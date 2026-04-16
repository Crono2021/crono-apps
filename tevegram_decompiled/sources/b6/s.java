package b6;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s extends AbstractSet {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1441i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Map f1442j;

    public /* synthetic */ s(Map map, int i9) {
        this.f1441i = i9;
        this.f1442j = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f1441i) {
            case 0:
                ((u) this.f1442j).clear();
                break;
            case 1:
                ((u) this.f1442j).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        switch (this.f1441i) {
            case 0:
                u uVar = (u) this.f1442j;
                Map b9 = uVar.b();
                if (b9 != null) {
                    return b9.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int d9 = uVar.d(entry.getKey());
                    if (d9 != -1 && android.support.v4.media.session.b.G(uVar.j()[d9], entry.getValue())) {
                        return true;
                    }
                }
                return false;
            case 1:
                return ((u) this.f1442j).containsKey(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f1441i) {
            case 0:
                u uVar = (u) this.f1442j;
                Map b9 = uVar.b();
                return b9 != null ? b9.entrySet().iterator() : new r(uVar, 1);
            case 1:
                u uVar2 = (u) this.f1442j;
                Map b10 = uVar2.b();
                return b10 != null ? b10.keySet().iterator() : new r(uVar2, 0);
            default:
                return new s.c((s.d) this.f1442j);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        switch (this.f1441i) {
            case 0:
                u uVar = (u) this.f1442j;
                Map b9 = uVar.b();
                if (b9 != null) {
                    return b9.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!uVar.f()) {
                        int c9 = uVar.c();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object obj2 = uVar.f1451i;
                        Objects.requireNonNull(obj2);
                        int k3 = q.k(key, value, c9, obj2, uVar.h(), uVar.i(), uVar.j());
                        if (k3 != -1) {
                            uVar.e(k3, c9);
                            uVar.f1456n--;
                            uVar.f1455m += 32;
                            return true;
                        }
                    }
                }
                return false;
            case 1:
                u uVar2 = (u) this.f1442j;
                Map b10 = uVar2.b();
                return b10 != null ? b10.keySet().remove(obj) : uVar2.g(obj) != u.f1450r;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f1441i) {
            case 0:
                return ((u) this.f1442j).size();
            case 1:
                return ((u) this.f1442j).size();
            default:
                return ((s.d) this.f1442j).f8653k;
        }
    }
}
