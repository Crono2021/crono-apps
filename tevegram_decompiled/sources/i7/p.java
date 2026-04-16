package i7;

import com.network.tvgramplayer.data.HistoryItem;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends o3.o {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5013b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final Object f5014c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5015d;

    public p(List list, List list2) {
        list.getClass();
        this.f5014c = list;
        this.f5015d = list2;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, java.util.List] */
    @Override // o3.o
    public final boolean a(int i9, int i10) {
        switch (this.f5013b) {
            case 0:
                return b8.i.a(((List) this.f5014c).get(i9), ((List) this.f5015d).get(i10));
            default:
                h7.i0 i0Var = (h7.i0) ((g0) this.f5014c).f4865d.get(i9);
                h7.i0 i0Var2 = (h7.i0) this.f5015d.get(i10);
                return b8.i.a(i0Var.f4115c, i0Var2.f4115c) && i0Var.f4116d == i0Var2.f4116d && b8.i.a(i0Var.f4118f, i0Var2.f4118f);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.List] */
    @Override // o3.o
    public final boolean b(int i9, int i10) {
        switch (this.f5013b) {
            case 0:
                List list = (List) this.f5014c;
                long chatId = ((HistoryItem) list.get(i9)).getChatId();
                List list2 = (List) this.f5015d;
                if (chatId != ((HistoryItem) list2.get(i10)).getChatId() || !b8.i.a(((HistoryItem) list.get(i9)).getUrl(), ((HistoryItem) list2.get(i10)).getUrl())) {
                }
                break;
            default:
                if (((h7.i0) ((g0) this.f5014c).f4865d.get(i9)).f4114b == ((h7.i0) this.f5015d.get(i10)).f4114b) {
                }
                break;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.List] */
    @Override // o3.o
    public Object g(int i9, int i10) {
        switch (this.f5013b) {
            case 1:
                h7.i0 i0Var = (h7.i0) ((g0) this.f5014c).f4865d.get(i9);
                h7.i0 i0Var2 = (h7.i0) this.f5015d.get(i10);
                if (i0Var.f4116d == i0Var2.f4116d && b8.i.a(i0Var.f4115c, i0Var2.f4115c)) {
                    return null;
                }
                return Boolean.TRUE;
            default:
                return super.g(i9, i10);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.List] */
    @Override // o3.o
    public final int h() {
        switch (this.f5013b) {
            case 0:
                return ((List) this.f5015d).size();
            default:
                return this.f5015d.size();
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.List] */
    @Override // o3.o
    public final int i() {
        switch (this.f5013b) {
            case 0:
                return ((List) this.f5014c).size();
            default:
                return ((g0) this.f5014c).f4865d.size();
        }
    }

    public p(g0 g0Var, List list) {
        this.f5014c = g0Var;
        this.f5015d = list;
    }
}
