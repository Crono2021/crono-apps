package x0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final KeyListener f10030a;

    public e(KeyListener keyListener) {
        this.f10030a = keyListener;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i9) {
        this.f10030a.clearMetaKeyState(view, editable, i9);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f10030a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i9, KeyEvent keyEvent) {
        boolean z8;
        if (i9 != 67 ? i9 != 112 ? false : a5.d.p0(editable, keyEvent, true) : a5.d.p0(editable, keyEvent, false)) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z8 = true;
        } else {
            z8 = false;
        }
        return z8 || this.f10030a.onKeyDown(view, editable, i9, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f10030a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i9, KeyEvent keyEvent) {
        return this.f10030a.onKeyUp(view, editable, i9, keyEvent);
    }
}
