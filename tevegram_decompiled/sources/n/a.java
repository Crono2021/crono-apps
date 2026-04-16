package n;

import androidx.appcompat.widget.ActionBarContextView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements n0.d1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6773a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f6774b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActionBarContextView f6775c;

    public a(ActionBarContextView actionBarContextView) {
        this.f6775c = actionBarContextView;
    }

    @Override // n0.d1
    public final void a() {
        if (this.f6773a) {
            return;
        }
        ActionBarContextView actionBarContextView = this.f6775c;
        actionBarContextView.f407n = null;
        super/*android.view.ViewGroup*/.setVisibility(this.f6774b);
    }

    @Override // n0.d1
    public final void b() {
        this.f6773a = true;
    }

    @Override // n0.d1
    public final void c() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.f6773a = false;
    }
}
