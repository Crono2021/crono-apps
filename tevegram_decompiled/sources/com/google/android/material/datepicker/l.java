package com.google.android.material.datepicker;

import android.os.Message;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.media3.ui.TrackSelectionView;
import b6.g0;
import d1.a1;
import d1.e1;
import d1.z0;
import java.util.ArrayList;
import java.util.HashMap;
import l3.i0;
import n.t3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2031i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f2032j;

    public /* synthetic */ l(Object obj, int i9) {
        this.f2031i = i9;
        this.f2032j = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        switch (this.f2031i) {
            case 0:
                m mVar = (m) this.f2032j;
                int i9 = mVar.f2036d0;
                if (i9 != 2) {
                    if (i9 == 1) {
                        mVar.B(2);
                        break;
                    }
                } else {
                    mVar.B(1);
                    break;
                }
                break;
            case 1:
                g.i iVar = (g.i) this.f2032j;
                Message obtain = (view != iVar.f3546i || (message3 = iVar.f3548k) == null) ? (view != iVar.f3549l || (message2 = iVar.f3551n) == null) ? (view != iVar.f3552o || (message = iVar.f3554q) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
                if (obtain != null) {
                    obtain.sendToTarget();
                }
                iVar.F.obtainMessage(1, iVar.f3540b).sendToTarget();
                break;
            case 2:
                TrackSelectionView trackSelectionView = (TrackSelectionView) this.f2032j;
                HashMap hashMap = trackSelectionView.f1030o;
                boolean z8 = true;
                if (view == trackSelectionView.f1026k) {
                    trackSelectionView.f1035t = true;
                    hashMap.clear();
                } else if (view == trackSelectionView.f1027l) {
                    trackSelectionView.f1035t = false;
                    hashMap.clear();
                } else {
                    trackSelectionView.f1035t = false;
                    Object tag = view.getTag();
                    tag.getClass();
                    i0 i0Var = (i0) tag;
                    e1 e1Var = i0Var.f6158a;
                    z0 z0Var = e1Var.f2415b;
                    int i10 = i0Var.f6159b;
                    a1 a1Var = (a1) hashMap.get(z0Var);
                    if (a1Var == null) {
                        if (!trackSelectionView.f1032q && hashMap.size() > 0) {
                            hashMap.clear();
                        }
                        hashMap.put(z0Var, new a1(z0Var, g0.q(Integer.valueOf(i10))));
                    } else {
                        ArrayList arrayList = new ArrayList(a1Var.f2354b);
                        boolean isChecked = ((CheckedTextView) view).isChecked();
                        boolean z9 = trackSelectionView.f1031p && e1Var.f2416c;
                        if (!z9 && (!trackSelectionView.f1032q || trackSelectionView.f1029n.size() <= 1)) {
                            z8 = false;
                        }
                        if (isChecked && z8) {
                            arrayList.remove(Integer.valueOf(i10));
                            if (arrayList.isEmpty()) {
                                hashMap.remove(z0Var);
                            } else {
                                hashMap.put(z0Var, new a1(z0Var, arrayList));
                            }
                        } else if (!isChecked) {
                            if (z9) {
                                arrayList.add(Integer.valueOf(i10));
                                hashMap.put(z0Var, new a1(z0Var, arrayList));
                            } else {
                                hashMap.put(z0Var, new a1(z0Var, g0.q(Integer.valueOf(i10))));
                            }
                        }
                    }
                }
                trackSelectionView.a();
                break;
            case 3:
                ((l.a) this.f2032j).a();
                break;
            default:
                t3 t3Var = ((Toolbar) this.f2032j).U;
                m.o oVar = t3Var == null ? null : t3Var.f7058j;
                if (oVar != null) {
                    oVar.collapseActionView();
                    break;
                }
                break;
        }
    }
}
