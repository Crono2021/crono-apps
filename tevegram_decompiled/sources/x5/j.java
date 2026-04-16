package x5;

import android.text.Editable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends o5.n {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ l f10133i;

    public j(l lVar) {
        this.f10133i = lVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f10133i.b().a();
    }

    @Override // o5.n, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        this.f10133i.b().b();
    }
}
