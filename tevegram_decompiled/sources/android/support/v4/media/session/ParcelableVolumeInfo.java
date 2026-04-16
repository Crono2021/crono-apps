package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a(3);

    /* renamed from: i, reason: collision with root package name */
    public int f238i;

    /* renamed from: j, reason: collision with root package name */
    public int f239j;

    /* renamed from: k, reason: collision with root package name */
    public int f240k;

    /* renamed from: l, reason: collision with root package name */
    public int f241l;

    /* renamed from: m, reason: collision with root package name */
    public int f242m;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f238i);
        parcel.writeInt(this.f240k);
        parcel.writeInt(this.f241l);
        parcel.writeInt(this.f242m);
        parcel.writeInt(this.f239j);
    }
}
