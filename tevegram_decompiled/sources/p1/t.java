package p1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new s(1);

    /* renamed from: i, reason: collision with root package name */
    public final int f8219i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8220j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8221k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8222l;

    /* renamed from: m, reason: collision with root package name */
    public final String f8223m;

    /* renamed from: n, reason: collision with root package name */
    public final String f8224n;

    public t(Parcel parcel) {
        this.f8219i = parcel.readInt();
        this.f8220j = parcel.readInt();
        this.f8221k = parcel.readString();
        this.f8222l = parcel.readString();
        this.f8223m = parcel.readString();
        this.f8224n = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && t.class == obj.getClass()) {
            t tVar = (t) obj;
            if (this.f8219i == tVar.f8219i && this.f8220j == tVar.f8220j && TextUtils.equals(this.f8221k, tVar.f8221k) && TextUtils.equals(this.f8222l, tVar.f8222l) && TextUtils.equals(this.f8223m, tVar.f8223m) && TextUtils.equals(this.f8224n, tVar.f8224n)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = ((this.f8219i * 31) + this.f8220j) * 31;
        String str = this.f8221k;
        int hashCode = (i9 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8222l;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8223m;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8224n;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f8219i);
        parcel.writeInt(this.f8220j);
        parcel.writeString(this.f8221k);
        parcel.writeString(this.f8222l);
        parcel.writeString(this.f8223m);
        parcel.writeString(this.f8224n);
    }

    public t(int i9, String str, int i10, String str2, String str3, String str4) {
        this.f8219i = i9;
        this.f8220j = i10;
        this.f8221k = str;
        this.f8222l = str2;
        this.f8223m = str3;
        this.f8224n = str4;
    }
}
