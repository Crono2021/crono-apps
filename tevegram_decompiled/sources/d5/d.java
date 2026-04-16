package d5;

import a0.i;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends u0.b {
    public static final Parcelable.Creator<d> CREATOR = new i(1);

    /* renamed from: k, reason: collision with root package name */
    public final int f2951k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2952l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f2953m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f2954n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f2955o;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2951k = parcel.readInt();
        this.f2952l = parcel.readInt();
        this.f2953m = parcel.readInt() == 1;
        this.f2954n = parcel.readInt() == 1;
        this.f2955o = parcel.readInt() == 1;
    }

    @Override // u0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeInt(this.f2951k);
        parcel.writeInt(this.f2952l);
        parcel.writeInt(this.f2953m ? 1 : 0);
        parcel.writeInt(this.f2954n ? 1 : 0);
        parcel.writeInt(this.f2955o ? 1 : 0);
    }

    public d(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f2951k = bottomSheetBehavior.L;
        this.f2952l = bottomSheetBehavior.f1928e;
        this.f2953m = bottomSheetBehavior.f1922b;
        this.f2954n = bottomSheetBehavior.I;
        this.f2955o = bottomSheetBehavior.J;
    }
}
