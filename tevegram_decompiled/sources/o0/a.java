package o0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: i, reason: collision with root package name */
    public final int f7547i;

    /* renamed from: j, reason: collision with root package name */
    public final l f7548j;

    /* renamed from: k, reason: collision with root package name */
    public final int f7549k;

    public a(int i9, l lVar, int i10) {
        this.f7547i = i9;
        this.f7548j = lVar;
        this.f7549k = i10;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f7547i);
        this.f7548j.f7564a.performAction(this.f7549k, bundle);
    }
}
