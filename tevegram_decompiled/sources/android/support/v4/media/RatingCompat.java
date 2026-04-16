package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a(3);

    /* renamed from: i, reason: collision with root package name */
    public final int f230i;

    /* renamed from: j, reason: collision with root package name */
    public final float f231j;

    public RatingCompat(int i9, float f9) {
        this.f230i = i9;
        this.f231j = f9;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f230i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f230i);
        sb.append(" rating=");
        float f9 = this.f231j;
        sb.append(f9 < 0.0f ? "unrated" : String.valueOf(f9));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f230i);
        parcel.writeFloat(this.f231j);
    }
}
