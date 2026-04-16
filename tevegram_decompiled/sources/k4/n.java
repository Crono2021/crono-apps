package k4;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n implements b4.e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5573a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5574b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int e(m mVar, e4.f fVar) {
        try {
            int k3 = mVar.k();
            if ((k3 & 65496) == 65496 || k3 == 19789 || k3 == 18761) {
                int g9 = g(mVar);
                if (g9 != -1) {
                    byte[] bArr = (byte[]) fVar.d(g9, byte[].class);
                    try {
                        return h(mVar, bArr, g9);
                    } finally {
                        fVar.h(bArr);
                    }
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    return -1;
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + k3);
                return -1;
            }
        } catch (l unused) {
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType f(m mVar) {
        try {
            int k3 = mVar.k();
            if (k3 == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int h = (k3 << 8) | mVar.h();
            if (h == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int h9 = (h << 8) | mVar.h();
            if (h9 == -1991225785) {
                mVar.skip(21L);
                try {
                    return mVar.h() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (l unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (h9 == 1380533830) {
                mVar.skip(4L);
                if (((mVar.k() << 16) | mVar.k()) != 1464156752) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int k9 = (mVar.k() << 16) | mVar.k();
                if ((k9 & (-256)) != 1448097792) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int i9 = k9 & 255;
                if (i9 == 88) {
                    mVar.skip(4L);
                    short h10 = mVar.h();
                    return (h10 & 2) != 0 ? ImageHeaderParser$ImageType.ANIMATED_WEBP : (h10 & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
                }
                if (i9 != 76) {
                    return ImageHeaderParser$ImageType.WEBP;
                }
                mVar.skip(4L);
                return (mVar.h() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (((mVar.k() << 16) | mVar.k()) != 1718909296) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int k10 = (mVar.k() << 16) | mVar.k();
            if (k10 == 1635150195) {
                return ImageHeaderParser$ImageType.ANIMATED_AVIF;
            }
            int i10 = 0;
            boolean z8 = k10 == 1635150182;
            mVar.skip(4L);
            int i11 = h9 - 16;
            if (i11 % 4 == 0) {
                while (i10 < 5 && i11 > 0) {
                    int k11 = (mVar.k() << 16) | mVar.k();
                    if (k11 == 1635150195) {
                        return ImageHeaderParser$ImageType.ANIMATED_AVIF;
                    }
                    if (k11 == 1635150182) {
                        z8 = true;
                    }
                    i10++;
                    i11 -= 4;
                }
            }
            return z8 ? ImageHeaderParser$ImageType.AVIF : ImageHeaderParser$ImageType.UNKNOWN;
        } catch (l unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(k4.m r10) {
        /*
        L0:
            short r0 = r10.h()
            r1 = 255(0xff, float:3.57E-43)
            r2 = 3
            r3 = -1
            java.lang.String r4 = "DfltImageHeaderParser"
            if (r0 == r1) goto L24
            boolean r10 = android.util.Log.isLoggable(r4, r2)
            if (r10 == 0) goto L6a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown segmentId="
            r10.<init>(r1)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r4, r10)
            return r3
        L24:
            short r0 = r10.h()
            r1 = 218(0xda, float:3.05E-43)
            if (r0 != r1) goto L2d
            goto L6a
        L2d:
            r1 = 217(0xd9, float:3.04E-43)
            if (r0 != r1) goto L3d
            boolean r10 = android.util.Log.isLoggable(r4, r2)
            if (r10 == 0) goto L6a
            java.lang.String r10 = "Found MARKER_EOI in exif segment"
            android.util.Log.d(r4, r10)
            return r3
        L3d:
            int r1 = r10.k()
            int r1 = r1 + (-2)
            r5 = 225(0xe1, float:3.15E-43)
            if (r0 == r5) goto L6b
            long r5 = (long) r1
            long r7 = r10.skip(r5)
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 == 0) goto L0
            boolean r10 = android.util.Log.isLoggable(r4, r2)
            if (r10 == 0) goto L6a
            java.lang.String r10 = ", wanted to skip: "
            java.lang.String r2 = ", but actually skipped: "
            java.lang.String r5 = "Unable to skip enough data, type: "
            java.lang.StringBuilder r10 = androidx.activity.g.q(r5, r0, r10, r1, r2)
            r10.append(r7)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r4, r10)
        L6a:
            return r3
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.n.g(k4.m):int");
    }

    public static int h(m mVar, byte[] bArr, int i9) {
        ByteOrder byteOrder;
        int read = mVar.read(bArr, i9);
        if (read == i9) {
            byte[] bArr2 = f5573a;
            boolean z8 = bArr != null && i9 > bArr2.length;
            if (z8) {
                int i10 = 0;
                while (true) {
                    if (i10 >= bArr2.length) {
                        break;
                    }
                    if (bArr[i10] != bArr2[i10]) {
                        z8 = false;
                        break;
                    }
                    i10++;
                }
            }
            if (!z8) {
                if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
                    return -1;
                }
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
                return -1;
            }
            ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i9);
            short s8 = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
            if (s8 == 18761) {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            } else if (s8 != 19789) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) s8));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
            byteBuffer.order(byteOrder);
            int i11 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
            int i12 = i11 + 6;
            short s9 = byteBuffer.remaining() - i12 >= 2 ? byteBuffer.getShort(i12) : (short) -1;
            for (int i13 = 0; i13 < s9; i13++) {
                int i14 = (i13 * 12) + i11 + 8;
                short s10 = byteBuffer.remaining() - i14 >= 2 ? byteBuffer.getShort(i14) : (short) -1;
                if (s10 == 274) {
                    int i15 = i14 + 2;
                    short s11 = byteBuffer.remaining() - i15 >= 2 ? byteBuffer.getShort(i15) : (short) -1;
                    if (s11 >= 1 && s11 <= 12) {
                        int i16 = i14 + 4;
                        int i17 = byteBuffer.remaining() - i16 >= 4 ? byteBuffer.getInt(i16) : -1;
                        if (i17 >= 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder q4 = androidx.activity.g.q("Got tagIndex=", i13, " tagType=", s10, " formatCode=");
                                q4.append((int) s11);
                                q4.append(" componentCount=");
                                q4.append(i17);
                                Log.d("DfltImageHeaderParser", q4.toString());
                            }
                            int i18 = i17 + f5574b[s11];
                            if (i18 <= 4) {
                                int i19 = i14 + 8;
                                if (i19 >= 0 && i19 <= byteBuffer.remaining()) {
                                    if (i18 >= 0 && i18 + i19 <= byteBuffer.remaining()) {
                                        if (byteBuffer.remaining() - i19 >= 2) {
                                            return byteBuffer.getShort(i19);
                                        }
                                        return -1;
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) s10));
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i19 + " tagType=" + ((int) s10));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) s11));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) s11));
                    }
                }
            }
        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i9 + ", actually read: " + read);
            return -1;
        }
        return -1;
    }

    @Override // b4.e
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        w4.f.c(byteBuffer, "Argument must not be null");
        return f(new k(0, byteBuffer));
    }

    @Override // b4.e
    public final int b(ByteBuffer byteBuffer, e4.f fVar) {
        k kVar = new k(0, byteBuffer);
        w4.f.c(fVar, "Argument must not be null");
        return e(kVar, fVar);
    }

    @Override // b4.e
    public final int c(InputStream inputStream, e4.f fVar) {
        i7.x xVar = new i7.x(inputStream, 1);
        w4.f.c(fVar, "Argument must not be null");
        return e(xVar, fVar);
    }

    @Override // b4.e
    public final ImageHeaderParser$ImageType d(InputStream inputStream) {
        return f(new i7.x(inputStream, 1));
    }
}
