package it.educk.carrds;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
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
