package j3;

import g1.p;
import java.util.LinkedHashMap;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class e implements w2.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5414a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f5415b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5416c;

    /* renamed from: d, reason: collision with root package name */
    public int f5417d;

    /* renamed from: e, reason: collision with root package name */
    public int f5418e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f5419f;

    public e(w2.b bVar) {
        p pVar = bVar.f9714k;
        this.f5419f = pVar;
        pVar.F(12);
        this.f5416c = pVar.x() & 255;
        this.f5415b = pVar.x();
    }

    private final synchronized String f() {
        int i9;
        int i10;
        int i11;
        try {
            i9 = this.f5417d;
            i10 = this.f5418e;
            int i12 = i9 + i10;
            i11 = i12 != 0 ? (i9 * 100) / i12 : 0;
            Locale locale = Locale.US;
        } catch (Throwable th) {
            throw th;
        }
        return "LruCache[maxSize=" + this.f5416c + ",hits=" + i9 + ",misses=" + i10 + ",hitRate=" + i11 + "%]";
    }

    @Override // w2.d
    public int a() {
        return -1;
    }

    @Override // w2.d
    public int b() {
        return this.f5415b;
    }

    @Override // w2.d
    public int c() {
        p pVar = (p) this.f5419f;
        int i9 = this.f5416c;
        if (i9 == 8) {
            return pVar.t();
        }
        if (i9 == 16) {
            return pVar.z();
        }
        int i10 = this.f5417d;
        this.f5417d = i10 + 1;
        if (i10 % 2 != 0) {
            return this.f5418e & 15;
        }
        int t8 = pVar.t();
        this.f5418e = t8;
        return (t8 & 240) >> 4;
    }

    public Object d(Object obj) {
        synchronized (this) {
            try {
                Object obj2 = ((LinkedHashMap) this.f5419f).get(obj);
                if (obj2 != null) {
                    this.f5417d++;
                    return obj2;
                }
                this.f5418e++;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object e(Object obj, Object obj2) {
        Object put;
        synchronized (this) {
            try {
                this.f5415b++;
                put = ((LinkedHashMap) this.f5419f).put(obj, obj2);
                if (put != null) {
                    this.f5415b--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g(this.f5416c);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r3) {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            int r0 = r2.f5415b     // Catch: java.lang.Throwable -> L14
            if (r0 < 0) goto L4f
            java.lang.Object r0 = r2.f5419f     // Catch: java.lang.Throwable -> L14
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0     // Catch: java.lang.Throwable -> L14
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L16
            int r0 = r2.f5415b     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L4f
            goto L16
        L14:
            r3 = move-exception
            goto L6e
        L16:
            int r0 = r2.f5415b     // Catch: java.lang.Throwable -> L14
            if (r0 <= r3) goto L4d
            java.lang.Object r0 = r2.f5419f     // Catch: java.lang.Throwable -> L14
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0     // Catch: java.lang.Throwable -> L14
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L25
            goto L4d
        L25:
            java.lang.Object r0 = r2.f5419f     // Catch: java.lang.Throwable -> L14
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0     // Catch: java.lang.Throwable -> L14
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L14
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L14
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L14
            r0.getValue()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r0 = r2.f5419f     // Catch: java.lang.Throwable -> L14
            java.util.LinkedHashMap r0 = (java.util.LinkedHashMap) r0     // Catch: java.lang.Throwable -> L14
            r0.remove(r1)     // Catch: java.lang.Throwable -> L14
            int r0 = r2.f5415b     // Catch: java.lang.Throwable -> L14
            int r0 = r0 + (-1)
            r2.f5415b = r0     // Catch: java.lang.Throwable -> L14
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            goto L0
        L4d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            return
        L4f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L14
            r0.<init>()     // Catch: java.lang.Throwable -> L14
            java.lang.Class r1 = r2.getClass()     // Catch: java.lang.Throwable -> L14
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L14
            r0.append(r1)     // Catch: java.lang.Throwable -> L14
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L14
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L14
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L14
            throw r3     // Catch: java.lang.Throwable -> L14
        L6e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.e.g(int):void");
    }

    public synchronized String toString() {
        switch (this.f5414a) {
            case 1:
                return f();
            default:
                return super.toString();
        }
    }

    public e(int i9, int i10, int i11, int i12, int i13, byte[] bArr) {
        this.f5415b = i10;
        this.f5416c = i11;
        this.f5417d = i12;
        this.f5418e = i13;
        this.f5419f = bArr;
    }

    public e(int i9) {
        if (i9 > 0) {
            this.f5416c = i9;
            this.f5419f = new LinkedHashMap(0, 0.75f, true);
        } else {
            m7.c.n("maxSize <= 0");
            throw null;
        }
    }
}
