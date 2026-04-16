package s2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends b {
    public static final Parcelable.Creator<i> CREATOR = new s(23);

    /* renamed from: i, reason: collision with root package name */
    public final List f8798i;

    public i(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i9 = 0; i9 < readInt; i9++) {
            arrayList.add(new h(parcel));
        }
        this.f8798i = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        List list = this.f8798i;
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = (h) list.get(i10);
            parcel.writeLong(hVar.f8788a);
            parcel.writeByte(hVar.f8789b ? (byte) 1 : (byte) 0);
            parcel.writeByte(hVar.f8790c ? (byte) 1 : (byte) 0);
            parcel.writeByte(hVar.f8791d ? (byte) 1 : (byte) 0);
            List list2 = hVar.f8793f;
            int size2 = list2.size();
            parcel.writeInt(size2);
            for (int i11 = 0; i11 < size2; i11++) {
                g gVar = (g) list2.get(i11);
                parcel.writeInt(gVar.f8786a);
                parcel.writeLong(gVar.f8787b);
            }
            parcel.writeLong(hVar.f8792e);
            parcel.writeByte(hVar.f8794g ? (byte) 1 : (byte) 0);
            parcel.writeLong(hVar.h);
            parcel.writeInt(hVar.f8795i);
            parcel.writeInt(hVar.f8796j);
            parcel.writeInt(hVar.f8797k);
        }
    }

    public i(ArrayList arrayList) {
        this.f8798i = Collections.unmodifiableList(arrayList);
    }
}
