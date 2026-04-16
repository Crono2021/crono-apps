package z6;

import d1.k0;
import d4.i;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import v.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10675a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f10676b = StandardCharsets.ISO_8859_1;

    public static boolean a(int i9, y6.b bVar, int i10) {
        int i11 = bVar.f10531c;
        i iVar = bVar.f10530b[h.a(i10)];
        int i12 = iVar.f2851i;
        int i13 = 0;
        for (k0 k0Var : (k0[]) iVar.f2852j) {
            i13 += k0Var.f2492a;
        }
        return i11 - (i13 * i12) >= (i9 + 7) / 8;
    }
}
