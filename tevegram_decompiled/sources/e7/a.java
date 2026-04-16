package e7;

import b8.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f3151a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3152b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3153c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3154d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3155e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3156f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3157g;
    public final long h;

    public /* synthetic */ a(String str, String str2, String str3, String str4, boolean z8, int i9, int i10) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? false : z8, (i10 & 32) != 0 ? 0 : i9, null, 0L);
    }

    public static a a(a aVar, String str, int i9, String str2, long j5, int i10) {
        if ((i10 & 1) != 0) {
            str = aVar.f3151a;
        }
        String str3 = str;
        String str4 = aVar.f3152b;
        String str5 = aVar.f3153c;
        String str6 = aVar.f3154d;
        boolean z8 = aVar.f3155e;
        if ((i10 & 32) != 0) {
            i9 = aVar.f3156f;
        }
        int i11 = i9;
        if ((i10 & 64) != 0) {
            str2 = aVar.f3157g;
        }
        String str7 = str2;
        long j9 = (i10 & 128) != 0 ? aVar.h : j5;
        aVar.getClass();
        str3.getClass();
        return new a(str3, str4, str5, str6, z8, i11, str7, j9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i.a(this.f3151a, aVar.f3151a) && i.a(this.f3152b, aVar.f3152b) && i.a(this.f3153c, aVar.f3153c) && i.a(this.f3154d, aVar.f3154d) && this.f3155e == aVar.f3155e && this.f3156f == aVar.f3156f && i.a(this.f3157g, aVar.f3157g) && this.h == aVar.h;
    }

    public final int hashCode() {
        int hashCode = this.f3151a.hashCode() * 31;
        String str = this.f3152b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f3153c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f3154d;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + (this.f3155e ? 1231 : 1237)) * 31) + this.f3156f) * 31;
        String str4 = this.f3157g;
        int hashCode5 = str4 != null ? str4.hashCode() : 0;
        long j5 = this.h;
        return ((hashCode4 + hashCode5) * 31) + ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        return "VideoItem(url=" + this.f3151a + ", title=" + this.f3152b + ", channel=" + this.f3153c + ", poster=" + this.f3154d + ", autoplay=" + this.f3155e + ", start=" + this.f3156f + ", error=" + this.f3157g + ", chatId=" + this.h + ")";
    }

    public a(String str, String str2, String str3, String str4, boolean z8, int i9, String str5, long j5) {
        this.f3151a = str;
        this.f3152b = str2;
        this.f3153c = str3;
        this.f3154d = str4;
        this.f3155e = z8;
        this.f3156f = i9;
        this.f3157g = str5;
        this.h = j5;
    }
}
