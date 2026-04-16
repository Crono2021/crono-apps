package g1;

import android.media.MediaFormat;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f3654a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f3655b = {"", "A", "B", "C"};

    /* renamed from: c, reason: collision with root package name */
    public static final Object f3656c = new Object();

    public static String A(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] u3 = u(str2);
        if (u3[0] != -1) {
            sb.append(str2);
            z(sb, u3[1], u3[2]);
            return sb.toString();
        }
        int[] u6 = u(str);
        if (u3[3] == 0) {
            sb.append((CharSequence) str, 0, u6[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (u3[2] == 0) {
            sb.append((CharSequence) str, 0, u6[2]);
            sb.append(str2);
            return sb.toString();
        }
        int i9 = u3[1];
        if (i9 != 0) {
            int i10 = u6[0] + 1;
            sb.append((CharSequence) str, 0, i10);
            sb.append(str2);
            return z(sb, u3[1] + i10, i10 + u3[2]);
        }
        if (str2.charAt(i9) == '/') {
            sb.append((CharSequence) str, 0, u6[1]);
            sb.append(str2);
            int i11 = u6[1];
            return z(sb, i11, u3[2] + i11);
        }
        int i12 = u6[0] + 2;
        int i13 = u6[1];
        if (i12 >= i13 || i13 != u6[2]) {
            int lastIndexOf = str.lastIndexOf(47, u6[2] - 1);
            int i14 = lastIndexOf == -1 ? u6[1] : lastIndexOf + 1;
            sb.append((CharSequence) str, 0, i14);
            sb.append(str2);
            return z(sb, u6[1], i14 + u3[2]);
        }
        sb.append((CharSequence) str, 0, i13);
        sb.append('/');
        sb.append(str2);
        int i15 = u6[1];
        return z(sb, i15, u3[2] + i15 + 1);
    }

    public static Uri B(String str, String str2) {
        return Uri.parse(A(str, str2));
    }

    public static void C(MediaFormat mediaFormat, List list) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            mediaFormat.setByteBuffer(androidx.activity.g.m(i9, "csd-"), ByteBuffer.wrap((byte[]) list.get(i9)));
        }
    }

    public static void D(String str, String str2) {
        synchronized (f3656c) {
            Log.w(str, a(str2, null));
        }
    }

    public static void E(String str, String str2, Throwable th) {
        synchronized (f3656c) {
            Log.w(str, a(str2, th));
        }
    }

    public static String a(String str, Throwable th) {
        String t8 = t(th);
        if (TextUtils.isEmpty(t8)) {
            return str;
        }
        return str + "\n  " + t8.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str) {
        if (w.f3713a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void c(int i9, int i10) {
        GLES20.glBindTexture(i9, i10);
        g();
        GLES20.glTexParameteri(i9, 10240, 9729);
        g();
        GLES20.glTexParameteri(i9, 10241, 9729);
        g();
        GLES20.glTexParameteri(i9, 10242, 33071);
        g();
        GLES20.glTexParameteri(i9, 10243, 33071);
        g();
    }

    public static String d(int i9, boolean z8, int i10, int i11, int[] iArr, int i12) {
        Object[] objArr = {f3655b[i9], Integer.valueOf(i10), Integer.valueOf(i11), Character.valueOf(z8 ? 'H' : 'L'), Integer.valueOf(i12)};
        int i13 = w.f3713a;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i14 = 0; i14 < length; i14++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i14])));
        }
        return sb.toString();
    }

    public static void e(String str, boolean z8) {
        if (z8) {
            return;
        }
        m7.c.n(str);
    }

    public static void f(boolean z8) {
        if (z8) {
            return;
        }
        m7.c.d();
    }

    public static void g() {
        StringBuilder sb = new StringBuilder();
        boolean z8 = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z8) {
                sb.append('\n');
            }
            String gluErrorString = GLU.gluErrorString(glGetError);
            if (gluErrorString == null) {
                gluErrorString = "error code: 0x" + Integer.toHexString(glGetError);
            }
            sb.append("glError: ");
            sb.append(gluErrorString);
            z8 = true;
        }
        if (z8) {
            throw new g(sb.toString());
        }
    }

    public static void h(String str, boolean z8) {
        if (!z8) {
            throw new g(str);
        }
    }

    public static void i(int i9, int i10) {
        if (i9 < 0 || i9 >= i10) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void j(Object obj, String str) {
        if (obj != null) {
            return;
        }
        m7.c.o(str);
    }

    public static void k(boolean z8) {
        if (z8) {
            return;
        }
        androidx.fragment.app.a.l();
    }

    public static void l(Object obj) {
        if (obj != null) {
            return;
        }
        androidx.fragment.app.a.l();
    }

    public static void m(Object obj, String str) {
        if (obj != null) {
            return;
        }
        m7.c.p(str);
    }

    public static FloatBuffer n(float[] fArr) {
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).flip();
    }

    public static void o(String str, String str2) {
        synchronized (f3656c) {
            Log.d(str, a(str2, null));
        }
    }

    public static void p(String str, String str2) {
        synchronized (f3656c) {
            Log.e(str, a(str2, null));
        }
    }

    public static void q(String str, String str2, Throwable th) {
        synchronized (f3656c) {
            Log.e(str, a(str2, th));
        }
    }

    public static void r() {
        if (w.f3713a >= 18) {
            Trace.endSection();
        }
    }

    public static String s(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i9 = 0; i9 < attributeCount; i9++) {
            if (xmlPullParser.getAttributeName(i9).equals(str)) {
                return xmlPullParser.getAttributeValue(i9);
            }
        }
        return null;
    }

    public static String t(Throwable th) {
        boolean z8;
        if (th == null) {
            return null;
        }
        synchronized (f3656c) {
            Throwable th2 = th;
            while (true) {
                if (th2 == null) {
                    z8 = false;
                    break;
                }
                try {
                    if (th2 instanceof UnknownHostException) {
                        z8 = true;
                        break;
                    }
                    th2 = th2.getCause();
                } finally {
                }
            }
            if (z8) {
                return "UnknownHostException (no network)";
            }
            return Log.getStackTraceString(th).trim().replace("\t", "    ");
        }
    }

    public static int[] u(String str) {
        int i9;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i10 = indexOf4 + 2;
        if (i10 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i10) == '/') {
            i9 = str.indexOf(47, indexOf4 + 3);
            if (i9 == -1 || i9 > indexOf2) {
                i9 = indexOf2;
            }
        } else {
            i9 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i9;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static void v(String str, String str2) {
        synchronized (f3656c) {
            Log.i(str, a(str2, null));
        }
    }

    public static boolean w(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(str);
    }

    public static boolean x(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(str);
    }

    public static void y(MediaFormat mediaFormat, String str, int i9) {
        if (i9 != -1) {
            mediaFormat.setInteger(str, i9);
        }
    }

    public static String z(StringBuilder sb, int i9, int i10) {
        int i11;
        int i12;
        if (i9 >= i10) {
            return sb.toString();
        }
        if (sb.charAt(i9) == '/') {
            i9++;
        }
        int i13 = i9;
        int i14 = i13;
        while (i13 <= i10) {
            if (i13 == i10) {
                i11 = i13;
            } else if (sb.charAt(i13) == '/') {
                i11 = i13 + 1;
            } else {
                i13++;
            }
            int i15 = i14 + 1;
            if (i13 == i15 && sb.charAt(i14) == '.') {
                sb.delete(i14, i11);
                i10 -= i11 - i14;
            } else {
                if (i13 == i14 + 2 && sb.charAt(i14) == '.' && sb.charAt(i15) == '.') {
                    i12 = sb.lastIndexOf("/", i14 - 2) + 1;
                    int i16 = i12 > i9 ? i12 : i9;
                    sb.delete(i16, i11);
                    i10 -= i11 - i16;
                } else {
                    i12 = i13 + 1;
                }
                i14 = i12;
            }
            i13 = i14;
        }
        return sb.toString();
    }
}
