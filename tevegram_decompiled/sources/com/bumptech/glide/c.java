package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import androidx.emoji2.text.o;
import d1.l0;
import d4.t;
import g.k0;
import g1.w;
import h4.x;
import h4.z;
import i8.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import k4.b0;
import k4.e0;
import k4.n;
import k4.q;
import k4.u;
import n0.d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c implements d1 {

    /* renamed from: a, reason: collision with root package name */
    public static Constructor f1738a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Method f1739b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Method f1740c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Field f1741d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f1742e = false;

    /* renamed from: f, reason: collision with root package name */
    public static Class f1743f = null;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f1744g = false;
    public static Field h = null;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f1745i = false;

    /* renamed from: j, reason: collision with root package name */
    public static Field f1746j = null;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f1747k = false;

    /* renamed from: l, reason: collision with root package name */
    public static volatile boolean f1748l = true;

    /* renamed from: m, reason: collision with root package name */
    public static Field f1749m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f1750n;

    /* renamed from: o, reason: collision with root package name */
    public static Boolean f1751o;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int A(String str) {
        char c9;
        if (str == null) {
            return -1;
        }
        String k3 = l0.k(str);
        k3.getClass();
        switch (k3.hashCode()) {
            case -2123537834:
                if (k3.equals("audio/eac3-joc")) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case -1662384011:
                if (k3.equals("video/mp2p")) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case -1662384007:
                if (k3.equals("video/mp2t")) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case -1662095187:
                if (k3.equals("video/webm")) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case -1606874997:
                if (k3.equals("audio/amr-wb")) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            case -1487464690:
                if (k3.equals("image/heif")) {
                    c9 = 5;
                    break;
                }
                c9 = 65535;
                break;
            case -1487394660:
                if (k3.equals("image/jpeg")) {
                    c9 = 6;
                    break;
                }
                c9 = 65535;
                break;
            case -1487018032:
                if (k3.equals("image/webp")) {
                    c9 = 7;
                    break;
                }
                c9 = 65535;
                break;
            case -1248337486:
                if (k3.equals("application/mp4")) {
                    c9 = '\b';
                    break;
                }
                c9 = 65535;
                break;
            case -1079884372:
                if (k3.equals("video/x-msvideo")) {
                    c9 = '\t';
                    break;
                }
                c9 = 65535;
                break;
            case -1004728940:
                if (k3.equals("text/vtt")) {
                    c9 = '\n';
                    break;
                }
                c9 = 65535;
                break;
            case -879272239:
                if (k3.equals("image/bmp")) {
                    c9 = 11;
                    break;
                }
                c9 = 65535;
                break;
            case -879258763:
                if (k3.equals("image/png")) {
                    c9 = '\f';
                    break;
                }
                c9 = 65535;
                break;
            case -387023398:
                if (k3.equals("audio/x-matroska")) {
                    c9 = '\r';
                    break;
                }
                c9 = 65535;
                break;
            case -43467528:
                if (k3.equals("application/webm")) {
                    c9 = 14;
                    break;
                }
                c9 = 65535;
                break;
            case 13915911:
                if (k3.equals("video/x-flv")) {
                    c9 = 15;
                    break;
                }
                c9 = 65535;
                break;
            case 187078296:
                if (k3.equals("audio/ac3")) {
                    c9 = 16;
                    break;
                }
                c9 = 65535;
                break;
            case 187078297:
                if (k3.equals("audio/ac4")) {
                    c9 = 17;
                    break;
                }
                c9 = 65535;
                break;
            case 187078669:
                if (k3.equals("audio/amr")) {
                    c9 = 18;
                    break;
                }
                c9 = 65535;
                break;
            case 187090232:
                if (k3.equals("audio/mp4")) {
                    c9 = 19;
                    break;
                }
                c9 = 65535;
                break;
            case 187091926:
                if (k3.equals("audio/ogg")) {
                    c9 = 20;
                    break;
                }
                c9 = 65535;
                break;
            case 187099443:
                if (k3.equals("audio/wav")) {
                    c9 = 21;
                    break;
                }
                c9 = 65535;
                break;
            case 1331848029:
                if (k3.equals("video/mp4")) {
                    c9 = 22;
                    break;
                }
                c9 = 65535;
                break;
            case 1503095341:
                if (k3.equals("audio/3gpp")) {
                    c9 = 23;
                    break;
                }
                c9 = 65535;
                break;
            case 1504578661:
                if (k3.equals("audio/eac3")) {
                    c9 = 24;
                    break;
                }
                c9 = 65535;
                break;
            case 1504619009:
                if (k3.equals("audio/flac")) {
                    c9 = 25;
                    break;
                }
                c9 = 65535;
                break;
            case 1504824762:
                if (k3.equals("audio/midi")) {
                    c9 = 26;
                    break;
                }
                c9 = 65535;
                break;
            case 1504831518:
                if (k3.equals("audio/mpeg")) {
                    c9 = 27;
                    break;
                }
                c9 = 65535;
                break;
            case 1505118770:
                if (k3.equals("audio/webm")) {
                    c9 = 28;
                    break;
                }
                c9 = 65535;
                break;
            case 2039520277:
                if (k3.equals("video/x-matroska")) {
                    c9 = 29;
                    break;
                }
                c9 = 65535;
                break;
            default:
                c9 = 65535;
                break;
        }
        switch (c9) {
        }
        return -1;
    }

    public static int B(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        return lastPathSegment.endsWith(".heic") ? 20 : -1;
    }

    public static r7.c C(r7.c cVar) {
        cVar.getClass();
        t7.c cVar2 = cVar instanceof t7.c ? (t7.c) cVar : null;
        if (cVar2 == null || (cVar = cVar2.f8984k) != null) {
            return cVar;
        }
        r7.g gVar = cVar2.f8983j;
        gVar.getClass();
        s sVar = (s) gVar.h(r7.d.f8614i);
        r7.c hVar = sVar != null ? new n8.h(sVar, cVar2) : cVar2;
        cVar2.f8984k = hVar;
        return hVar;
    }

    public static boolean D(int i9) {
        if (i9 == 0) {
            return false;
        }
        ThreadLocal threadLocal = f0.a.f3191a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int red = Color.red(i9);
        int green = Color.green(i9);
        int blue = Color.blue(i9);
        if (dArr.length != 3) {
            m7.c.n("outXyz must have a length of 3.");
            return false;
        }
        double d9 = red / 255.0d;
        double pow = d9 < 0.04045d ? d9 / 12.92d : Math.pow((d9 + 0.055d) / 1.055d, 2.4d);
        double d10 = green / 255.0d;
        double pow2 = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        double d11 = blue / 255.0d;
        double pow3 = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * 100.0d;
        double d12 = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * 100.0d;
        dArr[1] = d12;
        dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
        return d12 / 100.0d > 0.5d;
    }

    public static boolean F(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static int H(float f9, int i9, int i10) {
        return f0.a.b(f0.a.d(i10, Math.round(Color.alpha(i10) * f9)), i9);
    }

    public static long I(byte[] bArr, int i9) {
        return (((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16)) & 4294967295L;
    }

    public static Drawable J(Context context, int i9, Resources.Theme theme) {
        if (theme != null) {
            l.d dVar = new l.d(context);
            dVar.f5681b = theme;
            dVar.a(theme.getResources().getConfiguration());
            context = dVar;
        }
        return android.support.v4.media.session.b.I(context, i9);
    }

    public static MappedByteBuffer K(Context context, Uri uri) {
        ParcelFileDescriptor a9;
        try {
            a9 = f0.m.a(context.getContentResolver(), uri, "r", null);
        } catch (IOException unused) {
        }
        if (a9 == null) {
            if (a9 != null) {
                a9.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(a9.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                a9.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static void O() {
        if (f1738a == null || f1739b == null || f1740c == null) {
            Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
            f1738a = cls.getConstructor(null);
            f1739b = cls.getMethod("setRotationDegrees", Float.TYPE);
            f1740c = cls.getMethod("build", null);
        }
    }

    public static String P(File file) {
        Charset charset = h8.a.f4218a;
        charset.getClass();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String U = d.U(inputStreamReader);
            inputStreamReader.close();
            return U;
        } finally {
        }
    }

    public static TypedValue Q(Context context, int i9) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i9, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean R(Context context, int i9, boolean z8) {
        TypedValue Q = Q(context, i9);
        return (Q == null || Q.type != 18) ? z8 : Q.data != 0;
    }

    public static TypedValue S(Context context, int i9, String str) {
        TypedValue Q = Q(context, i9);
        if (Q != null) {
            return Q;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i9)));
    }

    public static final void V(Object obj) {
        if (obj instanceof n7.c) {
            throw ((n7.c) obj).f7482i;
        }
    }

    public static void W(int i9, long j5, byte[] bArr) {
        int i10 = 0;
        while (i10 < 4) {
            bArr[i9 + i10] = (byte) (255 & j5);
            i10++;
            j5 >>= 8;
        }
    }

    public static String X(int i9) {
        Object[] objArr = {Integer.valueOf(Color.red(i9)), Integer.valueOf(Color.green(i9)), Integer.valueOf(Color.blue(i9)), Double.valueOf(Color.alpha(i9) / 255.0d)};
        int i10 = w.f3713a;
        return String.format(Locale.US, "rgba(%d,%d,%d,%.3f)", objArr);
    }

    public static void Z(File file, String str) {
        Charset charset = h8.a.f4218a;
        charset.getClass();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            a0(fileOutputStream, str, charset);
            fileOutputStream.close();
        } finally {
        }
    }

    public static final void a0(FileOutputStream fileOutputStream, String str, Charset charset) {
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            bytes.getClass();
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder onUnmappableCharacter = newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer allocate = CharBuffer.allocate(8192);
        onUnmappableCharacter.getClass();
        ByteBuffer allocate2 = ByteBuffer.allocate(8192 * ((int) Math.ceil(onUnmappableCharacter.maxBytesPerChar())));
        allocate2.getClass();
        int i9 = 0;
        int i10 = 0;
        while (i9 < str.length()) {
            int min = Math.min(8192 - i10, str.length() - i9);
            int i11 = i9 + min;
            char[] array = allocate.array();
            array.getClass();
            str.getChars(i9, i11, array, i10);
            allocate.limit(min + i10);
            i10 = 1;
            if (!onUnmappableCharacter.encode(allocate, allocate2, i11 == str.length()).isUnderflow()) {
                m7.c.p("Check failed.");
                return;
            }
            fileOutputStream.write(allocate2.array(), 0, allocate2.position());
            if (allocate.position() != allocate.limit()) {
                allocate.put(0, allocate.get());
            } else {
                i10 = 0;
            }
            allocate.clear();
            allocate2.clear();
            i9 = i11;
        }
    }

    public static String d(int i9, int i10, String str) {
        if (i9 < 0) {
            return d.M("%s (%s) must not be negative", str, Integer.valueOf(i9));
        }
        if (i10 >= 0) {
            return d.M("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i9), Integer.valueOf(i10));
        }
        m7.c.n(androidx.activity.g.m(i10, "negative size: "));
        return null;
    }

    public static void e(long j5, String str, boolean z8) {
        if (z8) {
            return;
        }
        m7.c.n(d.M(str, Long.valueOf(j5)));
    }

    public static void f(int i9, int i10) {
        String M;
        if (i9 < 0 || i9 >= i10) {
            if (i9 < 0) {
                M = d.M("%s (%s) must not be negative", "index", Integer.valueOf(i9));
            } else {
                if (i10 < 0) {
                    m7.c.n(androidx.activity.g.m(i10, "negative size: "));
                    return;
                }
                M = d.M("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i9), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(M);
        }
    }

    public static void g(int i9, int i10) {
        if (i9 < 0 || i9 > i10) {
            throw new IndexOutOfBoundsException(d(i9, i10, "index"));
        }
    }

    public static void h(int i9, int i10, int i11) {
        if (i9 < 0 || i10 < i9 || i10 > i11) {
            throw new IndexOutOfBoundsException((i9 < 0 || i9 > i11) ? d(i9, i11, "start index") : (i10 < 0 || i10 > i11) ? d(i10, i11, "end index") : d.M("end index (%s) must not be less than start index (%s)", Integer.valueOf(i10), Integer.valueOf(i9)));
        }
    }

    public static int i(int i9, int i10, int i11) {
        return i9 < i10 ? i10 : i9 > i11 ? i11 : i9;
    }

    public static int j(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static byte[] k(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            m7.c.n("The key length in bytes must be 32.");
            return null;
        }
        long I = I(bArr, 0) & 67108863;
        int i9 = 3;
        long I2 = (I(bArr, 3) >> 2) & 67108611;
        long I3 = (I(bArr, 6) >> 4) & 67092735;
        long I4 = (I(bArr, 9) >> 6) & 66076671;
        long I5 = (I(bArr, 12) >> 8) & 1048575;
        long j5 = I2 * 5;
        long j9 = I3 * 5;
        long j10 = I4 * 5;
        long j11 = I5 * 5;
        byte[] bArr3 = new byte[17];
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        int i10 = 0;
        while (i10 < bArr2.length) {
            int min = Math.min(16, bArr2.length - i10);
            System.arraycopy(bArr2, i10, bArr3, 0, min);
            bArr3[min] = 1;
            if (min != 16) {
                Arrays.fill(bArr3, min + 1, 17, (byte) 0);
            }
            long I6 = j16 + (I(bArr3, 0) & 67108863);
            long I7 = j12 + ((I(bArr3, i9) >> 2) & 67108863);
            long I8 = j13 + ((I(bArr3, 6) >> 4) & 67108863);
            long I9 = j14 + ((I(bArr3, 9) >> 6) & 67108863);
            long j17 = I2;
            long I10 = j15 + (((I(bArr3, 12) >> 8) & 67108863) | (bArr3[16] << 24));
            long j18 = (I10 * j5) + (I9 * j9) + (I8 * j10) + (I7 * j11) + (I6 * I);
            long j19 = (I10 * j9) + (I9 * j10) + (I8 * j11) + (I7 * I) + (I6 * j17);
            long j20 = (I10 * j10) + (I9 * j11) + (I8 * I) + (I7 * j17) + (I6 * I3);
            long j21 = (I10 * j11) + (I9 * I) + (I8 * j17) + (I7 * I3) + (I6 * I4);
            long j22 = I9 * j17;
            long j23 = I10 * I;
            long j24 = j19 + (j18 >> 26);
            long j25 = j20 + (j24 >> 26);
            long j26 = j21 + (j25 >> 26);
            long j27 = j23 + j22 + (I8 * I3) + (I7 * I4) + (I6 * I5) + (j26 >> 26);
            long j28 = j27 >> 26;
            j15 = j27 & 67108863;
            long j29 = (j28 * 5) + (j18 & 67108863);
            i10 += 16;
            j13 = j25 & 67108863;
            j14 = j26 & 67108863;
            j16 = j29 & 67108863;
            j12 = (j24 & 67108863) + (j29 >> 26);
            I2 = j17;
            i9 = 3;
        }
        long j30 = j13 + (j12 >> 26);
        long j31 = j30 & 67108863;
        long j32 = j14 + (j30 >> 26);
        long j33 = j32 & 67108863;
        long j34 = j15 + (j32 >> 26);
        long j35 = j34 & 67108863;
        long j36 = ((j34 >> 26) * 5) + j16;
        long j37 = j36 >> 26;
        long j38 = j36 & 67108863;
        long j39 = (j12 & 67108863) + j37;
        long j40 = j38 + 5;
        long j41 = j40 & 67108863;
        long j42 = j39 + (j40 >> 26);
        long j43 = j31 + (j42 >> 26);
        long j44 = j33 + (j43 >> 26);
        long j45 = j44 & 67108863;
        long j46 = (j35 + (j44 >> 26)) - 67108864;
        long j47 = j46 >> 63;
        long j48 = j38 & j47;
        long j49 = j39 & j47;
        long j50 = j31 & j47;
        long j51 = j33 & j47;
        long j52 = j35 & j47;
        long j53 = ~j47;
        long j54 = j49 | (j42 & 67108863 & j53);
        long j55 = j50 | (j43 & 67108863 & j53);
        long j56 = j51 | (j45 & j53);
        long j57 = (j48 | (j41 & j53) | (j54 << 26)) & 4294967295L;
        long j58 = ((j54 >> 6) | (j55 << 20)) & 4294967295L;
        long j59 = ((j55 >> 12) | (j56 << 14)) & 4294967295L;
        long j60 = ((j56 >> 18) | ((j52 | (j46 & j53)) << 8)) & 4294967295L;
        long I11 = I(bArr, 16) + j57;
        long j61 = I11 & 4294967295L;
        long I12 = I(bArr, 20) + j58 + (I11 >> 32);
        long I13 = I(bArr, 24) + j59 + (I12 >> 32);
        long I14 = (I(bArr, 28) + j60 + (I13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        W(0, j61, bArr4);
        W(4, I12 & 4294967295L, bArr4);
        W(8, I13 & 4294967295L, bArr4);
        W(12, I14, bArr4);
        return bArr4;
    }

    public static boolean l(File file, Resources resources, int i9) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i9);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            boolean m9 = m(file, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return m9;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean m(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            fileOutputStream.close();
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return true;
        } catch (IOException e10) {
            e = e10;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static i n(b bVar, ArrayList arrayList) {
        b4.k fVar;
        b4.k aVar;
        e4.a aVar2;
        int i9;
        String str;
        Class cls;
        e4.a aVar3 = bVar.f1731i;
        e4.f fVar2 = bVar.f1734l;
        e eVar = bVar.f1733k;
        Context applicationContext = eVar.getApplicationContext();
        a0.b bVar2 = eVar.h;
        i iVar = new i();
        Class<InputStream> cls2 = InputStream.class;
        n nVar = new n();
        p4.c cVar = iVar.f1779g;
        synchronized (cVar) {
            cVar.f8251a.add(nVar);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 27) {
            iVar.i(new u());
        }
        Resources resources = applicationContext.getResources();
        ArrayList f9 = iVar.f();
        o4.a aVar4 = new o4.a(applicationContext, f9, aVar3, fVar2);
        e0 e0Var = new e0(aVar3, new t(18));
        q qVar = new q(iVar.f(), resources.getDisplayMetrics(), aVar3, fVar2);
        if (i10 < 28 || !((Map) bVar2.f8j).containsKey(c.class)) {
            fVar = new k4.f(qVar, 0);
            aVar = new k4.a(qVar, 2, fVar2);
        } else {
            aVar = new k4.g(1);
            fVar = new k4.g(0);
        }
        if (i10 >= 28) {
            i9 = i10;
            aVar2 = aVar3;
            int i11 = 1;
            iVar.d("Animation", InputStream.class, Drawable.class, new m4.b(new m1.b(f9, i11, fVar2), i11));
            iVar.d("Animation", ByteBuffer.class, Drawable.class, new m4.b(new m1.b(f9, 1, fVar2), 0));
        } else {
            aVar2 = aVar3;
            i9 = i10;
        }
        m4.d dVar = new m4.d(applicationContext);
        k4.b bVar3 = new k4.b(fVar2);
        d4.i iVar2 = new d4.i(5);
        p4.d dVar2 = new p4.d(1);
        ContentResolver contentResolver = applicationContext.getContentResolver();
        iVar.a(ByteBuffer.class, new z(5));
        iVar.a(InputStream.class, new a0.b(fVar2, 26));
        iVar.d("Bitmap", ByteBuffer.class, Bitmap.class, fVar);
        iVar.d("Bitmap", InputStream.class, Bitmap.class, aVar);
        String str2 = Build.FINGERPRINT;
        if ("robolectric".equals(str2)) {
            str = str2;
            cls = ParcelFileDescriptor.class;
        } else {
            str = str2;
            k4.f fVar3 = new k4.f(qVar, 1);
            cls = ParcelFileDescriptor.class;
            iVar.d("Bitmap", cls, Bitmap.class, fVar3);
        }
        e4.a aVar5 = aVar2;
        iVar.d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new e0(aVar5, new t(15)));
        iVar.d("Bitmap", cls, Bitmap.class, e0Var);
        z zVar = z.f4026j;
        iVar.c(Bitmap.class, Bitmap.class, zVar);
        iVar.d("Bitmap", Bitmap.class, Bitmap.class, new b0(0));
        iVar.b(Bitmap.class, bVar3);
        iVar.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new k4.a(resources, fVar));
        iVar.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new k4.a(resources, aVar));
        iVar.d("BitmapDrawable", cls, BitmapDrawable.class, new k4.a(resources, e0Var));
        iVar.b(BitmapDrawable.class, new a5.d(aVar5, 26, bVar3));
        iVar.d("Animation", InputStream.class, o4.c.class, new o4.j(f9, aVar4, fVar2));
        iVar.d("Animation", ByteBuffer.class, o4.c.class, aVar4);
        iVar.b(o4.c.class, new o4.d(0));
        iVar.c(a4.d.class, a4.d.class, zVar);
        iVar.d("Bitmap", a4.d.class, Bitmap.class, new k4.c(aVar5));
        iVar.d("legacy_append", Uri.class, Drawable.class, dVar);
        iVar.d("legacy_append", Uri.class, Bitmap.class, new k4.a(dVar, 1, aVar5));
        iVar.j(new com.bumptech.glide.load.data.h(2));
        iVar.c(File.class, ByteBuffer.class, new z(6));
        iVar.c(File.class, InputStream.class, new h4.f(new z(9)));
        iVar.d("legacy_append", File.class, File.class, new b0(2));
        iVar.c(File.class, cls, new h4.f(new z(8)));
        iVar.c(File.class, File.class, zVar);
        iVar.j(new com.bumptech.glide.load.data.m(fVar2));
        if (!"robolectric".equals(str)) {
            iVar.j(new com.bumptech.glide.load.data.h(1));
        }
        o oVar = new o(applicationContext, 5);
        o oVar2 = new o(applicationContext, 3);
        o oVar3 = new o(applicationContext, 4);
        Class cls3 = Integer.TYPE;
        iVar.c(cls3, InputStream.class, oVar);
        iVar.c(Integer.class, InputStream.class, oVar);
        iVar.c(cls3, AssetFileDescriptor.class, oVar2);
        iVar.c(Integer.class, AssetFileDescriptor.class, oVar2);
        iVar.c(cls3, Drawable.class, oVar3);
        iVar.c(Integer.class, Drawable.class, oVar3);
        iVar.c(Uri.class, InputStream.class, new o(applicationContext, 8));
        iVar.c(Uri.class, AssetFileDescriptor.class, new o(applicationContext, 7));
        x xVar = new x(resources, 2);
        x xVar2 = new x(resources, 0);
        x xVar3 = new x(resources, 1);
        iVar.c(Integer.class, Uri.class, xVar);
        iVar.c(cls3, Uri.class, xVar);
        iVar.c(Integer.class, AssetFileDescriptor.class, xVar2);
        iVar.c(cls3, AssetFileDescriptor.class, xVar2);
        iVar.c(Integer.class, InputStream.class, xVar3);
        iVar.c(cls3, InputStream.class, xVar3);
        iVar.c(String.class, InputStream.class, new a0.b(24));
        iVar.c(Uri.class, InputStream.class, new a0.b(24));
        iVar.c(String.class, InputStream.class, new z(13));
        iVar.c(String.class, cls, new z(12));
        iVar.c(String.class, AssetFileDescriptor.class, new z(11));
        iVar.c(Uri.class, InputStream.class, new h4.a(applicationContext.getAssets(), 1));
        iVar.c(Uri.class, AssetFileDescriptor.class, new h4.a(applicationContext.getAssets(), 0));
        iVar.c(Uri.class, InputStream.class, new o(applicationContext, 9));
        iVar.c(Uri.class, InputStream.class, new o(applicationContext, 10));
        int i12 = i9;
        if (i12 >= 29) {
            iVar.c(Uri.class, InputStream.class, new i4.b(applicationContext, cls2));
            iVar.c(Uri.class, cls, new i4.b(applicationContext, cls));
        }
        iVar.c(Uri.class, InputStream.class, new h4.b0(contentResolver, 2));
        iVar.c(Uri.class, cls, new h4.b0(contentResolver, 1));
        iVar.c(Uri.class, AssetFileDescriptor.class, new h4.b0(contentResolver, 0));
        iVar.c(Uri.class, InputStream.class, new z(14));
        iVar.c(URL.class, InputStream.class, new t(13));
        iVar.c(Uri.class, File.class, new o(applicationContext, 6));
        iVar.c(h4.g.class, InputStream.class, new a0.b(28));
        iVar.c(byte[].class, ByteBuffer.class, new z(2));
        iVar.c(byte[].class, InputStream.class, new z(4));
        iVar.c(Uri.class, Uri.class, zVar);
        iVar.c(Drawable.class, Drawable.class, zVar);
        iVar.d("legacy_append", Drawable.class, Drawable.class, new b0(1));
        iVar.k(Bitmap.class, BitmapDrawable.class, new x(resources, 4));
        iVar.k(Bitmap.class, byte[].class, iVar2);
        iVar.k(Drawable.class, byte[].class, new androidx.fragment.app.g(aVar5, iVar2, dVar2, 24));
        iVar.k(o4.c.class, byte[].class, dVar2);
        if (i12 >= 23) {
            e0 e0Var2 = new e0(aVar5, new t(16));
            iVar.d("legacy_append", ByteBuffer.class, Bitmap.class, e0Var2);
            iVar.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new k4.a(resources, e0Var2));
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw androidx.activity.g.l(it);
        }
        return iVar;
    }

    public static z1.h o(y1.q qVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = qVar.length();
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            if (qVar.b(i10, elapsedRealtime)) {
                i9++;
            }
        }
        return new z1.h(length, i9);
    }

    public static byte[] p(byte[] bArr) {
        if (bArr.length != 16) {
            m7.c.n("value must be a block.");
            return null;
        }
        byte[] bArr2 = new byte[16];
        for (int i9 = 0; i9 < 16; i9++) {
            byte b9 = (byte) ((bArr[i9] << 1) & 254);
            bArr2[i9] = b9;
            if (i9 < 15) {
                bArr2[i9] = (byte) (((byte) ((bArr[i9 + 1] >> 7) & 1)) | b9);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }

    public static void s(Object obj) {
        LongSparseArray longSparseArray;
        if (!f1744g) {
            try {
                f1743f = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e9) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e9);
            }
            f1744g = true;
        }
        Class cls = f1743f;
        if (cls == null) {
            return;
        }
        if (!f1745i) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                h = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e10);
            }
            f1745i = true;
        }
        Field field = h;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e11) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e11);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            k0.a(longSparseArray);
        }
    }

    public static Drawable t(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return r0.c.a(compoundButton);
        }
        if (!f1750n) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1749m = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e9) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e9);
            }
            f1750n = true;
        }
        Field field = f1749m;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e10) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e10);
                f1749m = null;
            }
        }
        return null;
    }

    public static int u(Context context, int i9, int i10) {
        TypedValue Q = Q(context, i9);
        if (Q == null) {
            return i10;
        }
        int i11 = Q.resourceId;
        return i11 != 0 ? a.a.t(context, i11) : Q.data;
    }

    public static int v(View view, int i9) {
        Context context = view.getContext();
        TypedValue S = S(view.getContext(), i9, view.getClass().getCanonicalName());
        int i10 = S.resourceId;
        return i10 != 0 ? a.a.t(context, i10) : S.data;
    }

    public static Drawable x(Context context, Context context2, int i9, Resources.Theme theme) {
        try {
            if (f1748l) {
                return J(context2, i9, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e9) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e9;
            }
            return d0.c.b(context2, i9);
        } catch (NoClassDefFoundError unused2) {
            f1748l = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal threadLocal = e0.o.f3001a;
        return e0.i.a(resources, i9, theme);
    }

    public static File z(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i9 = 0; i9 < 100; i9++) {
            File file = new File(cacheDir, str + i9);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public abstract boolean E();

    public boolean G(int i9, int i10, byte[] bArr) {
        return N(i9, i10, bArr) == 0;
    }

    public abstract void L(Throwable th);

    public abstract void M(a0.l lVar);

    public abstract int N(int i9, int i10, byte[] bArr);

    public abstract void T(boolean z8);

    public abstract void U(boolean z8);

    public abstract TransformationMethod Y(TransformationMethod transformationMethod);

    public abstract String q(int i9, int i10, byte[] bArr);

    public abstract int r(String str, byte[] bArr, int i9, int i10);

    public abstract void w(u5.s sVar, float f9, float f10);

    public abstract InputFilter[] y(InputFilter[] inputFilterArr);

    @Override // n0.d1
    public void b() {
    }

    @Override // n0.d1
    public void c() {
    }
}
