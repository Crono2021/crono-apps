package m;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends BaseAdapter {

    /* renamed from: i, reason: collision with root package name */
    public int f6420i = -1;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i f6421j;

    public h(i iVar) {
        this.f6421j = iVar;
        a();
    }

    public final void a() {
        m mVar = this.f6421j.f6424k;
        o oVar = mVar.D;
        if (oVar != null) {
            mVar.i();
            ArrayList arrayList = mVar.f6443r;
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                if (((o) arrayList.get(i9)) == oVar) {
                    this.f6420i = i9;
                    return;
                }
            }
        }
        this.f6420i = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final o getItem(int i9) {
        i iVar = this.f6421j;
        m mVar = iVar.f6424k;
        mVar.i();
        ArrayList arrayList = mVar.f6443r;
        iVar.getClass();
        int i10 = this.f6420i;
        if (i10 >= 0 && i9 >= i10) {
            i9++;
        }
        return (o) arrayList.get(i9);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        i iVar = this.f6421j;
        m mVar = iVar.f6424k;
        mVar.i();
        int size = mVar.f6443r.size();
        iVar.getClass();
        return this.f6420i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        return i9;
    }

    @Override // android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6421j.f6423j.inflate(2131558416, viewGroup, false);
        }
        ((a0) view).a(getItem(i9));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
