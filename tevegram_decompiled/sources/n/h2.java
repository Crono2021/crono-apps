package n;

import android.database.DataSetObserver;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h2 extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6882a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6883b;

    public /* synthetic */ h2(Object obj, int i9) {
        this.f6882a = i9;
        this.f6883b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f6882a) {
            case 0:
                k2 k2Var = (k2) this.f6883b;
                if (k2Var.H.isShowing()) {
                    k2Var.c();
                    break;
                }
                break;
            default:
                i3 i3Var = (i3) this.f6883b;
                i3Var.f8659i = true;
                i3Var.notifyDataSetChanged();
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f6882a) {
            case 0:
                ((k2) this.f6883b).dismiss();
                break;
            default:
                i3 i3Var = (i3) this.f6883b;
                i3Var.f8659i = false;
                i3Var.notifyDataSetInvalidated();
                break;
        }
    }
}
