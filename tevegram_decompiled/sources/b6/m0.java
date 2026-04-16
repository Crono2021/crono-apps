package b6;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m0 extends k1 {

    /* renamed from: i, reason: collision with root package name */
    public boolean f1418i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1419j;

    public m0(Object obj) {
        this.f1419j = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f1418i;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f1418i) {
            throw new NoSuchElementException();
        }
        this.f1418i = true;
        return this.f1419j;
    }
}
