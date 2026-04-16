package n;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p2 extends x1 {

    /* renamed from: u, reason: collision with root package name */
    public final int f7006u;

    /* renamed from: v, reason: collision with root package name */
    public final int f7007v;

    /* renamed from: w, reason: collision with root package name */
    public l2 f7008w;

    /* renamed from: x, reason: collision with root package name */
    public m.o f7009x;

    public p2(Context context, boolean z8) {
        super(context, z8);
        if (1 == o2.a(context.getResources().getConfiguration())) {
            this.f7006u = 21;
            this.f7007v = 22;
        } else {
            this.f7006u = 22;
            this.f7007v = 21;
        }
    }

    @Override // n.x1, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        m.j jVar;
        int i9;
        int pointToPosition;
        int i10;
        if (this.f7008w != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i9 = headerViewListAdapter.getHeadersCount();
                jVar = (m.j) headerViewListAdapter.getWrappedAdapter();
            } else {
                jVar = (m.j) adapter;
                i9 = 0;
            }
            m.o item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i10 = pointToPosition - i9) < 0 || i10 >= jVar.getCount()) ? null : jVar.getItem(i10);
            m.o oVar = this.f7009x;
            if (oVar != item) {
                m.m mVar = jVar.f6428i;
                if (oVar != null) {
                    this.f7008w.q(mVar, oVar);
                }
                this.f7009x = item;
                if (item != null) {
                    this.f7008w.f(mVar, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i9, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i9 == this.f7006u) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i9 != this.f7007v) {
            return super.onKeyDown(i9, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (m.j) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (m.j) adapter).f6428i.c(false);
        return true;
    }

    public void setHoverListener(l2 l2Var) {
        this.f7008w = l2Var;
    }

    @Override // n.x1, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
