package d1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 implements Parcelable {
    public static final Parcelable.Creator<j0> CREATOR = new android.support.v4.media.a(16);

    /* renamed from: i, reason: collision with root package name */
    public final i0[] f2490i;

    /* renamed from: j, reason: collision with root package name */
    public final long f2491j;

    public j0(Parcel parcel) {
        this.f2490i = new i0[parcel.readInt()];
        int i9 = 0;
        while (true) {
            i0[] i0VarArr = this.f2490i;
            if (i9 >= i0VarArr.length) {
                this.f2491j = parcel.readLong();
                return;
            } else {
                i0VarArr[i9] = (i0) parcel.readParcelable(i0.class.getClassLoader());
                i9++;
            }
        }
    }

    public final j0 d(i0... i0VarArr) {
        if (i0VarArr.length == 0) {
            return this;
        }
        int i9 = g1.w.f3713a;
        i0[] i0VarArr2 = this.f2490i;
        Object[] copyOf = Arrays.copyOf(i0VarArr2, i0VarArr2.length + i0VarArr.length);
        System.arraycopy(i0VarArr, 0, copyOf, i0VarArr2.length, i0VarArr.length);
        return new j0(this.f2491j, (i0[]) copyOf);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final j0 e(j0 j0Var) {
        return j0Var == null ? this : d(j0Var.f2490i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j0.class == obj.getClass()) {
            j0 j0Var = (j0) obj;
            if (Arrays.equals(this.f2490i, j0Var.f2490i) && this.f2491j == j0Var.f2491j) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return android.support.v4.media.session.b.U(this.f2491j) + (Arrays.hashCode(this.f2490i) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("entries=");
        sb.append(Arrays.toString(this.f2490i));
        long j5 = this.f2491j;
        if (j5 == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j5;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        i0[] i0VarArr = this.f2490i;
        parcel.writeInt(i0VarArr.length);
        for (i0 i0Var : i0VarArr) {
            parcel.writeParcelable(i0Var, 0);
        }
        parcel.writeLong(this.f2491j);
    }

    public j0(long j5, i0... i0VarArr) {
        this.f2491j = j5;
        this.f2490i = i0VarArr;
    }

    public j0(List list) {
        this((i0[]) list.toArray(new i0[0]));
    }

    public j0(i0... i0VarArr) {
        this(-9223372036854775807L, i0VarArr);
    }
}
