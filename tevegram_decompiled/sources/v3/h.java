package v3;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends k {
    public static final String[] F = {"android:visibility:visibility", "android:visibility:parent"};
    public final int E;

    public h() {
        this.E = 3;
    }

    public static void F(q qVar) {
        View view = qVar.f9549b;
        int visibility = view.getVisibility();
        HashMap hashMap = qVar.f9548a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static v3.z H(v3.q r8, v3.q r9) {
        /*
            v3.z r0 = new v3.z
            r0.<init>()
            r1 = 0
            r0.f9568a = r1
            r0.f9569b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f9548a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f9570c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f9572e = r6
            goto L33
        L2f:
            r0.f9570c = r3
            r0.f9572e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f9548a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f9571d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f9573f = r2
            goto L56
        L52:
            r0.f9571d = r3
            r0.f9573f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f9570c
            int r9 = r0.f9571d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f9572e
            android.view.ViewGroup r4 = r0.f9573f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f9569b = r1
            r0.f9568a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.f9569b = r2
            r0.f9568a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f9573f
            if (r8 != 0) goto L81
            r0.f9569b = r1
            r0.f9568a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.f9572e
            if (r8 != 0) goto L9f
            r0.f9569b = r2
            r0.f9568a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f9571d
            if (r8 != 0) goto L95
            r0.f9569b = r2
            r0.f9568a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f9570c
            if (r8 != 0) goto L9f
            r0.f9569b = r1
            r0.f9568a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.h.H(v3.q, v3.q):v3.z");
    }

    public final ObjectAnimator G(View view, float f9, float f10) {
        if (f9 == f10) {
            return null;
        }
        r.f9551a.a0(view, f9);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, r.f9552b, f10);
        ofFloat.addListener(new o3.p(view));
        a(new g(view, 0));
        return ofFloat;
    }

    @Override // v3.k
    public final void c(q qVar) {
        F(qVar);
    }

    @Override // v3.k
    public final void f(q qVar) {
        F(qVar);
        qVar.f9548a.put("android:fade:transitionAlpha", Float.valueOf(r.f9551a.Z(qVar.f9549b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if (H(m(r3, false), p(r3, false)).f9568a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01fa  */
    @Override // v3.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator j(android.view.ViewGroup r23, v3.q r24, v3.q r25) {
        /*
            Method dump skipped, instructions count: 745
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.h.j(android.view.ViewGroup, v3.q, v3.q):android.animation.Animator");
    }

    @Override // v3.k
    public final String[] o() {
        return F;
    }

    @Override // v3.k
    public final boolean q(q qVar, q qVar2) {
        if (qVar == null && qVar2 == null) {
            return false;
        }
        if (qVar != null && qVar2 != null && qVar2.f9548a.containsKey("android:visibility:visibility") != qVar.f9548a.containsKey("android:visibility:visibility")) {
            return false;
        }
        z H = H(qVar, qVar2);
        if (H.f9568a) {
            return H.f9570c == 0 || H.f9571d == 0;
        }
        return false;
    }

    public h(int i9) {
        this();
        this.E = i9;
    }
}
