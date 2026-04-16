package y0;

import android.util.Log;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteOrder;
import w2.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class b extends InputStream implements DataInput {

    /* renamed from: m, reason: collision with root package name */
    public static final ByteOrder f10349m = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: n, reason: collision with root package name */
    public static final ByteOrder f10350n = ByteOrder.BIG_ENDIAN;

    /* renamed from: i, reason: collision with root package name */
    public final DataInputStream f10351i;

    /* renamed from: j, reason: collision with root package name */
    public ByteOrder f10352j;

    /* renamed from: k, reason: collision with root package name */
    public int f10353k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f10354l;

    public b(InputStream inputStream, int i9) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this.f10352j = byteOrder;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f10351i = dataInputStream;
        dataInputStream.mark(0);
        this.f10353k = 0;
        this.f10352j = byteOrder;
    }

    public final void a(int i9) {
        int i10 = 0;
        while (i10 < i9) {
            int i11 = i9 - i10;
            DataInputStream dataInputStream = this.f10351i;
            int skip = (int) dataInputStream.skip(i11);
            if (skip <= 0) {
                if (this.f10354l == null) {
                    this.f10354l = new byte[8192];
                }
                skip = dataInputStream.read(this.f10354l, 0, Math.min(8192, i11));
                if (skip == -1) {
                    throw new EOFException("Reached EOF while skipping " + i9 + " bytes.");
                }
            }
            i10 += skip;
        }
        this.f10353k += i10;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f10351i.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i9) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f10353k++;
        return this.f10351i.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f10353k++;
        return this.f10351i.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        this.f10353k++;
        int read = this.f10351i.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f10353k += 2;
        return this.f10351i.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        this.f10353k += bArr.length;
        this.f10351i.readFully(bArr);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        this.f10353k += 4;
        DataInputStream dataInputStream = this.f10351i;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        if ((read | read2 | read3 | read4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f10352j;
        if (byteOrder == f10349m) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
        }
        if (byteOrder == f10350n) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        k.a(this.f10352j, "Invalid byte order: ");
        return 0;
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() {
        long j5;
        long j9;
        this.f10353k += 8;
        DataInputStream dataInputStream = this.f10351i;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        int read5 = dataInputStream.read();
        int read6 = dataInputStream.read();
        int read7 = dataInputStream.read();
        int read8 = dataInputStream.read();
        if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f10352j;
        if (byteOrder == f10349m) {
            j5 = (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8);
            j9 = read;
        } else {
            if (byteOrder != f10350n) {
                k.a(this.f10352j, "Invalid byte order: ");
                return 0L;
            }
            j5 = (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8);
            j9 = read8;
        }
        return j5 + j9;
    }

    @Override // java.io.DataInput
    public final short readShort() {
        this.f10353k += 2;
        DataInputStream dataInputStream = this.f10351i;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f10352j;
        if (byteOrder == f10349m) {
            return (short) ((read2 << 8) + read);
        }
        if (byteOrder == f10350n) {
            return (short) ((read << 8) + read2);
        }
        k.a(this.f10352j, "Invalid byte order: ");
        return (short) 0;
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f10353k += 2;
        return this.f10351i.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f10353k++;
        return this.f10351i.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        this.f10353k += 2;
        DataInputStream dataInputStream = this.f10351i;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f10352j;
        if (byteOrder == f10349m) {
            return (read2 << 8) + read;
        }
        if (byteOrder == f10350n) {
            return (read << 8) + read2;
        }
        k.a(this.f10352j, "Invalid byte order: ");
        return 0;
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i9) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i9, int i10) {
        this.f10353k += i10;
        this.f10351i.readFully(bArr, i9, i10);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i9, int i10) {
        int read = this.f10351i.read(bArr, i9, i10);
        this.f10353k += read;
        return read;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(InputStream inputStream) {
        this(inputStream, 0);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(byte[] r2) {
        /*
            r1 = this;
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r2)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
            r2 = 0
            r1.<init>(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.b.<init>(byte[]):void");
    }
}
