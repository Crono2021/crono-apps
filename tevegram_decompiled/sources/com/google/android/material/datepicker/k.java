package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.text.format.DateUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import o3.o0;
import o3.r0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f2028a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialButton f2029b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f2030c;

    public k(m mVar, u uVar, MaterialButton materialButton) {
        this.f2030c = mVar;
        this.f2028a = uVar;
        this.f2029b = materialButton;
    }

    @Override // o3.r0
    public final void a(RecyclerView recyclerView, int i9) {
        if (i9 == 0) {
            recyclerView.announceForAccessibility(this.f2029b.getText());
        }
    }

    @Override // o3.r0
    public final void b(RecyclerView recyclerView, int i9, int i10) {
        int J0;
        String formatDateTime;
        DateFormat instanceForSkeleton;
        TimeZone timeZone;
        DisplayContext unused;
        b bVar = this.f2028a.f2077d;
        m mVar = this.f2030c;
        RecyclerView recyclerView2 = mVar.f2039g0;
        if (i9 < 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView2.getLayoutManager();
            View L0 = linearLayoutManager.L0(0, linearLayoutManager.v(), false);
            J0 = L0 == null ? -1 : o0.F(L0);
        } else {
            J0 = ((LinearLayoutManager) recyclerView2.getLayoutManager()).J0();
        }
        Calendar a9 = y.a(bVar.f2008i.f2061i);
        a9.add(2, J0);
        mVar.f2035c0 = new q(a9);
        Calendar a10 = y.a(bVar.f2008i.f2061i);
        a10.add(2, J0);
        a10.set(5, 1);
        Calendar a11 = y.a(a10);
        a11.get(2);
        a11.get(1);
        a11.getMaximum(7);
        a11.getActualMaximum(5);
        a11.getTimeInMillis();
        long timeInMillis = a11.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = Locale.getDefault();
            AtomicReference atomicReference = y.f2081a;
            instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
            timeZone = TimeZone.getTimeZone("UTC");
            instanceForSkeleton.setTimeZone(timeZone);
            unused = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
            instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            formatDateTime = instanceForSkeleton.format(new Date(timeInMillis));
        } else {
            formatDateTime = DateUtils.formatDateTime(null, timeInMillis, 8228);
        }
        this.f2029b.setText(formatDateTime);
    }
}
