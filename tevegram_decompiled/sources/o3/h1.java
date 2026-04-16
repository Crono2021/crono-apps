package o3;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    public int f7669a;

    /* renamed from: b, reason: collision with root package name */
    public int f7670b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7671c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7672d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7673e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f7674f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f7675g;

    public h1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f7675g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f7669a = -1;
        this.f7670b = Integer.MIN_VALUE;
        this.f7671c = false;
        this.f7672d = false;
        this.f7673e = false;
        int[] iArr = this.f7674f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
