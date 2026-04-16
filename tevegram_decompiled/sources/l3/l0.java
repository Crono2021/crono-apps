package l3;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 extends FrameLayout implements g0 {

    /* renamed from: i, reason: collision with root package name */
    public final b f6169i;

    /* renamed from: j, reason: collision with root package name */
    public final j0 f6170j;

    /* renamed from: k, reason: collision with root package name */
    public List f6171k;

    /* renamed from: l, reason: collision with root package name */
    public c f6172l;

    /* renamed from: m, reason: collision with root package name */
    public float f6173m;

    /* renamed from: n, reason: collision with root package name */
    public float f6174n;

    public l0(Context context) {
        super(context, null);
        this.f6171k = Collections.EMPTY_LIST;
        this.f6172l = c.f6090g;
        this.f6173m = 0.0533f;
        this.f6174n = 0.08f;
        b bVar = new b(context, 0);
        this.f6169i = bVar;
        j0 j0Var = new j0(context, null);
        this.f6170j = j0Var;
        j0Var.setBackgroundColor(0);
        addView(bVar);
        addView(j0Var);
    }

    @Override // l3.g0
    public final void a(List list, c cVar, float f9, float f10) {
        this.f6172l = cVar;
        this.f6173m = f9;
        this.f6174n = f10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i9 = 0; i9 < list.size(); i9++) {
            f1.b bVar = (f1.b) list.get(i9);
            if (bVar.f3246d != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f6171k.isEmpty() || !arrayList2.isEmpty()) {
            this.f6171k = arrayList2;
            c();
        }
        this.f6169i.a(arrayList, cVar, f9, f10);
        invalidate();
    }

    public final String b(int i9, float f9) {
        float X = com.bumptech.glide.d.X(f9, i9, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (X == -3.4028235E38f) {
            return "unset";
        }
        Object[] objArr = {Float.valueOf(X / getContext().getResources().getDisplayMetrics().density)};
        int i10 = g1.w.f3713a;
        return String.format(Locale.US, "%.2fpx", objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x04c5, code lost:
    
        if (((android.text.style.TypefaceSpan) r3).getFamily() != null) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x01f5, code lost:
    
        if (r9 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x01f8, code lost:
    
        r30 = "left";
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x01fa, code lost:
    
        r31 = "top";
        r4 = 2;
        r32 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0200, code lost:
    
        if (r9 != false) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x054e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x06d9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x065a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 1871
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.l0.c():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        if (!z8 || this.f6171k.isEmpty()) {
            return;
        }
        c();
    }
}
