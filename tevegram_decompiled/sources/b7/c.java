package b7;

import a0.l;
import a8.p;
import android.net.Uri;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import h7.k0;
import i8.u;
import m7.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends t7.h implements p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1484m;

    /* renamed from: n, reason: collision with root package name */
    public int f1485n;

    /* renamed from: o, reason: collision with root package name */
    public Object f1486o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f1487p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f1488q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, Object obj2, Object obj3, r7.c cVar, int i9) {
        super(2, cVar);
        this.f1484m = i9;
        this.f1486o = obj;
        this.f1487p = obj2;
        this.f1488q = obj3;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        u uVar = (u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f1484m) {
        }
        return ((c) j(uVar, cVar)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f1484m) {
            case 0:
                return new c((l) this.f1486o, (HistoryItem) this.f1487p, (k7.a) this.f1488q, cVar, 0);
            case 1:
                c cVar2 = new c((LiveStreamActivity) this.f1488q, cVar);
                cVar2.f1487p = obj;
                return cVar2;
            case 2:
                return new c((String) this.f1486o, (String) this.f1487p, (MediaExplorerActivity) this.f1488q, cVar, 2);
            case 3:
                return new c((String) this.f1486o, (MediaExplorerActivity) this.f1487p, (Uri) this.f1488q, cVar, 3);
            case 4:
                return new c((e7.a) this.f1486o, (PlayerActivity) this.f1487p, (String) this.f1488q, cVar, 4);
            default:
                return new c((k) this.f1486o, (m7.f) this.f1487p, (k0) this.f1488q, cVar, 5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:378:0x05b9, code lost:
    
        if (r7 == false) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x05be, code lost:
    
        if (r4 != false) goto L317;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x065a  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0129  */
    /* JADX WARN: Type inference failed for: r4v67 */
    /* JADX WARN: Type inference failed for: r4v69, types: [java.lang.Throwable, r7.c] */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r4v73 */
    @Override // t7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r44) {
        /*
            Method dump skipped, instructions count: 1738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.c.k(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(LiveStreamActivity liveStreamActivity, r7.c cVar) {
        super(2, cVar);
        this.f1484m = 1;
        this.f1488q = liveStreamActivity;
    }
}
