package v;

import a0.l;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public b f9152d;

    /* renamed from: a, reason: collision with root package name */
    public i f9149a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f9150b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f9151c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f9153e = false;

    public c(l lVar) {
        this.f9152d = new a(this, lVar);
    }

    public final void a(e eVar, int i9) {
        this.f9152d.c(eVar.i(i9), 1.0f);
        this.f9152d.c(eVar.i(i9), -1.0f);
    }

    public final void b(i iVar, i iVar2, i iVar3, int i9) {
        boolean z8 = false;
        if (i9 != 0) {
            if (i9 < 0) {
                i9 *= -1;
                z8 = true;
            }
            this.f9150b = i9;
        }
        b bVar = this.f9152d;
        if (z8) {
            bVar.c(iVar, 1.0f);
            this.f9152d.c(iVar2, -1.0f);
            this.f9152d.c(iVar3, -1.0f);
        } else {
            bVar.c(iVar, -1.0f);
            this.f9152d.c(iVar2, 1.0f);
            this.f9152d.c(iVar3, 1.0f);
        }
    }

    public final void c(i iVar, i iVar2, i iVar3, int i9) {
        boolean z8 = false;
        if (i9 != 0) {
            if (i9 < 0) {
                i9 *= -1;
                z8 = true;
            }
            this.f9150b = i9;
        }
        b bVar = this.f9152d;
        if (z8) {
            bVar.c(iVar, 1.0f);
            this.f9152d.c(iVar2, -1.0f);
            this.f9152d.c(iVar3, 1.0f);
        } else {
            bVar.c(iVar, -1.0f);
            this.f9152d.c(iVar2, 1.0f);
            this.f9152d.c(iVar3, -1.0f);
        }
    }

    public i d(boolean[] zArr) {
        return e(zArr, null);
    }

    public final i e(boolean[] zArr, i iVar) {
        int i9;
        int d9 = this.f9152d.d();
        i iVar2 = null;
        float f9 = 0.0f;
        for (int i10 = 0; i10 < d9; i10++) {
            float a9 = this.f9152d.a(i10);
            if (a9 < 0.0f) {
                i h = this.f9152d.h(i10);
                if ((zArr == null || !zArr[h.f9175b]) && h != iVar && (((i9 = h.f9184l) == 3 || i9 == 4) && a9 < f9)) {
                    f9 = a9;
                    iVar2 = h;
                }
            }
        }
        return iVar2;
    }

    public final void f(i iVar) {
        i iVar2 = this.f9149a;
        if (iVar2 != null) {
            this.f9152d.c(iVar2, -1.0f);
            this.f9149a = null;
        }
        float e9 = this.f9152d.e(iVar, true) * (-1.0f);
        this.f9149a = iVar;
        if (e9 == 1.0f) {
            return;
        }
        this.f9150b /= e9;
        this.f9152d.j(e9);
    }

    public final void g(i iVar, boolean z8) {
        if (iVar.f9179f) {
            float g9 = this.f9152d.g(iVar);
            this.f9150b = (iVar.f9178e * g9) + this.f9150b;
            this.f9152d.e(iVar, z8);
            if (z8) {
                iVar.b(this);
            }
        }
    }

    public void h(c cVar, boolean z8) {
        float b9 = this.f9152d.b(cVar, z8);
        this.f9150b = (cVar.f9150b * b9) + this.f9150b;
        if (z8) {
            cVar.f9149a.b(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            v.i r0 = r10.f9149a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            v.i r1 = r10.f9149a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = r0.concat(r1)
            float r1 = r10.f9150b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f9150b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L3a
        L39:
            r1 = 0
        L3a:
            v.b r5 = r10.f9152d
            int r5 = r5.d()
        L40:
            if (r2 >= r5) goto Ld0
            v.b r6 = r10.f9152d
            v.i r6 = r6.h(r2)
            if (r6 != 0) goto L4c
            goto Lcc
        L4c:
            v.b r7 = r10.f9152d
            float r7 = r7.a(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L58
            goto Lcc
        L58:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L78
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L9e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L75:
            float r7 = r7 * r9
            goto L9e
        L78:
            if (r8 <= 0) goto L8c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L9e
        L8c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L75
        L9e:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto Lb4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto Lcb
        Lb4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        Lcb:
            r1 = 1
        Lcc:
            int r2 = r2 + 1
            goto L40
        Ld0:
            if (r1 != 0) goto Le3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        Le3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v.c.toString():java.lang.String");
    }
}
