package l;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f5721e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f5722f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f5723a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f5724b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f5725c;

    /* renamed from: d, reason: collision with root package name */
    public Object f5726d;

    static {
        Class[] clsArr = {Context.class};
        f5721e = clsArr;
        f5722f = clsArr;
    }

    public i(Context context) {
        super(context);
        this.f5725c = context;
        Object[] objArr = {context};
        this.f5723a = objArr;
        this.f5724b = objArr;
    }

    public static Object a(Object obj) {
        return obj instanceof Activity ? obj : obj instanceof ContextWrapper ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        if (r3 == 1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        if (r3 == r5) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        if (r3 == 3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        r8 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0266, code lost:
    
        r3 = r8.next();
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        r3 = r17.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r10 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (r3.equals(r11) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        r8 = r17;
        r10 = false;
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r3.equals("group") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        r2.f5697b = 0;
        r2.f5698c = 0;
        r2.f5699d = 0;
        r2.f5700e = 0;
        r2.f5701f = true;
        r2.f5702g = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        if (r3.equals("item") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        if (r2.h != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        r3 = r2.f5720z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
    
        if (r3 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        if (r3.f6473a.hasSubMenu() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        r2.h = true;
        r2.b(r2.f5696a.addSubMenu(r2.f5697b, r2.f5703i, r2.f5704j, r2.f5705k).getItem());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
    
        r2.h = true;
        r2.b(r2.f5696a.add(r2.f5697b, r2.f5703i, r2.f5704j, r2.f5705k));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
    
        if (r3.equals("menu") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b8, code lost:
    
        r8 = r17;
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00be, code lost:
    
        if (r10 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
    
        r3 = r17.getName();
        r13 = r3.equals("group");
        r15 = r16.f5725c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cd, code lost:
    
        if (r13 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cf, code lost:
    
        r3 = r15.obtainStyledAttributes(r18, f.a.f3180p);
        r2.f5697b = r3.getResourceId(1, 0);
        r2.f5698c = r3.getInt(3, 0);
        r2.f5699d = r3.getInt(4, 0);
        r2.f5700e = r3.getInt(5, 0);
        r2.f5701f = r3.getBoolean(2, true);
        r2.f5702g = r3.getBoolean(0, true);
        r3.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0104, code lost:
    
        if (r3.equals("item") == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0106, code lost:
    
        r3 = r15.obtainStyledAttributes(r18, f.a.f3181q);
        r2.f5703i = r3.getResourceId(2, 0);
        r2.f5704j = (r3.getInt(5, r2.f5698c) & (-65536)) | (r3.getInt(6, r2.f5699d) & 65535);
        r2.f5705k = r3.getText(7);
        r2.f5706l = r3.getText(8);
        r2.f5707m = r3.getResourceId(0, 0);
        r8 = r3.getString(9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0144, code lost:
    
        if (r8 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0146, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014c, code lost:
    
        r2.f5708n = r8;
        r2.f5709o = r3.getInt(16, 4096);
        r8 = r3.getString(10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x015e, code lost:
    
        if (r8 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0160, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0166, code lost:
    
        r2.f5710p = r8;
        r2.f5711q = r3.getInt(20, 4096);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0176, code lost:
    
        if (r3.hasValue(11) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0178, code lost:
    
        r2.f5712r = r3.getBoolean(11, false) ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0183, code lost:
    
        r2.f5713s = r3.getBoolean(3, false);
        r2.f5714t = r3.getBoolean(4, r2.f5701f);
        r2.f5715u = r3.getBoolean(1, r2.f5702g);
        r2.f5716v = r3.getInt(21, -1);
        r2.f5719y = r3.getString(12);
        r2.f5717w = r3.getResourceId(13, 0);
        r2.f5718x = r3.getString(15);
        r5 = r3.getString(14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c0, code lost:
    
        if (r5 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01c2, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01c5, code lost:
    
        if (r12 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c9, code lost:
    
        if (r2.f5717w != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01cd, code lost:
    
        if (r2.f5718x != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01cf, code lost:
    
        r2.f5720z = (m.p) r2.a(r5, l.i.f5722f, r16.f5724b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01e8, code lost:
    
        r2.A = r3.getText(17);
        r2.B = r3.getText(22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01fe, code lost:
    
        if (r3.hasValue(19) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0200, code lost:
    
        r2.D = n.r1.c(r3.getInt(19, -1), r2.D);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0216, code lost:
    
        if (r3.hasValue(18) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x021c, code lost:
    
        if (r3.hasValue(18) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x021e, code lost:
    
        r8 = r3.getResourceId(18, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0222, code lost:
    
        if (r8 == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0224, code lost:
    
        r8 = a.a.u(r15, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0228, code lost:
    
        if (r8 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x022f, code lost:
    
        r2.C = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0236, code lost:
    
        r3.recycle();
        r2.h = false;
        r8 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x022b, code lost:
    
        r8 = r3.getColorStateList(18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0233, code lost:
    
        r2.C = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x020d, code lost:
    
        r2.D = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01dc, code lost:
    
        if (r12 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01de, code lost:
    
        android.util.Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e5, code lost:
    
        r2.f5720z = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c4, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x017f, code lost:
    
        r2.f5712r = r2.f5700e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0162, code lost:
    
        r8 = r8.charAt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0148, code lost:
    
        r8 = r8.charAt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0243, code lost:
    
        if (r3.equals("menu") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        r9 = false;
        r10 = false;
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0245, code lost:
    
        r2.h = true;
        r3 = r2.f5696a.addSubMenu(r2.f5697b, r2.f5703i, r2.f5704j, r2.f5705k);
        r2.b(r3.getItem());
        r8 = r17;
        b(r8, r18, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0262, code lost:
    
        r8 = r17;
        r11 = r3;
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x026d, code lost:
    
        m7.c.i("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0272, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (r9 != false) goto L99;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(org.xmlpull.v1.XmlPullParser r17, android.util.AttributeSet r18, android.view.Menu r19) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l.i.b(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i9, Menu menu) {
        if (!(menu instanceof m.m)) {
            super.inflate(i9, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f5725c.getResources().getLayout(i9);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (IOException e9) {
                    throw new InflateException("Error inflating menu XML", e9);
                }
            } catch (XmlPullParserException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
