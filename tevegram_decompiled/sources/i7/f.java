package i7;

import android.net.Uri;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.PlayerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4837m;

    /* renamed from: n, reason: collision with root package name */
    public int f4838n;

    /* renamed from: o, reason: collision with root package name */
    public Object f4839o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f4840p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Object obj, Object obj2, r7.c cVar, int i9) {
        super(2, cVar);
        this.f4837m = i9;
        this.f4839o = obj;
        this.f4840p = obj2;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f4837m) {
            case 0:
                ((f) j(uVar, cVar)).k(n7.g.f7490c);
                break;
        }
        return ((f) j(uVar, cVar)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f4837m) {
            case 0:
                return new f((h) this.f4839o, (j7.d) this.f4840p, cVar, 0);
            case 1:
                return new f((Uri) this.f4839o, (MainActivity) this.f4840p, cVar, 1);
            case 2:
                return new f((PlaylistItem) this.f4839o, (PlayerActivity) this.f4840p, cVar, 2);
            default:
                return new f((m7.k) this.f4840p, cVar);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:182|(2:184|(1:(3:187|188|189)(2:190|191))(1:192))(2:202|(1:204))|193|194|195|196|197|(1:199)|188|189) */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x03b6, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0188, code lost:
    
        if (r0 != r3) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0188 -> B:7:0x018c). Please report as a decompilation issue!!! */
    @Override // t7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.f.k(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(m7.k kVar, r7.c cVar) {
        super(2, cVar);
        this.f4837m = 3;
        this.f4840p = kVar;
    }
}
