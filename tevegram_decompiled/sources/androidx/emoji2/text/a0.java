package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 implements Spannable {

    /* renamed from: i, reason: collision with root package name */
    public boolean f609i = false;

    /* renamed from: j, reason: collision with root package name */
    public Spannable f610j;

    public a0(CharSequence charSequence) {
        this.f610j = new SpannableString(charSequence);
    }

    public final void a() {
        Spannable spannable = this.f610j;
        if (!this.f609i) {
            if ((Build.VERSION.SDK_INT < 28 ? new u5.e(5) : new z(5)).j(spannable)) {
                this.f610j = new SpannableString(spannable);
            }
        }
        this.f609i = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i9) {
        return this.f610j.charAt(i9);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        IntStream chars;
        chars = this.f610j.chars();
        return chars;
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        IntStream codePoints;
        codePoints = this.f610j.codePoints();
        return codePoints;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f610j.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f610j.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f610j.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i9, int i10, Class cls) {
        return this.f610j.getSpans(i9, i10, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f610j.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i9, int i10, Class cls) {
        return this.f610j.nextSpanTransition(i9, i10, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f610j.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i9, int i10, int i11) {
        a();
        this.f610j.setSpan(obj, i9, i10, i11);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i9, int i10) {
        return this.f610j.subSequence(i9, i10);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f610j.toString();
    }

    public a0(Spannable spannable) {
        this.f610j = spannable;
    }
}
