package b7;

import d1.r;
import d1.v;
import java.util.function.Predicate;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class j implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1504a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1505b;

    public /* synthetic */ j(Object obj, int i9) {
        this.f1504a = i9;
        this.f1505b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1504a) {
            case 0:
                return ((Boolean) ((i) this.f1505b).a(obj)).booleanValue();
            case 1:
                return ((Boolean) ((i) this.f1505b).a(obj)).booleanValue();
            default:
                return ((v) obj).f2582b.equals(((r) this.f1505b).f2519b);
        }
    }
}
