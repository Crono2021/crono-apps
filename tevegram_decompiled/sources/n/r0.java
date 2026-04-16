package n;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r0 extends View.BaseSavedState {
    public static final Parcelable.Creator<r0> CREATOR = new android.support.v4.media.a(23);

    /* renamed from: i, reason: collision with root package name */
    public boolean f7020i;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeByte(this.f7020i ? (byte) 1 : (byte) 0);
    }
}
