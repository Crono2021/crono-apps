package i1;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class u extends i {

    /* renamed from: j, reason: collision with root package name */
    public final int f4363j;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public u(java.io.IOException r2, int r3, int r4) {
        /*
            r1 = this;
            r0 = 2000(0x7d0, float:2.803E-42)
            if (r3 != r0) goto L9
            r0 = 1
            if (r4 != r0) goto L9
            r3 = 2001(0x7d1, float:2.804E-42)
        L9:
            r1.<init>(r2, r3)
            r1.f4363j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.u.<init>(java.io.IOException, int, int):void");
    }

    public static u a(IOException iOException, int i9) {
        String message = iOException.getMessage();
        int i10 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !a.a.U(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i10 == 2007 ? new t(2007, iOException, "Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted") : new u(iOException, i10, i9);
    }

    public u(String str, int i9) {
        super(str, i9 == 2000 ? 2001 : i9);
        this.f4363j = 1;
    }

    public u() {
        super(2008);
        this.f4363j = 1;
    }

    public u(int i9, IOException iOException, String str) {
        super(str, iOException, i9 == 2000 ? 2001 : i9);
        this.f4363j = 1;
    }
}
