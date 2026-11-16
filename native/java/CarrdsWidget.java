package it.educk.carrds;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.RemoteViews;
import java.io.File;

/* Widget della Home: quattro mini tessere, ognuna apre Carrds sul suo codice */
public class CarrdsWidget extends AppWidgetProvider {
    static final String PREFS = "carrds_widget";
    static final int[] SLOTS = { R.id.w0, R.id.w1, R.id.w2, R.id.w3 };

    @Override
    public void onUpdate(Context ctx, AppWidgetManager m, int[] ids) {
        for (int id : ids) m.updateAppWidget(id, build(ctx));
    }

    static void updateAll(Context ctx) {
        AppWidgetManager m = AppWidgetManager.getInstance(ctx);
        int[] ids = m.getAppWidgetIds(new ComponentName(ctx, CarrdsWidget.class));
        for (int id : ids) m.updateAppWidget(id, build(ctx));
    }

    static RemoteViews build(Context ctx) {
        RemoteViews v = new RemoteViews(ctx.getPackageName(), R.layout.carrds_widget);
        String[] ids = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getString("ids", "").split(",");
        int flags = PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE;
        int shown = 0;
        for (int i = 0; i < SLOTS.length; i++) {
            String id = i < ids.length ? ids[i] : "";
            File f = new File(ctx.getFilesDir(), "widget/" + i + ".png");
            Bitmap b = (!id.isEmpty() && f.exists()) ? BitmapFactory.decodeFile(f.getAbsolutePath()) : null;
            if (b == null) { v.setViewVisibility(SLOTS[i], View.INVISIBLE); continue; }
            v.setImageViewBitmap(SLOTS[i], b);
            v.setViewVisibility(SLOTS[i], View.VISIBLE);
            Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("carrds://card/" + Uri.encode(id)), ctx, MainActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            v.setOnClickPendingIntent(SLOTS[i], PendingIntent.getActivity(ctx, 100 + i, it, flags));
            shown++;
        }
        v.setViewVisibility(R.id.wgrid, shown > 0 ? View.VISIBLE : View.GONE);
        v.setViewVisibility(R.id.wempty, shown > 0 ? View.GONE : View.VISIBLE);
        Intent open = new Intent(ctx, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent po = PendingIntent.getActivity(ctx, 99, open, flags);
        v.setOnClickPendingIntent(R.id.whead, po);
        v.setOnClickPendingIntent(R.id.wempty, po);
        return v;
    }
}
