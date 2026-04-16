package w2;

import d2.e0;
import d2.y;
import g1.w;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements d2.m, y {

    /* renamed from: a, reason: collision with root package name */
    public final z2.c f9775a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9776b;

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f9777c;

    /* renamed from: d, reason: collision with root package name */
    public final g1.p f9778d;

    /* renamed from: e, reason: collision with root package name */
    public final g1.p f9779e;

    /* renamed from: f, reason: collision with root package name */
    public final g1.p f9780f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f9781g;
    public final o h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f9782i;

    /* renamed from: j, reason: collision with root package name */
    public int f9783j;

    /* renamed from: k, reason: collision with root package name */
    public int f9784k;

    /* renamed from: l, reason: collision with root package name */
    public long f9785l;

    /* renamed from: m, reason: collision with root package name */
    public int f9786m;

    /* renamed from: n, reason: collision with root package name */
    public g1.p f9787n;

    /* renamed from: o, reason: collision with root package name */
    public int f9788o;

    /* renamed from: p, reason: collision with root package name */
    public int f9789p;

    /* renamed from: q, reason: collision with root package name */
    public int f9790q;

    /* renamed from: r, reason: collision with root package name */
    public int f9791r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9792s;

    /* renamed from: t, reason: collision with root package name */
    public d2.o f9793t;

    /* renamed from: u, reason: collision with root package name */
    public l[] f9794u;

    /* renamed from: v, reason: collision with root package name */
    public long[][] f9795v;

    /* renamed from: w, reason: collision with root package name */
    public int f9796w;

    /* renamed from: x, reason: collision with root package name */
    public long f9797x;

    /* renamed from: y, reason: collision with root package name */
    public int f9798y;

    /* renamed from: z, reason: collision with root package name */
    public r2.a f9799z;

    public m(int i9, z2.c cVar) {
        this.f9775a = cVar;
        this.f9776b = i9;
        this.f9783j = (i9 & 4) != 0 ? 3 : 0;
        this.h = new o();
        this.f9782i = new ArrayList();
        this.f9780f = new g1.p(16);
        this.f9781g = new ArrayDeque();
        this.f9777c = new g1.p(h1.g.f3891a);
        this.f9778d = new g1.p(4);
        this.f9779e = new g1.p();
        this.f9788o = -1;
        this.f9793t = d2.o.f2714b;
        this.f9794u = new l[0];
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        this.f9781g.clear();
        this.f9786m = 0;
        this.f9788o = -1;
        this.f9789p = 0;
        this.f9790q = 0;
        this.f9791r = 0;
        if (j5 == 0) {
            if (this.f9783j != 3) {
                this.f9783j = 0;
                this.f9786m = 0;
                return;
            } else {
                o oVar = this.h;
                ((ArrayList) oVar.f9806c).clear();
                oVar.f9804a = 0;
                this.f9782i.clear();
                return;
            }
        }
        for (l lVar : this.f9794u) {
            s sVar = lVar.f9771b;
            int c9 = w.c(j9, sVar.f9843f, false);
            while (true) {
                if (c9 < 0) {
                    c9 = -1;
                    break;
                } else if ((sVar.f9844g[c9] & 1) != 0) {
                    break;
                } else {
                    c9--;
                }
            }
            if (c9 == -1) {
                c9 = sVar.a(j9);
            }
            lVar.f9774e = c9;
            e0 e0Var = lVar.f9773d;
            if (e0Var != null) {
                e0Var.f2683b = false;
                e0Var.f2684c = 0;
            }
        }
    }

    @Override // d2.m
    public final void d(d2.o oVar) {
        if ((this.f9776b & 16) == 0) {
            oVar = new x.c(oVar, this.f9775a);
        }
        this.f9793t = oVar;
    }

    @Override // d2.y
    public final boolean e() {
        return true;
    }

    @Override // d2.m
    public final boolean g(d2.n nVar) {
        return j.h(nVar, false, (this.f9776b & 2) != 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x02e2, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x02e0, code lost:
    
        if (r8 == (-1)) goto L148;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(d2.n r41, d1.w r42) {
        /*
            Method dump skipped, instructions count: 1720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.m.h(d2.n, d1.w):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4 A[EDGE_INSN: B:70:0x00e4->B:71:0x00e4 BREAK  A[LOOP:1: B:29:0x006b->B:58:0x00e0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f8  */
    @Override // d2.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d2.x i(long r21) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.m.i(long):d2.x");
    }

    @Override // d2.y
    public final long k() {
        return this.f9797x;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01c0, code lost:
    
        r9 = null;
        r10 = null;
        r0 = -1;
        r4 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01c4, code lost:
    
        r15 = r7.f3700b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01c6, code lost:
    
        if (r15 >= r8) goto L389;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01c8, code lost:
    
        r28 = r7.g();
        r14 = r7.g();
        r31 = r4;
        r7.G(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01d9, code lost:
    
        if (r14 != 1835360622) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01db, code lost:
    
        r9 = r7.p(r28 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01e1, code lost:
    
        r4 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01e7, code lost:
    
        if (r14 != 1851878757) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01e9, code lost:
    
        r10 = r7.p(r28 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01f3, code lost:
    
        if (r14 != 1684108385) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01f5, code lost:
    
        r0 = r15;
        r4 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01fb, code lost:
    
        r7.G(r28 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01f9, code lost:
    
        r4 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0202, code lost:
    
        r31 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0204, code lost:
    
        if (r9 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0206, code lost:
    
        if (r10 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0209, code lost:
    
        if (r0 != (-1)) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x020c, code lost:
    
        r7.F(r0);
        r7.G(16);
        r4 = new q2.j(r9, r10, r7.p(r31 - 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0221, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02ce, code lost:
    
        g1.a.o("MetadataUtil", "Skipped unknown metadata entry: ".concat(g5.c.b(r15)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02d9, code lost:
    
        r7.F(r8);
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00c9, code lost:
    
        r9 = w2.j.g(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00cd, code lost:
    
        if (r9 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x00cf, code lost:
    
        r10 = w2.j.f9767a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00d3, code lost:
    
        if (r9 > 192) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00d5, code lost:
    
        r9 = r10[r9 - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00db, code lost:
    
        if (r9 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00dd, code lost:
    
        r4 = new q2.m("TCON", null, b6.g0.q(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00e8, code lost:
    
        g1.a.D("MetadataUtil", "Failed to parse standard genre code");
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00ee, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x00da, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0101, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02fe, code lost:
    
        r7.F(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0301, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0224, code lost:
    
        r9 = 16777215 & r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x022b, code lost:
    
        if (r9 != 6516084) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x022d, code lost:
    
        r0 = r7.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0238, code lost:
    
        if (r7.g() != 1684108385) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x023a, code lost:
    
        r7.G(8);
        r0 = r7.p(r0 - 16);
        r4 = new q2.e("und", r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0250, code lost:
    
        g1.a.D("MetadataUtil", "Failed to parse comment attribute: ".concat(g5.c.b(r15)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0261, code lost:
    
        if (r9 == 7233901) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0266, code lost:
    
        if (r9 != 7631467) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x026d, code lost:
    
        if (r9 == 6516589) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0272, code lost:
    
        if (r9 != 7828084) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0278, code lost:
    
        if (r9 != 6578553) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x027a, code lost:
    
        r4 = w2.j.e(r15, r7, "TDRC");
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0285, code lost:
    
        if (r9 != 4280916) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0287, code lost:
    
        r4 = w2.j.e(r15, r7, "TPE1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0292, code lost:
    
        if (r9 != 7630703) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0294, code lost:
    
        r4 = w2.j.e(r15, r7, "TSSE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x029f, code lost:
    
        if (r9 != 6384738) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02a1, code lost:
    
        r4 = w2.j.e(r15, r7, "TALB");
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02ac, code lost:
    
        if (r9 != 7108978) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02ae, code lost:
    
        r4 = w2.j.e(r15, r7, "USLT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02b9, code lost:
    
        if (r9 != 6776174) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02bb, code lost:
    
        r4 = w2.j.e(r15, r7, "TCON");
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x02c4, code lost:
    
        if (r9 != 6779504) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x02c6, code lost:
    
        r4 = w2.j.e(r15, r7, "TIT1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x02de, code lost:
    
        r4 = w2.j.e(r15, r7, "TCOM");
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x02e6, code lost:
    
        r4 = w2.j.e(r15, r7, "TIT2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0302, code lost:
    
        r29 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0308, code lost:
    
        if (r3.isEmpty() == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x030c, code lost:
    
        r0 = new d1.j0(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
    
        r7.F(r4);
        r4 = r4 + r10;
        r7.G(r9);
        r3 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
    
        r8 = r7.f3700b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a0, code lost:
    
        if (r8 >= r4) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a2, code lost:
    
        r8 = r7.g() + r8;
        r15 = r7.g();
        r9 = (r15 >> 24) & 255;
        r29 = r0;
        r30 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
    
        if (r9 == 169) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c0, code lost:
    
        if (r9 != 253) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c7, code lost:
    
        if (r15 != 1735291493) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f8, code lost:
    
        if (r15 != 1684632427) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fa, code lost:
    
        r4 = w2.j.c(r15, r7, "TPOS");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x02ee, code lost:
    
        if (r4 == null) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x02f0, code lost:
    
        r3.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x02f3, code lost:
    
        r0 = r29;
        r4 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0107, code lost:
    
        if (r15 != 1953655662) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0109, code lost:
    
        r4 = w2.j.c(r15, r7, "TRCK");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0113, code lost:
    
        if (r15 != 1953329263) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0115, code lost:
    
        r0 = w2.j.f(r15, "TBPM", r7, true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011d, code lost:
    
        r7.F(r8);
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0126, code lost:
    
        if (r15 != 1668311404) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0128, code lost:
    
        r0 = w2.j.f(r15, "TCMP", r7, true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0133, code lost:
    
        if (r15 != 1668249202) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0135, code lost:
    
        r4 = w2.j.b(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013d, code lost:
    
        if (r15 != 1631670868) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x013f, code lost:
    
        r4 = w2.j.e(r15, r7, "TPE2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0149, code lost:
    
        if (r15 != 1936682605) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x014b, code lost:
    
        r4 = w2.j.e(r15, r7, "TSOT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0155, code lost:
    
        if (r15 != 1936679276) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0157, code lost:
    
        r4 = w2.j.e(r15, r7, "TSO2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0161, code lost:
    
        if (r15 != 1936679282) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0163, code lost:
    
        r4 = w2.j.e(r15, r7, "TSOA");
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x016d, code lost:
    
        if (r15 != 1936679265) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x016f, code lost:
    
        r4 = w2.j.e(r15, r7, "TSOP");
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x017a, code lost:
    
        if (r15 != 1936679791) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x017c, code lost:
    
        r4 = w2.j.e(r15, r7, "TSOC");
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0187, code lost:
    
        if (r15 != 1920233063) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0189, code lost:
    
        r4 = w2.j.f(r15, "ITUNESADVISORY", r7, false, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0195, code lost:
    
        if (r15 != 1885823344) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0197, code lost:
    
        r0 = w2.j.f(r15, "ITUNESGAPLESS", r7, false, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a4, code lost:
    
        if (r15 != 1936683886) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01a6, code lost:
    
        r4 = w2.j.e(r15, r7, "TVSHOWSORT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b1, code lost:
    
        if (r15 != 1953919848) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b3, code lost:
    
        r4 = w2.j.e(r15, r7, "TVSHOW");
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01be, code lost:
    
        if (r15 != 757935405) goto L160;
     */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x06a2 A[EDGE_INSN: B:371:0x06a2->B:372:0x06a2 BREAK  A[LOOP:10: B:299:0x0575->B:305:0x0696], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x06c2 A[LOOP:13: B:373:0x06bf->B:375:0x06c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:380:0x06df  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x055b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(long r33) {
        /*
            Method dump skipped, instructions count: 1875
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.m.l(long):void");
    }

    @Override // d2.m
    public final d2.m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
