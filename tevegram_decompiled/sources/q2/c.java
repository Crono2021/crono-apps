package q2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import java.util.Arrays;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends i {
    public static final Parcelable.Creator<c> CREATOR = new s(6);

    /* renamed from: j, reason: collision with root package name */
    public final String f8427j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8428k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8429l;

    /* renamed from: m, reason: collision with root package name */
    public final long f8430m;

    /* renamed from: n, reason: collision with root package name */
    public final long f8431n;

    /* renamed from: o, reason: collision with root package name */
    public final i[] f8432o;

    public c(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f8427j = readString;
        this.f8428k = parcel.readInt();
        this.f8429l = parcel.readInt();
        this.f8430m = parcel.readLong();
        this.f8431n = parcel.readLong();
        int readInt = parcel.readInt();
        this.f8432o = new i[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f8432o[i10] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }

    @Override // q2.i, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f8428k == cVar.f8428k && this.f8429l == cVar.f8429l && this.f8430m == cVar.f8430m && this.f8431n == cVar.f8431n && w.a(this.f8427j, cVar.f8427j) && Arrays.equals(this.f8432o, cVar.f8432o)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = (((((((527 + this.f8428k) * 31) + this.f8429l) * 31) + ((int) this.f8430m)) * 31) + ((int) this.f8431n)) * 31;
        String str = this.f8427j;
        return i9 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8427j);
        parcel.writeInt(this.f8428k);
        parcel.writeInt(this.f8429l);
        parcel.writeLong(this.f8430m);
        parcel.writeLong(this.f8431n);
        i[] iVarArr = this.f8432o;
        parcel.writeInt(iVarArr.length);
        for (i iVar : iVarArr) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    public c(String str, int i9, int i10, long j5, long j9, i[] iVarArr) {
        super("CHAP");
        this.f8427j = str;
        this.f8428k = i9;
        this.f8429l = i10;
        this.f8430m = j5;
        this.f8431n = j9;
        this.f8432o = iVarArr;
    }
}
