package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import x3.a;
import x3.b;
import x3.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVar = remoteActionCompat.f567a;
        boolean z8 = true;
        if (aVar.e(1)) {
            cVar = aVar.h();
        }
        remoteActionCompat.f567a = (IconCompat) cVar;
        CharSequence charSequence = remoteActionCompat.f568b;
        if (aVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f10096e);
        }
        remoteActionCompat.f568b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f569c;
        if (aVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) aVar).f10096e);
        }
        remoteActionCompat.f569c = charSequence2;
        remoteActionCompat.f570d = (PendingIntent) aVar.g(remoteActionCompat.f570d, 4);
        boolean z9 = remoteActionCompat.f571e;
        if (aVar.e(5)) {
            z9 = ((b) aVar).f10096e.readInt() != 0;
        }
        remoteActionCompat.f571e = z9;
        boolean z10 = remoteActionCompat.f572f;
        if (!aVar.e(6)) {
            z8 = z10;
        } else if (((b) aVar).f10096e.readInt() == 0) {
            z8 = false;
        }
        remoteActionCompat.f572f = z8;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f567a;
        aVar.i(1);
        aVar.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f568b;
        aVar.i(2);
        Parcel parcel = ((b) aVar).f10096e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f569c;
        aVar.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        aVar.k(remoteActionCompat.f570d, 4);
        boolean z8 = remoteActionCompat.f571e;
        aVar.i(5);
        parcel.writeInt(z8 ? 1 : 0);
        boolean z9 = remoteActionCompat.f572f;
        aVar.i(6);
        parcel.writeInt(z9 ? 1 : 0);
    }
}
