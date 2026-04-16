package android.support.v4.media;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.h;
import androidx.fragment.app.e0;
import androidx.fragment.app.i0;
import androidx.fragment.app.l0;
import b.d;
import com.google.android.material.datepicker.q;
import d1.j0;
import d1.m;
import d1.n;
import d1.u0;
import java.util.ArrayList;
import n.r0;
import o3.j1;
import o3.k1;
import o3.y;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f232a;

    public /* synthetic */ a(int i9) {
        this.f232a = i9;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Uri a9;
        b.b bVar = null;
        switch (this.f232a) {
            case 0:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a(0);

                    /* renamed from: i, reason: collision with root package name */
                    public final int f218i;

                    /* renamed from: j, reason: collision with root package name */
                    public final MediaDescriptionCompat f219j;

                    {
                        this.f218i = parcel.readInt();
                        this.f219j = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.f218i + ", mDescription=" + this.f219j + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i9) {
                        parcel2.writeInt(this.f218i);
                        this.f219j.writeToParcel(parcel2, i9);
                    }
                };
            case 1:
                Object createFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (createFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) createFromParcel;
                String g9 = b.g(mediaDescription);
                CharSequence i9 = b.i(mediaDescription);
                CharSequence h = b.h(mediaDescription);
                CharSequence c9 = b.c(mediaDescription);
                Bitmap e9 = b.e(mediaDescription);
                Uri f9 = b.f(mediaDescription);
                Bundle d9 = b.d(mediaDescription);
                if (d9 != null) {
                    d9 = android.support.v4.media.session.b.z0(d9);
                }
                Uri uri = d9 != null ? (Uri) d9.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
                if (uri != null) {
                    if (d9.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && d9.size() == 2) {
                        d9 = null;
                    } else {
                        d9.remove("android.support.v4.media.description.MEDIA_URI");
                        d9.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    }
                }
                if (uri != null) {
                    a9 = uri;
                } else {
                    a9 = Build.VERSION.SDK_INT >= 23 ? c.a(mediaDescription) : null;
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(g9, i9, h, c9, e9, f9, d9, a9);
                mediaDescriptionCompat.f228q = mediaDescription;
                return mediaDescriptionCompat;
            case 2:
                return new MediaMetadataCompat(parcel);
            case 3:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 4:
                return new androidx.activity.result.a(parcel);
            case 5:
                parcel.getClass();
                Parcelable readParcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                readParcelable.getClass();
                return new h((IntentSender) readParcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 6:
                return new androidx.fragment.app.c(parcel);
            case 7:
                e0 e0Var = new e0();
                e0Var.f721i = parcel.readString();
                e0Var.f722j = parcel.readInt();
                return e0Var;
            case 8:
                i0 i0Var = new i0();
                i0Var.f767m = null;
                i0Var.f768n = new ArrayList();
                i0Var.f769o = new ArrayList();
                i0Var.f763i = parcel.createTypedArrayList(l0.CREATOR);
                i0Var.f764j = parcel.createStringArrayList();
                i0Var.f765k = (androidx.fragment.app.c[]) parcel.createTypedArray(androidx.fragment.app.c.CREATOR);
                i0Var.f766l = parcel.readInt();
                i0Var.f767m = parcel.readString();
                i0Var.f768n = parcel.createStringArrayList();
                i0Var.f769o = parcel.createTypedArrayList(Bundle.CREATOR);
                i0Var.f770p = parcel.createTypedArrayList(e0.CREATOR);
                return i0Var;
            case 9:
                return new l0(parcel);
            case 10:
                d dVar = new d();
                IBinder readStrongBinder = parcel.readStrongBinder();
                int i10 = b.c.f1123c;
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(b.b.f1122a);
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof b.b)) {
                        b.a aVar = new b.a();
                        aVar.f1121b = readStrongBinder;
                        bVar = aVar;
                    } else {
                        bVar = (b.b) queryLocalInterface;
                    }
                }
                dVar.f1125i = bVar;
                return dVar;
            case 11:
                return new com.google.android.material.datepicker.b((q) parcel.readParcelable(q.class.getClassLoader()), (q) parcel.readParcelable(q.class.getClassLoader()), (com.google.android.material.datepicker.d) parcel.readParcelable(com.google.android.material.datepicker.d.class.getClassLoader()), (q) parcel.readParcelable(q.class.getClassLoader()), parcel.readInt());
            case 12:
                return new com.google.android.material.datepicker.d(parcel.readLong());
            case 13:
                return q.d(parcel.readInt(), parcel.readInt());
            case 14:
                return new n(parcel);
            case 15:
                return new m(parcel);
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return new j0(parcel);
            case 17:
                return new u0(parcel);
            case 18:
                return new h1.a(parcel);
            case 19:
                return new h1.b(parcel);
            case 20:
                return new h1.c(parcel);
            case 21:
                h5.b bVar2 = new h5.b(parcel);
                bVar2.f4030i = ((Integer) parcel.readValue(h5.b.class.getClassLoader())).intValue();
                return bVar2;
            case 22:
                String readString = parcel.readString();
                readString.getClass();
                return new m2.a(parcel.readInt(), readString);
            case 23:
                r0 r0Var = new r0(parcel);
                r0Var.f7020i = parcel.readByte() != 0;
                return r0Var;
            case 24:
                return new n2.a(parcel);
            case 25:
                return new o2.a(parcel);
            case 26:
                return new o2.b(parcel);
            case 27:
                y yVar = new y();
                yVar.f7850i = parcel.readInt();
                yVar.f7851j = parcel.readInt();
                yVar.f7852k = parcel.readInt() == 1;
                return yVar;
            case 28:
                j1 j1Var = new j1();
                j1Var.f7692i = parcel.readInt();
                j1Var.f7693j = parcel.readInt();
                j1Var.f7695l = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    j1Var.f7694k = iArr;
                    parcel.readIntArray(iArr);
                }
                return j1Var;
            default:
                k1 k1Var = new k1();
                k1Var.f7709i = parcel.readInt();
                k1Var.f7710j = parcel.readInt();
                int readInt2 = parcel.readInt();
                k1Var.f7711k = readInt2;
                if (readInt2 > 0) {
                    int[] iArr2 = new int[readInt2];
                    k1Var.f7712l = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int readInt3 = parcel.readInt();
                k1Var.f7713m = readInt3;
                if (readInt3 > 0) {
                    int[] iArr3 = new int[readInt3];
                    k1Var.f7714n = iArr3;
                    parcel.readIntArray(iArr3);
                }
                k1Var.f7716p = parcel.readInt() == 1;
                k1Var.f7717q = parcel.readInt() == 1;
                k1Var.f7718r = parcel.readInt() == 1;
                k1Var.f7715o = parcel.readArrayList(j1.class.getClassLoader());
                return k1Var;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i9) {
        switch (this.f232a) {
            case 0:
                return new MediaBrowserCompat$MediaItem[i9];
            case 1:
                return new MediaDescriptionCompat[i9];
            case 2:
                return new MediaMetadataCompat[i9];
            case 3:
                return new RatingCompat[i9];
            case 4:
                return new androidx.activity.result.a[i9];
            case 5:
                return new h[i9];
            case 6:
                return new androidx.fragment.app.c[i9];
            case 7:
                return new e0[i9];
            case 8:
                return new i0[i9];
            case 9:
                return new l0[i9];
            case 10:
                return new d[i9];
            case 11:
                return new com.google.android.material.datepicker.b[i9];
            case 12:
                return new com.google.android.material.datepicker.d[i9];
            case 13:
                return new q[i9];
            case 14:
                return new n[i9];
            case 15:
                return new m[i9];
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return new j0[i9];
            case 17:
                return new u0[i9];
            case 18:
                return new h1.a[i9];
            case 19:
                return new h1.b[i9];
            case 20:
                return new h1.c[i9];
            case 21:
                return new h5.b[i9];
            case 22:
                return new m2.a[i9];
            case 23:
                return new r0[i9];
            case 24:
                return new n2.a[i9];
            case 25:
                return new o2.a[i9];
            case 26:
                return new o2.b[i9];
            case 27:
                return new y[i9];
            case 28:
                return new j1[i9];
            default:
                return new k1[i9];
        }
    }
}
