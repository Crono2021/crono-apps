package c4;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import h4.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements e {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1627i;

    /* renamed from: j, reason: collision with root package name */
    public final Comparable f1628j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f1629k;

    /* renamed from: l, reason: collision with root package name */
    public Object f1630l;

    public /* synthetic */ b(int i9, Comparable comparable, Object obj) {
        this.f1627i = i9;
        this.f1628j = comparable;
        this.f1629k = obj;
    }

    public static b d(Context context, Uri uri, a aVar) {
        return new b(0, uri, new c(com.bumptech.glide.b.a(context).f1733k.b().f(), aVar, com.bumptech.glide.b.a(context).f1734l, context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f1627i) {
            case 0:
                return InputStream.class;
            default:
                return ((z) this.f1629k).b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f1627i) {
            case 0:
                InputStream inputStream = (InputStream) this.f1630l;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        break;
                    } catch (IOException unused) {
                        return;
                    }
                }
                break;
            default:
                Object obj = this.f1630l;
                if (obj != null) {
                    try {
                        switch (((z) this.f1629k).f4027i) {
                            case 8:
                                ((ParcelFileDescriptor) obj).close();
                                break;
                            default:
                                ((InputStream) obj).close();
                                break;
                        }
                        break;
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(g gVar, d dVar) {
        Object open;
        switch (this.f1627i) {
            case 0:
                try {
                    InputStream g9 = g();
                    this.f1630l = g9;
                    dVar.K(g9);
                    break;
                } catch (FileNotFoundException e9) {
                    if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e9);
                    }
                    dVar.x(e9);
                }
            default:
                try {
                    z zVar = (z) this.f1629k;
                    File file = (File) this.f1628j;
                    switch (zVar.f4027i) {
                        case 8:
                            open = ParcelFileDescriptor.open(file, 268435456);
                            break;
                        default:
                            open = new FileInputStream(file);
                            break;
                    }
                    this.f1630l = open;
                    dVar.K(open);
                    break;
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("FileLoader", 3)) {
                        Log.d("FileLoader", "Failed to open file", e10);
                    }
                    dVar.x(e10);
                    return;
                }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i9 = this.f1627i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x002d, code lost:
    
        if (r7 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004e, code lost:
    
        if (r7 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0028: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:41), block:B:68:0x0028 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e7  */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream g() {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.b.g():java.io.InputStream");
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        switch (this.f1627i) {
        }
        return 1;
    }

    private final void e() {
    }

    private final void f() {
    }
}
