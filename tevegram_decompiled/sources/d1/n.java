package d1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n implements Comparator, Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new android.support.v4.media.a(14);

    /* renamed from: i, reason: collision with root package name */
    public final m[] f2503i;

    /* renamed from: j, reason: collision with root package name */
    public int f2504j;

    /* renamed from: k, reason: collision with root package name */
    public final String f2505k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2506l;

    public n(Parcel parcel) {
        this.f2505k = parcel.readString();
        m[] mVarArr = (m[]) parcel.createTypedArray(m.CREATOR);
        int i9 = g1.w.f3713a;
        this.f2503i = mVarArr;
        this.f2506l = mVarArr.length;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        UUID uuid = i.f2478a;
        return uuid.equals(mVar.f2497j) ? uuid.equals(mVar2.f2497j) ? 0 : 1 : mVar.f2497j.compareTo(mVar2.f2497j);
    }

    public final n d(String str) {
        return g1.w.a(this.f2505k, str) ? this : new n(str, false, this.f2503i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            if (g1.w.a(this.f2505k, nVar.f2505k) && Arrays.equals(this.f2503i, nVar.f2503i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f2504j == 0) {
            String str = this.f2505k;
            this.f2504j = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f2503i);
        }
        return this.f2504j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f2505k);
        parcel.writeTypedArray(this.f2503i, 0);
    }

    public n(String str, boolean z8, m... mVarArr) {
        this.f2505k = str;
        mVarArr = z8 ? (m[]) mVarArr.clone() : mVarArr;
        this.f2503i = mVarArr;
        this.f2506l = mVarArr.length;
        Arrays.sort(mVarArr, this);
    }
}
