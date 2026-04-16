package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f640d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f641a;

    /* renamed from: b, reason: collision with root package name */
    public final a0.l f642b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f643c = 0;

    public q(a0.l lVar, int i9) {
        this.f642b = lVar;
        this.f641a = i9;
    }

    public final int a(int i9) {
        w0.a b9 = b();
        int a9 = b9.a(16);
        if (a9 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) b9.f7134d;
        int i10 = a9 + b9.f7131a;
        return byteBuffer.getInt((i9 * 4) + byteBuffer.getInt(i10) + i10 + 4);
    }

    public final w0.a b() {
        ThreadLocal threadLocal = f640d;
        w0.a aVar = (w0.a) threadLocal.get();
        if (aVar == null) {
            aVar = new w0.a();
            threadLocal.set(aVar);
        }
        w0.b bVar = (w0.b) this.f642b.f30i;
        int a9 = bVar.a(6);
        if (a9 != 0) {
            int i9 = a9 + bVar.f7131a;
            int i10 = (this.f641a * 4) + ((ByteBuffer) bVar.f7134d).getInt(i9) + i9 + 4;
            int i11 = ((ByteBuffer) bVar.f7134d).getInt(i10) + i10;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f7134d;
            aVar.f7134d = byteBuffer;
            if (byteBuffer != null) {
                aVar.f7131a = i11;
                int i12 = i11 - byteBuffer.getInt(i11);
                aVar.f7132b = i12;
                aVar.f7133c = ((ByteBuffer) aVar.f7134d).getShort(i12);
                return aVar;
            }
            aVar.f7131a = 0;
            aVar.f7132b = 0;
            aVar.f7133c = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i9;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        w0.a b9 = b();
        int a9 = b9.a(4);
        sb.append(Integer.toHexString(a9 != 0 ? ((ByteBuffer) b9.f7134d).getInt(a9 + b9.f7131a) : 0));
        sb.append(", codepoints:");
        w0.a b10 = b();
        int a10 = b10.a(16);
        if (a10 != 0) {
            int i10 = a10 + b10.f7131a;
            i9 = ((ByteBuffer) b10.f7134d).getInt(((ByteBuffer) b10.f7134d).getInt(i10) + i10);
        } else {
            i9 = 0;
        }
        for (int i11 = 0; i11 < i9; i11++) {
            sb.append(Integer.toHexString(a(i11)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
