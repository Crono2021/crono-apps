package o5;

import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public float f7994c;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f7996e;

    /* renamed from: f, reason: collision with root package name */
    public r5.d f7997f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f7992a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final i5.a f7993b = new i5.a(this, 1);

    /* renamed from: d, reason: collision with root package name */
    public boolean f7995d = true;

    public m(i5.e eVar) {
        this.f7996e = new WeakReference(null);
        this.f7996e = new WeakReference(eVar);
    }

    public final float a(String str) {
        if (!this.f7995d) {
            return this.f7994c;
        }
        TextPaint textPaint = this.f7992a;
        this.f7994c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.f7995d = false;
        return this.f7994c;
    }
}
