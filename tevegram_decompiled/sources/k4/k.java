package k4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k implements m, b4.g, com.bumptech.glide.load.data.g {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5571i;

    /* renamed from: j, reason: collision with root package name */
    public final ByteBuffer f5572j;

    public k(int i9) {
        this.f5571i = i9;
        switch (i9) {
            case 2:
                this.f5572j = ByteBuffer.allocate(4);
                break;
            default:
                this.f5572j = ByteBuffer.allocate(8);
                break;
        }
    }

    private final void c(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l4 = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.f5572j) {
            this.f5572j.position(0);
            messageDigest.update(this.f5572j.putLong(l4.longValue()).array());
        }
    }

    @Override // com.bumptech.glide.load.data.g
    public Object a() {
        ByteBuffer byteBuffer = this.f5572j;
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override // b4.g
    public void d(byte[] bArr, Object obj, MessageDigest messageDigest) {
        switch (this.f5571i) {
            case 1:
                c(bArr, obj, messageDigest);
                return;
            default:
                Integer num = (Integer) obj;
                if (num == null) {
                    return;
                }
                messageDigest.update(bArr);
                synchronized (this.f5572j) {
                    this.f5572j.position(0);
                    messageDigest.update(this.f5572j.putInt(num.intValue()).array());
                }
                return;
        }
    }

    @Override // k4.m
    public short h() {
        ByteBuffer byteBuffer = this.f5572j;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new l();
    }

    @Override // k4.m
    public int k() {
        return (h() << 8) | h();
    }

    @Override // k4.m
    public int read(byte[] bArr, int i9) {
        ByteBuffer byteBuffer = this.f5572j;
        int min = Math.min(i9, byteBuffer.remaining());
        if (min == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, min);
        return min;
    }

    @Override // k4.m
    public long skip(long j5) {
        ByteBuffer byteBuffer = this.f5572j;
        int min = (int) Math.min(byteBuffer.remaining(), j5);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
    }

    public k(int i9, ByteBuffer byteBuffer) {
        this.f5571i = i9;
        switch (i9) {
            case 3:
                this.f5572j = byteBuffer;
                break;
            default:
                this.f5572j = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                break;
        }
    }
}
