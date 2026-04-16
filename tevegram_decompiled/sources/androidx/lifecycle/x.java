package androidx.lifecycle;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class x {

    /* renamed from: i, reason: collision with root package name */
    public final a0.b f950i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f951j;

    /* renamed from: k, reason: collision with root package name */
    public int f952k = -1;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ y f953l;

    public x(y yVar, a0.b bVar) {
        this.f953l = yVar;
        this.f950i = bVar;
    }

    public final void c(boolean z8) {
        if (z8 == this.f951j) {
            return;
        }
        this.f951j = z8;
        int i9 = z8 ? 1 : -1;
        y yVar = this.f953l;
        int i10 = yVar.f957c;
        yVar.f957c = i9 + i10;
        if (!yVar.f958d) {
            yVar.f958d = true;
            while (true) {
                try {
                    int i11 = yVar.f957c;
                    if (i10 == i11) {
                        break;
                    } else {
                        i10 = i11;
                    }
                } finally {
                    yVar.f958d = false;
                }
            }
        }
        if (this.f951j) {
            yVar.c(this);
        }
    }

    public abstract boolean e();

    public void d() {
    }
}
