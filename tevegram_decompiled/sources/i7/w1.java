package i7;

import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class w1 implements a8.q {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5170i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u1 f5171j;

    public /* synthetic */ w1(u1 u1Var, int i9) {
        this.f5170i = i9;
        this.f5171j = u1Var;
    }

    @Override // a8.q
    public final Object c(Object obj, Object obj2, Serializable serializable) {
        String str = (String) obj;
        Long l4 = (Long) obj2;
        String str2 = (String) serializable;
        switch (this.f5170i) {
            case 0:
                this.f5171j.i(str, l4, null, str2);
                break;
            default:
                this.f5171j.i(str, l4, null, str2);
                break;
        }
        return n7.g.f7490c;
    }
}
