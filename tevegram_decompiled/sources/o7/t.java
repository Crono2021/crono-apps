package o7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class t extends com.bumptech.glide.c {
    public static int b0(int i9) {
        if (i9 < 0) {
            return i9;
        }
        if (i9 < 3) {
            return i9 + 1;
        }
        if (i9 < 1073741824) {
            return (int) ((i9 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map c0(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return q.f8014i;
        }
        int i9 = 0;
        if (size == 1) {
            n7.b bVar = (n7.b) arrayList.get(0);
            bVar.getClass();
            Map singletonMap = Collections.singletonMap(bVar.f7480i, bVar.f7481j);
            singletonMap.getClass();
            return singletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(b0(arrayList.size()));
        int size2 = arrayList.size();
        while (i9 < size2) {
            Object obj = arrayList.get(i9);
            i9++;
            n7.b bVar2 = (n7.b) obj;
            linkedHashMap.put(bVar2.f7480i, bVar2.f7481j);
        }
        return linkedHashMap;
    }
}
