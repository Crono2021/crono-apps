package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 implements Parcelable {
    public static final Parcelable.Creator<l0> CREATOR = new android.support.v4.media.a(9);

    /* renamed from: i, reason: collision with root package name */
    public final String f782i;

    /* renamed from: j, reason: collision with root package name */
    public final String f783j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f784k;

    /* renamed from: l, reason: collision with root package name */
    public final int f785l;

    /* renamed from: m, reason: collision with root package name */
    public final int f786m;

    /* renamed from: n, reason: collision with root package name */
    public final String f787n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f788o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f789p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f790q;

    /* renamed from: r, reason: collision with root package name */
    public final Bundle f791r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f792s;

    /* renamed from: t, reason: collision with root package name */
    public final int f793t;

    /* renamed from: u, reason: collision with root package name */
    public Bundle f794u;

    public l0(Parcel parcel) {
        this.f782i = parcel.readString();
        this.f783j = parcel.readString();
        this.f784k = parcel.readInt() != 0;
        this.f785l = parcel.readInt();
        this.f786m = parcel.readInt();
        this.f787n = parcel.readString();
        this.f788o = parcel.readInt() != 0;
        this.f789p = parcel.readInt() != 0;
        this.f790q = parcel.readInt() != 0;
        this.f791r = parcel.readBundle();
        this.f792s = parcel.readInt() != 0;
        this.f794u = parcel.readBundle();
        this.f793t = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f782i);
        sb.append(" (");
        sb.append(this.f783j);
        sb.append(")}:");
        if (this.f784k) {
            sb.append(" fromLayout");
        }
        int i9 = this.f786m;
        if (i9 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i9));
        }
        String str = this.f787n;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f788o) {
            sb.append(" retainInstance");
        }
        if (this.f789p) {
            sb.append(" removing");
        }
        if (this.f790q) {
            sb.append(" detached");
        }
        if (this.f792s) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f782i);
        parcel.writeString(this.f783j);
        parcel.writeInt(this.f784k ? 1 : 0);
        parcel.writeInt(this.f785l);
        parcel.writeInt(this.f786m);
        parcel.writeString(this.f787n);
        parcel.writeInt(this.f788o ? 1 : 0);
        parcel.writeInt(this.f789p ? 1 : 0);
        parcel.writeInt(this.f790q ? 1 : 0);
        parcel.writeBundle(this.f791r);
        parcel.writeInt(this.f792s ? 1 : 0);
        parcel.writeBundle(this.f794u);
        parcel.writeInt(this.f793t);
    }

    public l0(s sVar) {
        this.f782i = sVar.getClass().getName();
        this.f783j = sVar.f846m;
        this.f784k = sVar.f854u;
        this.f785l = sVar.D;
        this.f786m = sVar.E;
        this.f787n = sVar.F;
        this.f788o = sVar.I;
        this.f789p = sVar.f853t;
        this.f790q = sVar.H;
        this.f791r = sVar.f847n;
        this.f792s = sVar.G;
        this.f793t = sVar.S.ordinal();
    }
}
