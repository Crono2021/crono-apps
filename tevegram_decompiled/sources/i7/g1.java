package i7;

import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g1 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4867m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4868n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(MainActivity mainActivity, r7.c cVar, int i9) {
        super(2, cVar);
        this.f4867m = i9;
        this.f4868n = mainActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f4867m) {
            case 0:
                g1 g1Var = (g1) j(uVar, cVar);
                n7.g gVar = n7.g.f7490c;
                g1Var.k(gVar);
                return gVar;
            default:
                g1 g1Var2 = (g1) j(uVar, cVar);
                n7.g gVar2 = n7.g.f7490c;
                g1Var2.k(gVar2);
                return gVar2;
        }
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f4867m) {
            case 0:
                return new g1(this.f4868n, cVar, 0);
            default:
                return new g1(this.f4868n, cVar, 1);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        switch (this.f4867m) {
            case 0:
                com.bumptech.glide.c.V(obj);
                this.f4868n.s("> Internet Check: PASSED ✅");
                break;
            default:
                com.bumptech.glide.c.V(obj);
                MainActivity mainActivity = this.f4868n;
                mainActivity.s("> Internet Check: FAILED ❌");
                mainActivity.s("> SYSTEM FIREWALL BLOCK DETECTED!");
                new g.j(mainActivity).setTitle("Internet Bloqueado").c("El sistema (Xiaomi/Android) ha bloqueado el acceso a Internet de esta app.\n\nEsto es común al instalar por USB.\n\n1. Pulsa 'Ir a Ajustes'.\n2. Busca 'Restringir uso de datos'.\n3. Activa WiFi y Datos.\n4. Cierra y abre la app.").g("Ir a Ajustes", new o0(mainActivity, 4)).a().h();
                break;
        }
        return n7.g.f7490c;
    }
}
