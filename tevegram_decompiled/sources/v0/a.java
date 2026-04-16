package v0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import i7.x;
import java.util.WeakHashMap;
import n0.c0;
import n0.t0;
import o0.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends x {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b f9195k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(14);
        this.f9195k = bVar;
    }

    @Override // i7.x
    public final boolean J(int i9, int i10, Bundle bundle) {
        int i11;
        b bVar = this.f9195k;
        Chip chip = bVar.f9203i;
        if (i9 == -1) {
            WeakHashMap weakHashMap = t0.f7209a;
            return c0.j(chip, i10, bundle);
        }
        if (i10 == 1) {
            return bVar.p(i9);
        }
        if (i10 == 2) {
            return bVar.j(i9);
        }
        boolean z8 = false;
        if (i10 == 64) {
            AccessibilityManager accessibilityManager = bVar.h;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i11 = bVar.f9205k) == i9) {
                return false;
            }
            if (i11 != Integer.MIN_VALUE) {
                bVar.f9205k = Integer.MIN_VALUE;
                chip.invalidate();
                bVar.q(i11, 65536);
            }
            bVar.f9205k = i9;
            chip.invalidate();
            bVar.q(i9, 32768);
            return true;
        }
        if (i10 == 128) {
            if (bVar.f9205k != i9) {
                return false;
            }
            bVar.f9205k = Integer.MIN_VALUE;
            chip.invalidate();
            bVar.q(i9, 65536);
            return true;
        }
        Chip chip2 = ((i5.c) bVar).f4719q;
        if (i10 == 16) {
            if (i9 == 0) {
                return chip2.performClick();
            }
            if (i9 == 1) {
                chip2.playSoundEffect(0);
                View.OnClickListener onClickListener = chip2.f1987p;
                if (onClickListener != null) {
                    onClickListener.onClick(chip2);
                    z8 = true;
                }
                if (chip2.B) {
                    chip2.A.q(1, 1);
                }
            }
        }
        return z8;
    }

    @Override // i7.x
    public final l x(int i9) {
        return new l(AccessibilityNodeInfo.obtain(this.f9195k.n(i9).f7564a));
    }

    @Override // i7.x
    public final l y(int i9) {
        b bVar = this.f9195k;
        int i10 = i9 == 2 ? bVar.f9205k : bVar.f9206l;
        if (i10 == Integer.MIN_VALUE) {
            return null;
        }
        return x(i10);
    }
}
