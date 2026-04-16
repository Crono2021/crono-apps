package y1;

import b6.u0;
import b6.y;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends m {
    public final int A;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f10459m;

    /* renamed from: n, reason: collision with root package name */
    public final i f10460n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f10461o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f10462p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f10463q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10464r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10465s;

    /* renamed from: t, reason: collision with root package name */
    public final int f10466t;

    /* renamed from: u, reason: collision with root package name */
    public final int f10467u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f10468v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f10469w;

    /* renamed from: x, reason: collision with root package name */
    public final int f10470x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f10471y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f10472z;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00d5 A[EDGE_INSN: B:125:0x00d5->B:67:0x00d5 BREAK  A[LOOP:0: B:59:0x00ba->B:123:0x00d2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n(int r6, d1.z0 r7, int r8, y1.i r9, int r10, int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.n.<init>(int, d1.z0, int, y1.i, int, int, boolean):void");
    }

    public static int c(n nVar, n nVar2) {
        y b9 = y.f1469a.c(nVar.f10462p, nVar2.f10462p).a(nVar.f10467u, nVar2.f10467u).c(nVar.f10468v, nVar2.f10468v).c(nVar.f10463q, nVar2.f10463q).c(nVar.f10459m, nVar2.f10459m).c(nVar.f10461o, nVar2.f10461o).b(Integer.valueOf(nVar.f10466t), Integer.valueOf(nVar2.f10466t), u0.f1461k);
        boolean z8 = nVar.f10471y;
        y c9 = b9.c(z8, nVar2.f10471y);
        boolean z9 = nVar.f10472z;
        y c10 = c9.c(z9, nVar2.f10472z);
        if (z8 && z9) {
            c10 = c10.a(nVar.A, nVar2.A);
        }
        return c10.e();
    }

    @Override // y1.m
    public final int a() {
        return this.f10470x;
    }

    @Override // y1.m
    public final boolean b(m mVar) {
        n nVar = (n) mVar;
        if (!this.f10469w && !w.a(this.f10458l.f2554m, nVar.f10458l.f2554m)) {
            return false;
        }
        this.f10460n.getClass();
        return this.f10471y == nVar.f10471y && this.f10472z == nVar.f10472z;
    }
}
