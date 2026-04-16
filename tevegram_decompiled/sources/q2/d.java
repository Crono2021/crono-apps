package q2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import java.util.Arrays;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends i {
    public static final Parcelable.Creator<d> CREATOR = new s(7);

    /* renamed from: j, reason: collision with root package name */
    public final String f8433j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f8434k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f8435l;

    /* renamed from: m, reason: collision with root package name */
    public final String[] f8436m;

    /* renamed from: n, reason: collision with root package name */
    public final i[] f8437n;

    public d(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f8433j = readString;
        this.f8434k = parcel.readByte() != 0;
        this.f8435l = parcel.readByte() != 0;
        this.f8436m = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f8437n = new i[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f8437n[i10] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f8434k == dVar.f8434k && this.f8435l == dVar.f8435l && w.a(this.f8433j, dVar.f8433j) && Arrays.equals(this.f8436m, dVar.f8436m) && Arrays.equals(this.f8437n, dVar.f8437n)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = (((527 + (this.f8434k ? 1 : 0)) * 31) + (this.f8435l ? 1 : 0)) * 31;
        String str = this.f8433j;
        return i9 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8433j);
        parcel.writeByte(this.f8434k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8435l ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f8436m);
        i[] iVarArr = this.f8437n;
        parcel.writeInt(iVarArr.length);
        for (i iVar : iVarArr) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    public d(String str, boolean z8, boolean z9, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f8433j = str;
        this.f8434k = z8;
        this.f8435l = z9;
        this.f8436m = strArr;
        this.f8437n = iVarArr;
    }
}
