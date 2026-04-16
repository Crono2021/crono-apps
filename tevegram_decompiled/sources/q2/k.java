package q2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.w;
import java.util.Arrays;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends i {
    public static final Parcelable.Creator<k> CREATOR = new s(11);

    /* renamed from: j, reason: collision with root package name */
    public final int f8454j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8455k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8456l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f8457m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f8458n;

    public k(Parcel parcel) {
        super("MLLT");
        this.f8454j = parcel.readInt();
        this.f8455k = parcel.readInt();
        this.f8456l = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        int i9 = w.f3713a;
        this.f8457m = createIntArray;
        this.f8458n = parcel.createIntArray();
    }

    @Override // q2.i, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (this.f8454j == kVar.f8454j && this.f8455k == kVar.f8455k && this.f8456l == kVar.f8456l && Arrays.equals(this.f8457m, kVar.f8457m) && Arrays.equals(this.f8458n, kVar.f8458n)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8458n) + ((Arrays.hashCode(this.f8457m) + ((((((527 + this.f8454j) * 31) + this.f8455k) * 31) + this.f8456l) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f8454j);
        parcel.writeInt(this.f8455k);
        parcel.writeInt(this.f8456l);
        parcel.writeIntArray(this.f8457m);
        parcel.writeIntArray(this.f8458n);
    }

    public k(int i9, int i10, int[] iArr, int[] iArr2, int i11) {
        super("MLLT");
        this.f8454j = i9;
        this.f8455k = i10;
        this.f8456l = i11;
        this.f8457m = iArr;
        this.f8458n = iArr2;
    }
}
