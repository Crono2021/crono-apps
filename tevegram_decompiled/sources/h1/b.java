package h1;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import d1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements i0 {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(19);

    /* renamed from: i, reason: collision with root package name */
    public final float f3854i;

    /* renamed from: j, reason: collision with root package name */
    public final float f3855j;

    public b(float f9, float f10) {
        g1.a.e("Invalid latitude or longitude", f9 >= -90.0f && f9 <= 90.0f && f10 >= -180.0f && f10 <= 180.0f);
        this.f3854i = f9;
        this.f3855j = f10;
    }

    @Override // d1.i0
    public final /* synthetic */ s b() {
        return null;
    }

    @Override // d1.i0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f3854i == bVar.f3854i && this.f3855j == bVar.f3855j) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.valueOf(this.f3855j).hashCode() + ((Float.valueOf(this.f3854i).hashCode() + 527) * 31);
    }

    public final String toString() {
        return "xyz: latitude=" + this.f3854i + ", longitude=" + this.f3855j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeFloat(this.f3854i);
        parcel.writeFloat(this.f3855j);
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }

    public b(Parcel parcel) {
        this.f3854i = parcel.readFloat();
        this.f3855j = parcel.readFloat();
    }
}
