package y1;

import d1.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final z0 f10483a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f10484b;

    public p(int i9, z0 z0Var, int[] iArr) {
        if (iArr.length == 0) {
            g1.a.q("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.f10483a = z0Var;
        this.f10484b = iArr;
    }
}
