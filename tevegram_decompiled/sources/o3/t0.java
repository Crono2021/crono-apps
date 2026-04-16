package o3;

import android.util.SparseArray;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f7813a;

    /* renamed from: b, reason: collision with root package name */
    public int f7814b;

    /* renamed from: c, reason: collision with root package name */
    public Set f7815c;

    public final s0 a(int i9) {
        SparseArray sparseArray = this.f7813a;
        s0 s0Var = (s0) sparseArray.get(i9);
        if (s0Var != null) {
            return s0Var;
        }
        s0 s0Var2 = new s0();
        sparseArray.put(i9, s0Var2);
        return s0Var2;
    }
}
