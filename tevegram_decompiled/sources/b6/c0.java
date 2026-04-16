package b6;

import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 extends m implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final Object f1363i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f1364j;

    public c0(Object obj, Object obj2) {
        this.f1363i = obj;
        this.f1364j = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1363i;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1364j;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
