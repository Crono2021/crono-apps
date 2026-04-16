package d1;

import java.util.Arrays;
import org.webrtc.PeerConnectionFactory;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h0 {

    /* renamed from: y, reason: collision with root package name */
    public static final h0 f2449y = new h0(new g0());

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f2450a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f2451b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f2452c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f2453d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f2454e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f2455f;

    /* renamed from: g, reason: collision with root package name */
    public final Integer f2456g;
    public final Integer h;

    /* renamed from: i, reason: collision with root package name */
    public final Integer f2457i;

    /* renamed from: j, reason: collision with root package name */
    public final Integer f2458j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f2459k;

    /* renamed from: l, reason: collision with root package name */
    public final Integer f2460l;

    /* renamed from: m, reason: collision with root package name */
    public final Integer f2461m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f2462n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f2463o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f2464p;

    /* renamed from: q, reason: collision with root package name */
    public final Integer f2465q;

    /* renamed from: r, reason: collision with root package name */
    public final Integer f2466r;

    /* renamed from: s, reason: collision with root package name */
    public final CharSequence f2467s;

    /* renamed from: t, reason: collision with root package name */
    public final CharSequence f2468t;

    /* renamed from: u, reason: collision with root package name */
    public final CharSequence f2469u;

    /* renamed from: v, reason: collision with root package name */
    public final CharSequence f2470v;

    /* renamed from: w, reason: collision with root package name */
    public final CharSequence f2471w;

    /* renamed from: x, reason: collision with root package name */
    public final Integer f2472x;

    static {
        androidx.activity.g.s(0, 1, 2, 3, 4);
        androidx.activity.g.s(5, 6, 8, 9, 10);
        androidx.activity.g.s(11, 12, 13, 14, 15);
        androidx.activity.g.s(16, 17, 18, 19, 20);
        androidx.activity.g.s(21, 22, 23, 24, 25);
        androidx.activity.g.s(26, 27, 28, 29, 30);
        g1.w.H(31);
        g1.w.H(32);
        g1.w.H(IjkMediaCodecInfo.RANK_MAX);
    }

    public h0(g0 g0Var) {
        Boolean bool = g0Var.f2435k;
        Integer num = g0Var.f2434j;
        Integer num2 = g0Var.f2447w;
        int i9 = 1;
        int i10 = 0;
        if (bool != null) {
            if (!bool.booleanValue()) {
                num = -1;
            } else if (num == null || num.intValue() == -1) {
                if (num2 != null) {
                    switch (num2.intValue()) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                        case 17:
                        case 18:
                        case 19:
                        case 31:
                        case PeerConnectionFactory.Options.ADAPTER_TYPE_ANY /* 32 */:
                        case 33:
                        case 34:
                        case 35:
                            break;
                        case 20:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        default:
                            i9 = 0;
                            break;
                        case 21:
                            i9 = 2;
                            break;
                        case 22:
                            i9 = 3;
                            break;
                        case 23:
                            i9 = 4;
                            break;
                        case 24:
                            i9 = 5;
                            break;
                        case 25:
                            i9 = 6;
                            break;
                    }
                    i10 = i9;
                }
                num = Integer.valueOf(i10);
            }
        } else if (num != null) {
            boolean z8 = num.intValue() != -1;
            bool = Boolean.valueOf(z8);
            if (z8 && num2 == null) {
                switch (num.intValue()) {
                    case 1:
                        break;
                    case 2:
                        i10 = 21;
                        break;
                    case 3:
                        i10 = 22;
                        break;
                    case 4:
                        i10 = 23;
                        break;
                    case 5:
                        i10 = 24;
                        break;
                    case 6:
                        i10 = 25;
                        break;
                    default:
                        i10 = 20;
                        break;
                }
                num2 = Integer.valueOf(i10);
            }
        }
        this.f2450a = g0Var.f2426a;
        this.f2451b = g0Var.f2427b;
        this.f2452c = g0Var.f2428c;
        this.f2453d = g0Var.f2429d;
        this.f2454e = g0Var.f2430e;
        this.f2455f = g0Var.f2431f;
        this.f2456g = g0Var.f2432g;
        this.h = g0Var.h;
        this.f2457i = g0Var.f2433i;
        this.f2458j = num;
        this.f2459k = bool;
        Integer num3 = g0Var.f2436l;
        this.f2460l = num3;
        this.f2461m = num3;
        this.f2462n = g0Var.f2437m;
        this.f2463o = g0Var.f2438n;
        this.f2464p = g0Var.f2439o;
        this.f2465q = g0Var.f2440p;
        this.f2466r = g0Var.f2441q;
        this.f2467s = g0Var.f2442r;
        this.f2468t = g0Var.f2443s;
        this.f2469u = g0Var.f2444t;
        this.f2470v = g0Var.f2445u;
        this.f2471w = g0Var.f2446v;
        this.f2472x = num2;
    }

    public final g0 a() {
        g0 g0Var = new g0();
        g0Var.f2426a = this.f2450a;
        g0Var.f2427b = this.f2451b;
        g0Var.f2428c = this.f2452c;
        g0Var.f2429d = this.f2453d;
        g0Var.f2430e = this.f2454e;
        g0Var.f2431f = this.f2455f;
        g0Var.f2432g = this.f2456g;
        g0Var.h = this.h;
        g0Var.f2433i = this.f2457i;
        g0Var.f2434j = this.f2458j;
        g0Var.f2435k = this.f2459k;
        g0Var.f2436l = this.f2461m;
        g0Var.f2437m = this.f2462n;
        g0Var.f2438n = this.f2463o;
        g0Var.f2439o = this.f2464p;
        g0Var.f2440p = this.f2465q;
        g0Var.f2441q = this.f2466r;
        g0Var.f2442r = this.f2467s;
        g0Var.f2443s = this.f2468t;
        g0Var.f2444t = this.f2469u;
        g0Var.f2445u = this.f2470v;
        g0Var.f2446v = this.f2471w;
        g0Var.f2447w = this.f2472x;
        return g0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h0.class != obj.getClass()) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return g1.w.a(this.f2450a, h0Var.f2450a) && g1.w.a(this.f2451b, h0Var.f2451b) && g1.w.a(this.f2452c, h0Var.f2452c) && g1.w.a(this.f2453d, h0Var.f2453d) && g1.w.a(this.f2454e, h0Var.f2454e) && Arrays.equals(this.f2455f, h0Var.f2455f) && g1.w.a(this.f2456g, h0Var.f2456g) && g1.w.a(this.h, h0Var.h) && g1.w.a(this.f2457i, h0Var.f2457i) && g1.w.a(this.f2458j, h0Var.f2458j) && g1.w.a(this.f2459k, h0Var.f2459k) && g1.w.a(this.f2461m, h0Var.f2461m) && g1.w.a(this.f2462n, h0Var.f2462n) && g1.w.a(this.f2463o, h0Var.f2463o) && g1.w.a(this.f2464p, h0Var.f2464p) && g1.w.a(this.f2465q, h0Var.f2465q) && g1.w.a(this.f2466r, h0Var.f2466r) && g1.w.a(this.f2467s, h0Var.f2467s) && g1.w.a(this.f2468t, h0Var.f2468t) && g1.w.a(this.f2469u, h0Var.f2469u) && g1.w.a(this.f2470v, h0Var.f2470v) && g1.w.a(this.f2471w, h0Var.f2471w) && g1.w.a(this.f2472x, h0Var.f2472x);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2450a, this.f2451b, this.f2452c, this.f2453d, null, null, this.f2454e, null, null, Integer.valueOf(Arrays.hashCode(this.f2455f)), this.f2456g, null, this.h, this.f2457i, this.f2458j, this.f2459k, null, this.f2461m, this.f2462n, this.f2463o, this.f2464p, this.f2465q, this.f2466r, this.f2467s, this.f2468t, this.f2469u, null, null, this.f2470v, null, this.f2471w, this.f2472x, true});
    }
}
