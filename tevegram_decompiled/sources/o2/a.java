package o2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.g;
import d1.g0;
import d1.i0;
import d1.l0;
import d1.s;
import g1.p;
import g1.w;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements i0 {
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.media.a(25);

    /* renamed from: i, reason: collision with root package name */
    public final int f7575i;

    /* renamed from: j, reason: collision with root package name */
    public final String f7576j;

    /* renamed from: k, reason: collision with root package name */
    public final String f7577k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7578l;

    /* renamed from: m, reason: collision with root package name */
    public final int f7579m;

    /* renamed from: n, reason: collision with root package name */
    public final int f7580n;

    /* renamed from: o, reason: collision with root package name */
    public final int f7581o;

    /* renamed from: p, reason: collision with root package name */
    public final byte[] f7582p;

    public a(Parcel parcel) {
        this.f7575i = parcel.readInt();
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f7576j = readString;
        this.f7577k = parcel.readString();
        this.f7578l = parcel.readInt();
        this.f7579m = parcel.readInt();
        this.f7580n = parcel.readInt();
        this.f7581o = parcel.readInt();
        this.f7582p = parcel.createByteArray();
    }

    public static a d(p pVar) {
        int g9 = pVar.g();
        String k3 = l0.k(pVar.r(pVar.g(), a6.b.f201a));
        String r8 = pVar.r(pVar.g(), a6.b.f203c);
        int g10 = pVar.g();
        int g11 = pVar.g();
        int g12 = pVar.g();
        int g13 = pVar.g();
        int g14 = pVar.g();
        byte[] bArr = new byte[g14];
        pVar.e(0, g14, bArr);
        return new a(g9, k3, r8, g10, g11, g12, g13, bArr);
    }

    @Override // d1.i0
    public final void a(g0 g0Var) {
        g0Var.a(this.f7582p, this.f7575i);
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
            if (this.f7575i == aVar.f7575i && this.f7576j.equals(aVar.f7576j) && this.f7577k.equals(aVar.f7577k) && this.f7578l == aVar.f7578l && this.f7579m == aVar.f7579m && this.f7580n == aVar.f7580n && this.f7581o == aVar.f7581o && Arrays.equals(this.f7582p, aVar.f7582p)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f7582p) + ((((((((g.k(g.k((527 + this.f7575i) * 31, 31, this.f7576j), 31, this.f7577k) + this.f7578l) * 31) + this.f7579m) * 31) + this.f7580n) * 31) + this.f7581o) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.f7576j + ", description=" + this.f7577k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f7575i);
        parcel.writeString(this.f7576j);
        parcel.writeString(this.f7577k);
        parcel.writeInt(this.f7578l);
        parcel.writeInt(this.f7579m);
        parcel.writeInt(this.f7580n);
        parcel.writeInt(this.f7581o);
        parcel.writeByteArray(this.f7582p);
    }

    public a(int i9, String str, String str2, int i10, int i11, int i12, int i13, byte[] bArr) {
        this.f7575i = i9;
        this.f7576j = str;
        this.f7577k = str2;
        this.f7578l = i10;
        this.f7579m = i11;
        this.f7580n = i12;
        this.f7581o = i13;
        this.f7582p = bArr;
    }
}
