package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements TextWatcher, SpanWatcher {

    /* renamed from: i, reason: collision with root package name */
    public final Object f661i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicInteger f662j = new AtomicInteger(0);

    public v(Object obj) {
        this.f661i = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f661i).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        ((TextWatcher) this.f661i).beforeTextChanged(charSequence, i9, i10, i11);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i9, int i10) {
        if (this.f662j.get() <= 0 || !(obj instanceof x)) {
            ((SpanWatcher) this.f661i).onSpanAdded(spannable, obj, i9, i10);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i9, int i10, int i11, int i12) {
        int i13;
        int i14;
        if (this.f662j.get() <= 0 || !(obj instanceof x)) {
            if (Build.VERSION.SDK_INT < 28) {
                if (i9 > i10) {
                    i9 = 0;
                }
                if (i11 > i12) {
                    i13 = i9;
                    i14 = 0;
                    ((SpanWatcher) this.f661i).onSpanChanged(spannable, obj, i13, i10, i14, i12);
                }
            }
            i13 = i9;
            i14 = i11;
            ((SpanWatcher) this.f661i).onSpanChanged(spannable, obj, i13, i10, i14, i12);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i9, int i10) {
        if (this.f662j.get() <= 0 || !(obj instanceof x)) {
            ((SpanWatcher) this.f661i).onSpanRemoved(spannable, obj, i9, i10);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        ((TextWatcher) this.f661i).onTextChanged(charSequence, i9, i10, i11);
    }
}
