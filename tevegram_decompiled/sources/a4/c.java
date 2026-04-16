package a4;

import android.util.Log;
import androidx.activity.g;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f148b;

    /* renamed from: c, reason: collision with root package name */
    public b f149c;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f147a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    public int f150d = 0;

    public final boolean a() {
        return this.f149c.f138b != 0;
    }

    public final b b() {
        byte[] bArr;
        if (this.f148b == null) {
            m7.c.p("You must call setData() before parseHeader()");
            return null;
        }
        if (a()) {
            return this.f149c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i9 = 0; i9 < 6; i9++) {
            sb.append((char) c());
        }
        boolean startsWith = sb.toString().startsWith("GIF");
        b bVar = this.f149c;
        if (startsWith) {
            bVar.f142f = this.f148b.getShort();
            this.f149c.f143g = this.f148b.getShort();
            int c9 = c();
            b bVar2 = this.f149c;
            bVar2.h = (c9 & 128) != 0;
            bVar2.f144i = (int) Math.pow(2.0d, (c9 & 7) + 1);
            this.f149c.f145j = c();
            b bVar3 = this.f149c;
            c();
            bVar3.getClass();
            if (this.f149c.h && !a()) {
                b bVar4 = this.f149c;
                bVar4.f137a = e(bVar4.f144i);
                b bVar5 = this.f149c;
                bVar5.f146k = bVar5.f137a[bVar5.f145j];
            }
        } else {
            bVar.f138b = 1;
        }
        if (!a()) {
            boolean z8 = false;
            while (!z8 && !a() && this.f149c.f139c <= Integer.MAX_VALUE) {
                int c10 = c();
                if (c10 == 33) {
                    int c11 = c();
                    if (c11 == 1) {
                        f();
                    } else if (c11 == 249) {
                        this.f149c.f140d = new a();
                        c();
                        int c12 = c();
                        a aVar = this.f149c.f140d;
                        int i10 = (c12 & 28) >> 2;
                        aVar.f133g = i10;
                        if (i10 == 0) {
                            aVar.f133g = 1;
                        }
                        aVar.f132f = (c12 & 1) != 0;
                        short s8 = this.f148b.getShort();
                        if (s8 < 2) {
                            s8 = 10;
                        }
                        a aVar2 = this.f149c.f140d;
                        aVar2.f134i = s8 * 10;
                        aVar2.h = c();
                        c();
                    } else if (c11 == 254) {
                        f();
                    } else if (c11 != 255) {
                        f();
                    } else {
                        d();
                        StringBuilder sb2 = new StringBuilder();
                        int i11 = 0;
                        while (true) {
                            bArr = this.f147a;
                            if (i11 >= 11) {
                                break;
                            }
                            sb2.append((char) bArr[i11]);
                            i11++;
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                d();
                                if (bArr[0] == 1) {
                                    byte b9 = bArr[1];
                                    byte b10 = bArr[2];
                                    this.f149c.getClass();
                                }
                                if (this.f150d > 0) {
                                }
                            } while (!a());
                        } else {
                            f();
                        }
                    }
                } else if (c10 == 44) {
                    b bVar6 = this.f149c;
                    if (bVar6.f140d == null) {
                        bVar6.f140d = new a();
                    }
                    bVar6.f140d.f127a = this.f148b.getShort();
                    this.f149c.f140d.f128b = this.f148b.getShort();
                    this.f149c.f140d.f129c = this.f148b.getShort();
                    this.f149c.f140d.f130d = this.f148b.getShort();
                    int c13 = c();
                    boolean z9 = (c13 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (c13 & 7) + 1);
                    a aVar3 = this.f149c.f140d;
                    aVar3.f131e = (c13 & 64) != 0;
                    if (z9) {
                        aVar3.f136k = e(pow);
                    } else {
                        aVar3.f136k = null;
                    }
                    this.f149c.f140d.f135j = this.f148b.position();
                    c();
                    f();
                    if (!a()) {
                        b bVar7 = this.f149c;
                        bVar7.f139c++;
                        bVar7.f141e.add(bVar7.f140d);
                    }
                } else if (c10 != 59) {
                    this.f149c.f138b = 1;
                } else {
                    z8 = true;
                }
            }
            b bVar8 = this.f149c;
            if (bVar8.f139c < 0) {
                bVar8.f138b = 1;
            }
        }
        return this.f149c;
    }

    public final int c() {
        try {
            return this.f148b.get() & 255;
        } catch (Exception unused) {
            this.f149c.f138b = 1;
            return 0;
        }
    }

    public final void d() {
        int c9 = c();
        this.f150d = c9;
        if (c9 <= 0) {
            return;
        }
        int i9 = 0;
        int i10 = 0;
        while (true) {
            try {
                i10 = this.f150d;
                if (i9 >= i10) {
                    return;
                }
                i10 -= i9;
                this.f148b.get(this.f147a, i9, i10);
                i9 += i10;
            } catch (Exception e9) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder q4 = g.q("Error Reading Block n: ", i9, " count: ", i10, " blockSize: ");
                    q4.append(this.f150d);
                    Log.d("GifHeaderParser", q4.toString(), e9);
                }
                this.f149c.f138b = 1;
                return;
            }
        }
    }

    public final int[] e(int i9) {
        byte[] bArr = new byte[i9 * 3];
        int[] iArr = null;
        try {
            this.f148b.get(bArr);
            iArr = new int[256];
            int i10 = 0;
            int i11 = 0;
            while (i10 < i9) {
                int i12 = bArr[i11] & 255;
                int i13 = i11 + 2;
                int i14 = bArr[i11 + 1] & 255;
                i11 += 3;
                int i15 = i10 + 1;
                iArr[i10] = (i14 << 8) | (i12 << 16) | (-16777216) | (bArr[i13] & 255);
                i10 = i15;
            }
            return iArr;
        } catch (BufferUnderflowException e9) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e9);
            }
            this.f149c.f138b = 1;
            return iArr;
        }
    }

    public final void f() {
        int c9;
        do {
            c9 = c();
            this.f148b.position(Math.min(this.f148b.position() + c9, this.f148b.limit()));
        } while (c9 > 0);
    }
}
