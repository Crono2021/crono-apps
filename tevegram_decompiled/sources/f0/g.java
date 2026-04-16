package f0;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final android.support.v4.media.session.b f3200a;

    /* renamed from: b, reason: collision with root package name */
    public static final j3.e f3201b;

    static {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            f3200a = new l();
        } else if (i9 >= 28) {
            f3200a = new k();
        } else if (i9 >= 26) {
            f3200a = new j();
        } else {
            if (i9 >= 24) {
                Method method = i.f3209q;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    f3200a = new i();
                }
            }
            f3200a = new h();
        }
        f3201b = new j3.e(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        if (r1.equals(r5) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r12, e0.e r13, android.content.res.Resources r14, int r15, java.lang.String r16, int r17, int r18, e0.b r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.g.a(android.content.Context, e0.e, android.content.res.Resources, int, java.lang.String, int, int, e0.b, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i9, String str, int i10, int i11) {
        return resources.getResourcePackageName(i9) + '-' + str + '-' + i10 + '-' + i9 + '-' + i11;
    }
}
