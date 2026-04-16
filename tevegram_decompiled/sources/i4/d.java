package i4;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import b4.i;
import h4.p;
import h4.q;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements q {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4712a;

    /* renamed from: b, reason: collision with root package name */
    public final q f4713b;

    /* renamed from: c, reason: collision with root package name */
    public final q f4714c;

    /* renamed from: d, reason: collision with root package name */
    public final Class f4715d;

    public d(Context context, q qVar, q qVar2, Class cls) {
        this.f4712a = context.getApplicationContext();
        this.f4713b = qVar;
        this.f4714c = qVar2;
        this.f4715d = cls;
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, i iVar) {
        Uri uri = (Uri) obj;
        return new p(new v4.b(uri), new c(this.f4712a, this.f4713b, this.f4714c, uri, i9, i10, iVar, this.f4715d));
    }

    @Override // h4.q
    public final boolean b(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.c.F((Uri) obj);
    }
}
