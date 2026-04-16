package o3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k1 implements Parcelable {
    public static final Parcelable.Creator<k1> CREATOR = new android.support.v4.media.a(29);

    /* renamed from: i, reason: collision with root package name */
    public int f7709i;

    /* renamed from: j, reason: collision with root package name */
    public int f7710j;

    /* renamed from: k, reason: collision with root package name */
    public int f7711k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f7712l;

    /* renamed from: m, reason: collision with root package name */
    public int f7713m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f7714n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f7715o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7716p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7717q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7718r;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f7709i);
        parcel.writeInt(this.f7710j);
        parcel.writeInt(this.f7711k);
        if (this.f7711k > 0) {
            parcel.writeIntArray(this.f7712l);
        }
        parcel.writeInt(this.f7713m);
        if (this.f7713m > 0) {
            parcel.writeIntArray(this.f7714n);
        }
        parcel.writeInt(this.f7716p ? 1 : 0);
        parcel.writeInt(this.f7717q ? 1 : 0);
        parcel.writeInt(this.f7718r ? 1 : 0);
        parcel.writeList(this.f7715o);
    }
}
