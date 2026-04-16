package h4;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z implements r, b4.b {

    /* renamed from: j, reason: collision with root package name */
    public static final z f4026j = new z(0);

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4027i;

    public /* synthetic */ z(int i9) {
        this.f4027i = i9;
    }

    public static ByteArrayInputStream a(String str) {
        if (!str.startsWith("data:image")) {
            m7.c.n("Not a valid image data URL.");
            return null;
        }
        int indexOf = str.indexOf(44);
        if (indexOf == -1) {
            m7.c.n("Missing comma in data URL.");
            return null;
        }
        if (str.substring(0, indexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
        }
        m7.c.n("Not a base64 image data URL.");
        return null;
    }

    public Class b() {
        switch (this.f4027i) {
            case 1:
                return ByteBuffer.class;
            case 3:
                return InputStream.class;
            case 8:
                return ParcelFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // h4.r
    public q i(w wVar) {
        switch (this.f4027i) {
            case 0:
                return a0.f3961b;
            case 2:
                return new c(new z(1), 0);
            case 4:
                return new c(new z(3), 0);
            case 6:
                return new a0(1);
            case 11:
                return new y(wVar.b(Uri.class, AssetFileDescriptor.class), 0);
            case 12:
                return new y(wVar.b(Uri.class, ParcelFileDescriptor.class), 0);
            case 13:
                return new y(wVar.b(Uri.class, InputStream.class), 0);
            default:
                return new d0(wVar.b(g.class, InputStream.class));
        }
    }

    @Override // b4.b
    public boolean s(Object obj, File file, b4.i iVar) {
        try {
            w4.b.d((ByteBuffer) obj, file);
            return true;
        } catch (IOException e9) {
            if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                return false;
            }
            Log.d("ByteBufferEncoder", "Failed to write data", e9);
            return false;
        }
    }
}
