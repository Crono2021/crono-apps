package q2;

import android.os.Parcel;
import android.os.Parcelable;
import b6.g0;
import b6.w0;
import g1.w;
import java.util.ArrayList;
import org.webrtc.PeerConnectionFactory;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m extends i {
    public static final Parcelable.Creator<m> CREATOR = new s(13);

    /* renamed from: j, reason: collision with root package name */
    public final String f8461j;

    /* renamed from: k, reason: collision with root package name */
    public final g0 f8462k;

    public m(String str, String str2, w0 w0Var) {
        super(str);
        g1.a.f(!w0Var.isEmpty());
        this.f8461j = str2;
        g0 m9 = g0.m(w0Var);
        this.f8462k = m9;
    }

    public static ArrayList d(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // q2.i, d1.i0
    public final void a(d1.g0 g0Var) {
        char c9;
        String str = this.f8450i;
        str.getClass();
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c9 = 5;
                    break;
                }
                c9 = 65535;
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c9 = 6;
                    break;
                }
                c9 = 65535;
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c9 = 7;
                    break;
                }
                c9 = 65535;
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c9 = '\b';
                    break;
                }
                c9 = 65535;
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c9 = '\t';
                    break;
                }
                c9 = 65535;
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c9 = '\n';
                    break;
                }
                c9 = 65535;
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c9 = 11;
                    break;
                }
                c9 = 65535;
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c9 = '\f';
                    break;
                }
                c9 = 65535;
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c9 = '\r';
                    break;
                }
                c9 = 65535;
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c9 = 14;
                    break;
                }
                c9 = 65535;
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c9 = 15;
                    break;
                }
                c9 = 65535;
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c9 = 16;
                    break;
                }
                c9 = 65535;
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c9 = 17;
                    break;
                }
                c9 = 65535;
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c9 = 18;
                    break;
                }
                c9 = 65535;
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c9 = 19;
                    break;
                }
                c9 = 65535;
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c9 = 20;
                    break;
                }
                c9 = 65535;
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c9 = 21;
                    break;
                }
                c9 = 65535;
                break;
            default:
                c9 = 65535;
                break;
        }
        g0 g0Var2 = this.f8462k;
        try {
            switch (c9) {
                case 0:
                case '\n':
                    g0Var.f2428c = (CharSequence) g0Var2.get(0);
                    break;
                case 1:
                case 11:
                    g0Var.f2443s = (CharSequence) g0Var2.get(0);
                    break;
                case 2:
                case '\f':
                    String str2 = (String) g0Var2.get(0);
                    int parseInt = Integer.parseInt(str2.substring(2, 4));
                    int parseInt2 = Integer.parseInt(str2.substring(0, 2));
                    g0Var.f2437m = Integer.valueOf(parseInt);
                    g0Var.f2438n = Integer.valueOf(parseInt2);
                    break;
                case 3:
                case 17:
                    g0Var.f2427b = (CharSequence) g0Var2.get(0);
                    break;
                case 4:
                case 18:
                    g0Var.f2429d = (CharSequence) g0Var2.get(0);
                    break;
                case 5:
                case 19:
                    g0Var.f2444t = (CharSequence) g0Var2.get(0);
                    break;
                case 6:
                case 20:
                    String str3 = (String) g0Var2.get(0);
                    int i9 = w.f3713a;
                    String[] split = str3.split("/", -1);
                    int parseInt3 = Integer.parseInt(split[0]);
                    Integer valueOf = split.length > 1 ? Integer.valueOf(Integer.parseInt(split[1])) : null;
                    g0Var.h = Integer.valueOf(parseInt3);
                    g0Var.f2433i = valueOf;
                    break;
                case 7:
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    g0Var.f2426a = (CharSequence) g0Var2.get(0);
                    break;
                case '\b':
                case 15:
                    g0Var.f2442r = (CharSequence) g0Var2.get(0);
                    break;
                case '\t':
                case 21:
                    g0Var.f2436l = Integer.valueOf(Integer.parseInt((String) g0Var2.get(0)));
                    break;
                case '\r':
                    ArrayList d9 = d((String) g0Var2.get(0));
                    int size = d9.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                g0Var.f2438n = (Integer) d9.get(2);
                            }
                        }
                        g0Var.f2437m = (Integer) d9.get(1);
                    }
                    g0Var.f2436l = (Integer) d9.get(0);
                    break;
                case 14:
                    ArrayList d10 = d((String) g0Var2.get(0));
                    int size2 = d10.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                g0Var.f2441q = (Integer) d10.get(2);
                            }
                        }
                        g0Var.f2440p = (Integer) d10.get(1);
                    }
                    g0Var.f2439o = (Integer) d10.get(0);
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (w.a(this.f8450i, mVar.f8450i) && w.a(this.f8461j, mVar.f8461j) && this.f8462k.equals(mVar.f8462k)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int k3 = androidx.activity.g.k(527, 31, this.f8450i);
        String str = this.f8461j;
        return this.f8462k.hashCode() + ((k3 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // q2.i
    public final String toString() {
        return this.f8450i + ": description=" + this.f8461j + ": values=" + this.f8462k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8450i);
        parcel.writeString(this.f8461j);
        parcel.writeStringArray((String[]) this.f8462k.toArray(new String[0]));
    }
}
