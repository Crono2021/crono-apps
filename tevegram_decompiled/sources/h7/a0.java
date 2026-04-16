package h7;

import android.util.Log;
import i7.h2;
import java.util.ArrayList;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a0 implements Client.ResultHandler {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4059i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f4060j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f4061k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f4062l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4063m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f4064n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4065o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ h2 f4066p;

    public /* synthetic */ a0(long j5, k0 k0Var, long j9, long j10, int i9, ArrayList arrayList, h2 h2Var) {
        this.f4061k = j5;
        this.f4060j = k0Var;
        this.f4062l = j9;
        this.f4064n = j10;
        this.f4063m = i9;
        this.f4065o = arrayList;
        this.f4066p = h2Var;
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public final void onResult(TdApi.Object object) {
        switch (this.f4059i) {
            case 0:
                boolean z8 = object instanceof TdApi.Error;
                long j5 = this.f4061k;
                if (z8) {
                    Log.e("TdClient", "❌ GetMessageThreadHistory failed for thread " + j5 + ": " + ((TdApi.Error) object).message);
                }
                object.getClass();
                this.f4060j.m(object, this.f4062l, this.f4064n, this.f4063m, j5, this.f4065o, this.f4066p);
                break;
            default:
                object.getClass();
                this.f4060j.m(object, this.f4061k, this.f4062l, this.f4063m, this.f4064n, this.f4065o, this.f4066p);
                break;
        }
    }

    public /* synthetic */ a0(k0 k0Var, long j5, long j9, int i9, long j10, ArrayList arrayList, h2 h2Var) {
        this.f4060j = k0Var;
        this.f4061k = j5;
        this.f4062l = j9;
        this.f4063m = i9;
        this.f4064n = j10;
        this.f4065o = arrayList;
        this.f4066p = h2Var;
    }
}
