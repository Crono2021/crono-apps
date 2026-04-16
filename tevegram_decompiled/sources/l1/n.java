package l1;

import android.content.Context;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class n implements a6.h {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5963i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Context f5964j;

    public /* synthetic */ n(Context context, int i9) {
        this.f5963i = i9;
        this.f5964j = context;
    }

    @Override // a6.h
    public final Object get() {
        z1.f fVar;
        switch (this.f5963i) {
            case 0:
                Context context = this.f5964j;
                return new v1.n(new a5.d(context, new i1.m()), new d2.k());
            case 1:
                return new y1.o(this.f5964j);
            default:
                Context context2 = this.f5964j;
                b6.w0 w0Var = z1.f.f10549n;
                synchronized (z1.f.class) {
                    try {
                        if (z1.f.f10555t == null) {
                            s1.c cVar = new s1.c(context2);
                            z1.f.f10555t = new z1.f((Context) cVar.f8673k, (HashMap) cVar.f8674l, cVar.f8671i, (g1.r) cVar.f8675m, cVar.f8672j);
                        }
                        fVar = z1.f.f10555t;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return fVar;
        }
    }
}
