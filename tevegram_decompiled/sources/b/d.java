package b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new android.support.v4.media.a(10);

    /* renamed from: i, reason: collision with root package name */
    public b f1125i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        synchronized (this) {
            try {
                if (this.f1125i == null) {
                    this.f1125i = new c(this);
                }
                parcel.writeStrongBinder(this.f1125i.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(int i9, Bundle bundle) {
    }
}
