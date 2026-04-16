package d4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2853a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2854b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2855c;

    public n1.l a() {
        if (this.f2853a || !(this.f2854b || this.f2855c)) {
            return new n1.l(this);
        }
        m7.c.p("Secondary offload attribute fields are true but primary isFormatSupported is false");
        return null;
    }

    public boolean b() {
        return (this.f2855c || this.f2854b) && this.f2853a;
    }
}
