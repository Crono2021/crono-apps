package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x extends ReplacementSpan {

    /* renamed from: j, reason: collision with root package name */
    public final q f666j;

    /* renamed from: i, reason: collision with root package name */
    public final Paint.FontMetricsInt f665i = new Paint.FontMetricsInt();

    /* renamed from: k, reason: collision with root package name */
    public float f667k = 1.0f;

    public x(q qVar) {
        android.support.v4.media.session.b.r(qVar, "metadata cannot be null");
        this.f666j = qVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i9, int i10, float f9, int i11, int i12, int i13, Paint paint) {
        l.a().getClass();
        q qVar = this.f666j;
        a0.l lVar = qVar.f642b;
        Typeface typeface = (Typeface) lVar.f33l;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) lVar.f31j, qVar.f641a * 2, 2, f9, i12, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i9, int i10, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f665i;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        q qVar = this.f666j;
        this.f667k = abs / (qVar.b().a(14) != 0 ? ((ByteBuffer) r8.f7134d).getShort(r1 + r8.f7131a) : (short) 0);
        w0.a b9 = qVar.b();
        int a9 = b9.a(14);
        if (a9 != 0) {
            ((ByteBuffer) b9.f7134d).getShort(a9 + b9.f7131a);
        }
        short s8 = (short) ((qVar.b().a(12) != 0 ? ((ByteBuffer) r5.f7134d).getShort(r7 + r5.f7131a) : (short) 0) * this.f667k);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s8;
    }
}
