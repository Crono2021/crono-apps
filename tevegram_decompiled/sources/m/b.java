package m;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import n.a2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends a2 {

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f6374r = 0;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ View f6375s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f6375s = actionMenuItemView;
    }

    @Override // n.a2
    public final d0 b() {
        n.f fVar;
        switch (this.f6374r) {
            case 0:
                c cVar = ((ActionMenuItemView) this.f6375s).f368u;
                if (cVar == null || (fVar = ((n.g) cVar).f6865a.B) == null) {
                    return null;
                }
                return fVar.a();
            default:
                n.f fVar2 = ((n.i) this.f6375s).f6889l.A;
                if (fVar2 == null) {
                    return null;
                }
                return fVar2.a();
        }
    }

    @Override // n.a2
    public final boolean c() {
        d0 b9;
        switch (this.f6374r) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f6375s;
                l lVar = actionMenuItemView.f366s;
                return lVar != null && lVar.c(actionMenuItemView.f363p) && (b9 = b()) != null && b9.b();
            default:
                ((n.i) this.f6375s).f6889l.l();
                return true;
        }
    }

    @Override // n.a2
    public boolean d() {
        switch (this.f6374r) {
            case 1:
                n.j jVar = ((n.i) this.f6375s).f6889l;
                if (jVar.C != null) {
                    return false;
                }
                jVar.c();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n.i iVar, n.i iVar2) {
        super(iVar2);
        this.f6375s = iVar;
    }
}
