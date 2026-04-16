package h4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements com.bumptech.glide.load.data.e {

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f3992l = {"_data"};

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3993i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f3994j;

    /* renamed from: k, reason: collision with root package name */
    public Object f3995k;

    public /* synthetic */ l(Object obj, int i9, Object obj2) {
        this.f3993i = i9;
        this.f3994j = obj;
        this.f3995k = obj2;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f3993i) {
            case 0:
                return File.class;
            case 1:
                return ((z) this.f3995k).b();
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f3993i) {
            case 0:
            case 1:
                break;
            default:
                try {
                    ((ByteArrayInputStream) this.f3995k).close();
                    break;
                } catch (IOException unused) {
                    return;
                }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.g gVar, com.bumptech.glide.load.data.d dVar) {
        Object wrap;
        switch (this.f3993i) {
            case 0:
                Cursor query = ((Context) this.f3994j).getContentResolver().query((Uri) this.f3995k, f3992l, null, null, null);
                if (query != null) {
                    try {
                        r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                        query.close();
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                if (!TextUtils.isEmpty(r0)) {
                    dVar.K(new File(r0));
                    return;
                }
                dVar.x(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.f3995k)));
                return;
            case 1:
                z zVar = (z) this.f3995k;
                byte[] bArr = (byte[]) this.f3994j;
                switch (zVar.f4027i) {
                    case 1:
                        wrap = ByteBuffer.wrap(bArr);
                        break;
                    default:
                        wrap = new ByteArrayInputStream(bArr);
                        break;
                }
                dVar.K(wrap);
                return;
            default:
                try {
                    ByteArrayInputStream a9 = z.a((String) this.f3994j);
                    this.f3995k = a9;
                    dVar.K(a9);
                    return;
                } catch (IllegalArgumentException e9) {
                    dVar.x(e9);
                    return;
                }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i9 = this.f3993i;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        switch (this.f3993i) {
        }
        return 1;
    }

    public l(String str, z zVar) {
        this.f3993i = 2;
        this.f3994j = str;
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
