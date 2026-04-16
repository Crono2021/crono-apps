package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashMap;
import w.a;
import w.d;
import y.b;
import y.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class Barrier extends b {

    /* renamed from: o, reason: collision with root package name */
    public int f531o;

    /* renamed from: p, reason: collision with root package name */
    public int f532p;

    /* renamed from: q, reason: collision with root package name */
    public a f533q;

    public Barrier(Context context) {
        super(context);
        this.f10224i = new int[32];
        this.f10229n = new HashMap();
        this.f10226k = context;
        e(null);
        super.setVisibility(8);
    }

    @Override // y.b
    public final void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        a aVar = new a();
        aVar.f9589f0 = 0;
        aVar.f9590g0 = true;
        aVar.f9591h0 = 0;
        this.f533q = aVar;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f10338b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = obtainStyledAttributes.getIndex(i9);
                if (index == 15) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 14) {
                    this.f533q.f9590g0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 16) {
                    this.f533q.f9591h0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
        }
        this.f10227l = this.f533q;
        g();
    }

    @Override // y.b
    public final void f(d dVar, boolean z8) {
        int i9 = this.f531o;
        this.f532p = i9;
        if (z8) {
            if (i9 == 5) {
                this.f532p = 1;
            } else if (i9 == 6) {
                this.f532p = 0;
            }
        } else if (i9 == 5) {
            this.f532p = 0;
        } else if (i9 == 6) {
            this.f532p = 1;
        }
        if (dVar instanceof a) {
            ((a) dVar).f9589f0 = this.f532p;
        }
    }

    public int getMargin() {
        return this.f533q.f9591h0;
    }

    public int getType() {
        return this.f531o;
    }

    public void setAllowsGoneWidget(boolean z8) {
        this.f533q.f9590g0 = z8;
    }

    public void setDpMargin(int i9) {
        this.f533q.f9591h0 = (int) ((i9 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i9) {
        this.f533q.f9591h0 = i9;
    }

    public void setType(int i9) {
        this.f531o = i9;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
