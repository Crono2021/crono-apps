package u5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import androidx.fragment.app.h0;
import b2.k0;
import b6.e0;
import b6.g0;
import b6.w0;
import d2.d0;
import d2.y;
import java.security.MessageDigest;
import tv.danmaku.ijk.media.player.IjkLibLoader;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class e implements IjkLibLoader, k0, b4.g, com.bumptech.glide.manager.g, com.bumptech.glide.manager.f, d2.f, d2.o {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f9068i;

    public e() {
        this.f9068i = 25;
        e0 e0Var = g0.f1391j;
        w0 w0Var = w0.f1464m;
    }

    public static e b(Context context, int i9) {
        android.support.v4.media.session.b.o("Cannot create a CalendarItemStyle with a styleResId of 0", i9 != 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i9, y4.a.f10512r);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
        com.bumptech.glide.d.B(context, obtainStyledAttributes, 4);
        com.bumptech.glide.d.B(context, obtainStyledAttributes, 9);
        com.bumptech.glide.d.B(context, obtainStyledAttributes, 7);
        obtainStyledAttributes.getDimensionPixelSize(8, 0);
        j.a(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0), new a(0)).a();
        obtainStyledAttributes.recycle();
        e eVar = new e(24);
        android.support.v4.media.session.b.p(rect.left);
        android.support.v4.media.session.b.p(rect.top);
        android.support.v4.media.session.b.p(rect.right);
        android.support.v4.media.session.b.p(rect.bottom);
        return eVar;
    }

    @Override // d2.o
    public void c() {
        switch (this.f9068i) {
            case 27:
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public void f(com.bumptech.glide.manager.h hVar) {
        hVar.j();
    }

    public Signature[] i(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public boolean j(CharSequence charSequence) {
        return false;
    }

    @Override // d2.o
    public d0 l(int i9, int i10) {
        switch (this.f9068i) {
            case 27:
                return new d2.l();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IjkLibLoader
    public void loadLibrary(String str) {
        Log.i("TvgramApplication", "IJKLoader: " + str + " assumed in tmessages.49");
    }

    @Override // d2.o
    public void t(y yVar) {
        switch (this.f9068i) {
            case 27:
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public e(a5.d dVar, h0 h0Var) {
        this.f9068i = 22;
    }

    public /* synthetic */ e(int i9) {
        this.f9068i = i9;
    }

    private final void h() {
    }

    private final void k(y yVar) {
    }

    @Override // com.bumptech.glide.manager.f
    public void a(g.l lVar) {
    }

    @Override // d2.f
    public long e(long j5) {
        return j5;
    }

    @Override // com.bumptech.glide.manager.g
    public void g(com.bumptech.glide.manager.h hVar) {
    }

    @Override // b4.g
    public void d(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }
}
