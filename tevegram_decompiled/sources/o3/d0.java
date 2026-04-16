package o3;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7615i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f7616j;

    public /* synthetic */ d0(RecyclerView recyclerView, int i9) {
        this.f7615i = i9;
        this.f7616j = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z8;
        int i9 = this.f7615i;
        RecyclerView recyclerView = this.f7616j;
        switch (i9) {
            case 0:
                if (recyclerView.C && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.A) {
                        recyclerView.requestLayout();
                        break;
                    } else if (!recyclerView.F) {
                        recyclerView.n();
                        break;
                    } else {
                        recyclerView.E = true;
                        break;
                    }
                }
                break;
            default:
                k0 k0Var = recyclerView.T;
                if (k0Var != null) {
                    i iVar = (i) k0Var;
                    long j5 = iVar.f7706d;
                    ArrayList arrayList = iVar.h;
                    boolean isEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = iVar.f7679j;
                    boolean isEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = iVar.f7680k;
                    boolean isEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = iVar.f7678i;
                    boolean isEmpty4 = arrayList4.isEmpty();
                    if (!isEmpty || !isEmpty2 || !isEmpty4 || !isEmpty3) {
                        int size = arrayList.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj = arrayList.get(i10);
                            int i11 = i10 + 1;
                            d1 d1Var = (d1) obj;
                            View view = d1Var.f7618a;
                            ViewPropertyAnimator animate = view.animate();
                            iVar.f7686q.add(d1Var);
                            animate.setDuration(j5).alpha(0.0f).setListener(new d(iVar, d1Var, animate, view)).start();
                            i10 = i11;
                            arrayList = arrayList;
                            isEmpty = isEmpty;
                        }
                        boolean z9 = isEmpty;
                        arrayList.clear();
                        if (!isEmpty2) {
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.addAll(arrayList2);
                            iVar.f7682m.add(arrayList5);
                            arrayList2.clear();
                            c cVar = new c(iVar, arrayList5, 0);
                            if (z9) {
                                cVar.run();
                            } else {
                                View view2 = ((h) arrayList5.get(0)).f7664a.f7618a;
                                WeakHashMap weakHashMap = n0.t0.f7209a;
                                n0.c0.n(view2, cVar, j5);
                            }
                        }
                        if (!isEmpty3) {
                            ArrayList arrayList6 = new ArrayList();
                            arrayList6.addAll(arrayList3);
                            iVar.f7683n.add(arrayList6);
                            arrayList3.clear();
                            c cVar2 = new c(iVar, arrayList6, 1);
                            if (z9) {
                                cVar2.run();
                            } else {
                                View view3 = ((g) arrayList6.get(0)).f7653a.f7618a;
                                WeakHashMap weakHashMap2 = n0.t0.f7209a;
                                n0.c0.n(view3, cVar2, j5);
                            }
                        }
                        if (!isEmpty4) {
                            ArrayList arrayList7 = new ArrayList();
                            arrayList7.addAll(arrayList4);
                            iVar.f7681l.add(arrayList7);
                            arrayList4.clear();
                            c cVar3 = new c(iVar, arrayList7, 2);
                            if (!z9 || !isEmpty2 || !isEmpty3) {
                                if (z9) {
                                    j5 = 0;
                                }
                                long max = Math.max(!isEmpty2 ? iVar.f7707e : 0L, isEmpty3 ? 0L : iVar.f7708f) + j5;
                                z8 = false;
                                View view4 = ((d1) arrayList7.get(0)).f7618a;
                                WeakHashMap weakHashMap3 = n0.t0.f7209a;
                                n0.c0.n(view4, cVar3, max);
                                recyclerView.f1079u0 = z8;
                                break;
                            } else {
                                cVar3.run();
                            }
                        }
                    }
                }
                z8 = false;
                recyclerView.f1079u0 = z8;
        }
    }
}
