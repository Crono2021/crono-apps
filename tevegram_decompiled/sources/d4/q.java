package d4;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q implements Iterable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2895i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f2896j;

    public /* synthetic */ q(Object obj, int i9) {
        this.f2895i = i9;
        this.f2896j = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f2895i) {
            case 0:
                return ((ArrayList) this.f2896j).iterator();
            default:
                return new h8.b((h8.c) this.f2896j);
        }
    }
}
