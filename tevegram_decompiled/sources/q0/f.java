package q0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements g {

    /* renamed from: i, reason: collision with root package name */
    public final InputContentInfo f8306i;

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f8306i = new InputContentInfo(uri, clipDescription, uri2);
    }

    @Override // q0.g
    public final ClipDescription a() {
        return this.f8306i.getDescription();
    }

    @Override // q0.g
    public final Object l() {
        return this.f8306i;
    }

    @Override // q0.g
    public final Uri m() {
        return this.f8306i.getContentUri();
    }

    @Override // q0.g
    public final void n() {
        this.f8306i.requestPermission();
    }

    @Override // q0.g
    public final Uri p() {
        return this.f8306i.getLinkUri();
    }

    public f(Object obj) {
        this.f8306i = (InputContentInfo) obj;
    }
}
