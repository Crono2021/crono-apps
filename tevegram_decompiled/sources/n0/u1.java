package n0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class u1 extends t1 {
    public u1(a2 a2Var, WindowInsets windowInsets) {
        super(a2Var, windowInsets);
    }

    @Override // n0.x1
    public a2 a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f7204c.consumeDisplayCutout();
        return a2.g(null, consumeDisplayCutout);
    }

    @Override // n0.x1
    public i e() {
        DisplayCutout displayCutout;
        displayCutout = this.f7204c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new i(displayCutout);
    }

    @Override // n0.s1, n0.x1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u1)) {
            return false;
        }
        u1 u1Var = (u1) obj;
        return Objects.equals(this.f7204c, u1Var.f7204c) && Objects.equals(this.f7208g, u1Var.f7208g);
    }

    @Override // n0.x1
    public int hashCode() {
        return this.f7204c.hashCode();
    }
}
