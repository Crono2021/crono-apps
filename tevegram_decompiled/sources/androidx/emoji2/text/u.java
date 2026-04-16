package androidx.emoji2.text;

import android.util.SparseArray;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f659a;

    /* renamed from: b, reason: collision with root package name */
    public q f660b;

    public u(int i9) {
        this.f659a = new SparseArray(i9);
    }

    public final void a(q qVar, int i9, int i10) {
        int a9 = qVar.a(i9);
        SparseArray sparseArray = this.f659a;
        u uVar = sparseArray == null ? null : (u) sparseArray.get(a9);
        if (uVar == null) {
            uVar = new u(1);
            sparseArray.put(qVar.a(i9), uVar);
        }
        if (i10 > i9) {
            uVar.a(qVar, i9 + 1, i10);
        } else {
            uVar.f660b = qVar;
        }
    }
}
