package x5;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.WeakHashMap;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q extends ArrayAdapter {

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f10188i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f10189j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ r f10190k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, Context context, int i9, String[] strArr) {
        super(context, i9, strArr);
        this.f10190k = rVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        r rVar = this.f10190k;
        ColorStateList colorStateList2 = rVar.f10198t;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f10189j = colorStateList;
        if (rVar.f10197s != 0 && rVar.f10198t != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{f0.a.b(rVar.f10198t.getColorForState(iArr3, 0), rVar.f10197s), f0.a.b(rVar.f10198t.getColorForState(iArr2, 0), rVar.f10197s), rVar.f10197s});
        }
        this.f10188i = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i9, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            r rVar = this.f10190k;
            Drawable drawable = null;
            if (rVar.getText().toString().contentEquals(textView.getText()) && rVar.f10197s != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(rVar.f10197s);
                if (this.f10189j != null) {
                    g0.b.h(colorDrawable, this.f10188i);
                    drawable = new RippleDrawable(this.f10189j, colorDrawable, null);
                } else {
                    drawable = colorDrawable;
                }
            }
            WeakHashMap weakHashMap = t0.f7209a;
            c0.q(textView, drawable);
        }
        return view2;
    }
}
