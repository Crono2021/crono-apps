package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import org.webrtc.PeerConnectionFactory;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g {

    /* renamed from: j0, reason: collision with root package name */
    public static final SparseIntArray f10277j0;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public float O;
    public float P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public float Y;
    public float Z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f10278a;

    /* renamed from: a0, reason: collision with root package name */
    public int f10279a0;

    /* renamed from: b, reason: collision with root package name */
    public int f10280b;

    /* renamed from: b0, reason: collision with root package name */
    public int f10281b0;

    /* renamed from: c, reason: collision with root package name */
    public int f10282c;

    /* renamed from: c0, reason: collision with root package name */
    public int f10283c0;

    /* renamed from: d, reason: collision with root package name */
    public int f10284d;

    /* renamed from: d0, reason: collision with root package name */
    public int[] f10285d0;

    /* renamed from: e, reason: collision with root package name */
    public int f10286e;

    /* renamed from: e0, reason: collision with root package name */
    public String f10287e0;

    /* renamed from: f, reason: collision with root package name */
    public float f10288f;

    /* renamed from: f0, reason: collision with root package name */
    public String f10289f0;

    /* renamed from: g, reason: collision with root package name */
    public int f10290g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f10291g0;
    public int h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f10292h0;

    /* renamed from: i, reason: collision with root package name */
    public int f10293i;
    public boolean i0;

    /* renamed from: j, reason: collision with root package name */
    public int f10294j;

    /* renamed from: k, reason: collision with root package name */
    public int f10295k;

    /* renamed from: l, reason: collision with root package name */
    public int f10296l;

    /* renamed from: m, reason: collision with root package name */
    public int f10297m;

    /* renamed from: n, reason: collision with root package name */
    public int f10298n;

    /* renamed from: o, reason: collision with root package name */
    public int f10299o;

    /* renamed from: p, reason: collision with root package name */
    public int f10300p;

    /* renamed from: q, reason: collision with root package name */
    public int f10301q;

    /* renamed from: r, reason: collision with root package name */
    public int f10302r;

    /* renamed from: s, reason: collision with root package name */
    public int f10303s;

    /* renamed from: t, reason: collision with root package name */
    public float f10304t;

    /* renamed from: u, reason: collision with root package name */
    public float f10305u;

    /* renamed from: v, reason: collision with root package name */
    public String f10306v;

    /* renamed from: w, reason: collision with root package name */
    public int f10307w;

    /* renamed from: x, reason: collision with root package name */
    public int f10308x;

    /* renamed from: y, reason: collision with root package name */
    public float f10309y;

    /* renamed from: z, reason: collision with root package name */
    public int f10310z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10277j0 = sparseIntArray;
        sparseIntArray.append(38, 24);
        sparseIntArray.append(39, 25);
        sparseIntArray.append(41, 28);
        sparseIntArray.append(42, 29);
        sparseIntArray.append(47, 35);
        sparseIntArray.append(46, 34);
        sparseIntArray.append(20, 4);
        sparseIntArray.append(19, 3);
        sparseIntArray.append(17, 1);
        sparseIntArray.append(55, 6);
        sparseIntArray.append(56, 7);
        sparseIntArray.append(27, 17);
        sparseIntArray.append(28, 18);
        sparseIntArray.append(29, 19);
        sparseIntArray.append(0, 26);
        sparseIntArray.append(43, 31);
        sparseIntArray.append(44, 32);
        sparseIntArray.append(26, 10);
        sparseIntArray.append(25, 9);
        sparseIntArray.append(59, 13);
        sparseIntArray.append(62, 16);
        sparseIntArray.append(60, 14);
        sparseIntArray.append(57, 11);
        sparseIntArray.append(61, 15);
        sparseIntArray.append(58, 12);
        sparseIntArray.append(50, 38);
        sparseIntArray.append(36, 37);
        sparseIntArray.append(35, 39);
        sparseIntArray.append(49, 40);
        sparseIntArray.append(34, 20);
        sparseIntArray.append(48, 36);
        sparseIntArray.append(24, 5);
        sparseIntArray.append(37, 76);
        sparseIntArray.append(45, 76);
        sparseIntArray.append(40, 76);
        sparseIntArray.append(18, 76);
        sparseIntArray.append(16, 76);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(5, 27);
        sparseIntArray.append(7, 30);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(4, 33);
        sparseIntArray.append(6, 2);
        sparseIntArray.append(1, 22);
        sparseIntArray.append(2, 21);
        sparseIntArray.append(21, 61);
        sparseIntArray.append(23, 62);
        sparseIntArray.append(22, 63);
        sparseIntArray.append(54, 69);
        sparseIntArray.append(33, 70);
        sparseIntArray.append(12, 71);
        sparseIntArray.append(10, 72);
        sparseIntArray.append(11, 73);
        sparseIntArray.append(13, 74);
        sparseIntArray.append(9, 75);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f10340d);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = obtainStyledAttributes.getIndex(i9);
            SparseIntArray sparseIntArray = f10277j0;
            int i10 = sparseIntArray.get(index);
            if (i10 == 80) {
                this.f10291g0 = obtainStyledAttributes.getBoolean(index, this.f10291g0);
            } else if (i10 != 81) {
                switch (i10) {
                    case 1:
                        this.f10299o = k.f(obtainStyledAttributes, index, this.f10299o);
                        break;
                    case 2:
                        this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case 3:
                        this.f10298n = k.f(obtainStyledAttributes, index, this.f10298n);
                        break;
                    case 4:
                        this.f10297m = k.f(obtainStyledAttributes, index, this.f10297m);
                        break;
                    case 5:
                        this.f10306v = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f10310z = obtainStyledAttributes.getDimensionPixelOffset(index, this.f10310z);
                        break;
                    case 7:
                        this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                        break;
                    case 8:
                        this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 9:
                        this.f10303s = k.f(obtainStyledAttributes, index, this.f10303s);
                        break;
                    case 10:
                        this.f10302r = k.f(obtainStyledAttributes, index, this.f10302r);
                        break;
                    case 11:
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 12:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 13:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 14:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 15:
                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 17:
                        this.f10284d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f10284d);
                        break;
                    case 18:
                        this.f10286e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f10286e);
                        break;
                    case 19:
                        this.f10288f = obtainStyledAttributes.getFloat(index, this.f10288f);
                        break;
                    case 20:
                        this.f10304t = obtainStyledAttributes.getFloat(index, this.f10304t);
                        break;
                    case 21:
                        this.f10282c = obtainStyledAttributes.getLayoutDimension(index, this.f10282c);
                        break;
                    case 22:
                        this.f10280b = obtainStyledAttributes.getLayoutDimension(index, this.f10280b);
                        break;
                    case 23:
                        this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                        break;
                    case 24:
                        this.f10290g = k.f(obtainStyledAttributes, index, this.f10290g);
                        break;
                    case 25:
                        this.h = k.f(obtainStyledAttributes, index, this.h);
                        break;
                    case 26:
                        this.B = obtainStyledAttributes.getInt(index, this.B);
                        break;
                    case 27:
                        this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                        break;
                    case 28:
                        this.f10293i = k.f(obtainStyledAttributes, index, this.f10293i);
                        break;
                    case 29:
                        this.f10294j = k.f(obtainStyledAttributes, index, this.f10294j);
                        break;
                    case 30:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 31:
                        this.f10300p = k.f(obtainStyledAttributes, index, this.f10300p);
                        break;
                    case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                        this.f10301q = k.f(obtainStyledAttributes, index, this.f10301q);
                        break;
                    case 33:
                        this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                        break;
                    case 34:
                        this.f10296l = k.f(obtainStyledAttributes, index, this.f10296l);
                        break;
                    case 35:
                        this.f10295k = k.f(obtainStyledAttributes, index, this.f10295k);
                        break;
                    case 36:
                        this.f10305u = obtainStyledAttributes.getFloat(index, this.f10305u);
                        break;
                    case 37:
                        this.P = obtainStyledAttributes.getFloat(index, this.P);
                        break;
                    case 38:
                        this.O = obtainStyledAttributes.getFloat(index, this.O);
                        break;
                    case 39:
                        this.Q = obtainStyledAttributes.getInt(index, this.Q);
                        break;
                    case 40:
                        this.R = obtainStyledAttributes.getInt(index, this.R);
                        break;
                    default:
                        switch (i10) {
                            case 54:
                                this.S = obtainStyledAttributes.getInt(index, this.S);
                                break;
                            case 55:
                                this.T = obtainStyledAttributes.getInt(index, this.T);
                                break;
                            case 56:
                                this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                break;
                            case 57:
                                this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                break;
                            case 58:
                                this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                break;
                            case 59:
                                this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                break;
                            default:
                                switch (i10) {
                                    case 61:
                                        this.f10307w = k.f(obtainStyledAttributes, index, this.f10307w);
                                        break;
                                    case 62:
                                        this.f10308x = obtainStyledAttributes.getDimensionPixelSize(index, this.f10308x);
                                        break;
                                    case 63:
                                        this.f10309y = obtainStyledAttributes.getFloat(index, this.f10309y);
                                        break;
                                    default:
                                        switch (i10) {
                                            case 69:
                                                this.Y = obtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 70:
                                                this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 71:
                                                Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                break;
                                            case 72:
                                                this.f10279a0 = obtainStyledAttributes.getInt(index, this.f10279a0);
                                                break;
                                            case 73:
                                                this.f10281b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f10281b0);
                                                break;
                                            case 74:
                                                this.f10287e0 = obtainStyledAttributes.getString(index);
                                                break;
                                            case 75:
                                                this.i0 = obtainStyledAttributes.getBoolean(index, this.i0);
                                                break;
                                            case 76:
                                                Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                break;
                                            case IjkMediaMeta.FF_PROFILE_H264_MAIN /* 77 */:
                                                this.f10289f0 = obtainStyledAttributes.getString(index);
                                                break;
                                            default:
                                                Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                break;
                                        }
                                }
                        }
                }
            } else {
                this.f10292h0 = obtainStyledAttributes.getBoolean(index, this.f10292h0);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
