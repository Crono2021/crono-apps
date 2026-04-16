package o7;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class n extends m {
    public static void F0(ArrayList arrayList, a8.l lVar) {
        int size;
        int size2 = arrayList.size() - 1;
        int i9 = 0;
        if (size2 >= 0) {
            int i10 = 0;
            while (true) {
                Object obj = arrayList.get(i9);
                if (!((Boolean) lVar.a(obj)).booleanValue()) {
                    if (i10 != i9) {
                        arrayList.set(i10, obj);
                    }
                    i10++;
                }
                if (i9 == size2) {
                    break;
                } else {
                    i9++;
                }
            }
            i9 = i10;
        }
        if (i9 >= arrayList.size() || i9 > (size = arrayList.size() - 1)) {
            return;
        }
        while (true) {
            arrayList.remove(size);
            if (size == i9) {
                return;
            } else {
                size--;
            }
        }
    }
}
