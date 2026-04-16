package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import g1.w;
import java.util.concurrent.Executor;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1844a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1845b;

    public /* synthetic */ p(Object obj, int i9) {
        this.f1844a = i9;
        this.f1845b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Executor mainExecutor;
        switch (this.f1844a) {
            case 0:
                r.f1848g.execute(new q((r) this.f1845b, 2));
                break;
            case 1:
                ((androidx.fragment.app.i) this.f1845b).m();
                break;
            case 2:
                g1.o oVar = (g1.o) this.f1845b;
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                int i9 = 0;
                if (connectivityManager != null) {
                    try {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            int type = activeNetworkInfo.getType();
                            if (type != 0) {
                                if (type != 1) {
                                    if (type != 4 && type != 5) {
                                        if (type != 6) {
                                            i9 = type != 9 ? 8 : 7;
                                        }
                                        i9 = 5;
                                    }
                                }
                                i9 = 2;
                            }
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                    i9 = 3;
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 14:
                                case 15:
                                case 17:
                                    i9 = 4;
                                    break;
                                case 13:
                                    i9 = 5;
                                    break;
                                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                                case 19:
                                default:
                                    i9 = 6;
                                    break;
                                case 18:
                                    i9 = 2;
                                    break;
                                case 20:
                                    if (w.f3713a >= 29) {
                                        i9 = 9;
                                        break;
                                    }
                                    break;
                            }
                        } else {
                            i9 = 1;
                        }
                    } catch (SecurityException unused) {
                    }
                }
                if (w.f3713a < 31 || i9 != 5) {
                    g1.o.a(i9, oVar);
                    break;
                } else {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        telephonyManager.getClass();
                        g1.n nVar = new g1.n(oVar);
                        mainExecutor = context.getMainExecutor();
                        telephonyManager.registerTelephonyCallback(mainExecutor, nVar);
                        telephonyManager.unregisterTelephonyCallback(nVar);
                        break;
                    } catch (RuntimeException unused2) {
                        g1.o.a(5, oVar);
                        return;
                    }
                }
                break;
            default:
                if (!isInitialStickyBroadcast()) {
                    n1.j jVar = (n1.j) this.f1845b;
                    jVar.a(n1.e.b(context, intent, jVar.f7279i, jVar.h));
                    break;
                }
                break;
        }
    }
}
