package x5;

import com.google.android.material.internal.CheckableImageButton;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends m {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f10116e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(l lVar, int i9) {
        super(lVar);
        this.f10116e = i9;
    }

    @Override // x5.m
    public void q() {
        switch (this.f10116e) {
            case 0:
                l lVar = this.f10154b;
                lVar.f10149w = null;
                CheckableImageButton checkableImageButton = lVar.f10141o;
                checkableImageButton.setOnLongClickListener(null);
                com.bumptech.glide.d.Z(checkableImageButton, null);
                break;
        }
    }
}
