package d2;

import b6.g0;
import b6.w0;
import java.util.ArrayList;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f2707d = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20};

    /* renamed from: e, reason: collision with root package name */
    public static final a5.d f2708e = new a5.d(new androidx.fragment.app.a(16));

    /* renamed from: f, reason: collision with root package name */
    public static final a5.d f2709f = new a5.d(new androidx.fragment.app.a(17));

    /* renamed from: a, reason: collision with root package name */
    public w0 f2710a;

    /* renamed from: b, reason: collision with root package name */
    public z2.c f2711b = new z2.c(0);

    /* renamed from: c, reason: collision with root package name */
    public int f2712c;

    public final void a(int i9, ArrayList arrayList) {
        switch (i9) {
            case 0:
                arrayList.add(new i3.a());
                break;
            case 1:
                arrayList.add(new i3.c());
                break;
            case 2:
                arrayList.add(new i3.d(0));
                break;
            case 3:
                arrayList.add(new e2.a());
                break;
            case 4:
                m H0 = f2708e.H0(0);
                if (H0 == null) {
                    arrayList.add(new h2.b());
                    break;
                } else {
                    arrayList.add(H0);
                    break;
                }
            case 5:
                arrayList.add(new i2.b());
                break;
            case 6:
                arrayList.add(new u2.d(2, this.f2711b));
                break;
            case 7:
                arrayList.add(new v2.d(0));
                break;
            case 8:
                z2.c cVar = this.f2711b;
                b6.e0 e0Var = g0.f1391j;
                arrayList.add(new w2.i(cVar, 32, null, w0.f1464m));
                arrayList.add(new w2.m(16, this.f2711b));
                break;
            case 9:
                arrayList.add(new x2.d());
                break;
            case 10:
                arrayList.add(new i3.y());
                break;
            case 11:
                if (this.f2710a == null) {
                    b6.e0 e0Var2 = g0.f1391j;
                    this.f2710a = w0.f1464m;
                }
                arrayList.add(new i3.c0(1, 1, this.f2711b, new g1.u(0L), new d4.i(0, this.f2710a)));
                break;
            case 12:
                j3.d dVar = new j3.d();
                dVar.f5409c = 0;
                dVar.f5410d = -1L;
                dVar.f5412f = -1;
                dVar.f5413g = -1L;
                arrayList.add(dVar);
                break;
            case 14:
                arrayList.add(new g2.a(this.f2712c));
                break;
            case 15:
                m H02 = f2709f.H0(new Object[0]);
                if (H02 != null) {
                    arrayList.add(H02);
                    break;
                }
                break;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                arrayList.add(new f2.b(1, this.f2711b));
                break;
            case 17:
                arrayList.add(new g2.a(1, (byte) 0));
                break;
            case 18:
                arrayList.add(new j2.a(1));
                break;
            case 19:
                arrayList.add(new g2.a(0, (byte) 0));
                break;
            case 20:
                arrayList.add(new j2.a(0));
                break;
        }
    }
}
