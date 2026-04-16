package p2;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import g1.w;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements i0 {
    public static final Parcelable.Creator<b> CREATOR = new s(2);

    /* renamed from: i, reason: collision with root package name */
    public final int f8238i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8239j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8240k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8241l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f8242m;

    /* renamed from: n, reason: collision with root package name */
    public final int f8243n;

    public b(Parcel parcel) {
        this.f8238i = parcel.readInt();
        this.f8239j = parcel.readString();
        this.f8240k = parcel.readString();
        this.f8241l = parcel.readString();
        int i9 = w.f3713a;
        this.f8242m = parcel.readInt() != 0;
        this.f8243n = parcel.readInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p2.b d(java.util.Map r14) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.b.d(java.util.Map):p2.b");
    }

    @Override // d1.i0
    public final void a(g0 g0Var) {
        String str = this.f8240k;
        if (str != null) {
            g0Var.f2446v = str;
        }
        String str2 = this.f8239j;
        if (str2 != null) {
            g0Var.f2445u = str2;
        }
    }

    @Override // d1.i0
    public final /* synthetic */ d1.s b() {
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
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f8238i == bVar.f8238i && w.a(this.f8239j, bVar.f8239j) && w.a(this.f8240k, bVar.f8240k) && w.a(this.f8241l, bVar.f8241l) && this.f8242m == bVar.f8242m && this.f8243n == bVar.f8243n) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = (527 + this.f8238i) * 31;
        String str = this.f8239j;
        int hashCode = (i9 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8240k;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8241l;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f8242m ? 1 : 0)) * 31) + this.f8243n;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.f8240k + "\", genre=\"" + this.f8239j + "\", bitrate=" + this.f8238i + ", metadataInterval=" + this.f8243n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f8238i);
        parcel.writeString(this.f8239j);
        parcel.writeString(this.f8240k);
        parcel.writeString(this.f8241l);
        int i10 = w.f3713a;
        parcel.writeInt(this.f8242m ? 1 : 0);
        parcel.writeInt(this.f8243n);
    }

    public b(int i9, String str, String str2, String str3, boolean z8, int i10) {
        g1.a.f(i10 == -1 || i10 > 0);
        this.f8238i = i9;
        this.f8239j = str;
        this.f8240k = str2;
        this.f8241l = str3;
        this.f8242m = z8;
        this.f8243n = i10;
    }
}
