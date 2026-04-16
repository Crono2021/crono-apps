package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import com.network.tvgramplayer.voip.VoIPController;
import java.nio.charset.Charset;
import m7.c;
import x3.a;
import x3.b;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f579a = aVar.f(iconCompat.f579a, 1);
        byte[] bArr = iconCompat.f581c;
        if (aVar.e(2)) {
            Parcel parcel = ((b) aVar).f10096e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f581c = bArr;
        iconCompat.f582d = aVar.g(iconCompat.f582d, 3);
        iconCompat.f583e = aVar.f(iconCompat.f583e, 4);
        iconCompat.f584f = aVar.f(iconCompat.f584f, 5);
        iconCompat.f585g = (ColorStateList) aVar.g(iconCompat.f585g, 6);
        String str = iconCompat.f586i;
        if (aVar.e(7)) {
            str = ((b) aVar).f10096e.readString();
        }
        iconCompat.f586i = str;
        String str2 = iconCompat.f587j;
        if (aVar.e(8)) {
            str2 = ((b) aVar).f10096e.readString();
        }
        iconCompat.f587j = str2;
        iconCompat.h = PorterDuff.Mode.valueOf(iconCompat.f586i);
        switch (iconCompat.f579a) {
            case VoIPController.ERROR_PEER_OUTDATED /* -1 */:
                Parcelable parcelable = iconCompat.f582d;
                if (parcelable != null) {
                    iconCompat.f580b = parcelable;
                    return iconCompat;
                }
                c.n("Invalid icon");
                return null;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f582d;
                if (parcelable2 != null) {
                    iconCompat.f580b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f581c;
                iconCompat.f580b = bArr3;
                iconCompat.f579a = 3;
                iconCompat.f583e = 0;
                iconCompat.f584f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f581c, Charset.forName("UTF-16"));
                iconCompat.f580b = str3;
                if (iconCompat.f579a == 2 && iconCompat.f587j == null) {
                    iconCompat.f587j = str3.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f580b = iconCompat.f581c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.f586i = iconCompat.h.name();
        switch (iconCompat.f579a) {
            case VoIPController.ERROR_PEER_OUTDATED /* -1 */:
                iconCompat.f582d = (Parcelable) iconCompat.f580b;
                break;
            case 1:
            case 5:
                iconCompat.f582d = (Parcelable) iconCompat.f580b;
                break;
            case 2:
                iconCompat.f581c = ((String) iconCompat.f580b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f581c = (byte[]) iconCompat.f580b;
                break;
            case 4:
            case 6:
                iconCompat.f581c = iconCompat.f580b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i9 = iconCompat.f579a;
        if (-1 != i9) {
            aVar.j(i9, 1);
        }
        byte[] bArr = iconCompat.f581c;
        if (bArr != null) {
            aVar.i(2);
            Parcel parcel = ((b) aVar).f10096e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f582d;
        if (parcelable != null) {
            aVar.k(parcelable, 3);
        }
        int i10 = iconCompat.f583e;
        if (i10 != 0) {
            aVar.j(i10, 4);
        }
        int i11 = iconCompat.f584f;
        if (i11 != 0) {
            aVar.j(i11, 5);
        }
        ColorStateList colorStateList = iconCompat.f585g;
        if (colorStateList != null) {
            aVar.k(colorStateList, 6);
        }
        String str = iconCompat.f586i;
        if (str != null) {
            aVar.i(7);
            ((b) aVar).f10096e.writeString(str);
        }
        String str2 = iconCompat.f587j;
        if (str2 != null) {
            aVar.i(8);
            ((b) aVar).f10096e.writeString(str2);
        }
    }
}
