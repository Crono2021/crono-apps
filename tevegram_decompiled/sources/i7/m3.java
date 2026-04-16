package i7;

import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.ui.PlayerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m3 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4982m;

    /* renamed from: n, reason: collision with root package name */
    public int f4983n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ g.l f4984o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m3(g.l lVar, r7.c cVar, int i9) {
        super(2, cVar);
        this.f4982m = i9;
        this.f4984o = lVar;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f4982m) {
            case 0:
                ((m3) j(uVar, cVar)).k(n7.g.f7490c);
                break;
            case 1:
                ((m3) j(uVar, cVar)).k(n7.g.f7490c);
                break;
            default:
                ((m3) j(uVar, cVar)).k(n7.g.f7490c);
                break;
        }
        return s7.a.f8891i;
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f4982m) {
            case 0:
                return new m3((PlayerActivity) this.f4984o, cVar, 0);
            case 1:
                return new m3((PlayerActivity) this.f4984o, cVar, 1);
            default:
                return new m3((LiveStreamActivity) this.f4984o, cVar, 2);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0065 -> B:20:0x0068). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00f9 -> B:54:0x00fc). Please report as a decompilation issue!!! */
    @Override // t7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.m3.k(java.lang.Object):java.lang.Object");
    }
}
