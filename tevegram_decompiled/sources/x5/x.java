package x5;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x extends u0.b {
    public static final Parcelable.Creator<x> CREATOR = new a0.i(9);

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f10215k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10216l;

    public x(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f10215k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f10216l = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f10215k) + "}";
    }

    @Override // u0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        TextUtils.writeToParcel(this.f10215k, parcel, i9);
        parcel.writeInt(this.f10216l ? 1 : 0);
    }
}
