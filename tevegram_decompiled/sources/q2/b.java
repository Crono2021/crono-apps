package q2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends i {
    public static final Parcelable.Creator<b> CREATOR = new s(5);

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f8426j;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = g1.w.f3713a
            r2.<init>(r0)
            byte[] r3 = r3.createByteArray()
            r2.f8426j = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.b.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f8450i.equals(bVar.f8450i) && Arrays.equals(this.f8426j, bVar.f8426j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8426j) + androidx.activity.g.k(527, 31, this.f8450i);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8450i);
        parcel.writeByteArray(this.f8426j);
    }

    public b(String str, byte[] bArr) {
        super(str);
        this.f8426j = bArr;
    }
}
