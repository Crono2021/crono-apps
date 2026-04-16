package n1;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f7258a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f7259b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f7260c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.f7260c = jVar;
        this.f7258a = contentResolver;
        this.f7259b = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z8) {
        j jVar = this.f7260c;
        jVar.a(e.c(jVar.f7272a, jVar.f7279i, jVar.h));
    }
}
