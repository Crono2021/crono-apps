package com.network.tvgramplayer.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.d;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b8.i;
import c7.a;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.datepicker.n;
import g.l;
import m7.c;
import n7.e;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class DiscoveryActivity extends l {
    public static final /* synthetic */ int J = 0;
    public a E;
    public i7.l G;
    public a0.l H;
    public final e F = new e(new d(this, 2));
    public int I = 24;

    @Override // g.l, androidx.activity.n, c0.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(2131558428, (ViewGroup) null, false);
        int i9 = 2131361949;
        if (((Chip) com.bumptech.glide.d.z(inflate, 2131361949)) != null) {
            i9 = 2131361950;
            if (((Chip) com.bumptech.glide.d.z(inflate, 2131361950)) != null) {
                i9 = 2131361951;
                if (((Chip) com.bumptech.glide.d.z(inflate, 2131361951)) != null) {
                    i9 = 2131361952;
                    if (((Chip) com.bumptech.glide.d.z(inflate, 2131361952)) != null) {
                        i9 = 2131361958;
                        ChipGroup chipGroup = (ChipGroup) com.bumptech.glide.d.z(inflate, 2131361958);
                        if (chipGroup != null) {
                            i9 = 2131362292;
                            ProgressBar progressBar = (ProgressBar) com.bumptech.glide.d.z(inflate, 2131362292);
                            if (progressBar != null) {
                                i9 = 2131362312;
                                RecyclerView recyclerView = (RecyclerView) com.bumptech.glide.d.z(inflate, 2131362312);
                                if (recyclerView != null) {
                                    i9 = 2131362481;
                                    MaterialToolbar materialToolbar = (MaterialToolbar) com.bumptech.glide.d.z(inflate, 2131362481);
                                    if (materialToolbar != null) {
                                        i9 = 2131362499;
                                        TextView textView = (TextView) com.bumptech.glide.d.z(inflate, 2131362499);
                                        if (textView != null) {
                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                                            this.E = new a(coordinatorLayout, chipGroup, progressBar, recyclerView, materialToolbar, textView);
                                            setContentView(coordinatorLayout);
                                            this.H = new a0.l((l) this);
                                            a aVar = this.E;
                                            if (aVar == null) {
                                                i.d("binding");
                                                throw null;
                                            }
                                            ((MaterialToolbar) aVar.f1645m).setNavigationOnClickListener(new n(this, 1));
                                            this.G = new i7.l(this, new i7.i(this, 1));
                                            a aVar2 = this.E;
                                            if (aVar2 == null) {
                                                i.d("binding");
                                                throw null;
                                            }
                                            ((RecyclerView) aVar2.f1644l).setLayoutManager(new GridLayoutManager(3));
                                            a aVar3 = this.E;
                                            if (aVar3 == null) {
                                                i.d("binding");
                                                throw null;
                                            }
                                            RecyclerView recyclerView2 = (RecyclerView) aVar3.f1644l;
                                            i7.l lVar = this.G;
                                            if (lVar == null) {
                                                i.d("adapter");
                                                throw null;
                                            }
                                            recyclerView2.setAdapter(lVar);
                                            a aVar4 = this.E;
                                            if (aVar4 == null) {
                                                i.d("binding");
                                                throw null;
                                            }
                                            ((ChipGroup) aVar4.f1642j).setOnCheckedChangeListener(new a3.i(this, 8));
                                            s();
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        c.o("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i9)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.network.tvgramplayer.ui.DiscoveryActivity.s():void");
    }
}
