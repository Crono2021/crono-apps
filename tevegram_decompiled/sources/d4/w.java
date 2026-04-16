package d4;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w extends Exception {

    /* renamed from: n, reason: collision with root package name */
    public static final StackTraceElement[] f2933n = new StackTraceElement[0];

    /* renamed from: i, reason: collision with root package name */
    public final List f2934i;

    /* renamed from: j, reason: collision with root package name */
    public b4.f f2935j;

    /* renamed from: k, reason: collision with root package name */
    public int f2936k;

    /* renamed from: l, reason: collision with root package name */
    public Class f2937l;

    /* renamed from: m, reason: collision with root package name */
    public final String f2938m;

    public w(String str, List list) {
        this.f2938m = str;
        setStackTrace(f2933n);
        this.f2934i = list;
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (!(th instanceof w)) {
            arrayList.add(th);
            return;
        }
        Iterator it = ((w) th).f2934i.iterator();
        while (it.hasNext()) {
            a((Throwable) it.next(), arrayList);
        }
    }

    public static void b(List list, v vVar) {
        int size = list.size();
        int i9 = 0;
        while (i9 < size) {
            vVar.append("Cause (");
            int i10 = i9 + 1;
            vVar.append(String.valueOf(i10));
            vVar.append(" of ");
            vVar.append(String.valueOf(size));
            vVar.append("): ");
            Throwable th = (Throwable) list.get(i9);
            if (th instanceof w) {
                ((w) th).e(vVar);
            } else {
                c(th, vVar);
            }
            i9 = i10;
        }
    }

    public static void c(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void d() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i10 = i9 + 1;
            sb.append(i10);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i("Glide", sb.toString(), (Throwable) arrayList.get(i9));
            i9 = i10;
        }
    }

    public final void e(Appendable appendable) {
        c(this, appendable);
        try {
            b(this.f2934i, new v(appendable));
        } catch (IOException e9) {
            throw new RuntimeException(e9);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f2938m);
        String str2 = "";
        if (this.f2937l != null) {
            str = ", " + this.f2937l;
        } else {
            str = "";
        }
        sb.append(str);
        int i9 = this.f2936k;
        sb.append(i9 != 0 ? ", ".concat(androidx.activity.g.C(i9)) : "");
        if (this.f2935j != null) {
            str2 = ", " + this.f2935j;
        }
        sb.append(str2);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" root causes:");
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Throwable th = (Throwable) obj;
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        e(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        e(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        e(printWriter);
    }

    public w(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
