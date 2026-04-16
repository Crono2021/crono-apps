package k2;

import b6.a0;
import b6.e0;
import b6.g0;
import b6.q;
import b6.w0;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f5539a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f5540b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f5541c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        if (r6 == (-1)) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b2.d0 a(java.lang.String r20) {
        /*
            org.xmlpull.v1.XmlPullParserFactory r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance()
            org.xmlpull.v1.XmlPullParser r0 = r0.newPullParser()
            java.io.StringReader r1 = new java.io.StringReader
            r2 = r20
            r1.<init>(r2)
            r0.setInput(r1)
            r0.next()
            java.lang.String r1 = "x:xmpmeta"
            boolean r2 = g1.a.x(r0, r1)
            r3 = 0
            if (r2 == 0) goto Lcf
            b6.e0 r2 = b6.g0.f1391j
            b6.w0 r2 = b6.w0.f1464m
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r4
        L28:
            r0.next()
            java.lang.String r8 = "rdf:Description"
            boolean r8 = g1.a.x(r0, r8)
            r9 = 1
            if (r8 == 0) goto L9b
            r2 = 0
            r6 = 0
        L36:
            r7 = 4
            if (r6 >= r7) goto Lc8
            java.lang.String[] r8 = k2.d.f5539a
            r8 = r8[r6]
            java.lang.String r8 = g1.a.s(r0, r8)
            if (r8 == 0) goto L98
            int r6 = java.lang.Integer.parseInt(r8)
            if (r6 != r9) goto Lc8
            r6 = 0
        L4a:
            if (r6 >= r7) goto L60
            java.lang.String[] r8 = k2.d.f5540b
            r8 = r8[r6]
            java.lang.String r8 = g1.a.s(r0, r8)
            if (r8 == 0) goto L62
            long r6 = java.lang.Long.parseLong(r8)
            r10 = -1
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 != 0) goto L65
        L60:
            r6 = r4
            goto L65
        L62:
            int r6 = r6 + 1
            goto L4a
        L65:
            r8 = 2
            if (r2 >= r8) goto L93
            java.lang.String[] r8 = k2.d.f5541c
            r8 = r8[r2]
            java.lang.String r8 = g1.a.s(r0, r8)
            if (r8 == 0) goto L90
            long r12 = java.lang.Long.parseLong(r8)
            k2.b r14 = new k2.b
            r16 = 0
            r18 = 0
            java.lang.String r15 = "image/jpeg"
            r14.<init>(r15, r16, r18)
            r2 = r14
            k2.b r10 = new k2.b
            java.lang.String r11 = "video/mp4"
            r14 = 0
            r10.<init>(r11, r12, r14)
            b6.w0 r2 = b6.g0.r(r2, r10)
            goto Lbc
        L90:
            int r2 = r2 + 1
            goto L65
        L93:
            b6.e0 r2 = b6.g0.f1391j
            b6.w0 r2 = b6.w0.f1464m
            goto Lbc
        L98:
            int r6 = r6 + 1
            goto L36
        L9b:
            java.lang.String r8 = "Container:Directory"
            boolean r8 = g1.a.x(r0, r8)
            if (r8 == 0) goto Lac
            java.lang.String r2 = "Container"
            java.lang.String r8 = "Item"
            b6.w0 r2 = b(r0, r2, r8)
            goto Lbc
        Lac:
            java.lang.String r8 = "GContainer:Directory"
            boolean r8 = g1.a.x(r0, r8)
            if (r8 == 0) goto Lbc
            java.lang.String r2 = "GContainer"
            java.lang.String r8 = "GContainerItem"
            b6.w0 r2 = b(r0, r2, r8)
        Lbc:
            boolean r8 = g1.a.w(r0, r1)
            if (r8 == 0) goto L28
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto Lc9
        Lc8:
            return r3
        Lc9:
            b2.d0 r0 = new b2.d0
            r0.<init>(r9, r6, r2)
            return r0
        Lcf:
            java.lang.String r0 = "Couldn't find xmp metadata"
            d1.m0 r0 = d1.m0.a(r3, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.d.a(java.lang.String):b2.d0");
    }

    public static w0 b(XmlPullParser xmlPullParser, String str, String str2) {
        e0 e0Var = g0.f1391j;
        q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        String concat = str.concat(":Item");
        String concat2 = str.concat(":Directory");
        int i9 = 0;
        boolean z8 = false;
        do {
            xmlPullParser.next();
            if (g1.a.x(xmlPullParser, concat)) {
                String concat3 = str2.concat(":Mime");
                String concat4 = str2.concat(":Semantic");
                String concat5 = str2.concat(":Length");
                String concat6 = str2.concat(":Padding");
                String s8 = g1.a.s(xmlPullParser, concat3);
                String s9 = g1.a.s(xmlPullParser, concat4);
                String s10 = g1.a.s(xmlPullParser, concat5);
                String s11 = g1.a.s(xmlPullParser, concat6);
                if (s8 == null || s9 == null) {
                    return w0.f1464m;
                }
                b bVar = new b(s8, s10 != null ? Long.parseLong(s10) : 0L, s11 != null ? Long.parseLong(s11) : 0L);
                int i10 = i9 + 1;
                if (objArr.length < i10) {
                    objArr = Arrays.copyOf(objArr, a0.d(objArr.length, i10));
                } else {
                    if (z8) {
                        objArr = (Object[]) objArr.clone();
                    }
                    objArr[i9] = bVar;
                    i9++;
                }
                z8 = false;
                objArr[i9] = bVar;
                i9++;
            }
        } while (!g1.a.w(xmlPullParser, concat2));
        return g0.l(i9, objArr);
    }
}
