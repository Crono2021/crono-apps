package androidx.activity;

import androidx.fragment.app.a0;
import java.util.ListIterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends b8.j implements a8.l {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f313j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x f314k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(x xVar, int i9) {
        super(1);
        this.f313j = i9;
        this.f314k = xVar;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        Object obj2;
        Object obj3;
        switch (this.f313j) {
            case 0:
                ((b) obj).getClass();
                x xVar = this.f314k;
                o7.e eVar = xVar.f355b;
                ListIterator listIterator = eVar.listIterator(eVar.f8010k);
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj2 = listIterator.previous();
                        if (((a0) obj2).f674a) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                xVar.f356c = (a0) obj2;
                break;
            default:
                ((b) obj).getClass();
                o7.e eVar2 = this.f314k.f355b;
                ListIterator listIterator2 = eVar2.listIterator(eVar2.f8010k);
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        obj3 = listIterator2.previous();
                        if (((a0) obj3).f674a) {
                        }
                    } else {
                        obj3 = null;
                    }
                }
                break;
        }
        return n7.g.f7490c;
    }
}
