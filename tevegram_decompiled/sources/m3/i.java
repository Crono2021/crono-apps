package m3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f6631a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6632b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6633c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6634d;

    public i(int i9, long j5, int i10, long j9) {
        this.f6631a = i9;
        this.f6632b = i10;
        this.f6633c = j5;
        this.f6634d = j9;
    }

    public static i a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            i iVar = new i(dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readInt(), dataInputStream.readLong());
            dataInputStream.close();
            return iVar;
        } finally {
        }
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f6631a);
            dataOutputStream.writeInt(this.f6632b);
            dataOutputStream.writeLong(this.f6633c);
            dataOutputStream.writeLong(this.f6634d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof i)) {
            i iVar = (i) obj;
            if (this.f6632b == iVar.f6632b && this.f6633c == iVar.f6633c && this.f6631a == iVar.f6631a && this.f6634d == iVar.f6634d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6632b), Long.valueOf(this.f6633c), Integer.valueOf(this.f6631a), Long.valueOf(this.f6634d));
    }
}
