package m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends BaseAdapter {

    /* renamed from: i, reason: collision with root package name */
    public final m f6428i;

    /* renamed from: j, reason: collision with root package name */
    public int f6429j = -1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6430k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6431l;

    /* renamed from: m, reason: collision with root package name */
    public final LayoutInflater f6432m;

    /* renamed from: n, reason: collision with root package name */
    public final int f6433n;

    public j(m mVar, LayoutInflater layoutInflater, boolean z8, int i9) {
        this.f6431l = z8;
        this.f6432m = layoutInflater;
        this.f6428i = mVar;
        this.f6433n = i9;
        a();
    }

    public final void a() {
        m mVar = this.f6428i;
        o oVar = mVar.D;
        if (oVar != null) {
            mVar.i();
            ArrayList arrayList = mVar.f6443r;
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                if (((o) arrayList.get(i9)) == oVar) {
                    this.f6429j = i9;
                    return;
                }
            }
        }
        this.f6429j = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final o getItem(int i9) {
        ArrayList l4;
        boolean z8 = this.f6431l;
        m mVar = this.f6428i;
        if (z8) {
            mVar.i();
            l4 = mVar.f6443r;
        } else {
            l4 = mVar.l();
        }
        int i10 = this.f6429j;
        if (i10 >= 0 && i9 >= i10) {
            i9++;
        }
        return (o) l4.get(i9);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList l4;
        boolean z8 = this.f6431l;
        m mVar = this.f6428i;
        if (z8) {
            mVar.i();
            l4 = mVar.f6443r;
        } else {
            l4 = mVar.l();
        }
        return this.f6429j < 0 ? l4.size() : l4.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        return i9;
    }

    @Override // android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        boolean z8 = false;
        if (view == null) {
            view = this.f6432m.inflate(this.f6433n, viewGroup, false);
        }
        int i10 = getItem(i9).f6456j;
        int i11 = i9 - 1;
        int i12 = i11 >= 0 ? getItem(i11).f6456j : i10;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f6428i.m() && i10 != i12) {
            z8 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z8);
        a0 a0Var = (a0) view;
        if (this.f6430k) {
            listMenuItemView.setForceShowIcon(true);
        }
        a0Var.a(getItem(i9));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
