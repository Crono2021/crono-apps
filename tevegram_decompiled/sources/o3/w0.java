package o3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w0 extends u0.b {
    public static final Parcelable.Creator<w0> CREATOR = new a0.i(5);

    /* renamed from: k, reason: collision with root package name */
    public Parcelable f7831k;

    public w0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f7831k = parcel.readParcelable(classLoader == null ? o0.class.getClassLoader() : classLoader);
    }

    @Override // u0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeParcelable(this.f7831k, 0);
    }
}
