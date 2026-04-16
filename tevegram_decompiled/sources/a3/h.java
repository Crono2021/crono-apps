package a3;

import android.text.SpannableStringBuilder;
import g1.p;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends l {

    /* renamed from: g, reason: collision with root package name */
    public final p f108g = new p();
    public final g h = new g();

    /* renamed from: i, reason: collision with root package name */
    public int f109i = -1;

    /* renamed from: j, reason: collision with root package name */
    public final int f110j;

    /* renamed from: k, reason: collision with root package name */
    public final f[] f111k;

    /* renamed from: l, reason: collision with root package name */
    public f f112l;

    /* renamed from: m, reason: collision with root package name */
    public List f113m;

    /* renamed from: n, reason: collision with root package name */
    public List f114n;

    /* renamed from: o, reason: collision with root package name */
    public g f115o;

    /* renamed from: p, reason: collision with root package name */
    public int f116p;

    public h(int i9, List list) {
        this.f110j = i9 == -1 ? 1 : i9;
        if (list != null && list.size() == 1 && ((byte[]) list.get(0)).length == 1) {
            byte b9 = ((byte[]) list.get(0))[0];
        }
        this.f111k = new f[8];
        int i10 = 0;
        while (true) {
            f[] fVarArr = this.f111k;
            if (i10 >= 8) {
                this.f112l = fVarArr[0];
                return;
            } else {
                fVarArr[i10] = new f();
                i10++;
            }
        }
    }

    @Override // a3.l
    public final a0.b e() {
        List list = this.f113m;
        this.f114n = list;
        list.getClass();
        return new a0.b(list, 1);
    }

    @Override // a3.l
    public final void f(j jVar) {
        ByteBuffer byteBuffer = jVar.f5359m;
        byteBuffer.getClass();
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        p pVar = this.f108g;
        pVar.D(array, limit);
        while (pVar.a() >= 3) {
            int t8 = pVar.t();
            int i9 = t8 & 3;
            boolean z8 = (t8 & 4) == 4;
            byte t9 = (byte) pVar.t();
            byte t10 = (byte) pVar.t();
            if (i9 == 2 || i9 == 3) {
                if (z8) {
                    if (i9 == 3) {
                        i();
                        int i10 = (t9 & 192) >> 6;
                        int i11 = this.f109i;
                        if (i11 != -1 && i10 != (i11 + 1) % 4) {
                            k();
                            g1.a.D("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f109i + " current=" + i10);
                        }
                        this.f109i = i10;
                        int i12 = t9 & 63;
                        if (i12 == 0) {
                            i12 = 64;
                        }
                        g gVar = new g(i10, i12);
                        this.f115o = gVar;
                        byte[] bArr = gVar.f104b;
                        gVar.f107e = 1;
                        bArr[0] = t10;
                    } else {
                        g1.a.f(i9 == 2);
                        g gVar2 = this.f115o;
                        if (gVar2 == null) {
                            g1.a.p("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = gVar2.f104b;
                            int i13 = gVar2.f107e;
                            int i14 = i13 + 1;
                            gVar2.f107e = i14;
                            bArr2[i13] = t9;
                            gVar2.f107e = i13 + 2;
                            bArr2[i14] = t10;
                        }
                    }
                    g gVar3 = this.f115o;
                    if (gVar3.f107e == (gVar3.f106d * 2) - 1) {
                        i();
                    }
                }
            }
        }
    }

    @Override // a3.l, j1.b
    public final void flush() {
        super.flush();
        this.f113m = null;
        this.f114n = null;
        this.f116p = 0;
        this.f112l = this.f111k[0];
        k();
        this.f115o = null;
    }

    @Override // a3.l
    public final boolean h() {
        return this.f113m != this.f114n;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void i() {
        int i9;
        g gVar = this.f115o;
        if (gVar == null) {
            return;
        }
        int i10 = 2;
        if (gVar.f107e != (gVar.f106d * 2) - 1) {
            g1.a.o("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f115o.f106d * 2) - 1) + ", but current index is " + this.f115o.f107e + " (sequence number " + this.f115o.f105c + ");");
        }
        g gVar2 = this.f115o;
        byte[] bArr = gVar2.f104b;
        int i11 = gVar2.f107e;
        g gVar3 = this.h;
        gVar3.o(bArr, i11);
        boolean z8 = false;
        while (true) {
            if (gVar3.b() > 0) {
                int i12 = 3;
                int i13 = gVar3.i(3);
                int i14 = gVar3.i(5);
                if (i13 == 7) {
                    gVar3.s(i10);
                    i13 = gVar3.i(6);
                    if (i13 < 7) {
                        androidx.activity.g.t(i13, "Invalid extended service number: ", "Cea708Decoder");
                    }
                }
                if (i14 == 0) {
                    if (i13 != 0) {
                        g1.a.D("Cea708Decoder", "serviceNumber is non-zero (" + i13 + ") when blockSize is 0");
                    }
                } else if (i13 != this.f110j) {
                    gVar3.t(i14);
                } else {
                    int g9 = (i14 * 8) + gVar3.g();
                    while (gVar3.g() < g9) {
                        int i15 = gVar3.i(8);
                        if (i15 == 16) {
                            i9 = g9;
                            int i16 = gVar3.i(8);
                            if (i16 <= 31) {
                                if (i16 > 7) {
                                    if (i16 <= 15) {
                                        gVar3.s(8);
                                    } else if (i16 <= 23) {
                                        gVar3.s(16);
                                    } else if (i16 <= 31) {
                                        gVar3.s(24);
                                    }
                                }
                            } else if (i16 <= 127) {
                                if (i16 == 32) {
                                    this.f112l.a(' ');
                                } else if (i16 == 33) {
                                    this.f112l.a((char) 160);
                                } else if (i16 == 37) {
                                    this.f112l.a((char) 8230);
                                } else if (i16 == 42) {
                                    this.f112l.a((char) 352);
                                } else if (i16 == 44) {
                                    this.f112l.a((char) 338);
                                } else if (i16 == 63) {
                                    this.f112l.a((char) 376);
                                } else if (i16 == 57) {
                                    this.f112l.a((char) 8482);
                                } else if (i16 == 58) {
                                    this.f112l.a((char) 353);
                                } else if (i16 == 60) {
                                    this.f112l.a((char) 339);
                                } else if (i16 != 61) {
                                    switch (i16) {
                                        case 48:
                                            this.f112l.a((char) 9608);
                                            break;
                                        case 49:
                                            this.f112l.a((char) 8216);
                                            break;
                                        case l1.k.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY /* 50 */:
                                            this.f112l.a((char) 8217);
                                            break;
                                        case 51:
                                            this.f112l.a((char) 8220);
                                            break;
                                        case 52:
                                            this.f112l.a((char) 8221);
                                            break;
                                        case 53:
                                            this.f112l.a((char) 8226);
                                            break;
                                        default:
                                            switch (i16) {
                                                case 118:
                                                    this.f112l.a((char) 8539);
                                                    break;
                                                case 119:
                                                    this.f112l.a((char) 8540);
                                                    break;
                                                case 120:
                                                    this.f112l.a((char) 8541);
                                                    break;
                                                case 121:
                                                    this.f112l.a((char) 8542);
                                                    break;
                                                case IjkMediaMeta.FF_PROFILE_H264_HIGH_422 /* 122 */:
                                                    this.f112l.a((char) 9474);
                                                    break;
                                                case 123:
                                                    this.f112l.a((char) 9488);
                                                    break;
                                                case 124:
                                                    this.f112l.a((char) 9492);
                                                    break;
                                                case 125:
                                                    this.f112l.a((char) 9472);
                                                    break;
                                                case 126:
                                                    this.f112l.a((char) 9496);
                                                    break;
                                                case 127:
                                                    this.f112l.a((char) 9484);
                                                    break;
                                                default:
                                                    androidx.activity.g.t(i16, "Invalid G2 character: ", "Cea708Decoder");
                                                    break;
                                            }
                                    }
                                } else {
                                    this.f112l.a((char) 8480);
                                }
                                z8 = true;
                            } else if (i16 <= 159) {
                                if (i16 <= 135) {
                                    gVar3.s(32);
                                } else if (i16 <= 143) {
                                    gVar3.s(40);
                                } else if (i16 <= 159) {
                                    gVar3.s(2);
                                    gVar3.s(gVar3.i(6) * 8);
                                }
                            } else if (i16 <= 255) {
                                if (i16 == 160) {
                                    this.f112l.a((char) 13252);
                                } else {
                                    androidx.activity.g.t(i16, "Invalid G3 character: ", "Cea708Decoder");
                                    this.f112l.a('_');
                                }
                                z8 = true;
                            } else {
                                androidx.activity.g.t(i16, "Invalid extended command: ", "Cea708Decoder");
                            }
                        } else if (i15 <= 31) {
                            if (i15 != 0) {
                                if (i15 == i12) {
                                    this.f113m = j();
                                } else if (i15 != 8) {
                                    switch (i15) {
                                        case 12:
                                            k();
                                            break;
                                        case 13:
                                            this.f112l.a('\n');
                                            break;
                                        case 14:
                                            break;
                                        default:
                                            if (i15 < 17 || i15 > 23) {
                                                if (i15 < 24 || i15 > 31) {
                                                    androidx.activity.g.t(i15, "Invalid C0 command: ", "Cea708Decoder");
                                                    break;
                                                } else {
                                                    g1.a.D("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i15);
                                                    gVar3.s(16);
                                                    break;
                                                }
                                            } else {
                                                g1.a.D("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i15);
                                                gVar3.s(8);
                                                break;
                                            }
                                    }
                                } else {
                                    SpannableStringBuilder spannableStringBuilder = this.f112l.f83b;
                                    int length = spannableStringBuilder.length();
                                    if (length > 0) {
                                        spannableStringBuilder.delete(length - 1, length);
                                    }
                                }
                            }
                            i9 = g9;
                        } else if (i15 <= 127) {
                            f fVar = this.f112l;
                            if (i15 == 127) {
                                fVar.a((char) 9835);
                            } else {
                                fVar.a((char) (i15 & 255));
                            }
                            i9 = g9;
                            z8 = true;
                        } else {
                            if (i15 <= 159) {
                                f[] fVarArr = this.f111k;
                                switch (i15) {
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                        i9 = g9;
                                        int i17 = i15 - 128;
                                        if (this.f116p != i17) {
                                            this.f116p = i17;
                                            this.f112l = fVarArr[i17];
                                            break;
                                        }
                                        break;
                                    case 136:
                                        i9 = g9;
                                        for (int i18 = 1; i18 <= 8; i18++) {
                                            if (gVar3.h()) {
                                                f fVar2 = fVarArr[8 - i18];
                                                fVar2.f82a.clear();
                                                fVar2.f83b.clear();
                                                fVar2.f96p = -1;
                                                fVar2.f97q = -1;
                                                fVar2.f98r = -1;
                                                fVar2.f100t = -1;
                                                fVar2.f102v = 0;
                                            }
                                        }
                                        break;
                                    case 137:
                                        i9 = g9;
                                        for (int i19 = 1; i19 <= 8; i19++) {
                                            if (gVar3.h()) {
                                                fVarArr[8 - i19].f85d = true;
                                            }
                                        }
                                        break;
                                    case 138:
                                        i9 = g9;
                                        for (int i20 = 1; i20 <= 8; i20++) {
                                            if (gVar3.h()) {
                                                fVarArr[8 - i20].f85d = false;
                                            }
                                        }
                                        break;
                                    case 139:
                                        i9 = g9;
                                        for (int i21 = 1; i21 <= 8; i21++) {
                                            if (gVar3.h()) {
                                                fVarArr[8 - i21].f85d = !r1.f85d;
                                            }
                                        }
                                        break;
                                    case 140:
                                        i9 = g9;
                                        for (int i22 = 1; i22 <= 8; i22++) {
                                            if (gVar3.h()) {
                                                fVarArr[8 - i22].d();
                                            }
                                        }
                                        break;
                                    case 141:
                                        i9 = g9;
                                        gVar3.s(8);
                                        break;
                                    case 142:
                                        i9 = g9;
                                        break;
                                    case 143:
                                        i9 = g9;
                                        k();
                                        break;
                                    case IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
                                        i9 = g9;
                                        if (!this.f112l.f84c) {
                                            gVar3.s(16);
                                            break;
                                        } else {
                                            gVar3.i(4);
                                            gVar3.i(2);
                                            gVar3.i(2);
                                            boolean h = gVar3.h();
                                            boolean h9 = gVar3.h();
                                            gVar3.i(3);
                                            gVar3.i(3);
                                            this.f112l.e(h, h9);
                                        }
                                    case 145:
                                        i9 = g9;
                                        if (this.f112l.f84c) {
                                            int c9 = f.c(gVar3.i(2), gVar3.i(2), gVar3.i(2), gVar3.i(2));
                                            int c10 = f.c(gVar3.i(2), gVar3.i(2), gVar3.i(2), gVar3.i(2));
                                            gVar3.s(2);
                                            f.c(gVar3.i(2), gVar3.i(2), gVar3.i(2), 0);
                                            this.f112l.f(c9, c10);
                                        } else {
                                            gVar3.s(24);
                                        }
                                        break;
                                    case 146:
                                        i9 = g9;
                                        if (this.f112l.f84c) {
                                            gVar3.s(4);
                                            int i23 = gVar3.i(4);
                                            gVar3.s(2);
                                            gVar3.i(6);
                                            f fVar3 = this.f112l;
                                            if (fVar3.f102v != i23) {
                                                fVar3.a('\n');
                                            }
                                            fVar3.f102v = i23;
                                        } else {
                                            gVar3.s(16);
                                        }
                                        break;
                                    case 147:
                                    case 148:
                                    case 149:
                                    case 150:
                                    default:
                                        androidx.activity.g.t(i15, "Invalid C1 command: ", "Cea708Decoder");
                                        i9 = g9;
                                        break;
                                    case 151:
                                        i9 = g9;
                                        if (this.f112l.f84c) {
                                            int c11 = f.c(gVar3.i(2), gVar3.i(2), gVar3.i(2), gVar3.i(2));
                                            gVar3.i(2);
                                            f.c(gVar3.i(2), gVar3.i(2), gVar3.i(2), 0);
                                            gVar3.h();
                                            gVar3.h();
                                            gVar3.i(2);
                                            gVar3.i(2);
                                            int i24 = gVar3.i(2);
                                            gVar3.s(8);
                                            f fVar4 = this.f112l;
                                            fVar4.f95o = c11;
                                            fVar4.f92l = i24;
                                        } else {
                                            gVar3.s(32);
                                        }
                                        break;
                                    case 152:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 159:
                                        int i25 = i15 - 152;
                                        f fVar5 = fVarArr[i25];
                                        gVar3.s(i10);
                                        boolean h10 = gVar3.h();
                                        boolean h11 = gVar3.h();
                                        gVar3.h();
                                        int i26 = gVar3.i(i12);
                                        boolean h12 = gVar3.h();
                                        int i27 = gVar3.i(7);
                                        int i28 = gVar3.i(8);
                                        int i29 = gVar3.i(4);
                                        int i30 = gVar3.i(4);
                                        gVar3.s(i10);
                                        gVar3.i(6);
                                        gVar3.s(i10);
                                        int i31 = gVar3.i(3);
                                        int i32 = gVar3.i(3);
                                        ArrayList arrayList = fVar5.f82a;
                                        i9 = g9;
                                        fVar5.f84c = true;
                                        fVar5.f85d = h10;
                                        fVar5.f91k = h11;
                                        fVar5.f86e = i26;
                                        fVar5.f87f = h12;
                                        fVar5.f88g = i27;
                                        fVar5.h = i28;
                                        fVar5.f89i = i29;
                                        int i33 = i30 + 1;
                                        if (fVar5.f90j != i33) {
                                            fVar5.f90j = i33;
                                            while (true) {
                                                if ((h11 && arrayList.size() >= fVar5.f90j) || arrayList.size() >= 15) {
                                                    arrayList.remove(0);
                                                }
                                            }
                                        }
                                        if (i31 != 0 && fVar5.f93m != i31) {
                                            fVar5.f93m = i31;
                                            int i34 = i31 - 1;
                                            int i35 = f.C[i34];
                                            boolean z9 = f.B[i34];
                                            int i36 = f.f81z[i34];
                                            int i37 = f.A[i34];
                                            int i38 = f.f80y[i34];
                                            fVar5.f95o = i35;
                                            fVar5.f92l = i38;
                                        }
                                        if (i32 != 0 && fVar5.f94n != i32) {
                                            fVar5.f94n = i32;
                                            int i39 = i32 - 1;
                                            int i40 = f.E[i39];
                                            int i41 = f.D[i39];
                                            fVar5.e(false, false);
                                            fVar5.f(f.f78w, f.F[i39]);
                                        }
                                        if (this.f116p != i25) {
                                            this.f116p = i25;
                                            this.f112l = fVarArr[i25];
                                        }
                                        break;
                                }
                            } else {
                                i9 = g9;
                                if (i15 <= 255) {
                                    this.f112l.a((char) (i15 & 255));
                                } else {
                                    androidx.activity.g.t(i15, "Invalid base command: ", "Cea708Decoder");
                                }
                            }
                            z8 = true;
                        }
                        g9 = i9;
                        i10 = 2;
                        i12 = 3;
                    }
                }
            }
        }
        if (z8) {
            this.f113m = j();
        }
        this.f115o = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List j() {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.h.j():java.util.List");
    }

    public final void k() {
        for (int i9 = 0; i9 < 8; i9++) {
            this.f111k[i9].d();
        }
    }
}
