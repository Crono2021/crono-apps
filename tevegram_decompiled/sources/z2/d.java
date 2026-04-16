package z2;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d {
    public static long a(FileInputStream fileInputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int read = fileInputStream.read(bArr);
        long j5 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j5 += read;
            read = fileInputStream.read(bArr);
        }
        return j5;
    }

    public static void b(f fVar, int i9, g1.c cVar) {
        long j5 = fVar.j(i9);
        List q4 = fVar.q(j5);
        if (q4.isEmpty()) {
            return;
        }
        if (i9 == fVar.u() - 1) {
            androidx.fragment.app.a.l();
            return;
        }
        long j9 = fVar.j(i9 + 1) - fVar.j(i9);
        if (j9 > 0) {
            cVar.accept(new a(j5, j9, q4));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005a A[LOOP:0: B:14:0x0054->B:16:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(z2.f r13, z2.k r14, g1.c r15) {
        /*
            long r0 = r14.f10621a
            r2 = 0
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 != 0) goto Le
            r5 = 0
            goto L28
        Le:
            int r5 = r13.g(r0)
            r6 = -1
            if (r5 != r6) goto L1a
            int r5 = r13.u()
            goto L28
        L1a:
            if (r5 <= 0) goto L28
            int r6 = r5 + (-1)
            long r6 = r13.j(r6)
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 != 0) goto L28
            int r5 = r5 + (-1)
        L28:
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L52
            java.util.List r12 = r13.q(r0)
            long r3 = r13.j(r5)
            boolean r6 = r12.isEmpty()
            if (r6 != 0) goto L52
            int r6 = r13.u()
            if (r5 >= r6) goto L52
            long r8 = r14.f10621a
            int r6 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r6 >= 0) goto L52
            z2.a r7 = new z2.a
            long r10 = r3 - r8
            r7.<init>(r8, r10, r12)
            r15.accept(r7)
            r3 = 1
            goto L53
        L52:
            r3 = 0
        L53:
            r4 = r5
        L54:
            int r6 = r13.u()
            if (r4 >= r6) goto L60
            b(r13, r4, r15)
            int r4 = r4 + 1
            goto L54
        L60:
            boolean r14 = r14.f10622b
            if (r14 == 0) goto L88
            if (r3 == 0) goto L68
            int r5 = r5 + (-1)
        L68:
            if (r2 >= r5) goto L70
            b(r13, r2, r15)
            int r2 = r2 + 1
            goto L68
        L70:
            if (r3 == 0) goto L88
            z2.a r6 = new z2.a
            java.util.List r11 = r13.q(r0)
            long r7 = r13.j(r5)
            long r13 = r13.j(r5)
            long r9 = r0 - r13
            r6.<init>(r7, r9, r11)
            r15.accept(r6)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.d.c(z2.f, z2.k, g1.c):void");
    }
}
