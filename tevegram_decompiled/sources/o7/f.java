package o7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f extends a.a {
    public static final void Z(int i9, int i10, int i11, Object[] objArr, Object[] objArr2) {
        objArr.getClass();
        objArr2.getClass();
        System.arraycopy(objArr, i10, objArr2, i9, i11 - i10);
    }

    public static final void a0(Object[] objArr, a6.d dVar, int i9, int i10) {
        objArr.getClass();
        Arrays.fill(objArr, i9, i10, dVar);
    }

    public static int b0(Object[] objArr, Object obj) {
        objArr.getClass();
        int i9 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i9 < length) {
                if (objArr[i9] == null) {
                    return i9;
                }
                i9++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i9 < length2) {
            if (obj.equals(objArr[i9])) {
                return i9;
            }
            i9++;
        }
        return -1;
    }

    public static List c0(float[] fArr, e8.c cVar) {
        fArr.getClass();
        if (cVar.isEmpty()) {
            return p.f8013i;
        }
        int i9 = cVar.f3158i;
        int i10 = cVar.f3159j + 1;
        int length = fArr.length;
        if (i10 <= length) {
            float[] copyOfRange = Arrays.copyOfRange(fArr, i9, i10);
            copyOfRange.getClass();
            return new g(copyOfRange);
        }
        throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + length + ").");
    }

    public static List d0(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new d(objArr)) : android.support.v4.media.session.b.b0(objArr[0]) : p.f8013i;
    }
}
