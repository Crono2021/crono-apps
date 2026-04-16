package b6;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class j extends e implements SortedSet {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ t0 f1402k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(t0 t0Var, SortedMap sortedMap) {
        super(t0Var, sortedMap);
        this.f1402k = t0Var;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return f().comparator();
    }

    public SortedMap f() {
        return (SortedMap) this.f1377i;
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return f().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new j(this.f1402k, f().headMap(obj));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return f().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new j(this.f1402k, f().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new j(this.f1402k, f().tailMap(obj));
    }
}
