package s;

import b6.s;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class d extends h implements Map {

    /* renamed from: p, reason: collision with root package name */
    public s f8628p;

    /* renamed from: q, reason: collision with root package name */
    public b f8629q;

    /* renamed from: r, reason: collision with root package name */
    public o7.d f8630r;

    public d(d dVar) {
        i(dVar);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        s sVar = this.f8628p;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 2);
        this.f8628p = sVar2;
        return sVar2;
    }

    @Override // java.util.Map
    public final Set keySet() {
        b bVar = this.f8629q;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f8629q = bVar2;
        return bVar2;
    }

    public final Object[] m(int i9, Object[] objArr) {
        int i10 = this.f8653k;
        if (objArr.length < i10) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i10);
        }
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = this.f8652j[(i11 << 1) + i9];
        }
        if (objArr.length > i10) {
            objArr[i10] = null;
        }
        return objArr;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f8653k);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        o7.d dVar = this.f8630r;
        if (dVar != null) {
            return dVar;
        }
        o7.d dVar2 = new o7.d(this);
        this.f8630r = dVar2;
        return dVar2;
    }
}
