package o4;

import android.util.Log;
import b4.k;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d4.a0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements k {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7929a;

    /* renamed from: b, reason: collision with root package name */
    public final a f7930b;

    /* renamed from: c, reason: collision with root package name */
    public final e4.f f7931c;

    public j(ArrayList arrayList, a aVar, e4.f fVar) {
        this.f7929a = arrayList;
        this.f7930b = aVar;
        this.f7931c = fVar;
    }

    @Override // b4.k
    public final a0 a(Object obj, int i9, int i10, b4.i iVar) {
        byte[] bArr;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e9) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e9);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.f7930b.a(ByteBuffer.wrap(bArr), i9, i10, iVar);
    }

    @Override // b4.k
    public final boolean b(Object obj, b4.i iVar) {
        return !((Boolean) iVar.c(i.f7928b)).booleanValue() && com.bumptech.glide.d.I(this.f7929a, (InputStream) obj, this.f7931c) == ImageHeaderParser$ImageType.GIF;
    }
}
