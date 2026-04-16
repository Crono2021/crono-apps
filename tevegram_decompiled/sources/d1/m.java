package d1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new android.support.v4.media.a(15);

    /* renamed from: i, reason: collision with root package name */
    public int f2496i;

    /* renamed from: j, reason: collision with root package name */
    public final UUID f2497j;

    /* renamed from: k, reason: collision with root package name */
    public final String f2498k;

    /* renamed from: l, reason: collision with root package name */
    public final String f2499l;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f2500m;

    public m(Parcel parcel) {
        this.f2497j = new UUID(parcel.readLong(), parcel.readLong());
        this.f2498k = parcel.readString();
        String readString = parcel.readString();
        int i9 = g1.w.f3713a;
        this.f2499l = readString;
        this.f2500m = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        m mVar = (m) obj;
        return g1.w.a(this.f2498k, mVar.f2498k) && g1.w.a(this.f2499l, mVar.f2499l) && g1.w.a(this.f2497j, mVar.f2497j) && Arrays.equals(this.f2500m, mVar.f2500m);
    }

    public final int hashCode() {
        if (this.f2496i == 0) {
            int hashCode = this.f2497j.hashCode() * 31;
            String str = this.f2498k;
            this.f2496i = Arrays.hashCode(this.f2500m) + androidx.activity.g.k((hashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.f2499l);
        }
        return this.f2496i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        UUID uuid = this.f2497j;
        parcel.writeLong(uuid.getMostSignificantBits());
        parcel.writeLong(uuid.getLeastSignificantBits());
        parcel.writeString(this.f2498k);
        parcel.writeString(this.f2499l);
        parcel.writeByteArray(this.f2500m);
    }

    public m(UUID uuid, String str, String str2, byte[] bArr) {
        uuid.getClass();
        this.f2497j = uuid;
        this.f2498k = str;
        str2.getClass();
        this.f2499l = l0.k(str2);
        this.f2500m = bArr;
    }
}
