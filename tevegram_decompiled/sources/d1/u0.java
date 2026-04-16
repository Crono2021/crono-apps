package d1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u0 implements Comparable, Parcelable {
    public static final Parcelable.Creator<u0> CREATOR = new android.support.v4.media.a(17);

    /* renamed from: i, reason: collision with root package name */
    public final int f2578i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2579j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2580k;

    static {
        g1.w.H(0);
        g1.w.H(1);
        g1.w.H(2);
    }

    public u0(Parcel parcel) {
        this.f2578i = parcel.readInt();
        this.f2579j = parcel.readInt();
        this.f2580k = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        u0 u0Var = (u0) obj;
        int i9 = this.f2578i - u0Var.f2578i;
        if (i9 != 0) {
            return i9;
        }
        int i10 = this.f2579j - u0Var.f2579j;
        return i10 == 0 ? this.f2580k - u0Var.f2580k : i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && u0.class == obj.getClass()) {
            u0 u0Var = (u0) obj;
            if (this.f2578i == u0Var.f2578i && this.f2579j == u0Var.f2579j && this.f2580k == u0Var.f2580k) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f2578i * 31) + this.f2579j) * 31) + this.f2580k;
    }

    public final String toString() {
        return this.f2578i + "." + this.f2579j + "." + this.f2580k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f2578i);
        parcel.writeInt(this.f2579j);
        parcel.writeInt(this.f2580k);
    }
}
