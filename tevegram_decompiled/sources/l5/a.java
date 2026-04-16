package l5;

import android.graphics.drawable.Drawable;
import i.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends h {

    /* renamed from: j, reason: collision with root package name */
    public final int f6264j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6265k;

    public a(Drawable drawable, int i9, int i10) {
        super(drawable);
        this.f6264j = i9;
        this.f6265k = i10;
    }

    @Override // i.h, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6265k;
    }

    @Override // i.h, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f6264j;
    }
}
