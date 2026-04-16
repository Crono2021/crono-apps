package h7;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f4113a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4114b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4115c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4116d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4117e;

    /* renamed from: f, reason: collision with root package name */
    public final String f4118f;

    public i0(long j5, int i9, String str, int i10, String str2, String str3) {
        str.getClass();
        this.f4113a = j5;
        this.f4114b = i9;
        this.f4115c = str;
        this.f4116d = i10;
        this.f4117e = str2;
        this.f4118f = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.f4113a == i0Var.f4113a && this.f4114b == i0Var.f4114b && b8.i.a(this.f4115c, i0Var.f4115c) && this.f4116d == i0Var.f4116d && this.f4117e.equals(i0Var.f4117e) && b8.i.a(this.f4118f, i0Var.f4118f);
    }

    public final int hashCode() {
        long j5 = this.f4113a;
        int k3 = androidx.activity.g.k((androidx.activity.g.k(((((int) (j5 ^ (j5 >>> 32))) * 31) + this.f4114b) * 31, 31, this.f4115c) + this.f4116d) * 31, 31, this.f4117e);
        String str = this.f4118f;
        return k3 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ActiveLiveInfo(chatId=" + this.f4113a + ", groupCallId=" + this.f4114b + ", title=" + this.f4115c + ", participantCount=" + this.f4116d + ", chatTitle=" + this.f4117e + ", smallPhotoPath=" + this.f4118f + ")";
    }
}
