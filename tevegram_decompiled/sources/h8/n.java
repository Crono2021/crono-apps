package h8;

import a8.p;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class n implements p {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ List f4233i;

    public /* synthetic */ n(List list) {
        this.f4233i = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d9 A[RETURN] */
    @Override // a8.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.Object r10, java.lang.Object r11) {
        /*
            r9 = this;
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r10.getClass()
            java.util.List r0 = r9.f4233i
            int r1 = r0.size()
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 != r3) goto L48
            int r1 = r0.size()
            if (r1 == 0) goto L40
            if (r1 != r3) goto L39
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 4
            int r10 = h8.e.j0(r10, r0, r11, r2, r1)
            if (r10 >= 0) goto L2e
        L2b:
            r11 = r4
            goto Lc3
        L2e:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            n7.b r11 = new n7.b
            r11.<init>(r10, r0)
            goto Lc3
        L39:
            java.lang.String r10 = "List has more than one element."
            m7.c.n(r10)
            r10 = 0
            return r10
        L40:
            java.util.NoSuchElementException r10 = new java.util.NoSuchElementException
            java.lang.String r11 = "List is empty."
            r10.<init>(r11)
            throw r10
        L48:
            e8.c r1 = new e8.c
            if (r11 >= 0) goto L4d
            r11 = 0
        L4d:
            int r5 = r10.length()
            r1.<init>(r11, r5, r3)
            boolean r3 = r10 instanceof java.lang.String
            int r1 = r1.f3159j
            if (r3 == 0) goto L90
            if (r11 <= r1) goto L5d
            goto L2b
        L5d:
            java.util.Iterator r3 = r0.iterator()
        L61:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L7c
            java.lang.Object r5 = r3.next()
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            r7 = r10
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r6.length()
            boolean r6 = r6.regionMatches(r2, r7, r11, r8)
            if (r6 == 0) goto L61
            goto L7d
        L7c:
            r5 = r4
        L7d:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L8b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            n7.b r11 = new n7.b
            r11.<init>(r10, r5)
            goto Lc3
        L8b:
            if (r11 == r1) goto L2b
            int r11 = r11 + 1
            goto L5d
        L90:
            if (r11 <= r1) goto L93
            goto L2b
        L93:
            java.util.Iterator r3 = r0.iterator()
        L97:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto Laf
            java.lang.Object r5 = r3.next()
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            int r7 = r6.length()
            boolean r6 = h8.e.n0(r6, r10, r11, r7, r2)
            if (r6 == 0) goto L97
            goto Lb0
        Laf:
            r5 = r4
        Lb0:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto Lbe
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            n7.b r11 = new n7.b
            r11.<init>(r10, r5)
            goto Lc3
        Lbe:
            if (r11 == r1) goto L2b
            int r11 = r11 + 1
            goto L93
        Lc3:
            if (r11 == 0) goto Ld9
            java.lang.Object r10 = r11.f7480i
            java.lang.Object r11 = r11.f7481j
            java.lang.String r11 = (java.lang.String) r11
            int r11 = r11.length()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            n7.b r0 = new n7.b
            r0.<init>(r10, r11)
            return r0
        Ld9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h8.n.h(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
