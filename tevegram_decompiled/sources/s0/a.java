package s0;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import n.i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i3 f8658a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(i3 i3Var) {
        super(new Handler());
        this.f8658a = i3Var;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z8) {
        Cursor cursor;
        i3 i3Var = this.f8658a;
        if (!i3Var.f8660j || (cursor = i3Var.f8661k) == null || cursor.isClosed()) {
            return;
        }
        i3Var.f8659i = i3Var.f8661k.requery();
    }
}
