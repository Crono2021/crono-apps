package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new android.support.v4.media.a(8);

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f763i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f764j;

    /* renamed from: k, reason: collision with root package name */
    public c[] f765k;

    /* renamed from: l, reason: collision with root package name */
    public int f766l;

    /* renamed from: m, reason: collision with root package name */
    public String f767m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f768n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f769o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f770p;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeTypedList(this.f763i);
        parcel.writeStringList(this.f764j);
        parcel.writeTypedArray(this.f765k, i9);
        parcel.writeInt(this.f766l);
        parcel.writeString(this.f767m);
        parcel.writeStringList(this.f768n);
        parcel.writeTypedList(this.f769o);
        parcel.writeTypedList(this.f770p);
    }
}
