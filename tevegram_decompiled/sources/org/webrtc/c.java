package org.webrtc;

import org.webrtc.EglBase;
import org.webrtc.EglBase10;
import org.webrtc.EglBase14;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8036a = 0;

    static {
        Object obj = EglBase.lock;
    }

    public static EglBase a(EglBase.Context context, int[] iArr) {
        if (context == null) {
            return EglBase14Impl.isEGL14Supported() ? new EglBase14Impl(null, iArr) : new EglBase10Impl(null, iArr);
        }
        if (context instanceof EglBase14.Context) {
            return new EglBase14Impl(((EglBase14.Context) context).getRawContext(), iArr);
        }
        if (context instanceof EglBase10.Context) {
            return new EglBase10Impl(((EglBase10.Context) context).getRawContext(), iArr);
        }
        m7.c.n("Unrecognized Context");
        return null;
    }

    public static int b(int[] iArr) {
        for (int i9 = 0; i9 < iArr.length - 1; i9++) {
            if (iArr[i9] == 12352) {
                int i10 = iArr[i9 + 1];
                if (i10 != 4) {
                    return i10 != 64 ? 1 : 3;
                }
                return 2;
            }
        }
        return 1;
    }
}
