package h8;

import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements g8.b {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f4225a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4226b;

    /* renamed from: c, reason: collision with root package name */
    public final n f4227c;

    public c(CharSequence charSequence, int i9, n nVar) {
        charSequence.getClass();
        this.f4225a = charSequence;
        this.f4226b = i9;
        this.f4227c = nVar;
    }

    @Override // g8.b
    public final Iterator iterator() {
        return new b(this);
    }
}
