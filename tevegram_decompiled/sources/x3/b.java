package x3;

import android.os.Parcel;
import android.util.SparseIntArray;
import androidx.activity.g;
import s.d;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f10095d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f10096e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10097f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10098g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public int f10099i;

    /* renamed from: j, reason: collision with root package name */
    public int f10100j;

    /* renamed from: k, reason: collision with root package name */
    public int f10101k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new d(), new d(), new d());
    }

    @Override // x3.a
    public final b a() {
        Parcel parcel = this.f10096e;
        int dataPosition = parcel.dataPosition();
        int i9 = this.f10100j;
        if (i9 == this.f10097f) {
            i9 = this.f10098g;
        }
        return new b(parcel, dataPosition, i9, g.o(new StringBuilder(), this.h, "  "), this.f10092a, this.f10093b, this.f10094c);
    }

    @Override // x3.a
    public final boolean e(int i9) {
        while (true) {
            int i10 = this.f10100j;
            int i11 = this.f10101k;
            if (i10 >= this.f10098g) {
                return i11 == i9;
            }
            if (i11 == i9) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i9)) > 0) {
                return false;
            }
            int i12 = this.f10100j;
            Parcel parcel = this.f10096e;
            parcel.setDataPosition(i12);
            int readInt = parcel.readInt();
            this.f10101k = parcel.readInt();
            this.f10100j += readInt;
        }
    }

    @Override // x3.a
    public final void i(int i9) {
        int i10 = this.f10099i;
        SparseIntArray sparseIntArray = this.f10095d;
        Parcel parcel = this.f10096e;
        if (i10 >= 0) {
            int i11 = sparseIntArray.get(i10);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i11);
            parcel.writeInt(dataPosition - i11);
            parcel.setDataPosition(dataPosition);
        }
        this.f10099i = i9;
        sparseIntArray.put(i9, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i9);
    }

    public b(Parcel parcel, int i9, int i10, String str, d dVar, d dVar2, d dVar3) {
        super(dVar, dVar2, dVar3);
        this.f10095d = new SparseIntArray();
        this.f10099i = -1;
        this.f10101k = -1;
        this.f10096e = parcel;
        this.f10097f = i9;
        this.f10098g = i10;
        this.f10100j = i9;
        this.h = str;
    }
}
