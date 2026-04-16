package s2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new s(20);

    /* renamed from: i, reason: collision with root package name */
    public final long f8764i;

    /* renamed from: j, reason: collision with root package name */
    public final long f8765j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f8766k;

    public a(Parcel parcel) {
        this.f8764i = parcel.readLong();
        this.f8765j = parcel.readLong();
        byte[] createByteArray = parcel.createByteArray();
        int i9 = w.f3713a;
        this.f8766k = createByteArray;
    }

    @Override // s2.b
    public final String toString() {
        return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.f8764i + ", identifier= " + this.f8765j + " }";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeLong(this.f8764i);
        parcel.writeLong(this.f8765j);
        parcel.writeByteArray(this.f8766k);
    }

    public a(long j5, long j9, byte[] bArr) {
        this.f8764i = j9;
        this.f8765j = j5;
        this.f8766k = bArr;
    }
}
