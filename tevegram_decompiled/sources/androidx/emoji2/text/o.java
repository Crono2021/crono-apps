package androidx.emoji2.text;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.ConnectivityManager;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o implements k, w4.g, h4.r {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f638i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f639j;

    public o(Context context) {
        this.f638i = 0;
        this.f639j = context.getApplicationContext();
    }

    @Override // androidx.emoji2.text.k
    public void a(com.bumptech.glide.c cVar) {
        a aVar = new a("EmojiCompatInitializer", 0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), aVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new m(this, cVar, threadPoolExecutor, 0));
    }

    @Override // w4.g
    public Object get() {
        return (ConnectivityManager) this.f639j.getSystemService("connectivity");
    }

    @Override // h4.r
    public h4.q i(h4.w wVar) {
        switch (this.f638i) {
            case 3:
                return new h4.b(this.f639j, this);
            case 4:
                return new h4.b(this.f639j, this);
            case 5:
                return new h4.b(this.f639j, this);
            case 6:
                return new h4.m(this.f639j, 0);
            case 7:
                return new h4.b(this.f639j, wVar.b(Integer.class, AssetFileDescriptor.class));
            case 8:
                return new h4.b(this.f639j, wVar.b(Integer.class, InputStream.class));
            case 9:
                return new h4.m(this.f639j, 1);
            default:
                return new h4.m(this.f639j, 2);
        }
    }

    public /* synthetic */ o(Context context, int i9) {
        this.f638i = i9;
        this.f639j = context;
    }
}
