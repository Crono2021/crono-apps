package r2;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import java.util.ArrayList;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements i0 {
    public static final Parcelable.Creator<c> CREATOR = new s(17);

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f8539i;

    public c(ArrayList arrayList) {
        this.f8539i = arrayList;
        boolean z8 = false;
        if (!arrayList.isEmpty()) {
            long j5 = ((b) arrayList.get(0)).f8537j;
            int i9 = 1;
            while (true) {
                if (i9 >= arrayList.size()) {
                    break;
                }
                if (((b) arrayList.get(i9)).f8536i < j5) {
                    z8 = true;
                    break;
                } else {
                    j5 = ((b) arrayList.get(i9)).f8537j;
                    i9++;
                }
            }
        }
        g1.a.f(!z8);
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
        return this.f8539i.equals(((c) obj).f8539i);
    }

    public final int hashCode() {
        return this.f8539i.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.f8539i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeList(this.f8539i);
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }
}
