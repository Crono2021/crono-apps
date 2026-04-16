package b6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1392a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1393b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1394c;

    public h0(Object obj, Object obj2, Object obj3) {
        this.f1392a = obj;
        this.f1393b = obj2;
        this.f1394c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f1392a;
        sb.append(obj);
        sb.append("=");
        sb.append(this.f1393b);
        sb.append(" and ");
        sb.append(obj);
        sb.append("=");
        sb.append(this.f1394c);
        return new IllegalArgumentException(sb.toString());
    }
}
