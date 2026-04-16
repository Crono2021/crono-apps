package u0;

import a0.i;
import android.os.Parcel;
import android.os.Parcelable;
import m7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b implements Parcelable {

    /* renamed from: i, reason: collision with root package name */
    public final Parcelable f8991i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f8990j = new a();
    public static final Parcelable.Creator<b> CREATOR = new i(7);

    public b(Parcelable parcelable) {
        if (parcelable != null) {
            this.f8991i = parcelable == f8990j ? null : parcelable;
        } else {
            c.n("superState must not be null");
            throw null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeParcelable(this.f8991i, i9);
    }

    public b() {
        this.f8991i = null;
    }

    public b(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f8991i = readParcelable == null ? f8990j : readParcelable;
    }
}
