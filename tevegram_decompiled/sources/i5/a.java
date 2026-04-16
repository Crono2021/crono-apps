package i5;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import o5.l;
import o5.m;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends a.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4716i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4717j;

    public /* synthetic */ a(Object obj, int i9) {
        this.f4716i = i9;
        this.f4717j = obj;
    }

    @Override // a.a
    public final void D(int i9) {
        switch (this.f4716i) {
            case 0:
                break;
            default:
                m mVar = (m) this.f4717j;
                mVar.f7995d = true;
                l lVar = (l) mVar.f7996e.get();
                if (lVar != null) {
                    e eVar = (e) lVar;
                    eVar.y();
                    eVar.invalidateSelf();
                    break;
                }
                break;
        }
    }

    @Override // a.a
    public final void E(Typeface typeface, boolean z8) {
        switch (this.f4716i) {
            case 0:
                Chip chip = (Chip) this.f4717j;
                e eVar = chip.f1984m;
                chip.setText(eVar.K0 ? eVar.M : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z8) {
                    m mVar = (m) this.f4717j;
                    mVar.f7995d = true;
                    l lVar = (l) mVar.f7996e.get();
                    if (lVar != null) {
                        e eVar2 = (e) lVar;
                        eVar2.y();
                        eVar2.invalidateSelf();
                        break;
                    }
                }
                break;
        }
    }

    private final void Z(int i9) {
    }
}
