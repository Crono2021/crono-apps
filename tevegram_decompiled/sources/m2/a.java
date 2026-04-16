package m2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.g;
import d1.g0;
import d1.i0;
import d1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements i0 {
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.media.a(22);

    /* renamed from: i, reason: collision with root package name */
    public final int f6603i;

    /* renamed from: j, reason: collision with root package name */
    public final String f6604j;

    public a(int i9, String str) {
        this.f6603i = i9;
        this.f6604j = str;
    }

    @Override // d1.i0
    public final /* synthetic */ s b() {
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

    public final String toString() {
        StringBuilder sb = new StringBuilder("Ait(controlCode=");
        sb.append(this.f6603i);
        sb.append(",url=");
        return g.o(sb, this.f6604j, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f6604j);
        parcel.writeInt(this.f6603i);
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }
}
