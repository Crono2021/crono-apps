package h4;

import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w {

    /* renamed from: e, reason: collision with root package name */
    public static final z f4016e = new z(10);

    /* renamed from: f, reason: collision with root package name */
    public static final a0 f4017f = new a0(2);

    /* renamed from: d, reason: collision with root package name */
    public final x.c f4021d;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4018a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f4020c = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final z f4019b = f4016e;

    public w(x.c cVar) {
        this.f4021d = cVar;
    }

    public final synchronized void a(Class cls, Class cls2, r rVar) {
        v vVar = new v(cls, cls2, rVar);
        ArrayList arrayList = this.f4018a;
        arrayList.add(arrayList.size(), vVar);
    }

    public final synchronized q b(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f4018a;
            int size = arrayList2.size();
            boolean z8 = false;
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList2.get(i9);
                i9++;
                v vVar = (v) obj;
                if (this.f4020c.contains(vVar)) {
                    z8 = true;
                } else if (vVar.f4013a.isAssignableFrom(cls) && vVar.f4014b.isAssignableFrom(cls2)) {
                    this.f4020c.add(vVar);
                    arrayList.add(vVar.f4015c.i(this));
                    this.f4020c.remove(vVar);
                }
            }
            if (arrayList.size() > 1) {
                z zVar = this.f4019b;
                x.c cVar = this.f4021d;
                zVar.getClass();
                return new b(arrayList, 2, cVar);
            }
            if (arrayList.size() == 1) {
                return (q) arrayList.get(0);
            }
            if (z8) {
                return f4017f;
            }
            throw new com.bumptech.glide.h("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            this.f4020c.clear();
            throw th;
        }
    }

    public final synchronized ArrayList c(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            ArrayList arrayList2 = this.f4018a;
            int size = arrayList2.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList2.get(i9);
                i9++;
                v vVar = (v) obj;
                if (!this.f4020c.contains(vVar) && vVar.f4013a.isAssignableFrom(cls)) {
                    this.f4020c.add(vVar);
                    arrayList.add(vVar.f4015c.i(this));
                    this.f4020c.remove(vVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized ArrayList d(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f4018a;
        int size = arrayList2.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList2.get(i9);
            i9++;
            v vVar = (v) obj;
            if (!arrayList.contains(vVar.f4014b) && vVar.f4013a.isAssignableFrom(cls)) {
                arrayList.add(vVar.f4014b);
            }
        }
        return arrayList;
    }
}
