package r2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import java.util.Arrays;
import java.util.Locale;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new s(18);

    /* renamed from: i, reason: collision with root package name */
    public final long f8536i;

    /* renamed from: j, reason: collision with root package name */
    public final long f8537j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8538k;

    public b(long j5, long j9, int i9) {
        g1.a.f(j5 < j9);
        this.f8536i = j5;
        this.f8537j = j9;
        this.f8538k = i9;
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
            if (this.f8536i == bVar.f8536i && this.f8537j == bVar.f8537j && this.f8538k == bVar.f8538k) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f8536i), Long.valueOf(this.f8537j), Integer.valueOf(this.f8538k)});
    }

    public final String toString() {
        int i9 = w.f3713a;
        Locale locale = Locale.US;
        StringBuilder c9 = t.a.c("Segment: startTimeMs=", this.f8536i, ", endTimeMs=");
        c9.append(this.f8537j);
        c9.append(", speedDivisor=");
        c9.append(this.f8538k);
        return c9.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeLong(this.f8536i);
        parcel.writeLong(this.f8537j);
        parcel.writeInt(this.f8538k);
    }
}
