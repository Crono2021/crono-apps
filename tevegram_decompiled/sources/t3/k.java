package t3;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends View.BaseSavedState {
    public static final Parcelable.Creator<k> CREATOR = new s(26);

    /* renamed from: i, reason: collision with root package name */
    public final boolean f8960i;

    public k(Parcel parcel) {
        super(parcel);
        this.f8960i = parcel.readByte() != 0;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeByte(this.f8960i ? (byte) 1 : (byte) 0);
    }

    public k(Parcelable parcelable, boolean z8) {
        super(parcelable);
        this.f8960i = z8;
    }
}
