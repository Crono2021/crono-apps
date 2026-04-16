package w3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l extends k {

    /* renamed from: a, reason: collision with root package name */
    public f0.f[] f9889a;

    /* renamed from: b, reason: collision with root package name */
    public String f9890b;

    /* renamed from: c, reason: collision with root package name */
    public int f9891c;

    public l(l lVar) {
        this.f9889a = null;
        this.f9891c = 0;
        this.f9890b = lVar.f9890b;
        this.f9889a = a.a.p(lVar.f9889a);
    }

    public f0.f[] getPathData() {
        return this.f9889a;
    }

    public String getPathName() {
        return this.f9890b;
    }

    public void setPathData(f0.f[] fVarArr) {
        if (!a.a.e(this.f9889a, fVarArr)) {
            this.f9889a = a.a.p(fVarArr);
            return;
        }
        f0.f[] fVarArr2 = this.f9889a;
        for (int i9 = 0; i9 < fVarArr.length; i9++) {
            fVarArr2[i9].f3198a = fVarArr[i9].f3198a;
            int i10 = 0;
            while (true) {
                float[] fArr = fVarArr[i9].f3199b;
                if (i10 < fArr.length) {
                    fVarArr2[i9].f3199b[i10] = fArr[i10];
                    i10++;
                }
            }
        }
    }

    public l() {
        this.f9889a = null;
        this.f9891c = 0;
    }
}
