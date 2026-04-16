package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w extends SpannableStringBuilder {

    /* renamed from: i, reason: collision with root package name */
    public final Class f663i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f664j;

    public w(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f664j = new ArrayList();
        android.support.v4.media.session.b.r(cls, "watcherClass cannot be null");
        this.f663i = cls;
    }

    public final void a() {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f664j;
            if (i9 >= arrayList.size()) {
                return;
            }
            ((v) arrayList.get(i9)).f662j.incrementAndGet();
            i9++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f664j;
            if (i9 >= arrayList.size()) {
                return;
            }
            ((v) arrayList.get(i9)).onTextChanged(this, 0, length(), length());
            i9++;
        }
    }

    public final v c(Object obj) {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f664j;
            if (i9 >= arrayList.size()) {
                return null;
            }
            v vVar = (v) arrayList.get(i9);
            if (vVar.f661i == obj) {
                return vVar;
            }
            i9++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            return this.f663i == obj.getClass();
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i9, int i10) {
        super.delete(i9, i10);
        return this;
    }

    public final void e() {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f664j;
            if (i9 >= arrayList.size()) {
                return;
            }
            ((v) arrayList.get(i9)).f662j.decrementAndGet();
            i9++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        v c9;
        if (d(obj) && (c9 = c(obj)) != null) {
            obj = c9;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        v c9;
        if (d(obj) && (c9 = c(obj)) != null) {
            obj = c9;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        v c9;
        if (d(obj) && (c9 = c(obj)) != null) {
            obj = c9;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i9, int i10, Class cls) {
        if (this.f663i != cls) {
            return super.getSpans(i9, i10, cls);
        }
        v[] vVarArr = (v[]) super.getSpans(i9, i10, v.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, vVarArr.length);
        for (int i11 = 0; i11 < vVarArr.length; i11++) {
            objArr[i11] = vVarArr[i11].f661i;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i9, CharSequence charSequence) {
        super.insert(i9, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i9, int i10, Class cls) {
        if (cls == null || this.f663i == cls) {
            cls = v.class;
        }
        return super.nextSpanTransition(i9, i10, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        v vVar;
        if (d(obj)) {
            vVar = c(obj);
            if (vVar != null) {
                obj = vVar;
            }
        } else {
            vVar = null;
        }
        super.removeSpan(obj);
        if (vVar != null) {
            this.f664j.remove(vVar);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i9, int i10, CharSequence charSequence, int i11, int i12) {
        a();
        super.replace(i9, i10, charSequence, i11, i12);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i9, int i10, int i11) {
        if (d(obj)) {
            v vVar = new v(obj);
            this.f664j.add(vVar);
            obj = vVar;
        }
        super.setSpan(obj, i9, i10, i11);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i9, int i10) {
        return new w(this.f663i, this, i9, i10);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i9, int i10) {
        super.delete(i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i9, CharSequence charSequence) {
        super.insert(i9, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i9, CharSequence charSequence, int i10, int i11) {
        super.insert(i9, charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i9, CharSequence charSequence, int i10, int i11) {
        super.insert(i9, charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c9) {
        super.append(c9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i9, int i10) {
        super.append(charSequence, i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i9, int i10) {
        super.append(charSequence, i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i9, int i10) {
        super.append(charSequence, i9, i10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i9, int i10, CharSequence charSequence, int i11, int i12) {
        replace(i9, i10, charSequence, i11, i12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i9) {
        super.append(charSequence, obj, i9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i9, int i10, CharSequence charSequence) {
        a();
        super.replace(i9, i10, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i9, int i10, CharSequence charSequence) {
        replace(i9, i10, charSequence);
        return this;
    }

    public w(Class cls, w wVar, int i9, int i10) {
        super(wVar, i9, i10);
        this.f664j = new ArrayList();
        android.support.v4.media.session.b.r(cls, "watcherClass cannot be null");
        this.f663i = cls;
    }
}
