package b2;

import android.view.Surface;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final i f1147a;

    /* renamed from: b, reason: collision with root package name */
    public final z f1148b;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f1149c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1150d;

    /* renamed from: e, reason: collision with root package name */
    public Surface f1151e;

    /* renamed from: f, reason: collision with root package name */
    public float f1152f;

    /* renamed from: g, reason: collision with root package name */
    public float f1153g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f1154i;

    /* renamed from: j, reason: collision with root package name */
    public int f1155j;

    /* renamed from: k, reason: collision with root package name */
    public long f1156k;

    /* renamed from: l, reason: collision with root package name */
    public long f1157l;

    /* renamed from: m, reason: collision with root package name */
    public long f1158m;

    /* renamed from: n, reason: collision with root package name */
    public long f1159n;

    /* renamed from: o, reason: collision with root package name */
    public long f1160o;

    /* renamed from: p, reason: collision with root package name */
    public long f1161p;

    /* renamed from: q, reason: collision with root package name */
    public long f1162q;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c0(android.content.Context r6) {
        /*
            r5 = this;
            r5.<init>()
            b2.i r0 = new b2.i
            r0.<init>()
            b2.h r1 = new b2.h
            r1.<init>()
            r0.f1203a = r1
            b2.h r1 = new b2.h
            r1.<init>()
            r0.f1204b = r1
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.f1206d = r1
            r5.f1147a = r0
            r0 = 0
            if (r6 == 0) goto L51
            android.content.Context r6 = r6.getApplicationContext()
            int r3 = g1.w.f3713a
            r4 = 17
            if (r3 < r4) goto L3c
            java.lang.String r3 = "display"
            java.lang.Object r3 = r6.getSystemService(r3)
            android.hardware.display.DisplayManager r3 = (android.hardware.display.DisplayManager) r3
            if (r3 == 0) goto L3c
            b2.a0 r4 = new b2.a0
            r4.<init>(r3)
            goto L3d
        L3c:
            r4 = r0
        L3d:
            if (r4 != 0) goto L52
            java.lang.String r3 = "window"
            java.lang.Object r6 = r6.getSystemService(r3)
            android.view.WindowManager r6 = (android.view.WindowManager) r6
            if (r6 == 0) goto L51
            a0.b r4 = new a0.b
            r3 = 10
            r4.<init>(r6, r3)
            goto L52
        L51:
            r4 = r0
        L52:
            r5.f1148b = r4
            if (r4 == 0) goto L58
            b2.b0 r0 = b2.b0.f1141m
        L58:
            r5.f1149c = r0
            r5.f1156k = r1
            r5.f1157l = r1
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5.f1152f = r6
            r6 = 1065353216(0x3f800000, float:1.0)
            r5.f1154i = r6
            r6 = 0
            r5.f1155j = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c0.<init>(android.content.Context):void");
    }

    public final void a() {
        Surface surface;
        if (g1.w.f3713a < 30 || (surface = this.f1151e) == null || this.f1155j == Integer.MIN_VALUE || this.h == 0.0f) {
            return;
        }
        this.h = 0.0f;
        y.a(surface, 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r9 = this;
            int r0 = g1.w.f3713a
            r1 = 30
            if (r0 < r1) goto L8e
            android.view.Surface r0 = r9.f1151e
            if (r0 != 0) goto Lc
            goto L8e
        Lc:
            b2.i r0 = r9.f1147a
            b2.h r2 = r0.f1203a
            boolean r2 = r2.a()
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == 0) goto L3a
            b2.h r2 = r0.f1203a
            boolean r2 = r2.a()
            if (r2 == 0) goto L37
            b2.h r2 = r0.f1203a
            long r4 = r2.f1196e
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L2b
            goto L2e
        L2b:
            long r6 = r2.f1197f
            long r6 = r6 / r4
        L2e:
            double r4 = (double) r6
            r6 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r6 = r6 / r4
            float r2 = (float) r6
            goto L3c
        L37:
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L3c
        L3a:
            float r2 = r9.f1152f
        L3c:
            float r4 = r9.f1153g
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 != 0) goto L43
            goto L8e
        L43:
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 == 0) goto L81
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 == 0) goto L81
            b2.h r1 = r0.f1203a
            boolean r1 = r1.a()
            if (r1 == 0) goto L72
            b2.h r1 = r0.f1203a
            boolean r1 = r1.a()
            if (r1 == 0) goto L60
            b2.h r0 = r0.f1203a
            long r0 = r0.f1197f
            goto L65
        L60:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L65:
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 < 0) goto L72
            r0 = 1017370378(0x3ca3d70a, float:0.02)
            goto L74
        L72:
            r0 = 1065353216(0x3f800000, float:1.0)
        L74:
            float r1 = r9.f1153g
            float r1 = r2 - r1
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L8e
            goto L88
        L81:
            if (r5 == 0) goto L84
            goto L88
        L84:
            int r0 = r0.f1207e
            if (r0 < r1) goto L8e
        L88:
            r9.f1153g = r2
            r0 = 0
            r9.c(r0)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c0.b():void");
    }

    public final void c(boolean z8) {
        Surface surface;
        float f9;
        if (g1.w.f3713a < 30 || (surface = this.f1151e) == null || this.f1155j == Integer.MIN_VALUE) {
            return;
        }
        if (this.f1150d) {
            float f10 = this.f1153g;
            if (f10 != -1.0f) {
                f9 = f10 * this.f1154i;
                if (z8 && this.h == f9) {
                    return;
                }
                this.h = f9;
                y.a(surface, f9);
            }
        }
        f9 = 0.0f;
        if (z8) {
        }
        this.h = f9;
        y.a(surface, f9);
    }
}
