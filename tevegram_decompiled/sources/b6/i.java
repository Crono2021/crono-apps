package b6;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class i extends d implements SortedMap {

    /* renamed from: m, reason: collision with root package name */
    public SortedSet f1395m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ t0 f1396n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(t0 t0Var, SortedMap sortedMap) {
        super(t0Var, sortedMap);
        this.f1396n = t0Var;
    }

    public SortedSet b() {
        return new j(this.f1396n, d());
    }

    @Override // b6.d, java.util.AbstractMap, java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.f1395m;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet b9 = b();
        this.f1395m = b9;
        return b9;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return d().comparator();
    }

    public SortedMap d() {
        return (SortedMap) this.f1374k;
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return d().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new i(this.f1396n, d().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return d().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new i(this.f1396n, d().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new i(this.f1396n, d().tailMap(obj));
    }
}
