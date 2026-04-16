package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f895a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f896b;

    public a(HashMap hashMap) {
        this.f896b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            l lVar = (l) entry.getValue();
            List list = (List) this.f895a.get(lVar);
            if (list == null) {
                list = new ArrayList();
                this.f895a.put(lVar, list);
            }
            list.add((b) entry.getKey());
        }
    }

    public static void a(List list, s sVar, l lVar, r rVar) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                b bVar = (b) list.get(size);
                Method method = bVar.f898b;
                try {
                    int i9 = bVar.f897a;
                    if (i9 == 0) {
                        method.invoke(rVar, null);
                    } else if (i9 == 1) {
                        method.invoke(rVar, sVar);
                    } else if (i9 == 2) {
                        method.invoke(rVar, sVar, lVar);
                    }
                } catch (IllegalAccessException e9) {
                    throw new RuntimeException(e9);
                } catch (InvocationTargetException e10) {
                    m7.c.k("Failed to call observer method", e10.getCause());
                    return;
                }
            }
        }
    }
}
