package d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final m0.c f2939a;

    /* renamed from: b, reason: collision with root package name */
    public final List f2940b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2941c;

    public y(Class cls, Class cls2, Class cls3, List list, m0.c cVar) {
        this.f2939a = cVar;
        if (list.isEmpty()) {
            m7.c.n("Must not be empty.");
            throw null;
        }
        this.f2940b = list;
        this.f2941c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final a0 a(int i9, int i10, b4.i iVar, com.bumptech.glide.load.data.g gVar, i iVar2) {
        m0.c cVar = this.f2939a;
        Object b9 = cVar.b();
        w4.f.c(b9, "Argument must not be null");
        List list = (List) b9;
        try {
            List list2 = this.f2940b;
            int size = list2.size();
            a0 a0Var = null;
            for (int i11 = 0; i11 < size; i11++) {
                try {
                    a0Var = ((l) list2.get(i11)).a(i9, i10, iVar, gVar, iVar2);
                } catch (w e9) {
                    list.add(e9);
                }
                if (a0Var != null) {
                    break;
                }
            }
            if (a0Var != null) {
                return a0Var;
            }
            throw new w(this.f2941c, new ArrayList(list));
        } finally {
            cVar.a(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f2940b.toArray()) + '}';
    }
}
