package a0;

import android.os.Parcel;
import android.os.Parcelable;
import n.f3;
import n.w3;
import o3.w0;
import x5.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f27a;

    public /* synthetic */ i(int i9) {
        this.f27a = i9;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f27a) {
            case 0:
                return new j(parcel, null);
            case 1:
                return new d5.d(parcel, null);
            case 2:
                return new e5.b(parcel, null);
            case 3:
                return new f3(parcel, null);
            case 4:
                return new w3(parcel, null);
            case 5:
                return new w0(parcel, null);
            case 6:
                return new o5.b(parcel, null);
            case 7:
                if (parcel.readParcelable(null) == null) {
                    return u0.b.f8990j;
                }
                m7.c.p("superState must be null");
                return null;
            case 8:
                return new v5.b(parcel, null);
            default:
                return new x(parcel, null);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i9) {
        switch (this.f27a) {
            case 0:
                return new j[i9];
            case 1:
                return new d5.d[i9];
            case 2:
                return new e5.b[i9];
            case 3:
                return new f3[i9];
            case 4:
                return new w3[i9];
            case 5:
                return new w0[i9];
            case 6:
                return new o5.b[i9];
            case 7:
                return new u0.b[i9];
            case 8:
                return new v5.b[i9];
            default:
                return new x[i9];
        }
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f27a) {
            case 0:
                return new j(parcel, classLoader);
            case 1:
                return new d5.d(parcel, classLoader);
            case 2:
                return new e5.b(parcel, classLoader);
            case 3:
                return new f3(parcel, classLoader);
            case 4:
                return new w3(parcel, classLoader);
            case 5:
                return new w0(parcel, classLoader);
            case 6:
                return new o5.b(parcel, classLoader);
            case 7:
                if (parcel.readParcelable(classLoader) == null) {
                    return u0.b.f8990j;
                }
                m7.c.p("superState must be null");
                return null;
            case 8:
                return new v5.b(parcel, classLoader);
            default:
                return new x(parcel, classLoader);
        }
    }
}
