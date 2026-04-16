package i4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import b4.i;
import com.bumptech.glide.g;
import com.bumptech.glide.load.data.e;
import h4.p;
import h4.q;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements e {

    /* renamed from: s, reason: collision with root package name */
    public static final String[] f4701s = {"_data"};

    /* renamed from: i, reason: collision with root package name */
    public final Context f4702i;

    /* renamed from: j, reason: collision with root package name */
    public final q f4703j;

    /* renamed from: k, reason: collision with root package name */
    public final q f4704k;

    /* renamed from: l, reason: collision with root package name */
    public final Uri f4705l;

    /* renamed from: m, reason: collision with root package name */
    public final int f4706m;

    /* renamed from: n, reason: collision with root package name */
    public final int f4707n;

    /* renamed from: o, reason: collision with root package name */
    public final i f4708o;

    /* renamed from: p, reason: collision with root package name */
    public final Class f4709p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f4710q;

    /* renamed from: r, reason: collision with root package name */
    public volatile e f4711r;

    public c(Context context, q qVar, q qVar2, Uri uri, int i9, int i10, i iVar, Class cls) {
        this.f4702i = context.getApplicationContext();
        this.f4703j = qVar;
        this.f4704k = qVar2;
        this.f4705l = uri;
        this.f4706m = i9;
        this.f4707n = i10;
        this.f4708o = iVar;
        this.f4709p = cls;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return this.f4709p;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        e eVar = this.f4711r;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(g gVar, com.bumptech.glide.load.data.d dVar) {
        try {
            e d9 = d();
            if (d9 == null) {
                dVar.x(new IllegalArgumentException("Failed to build fetcher for: " + this.f4705l));
            } else {
                this.f4711r = d9;
                if (this.f4710q) {
                    cancel();
                } else {
                    d9.c(gVar, dVar);
                }
            }
        } catch (FileNotFoundException e9) {
            dVar.x(e9);
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f4710q = true;
        e eVar = this.f4711r;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public final e d() {
        boolean isExternalStorageLegacy;
        int checkSelfPermission;
        p a9;
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Context context = this.f4702i;
        i iVar = this.f4708o;
        int i9 = this.f4707n;
        int i10 = this.f4706m;
        if (isExternalStorageLegacy) {
            Uri uri = this.f4705l;
            try {
                Cursor query = context.getContentResolver().query(uri, f4701s, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            query.close();
                            a9 = this.f4703j.a(file, i10, i9, iVar);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            Uri uri2 = this.f4705l;
            boolean F = com.bumptech.glide.c.F(uri2);
            q qVar = this.f4704k;
            if (F && uri2.getPathSegments().contains("picker")) {
                a9 = qVar.a(uri2, i10, i9, iVar);
            } else {
                checkSelfPermission = context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
                if (checkSelfPermission == 0) {
                    uri2 = MediaStore.setRequireOriginal(uri2);
                }
                a9 = qVar.a(uri2, i10, i9, iVar);
            }
        }
        if (a9 != null) {
            return a9.f4002c;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        return 1;
    }
}
