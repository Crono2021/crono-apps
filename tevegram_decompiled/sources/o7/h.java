package o7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h extends n {
    public static double G0(Iterable iterable) {
        Iterator it = iterable.iterator();
        double d9 = 0.0d;
        int i9 = 0;
        while (it.hasNext()) {
            d9 += ((Number) it.next()).floatValue();
            i9++;
            if (i9 < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        if (i9 == 0) {
            return Double.NaN;
        }
        return d9 / i9;
    }

    public static Object H0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object I0(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static String J0(Collection collection, a8.l lVar, int i9) {
        String str = (i9 & 2) != 0 ? "" : "[";
        String str2 = (i9 & 4) == 0 ? "]" : "";
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        int i10 = 0;
        for (Object obj : collection) {
            i10++;
            if (i10 > 1) {
                sb.append((CharSequence) ", ");
            }
            sb.append((CharSequence) lVar.a(obj));
        }
        sb.append((CharSequence) str2);
        return sb.toString();
    }

    public static Object K0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(list.size() - 1);
    }

    public static Object L0(List list) {
        c8.a aVar = c8.e.f1727i;
        if (list.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return list.get(c8.e.f1727i.e(list.size()));
    }

    public static List M0(ArrayList arrayList) {
        if (arrayList.size() <= 1) {
            return Q0(arrayList);
        }
        List R0 = R0(arrayList);
        Collections.reverse(R0);
        return R0;
    }

    public static List N0(Collection collection) {
        if (collection.size() <= 1) {
            return Q0(collection);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        comparableArr.getClass();
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        array.getClass();
        List asList = Arrays.asList(array);
        asList.getClass();
        return asList;
    }

    public static List O0(Iterable iterable, Comparator comparator) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List R0 = R0(iterable);
            if (((ArrayList) R0).size() > 1) {
                Collections.sort(R0, comparator);
            }
            return R0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return Q0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        array.getClass();
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List asList = Arrays.asList(array);
        asList.getClass();
        return asList;
    }

    public static List P0(int i9, List list) {
        if (i9 < 0) {
            h7.o.d("Requested element count ", i9, " is less than zero.");
            return null;
        }
        p pVar = p.f8013i;
        if (i9 == 0) {
            return pVar;
        }
        if (i9 >= list.size()) {
            return Q0(list);
        }
        if (i9 == 1) {
            return android.support.v4.media.session.b.b0(H0(list));
        }
        ArrayList arrayList = new ArrayList(i9);
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i10++;
            if (i10 == i9) {
                break;
            }
        }
        int size = arrayList.size();
        return size != 0 ? size != 1 ? arrayList : android.support.v4.media.session.b.b0(arrayList.get(0)) : pVar;
    }

    public static List Q0(Iterable iterable) {
        iterable.getClass();
        boolean z8 = iterable instanceof Collection;
        p pVar = p.f8013i;
        if (!z8) {
            List R0 = R0(iterable);
            ArrayList arrayList = (ArrayList) R0;
            int size = arrayList.size();
            return size != 0 ? size != 1 ? R0 : android.support.v4.media.session.b.b0(arrayList.get(0)) : pVar;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return pVar;
        }
        if (size2 != 1) {
            return new ArrayList(collection);
        }
        return android.support.v4.media.session.b.b0(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List R0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
