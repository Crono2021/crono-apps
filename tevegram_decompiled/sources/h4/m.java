package h4;

import android.content.Context;
import android.net.Uri;
import k4.e0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3996a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3997b;

    public m(Context context, int i9) {
        this.f3996a = i9;
        switch (i9) {
            case 1:
                this.f3997b = context.getApplicationContext();
                break;
            case 2:
                this.f3997b = context.getApplicationContext();
                break;
            default:
                this.f3997b = context;
                break;
        }
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, b4.i iVar) {
        Long l4;
        switch (this.f3996a) {
            case 0:
                Uri uri = (Uri) obj;
                return new p(new v4.b(uri), new l(this.f3997b, 0, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i9 == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i9 > 512 || i10 > 384) {
                    return null;
                }
                v4.b bVar = new v4.b(uri2);
                Context context = this.f3997b;
                return new p(bVar, c4.b.d(context, uri2, new c4.a(context.getContentResolver(), 0)));
            default:
                Uri uri3 = (Uri) obj;
                if (i9 == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i9 > 512 || i10 > 384 || (l4 = (Long) iVar.c(e0.f5557d)) == null || l4.longValue() != -1) {
                    return null;
                }
                v4.b bVar2 = new v4.b(uri3);
                Context context2 = this.f3997b;
                return new p(bVar2, c4.b.d(context2, uri3, new c4.a(context2.getContentResolver(), 1)));
        }
    }

    @Override // h4.q
    public final boolean b(Object obj) {
        switch (this.f3996a) {
            case 0:
                return com.bumptech.glide.c.F((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return com.bumptech.glide.c.F(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return com.bumptech.glide.c.F(uri2) && uri2.getPathSegments().contains("video");
        }
    }
}
