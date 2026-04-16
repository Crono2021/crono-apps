package r2;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements i0 {
    public static final Parcelable.Creator<a> CREATOR = new s(16);

    /* renamed from: i, reason: collision with root package name */
    public final long f8531i;

    /* renamed from: j, reason: collision with root package name */
    public final long f8532j;

    /* renamed from: k, reason: collision with root package name */
    public final long f8533k;

    /* renamed from: l, reason: collision with root package name */
    public final long f8534l;

    /* renamed from: m, reason: collision with root package name */
    public final long f8535m;

    public a(Parcel parcel) {
        this.f8531i = parcel.readLong();
        this.f8532j = parcel.readLong();
        this.f8533k = parcel.readLong();
        this.f8534l = parcel.readLong();
        this.f8535m = parcel.readLong();
    }

    @Override // d1.i0
    public final /* synthetic */ d1.s b() {
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
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f8531i == aVar.f8531i && this.f8532j == aVar.f8532j && this.f8533k == aVar.f8533k && this.f8534l == aVar.f8534l && this.f8535m == aVar.f8535m) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return android.support.v4.media.session.b.U(this.f8535m) + ((android.support.v4.media.session.b.U(this.f8534l) + ((android.support.v4.media.session.b.U(this.f8533k) + ((android.support.v4.media.session.b.U(this.f8532j) + ((android.support.v4.media.session.b.U(this.f8531i) + 527) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f8531i + ", photoSize=" + this.f8532j + ", photoPresentationTimestampUs=" + this.f8533k + ", videoStartPosition=" + this.f8534l + ", videoSize=" + this.f8535m;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeLong(this.f8531i);
        parcel.writeLong(this.f8532j);
        parcel.writeLong(this.f8533k);
        parcel.writeLong(this.f8534l);
        parcel.writeLong(this.f8535m);
    }

    public a(long j5, long j9, long j10, long j11, long j12) {
        this.f8531i = j5;
        this.f8532j = j9;
        this.f8533k = j10;
        this.f8534l = j11;
        this.f8535m = j12;
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }
}
