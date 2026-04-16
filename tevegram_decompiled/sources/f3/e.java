package f3;

import d1.k0;
import g1.w;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import z2.h;
import z2.k;
import z2.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements l {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f3336j = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f3337k = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f3338l = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f3339m = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f3340n = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f3341o = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f3342p = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: q, reason: collision with root package name */
    public static final d f3343q = new d(30.0f, 1, 1);

    /* renamed from: i, reason: collision with root package name */
    public final XmlPullParserFactory f3344i;

    public e() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f3344i = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e9) {
            m7.c.k("Couldn't create XmlPullParserFactory instance", e9);
            throw null;
        }
    }

    public static g a(g gVar) {
        return gVar == null ? new g() : gVar;
    }

    public static boolean b(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    public static int c(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return 15;
        }
        Matcher matcher = f3342p.matcher(attributeValue);
        if (!matcher.matches()) {
            g1.a.D("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return 15;
        }
        boolean z8 = true;
        try {
            String group = matcher.group(1);
            group.getClass();
            int parseInt = Integer.parseInt(group);
            String group2 = matcher.group(2);
            group2.getClass();
            int parseInt2 = Integer.parseInt(group2);
            if (parseInt == 0 || parseInt2 == 0) {
                z8 = false;
            }
            g1.a.e("Invalid cell resolution " + parseInt + " " + parseInt2, z8);
            return parseInt2;
        } catch (NumberFormatException unused) {
            g1.a.D("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return 15;
        }
    }

    public static void d(String str, g gVar) {
        Matcher matcher;
        String group;
        int i9 = w.f3713a;
        String[] split = str.split("\\s+", -1);
        int length = split.length;
        Pattern pattern = f3338l;
        if (length == 1) {
            matcher = pattern.matcher(str);
        } else {
            if (split.length != 2) {
                throw new h("Invalid number of entries for fontSize: " + split.length + ".");
            }
            matcher = pattern.matcher(split[1]);
            g1.a.D("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new h(androidx.activity.g.n("Invalid expression for fontSize: '", str, "'."));
        }
        group = matcher.group(3);
        group.getClass();
        switch (group) {
            case "%":
                gVar.f3362j = 3;
                break;
            case "em":
                gVar.f3362j = 2;
                break;
            case "px":
                gVar.f3362j = 1;
                break;
            default:
                throw new h(androidx.activity.g.n("Invalid unit for fontSize: '", group, "'."));
        }
        String group2 = matcher.group(1);
        group2.getClass();
        gVar.f3363k = Float.parseFloat(group2);
    }

    public static d e(XmlPullParser xmlPullParser) {
        float f9;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i9 = w.f3713a;
            g1.a.e("frameRateMultiplier doesn't have 2 parts", attributeValue2.split(" ", -1).length == 2);
            f9 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f9 = 1.0f;
        }
        d dVar = f3343q;
        int i10 = dVar.f3334b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i10 = Integer.parseInt(attributeValue3);
        }
        int i11 = dVar.f3335c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i11 = Integer.parseInt(attributeValue4);
        }
        return new d(parseInt * f9, i10, i11);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(org.xmlpull.v1.XmlPullParser r19, java.util.HashMap r20, int r21, d1.k0 r22, java.util.HashMap r23, java.util.HashMap r24) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.f(org.xmlpull.v1.XmlPullParser, java.util.HashMap, int, d1.k0, java.util.HashMap, java.util.HashMap):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static c g(XmlPullParser xmlPullParser, c cVar, HashMap hashMap, d dVar) {
        long j5;
        char c9;
        String[] split;
        int attributeCount = xmlPullParser.getAttributeCount();
        String[] strArr = null;
        g h = h(xmlPullParser, null);
        String str = null;
        String str2 = "";
        long j9 = -9223372036854775807L;
        long j10 = -9223372036854775807L;
        long j11 = -9223372036854775807L;
        for (int i9 = 0; i9 < attributeCount; i9++) {
            String attributeName = xmlPullParser.getAttributeName(i9);
            String attributeValue = xmlPullParser.getAttributeValue(i9);
            attributeName.getClass();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c9 = 0;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c9 = 1;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c9 = 2;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c9 = 3;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c9 = 4;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c9 = 5;
                        break;
                    }
                    c9 = 65535;
                    break;
                default:
                    c9 = 65535;
                    break;
            }
            switch (c9) {
                case 0:
                    if (!hashMap.containsKey(attributeValue)) {
                        break;
                    } else {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j11 = i(attributeValue, dVar);
                    break;
                case 2:
                    j10 = i(attributeValue, dVar);
                    break;
                case 3:
                    j9 = i(attributeValue, dVar);
                    break;
                case 4:
                    String trim = attributeValue.trim();
                    if (trim.isEmpty()) {
                        split = new String[0];
                    } else {
                        int i10 = w.f3713a;
                        split = trim.split("\\s+", -1);
                    }
                    if (split.length > 0) {
                        strArr = split;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (cVar != null) {
            long j12 = cVar.f3324d;
            if (j12 != -9223372036854775807L) {
                if (j9 != -9223372036854775807L) {
                    j9 += j12;
                }
                if (j10 != -9223372036854775807L) {
                    j10 += j12;
                }
            }
        }
        if (j10 == -9223372036854775807L) {
            if (j11 != -9223372036854775807L) {
                j10 = j9 + j11;
            } else if (cVar != null) {
                long j13 = cVar.f3325e;
                if (j13 != -9223372036854775807L) {
                    j5 = j13;
                    return new c(xmlPullParser.getName(), null, j9, j5, h, strArr, str2, str, cVar);
                }
            }
        }
        j5 = j10;
        return new c(xmlPullParser.getName(), null, j9, j5, h, strArr, str2, str, cVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:103:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x023f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f3.g h(org.xmlpull.v1.XmlPullParser r18, f3.g r19) {
        /*
            Method dump skipped, instructions count: 1494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.h(org.xmlpull.v1.XmlPullParser, f3.g):f3.g");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ad, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long i(java.lang.String r13, f3.d r14) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.i(java.lang.String, f3.d):long");
    }

    public static k0 j(XmlPullParser xmlPullParser) {
        String s8 = g1.a.s(xmlPullParser, "extent");
        if (s8 == null) {
            return null;
        }
        Matcher matcher = f3341o.matcher(s8);
        if (!matcher.matches()) {
            g1.a.D("TtmlParser", "Ignoring non-pixel tts extent: ".concat(s8));
            return null;
        }
        try {
            String group = matcher.group(1);
            group.getClass();
            int parseInt = Integer.parseInt(group);
            String group2 = matcher.group(2);
            group2.getClass();
            return new k0(parseInt, Integer.parseInt(group2));
        } catch (NumberFormatException unused) {
            g1.a.D("TtmlParser", "Ignoring malformed tts extent: ".concat(s8));
            return null;
        }
    }

    @Override // z2.l
    public final void a0(byte[] bArr, int i9, int i10, k kVar, g1.c cVar) {
        z2.d.c(h0(i9, i10, bArr), kVar, cVar);
    }

    @Override // z2.l
    public final z2.f h0(int i9, int i10, byte[] bArr) {
        try {
            XmlPullParser newPullParser = this.f3344i.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new f("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            k0 k0Var = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, i9, i10), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            d dVar = f3343q;
            c7.a aVar = null;
            int i11 = 15;
            int i12 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                c cVar = (c) arrayDeque.peek();
                if (i12 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            dVar = e(newPullParser);
                            i11 = c(newPullParser);
                            k0Var = j(newPullParser);
                        }
                        d dVar2 = dVar;
                        k0 k0Var2 = k0Var;
                        int i13 = i11;
                        if (b(name)) {
                            if ("head".equals(name)) {
                                f(newPullParser, hashMap, i13, k0Var2, hashMap2, hashMap3);
                            } else {
                                try {
                                    c g9 = g(newPullParser, cVar, hashMap2, dVar2);
                                    arrayDeque.push(g9);
                                    if (cVar != null) {
                                        if (cVar.f3332m == null) {
                                            cVar.f3332m = new ArrayList();
                                        }
                                        cVar.f3332m.add(g9);
                                    }
                                } catch (h e9) {
                                    g1.a.E("TtmlParser", "Suppressing parser error", e9);
                                }
                            }
                            i11 = i13;
                            k0Var = k0Var2;
                            dVar = dVar2;
                        } else {
                            g1.a.v("TtmlParser", "Ignoring unsupported tag: " + newPullParser.getName());
                        }
                        i12++;
                        i11 = i13;
                        k0Var = k0Var2;
                        dVar = dVar2;
                    } else if (eventType == 4) {
                        cVar.getClass();
                        c a9 = c.a(newPullParser.getText());
                        if (cVar.f3332m == null) {
                            cVar.f3332m = new ArrayList();
                        }
                        cVar.f3332m.add(a9);
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            c cVar2 = (c) arrayDeque.peek();
                            cVar2.getClass();
                            aVar = new c7.a(cVar2, hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i12++;
                } else if (eventType == 3) {
                    i12--;
                }
                newPullParser.next();
            }
            aVar.getClass();
            return aVar;
        } catch (IOException e10) {
            throw new IllegalStateException("Unexpected error when reading input.", e10);
        } catch (XmlPullParserException e11) {
            throw new IllegalStateException("Unable to decode source", e11);
        }
    }

    @Override // z2.l
    public final /* synthetic */ void reset() {
    }
}
