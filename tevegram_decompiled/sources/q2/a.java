package q2;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import g1.w;
import java.util.Arrays;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends i {
    public static final Parcelable.Creator<a> CREATOR = new s(4);

    /* renamed from: j, reason: collision with root package name */
    public final String f8422j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8423k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8424l;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f8425m;

    public a(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f8422j = readString;
        this.f8423k = parcel.readString();
        this.f8424l = parcel.readInt();
        this.f8425m = parcel.createByteArray();
    }

    @Override // q2.i, d1.i0
    public final void a(g0 g0Var) {
        g0Var.a(this.f8425m, this.f8424l);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f8424l == aVar.f8424l && w.a(this.f8422j, aVar.f8422j) && w.a(this.f8423k, aVar.f8423k) && Arrays.equals(this.f8425m, aVar.f8425m)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = (527 + this.f8424l) * 31;
        String str = this.f8422j;
        int hashCode = (i9 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8423k;
        return Arrays.hashCode(this.f8425m) + ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // q2.i
    public final String toString() {
        return this.f8450i + ": mimeType=" + this.f8422j + ", description=" + this.f8423k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8422j);
        parcel.writeString(this.f8423k);
        parcel.writeInt(this.f8424l);
        parcel.writeByteArray(this.f8425m);
    }

    public a(String str, String str2, int i9, byte[] bArr) {
        super("APIC");
        this.f8422j = str;
        this.f8423k = str2;
        this.f8424l = i9;
        this.f8425m = bArr;
    }
}
