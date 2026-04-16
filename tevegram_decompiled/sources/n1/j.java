package n1;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7272a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.i f7273b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f7274c;

    /* renamed from: d, reason: collision with root package name */
    public final h f7275d;

    /* renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.manager.p f7276e;

    /* renamed from: f, reason: collision with root package name */
    public final i f7277f;

    /* renamed from: g, reason: collision with root package name */
    public e f7278g;
    public k h;

    /* renamed from: i, reason: collision with root package name */
    public d1.g f7279i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7280j;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j(android.content.Context r3, a3.i r4, d1.g r5, n1.k r6) {
        /*
            r2 = this;
            r2.<init>()
            android.content.Context r3 = r3.getApplicationContext()
            r2.f7272a = r3
            r2.f7273b = r4
            r2.f7279i = r5
            r2.h = r6
            int r4 = g1.w.f3713a
            android.os.Looper r4 = android.os.Looper.myLooper()
            if (r4 == 0) goto L18
            goto L1c
        L18:
            android.os.Looper r4 = android.os.Looper.getMainLooper()
        L1c:
            android.os.Handler r5 = new android.os.Handler
            r6 = 0
            r5.<init>(r4, r6)
            r2.f7274c = r5
            int r4 = g1.w.f3713a
            r0 = 23
            if (r4 < r0) goto L30
            n1.h r0 = new n1.h
            r0.<init>(r2)
            goto L31
        L30:
            r0 = r6
        L31:
            r2.f7275d = r0
            r0 = 21
            if (r4 < r0) goto L3e
            com.bumptech.glide.manager.p r0 = new com.bumptech.glide.manager.p
            r1 = 3
            r0.<init>(r2, r1)
            goto L3f
        L3e:
            r0 = r6
        L3f:
            r2.f7276e = r0
            n1.e r0 = n1.e.f7247c
            r0 = 17
            if (r4 < r0) goto L60
            java.lang.String r4 = g1.w.f3715c
            java.lang.String r0 = "Amazon"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L59
            java.lang.String r0 = "Xiaomi"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L60
        L59:
            java.lang.String r4 = "external_surround_sound_enabled"
            android.net.Uri r4 = android.provider.Settings.Global.getUriFor(r4)
            goto L61
        L60:
            r4 = r6
        L61:
            if (r4 == 0) goto L6c
            n1.i r6 = new n1.i
            android.content.ContentResolver r3 = r3.getContentResolver()
            r6.<init>(r2, r5, r3, r4)
        L6c:
            r2.f7277f = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.j.<init>(android.content.Context, a3.i, d1.g, n1.k):void");
    }

    public final void a(e eVar) {
        y1.o oVar;
        if (!this.f7280j || eVar.equals(this.f7278g)) {
            return;
        }
        this.f7278g = eVar;
        p0 p0Var = (p0) this.f7273b.f118j;
        g1.a.k(p0Var.f7326f0 == Looper.myLooper());
        if (eVar.equals(p0Var.f7343v)) {
            return;
        }
        p0Var.f7343v = eVar;
        i7.x xVar = p0Var.f7338q;
        if (xVar != null) {
            switch (xVar.f5178i) {
                case 11:
                    return;
                default:
                    s0 s0Var = (s0) xVar.f5179j;
                    synchronized (s0Var.f5826i) {
                        oVar = s0Var.f5842y;
                    }
                    if (oVar != null) {
                        oVar.g();
                        return;
                    }
                    return;
            }
        }
    }

    public final void b(AudioDeviceInfo audioDeviceInfo) {
        k kVar = this.h;
        if (g1.w.a(audioDeviceInfo, kVar == null ? null : kVar.f7284a)) {
            return;
        }
        k kVar2 = audioDeviceInfo != null ? new k(audioDeviceInfo) : null;
        this.h = kVar2;
        a(e.c(this.f7272a, this.f7279i, kVar2));
    }
}
