package s1;

import android.text.TextUtils;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f8758a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8759b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8760c;

    public v(String str, boolean z8, boolean z9) {
        this.f8758a = str;
        this.f8759b = z8;
        this.f8760c = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == v.class) {
            v vVar = (v) obj;
            if (TextUtils.equals(this.f8758a, vVar.f8758a) && this.f8759b == vVar.f8759b && this.f8760c == vVar.f8760c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((androidx.activity.g.k(31, 31, this.f8758a) + (this.f8759b ? 1231 : 1237)) * 31) + (this.f8760c ? 1231 : 1237);
    }
}
