package b6;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b1 implements Map, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public static final b1 f1352o = new b1(null, new Object[0], 0);

    /* renamed from: i, reason: collision with root package name */
    public transient y0 f1353i;

    /* renamed from: j, reason: collision with root package name */
    public transient z0 f1354j;

    /* renamed from: k, reason: collision with root package name */
    public transient a1 f1355k;

    /* renamed from: l, reason: collision with root package name */
    public final transient Object f1356l;

    /* renamed from: m, reason: collision with root package name */
    public final transient Object[] f1357m;

    /* renamed from: n, reason: collision with root package name */
    public final transient int f1358n;

    public b1(Object obj, Object[] objArr, int i9) {
        this.f1356l = obj;
        this.f1357m = objArr;
        this.f1358n = i9;
    }

    public static b1 a(Map map) {
        if ((map instanceof b1) && !(map instanceof SortedMap)) {
            return (b1) map;
        }
        Set<Map.Entry> entrySet = map.entrySet();
        boolean z8 = entrySet != null;
        i0 i0Var = new i0(z8 ? entrySet.size() : 4);
        if (z8) {
            int size = entrySet.size() * 2;
            Object[] objArr = (Object[]) i0Var.f1399k;
            if (size > objArr.length) {
                i0Var.f1399k = Arrays.copyOf(objArr, a0.d(objArr.length, size));
            }
        }
        for (Map.Entry entry : entrySet) {
            i0Var.g(entry.getKey(), entry.getValue());
        }
        return i0Var.a();
    }

    @Override // java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final k0 entrySet() {
        y0 y0Var = this.f1353i;
        if (y0Var != null) {
            return y0Var;
        }
        y0 y0Var2 = new y0(this, this.f1357m, this.f1358n);
        this.f1353i = y0Var2;
        return y0Var2;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        a1 a1Var = this.f1355k;
        if (a1Var == null) {
            a1Var = new a1(this.f1357m, 1, this.f1358n);
            this.f1355k = a1Var;
        }
        return a1Var.contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return q.d(this, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009f A[RETURN] */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L6
        L3:
            r9 = r0
            goto L9c
        L6:
            java.lang.Object[] r1 = r8.f1357m
            int r2 = r8.f1358n
            r3 = 1
            if (r2 != r3) goto L20
            r2 = 0
            r2 = r1[r2]
            java.util.Objects.requireNonNull(r2)
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L3
            r9 = r1[r3]
            java.util.Objects.requireNonNull(r9)
            goto L9c
        L20:
            java.lang.Object r2 = r8.f1356l
            if (r2 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L50
            r4 = r2
            byte[] r4 = (byte[]) r4
            int r2 = r4.length
            int r5 = r2 + (-1)
            int r2 = r9.hashCode()
            int r2 = b6.q.m(r2)
        L37:
            r2 = r2 & r5
            r6 = r4[r2]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L40
            goto L3
        L40:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L4d
            r9 = r6 ^ 1
            r9 = r1[r9]
            goto L9c
        L4d:
            int r2 = r2 + 1
            goto L37
        L50:
            boolean r4 = r2 instanceof short[]
            if (r4 == 0) goto L7c
            r4 = r2
            short[] r4 = (short[]) r4
            int r2 = r4.length
            int r5 = r2 + (-1)
            int r2 = r9.hashCode()
            int r2 = b6.q.m(r2)
        L62:
            r2 = r2 & r5
            short r6 = r4[r2]
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            if (r6 != r7) goto L6c
            goto L3
        L6c:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L79
            r9 = r6 ^ 1
            r9 = r1[r9]
            goto L9c
        L79:
            int r2 = r2 + 1
            goto L62
        L7c:
            int[] r2 = (int[]) r2
            int r4 = r2.length
            int r4 = r4 - r3
            int r5 = r9.hashCode()
            int r5 = b6.q.m(r5)
        L88:
            r5 = r5 & r4
            r6 = r2[r5]
            r7 = -1
            if (r6 != r7) goto L90
            goto L3
        L90:
            r7 = r1[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto La0
            r9 = r6 ^ 1
            r9 = r1[r9]
        L9c:
            if (r9 != 0) goto L9f
            return r0
        L9f:
            return r9
        La0:
            int r5 = r5 + 1
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.b1.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return q.h(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        z0 z0Var = this.f1354j;
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(this, new a1(this.f1357m, 0, this.f1358n));
        this.f1354j = z0Var2;
        return z0Var2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f1358n;
    }

    public final String toString() {
        int i9 = this.f1358n;
        q.b(i9, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(i9 * 8, IjkMediaMeta.AV_CH_STEREO_RIGHT));
        sb.append('{');
        k1 it = ((y0) entrySet()).iterator();
        boolean z8 = true;
        while (true) {
            e0 e0Var = (e0) it;
            if (!e0Var.hasNext()) {
                sb.append('}');
                return sb.toString();
            }
            Map.Entry entry = (Map.Entry) e0Var.next();
            if (!z8) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z8 = false;
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        a1 a1Var = this.f1355k;
        if (a1Var != null) {
            return a1Var;
        }
        a1 a1Var2 = new a1(this.f1357m, 1, this.f1358n);
        this.f1355k = a1Var2;
        return a1Var2;
    }
}
