package q2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends i {
    public static final Parcelable.Creator<j> CREATOR = new s(10);

    /* renamed from: j, reason: collision with root package name */
    public final String f8451j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8452k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8453l;

    public j(Parcel parcel) {
        super("----");
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f8451j = readString;
        this.f8452k = parcel.readString();
        this.f8453l = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            j jVar = (j) obj;
            if (w.a(this.f8452k, jVar.f8452k) && w.a(this.f8451j, jVar.f8451j) && w.a(this.f8453l, jVar.f8453l)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8451j;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8452k;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8453l;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // q2.i
    public final String toString() {
        return this.f8450i + ": domain=" + this.f8451j + ", description=" + this.f8452k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8450i);
        parcel.writeString(this.f8451j);
        parcel.writeString(this.f8453l);
    }

    public j(String str, String str2, String str3) {
        super("----");
        this.f8451j = str;
        this.f8452k = str2;
        this.f8453l = str3;
    }
}
