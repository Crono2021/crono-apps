package n;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f0 {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        n0.d dVar;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                dVar = new i7.x(clipData, 3);
            } else {
                n0.e eVar = new n0.e();
                eVar.f7148j = clipData;
                eVar.f7149k = 3;
                dVar = eVar;
            }
            n0.t0.l(textView, dVar.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        n0.d dVar;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            dVar = new i7.x(clipData, 3);
        } else {
            n0.e eVar = new n0.e();
            eVar.f7148j = clipData;
            eVar.f7149k = 3;
            dVar = eVar;
        }
        n0.t0.l(view, dVar.build());
        return true;
    }
}
