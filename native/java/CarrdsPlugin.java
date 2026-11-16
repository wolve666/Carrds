package it.educk.carrds;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import android.util.Base64;
import android.view.WindowManager;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* Ponte tra l'app e Android: luminosità dello schermo e widget */
@CapacitorPlugin(name = "Carrds")
public class CarrdsPlugin extends Plugin {

    /* value 1 = luminosità massima, -1 = torna a quella del telefono */
    @PluginMethod
    public void setBrightness(PluginCall call) {
        final float value = call.getFloat("value", -1f);
        getActivity().runOnUiThread(() -> {
            WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
            lp.screenBrightness = value < 0 ? WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE : Math.min(1f, value);
            getActivity().getWindow().setAttributes(lp);
            call.resolve();
        });
    }

    /* riceve fino a quattro mini tessere già disegnate (PNG in base64) e aggiorna i widget */
    @PluginMethod
    public void setWidgetCards(PluginCall call) {
        Context ctx = getContext();
        JSArray arr = call.getArray("cards");
        File dir = new File(ctx.getFilesDir(), "widget");
        if (!dir.exists()) dir.mkdirs();
        StringBuilder ids = new StringBuilder();
        int n = 0;
        try {
            for (int i = 0; arr != null && i < arr.length() && n < 4; i++) {
                JSONObject o = arr.getJSONObject(i);
                byte[] png = Base64.decode(o.getString("png"), Base64.DEFAULT);
                try (FileOutputStream out = new FileOutputStream(new File(dir, n + ".png"))) { out.write(png); }
                if (n > 0) ids.append(',');
                ids.append(o.getString("id").replace(",", ""));
                n++;
            }
        } catch (Exception e) {
            call.reject("Widget non aggiornato: " + e.getMessage());
            return;
        }
        for (int i = n; i < 4; i++) new File(dir, i + ".png").delete();
        ctx.getSharedPreferences(CarrdsWidget.PREFS, Context.MODE_PRIVATE).edit().putString("ids", ids.toString()).apply();
        CarrdsWidget.updateAll(ctx);
        call.resolve();
    }

    /* backup: apre il menu Condividi di Android con il file (WhatsApp, Drive, email...) */
    @PluginMethod
    public void shareFile(PluginCall call) {
        String name = call.getString("name", "carrds-backup.json");
        String data = call.getString("data", "");
        try {
            File dir = new File(getContext().getCacheDir(), "backup");
            if (!dir.exists()) dir.mkdirs();
            File f = new File(dir, name);
            try (FileOutputStream out = new FileOutputStream(f)) { out.write(data.getBytes(StandardCharsets.UTF_8)); }
            Uri uri = FileProvider.getUriForFile(getContext(), getContext().getPackageName() + ".fileprovider", f);
            Intent send = new Intent(Intent.ACTION_SEND);
            send.setType("application/json");
            send.putExtra(Intent.EXTRA_STREAM, uri);
            send.putExtra(Intent.EXTRA_SUBJECT, name);
            send.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Intent chooser = Intent.createChooser(send, "Condividi il backup di Carrds");
            chooser.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            getActivity().startActivity(chooser);
            call.resolve();
        } catch (Exception e) {
            call.reject("Condivisione non riuscita: " + e.getMessage());
        }
    }

    /* backup: salva il file nella cartella Download/Carrds del telefono */
    @PluginMethod
    public void saveDownload(PluginCall call) {
        String name = call.getString("name", "carrds-backup.json");
        String data = call.getString("data", "");
        if (Build.VERSION.SDK_INT < 29) { call.reject("Serve Android 10 o successivo"); return; }
        try {
            ContentValues cv = new ContentValues();
            cv.put(MediaStore.MediaColumns.DISPLAY_NAME, name);
            cv.put(MediaStore.MediaColumns.MIME_TYPE, "application/json");
            cv.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/Carrds");
            Uri uri = getContext().getContentResolver().insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, cv);
            if (uri == null) throw new Exception("cartella non disponibile");
            try (OutputStream out = getContext().getContentResolver().openOutputStream(uri)) { out.write(data.getBytes(StandardCharsets.UTF_8)); }
            JSObject r = new JSObject();
            r.put("path", "Download/Carrds/" + name);
            call.resolve(r);
        } catch (Exception e) {
            call.reject("Salvataggio non riuscito: " + e.getMessage());
        }
    }

    /* chiede ad Android di aggiungere il widget alla Home */
    @PluginMethod
    public void pinWidget(PluginCall call) {
        JSObject r = new JSObject();
        boolean ok = false;
        if (Build.VERSION.SDK_INT >= 26) {
            AppWidgetManager m = AppWidgetManager.getInstance(getContext());
            if (m.isRequestPinAppWidgetSupported()) {
                ok = m.requestPinAppWidget(new ComponentName(getContext(), CarrdsWidget.class), null, null);
            }
        }
        r.put("ok", ok);
        call.resolve(r);
    }
}
