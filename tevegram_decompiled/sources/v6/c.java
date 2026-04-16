package v6;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f9586a = Charset.defaultCharset();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f9587b;

    static {
        Charset charset;
        Charset charset2 = null;
        try {
            charset = Charset.forName("SJIS");
        } catch (UnsupportedCharsetException unused) {
            charset = null;
        }
        f9587b = charset;
        try {
            Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused2) {
        }
        try {
            charset2 = Charset.forName("EUC_JP");
        } catch (UnsupportedCharsetException unused3) {
        }
        Charset charset3 = f9587b;
        if ((charset3 == null || !charset3.equals(f9586a)) && charset2 != null) {
            charset2.equals(f9586a);
        }
    }
}
