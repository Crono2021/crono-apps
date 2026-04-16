package d4;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2874a;

    /* renamed from: b, reason: collision with root package name */
    public final List f2875b;

    /* renamed from: c, reason: collision with root package name */
    public final p4.a f2876c;

    /* renamed from: d, reason: collision with root package name */
    public final m0.c f2877d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2878e;

    public l(Class cls, Class cls2, Class cls3, List list, p4.a aVar, x.c cVar) {
        this.f2874a = cls;
        this.f2875b = list;
        this.f2876c = aVar;
        this.f2877d = cVar;
        this.f2878e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b7, code lost:
    
        if (r0 == 3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bc, code lost:
    
        if (r2 != 2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b9, code lost:
    
        if (r0 == 1) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d4.a0 a(int r17, int r18, b4.i r19, com.bumptech.glide.load.data.g r20, d4.i r21) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.l.a(int, int, b4.i, com.bumptech.glide.load.data.g, d4.i):d4.a0");
    }

    public final a0 b(com.bumptech.glide.load.data.g gVar, int i9, int i10, b4.i iVar, List list) {
        List list2 = this.f2875b;
        int size = list2.size();
        a0 a0Var = null;
        for (int i11 = 0; i11 < size; i11++) {
            b4.k kVar = (b4.k) list2.get(i11);
            try {
                if (kVar.b(gVar.a(), iVar)) {
                    a0Var = kVar.a(gVar.a(), i9, i10, iVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e9) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + kVar, e9);
                }
                list.add(e9);
            }
            if (a0Var != null) {
                break;
            }
        }
        if (a0Var != null) {
            return a0Var;
        }
        throw new w(this.f2878e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f2874a + ", decoders=" + this.f2875b + ", transcoder=" + this.f2876c + '}';
    }
}
