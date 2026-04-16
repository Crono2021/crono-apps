package n2;

import android.os.Parcel;
import android.os.Parcelable;
import d1.g0;
import d1.i0;
import d1.l0;
import d1.r;
import d1.s;
import g1.w;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements i0 {
    public static final Parcelable.Creator<a> CREATOR;

    /* renamed from: o, reason: collision with root package name */
    public static final s f7426o;

    /* renamed from: p, reason: collision with root package name */
    public static final s f7427p;

    /* renamed from: i, reason: collision with root package name */
    public final String f7428i;

    /* renamed from: j, reason: collision with root package name */
    public final String f7429j;

    /* renamed from: k, reason: collision with root package name */
    public final long f7430k;

    /* renamed from: l, reason: collision with root package name */
    public final long f7431l;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f7432m;

    /* renamed from: n, reason: collision with root package name */
    public int f7433n;

    static {
        r rVar = new r();
        rVar.f2528l = l0.k("application/id3");
        f7426o = new s(rVar);
        r rVar2 = new r();
        rVar2.f2528l = l0.k("application/x-scte35");
        f7427p = new s(rVar2);
        CREATOR = new android.support.v4.media.a(24);
    }

    public a(Parcel parcel) {
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f7428i = readString;
        this.f7429j = parcel.readString();
        this.f7430k = parcel.readLong();
        this.f7431l = parcel.readLong();
        this.f7432m = parcel.createByteArray();
    }

    @Override // d1.i0
    public final s b() {
        String str = this.f7428i;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f7427p;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f7426o;
            default:
                return null;
        }
    }

    @Override // d1.i0
    public final byte[] c() {
        if (b() != null) {
            return this.f7432m;
        }
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
            if (this.f7430k == aVar.f7430k && this.f7431l == aVar.f7431l && w.a(this.f7428i, aVar.f7428i) && w.a(this.f7429j, aVar.f7429j) && Arrays.equals(this.f7432m, aVar.f7432m)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f7433n == 0) {
            String str = this.f7428i;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f7429j;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j5 = this.f7430k;
            int i9 = (hashCode2 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            long j9 = this.f7431l;
            this.f7433n = Arrays.hashCode(this.f7432m) + ((i9 + ((int) (j9 ^ (j9 >>> 32)))) * 31);
        }
        return this.f7433n;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f7428i + ", id=" + this.f7431l + ", durationMs=" + this.f7430k + ", value=" + this.f7429j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f7428i);
        parcel.writeString(this.f7429j);
        parcel.writeLong(this.f7430k);
        parcel.writeLong(this.f7431l);
        parcel.writeByteArray(this.f7432m);
    }

    public a(String str, String str2, long j5, long j9, byte[] bArr) {
        this.f7428i = str;
        this.f7429j = str2;
        this.f7430k = j5;
        this.f7431l = j9;
        this.f7432m = bArr;
    }

    @Override // d1.i0
    public final /* synthetic */ void a(g0 g0Var) {
    }
}
