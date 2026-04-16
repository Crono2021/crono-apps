package l0;

import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f5748a;

    /* renamed from: b, reason: collision with root package name */
    public final TextDirectionHeuristic f5749b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5750c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5751d;

    public f(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i9, int i10) {
        PrecomputedText.Params.Builder breakStrategy;
        PrecomputedText.Params.Builder hyphenationFrequency;
        PrecomputedText.Params.Builder textDirection;
        if (Build.VERSION.SDK_INT >= 29) {
            breakStrategy = androidx.emoji2.text.b.m(textPaint).setBreakStrategy(i9);
            hyphenationFrequency = breakStrategy.setHyphenationFrequency(i10);
            textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
            textDirection.build();
        }
        this.f5748a = textPaint;
        this.f5749b = textDirectionHeuristic;
        this.f5750c = i9;
        this.f5751d = i10;
    }

    public final boolean equals(Object obj) {
        LocaleList textLocales;
        LocaleList textLocales2;
        boolean equals;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 23 && (this.f5750c != fVar.f5750c || this.f5751d != fVar.f5751d)) {
            return false;
        }
        TextPaint textPaint = this.f5748a;
        float textSize = textPaint.getTextSize();
        TextPaint textPaint2 = fVar.f5748a;
        if (textSize != textPaint2.getTextSize() || textPaint.getTextScaleX() != textPaint2.getTextScaleX() || textPaint.getTextSkewX() != textPaint2.getTextSkewX() || textPaint.getLetterSpacing() != textPaint2.getLetterSpacing() || !TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) || textPaint.getFlags() != textPaint2.getFlags()) {
            return false;
        }
        if (i9 >= 24) {
            textLocales = textPaint.getTextLocales();
            textLocales2 = textPaint2.getTextLocales();
            equals = textLocales.equals(textLocales2);
            if (!equals) {
                return false;
            }
        } else if (!textPaint.getTextLocale().equals(textPaint2.getTextLocale())) {
            return false;
        }
        if (textPaint.getTypeface() == null) {
            if (textPaint2.getTypeface() != null) {
                return false;
            }
        } else if (!textPaint.getTypeface().equals(textPaint2.getTypeface())) {
            return false;
        }
        return this.f5749b == fVar.f5749b;
    }

    public final int hashCode() {
        LocaleList textLocales;
        int i9 = Build.VERSION.SDK_INT;
        TextDirectionHeuristic textDirectionHeuristic = this.f5749b;
        int i10 = this.f5751d;
        int i11 = this.f5750c;
        TextPaint textPaint = this.f5748a;
        if (i9 < 24) {
            return m0.a.b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocale(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i11), Integer.valueOf(i10));
        }
        Float valueOf = Float.valueOf(textPaint.getTextSize());
        Float valueOf2 = Float.valueOf(textPaint.getTextScaleX());
        Float valueOf3 = Float.valueOf(textPaint.getTextSkewX());
        Float valueOf4 = Float.valueOf(textPaint.getLetterSpacing());
        Integer valueOf5 = Integer.valueOf(textPaint.getFlags());
        textLocales = textPaint.getTextLocales();
        return m0.a.b(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, textLocales, textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i11), Integer.valueOf(i10));
    }

    public final String toString() {
        String fontVariationSettings;
        LocaleList textLocales;
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f5748a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 24) {
            StringBuilder sb3 = new StringBuilder(", textLocale=");
            textLocales = textPaint.getTextLocales();
            sb3.append(textLocales);
            sb.append(sb3.toString());
        } else {
            sb.append(", textLocale=" + textPaint.getTextLocale());
        }
        sb.append(", typeface=" + textPaint.getTypeface());
        if (i9 >= 26) {
            StringBuilder sb4 = new StringBuilder(", variationSettings=");
            fontVariationSettings = textPaint.getFontVariationSettings();
            sb4.append(fontVariationSettings);
            sb.append(sb4.toString());
        }
        sb.append(", textDir=" + this.f5749b);
        sb.append(", breakStrategy=" + this.f5750c);
        sb.append(", hyphenationFrequency=" + this.f5751d);
        sb.append("}");
        return sb.toString();
    }

    public f(PrecomputedText.Params params) {
        TextPaint textPaint;
        TextDirectionHeuristic textDirection;
        int breakStrategy;
        int hyphenationFrequency;
        textPaint = params.getTextPaint();
        this.f5748a = textPaint;
        textDirection = params.getTextDirection();
        this.f5749b = textDirection;
        breakStrategy = params.getBreakStrategy();
        this.f5750c = breakStrategy;
        hyphenationFrequency = params.getHyphenationFrequency();
        this.f5751d = hyphenationFrequency;
    }
}
