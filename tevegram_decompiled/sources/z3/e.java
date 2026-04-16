package z3;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends ByteArrayOutputStream {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f f10652i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, int i9) {
        super(i9);
        this.f10652i = fVar;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i9 = ((ByteArrayOutputStream) this).count;
        if (i9 > 0) {
            int i10 = i9 - 1;
            if (((ByteArrayOutputStream) this).buf[i10] == 13) {
                i9 = i10;
            }
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i9, this.f10652i.f10654j.name());
        } catch (UnsupportedEncodingException e9) {
            m7.c.e(e9);
            return null;
        }
    }
}
