package z3;

import java.io.File;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f10631a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f10632b;

    /* renamed from: c, reason: collision with root package name */
    public final File[] f10633c;

    /* renamed from: d, reason: collision with root package name */
    public final File[] f10634d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10635e;

    /* renamed from: f, reason: collision with root package name */
    public b2.b f10636f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d f10637g;

    public c(d dVar, String str) {
        this.f10637g = dVar;
        this.f10631a = str;
        int i9 = dVar.f10644o;
        File file = dVar.f10638i;
        this.f10632b = new long[i9];
        this.f10633c = new File[i9];
        this.f10634d = new File[i9];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i10 = 0; i10 < i9; i10++) {
            sb.append(i10);
            this.f10633c[i10] = new File(file, sb.toString());
            sb.append(".tmp");
            this.f10634d[i10] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (long j5 : this.f10632b) {
            sb.append(' ');
            sb.append(j5);
        }
        return sb.toString();
    }
}
