package q2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import java.util.Arrays;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends i {
    public static final Parcelable.Creator<l> CREATOR = new s(12);

    /* renamed from: j, reason: collision with root package name */
    public final String f8459j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f8460k;

    public l(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f8459j = readString;
        this.f8460k = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (w.a(this.f8459j, lVar.f8459j) && Arrays.equals(this.f8460k, lVar.f8460k)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8459j;
        return Arrays.hashCode(this.f8460k) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // q2.i
    public final String toString() {
        return this.f8450i + ": owner=" + this.f8459j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8459j);
        parcel.writeByteArray(this.f8460k);
    }

    public l(String str, byte[] bArr) {
        super("PRIV");
        this.f8459j = str;
        this.f8460k = bArr;
    }
}
