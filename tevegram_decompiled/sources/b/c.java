package b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends Binder implements b {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1123c = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1124b;

    public c(d dVar) {
        this.f1124b = dVar;
        attachInterface(this, b.f1122a);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
        String str = b.f1122a;
        if (i9 >= 1 && i9 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i9 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        if (i9 != 1) {
            return super.onTransact(i9, parcel, parcel2, i10);
        }
        this.f1124b.d(parcel.readInt(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
