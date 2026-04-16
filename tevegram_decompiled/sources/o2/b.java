package o2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.g;
import d1.g0;
import d1.i0;
import d1.s;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class b implements i0 {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(26);

    /* renamed from: i, reason: collision with root package name */
    public final String f7583i;

    /* renamed from: j, reason: collision with root package name */
    public final String f7584j;

    public b(Parcel parcel) {
        String readString = parcel.readString();
        int i9 = w.f3713a;
        this.f7583i = readString;
        this.f7584j = parcel.readString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // d1.i0
    public final void a(g0 g0Var) {
        String str = this.f7583i;
        str.getClass();
        char c9 = 65535;
        switch (str.hashCode()) {
            case 62359119:
                if (str.equals("ALBUM")) {
                    c9 = 0;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c9 = 1;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c9 = 2;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c9 = 3;
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c9 = 4;
                    break;
                }
                break;
        }
        String str2 = this.f7584j;
        switch (c9) {
            case 0:
                g0Var.f2428c = str2;
                break;
            case 1:
                g0Var.f2426a = str2;
                break;
            case 2:
                g0Var.f2430e = str2;
                break;
            case 3:
                g0Var.f2429d = str2;
                break;
            case 4:
                g0Var.f2427b = str2;
                break;
        }
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
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f7583i.equals(bVar.f7583i) && this.f7584j.equals(bVar.f7584j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7584j.hashCode() + g.k(527, 31, this.f7583i);
    }

    public final String toString() {
        return "VC: " + this.f7583i + "=" + this.f7584j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f7583i);
        parcel.writeString(this.f7584j);
    }

    public b(String str, String str2) {
        this.f7583i = a.a.V(str);
        this.f7584j = str2;
    }
}
