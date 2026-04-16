package o3;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7596i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7597j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i f7598k;

    public /* synthetic */ c(i iVar, ArrayList arrayList, int i9) {
        this.f7596i = i9;
        this.f7598k = iVar;
        this.f7597j = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7596i) {
            case 0:
                ArrayList arrayList = this.f7597j;
                int size = arrayList.size();
                int i9 = 0;
                while (true) {
                    i iVar = this.f7598k;
                    if (i9 >= size) {
                        arrayList.clear();
                        iVar.f7682m.remove(arrayList);
                        break;
                    } else {
                        Object obj = arrayList.get(i9);
                        i9++;
                        h hVar = (h) obj;
                        d1 d1Var = hVar.f7664a;
                        int i10 = hVar.f7665b;
                        int i11 = hVar.f7666c;
                        int i12 = hVar.f7667d;
                        int i13 = hVar.f7668e;
                        iVar.getClass();
                        View view = d1Var.f7618a;
                        int i14 = i12 - i10;
                        int i15 = i13 - i11;
                        if (i14 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i15 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator animate = view.animate();
                        iVar.f7685p.add(d1Var);
                        animate.setDuration(iVar.f7707e).setListener(new e(iVar, d1Var, i14, view, i15, animate)).start();
                    }
                }
            case 1:
                ArrayList arrayList2 = this.f7597j;
                int size2 = arrayList2.size();
                int i16 = 0;
                while (true) {
                    i iVar2 = this.f7598k;
                    if (i16 >= size2) {
                        arrayList2.clear();
                        iVar2.f7683n.remove(arrayList2);
                        break;
                    } else {
                        Object obj2 = arrayList2.get(i16);
                        i16++;
                        g gVar = (g) obj2;
                        ArrayList arrayList3 = iVar2.f7687r;
                        long j5 = iVar2.f7708f;
                        d1 d1Var2 = gVar.f7653a;
                        View view2 = d1Var2 == null ? null : d1Var2.f7618a;
                        d1 d1Var3 = gVar.f7654b;
                        View view3 = d1Var3 != null ? d1Var3.f7618a : null;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j5);
                            arrayList3.add(gVar.f7653a);
                            duration.translationX(gVar.f7657e - gVar.f7655c);
                            duration.translationY(gVar.f7658f - gVar.f7656d);
                            duration.alpha(0.0f).setListener(new f(iVar2, gVar, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator animate2 = view3.animate();
                            arrayList3.add(gVar.f7654b);
                            animate2.translationX(0.0f).translationY(0.0f).setDuration(j5).alpha(1.0f).setListener(new f(iVar2, gVar, animate2, view3, 1)).start();
                        }
                    }
                }
            default:
                ArrayList arrayList4 = this.f7597j;
                int size3 = arrayList4.size();
                int i17 = 0;
                while (true) {
                    i iVar3 = this.f7598k;
                    if (i17 >= size3) {
                        arrayList4.clear();
                        iVar3.f7681l.remove(arrayList4);
                        break;
                    } else {
                        Object obj3 = arrayList4.get(i17);
                        i17++;
                        d1 d1Var4 = (d1) obj3;
                        iVar3.getClass();
                        View view4 = d1Var4.f7618a;
                        ViewPropertyAnimator animate3 = view4.animate();
                        iVar3.f7684o.add(d1Var4);
                        animate3.alpha(1.0f).setDuration(iVar3.f7705c).setListener(new d(iVar3, d1Var4, view4, animate3)).start();
                    }
                }
        }
    }
}
