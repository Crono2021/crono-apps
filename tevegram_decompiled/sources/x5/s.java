package x5;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s extends m {

    /* renamed from: e, reason: collision with root package name */
    public final int f10199e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f10200f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.material.datepicker.n f10201g;

    public s(l lVar, int i9) {
        super(lVar);
        this.f10199e = 2131230867;
        this.f10201g = new com.google.android.material.datepicker.n(this, 11);
        if (i9 != 0) {
            this.f10199e = i9;
        }
    }

    @Override // x5.m
    public final void b() {
        p();
    }

    @Override // x5.m
    public final int c() {
        return 2131951829;
    }

    @Override // x5.m
    public final int d() {
        return this.f10199e;
    }

    @Override // x5.m
    public final View.OnClickListener f() {
        return this.f10201g;
    }

    @Override // x5.m
    public final boolean j() {
        return true;
    }

    @Override // x5.m
    public final boolean k() {
        EditText editText = this.f10200f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // x5.m
    public final void l(EditText editText) {
        this.f10200f = editText;
        p();
    }

    @Override // x5.m
    public final void q() {
        EditText editText = this.f10200f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f10200f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // x5.m
    public final void r() {
        EditText editText = this.f10200f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
