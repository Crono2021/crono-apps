package l1;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y implements b2.j0, n1.q, x1.d, t1.b, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ b0 f6065i;

    public y(b0 b0Var) {
        this.f6065i = b0Var;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i9, int i10) {
        Surface surface = new Surface(surfaceTexture);
        b0 b0Var = this.f6065i;
        b0Var.s0(surface);
        b0Var.X = surface;
        b0Var.h0(i9, i10);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        b0 b0Var = this.f6065i;
        b0Var.s0(null);
        b0Var.h0(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i9, int i10) {
        this.f6065i.h0(i9, i10);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i9, int i10, int i11) {
        this.f6065i.h0(i10, i11);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        b0 b0Var = this.f6065i;
        if (b0Var.f5772a0) {
            b0Var.s0(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b0 b0Var = this.f6065i;
        if (b0Var.f5772a0) {
            b0Var.s0(null);
        }
        b0Var.h0(0, 0);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
