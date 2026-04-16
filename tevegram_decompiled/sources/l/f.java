package l;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import m.c0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5691a;

    /* renamed from: b, reason: collision with root package name */
    public final a f5692b;

    public f(Context context, a aVar) {
        this.f5691a = context;
        this.f5692b = aVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f5692b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f5692b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new c0(this.f5691a, this.f5692b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f5692b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f5692b.f();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f5692b.f5677i;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f5692b.g();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f5692b.f5678j;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f5692b.h();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f5692b.i();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f5692b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f5692b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f5692b.f5677i = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f5692b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z8) {
        this.f5692b.p(z8);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i9) {
        this.f5692b.l(i9);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i9) {
        this.f5692b.n(i9);
    }
}
