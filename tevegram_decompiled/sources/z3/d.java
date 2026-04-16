package z3;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import w2.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    public final File f10638i;

    /* renamed from: j, reason: collision with root package name */
    public final File f10639j;

    /* renamed from: k, reason: collision with root package name */
    public final File f10640k;

    /* renamed from: l, reason: collision with root package name */
    public final File f10641l;

    /* renamed from: n, reason: collision with root package name */
    public final long f10643n;

    /* renamed from: q, reason: collision with root package name */
    public BufferedWriter f10646q;

    /* renamed from: s, reason: collision with root package name */
    public int f10648s;

    /* renamed from: p, reason: collision with root package name */
    public long f10645p = 0;

    /* renamed from: r, reason: collision with root package name */
    public final LinkedHashMap f10647r = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: t, reason: collision with root package name */
    public long f10649t = 0;

    /* renamed from: u, reason: collision with root package name */
    public final ThreadPoolExecutor f10650u = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());

    /* renamed from: v, reason: collision with root package name */
    public final a f10651v = new a(this);

    /* renamed from: m, reason: collision with root package name */
    public final int f10642m = 1;

    /* renamed from: o, reason: collision with root package name */
    public final int f10644o = 1;

    public d(File file, long j5) {
        this.f10638i = file;
        this.f10639j = new File(file, "journal");
        this.f10640k = new File(file, "journal.tmp");
        this.f10641l = new File(file, "journal.bkp");
        this.f10643n = j5;
    }

    public static void a(d dVar, b2.b bVar, boolean z8) {
        synchronized (dVar) {
            c cVar = (c) bVar.f1138b;
            if (cVar.f10636f != bVar) {
                throw new IllegalStateException();
            }
            if (z8 && !cVar.f10635e) {
                for (int i9 = 0; i9 < dVar.f10644o; i9++) {
                    if (!((boolean[]) bVar.f1139c)[i9]) {
                        bVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i9);
                    }
                    if (!cVar.f10634d[i9].exists()) {
                        bVar.c();
                        return;
                    }
                }
            }
            for (int i10 = 0; i10 < dVar.f10644o; i10++) {
                File file = cVar.f10634d[i10];
                if (!z8) {
                    c(file);
                } else if (file.exists()) {
                    File file2 = cVar.f10633c[i10];
                    file.renameTo(file2);
                    long j5 = cVar.f10632b[i10];
                    long length = file2.length();
                    cVar.f10632b[i10] = length;
                    dVar.f10645p = (dVar.f10645p - j5) + length;
                }
            }
            dVar.f10648s++;
            cVar.f10636f = null;
            if (cVar.f10635e || z8) {
                cVar.f10635e = true;
                dVar.f10646q.append((CharSequence) "CLEAN");
                dVar.f10646q.append(' ');
                dVar.f10646q.append((CharSequence) cVar.f10631a);
                dVar.f10646q.append((CharSequence) cVar.a());
                dVar.f10646q.append('\n');
                if (z8) {
                    dVar.f10649t++;
                }
            } else {
                dVar.f10647r.remove(cVar.f10631a);
                dVar.f10646q.append((CharSequence) "REMOVE");
                dVar.f10646q.append(' ');
                dVar.f10646q.append((CharSequence) cVar.f10631a);
                dVar.f10646q.append('\n');
            }
            e(dVar.f10646q);
            if (dVar.f10645p > dVar.f10643n || dVar.g()) {
                dVar.f10650u.submit(dVar.f10651v);
            }
        }
    }

    public static void b(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void c(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void e(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static d h(File file, long j5) {
        if (j5 <= 0) {
            m7.c.n("maxSize <= 0");
            return null;
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m(file2, file3, false);
            }
        }
        d dVar = new d(file, j5);
        if (dVar.f10639j.exists()) {
            try {
                dVar.j();
                dVar.i();
                return dVar;
            } catch (IOException e9) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e9.getMessage() + ", removing");
                dVar.close();
                g.a(dVar.f10638i);
            }
        }
        file.mkdirs();
        d dVar2 = new d(file, j5);
        dVar2.l();
        return dVar2;
    }

    public static void m(File file, File file2, boolean z8) {
        if (z8) {
            c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f10646q == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f10647r.values());
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                b2.b bVar = ((c) obj).f10636f;
                if (bVar != null) {
                    bVar.c();
                }
            }
            n();
            b(this.f10646q);
            this.f10646q = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final b2.b d(String str) {
        synchronized (this) {
            try {
                if (this.f10646q == null) {
                    throw new IllegalStateException("cache is closed");
                }
                c cVar = (c) this.f10647r.get(str);
                if (cVar == null) {
                    cVar = new c(this, str);
                    this.f10647r.put(str, cVar);
                } else if (cVar.f10636f != null) {
                    return null;
                }
                b2.b bVar = new b2.b(this, cVar);
                cVar.f10636f = bVar;
                this.f10646q.append((CharSequence) "DIRTY");
                this.f10646q.append(' ');
                this.f10646q.append((CharSequence) str);
                this.f10646q.append('\n');
                e(this.f10646q);
                return bVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized z1.c f(String str) {
        if (this.f10646q == null) {
            throw new IllegalStateException("cache is closed");
        }
        c cVar = (c) this.f10647r.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f10635e) {
            return null;
        }
        for (File file : cVar.f10633c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f10648s++;
        this.f10646q.append((CharSequence) "READ");
        this.f10646q.append(' ');
        this.f10646q.append((CharSequence) str);
        this.f10646q.append('\n');
        if (g()) {
            this.f10650u.submit(this.f10651v);
        }
        return new z1.c(cVar.f10633c);
    }

    public final boolean g() {
        int i9 = this.f10648s;
        return i9 >= 2000 && i9 >= this.f10647r.size();
    }

    public final void i() {
        c(this.f10640k);
        Iterator it = this.f10647r.values().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            b2.b bVar = cVar.f10636f;
            int i9 = this.f10644o;
            int i10 = 0;
            if (bVar == null) {
                while (i10 < i9) {
                    this.f10645p += cVar.f10632b[i10];
                    i10++;
                }
            } else {
                cVar.f10636f = null;
                while (i10 < i9) {
                    c(cVar.f10633c[i10]);
                    c(cVar.f10634d[i10]);
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void j() {
        File file = this.f10639j;
        f fVar = new f(new FileInputStream(file), g.f10658a);
        try {
            String a9 = fVar.a();
            String a10 = fVar.a();
            String a11 = fVar.a();
            String a12 = fVar.a();
            String a13 = fVar.a();
            if (!"libcore.io.DiskLruCache".equals(a9) || !"1".equals(a10) || !Integer.toString(this.f10642m).equals(a11) || !Integer.toString(this.f10644o).equals(a12) || !"".equals(a13)) {
                throw new IOException("unexpected journal header: [" + a9 + ", " + a10 + ", " + a12 + ", " + a13 + "]");
            }
            int i9 = 0;
            while (true) {
                try {
                    k(fVar.a());
                    i9++;
                } catch (EOFException unused) {
                    this.f10648s = i9 - this.f10647r.size();
                    if (fVar.f10657m == -1) {
                        l();
                    } else {
                        this.f10646q = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), g.f10658a));
                    }
                    try {
                        fVar.close();
                        return;
                    } catch (RuntimeException e9) {
                        throw e9;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                fVar.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void k(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i9 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i9);
        LinkedHashMap linkedHashMap = this.f10647r;
        if (indexOf2 == -1) {
            substring = str.substring(i9);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i9, indexOf2);
        }
        c cVar = (c) linkedHashMap.get(substring);
        if (cVar == null) {
            cVar = new c(this, substring);
            linkedHashMap.put(substring, cVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f10636f = new b2.b(this, cVar);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        cVar.f10635e = true;
        cVar.f10636f = null;
        if (split.length != cVar.f10637g.f10644o) {
            k.a(Arrays.toString(split), "unexpected journal line: ");
            return;
        }
        for (int i10 = 0; i10 < split.length; i10++) {
            try {
                cVar.f10632b[i10] = Long.parseLong(split[i10]);
            } catch (NumberFormatException unused) {
                k.a(Arrays.toString(split), "unexpected journal line: ");
                return;
            }
        }
    }

    public final synchronized void l() {
        try {
            BufferedWriter bufferedWriter = this.f10646q;
            if (bufferedWriter != null) {
                b(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10640k), g.f10658a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f10642m));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f10644o));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (c cVar : this.f10647r.values()) {
                    if (cVar.f10636f != null) {
                        bufferedWriter2.write("DIRTY " + cVar.f10631a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + cVar.f10631a + cVar.a() + '\n');
                    }
                }
                b(bufferedWriter2);
                if (this.f10639j.exists()) {
                    m(this.f10639j, this.f10641l, true);
                }
                m(this.f10640k, this.f10639j, false);
                this.f10641l.delete();
                this.f10646q = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10639j, true), g.f10658a));
            } catch (Throwable th) {
                b(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void n() {
        while (this.f10645p > this.f10643n) {
            String str = (String) ((Map.Entry) this.f10647r.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.f10646q == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    c cVar = (c) this.f10647r.get(str);
                    if (cVar != null && cVar.f10636f == null) {
                        for (int i9 = 0; i9 < this.f10644o; i9++) {
                            File file = cVar.f10633c[i9];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j5 = this.f10645p;
                            long[] jArr = cVar.f10632b;
                            this.f10645p = j5 - jArr[i9];
                            jArr[i9] = 0;
                        }
                        this.f10648s++;
                        this.f10646q.append((CharSequence) "REMOVE");
                        this.f10646q.append(' ');
                        this.f10646q.append((CharSequence) str);
                        this.f10646q.append('\n');
                        this.f10647r.remove(str);
                        if (g()) {
                            this.f10650u.submit(this.f10651v);
                        }
                    }
                } finally {
                }
            }
        }
    }
}
