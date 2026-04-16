package n0;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public int f7131a;

    /* renamed from: b, reason: collision with root package name */
    public int f7132b;

    /* renamed from: c, reason: collision with root package name */
    public int f7133c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7134d;

    public a0() {
        if (o4.d.f7900j == null) {
            o4.d.f7900j = new o4.d(18);
        }
    }

    public int a(int i9) {
        if (i9 < this.f7133c) {
            return ((ByteBuffer) this.f7134d).getShort(this.f7132b + i9);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, Object obj);

    public void d(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.f7132b) {
            c(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f7132b) {
            tag = b(view);
        } else {
            tag = view.getTag(this.f7131a);
            if (!((Class) this.f7134d).isInstance(tag)) {
                tag = null;
            }
        }
        if (e(tag, obj)) {
            View.AccessibilityDelegate c9 = t0.c(view);
            c cVar = c9 == null ? null : c9 instanceof a ? ((a) c9).f7130a : new c(c9);
            if (cVar == null) {
                cVar = new c();
            }
            t0.p(view, cVar);
            view.setTag(this.f7131a, obj);
            t0.i(view, this.f7133c);
        }
    }

    public abstract boolean e(Object obj, Object obj2);
}
