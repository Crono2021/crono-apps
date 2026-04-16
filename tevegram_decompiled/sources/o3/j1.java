package o3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j1 implements Parcelable {
    public static final Parcelable.Creator<j1> CREATOR = new android.support.v4.media.a(28);

    /* renamed from: i, reason: collision with root package name */
    public int f7692i;

    /* renamed from: j, reason: collision with root package name */
    public int f7693j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f7694k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7695l;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f7692i + ", mGapDir=" + this.f7693j + ", mHasUnwantedGapAfter=" + this.f7695l + ", mGapPerSpan=" + Arrays.toString(this.f7694k) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f7692i);
        parcel.writeInt(this.f7693j);
        parcel.writeInt(this.f7695l ? 1 : 0);
        int[] iArr = this.f7694k;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f7694k);
        }
    }
}
