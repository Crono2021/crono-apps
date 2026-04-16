package g3;

import a6.b;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.activity.g;
import b6.e0;
import b6.g0;
import b6.w0;
import g1.c;
import g1.p;
import g1.w;
import java.nio.charset.Charset;
import java.util.List;
import z2.f;
import z2.k;
import z2.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements l {

    /* renamed from: i, reason: collision with root package name */
    public final p f3728i = new p();

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3729j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3730k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3731l;

    /* renamed from: m, reason: collision with root package name */
    public final String f3732m;

    /* renamed from: n, reason: collision with root package name */
    public final float f3733n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3734o;

    public a(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f3730k = 0;
            this.f3731l = -1;
            this.f3732m = "sans-serif";
            this.f3729j = false;
            this.f3733n = 0.85f;
            this.f3734o = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f3730k = bArr[24];
        this.f3731l = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f3732m = "Serif".equals(new String(bArr, 43, bArr.length - 43, b.f203c)) ? "serif" : "sans-serif";
        int i9 = bArr[25] * 20;
        this.f3734o = i9;
        boolean z8 = (bArr[0] & 32) != 0;
        this.f3729j = z8;
        if (z8) {
            this.f3733n = w.g(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i9, 0.0f, 0.95f);
        } else {
            this.f3733n = 0.85f;
        }
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i9, int i10, int i11, int i12, int i13) {
        if (i9 != i10) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i9 >>> 8) | ((i9 & 255) << 24)), i11, i12, i13 | 33);
        }
    }

    public static void b(SpannableStringBuilder spannableStringBuilder, int i9, int i10, int i11, int i12, int i13) {
        if (i9 != i10) {
            int i14 = i13 | 33;
            boolean z8 = (i9 & 1) != 0;
            boolean z9 = (i9 & 2) != 0;
            if (z8) {
                if (z9) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i11, i12, i14);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i11, i12, i14);
                }
            } else if (z9) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, i12, i14);
            }
            boolean z10 = (i9 & 4) != 0;
            if (z10) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, i14);
            }
            if (z10 || z8 || z9) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i11, i12, i14);
        }
    }

    @Override // z2.l
    public final void a0(byte[] bArr, int i9, int i10, k kVar, c cVar) {
        String r8;
        int i11;
        p pVar = this.f3728i;
        pVar.D(bArr, i9 + i10);
        pVar.F(i9);
        int i12 = 1;
        int i13 = 2;
        g1.a.f(pVar.a() >= 2);
        int z8 = pVar.z();
        if (z8 == 0) {
            r8 = "";
        } else {
            int i14 = pVar.f3700b;
            Charset B = pVar.B();
            int i15 = z8 - (pVar.f3700b - i14);
            if (B == null) {
                B = b.f203c;
            }
            r8 = pVar.r(i15, B);
        }
        if (r8.isEmpty()) {
            e0 e0Var = g0.f1391j;
            cVar.accept(new z2.a(-9223372036854775807L, -9223372036854775807L, w0.f1464m));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(r8);
        b(spannableStringBuilder, this.f3730k, 0, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f3731l, -1, 0, spannableStringBuilder.length(), 16711680);
        int length = spannableStringBuilder.length();
        String str = this.f3732m;
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float f9 = this.f3733n;
        while (pVar.a() >= 8) {
            int i16 = pVar.f3700b;
            int g9 = pVar.g();
            int g10 = pVar.g();
            if (g10 == 1937013100) {
                g1.a.f(pVar.a() >= i13);
                int z9 = pVar.z();
                int i17 = 0;
                while (i17 < z9) {
                    g1.a.f(pVar.a() >= 12);
                    int z10 = pVar.z();
                    int z11 = pVar.z();
                    pVar.G(i13);
                    int i18 = i17;
                    int t8 = pVar.t();
                    pVar.G(i12);
                    int g11 = pVar.g();
                    if (z11 > spannableStringBuilder.length()) {
                        StringBuilder p5 = g.p(z11, "Truncating styl end (", ") to cueText.length() (");
                        p5.append(spannableStringBuilder.length());
                        p5.append(").");
                        g1.a.D("Tx3gParser", p5.toString());
                        z11 = spannableStringBuilder.length();
                    }
                    if (z10 >= z11) {
                        g1.a.D("Tx3gParser", "Ignoring styl with start (" + z10 + ") >= end (" + z11 + ").");
                        i11 = i18;
                    } else {
                        i11 = i18;
                        int i19 = z11;
                        b(spannableStringBuilder, t8, this.f3730k, z10, i19, 0);
                        a(spannableStringBuilder, g11, this.f3731l, z10, i19, 0);
                    }
                    i17 = i11 + 1;
                    i12 = 1;
                    i13 = 2;
                }
            } else if (g10 == 1952608120 && this.f3729j) {
                g1.a.f(pVar.a() >= 2);
                f9 = w.g(pVar.z() / this.f3734o, 0.0f, 0.95f);
                pVar.F(i16 + g9);
                i12 = 1;
                i13 = 2;
            }
            pVar.F(i16 + g9);
            i12 = 1;
            i13 = 2;
        }
        cVar.accept(new z2.a(-9223372036854775807L, -9223372036854775807L, g0.q(new f1.b(spannableStringBuilder, null, null, null, f9, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f))));
    }

    @Override // z2.l
    public final /* synthetic */ f h0(int i9, int i10, byte[] bArr) {
        return t.a.a(this, bArr, i10);
    }

    @Override // z2.l
    public final /* synthetic */ void reset() {
    }
}
