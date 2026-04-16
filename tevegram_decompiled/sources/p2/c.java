package p2;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import java.util.Arrays;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements i0 {
    public static final Parcelable.Creator<c> CREATOR = new s(3);

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f8244i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8245j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8246k;

    public c(Parcel parcel) {
        byte[] createByteArray = parcel.createByteArray();
        createByteArray.getClass();
        this.f8244i = createByteArray;
        this.f8245j = parcel.readString();
        this.f8246k = parcel.readString();
    }

    @Override // d1.i0
    public final void a(g0 g0Var) {
        String str = this.f8245j;
        if (str != null) {
            g0Var.f2426a = str;
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
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f8244i, ((c) obj).f8244i);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8244i);
    }

    public final String toString() {
        return "ICY: title=\"" + this.f8245j + "\", url=\"" + this.f8246k + "\", rawMetadata.length=\"" + this.f8244i.length + "\"";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeByteArray(this.f8244i);
        parcel.writeString(this.f8245j);
        parcel.writeString(this.f8246k);
    }

    public c(byte[] bArr, String str, String str2) {
        this.f8244i = bArr;
        this.f8245j = str;
        this.f8246k = str2;
    }
}
