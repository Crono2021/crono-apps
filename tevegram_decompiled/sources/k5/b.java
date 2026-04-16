package k5;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import android.view.Window;
import g.j;
import g.k;
import i7.e1;
import java.util.WeakHashMap;
import n0.i0;
import n0.t0;
import u5.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends j {

    /* renamed from: c, reason: collision with root package name */
    public final g f5618c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f5619d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.content.Context r14, int r15) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.b.<init>(android.content.Context, int):void");
    }

    @Override // g.j
    public final j a() {
        this.f3568a.f3517m = false;
        return this;
    }

    @Override // g.j
    public final j b(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        super.b(charSequenceArr, onClickListener);
        return this;
    }

    @Override // g.j
    public final j c(String str) {
        this.f3568a.f3511f = str;
        return this;
    }

    @Override // g.j
    public final k create() {
        k create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        g gVar = this.f5618c;
        if (gVar != null) {
            WeakHashMap weakHashMap = t0.f7209a;
            gVar.k(i0.i(decorView));
        }
        Rect rect = this.f5619d;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) gVar, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new a(create, rect));
        return create;
    }

    @Override // g.j
    public final j d(String str, DialogInterface.OnClickListener onClickListener) {
        super.d(str, onClickListener);
        return this;
    }

    @Override // g.j
    public final j e(String str, DialogInterface.OnClickListener onClickListener) {
        super.e(str, onClickListener);
        return this;
    }

    @Override // g.j
    public final j f(e1 e1Var) {
        this.f3568a.f3518n = e1Var;
        return this;
    }

    @Override // g.j
    public final j g(String str, DialogInterface.OnClickListener onClickListener) {
        super.g(str, onClickListener);
        return this;
    }

    public final void i(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        super.b(charSequenceArr, onClickListener);
    }

    public final void j(String str, DialogInterface.OnClickListener onClickListener) {
        super.d(str, onClickListener);
    }

    public final void k(String str, DialogInterface.OnClickListener onClickListener) {
        super.e(str, onClickListener);
    }

    public final void l(String str, DialogInterface.OnClickListener onClickListener) {
        super.g(str, onClickListener);
    }

    public final b m(String str) {
        return (b) super.setTitle(str);
    }

    public final b n(View view) {
        return (b) super.setView(view);
    }

    @Override // g.j
    public final j setNegativeButton(int i9, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNegativeButton(i9, onClickListener);
    }

    @Override // g.j
    public final j setPositiveButton(int i9, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setPositiveButton(i9, onClickListener);
    }

    @Override // g.j
    public final j setTitle(CharSequence charSequence) {
        return (b) super.setTitle(charSequence);
    }

    @Override // g.j
    public final j setView(View view) {
        return (b) super.setView(view);
    }
}
