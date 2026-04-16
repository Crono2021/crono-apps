package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a(1);

    /* renamed from: i, reason: collision with root package name */
    public final String f220i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f221j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f222k;

    /* renamed from: l, reason: collision with root package name */
    public final CharSequence f223l;

    /* renamed from: m, reason: collision with root package name */
    public final Bitmap f224m;

    /* renamed from: n, reason: collision with root package name */
    public final Uri f225n;

    /* renamed from: o, reason: collision with root package name */
    public final Bundle f226o;

    /* renamed from: p, reason: collision with root package name */
    public final Uri f227p;

    /* renamed from: q, reason: collision with root package name */
    public MediaDescription f228q;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f220i = str;
        this.f221j = charSequence;
        this.f222k = charSequence2;
        this.f223l = charSequence3;
        this.f224m = bitmap;
        this.f225n = uri;
        this.f226o = bundle;
        this.f227p = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f221j) + ", " + ((Object) this.f222k) + ", " + ((Object) this.f223l);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        Bundle bundle;
        MediaDescription mediaDescription = this.f228q;
        if (mediaDescription == null) {
            MediaDescription.Builder b9 = b.b();
            b.n(b9, this.f220i);
            b.p(b9, this.f221j);
            b.o(b9, this.f222k);
            b.j(b9, this.f223l);
            b.l(b9, this.f224m);
            b.m(b9, this.f225n);
            int i10 = Build.VERSION.SDK_INT;
            Bundle bundle2 = this.f226o;
            Uri uri = this.f227p;
            if (i10 >= 23 || uri == null) {
                b.k(b9, bundle2);
            } else {
                if (bundle2 == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                } else {
                    bundle = new Bundle(bundle2);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", uri);
                b.k(b9, bundle);
            }
            if (i10 >= 23) {
                c.b(b9, uri);
            }
            mediaDescription = b.a(b9);
            this.f228q = mediaDescription;
        }
        mediaDescription.writeToParcel(parcel, i9);
    }
}
