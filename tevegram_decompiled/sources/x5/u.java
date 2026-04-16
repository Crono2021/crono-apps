package x5;

import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f10212i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f10213j;

    public /* synthetic */ u(TextInputLayout textInputLayout, int i9) {
        this.f10212i = i9;
        this.f10213j = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10212i) {
            case 0:
                CheckableImageButton checkableImageButton = this.f10213j.f2142k.f10141o;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                break;
            default:
                this.f10213j.f2144l.requestLayout();
                break;
        }
    }
}
