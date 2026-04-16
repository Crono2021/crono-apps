package o3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new android.support.v4.media.a(27);

    /* renamed from: i, reason: collision with root package name */
    public int f7850i;

    /* renamed from: j, reason: collision with root package name */
    public int f7851j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7852k;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f7850i);
        parcel.writeInt(this.f7851j);
        parcel.writeInt(this.f7852k ? 1 : 0);
    }
}
