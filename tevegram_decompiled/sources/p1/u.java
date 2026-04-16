package p1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import d1.g0;
import d1.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u implements i0 {
    public static final Parcelable.Creator<u> CREATOR = new s(0);

    /* renamed from: i, reason: collision with root package name */
    public final String f8225i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8226j;

    /* renamed from: k, reason: collision with root package name */
    public final List f8227k;

    public u(Parcel parcel) {
        this.f8225i = parcel.readString();
        this.f8226j = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i9 = 0; i9 < readInt; i9++) {
            arrayList.add((t) parcel.readParcelable(t.class.getClassLoader()));
        }
        this.f8227k = Collections.unmodifiableList(arrayList);
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
        if (obj != null && u.class == obj.getClass()) {
            u uVar = (u) obj;
            if (TextUtils.equals(this.f8225i, uVar.f8225i) && TextUtils.equals(this.f8226j, uVar.f8226j) && this.f8227k.equals(uVar.f8227k)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8225i;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8226j;
        return this.f8227k.hashCode() + ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        String str = this.f8225i;
        return "HlsTrackMetadataEntry".concat(str != null ? androidx.activity.g.o(androidx.activity.g.r(" [", str, ", "), this.f8226j, "]") : "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8225i);
        parcel.writeString(this.f8226j);
        List list = this.f8227k;
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeParcelable((Parcelable) list.get(i10), 0);
        }
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }

    public u(String str, String str2, List list) {
        this.f8225i = str;
        this.f8226j = str2;
        this.f8227k = Collections.unmodifiableList(new ArrayList(list));
    }
}
