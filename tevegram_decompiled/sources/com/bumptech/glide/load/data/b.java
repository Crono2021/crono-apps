package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b implements e {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1790i;

    /* renamed from: j, reason: collision with root package name */
    public Object f1791j;

    /* renamed from: k, reason: collision with root package name */
    public final Comparable f1792k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f1793l;

    public /* synthetic */ b(int i9, Comparable comparable, Object obj) {
        this.f1790i = i9;
        this.f1793l = obj;
        this.f1792k = comparable;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch (this.f1790i) {
            case 0:
                Object obj = this.f1791j;
                if (obj != null) {
                    try {
                        f(obj);
                        break;
                    } catch (IOException unused) {
                        return;
                    }
                }
                break;
            default:
                Object obj2 = this.f1791j;
                if (obj2 != null) {
                    try {
                        f(obj2);
                        break;
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.g gVar, d dVar) {
        switch (this.f1790i) {
            case 0:
                try {
                    Object g9 = g((AssetManager) this.f1793l, (String) this.f1792k);
                    this.f1791j = g9;
                    dVar.K(g9);
                    break;
                } catch (IOException e9) {
                    if (Log.isLoggable("AssetPathFetcher", 3)) {
                        Log.d("AssetPathFetcher", "Failed to load data from asset manager", e9);
                    }
                    dVar.x(e9);
                    return;
                }
            default:
                try {
                    Object h = h((Uri) this.f1792k, (ContentResolver) this.f1793l);
                    this.f1791j = h;
                    dVar.K(h);
                    break;
                } catch (FileNotFoundException e10) {
                    if (Log.isLoggable("LocalUriFetcher", 3)) {
                        Log.d("LocalUriFetcher", "Failed to open Uri", e10);
                    }
                    dVar.x(e10);
                }
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i9 = this.f1790i;
    }

    public abstract void f(Object obj);

    public abstract Object g(AssetManager assetManager, String str);

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        switch (this.f1790i) {
        }
        return 1;
    }

    public abstract Object h(Uri uri, ContentResolver contentResolver);

    private final void d() {
    }

    private final void e() {
    }
}
