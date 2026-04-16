package o5;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: l, reason: collision with root package name */
    public static final int f7978l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f7979m;

    /* renamed from: n, reason: collision with root package name */
    public static Constructor f7980n;

    /* renamed from: o, reason: collision with root package name */
    public static TextDirectionHeuristic f7981o;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f7982a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f7983b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7984c;

    /* renamed from: d, reason: collision with root package name */
    public int f7985d;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7990j;

    /* renamed from: e, reason: collision with root package name */
    public Layout.Alignment f7986e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f7987f = Integer.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public float f7988g = 1.0f;
    public int h = f7978l;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7989i = true;

    /* renamed from: k, reason: collision with root package name */
    public TextUtils.TruncateAt f7991k = null;

    static {
        f7978l = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public k(CharSequence charSequence, TextPaint textPaint, int i9) {
        this.f7982a = charSequence;
        this.f7983b = textPaint;
        this.f7984c = i9;
        this.f7985d = charSequence.length();
    }

    public final StaticLayout a() {
        StaticLayout.Builder obtain;
        StaticLayout build;
        if (this.f7982a == null) {
            this.f7982a = "";
        }
        int max = Math.max(0, this.f7984c);
        CharSequence charSequence = this.f7982a;
        int i9 = this.f7987f;
        TextPaint textPaint = this.f7983b;
        if (i9 == 1) {
            charSequence = TextUtils.ellipsize(charSequence, textPaint, max, this.f7991k);
        }
        int min = Math.min(charSequence.length(), this.f7985d);
        this.f7985d = min;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            if (this.f7990j && this.f7987f == 1) {
                this.f7986e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            obtain = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
            obtain.setAlignment(this.f7986e);
            obtain.setIncludePad(this.f7989i);
            obtain.setTextDirection(this.f7990j ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f7991k;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f7987f);
            float f9 = this.f7988g;
            if (f9 != 1.0f) {
                obtain.setLineSpacing(0.0f, f9);
            }
            if (this.f7987f > 1) {
                obtain.setHyphenationFrequency(this.h);
            }
            build = obtain.build();
            return build;
        }
        if (!f7979m) {
            try {
                f7981o = this.f7990j && i10 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                f7980n = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f7979m = true;
            } catch (Exception e9) {
                throw new j(e9);
            }
        }
        try {
            Constructor constructor = f7980n;
            constructor.getClass();
            Integer valueOf = Integer.valueOf(this.f7985d);
            Integer valueOf2 = Integer.valueOf(max);
            Layout.Alignment alignment = this.f7986e;
            TextDirectionHeuristic textDirectionHeuristic = f7981o;
            textDirectionHeuristic.getClass();
            return (StaticLayout) constructor.newInstance(charSequence, 0, valueOf, textPaint, valueOf2, alignment, textDirectionHeuristic, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f7989i), null, Integer.valueOf(max), Integer.valueOf(this.f7987f));
        } catch (Exception e10) {
            throw new j(e10);
        }
    }
}
