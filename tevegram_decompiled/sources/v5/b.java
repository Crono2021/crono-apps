package v5;

import a0.i;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends u0.b {
    public static final Parcelable.Creator<b> CREATOR = new i(8);

    /* renamed from: k, reason: collision with root package name */
    public final int f9578k;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f9578k = parcel.readInt();
    }

    @Override // u0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeInt(this.f9578k);
    }

    public b(SideSheetBehavior sideSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f9578k = sideSheetBehavior.h;
    }
}
