package m;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q extends FrameLayout implements l.b {

    /* renamed from: i, reason: collision with root package name */
    public final CollapsibleActionView f6475i;

    /* JADX WARN: Multi-variable type inference failed */
    public q(View view) {
        super(view.getContext());
        this.f6475i = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // l.b
    public final void onActionViewCollapsed() {
        this.f6475i.onActionViewCollapsed();
    }

    @Override // l.b
    public final void onActionViewExpanded() {
        this.f6475i.onActionViewExpanded();
    }
}
