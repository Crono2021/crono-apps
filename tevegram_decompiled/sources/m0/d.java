package m0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class d implements c {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6496i;

    /* renamed from: j, reason: collision with root package name */
    public final Object[] f6497j;

    /* renamed from: k, reason: collision with root package name */
    public int f6498k;

    public d(int i9) {
        this.f6496i = 0;
        if (i9 > 0) {
            this.f6497j = new Object[i9];
        } else {
            m7.c.n("The max pool size must be > 0");
            throw null;
        }
    }

    @Override // m0.c
    public boolean a(Object obj) {
        int i9 = 0;
        while (true) {
            int i10 = this.f6498k;
            Object[] objArr = this.f6497j;
            if (i9 >= i10) {
                if (i10 >= objArr.length) {
                    return false;
                }
                objArr[i10] = obj;
                this.f6498k = i10 + 1;
                return true;
            }
            if (objArr[i9] == obj) {
                m7.c.p("Already in the pool!");
                return false;
            }
            i9++;
        }
    }

    @Override // m0.c
    public Object b() {
        switch (this.f6496i) {
            case 0:
                int i9 = this.f6498k;
                if (i9 <= 0) {
                    return null;
                }
                int i10 = i9 - 1;
                Object[] objArr = this.f6497j;
                Object obj = objArr[i10];
                objArr[i10] = null;
                this.f6498k = i10;
                return obj;
            default:
                int i11 = this.f6498k;
                if (i11 <= 0) {
                    return null;
                }
                int i12 = i11 - 1;
                Object[] objArr2 = this.f6497j;
                Object obj2 = objArr2[i12];
                objArr2[i12] = null;
                this.f6498k = i12;
                return obj2;
        }
    }

    public void c(v.c cVar) {
        int i9 = this.f6498k;
        Object[] objArr = this.f6497j;
        if (i9 < objArr.length) {
            objArr[i9] = cVar;
            this.f6498k = i9 + 1;
        }
    }

    public d() {
        this.f6496i = 1;
        this.f6497j = new Object[256];
    }
}
