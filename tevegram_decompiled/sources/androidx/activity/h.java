package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f287i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f288j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f289k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f290l;

    public h(BottomSheetBehavior bottomSheetBehavior, View view, int i9) {
        this.f287i = 3;
        this.f289k = bottomSheetBehavior;
        this.f290l = view;
        this.f288j = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f287i) {
            case 0:
                i iVar = (i) this.f289k;
                Object obj = ((d.a) this.f290l).f2343a;
                String str = (String) iVar.f334a.get(Integer.valueOf(this.f288j));
                if (str != null) {
                    androidx.activity.result.e eVar = (androidx.activity.result.e) iVar.f338e.get(str);
                    if (eVar != null) {
                        androidx.activity.result.b bVar = eVar.f330a;
                        if (iVar.f337d.remove(str)) {
                            bVar.b(obj);
                            break;
                        }
                    } else {
                        iVar.f340g.remove(str);
                        iVar.f339f.put(str, obj);
                        break;
                    }
                }
                break;
            case 1:
                ((i) this.f289k).a(this.f288j, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f290l));
                break;
            case 2:
                String[] strArr = (String[]) this.f290l;
                int[] iArr = new int[strArr.length];
                g.l lVar = (g.l) this.f289k;
                PackageManager packageManager = lVar.getPackageManager();
                String packageName = lVar.getPackageName();
                int length = strArr.length;
                for (int i9 = 0; i9 < length; i9++) {
                    iArr[i9] = packageManager.checkPermission(strArr[i9], packageName);
                }
                lVar.onRequestPermissionsResult(this.f288j, strArr, iArr);
                break;
            case 3:
                ((BottomSheetBehavior) this.f289k).F((View) this.f290l, this.f288j, false);
                break;
            default:
                ((TextView) this.f290l).setTypeface((Typeface) this.f289k, this.f288j);
                break;
        }
    }

    public /* synthetic */ h(i iVar, int i9, Object obj, int i10) {
        this.f287i = i10;
        this.f289k = iVar;
        this.f288j = i9;
        this.f290l = obj;
    }

    public /* synthetic */ h(int i9, int i10, Object obj, Object obj2) {
        this.f287i = i10;
        this.f290l = obj;
        this.f289k = obj2;
        this.f288j = i9;
    }
}
