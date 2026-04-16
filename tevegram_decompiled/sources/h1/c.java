package h1;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import d1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements i0 {
    public static final Parcelable.Creator<c> CREATOR = new android.support.v4.media.a(20);

    /* renamed from: i, reason: collision with root package name */
    public final long f3856i;

    /* renamed from: j, reason: collision with root package name */
    public final long f3857j;

    /* renamed from: k, reason: collision with root package name */
    public final long f3858k;

    public c(Parcel parcel) {
        this.f3856i = parcel.readLong();
        this.f3857j = parcel.readLong();
        this.f3858k = parcel.readLong();
    }

    @Override // d1.i0
    public final /* synthetic */ s b() {
        return null;
    }

    @Override // d1.i0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3856i == cVar.f3856i && this.f3857j == cVar.f3857j && this.f3858k == cVar.f3858k;
    }

    public final int hashCode() {
        return android.support.v4.media.session.b.U(this.f3858k) + ((android.support.v4.media.session.b.U(this.f3857j) + ((android.support.v4.media.session.b.U(this.f3856i) + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.f3856i + ", modification time=" + this.f3857j + ", timescale=" + this.f3858k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeLong(this.f3856i);
        parcel.writeLong(this.f3857j);
        parcel.writeLong(this.f3858k);
    }

    public c(long j5, long j9, long j10) {
        this.f3856i = j5;
        this.f3857j = j9;
        this.f3858k = j10;
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }
}
