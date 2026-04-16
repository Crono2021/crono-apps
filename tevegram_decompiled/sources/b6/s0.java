package b6;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s0 implements a6.h, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final int f1443i;

    public s0() {
        q.b(2, "expectedValuesPerKey");
        this.f1443i = 2;
    }

    @Override // a6.h
    public final Object get() {
        return new ArrayList(this.f1443i);
    }
}
