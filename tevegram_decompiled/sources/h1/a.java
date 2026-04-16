package h1;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import d1.s;
import g1.w;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements i0 {
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.media.a(18);

    /* renamed from: i, reason: collision with root package name */
    public final String f3850i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f3851j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3852k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3853l;

    public a(Parcel parcel) {
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f3850i = readString;
        this.f3851j = parcel.createByteArray();
        this.f3852k = parcel.readInt();
        this.f3853l = parcel.readInt();
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
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f3850i.equals(aVar.f3850i) && Arrays.equals(this.f3851j, aVar.f3851j) && this.f3852k == aVar.f3852k && this.f3853l == aVar.f3853l) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f3851j) + androidx.activity.g.k(527, 31, this.f3850i)) * 31) + this.f3852k) * 31) + this.f3853l;
    }

    public final String toString() {
        String m9;
        byte[] bArr = this.f3851j;
        int i9 = this.f3853l;
        if (i9 != 1) {
            if (i9 == 23) {
                int i10 = w.f3713a;
                g1.a.f(bArr.length == 4);
                m9 = String.valueOf(Float.intBitsToFloat((bArr[3] & 255) | (bArr[0] << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8)));
            } else if (i9 != 67) {
                int i11 = w.f3713a;
                StringBuilder sb = new StringBuilder(bArr.length * 2);
                for (int i12 = 0; i12 < bArr.length; i12++) {
                    sb.append(Character.forDigit((bArr[i12] >> 4) & 15, 16));
                    sb.append(Character.forDigit(bArr[i12] & 15, 16));
                }
                m9 = sb.toString();
            } else {
                int i13 = w.f3713a;
                g1.a.f(bArr.length == 4);
                m9 = String.valueOf(bArr[3] | (bArr[0] << 24) | (bArr[1] << 16) | (bArr[2] << 8));
            }
        } else {
            m9 = w.m(bArr);
        }
        return "mdta: key=" + this.f3850i + ", value=" + m9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f3850i);
        parcel.writeByteArray(this.f3851j);
        parcel.writeInt(this.f3852k);
        parcel.writeInt(this.f3853l);
    }

    public a(String str, byte[] bArr, int i9, int i10) {
        this.f3850i = str;
        this.f3851j = bArr;
        this.f3852k = i9;
        this.f3853l = i10;
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }
}
