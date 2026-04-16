package androidx.fragment.app;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f839i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ s0 f840j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ k f841k;

    public /* synthetic */ r0(k kVar, s0 s0Var, int i9) {
        this.f839i = i9;
        this.f841k = kVar;
        this.f840j = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f839i) {
            case 0:
                ArrayList arrayList = this.f841k.f777b;
                s0 s0Var = this.f840j;
                if (arrayList.contains(s0Var)) {
                    androidx.activity.g.a(s0Var.f862c.M, s0Var.f860a);
                    break;
                }
                break;
            default:
                k kVar = this.f841k;
                ArrayList arrayList2 = kVar.f777b;
                s0 s0Var2 = this.f840j;
                arrayList2.remove(s0Var2);
                kVar.f778c.remove(s0Var2);
                break;
        }
    }
}
