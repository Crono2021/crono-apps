package i1;

import android.net.Uri;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s extends c {

    /* renamed from: m, reason: collision with root package name */
    public RandomAccessFile f4359m;

    /* renamed from: n, reason: collision with root package name */
    public Uri f4360n;

    /* renamed from: o, reason: collision with root package name */
    public long f4361o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4362p;

    @Override // i1.h
    public final void close() {
        this.f4360n = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f4359m;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e9) {
                throw new r(e9, 2000);
            }
        } finally {
            this.f4359m = null;
            if (this.f4362p) {
                this.f4362p = false;
                l();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        if (r1 != false) goto L39;
     */
    @Override // i1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long f(i1.k r9) {
        /*
            r8 = this;
            android.net.Uri r0 = r9.f4324a
            long r1 = r9.f4328e
            r8.f4360n = r0
            r8.q()
            r3 = 2000(0x7d0, float:2.803E-42)
            r4 = 2006(0x7d6, float:2.811E-42)
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.lang.RuntimeException -> L52 java.lang.SecurityException -> L54 java.io.FileNotFoundException -> L56
            java.lang.String r6 = r0.getPath()     // Catch: java.lang.RuntimeException -> L52 java.lang.SecurityException -> L54 java.io.FileNotFoundException -> L56
            r6.getClass()     // Catch: java.lang.RuntimeException -> L52 java.lang.SecurityException -> L54 java.io.FileNotFoundException -> L56
            java.lang.String r7 = "r"
            r5.<init>(r6, r7)     // Catch: java.lang.RuntimeException -> L52 java.lang.SecurityException -> L54 java.io.FileNotFoundException -> L56
            r8.f4359m = r5
            r5.seek(r1)     // Catch: java.io.IOException -> L30
            long r4 = r9.f4329f     // Catch: java.io.IOException -> L30
            r6 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L32
            java.io.RandomAccessFile r0 = r8.f4359m     // Catch: java.io.IOException -> L30
            long r4 = r0.length()     // Catch: java.io.IOException -> L30
            long r4 = r4 - r1
            goto L32
        L30:
            r9 = move-exception
            goto L4c
        L32:
            r8.f4361o = r4     // Catch: java.io.IOException -> L30
            r0 = 0
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 < 0) goto L43
            r0 = 1
            r8.f4362p = r0
            r8.r(r9)
            long r0 = r8.f4361o
            return r0
        L43:
            i1.r r9 = new i1.r
            r0 = 2008(0x7d8, float:2.814E-42)
            r1 = 0
            r9.<init>(r1, r1, r0)
            throw r9
        L4c:
            i1.r r0 = new i1.r
            r0.<init>(r9, r3)
            throw r0
        L52:
            r9 = move-exception
            goto L58
        L54:
            r9 = move-exception
            goto L5e
        L56:
            r9 = move-exception
            goto L64
        L58:
            i1.r r0 = new i1.r
            r0.<init>(r9, r3)
            throw r0
        L5e:
            i1.r r0 = new i1.r
            r0.<init>(r9, r4)
            throw r0
        L64:
            java.lang.String r1 = r0.getQuery()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L91
            java.lang.String r1 = r0.getFragment()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L91
            i1.r r0 = new i1.r
            int r1 = g1.w.f3713a
            r2 = 21
            if (r1 < r2) goto L8b
            java.lang.Throwable r1 = r9.getCause()
            boolean r1 = i1.q.a(r1)
            if (r1 == 0) goto L8b
            goto L8d
        L8b:
            r4 = 2005(0x7d5, float:2.81E-42)
        L8d:
            r0.<init>(r9, r4)
            throw r0
        L91:
            i1.r r1 = new i1.r
            java.lang.String r2 = r0.getPath()
            java.lang.String r3 = r0.getQuery()
            java.lang.String r0 = r0.getFragment()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path="
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r2 = ",query="
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = ",fragment="
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2 = 1004(0x3ec, float:1.407E-42)
            r1.<init>(r0, r9, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.s.f(i1.k):long");
    }

    @Override // i1.h
    public final Uri m() {
        return this.f4360n;
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        long j5 = this.f4361o;
        if (j5 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f4359m;
            int i11 = g1.w.f3713a;
            int read = randomAccessFile.read(bArr, i9, (int) Math.min(j5, i10));
            if (read > 0) {
                this.f4361o -= read;
                c(read);
            }
            return read;
        } catch (IOException e9) {
            throw new r(e9, 2000);
        }
    }
}
