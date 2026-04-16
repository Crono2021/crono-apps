package u5;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f9065a;

    public a(float f9) {
        this.f9065a = f9;
    }

    @Override // u5.c
    public final float a(RectF rectF) {
        return this.f9065a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f9065a == ((a) obj).f9065a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f9065a)});
    }
}
