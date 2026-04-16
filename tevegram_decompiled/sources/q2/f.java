package q2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import java.util.Arrays;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends i {
    public static final Parcelable.Creator<f> CREATOR = new s(9);

    /* renamed from: j, reason: collision with root package name */
    public final String f8441j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8442k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8443l;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f8444m;

    public f(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f8441j = readString;
        this.f8442k = parcel.readString();
        this.f8443l = parcel.readString();
        this.f8444m = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (w.a(this.f8441j, fVar.f8441j) && w.a(this.f8442k, fVar.f8442k) && w.a(this.f8443l, fVar.f8443l) && Arrays.equals(this.f8444m, fVar.f8444m)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8441j;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8442k;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8443l;
        return Arrays.hashCode(this.f8444m) + ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // q2.i
    public final String toString() {
        return this.f8450i + ": mimeType=" + this.f8441j + ", filename=" + this.f8442k + ", description=" + this.f8443l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8441j);
        parcel.writeString(this.f8442k);
        parcel.writeString(this.f8443l);
        parcel.writeByteArray(this.f8444m);
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f8441j = str;
        this.f8442k = str2;
        this.f8443l = str3;
        this.f8444m = bArr;
    }
}
