package s0;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.activity.g;
import n.h2;
import n.i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b extends BaseAdapter implements Filterable {

    /* renamed from: i, reason: collision with root package name */
    public boolean f8659i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8660j;

    /* renamed from: k, reason: collision with root package name */
    public Cursor f8661k;

    /* renamed from: l, reason: collision with root package name */
    public int f8662l;

    /* renamed from: m, reason: collision with root package name */
    public a f8663m;

    /* renamed from: n, reason: collision with root package name */
    public h2 f8664n;

    /* renamed from: o, reason: collision with root package name */
    public c f8665o;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f8661k;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.f8663m;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                h2 h2Var = this.f8664n;
                if (h2Var != null) {
                    cursor2.unregisterDataSetObserver(h2Var);
                }
            }
            this.f8661k = cursor;
            if (cursor != null) {
                a aVar2 = this.f8663m;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                h2 h2Var2 = this.f8664n;
                if (h2Var2 != null) {
                    cursor.registerDataSetObserver(h2Var2);
                }
                this.f8662l = cursor.getColumnIndexOrThrow("_id");
                this.f8659i = true;
                notifyDataSetChanged();
            } else {
                this.f8662l = -1;
                this.f8659i = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f8659i || (cursor = this.f8661k) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i9, View view, ViewGroup viewGroup) {
        if (!this.f8659i) {
            return null;
        }
        this.f8661k.moveToPosition(i9);
        if (view == null) {
            i3 i3Var = (i3) this;
            view = i3Var.f6895r.inflate(i3Var.f6894q, viewGroup, false);
        }
        a(view, this.f8661k);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f8665o == null) {
            c cVar = new c();
            cVar.f8666a = this;
            this.f8665o = cVar;
        }
        return this.f8665o;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i9) {
        Cursor cursor;
        if (!this.f8659i || (cursor = this.f8661k) == null) {
            return null;
        }
        cursor.moveToPosition(i9);
        return this.f8661k;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        Cursor cursor;
        if (this.f8659i && (cursor = this.f8661k) != null && cursor.moveToPosition(i9)) {
            return this.f8661k.getLong(this.f8662l);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i9, View view, ViewGroup viewGroup) {
        if (!this.f8659i) {
            m7.c.p("this should only be called when the cursor is valid");
            return null;
        }
        if (!this.f8661k.moveToPosition(i9)) {
            m7.c.p(g.m(i9, "couldn't move cursor to position "));
            return null;
        }
        if (view == null) {
            view = d(viewGroup);
        }
        a(view, this.f8661k);
        return view;
    }
}
