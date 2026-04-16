package n;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.CompoundButton;
import android.widget.TextView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public Parcelable f7025a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7026b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7027c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7028d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7029e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f7030f;

    public /* synthetic */ s(TextView textView) {
        this.f7025a = null;
        this.f7026b = null;
        this.f7027c = false;
        this.f7028d = false;
        this.f7030f = textView;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f7030f;
        Drawable t8 = com.bumptech.glide.c.t(compoundButton);
        if (t8 != null) {
            if (this.f7027c || this.f7028d) {
                Drawable mutate = com.bumptech.glide.d.f0(t8).mutate();
                if (this.f7027c) {
                    g0.b.h(mutate, (ColorStateList) this.f7025a);
                }
                if (this.f7028d) {
                    g0.b.i(mutate, (PorterDuff.Mode) this.f7026b);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    public void b() {
        r rVar = (r) this.f7030f;
        Drawable checkMarkDrawable = rVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f7027c || this.f7028d) {
                Drawable mutate = com.bumptech.glide.d.f0(checkMarkDrawable).mutate();
                if (this.f7027c) {
                    g0.b.h(mutate, (ColorStateList) this.f7025a);
                }
                if (this.f7028d) {
                    g0.b.i(mutate, (PorterDuff.Mode) this.f7026b);
                }
                if (mutate.isStateful()) {
                    mutate.setState(rVar.getDrawableState());
                }
                rVar.setCheckMarkDrawable(mutate);
            }
        }
    }

    public Bundle c(String str) {
        if (!this.f7028d) {
            m7.c.p("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
            return null;
        }
        Bundle bundle = (Bundle) this.f7025a;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.f7025a;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.f7025a;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f7025a = null;
        return bundle2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:8:0x002f, B:9:0x0055, B:11:0x005c, B:12:0x0063, B:14:0x006a, B:21:0x003e, B:23:0x0044, B:25:0x004a), top: B:2:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:8:0x002f, B:9:0x0055, B:11:0x005c, B:12:0x0063, B:14:0x006a, B:21:0x003e, B:23:0x0044, B:25:0x004a), top: B:2:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f7030f
            r1 = r0
            android.widget.CompoundButton r1 = (android.widget.CompoundButton) r1
            android.content.Context r0 = r1.getContext()
            int[] r3 = f.a.f3177m
            androidx.fragment.app.g r7 = androidx.fragment.app.g.g0(r0, r9, r3, r10)
            java.lang.Object r0 = r7.f729k
            android.content.res.TypedArray r0 = (android.content.res.TypedArray) r0
            android.content.Context r2 = r1.getContext()
            java.lang.Object r4 = r7.f729k
            r5 = r4
            android.content.res.TypedArray r5 = (android.content.res.TypedArray) r5
            r4 = r9
            r6 = r10
            n0.t0.o(r1, r2, r3, r4, r5, r6)
            r9 = 1
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            if (r10 == 0) goto L3e
            int r9 = r0.getResourceId(r9, r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L3e
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            android.graphics.drawable.Drawable r9 = android.support.v4.media.session.b.I(r10, r9)     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            goto L55
        L3b:
            r0 = move-exception
            r9 = r0
            goto L7b
        L3e:
            boolean r9 = r0.hasValue(r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L55
            int r9 = r0.getResourceId(r2, r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L55
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L3b
            android.graphics.drawable.Drawable r9 = android.support.v4.media.session.b.I(r10, r9)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L3b
        L55:
            r9 = 2
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L63
            android.content.res.ColorStateList r9 = r7.O(r9)     // Catch: java.lang.Throwable -> L3b
            r0.b.c(r1, r9)     // Catch: java.lang.Throwable -> L3b
        L63:
            r9 = 3
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L77
            r10 = -1
            int r9 = r0.getInt(r9, r10)     // Catch: java.lang.Throwable -> L3b
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = n.r1.c(r9, r10)     // Catch: java.lang.Throwable -> L3b
            r0.b.d(r1, r9)     // Catch: java.lang.Throwable -> L3b
        L77:
            r7.i0()
            return
        L7b:
            r7.i0()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: n.s.d(android.util.AttributeSet, int):void");
    }

    public void e(String str, p3.c cVar) {
        Object obj;
        p.f fVar = (p.f) this.f7030f;
        p.c f9 = fVar.f(str);
        if (f9 != null) {
            obj = f9.f8083j;
        } else {
            p.c cVar2 = new p.c(str, cVar);
            fVar.f8092l++;
            p.c cVar3 = fVar.f8090j;
            if (cVar3 == null) {
                fVar.f8089i = cVar2;
                fVar.f8090j = cVar2;
            } else {
                cVar3.f8084k = cVar2;
                cVar2.f8085l = cVar3;
                fVar.f8090j = cVar2;
            }
            obj = null;
        }
        if (((p3.c) obj) == null) {
            return;
        }
        m7.c.n("SavedStateProvider with the given key is already registered");
    }

    public s() {
        this.f7030f = new p.f();
        this.f7029e = true;
    }
}
