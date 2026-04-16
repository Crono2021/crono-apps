package q2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends i {
    public static final Parcelable.Creator<e> CREATOR = new s(8);

    /* renamed from: j, reason: collision with root package name */
    public final String f8438j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8439k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8440l;

    public e(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f8438j = readString;
        this.f8439k = parcel.readString();
        this.f8440l = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (w.a(this.f8439k, eVar.f8439k) && w.a(this.f8438j, eVar.f8438j) && w.a(this.f8440l, eVar.f8440l)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8438j;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8439k;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8440l;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // q2.i
    public final String toString() {
        return this.f8450i + ": language=" + this.f8438j + ", description=" + this.f8439k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8450i);
        parcel.writeString(this.f8438j);
        parcel.writeString(this.f8440l);
    }

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f8438j = str;
        this.f8439k = str2;
        this.f8440l = str3;
    }
}
