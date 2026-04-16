package c0;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.u;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g extends Activity implements androidx.lifecycle.s, n0.k {

    /* renamed from: i, reason: collision with root package name */
    public u f1542i;

    @Override // n0.k
    public final boolean b(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !android.support.v4.media.session.b.D(decorView, keyEvent)) {
            return android.support.v4.media.session.b.E(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !android.support.v4.media.session.b.D(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i9 = f0.f912j;
        d0.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        u uVar = this.f1542i;
        uVar.getClass();
        uVar.c("markState");
        uVar.c("setCurrentState");
        uVar.e(androidx.lifecycle.m.f930k);
        super.onSaveInstanceState(bundle);
    }
}
