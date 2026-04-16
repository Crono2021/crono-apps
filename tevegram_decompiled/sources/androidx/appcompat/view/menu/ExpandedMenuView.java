package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.g;
import m.b0;
import m.l;
import m.m;
import m.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class ExpandedMenuView extends ListView implements l, b0, AdapterView.OnItemClickListener {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f374j = {R.attr.background, R.attr.divider};

    /* renamed from: i, reason: collision with root package name */
    public m f375i;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        g g02 = g.g0(context, attributeSet, f374j, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) g02.f729k;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(g02.Q(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(g02.Q(1));
        }
        g02.i0();
    }

    @Override // m.b0
    public final void b(m mVar) {
        this.f375i = mVar;
    }

    @Override // m.l
    public final boolean c(o oVar) {
        return this.f375i.q(oVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
        c((o) getAdapter().getItem(i9));
    }
}
