package p1;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import b6.g0;
import java.util.ArrayList;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8218a;

    public /* synthetic */ s(int i9) {
        this.f8218a = i9;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f8218a) {
            case 0:
                return new u(parcel);
            case 1:
                return new t(parcel);
            case 2:
                return new p2.b(parcel);
            case 3:
                return new p2.c(parcel);
            case 4:
                return new q2.a(parcel);
            case 5:
                return new q2.b(parcel);
            case 6:
                return new q2.c(parcel);
            case 7:
                return new q2.d(parcel);
            case 8:
                return new q2.e(parcel);
            case 9:
                return new q2.f(parcel);
            case 10:
                return new q2.j(parcel);
            case 11:
                return new q2.k(parcel);
            case 12:
                return new q2.l(parcel);
            case 13:
                String readString = parcel.readString();
                readString.getClass();
                String readString2 = parcel.readString();
                String[] createStringArray = parcel.createStringArray();
                createStringArray.getClass();
                return new q2.m(readString, readString2, g0.n(createStringArray));
            case 14:
                return new q2.n(parcel);
            case 15:
                r0.k kVar = new r0.k(parcel);
                kVar.f8514i = parcel.readInt();
                return kVar;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return new r2.a(parcel);
            case 17:
                ArrayList arrayList = new ArrayList();
                parcel.readList(arrayList, r2.b.class.getClassLoader());
                return new r2.c(arrayList);
            case 18:
                return new r2.b(parcel.readLong(), parcel.readLong(), parcel.readInt());
            case 19:
                return new r2.d(parcel);
            case 20:
                return new s2.a(parcel);
            case 21:
                return new s2.e(parcel);
            case 22:
                return new s2.f();
            case 23:
                return new s2.i(parcel);
            case 24:
                return new s2.j(parcel.readLong(), parcel.readLong());
            case 25:
                return new t2.a(parcel);
            case 26:
                return new t3.k(parcel);
            default:
                return new ParcelImpl(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i9) {
        switch (this.f8218a) {
            case 0:
                return new u[i9];
            case 1:
                return new t[i9];
            case 2:
                return new p2.b[i9];
            case 3:
                return new p2.c[i9];
            case 4:
                return new q2.a[i9];
            case 5:
                return new q2.b[i9];
            case 6:
                return new q2.c[i9];
            case 7:
                return new q2.d[i9];
            case 8:
                return new q2.e[i9];
            case 9:
                return new q2.f[i9];
            case 10:
                return new q2.j[i9];
            case 11:
                return new q2.k[i9];
            case 12:
                return new q2.l[i9];
            case 13:
                return new q2.m[i9];
            case 14:
                return new q2.n[i9];
            case 15:
                return new r0.k[i9];
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return new r2.a[i9];
            case 17:
                return new r2.c[i9];
            case 18:
                return new r2.b[i9];
            case 19:
                return new r2.d[i9];
            case 20:
                return new s2.a[i9];
            case 21:
                return new s2.e[i9];
            case 22:
                return new s2.f[i9];
            case 23:
                return new s2.i[i9];
            case 24:
                return new s2.j[i9];
            case 25:
                return new t2.a[i9];
            case 26:
                return new t3.k[i9];
            default:
                return new ParcelImpl[i9];
        }
    }
}
