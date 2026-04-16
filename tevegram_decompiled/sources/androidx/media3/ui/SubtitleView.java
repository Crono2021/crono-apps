package androidx.media3.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.bumptech.glide.d;
import f1.a;
import f1.f;
import g1.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l3.b;
import l3.c;
import l3.g0;
import l3.l0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class SubtitleView extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    public List f1015i;

    /* renamed from: j, reason: collision with root package name */
    public c f1016j;

    /* renamed from: k, reason: collision with root package name */
    public float f1017k;

    /* renamed from: l, reason: collision with root package name */
    public float f1018l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1019m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1020n;

    /* renamed from: o, reason: collision with root package name */
    public int f1021o;

    /* renamed from: p, reason: collision with root package name */
    public g0 f1022p;

    /* renamed from: q, reason: collision with root package name */
    public View f1023q;

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1015i = Collections.EMPTY_LIST;
        this.f1016j = c.f6090g;
        this.f1017k = 0.0533f;
        this.f1018l = 0.08f;
        this.f1019m = true;
        this.f1020n = true;
        b bVar = new b(context, 0);
        this.f1022p = bVar;
        this.f1023q = bVar;
        addView(bVar);
        this.f1021o = 1;
    }

    private List<f1.b> getCuesWithStylingPreferencesApplied() {
        if (this.f1019m && this.f1020n) {
            return this.f1015i;
        }
        ArrayList arrayList = new ArrayList(this.f1015i.size());
        for (int i9 = 0; i9 < this.f1015i.size(); i9++) {
            a a9 = ((f1.b) this.f1015i.get(i9)).a();
            if (!this.f1019m) {
                a9.f3230n = false;
                CharSequence charSequence = a9.f3218a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        a9.f3218a = SpannableString.valueOf(charSequence);
                    }
                    CharSequence charSequence2 = a9.f3218a;
                    charSequence2.getClass();
                    Spannable spannable = (Spannable) charSequence2;
                    for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                        if (!(obj instanceof f)) {
                            spannable.removeSpan(obj);
                        }
                    }
                }
                d.W(a9);
            } else if (!this.f1020n) {
                d.W(a9);
            }
            arrayList.add(a9.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (w.f3713a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private c getUserCaptionStyle() {
        CaptioningManager captioningManager;
        int i9 = w.f3713a;
        c cVar = c.f6090g;
        if (i9 < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return cVar;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i9 >= 21) {
            return new c(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : -16777216, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
        }
        return new c(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
    }

    private <T extends View & g0> void setView(T t8) {
        removeView(this.f1023q);
        View view = this.f1023q;
        if (view instanceof l0) {
            ((l0) view).f6170j.destroy();
        }
        this.f1023q = t8;
        this.f1022p = t8;
        addView(t8);
    }

    public final void a() {
        setStyle(getUserCaptionStyle());
    }

    public final void b() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void c() {
        this.f1022p.a(getCuesWithStylingPreferencesApplied(), this.f1016j, this.f1017k, this.f1018l);
    }

    public void setApplyEmbeddedFontSizes(boolean z8) {
        this.f1020n = z8;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z8) {
        this.f1019m = z8;
        c();
    }

    public void setBottomPaddingFraction(float f9) {
        this.f1018l = f9;
        c();
    }

    public void setCues(List<f1.b> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f1015i = list;
        c();
    }

    public void setFractionalTextSize(float f9) {
        this.f1017k = f9;
        c();
    }

    public void setStyle(c cVar) {
        this.f1016j = cVar;
        c();
    }

    public void setViewType(int i9) {
        if (this.f1021o == i9) {
            return;
        }
        if (i9 == 1) {
            setView(new b(getContext(), 0));
        } else {
            if (i9 != 2) {
                m7.c.d();
                return;
            }
            setView(new l0(getContext()));
        }
        this.f1021o = i9;
    }
}
