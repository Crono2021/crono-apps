package androidx.activity;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.h0;
import d2.d0;
import java.util.HashMap;
import java.util.Iterator;
import org.webrtc.Logging;
import org.webrtc.TextureBufferImpl;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract /* synthetic */ class g {
    public static /* synthetic */ String A(int i9) {
        return i9 != 1 ? i9 != 2 ? i9 != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }

    public static /* synthetic */ String B(int i9) {
        return i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }

    public static /* synthetic */ String C(int i9) {
        return i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? i9 != 5 ? "null" : "MEMORY_CACHE" : "RESOURCE_DISK_CACHE" : "DATA_DISK_CACHE" : "REMOTE" : "LOCAL";
    }

    public static /* synthetic */ String D(int i9) {
        switch (i9) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }

    public static final void a(View view, int i9) {
        int a9 = v.h.a(i9);
        if (a9 == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (h0.D(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (a9 == 1) {
            if (h0.D(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (a9 == 2) {
            if (h0.D(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (a9 != 3) {
            return;
        }
        if (h0.D(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static int b(int i9) {
        if (i9 == 0) {
            return 2;
        }
        if (i9 == 4) {
            return 4;
        }
        if (i9 == 8) {
            return 3;
        }
        m7.c.n(m(i9, "Unknown visibility "));
        return 0;
    }

    public static int c(View view) {
        if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
            return 4;
        }
        return b(view.getVisibility());
    }

    public static final boolean d(int i9) {
        return !j6.a.a();
    }

    public static final boolean e(int i9) {
        Boolean bool;
        if (j6.a.a()) {
            try {
                bool = (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
            } catch (Exception unused) {
                j6.a.f5435a.info("Conscrypt is not available or does not support checking for FIPS build.");
                bool = Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static int f(int i9, int i10, int i11, int i12) {
        return i9 | i10 | i11 | 128 | i12;
    }

    public static TextureBufferImpl g(TextureBufferImpl textureBufferImpl, boolean z8, int i9) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (z8) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preRotate(i9);
        matrix.preTranslate(-0.5f, -0.5f);
        return textureBufferImpl.applyTransformMatrix(matrix, textureBufferImpl.getWidth(), textureBufferImpl.getHeight());
    }

    public static /* synthetic */ boolean h(int i9) {
        if (i9 == 1 || i9 == 2 || i9 == 3) {
            return false;
        }
        if (i9 == 4 || i9 == 5) {
            return true;
        }
        throw null;
    }

    public static int i(int i9, int i10, int i11) {
        return com.google.crypto.tink.shaded.protobuf.n.h(i9) + i10 + i11;
    }

    public static int j(int i9, int i10, int i11, int i12) {
        return com.google.crypto.tink.shaded.protobuf.n.i(i9) + i10 + i11 + i12;
    }

    public static int k(int i9, int i10, String str) {
        return (str.hashCode() + i9) * i10;
    }

    public static ClassCastException l(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String m(int i9, String str) {
        return str + i9;
    }

    public static String n(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder p(int i9, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i9);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder q(String str, int i9, String str2, int i10, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i9);
        sb.append(str2);
        sb.append(i10);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder r(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void s(int i9, int i10, int i11, int i12, int i13) {
        g1.w.H(i9);
        g1.w.H(i10);
        g1.w.H(i11);
        g1.w.H(i12);
        g1.w.H(i13);
    }

    public static void t(int i9, String str, String str2) {
        g1.a.D(str2, str + i9);
    }

    public static void u(int i9, HashMap hashMap, String str, int i10, String str2) {
        hashMap.put(str, Integer.valueOf(i9));
        hashMap.put(str2, Integer.valueOf(i10));
    }

    public static void v(d1.r rVar, d0 d0Var) {
        d0Var.e(new d1.s(rVar));
    }

    public static /* synthetic */ void w(Object obj) {
        if (obj == null) {
            return;
        }
        androidx.fragment.app.a.c();
    }

    public static void x(String str, String str2, String str3) {
        g1.a.D(str3, str + str2);
    }

    public static void y(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Logging.d(str2, sb.toString());
    }

    public static void z(i7.x xVar, i7.x xVar2) {
        if (xVar == xVar2) {
            return;
        }
        if (xVar2 != null) {
            xVar2.getClass();
        }
        if (xVar != null) {
            xVar.getClass();
        }
    }
}
