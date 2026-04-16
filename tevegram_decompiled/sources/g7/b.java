package g7;

import a8.p;
import android.util.Log;
import h7.k0;
import i8.u;
import java.io.OutputStream;
import n7.g;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import r7.i;
import t7.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends h implements p {

    /* renamed from: m, reason: collision with root package name */
    public int f3808m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ e f3809n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ OutputStream f3810o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f3811p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ long f3812q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ long f3813r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, OutputStream outputStream, String str, long j5, long j9, r7.c cVar) {
        super(2, cVar);
        this.f3809n = eVar;
        this.f3810o = outputStream;
        this.f3811p = str;
        this.f3812q = j5;
        this.f3813r = j9;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((b) j((u) obj, (r7.c) obj2)).k(g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new b(this.f3809n, this.f3810o, this.f3811p, this.f3812q, this.f3813r, cVar);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        int i9 = this.f3808m;
        long j5 = this.f3813r;
        long j9 = this.f3812q;
        e eVar = this.f3809n;
        if (i9 == 0) {
            com.bumptech.glide.c.V(obj);
            this.f3808m = 1;
            i iVar = new i(com.bumptech.glide.c.C(this));
            k0 k0Var = eVar.f3832b;
            a aVar = new a(iVar);
            Client client = k0Var.f4141l;
            if (client != null) {
                client.send(new TdApi.GetMessage(j9, j5), new a3.i(aVar, 7));
            } else {
                aVar.a(null);
            }
            obj = iVar.a();
            s7.a aVar2 = s7.a.f8891i;
            if (obj == aVar2) {
                return aVar2;
            }
        } else {
            if (i9 != 1) {
                m7.c.p("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            com.bumptech.glide.c.V(obj);
        }
        Integer num = (Integer) obj;
        OutputStream outputStream = this.f3810o;
        if (num != null) {
            eVar.g(outputStream, num.intValue(), this.f3811p);
        } else {
            String str = eVar.f3835e;
            StringBuilder c9 = t.a.c("❌ No se pudo resolver el file_id para chat=", j9, " msg=");
            c9.append(j5);
            Log.w(str, c9.toString());
            e.c(outputStream);
        }
        return g.f7490c;
    }
}
