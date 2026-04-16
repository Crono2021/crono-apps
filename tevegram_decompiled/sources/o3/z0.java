package o3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public int f7868a;

    /* renamed from: b, reason: collision with root package name */
    public int f7869b;

    /* renamed from: c, reason: collision with root package name */
    public int f7870c;

    /* renamed from: d, reason: collision with root package name */
    public int f7871d;

    /* renamed from: e, reason: collision with root package name */
    public int f7872e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7873f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7874g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7875i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7876j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7877k;

    /* renamed from: l, reason: collision with root package name */
    public int f7878l;

    /* renamed from: m, reason: collision with root package name */
    public long f7879m;

    /* renamed from: n, reason: collision with root package name */
    public int f7880n;

    public final void a(int i9) {
        if ((this.f7871d & i9) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i9) + " but it is " + Integer.toBinaryString(this.f7871d));
    }

    public final int b() {
        return this.f7874g ? this.f7869b - this.f7870c : this.f7872e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f7868a + ", mData=null, mItemCount=" + this.f7872e + ", mIsMeasuring=" + this.f7875i + ", mPreviousLayoutItemCount=" + this.f7869b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f7870c + ", mStructureChanged=" + this.f7873f + ", mInPreLayout=" + this.f7874g + ", mRunSimpleAnimations=" + this.f7876j + ", mRunPredictiveAnimations=" + this.f7877k + '}';
    }
}
