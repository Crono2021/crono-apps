package n;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f3 extends u0.b {
    public static final Parcelable.Creator<f3> CREATOR = new a0.i(3);

    /* renamed from: k, reason: collision with root package name */
    public boolean f6862k;

    public f3(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6862k = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f6862k + "}";
    }

    @Override // u0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeValue(Boolean.valueOf(this.f6862k));
    }
}
