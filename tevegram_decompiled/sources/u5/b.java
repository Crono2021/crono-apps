package u5;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f9066a;

    /* renamed from: b, reason: collision with root package name */
    public final float f9067b;

    public b(float f9, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f9066a;
            f9 += ((b) cVar).f9067b;
        }
        this.f9066a = cVar;
        this.f9067b = f9;
    }

    @Override // u5.c
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f9066a.a(rectF) + this.f9067b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f9066a.equals(bVar.f9066a) && this.f9067b == bVar.f9067b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9066a, Float.valueOf(this.f9067b)});
    }
}
