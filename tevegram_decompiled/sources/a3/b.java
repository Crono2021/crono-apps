package a3;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f48a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f49b;

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f50c;

    /* renamed from: d, reason: collision with root package name */
    public int f51d;

    /* renamed from: e, reason: collision with root package name */
    public int f52e;

    /* renamed from: f, reason: collision with root package name */
    public int f53f;

    /* renamed from: g, reason: collision with root package name */
    public int f54g;
    public int h;

    public b(int i9, int i10) {
        ArrayList arrayList = new ArrayList();
        this.f48a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f49b = arrayList2;
        StringBuilder sb = new StringBuilder();
        this.f50c = sb;
        this.f54g = i9;
        arrayList.clear();
        arrayList2.clear();
        sb.setLength(0);
        this.f51d = 15;
        this.f52e = 0;
        this.f53f = 0;
        this.h = i10;
    }

    public final void a(char c9) {
        StringBuilder sb = this.f50c;
        if (sb.length() < 32) {
            sb.append(c9);
        }
    }

    public final void b() {
        StringBuilder sb = this.f50c;
        int length = sb.length();
        if (length > 0) {
            sb.delete(length - 1, length);
            ArrayList arrayList = this.f48a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                a aVar = (a) arrayList.get(size);
                int i9 = aVar.f47c;
                if (i9 != length) {
                    return;
                }
                aVar.f47c = i9 - 1;
            }
        }
    }

    public final f1.b c(int i9) {
        float f9;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f49b;
            if (i10 >= arrayList.size()) {
                break;
            }
            spannableStringBuilder.append((CharSequence) arrayList.get(i10));
            spannableStringBuilder.append('\n');
            i10++;
        }
        spannableStringBuilder.append((CharSequence) d());
        if (spannableStringBuilder.length() == 0) {
            return null;
        }
        int i11 = this.f52e + this.f53f;
        int length = (32 - i11) - spannableStringBuilder.length();
        int i12 = i11 - length;
        int i13 = i9 != Integer.MIN_VALUE ? i9 : (this.f54g != 2 || (Math.abs(i12) >= 3 && length >= 0)) ? (this.f54g != 2 || i12 <= 0) ? 0 : 2 : 1;
        if (i13 != 1) {
            if (i13 == 2) {
                i11 = 32 - length;
            }
            f9 = ((i11 / 32.0f) * 0.8f) + 0.1f;
        } else {
            f9 = 0.5f;
        }
        int i14 = this.f51d;
        if (i14 > 7) {
            i14 -= 17;
        } else if (this.f54g == 1) {
            i14 -= this.h - 1;
        }
        return new f1.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, null, null, i14, 1, Integer.MIN_VALUE, f9, i13, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f);
    }

    public final SpannableString d() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f50c);
        int length = spannableStringBuilder.length();
        int i9 = 0;
        int i10 = -1;
        int i11 = -1;
        int i12 = 0;
        int i13 = -1;
        int i14 = -1;
        boolean z8 = false;
        while (true) {
            ArrayList arrayList = this.f48a;
            if (i9 >= arrayList.size()) {
                break;
            }
            a aVar = (a) arrayList.get(i9);
            boolean z9 = aVar.f46b;
            int i15 = aVar.f45a;
            if (i15 != 8) {
                boolean z10 = i15 == 7;
                if (i15 != 7) {
                    i14 = c.A[i15];
                }
                z8 = z10;
            }
            int i16 = aVar.f47c;
            i9++;
            if (i16 != (i9 < arrayList.size() ? ((a) arrayList.get(i9)).f47c : length)) {
                if (i10 != -1 && !z9) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i10, i16, 33);
                    i10 = -1;
                } else if (i10 == -1 && z9) {
                    i10 = i16;
                }
                if (i11 != -1 && !z8) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), i11, i16, 33);
                    i11 = -1;
                } else if (i11 == -1 && z8) {
                    i11 = i16;
                }
                if (i14 != i13) {
                    if (i13 != -1) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(i13), i12, i16, 33);
                    }
                    i13 = i14;
                    i12 = i16;
                }
            }
        }
        if (i10 != -1 && i10 != length) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i10, length, 33);
        }
        if (i11 != -1 && i11 != length) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i11, length, 33);
        }
        if (i12 != length && i13 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i13), i12, length, 33);
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final boolean e() {
        return this.f48a.isEmpty() && this.f49b.isEmpty() && this.f50c.length() == 0;
    }
}
