package r2;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements i0 {
    public static final Parcelable.Creator<d> CREATOR = new s(19);

    /* renamed from: i, reason: collision with root package name */
    public final float f8540i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8541j;

    public d(Parcel parcel) {
        this.f8540i = parcel.readFloat();
        this.f8541j = parcel.readInt();
    }

    @Override // d1.i0
    public final /* synthetic */ d1.s b() {
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
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f8540i == dVar.f8540i && this.f8541j == dVar.f8541j) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.f8540i).hashCode() + 527) * 31) + this.f8541j;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.f8540i + ", svcTemporalLayerCount=" + this.f8541j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeFloat(this.f8540i);
        parcel.writeInt(this.f8541j);
    }

    public d(int i9, float f9) {
        this.f8540i = f9;
        this.f8541j = i9;
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }
}
