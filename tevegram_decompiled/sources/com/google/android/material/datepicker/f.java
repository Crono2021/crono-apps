package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;
import o3.o0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2022i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u f2023j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ m f2024k;

    public /* synthetic */ f(m mVar, u uVar, int i9) {
        this.f2022i = i9;
        this.f2024k = mVar;
        this.f2023j = uVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2022i) {
            case 0:
                m mVar = this.f2024k;
                int J0 = ((LinearLayoutManager) mVar.f2039g0.getLayoutManager()).J0() - 1;
                if (J0 >= 0) {
                    Calendar a9 = y.a(this.f2023j.f2077d.f2008i.f2061i);
                    a9.add(2, J0);
                    mVar.A(new q(a9));
                    break;
                }
                break;
            default:
                m mVar2 = this.f2024k;
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mVar2.f2039g0.getLayoutManager();
                View L0 = linearLayoutManager.L0(0, linearLayoutManager.v(), false);
                int F = (L0 == null ? -1 : o0.F(L0)) + 1;
                if (F < mVar2.f2039g0.getAdapter().a()) {
                    Calendar a10 = y.a(this.f2023j.f2077d.f2008i.f2061i);
                    a10.add(2, F);
                    mVar2.A(new q(a10));
                    break;
                }
                break;
        }
    }
}
