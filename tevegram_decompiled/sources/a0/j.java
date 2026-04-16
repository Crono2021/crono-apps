package a0;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends u0.b {
    public static final Parcelable.Creator<j> CREATOR = new i(0);

    /* renamed from: k, reason: collision with root package name */
    public SparseArray f28k;

    public j(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        this.f28k = new SparseArray(readInt);
        for (int i9 = 0; i9 < readInt; i9++) {
            this.f28k.append(iArr[i9], readParcelableArray[i9]);
        }
    }

    @Override // u0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        SparseArray sparseArray = this.f28k;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f28k.keyAt(i10);
            parcelableArr[i10] = (Parcelable) this.f28k.valueAt(i10);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i9);
    }
}
