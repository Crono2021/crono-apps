package s2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.p;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends b {
    public static final Parcelable.Creator<j> CREATOR = new s(24);

    /* renamed from: i, reason: collision with root package name */
    public final long f8799i;

    /* renamed from: j, reason: collision with root package name */
    public final long f8800j;

    public j(long j5, long j9) {
        this.f8799i = j5;
        this.f8800j = j9;
    }

    public static long d(long j5, p pVar) {
        long t8 = pVar.t();
        if ((128 & t8) != 0) {
            return 8589934591L & ((((t8 & 1) << 32) | pVar.v()) + j5);
        }
        return -9223372036854775807L;
    }

    @Override // s2.b
    public final String toString() {
        return "SCTE-35 TimeSignalCommand { ptsTime=" + this.f8799i + ", playbackPositionUs= " + this.f8800j + " }";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeLong(this.f8799i);
        parcel.writeLong(this.f8800j);
    }
}
