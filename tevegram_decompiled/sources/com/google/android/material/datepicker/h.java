package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import o3.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends LinearLayoutManager {
    public final /* synthetic */ int E;
    public final /* synthetic */ m F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(m mVar, int i9, int i10) {
        super(i9);
        this.F = mVar;
        this.E = i10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final void w0(RecyclerView recyclerView, int i9) {
        w wVar = new w(recyclerView.getContext());
        wVar.f7853a = i9;
        x0(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void z0(z0 z0Var, int[] iArr) {
        m mVar = this.F;
        RecyclerView recyclerView = mVar.f2039g0;
        if (this.E == 0) {
            iArr[0] = recyclerView.getWidth();
            iArr[1] = mVar.f2039g0.getWidth();
        } else {
            iArr[0] = recyclerView.getHeight();
            iArr[1] = mVar.f2039g0.getHeight();
        }
    }
}
