package m;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class u implements d0, z, AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    public Rect f6482i;

    public static int m(ListAdapter listAdapter, Context context, int i9) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        FrameLayout frameLayout = null;
        View view = null;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < count; i12++) {
            int itemViewType = listAdapter.getItemViewType(i12);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i12, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i9) {
                return i9;
            }
            if (measuredWidth > i10) {
                i10 = measuredWidth;
            }
        }
        return i10;
    }

    @Override // m.z
    public final boolean f(o oVar) {
        return false;
    }

    @Override // m.z
    public final boolean k(o oVar) {
        return false;
    }

    public abstract void l(m mVar);

    public abstract void n(View view);

    public abstract void o(boolean z8);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (j) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (j) listAdapter).f6428i.q((MenuItem) listAdapter.getItem(i9), this, !(this instanceof g) ? 0 : 4);
    }

    public abstract void p(int i9);

    public abstract void q(int i9);

    public abstract void r(PopupWindow.OnDismissListener onDismissListener);

    public abstract void s(boolean z8);

    public abstract void t(int i9);

    @Override // m.z
    public final void g(Context context, m mVar) {
    }
}
