package n;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l3 extends androidx.emoji2.text.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6960a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f6961b;

    public l3(EditText editText) {
        this.f6961b = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.i
    public void a() {
        switch (this.f6960a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f6961b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    break;
                }
                break;
        }
    }

    @Override // androidx.emoji2.text.i
    public final void b() {
        switch (this.f6960a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f6961b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    break;
                }
                break;
            default:
                x0.h.a((EditText) this.f6961b.get(), 1);
                break;
        }
    }

    public l3(SwitchCompat switchCompat) {
        this.f6961b = new WeakReference(switchCompat);
    }
}
