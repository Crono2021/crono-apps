package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q0 extends Writer {

    /* renamed from: j, reason: collision with root package name */
    public final StringBuilder f838j = new StringBuilder(128);

    /* renamed from: i, reason: collision with root package name */
    public final String f837i = "FragmentManager";

    public final void a() {
        StringBuilder sb = this.f838j;
        if (sb.length() > 0) {
            Log.d(this.f837i, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i9, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            char c9 = cArr[i9 + i11];
            if (c9 == '\n') {
                a();
            } else {
                this.f838j.append(c9);
            }
        }
    }
}
