package v0;

import android.graphics.Rect;
import java.util.Comparator;
import o0.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Comparator {

    /* renamed from: i, reason: collision with root package name */
    public final Rect f9208i = new Rect();

    /* renamed from: j, reason: collision with root package name */
    public final Rect f9209j = new Rect();

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9210k;

    /* renamed from: l, reason: collision with root package name */
    public final o4.d f9211l;

    public c(boolean z8, o4.d dVar) {
        this.f9210k = z8;
        this.f9211l = dVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f9211l.getClass();
        Rect rect = this.f9208i;
        ((l) obj).f(rect);
        Rect rect2 = this.f9209j;
        ((l) obj2).f(rect2);
        int i9 = rect.top;
        int i10 = rect2.top;
        if (i9 < i10) {
            return -1;
        }
        if (i9 > i10) {
            return 1;
        }
        int i11 = rect.left;
        int i12 = rect2.left;
        boolean z8 = this.f9210k;
        if (i11 < i12) {
            return z8 ? 1 : -1;
        }
        if (i11 > i12) {
            return z8 ? -1 : 1;
        }
        int i13 = rect.bottom;
        int i14 = rect2.bottom;
        if (i13 < i14) {
            return -1;
        }
        if (i13 > i14) {
            return 1;
        }
        int i15 = rect.right;
        int i16 = rect2.right;
        if (i15 < i16) {
            return z8 ? 1 : -1;
        }
        if (i15 > i16) {
            return z8 ? -1 : 1;
        }
        return 0;
    }
}
