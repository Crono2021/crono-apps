package g5;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3747i;

    /* renamed from: j, reason: collision with root package name */
    public int f3748j;

    public /* synthetic */ c(int i9, int i10) {
        this.f3747i = i10;
        this.f3748j = i9;
    }

    public static String b(int i9) {
        return "" + ((char) ((i9 >> 24) & 255)) + ((char) ((i9 >> 16) & 255)) + ((char) ((i9 >> 8) & 255)) + ((char) (i9 & 255));
    }

    public static int i(int i9) {
        return (i9 >> 24) & 255;
    }

    public void a(int i9) {
        this.f3748j = i9 | this.f3748j;
    }

    public boolean c(int i9) {
        return (this.f3748j & i9) == i9;
    }

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int h();

    public String toString() {
        switch (this.f3747i) {
            case 2:
                return b(this.f3748j);
            default:
                return super.toString();
        }
    }
}
