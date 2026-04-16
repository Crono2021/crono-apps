package a0;

import android.animation.Animator;
import android.content.Context;
import android.media.AudioAttributes;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.emoji2.text.o;
import androidx.fragment.app.s0;
import androidx.fragment.app.v;
import b2.z;
import b6.i0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import d1.p;
import h4.n;
import h4.q;
import h4.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import n.c4;
import n0.a2;
import n0.c0;
import n0.d0;
import n0.r;
import n0.t0;
import n0.x1;
import o0.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements r, z2.f, j0.c, z, x, x4.a, e5.a, h4.r, b4.b {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7i;

    /* renamed from: j, reason: collision with root package name */
    public Object f8j;

    public b(int i9) {
        this.f7i = i9;
        switch (i9) {
            case 20:
                break;
            case 24:
                this.f8j = new h4.z(7);
                break;
            case 25:
                this.f8j = new n(500L);
                break;
            case 28:
                this.f8j = new b(25);
                break;
            default:
                this.f8j = new p(0);
                break;
        }
    }

    @Override // o0.x
    public boolean b(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f8j;
        if (!swipeDismissBehavior.s(view)) {
            return false;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        boolean z8 = d0.d(view) == 1;
        int i9 = swipeDismissBehavior.f1916d;
        t0.j(view, (!(i9 == 0 && z8) && (i9 != 1 || z8)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n0.r
    public a2 c(View view, a2 a2Var) {
        int i9 = 0;
        switch (this.f7i) {
            case 0:
                x1 x1Var = a2Var.f7139a;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f8j;
                if (!m0.a.a(coordinatorLayout.f562v, a2Var)) {
                    coordinatorLayout.f562v = a2Var;
                    boolean z8 = a2Var.d() > 0;
                    coordinatorLayout.f563w = z8;
                    coordinatorLayout.setWillNotDraw(!z8 && coordinatorLayout.getBackground() == null);
                    if (!x1Var.m()) {
                        int childCount = coordinatorLayout.getChildCount();
                        while (i9 < childCount) {
                            View childAt = coordinatorLayout.getChildAt(i9);
                            WeakHashMap weakHashMap = t0.f7209a;
                            if (!c0.b(childAt) || ((g) childAt.getLayoutParams()).f10a == null || !x1Var.m()) {
                                i9++;
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                    break;
                }
                break;
            default:
                AppBarLayout appBarLayout = (AppBarLayout) this.f8j;
                WeakHashMap weakHashMap2 = t0.f7209a;
                a2 a2Var2 = c0.b(appBarLayout) ? a2Var : null;
                if (!m0.a.a(appBarLayout.f1867o, a2Var2)) {
                    appBarLayout.f1867o = a2Var2;
                    if (appBarLayout.C != null && appBarLayout.getTopInset() > 0) {
                        i9 = 1;
                    }
                    appBarLayout.setWillNotDraw(i9 ^ 1);
                    appBarLayout.requestLayout();
                    break;
                }
                break;
        }
        return a2Var;
    }

    @Override // b2.z
    public void d(a3.i iVar) {
        iVar.g(((WindowManager) this.f8j).getDefaultDisplay());
    }

    public void e(int i9, boolean z8) {
        p pVar = (p) this.f8j;
        if (z8) {
            pVar.a(i9);
        } else {
            pVar.getClass();
        }
    }

    public void f() {
        ((v) this.f8j).f874r.I();
    }

    @Override // z2.f
    public int g(long j5) {
        return j5 < 0 ? 0 : -1;
    }

    @Override // x4.a
    public Object h() {
        switch (this.f7i) {
            case 17:
                i0 i0Var = (i0) this.f8j;
                return new d4.k((c.a) i0Var.f1399k, (x.c) i0Var.f1400l);
            default:
                c4 c4Var = (c4) this.f8j;
                return new d4.r((g4.e) c4Var.f6834a, (g4.e) c4Var.f6835b, (g4.e) c4Var.f6836c, (g4.e) c4Var.f6837d, (d4.n) c4Var.f6838e, (d4.n) c4Var.f6839f, (x.c) c4Var.f6840g);
        }
    }

    @Override // h4.r
    public q i(w wVar) {
        switch (this.f7i) {
            case 24:
                return new h4.c((h4.z) this.f8j, 1);
            default:
                return new i4.a((b) this.f8j);
        }
    }

    @Override // z2.f
    public long j(int i9) {
        g1.a.f(i9 == 0);
        return 0L;
    }

    public List k(CharSequence charSequence) {
        charSequence.getClass();
        a6.g gVar = new a6.g((b) this.f8j, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (gVar.hasNext()) {
            arrayList.add((String) gVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // j0.c
    public void onCancel() {
        switch (this.f7i) {
            case 5:
                ((Animator) this.f8j).end();
                break;
            default:
                ((s0) this.f8j).a();
                break;
        }
    }

    @Override // z2.f
    public List q(long j5) {
        return j5 >= 0 ? (List) this.f8j : Collections.EMPTY_LIST;
    }

    @Override // b4.b
    public boolean s(Object obj, File file, b4.i iVar) {
        InputStream inputStream = (InputStream) obj;
        e4.f fVar = (e4.f) this.f8j;
        byte[] bArr = (byte[]) fVar.d(65536, byte[].class);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (IOException e9) {
                        e = e9;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        fVar.h(bArr);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        fVar.h(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                fVar.h(bArr);
                return true;
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // z2.f
    public int u() {
        return 1;
    }

    @Override // b2.z
    public void a() {
    }

    public b(com.bumptech.glide.f fVar) {
        this.f7i = 12;
        this.f8j = Collections.unmodifiableMap(new HashMap(fVar.f1767a));
    }

    public b(Context context) {
        this.f7i = 21;
        this.f8j = new o(context, 2);
    }

    public b(d1.g gVar) {
        this.f7i = 14;
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(gVar.f2424a).setFlags(0).setUsage(1);
        int i9 = g1.w.f3713a;
        if (i9 >= 29) {
            d1.d.a(usage, 1);
        }
        if (i9 >= 32) {
            d1.f.a(usage, 0);
        }
        this.f8j = usage.build();
    }

    public b(Matcher matcher, String str) {
        this.f7i = 27;
        this.f8j = matcher;
    }

    public /* synthetic */ b(Object obj, int i9) {
        this.f7i = i9;
        this.f8j = obj;
    }
}
