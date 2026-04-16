package q1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g implements Comparable {

    /* renamed from: i, reason: collision with root package name */
    public final String f8341i;

    /* renamed from: j, reason: collision with root package name */
    public final f f8342j;

    /* renamed from: k, reason: collision with root package name */
    public final long f8343k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8344l;

    /* renamed from: m, reason: collision with root package name */
    public final long f8345m;

    /* renamed from: n, reason: collision with root package name */
    public final d1.n f8346n;

    /* renamed from: o, reason: collision with root package name */
    public final String f8347o;

    /* renamed from: p, reason: collision with root package name */
    public final String f8348p;

    /* renamed from: q, reason: collision with root package name */
    public final long f8349q;

    /* renamed from: r, reason: collision with root package name */
    public final long f8350r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f8351s;

    public g(String str, f fVar, long j5, int i9, long j9, d1.n nVar, String str2, String str3, long j10, long j11, boolean z8) {
        this.f8341i = str;
        this.f8342j = fVar;
        this.f8343k = j5;
        this.f8344l = i9;
        this.f8345m = j9;
        this.f8346n = nVar;
        this.f8347o = str2;
        this.f8348p = str3;
        this.f8349q = j10;
        this.f8350r = j11;
        this.f8351s = z8;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Long l4 = (Long) obj;
        long longValue = l4.longValue();
        long j5 = this.f8345m;
        if (j5 > longValue) {
            return 1;
        }
        return j5 < l4.longValue() ? -1 : 0;
    }
}
