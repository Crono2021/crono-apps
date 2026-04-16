package z2;

import d1.s;
import d2.u;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f10614b = new c(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10615a;

    public /* synthetic */ c(int i9) {
        this.f10615a = i9;
    }

    public final l a(s sVar) {
        l iVar;
        switch (this.f10615a) {
            case 0:
                String str = sVar.f2554m;
                List list = sVar.f2556o;
                if (str != null) {
                    switch (str) {
                        case "application/dvbsubs":
                            iVar = new b3.i(list);
                            break;
                        case "application/pgs":
                            return new a0.l(4);
                        case "application/x-mp4-vtt":
                            return new u(1);
                        case "text/vtt":
                            return new a5.d(17);
                        case "application/x-quicktime-tx3g":
                            iVar = new g3.a(list);
                            break;
                        case "text/x-ssa":
                            iVar = new d3.b(list);
                            break;
                        case "application/x-subrip":
                            return new e3.a();
                        case "application/ttml+xml":
                            return new f3.e();
                    }
                    return iVar;
                }
                m7.c.n(t.a.b("Unsupported MIME type: ", str));
                return null;
            default:
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
        }
    }

    public final boolean b(s sVar) {
        switch (this.f10615a) {
            case 0:
                String str = sVar.f2554m;
                return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
            default:
                return false;
        }
    }
}
