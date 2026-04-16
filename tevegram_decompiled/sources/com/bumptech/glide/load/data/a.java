package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends b {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1789m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(ContentResolver contentResolver, Uri uri, int i9) {
        super(1, uri, contentResolver);
        this.f1789m = i9;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f1789m) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // com.bumptech.glide.load.data.b
    public final void f(Object obj) {
        switch (this.f1789m) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((ParcelFileDescriptor) obj).close();
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.b
    public final Object h(Uri uri, ContentResolver contentResolver) {
        switch (this.f1789m) {
            case 0:
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                if (openAssetFileDescriptor == null) {
                    m7.c.g(uri, "FileDescriptor is null for: ");
                    break;
                }
                break;
            default:
                AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(uri, "r");
                if (openAssetFileDescriptor2 == null) {
                    m7.c.g(uri, "FileDescriptor is null for: ");
                    break;
                } else {
                    break;
                }
        }
        return null;
    }
}
