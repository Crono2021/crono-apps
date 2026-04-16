package q2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends i {
    public static final Parcelable.Creator<n> CREATOR = new s(14);

    /* renamed from: j, reason: collision with root package name */
    public final String f8463j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8464k;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = g1.w.f3713a
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.f8463j = r0
            java.lang.String r3 = r3.readString()
            r2.f8464k = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.n.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            if (this.f8450i.equals(nVar.f8450i) && w.a(this.f8463j, nVar.f8463j) && w.a(this.f8464k, nVar.f8464k)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int k3 = androidx.activity.g.k(527, 31, this.f8450i);
        String str = this.f8463j;
        int hashCode = (k3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8464k;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // q2.i
    public final String toString() {
        return this.f8450i + ": url=" + this.f8464k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8450i);
        parcel.writeString(this.f8463j);
        parcel.writeString(this.f8464k);
    }

    public n(String str, String str2, String str3) {
        super(str);
        this.f8463j = str2;
        this.f8464k = str3;
    }
}
