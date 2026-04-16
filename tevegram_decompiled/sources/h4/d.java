package h4;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements com.bumptech.glide.load.data.e {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3972i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f3973j;

    public /* synthetic */ d(Object obj, int i9) {
        this.f3972i = i9;
        this.f3973j = obj;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f3972i) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.f3973j.getClass();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int i9 = this.f3972i;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.g gVar, com.bumptech.glide.load.data.d dVar) {
        switch (this.f3972i) {
            case 0:
                try {
                    dVar.K(w4.b.a((File) this.f3973j));
                    break;
                } catch (IOException e9) {
                    if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e9);
                    }
                    dVar.x(e9);
                    return;
                }
            default:
                dVar.K(this.f3973j);
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i9 = this.f3972i;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        switch (this.f3972i) {
        }
        return 1;
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }
}
