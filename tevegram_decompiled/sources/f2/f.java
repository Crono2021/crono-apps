package f2;

import b6.a0;
import b6.e0;
import b6.g0;
import b6.q;
import b6.w0;
import d1.l0;
import d1.r;
import d1.s;
import g1.p;
import g1.w;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f3310a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3311b;

    public f(int i9, w0 w0Var) {
        this.f3311b = i9;
        this.f3310a = w0Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static f b(int i9, p pVar) {
        a gVar;
        String str;
        int i10 = 4;
        q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i11 = pVar.f3701c;
        int i12 = 0;
        int i13 = -2;
        int i14 = 0;
        while (pVar.a() > 8) {
            int i15 = pVar.i();
            int i16 = pVar.f3700b + pVar.i();
            pVar.E(i16);
            if (i15 != 1414744396) {
                d dVar = null;
                switch (i15) {
                    case 1718776947:
                        if (i13 == 2) {
                            pVar.G(i10);
                            int i17 = pVar.i();
                            int i18 = pVar.i();
                            pVar.G(i10);
                            int i19 = pVar.i();
                            switch (i19) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str != null) {
                                r rVar = new r();
                                rVar.f2533q = i17;
                                rVar.f2534r = i18;
                                rVar.f2528l = l0.k(str);
                                gVar = new g(new s(rVar));
                                break;
                            } else {
                                androidx.activity.g.t(i19, "Ignoring track with unsupported compression ", "StreamFormatChunk");
                                gVar = dVar;
                                break;
                            }
                        } else {
                            if (i13 == 1) {
                                int m9 = pVar.m();
                                String str2 = m9 != 1 ? m9 != 85 ? m9 != 255 ? m9 != 8192 ? m9 != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                                if (str2 != null) {
                                    int m10 = pVar.m();
                                    int i20 = pVar.i();
                                    pVar.G(6);
                                    int x6 = w.x(pVar.z());
                                    int m11 = pVar.m();
                                    byte[] bArr = new byte[m11];
                                    pVar.e(i12, m11, bArr);
                                    r rVar2 = new r();
                                    rVar2.f2528l = l0.k(str2);
                                    rVar2.f2541y = m10;
                                    rVar2.f2542z = i20;
                                    if ("audio/raw".equals(str2) && x6 != 0) {
                                        rVar2.A = x6;
                                    }
                                    if ("audio/mp4a-latm".equals(str2) && m11 > 0) {
                                        rVar2.f2530n = g0.q(bArr);
                                    }
                                    gVar = new g(new s(rVar2));
                                    break;
                                } else {
                                    androidx.activity.g.t(m9, "Ignoring track with unsupported format tag ", "StreamFormatChunk");
                                }
                            } else {
                                g1.a.D("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(w.D(i13)));
                            }
                            gVar = dVar;
                        }
                    case 1751742049:
                        int i21 = pVar.i();
                        pVar.G(8);
                        int i22 = pVar.i();
                        int i23 = pVar.i();
                        pVar.G(i10);
                        pVar.i();
                        pVar.G(12);
                        gVar = new c(i21, i22, i23);
                        break;
                    case 1752331379:
                        int i24 = pVar.i();
                        pVar.G(12);
                        pVar.i();
                        int i25 = pVar.i();
                        int i26 = pVar.i();
                        pVar.G(i10);
                        int i27 = pVar.i();
                        int i28 = pVar.i();
                        pVar.G(8);
                        dVar = new d(i24, i25, i26, i27, i28);
                        gVar = dVar;
                        break;
                    case 1852994675:
                        gVar = new h(pVar.r(pVar.a(), a6.b.f203c));
                        break;
                    default:
                        gVar = dVar;
                        break;
                }
            } else {
                gVar = b(pVar.i(), pVar);
            }
            if (gVar != null) {
                if (gVar.getType() == 1752331379) {
                    int i29 = ((d) gVar).f3294a;
                    if (i29 == 1935960438) {
                        i13 = 2;
                    } else if (i29 == 1935963489) {
                        i13 = 1;
                    } else if (i29 != 1937012852) {
                        g1.a.D("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(i29));
                        i13 = -1;
                    } else {
                        i13 = 3;
                    }
                }
                int i30 = i14 + 1;
                if (objArr.length < i30) {
                    objArr = Arrays.copyOf(objArr, a0.d(objArr.length, i30));
                }
                objArr[i14] = gVar;
                i14 = i30;
            }
            pVar.F(i16);
            pVar.E(i11);
            i10 = 4;
            i12 = 0;
        }
        return new f(i9, g0.l(i14, objArr));
    }

    public final a a(Class cls) {
        e0 listIterator = this.f3310a.listIterator(0);
        while (listIterator.hasNext()) {
            a aVar = (a) listIterator.next();
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }

    @Override // f2.a
    public final int getType() {
        return this.f3311b;
    }
}
