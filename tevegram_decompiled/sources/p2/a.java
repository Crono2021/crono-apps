package p2;

import d1.j0;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends android.support.v4.media.session.b {

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f8235q = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: o, reason: collision with root package name */
    public final CharsetDecoder f8236o = a6.b.f203c.newDecoder();

    /* renamed from: p, reason: collision with root package name */
    public final CharsetDecoder f8237p = a6.b.f202b.newDecoder();

    @Override // android.support.v4.media.session.b
    public final j0 B(l2.a aVar, ByteBuffer byteBuffer) {
        String str;
        CharsetDecoder charsetDecoder = this.f8237p;
        CharsetDecoder charsetDecoder2 = this.f8236o;
        String str2 = null;
        try {
            str = charsetDecoder2.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = charsetDecoder.decode(byteBuffer).toString();
                charsetDecoder.reset();
                byteBuffer.rewind();
                str = charBuffer;
            } catch (CharacterCodingException unused2) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                str = null;
            } catch (Throwable th) {
                charsetDecoder.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            charsetDecoder2.reset();
            byteBuffer.rewind();
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (str == null) {
            return new j0(new c(bArr, null, null));
        }
        Matcher matcher = f8235q.matcher(str);
        String str3 = null;
        for (int i9 = 0; matcher.find(i9); i9 = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String U = a.a.U(group);
                U.getClass();
                if (U.equals("streamurl")) {
                    str3 = group2;
                } else if (U.equals("streamtitle")) {
                    str2 = group2;
                }
            }
        }
        return new j0(new c(bArr, str2, str3));
    }
}
