package b6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class q {
    public static void a(int i9, Object[] objArr) {
        for (int i10 = 0; i10 < i9; i10++) {
            if (objArr[i10] == null) {
                m7.c.o(androidx.activity.g.m(i10, "at index "));
                return;
            }
        }
    }

    public static void b(int i9, String str) {
        if (i9 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i9);
    }

    public static Object c(int i9) {
        if (i9 >= 2 && i9 <= 1073741824 && Integer.highestOneBit(i9) == i9) {
            return i9 <= 256 ? new byte[i9] : i9 <= 65536 ? new short[i9] : new int[i9];
        }
        m7.c.n(androidx.activity.g.m(i9, "must be power of 2 between 2^1 and 2^30: "));
        return null;
    }

    public static boolean d(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static boolean e(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
                return set.containsAll(set2);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static f1 f(Set set, a6.e eVar) {
        if (set instanceof SortedSet) {
            Set set2 = (SortedSet) set;
            if (!(set2 instanceof f1)) {
                return new g1(set2, eVar);
            }
            f1 f1Var = (f1) set2;
            a6.e eVar2 = f1Var.f1389j;
            eVar2.getClass();
            return new g1((SortedSet) f1Var.f1388i, new a6.f(Arrays.asList(eVar2, eVar)));
        }
        if (!(set instanceof f1)) {
            set.getClass();
            return new f1(set, eVar);
        }
        f1 f1Var2 = (f1) set;
        a6.e eVar3 = f1Var2.f1389j;
        eVar3.getClass();
        return new f1(f1Var2.f1388i, new a6.f(Arrays.asList(eVar3, eVar)));
    }

    public static Object g(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return list.get(list.size() - 1);
        }
        Iterator it = iterable.iterator();
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static int h(Set set) {
        Iterator it = set.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i9 = ~(~(i9 + (next != null ? next.hashCode() : 0)));
        }
        return i9;
    }

    public static e1 i(Set set, k0 k0Var) {
        if (set == null) {
            m7.c.o("set1");
            return null;
        }
        if (k0Var != null) {
            return new e1(set, k0Var);
        }
        m7.c.o("set2");
        return null;
    }

    public static int j(int i9, int i10, int i11) {
        return (i9 & (~i11)) | (i10 & i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        r9 = r6 & r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        if (r5 != (-1)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        p(r1, r9, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        r13[r5] = j(r13[r5], r9, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int k(java.lang.Object r9, java.lang.Object r10, int r11, java.lang.Object r12, int[] r13, java.lang.Object[] r14, java.lang.Object[] r15) {
        /*
            int r0 = n(r9)
            r1 = r0 & r11
            int r2 = o(r1, r12)
            r3 = -1
            if (r2 != 0) goto Le
            goto L40
        Le:
            int r4 = ~r11
            r0 = r0 & r4
            r5 = -1
        L11:
            int r2 = r2 + (-1)
            r6 = r13[r2]
            r7 = r6 & r4
            if (r7 != r0) goto L3c
            r7 = r14[r2]
            boolean r7 = android.support.v4.media.session.b.G(r9, r7)
            if (r7 == 0) goto L3c
            if (r15 == 0) goto L2b
            r7 = r15[r2]
            boolean r7 = android.support.v4.media.session.b.G(r10, r7)
            if (r7 == 0) goto L3c
        L2b:
            r9 = r6 & r11
            if (r5 != r3) goto L33
            p(r1, r9, r12)
            return r2
        L33:
            r10 = r13[r5]
            int r9 = j(r10, r9, r11)
            r13[r5] = r9
            return r2
        L3c:
            r5 = r6 & r11
            if (r5 != 0) goto L41
        L40:
            return r3
        L41:
            r8 = r5
            r5 = r2
            r2 = r8
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.q.k(java.lang.Object, java.lang.Object, int, java.lang.Object, int[], java.lang.Object[], java.lang.Object[]):int");
    }

    public static void l(List list, a6.e eVar, int i9, int i10) {
        for (int size = list.size() - 1; size > i10; size--) {
            if (eVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i11 = i10 - 1; i11 >= i9; i11--) {
            list.remove(i11);
        }
    }

    public static int m(int i9) {
        return (int) (Integer.rotateLeft((int) (i9 * (-862048943)), 15) * 461845907);
    }

    public static int n(Object obj) {
        return m(obj == null ? 0 : obj.hashCode());
    }

    public static int o(int i9, Object obj) {
        return obj instanceof byte[] ? ((byte[]) obj)[i9] & 255 : obj instanceof short[] ? ((short[]) obj)[i9] & 65535 : ((int[]) obj)[i9];
    }

    public static void p(int i9, int i10, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i9] = (byte) i10;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i9] = (short) i10;
        } else {
            ((int[]) obj)[i9] = i10;
        }
    }
}
