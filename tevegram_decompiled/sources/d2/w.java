package d2;

import androidx.constraintlayout.widget.ConstraintLayout;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public int f2746a;

    /* renamed from: b, reason: collision with root package name */
    public int f2747b;

    /* renamed from: c, reason: collision with root package name */
    public int f2748c;

    /* renamed from: d, reason: collision with root package name */
    public int f2749d;

    /* renamed from: e, reason: collision with root package name */
    public int f2750e;

    /* renamed from: f, reason: collision with root package name */
    public int f2751f;

    /* renamed from: g, reason: collision with root package name */
    public Object f2752g;

    public w(ConstraintLayout constraintLayout) {
        this.f2752g = constraintLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0215 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x020b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0150 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0158 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0185 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ff A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(w.d r22, x.b r23) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.w.a(w.d, x.b):void");
    }

    public boolean b(int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        if ((i9 & (-2097152)) != -2097152 || (i10 = (i9 >>> 19) & 3) == 1 || (i11 = (i9 >>> 17) & 3) == 0 || (i12 = (i9 >>> 12) & 15) == 0 || i12 == 15 || (i13 = (i9 >>> 10) & 3) == 3) {
            return false;
        }
        this.f2746a = i10;
        this.f2752g = b.f2648s[3 - i11];
        int i14 = b.f2649t[i13];
        this.f2748c = i14;
        if (i10 == 2) {
            this.f2748c = i14 / 2;
        } else if (i10 == 0) {
            this.f2748c = i14 / 4;
        }
        int i15 = (i9 >>> 9) & 1;
        int i16 = 1152;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    m7.c.d();
                    return false;
                }
                i16 = 384;
            }
        } else if (i10 != 3) {
            i16 = 576;
        }
        this.f2751f = i16;
        if (i11 == 3) {
            int i17 = i10 == 3 ? b.f2650u[i12 - 1] : b.f2651v[i12 - 1];
            this.f2750e = i17;
            this.f2747b = (((i17 * 12) / this.f2748c) + i15) * 4;
        } else {
            int i18 = IjkMediaMeta.FF_PROFILE_H264_HIGH_444;
            if (i10 == 3) {
                int i19 = i11 == 2 ? b.f2652w[i12 - 1] : b.f2653x[i12 - 1];
                this.f2750e = i19;
                this.f2747b = ((i19 * IjkMediaMeta.FF_PROFILE_H264_HIGH_444) / this.f2748c) + i15;
            } else {
                int i20 = b.f2654y[i12 - 1];
                this.f2750e = i20;
                if (i11 == 1) {
                    i18 = 72;
                }
                this.f2747b = ((i18 * i20) / this.f2748c) + i15;
            }
        }
        this.f2749d = ((i9 >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
