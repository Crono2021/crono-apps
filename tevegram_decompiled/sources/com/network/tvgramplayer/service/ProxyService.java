package com.network.tvgramplayer.service;

import a5.a;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.activity.g;
import c0.i;
import c0.j;
import c0.k;
import c0.l;
import c0.m;
import c0.n;
import c0.o;
import c0.p;
import c0.q;
import g7.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class ProxyService extends Service {

    /* renamed from: i, reason: collision with root package name */
    public static e f2331i;

    public final void a() {
        Bundle bundle;
        Notification a9;
        Object systemService;
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 26) {
            a.p();
            NotificationChannel c9 = a.c();
            c9.setDescription("Mantiene el reproductor externo enviando datos sin interrupciones.");
            systemService = getSystemService(NotificationManager.class);
            ((NotificationManager) systemService).createNotificationChannel(c9);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Notification notification = new Notification();
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        ArrayList arrayList4 = new ArrayList();
        CharSequence subSequence = "TVgram Proxy Activo".length() > 5120 ? "TVgram Proxy Activo".subSequence(0, 5120) : "TVgram Proxy Activo";
        CharSequence subSequence2 = "Enviando video al reproductor externo...".length() > 5120 ? "Enviando video al reproductor externo...".subSequence(0, 5120) : "Enviando video al reproductor externo...";
        notification.icon = 2131755008;
        notification.flags |= 2;
        new ArrayList();
        Bundle bundle2 = new Bundle();
        Notification.Builder a10 = i9 >= 26 ? p.a(this, "ProxyServiceChannel") : new Notification.Builder(this);
        a10.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(subSequence).setContentText(subSequence2).setContentInfo(null).setContentIntent(null).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        if (i9 < 23) {
            a10.setLargeIcon((Bitmap) null);
        } else {
            n.b(a10, null);
        }
        i.b(i.d(i.c(a10, null), false), -1);
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw g.l(it);
        }
        j.a(a10, true);
        l.i(a10, false);
        l.g(a10, null);
        l.j(a10, null);
        l.h(a10, false);
        m.b(a10, null);
        m.c(a10, 0);
        m.f(a10, 0);
        m.d(a10, null);
        m.e(a10, notification.sound, notification.audioAttributes);
        if (i9 < 28) {
            ArrayList arrayList5 = new ArrayList(arrayList2.size());
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                throw g.l(it2);
            }
            s.e eVar = new s.e(arrayList4.size() + arrayList5.size());
            eVar.addAll(arrayList5);
            eVar.addAll(arrayList4);
            arrayList4 = new ArrayList(eVar);
        }
        if (!arrayList4.isEmpty()) {
            int size = arrayList4.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList4.get(i10);
                i10++;
                m.a(a10, (String) obj);
            }
        }
        if (arrayList3.size() > 0) {
            bundle = new Bundle();
            Bundle bundle3 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle3 == null) {
                bundle3 = new Bundle();
            }
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            if (arrayList3.size() > 0) {
                Integer.toString(0);
                if (arrayList3.get(0) != null) {
                    androidx.fragment.app.a.c();
                    return;
                } else {
                    new Bundle();
                    throw null;
                }
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            bundle.putBundle("android.car.EXTENSIONS", bundle3);
            bundle2.putBundle("android.car.EXTENSIONS", bundle4);
        } else {
            bundle = null;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            k.a(a10, bundle);
            o.e(a10, null);
        }
        if (i11 >= 26) {
            p.b(a10, 0);
            p.e(a10, null);
            p.f(a10, null);
            p.g(a10, 0L);
            p.d(a10, 0);
            if (!TextUtils.isEmpty("ProxyServiceChannel")) {
                a10.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i11 >= 28) {
            Iterator it3 = arrayList2.iterator();
            if (it3.hasNext()) {
                throw g.l(it3);
            }
        }
        if (i11 >= 29) {
            q.a(a10, true);
            q.b(a10, null);
        }
        if (i11 >= 26) {
            a9 = i.a(a10);
        } else if (i11 >= 24) {
            a9 = i.a(a10);
        } else {
            k.a(a10, bundle2);
            a9 = i.a(a10);
        }
        a9.getClass();
        startForeground(1001, a9);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
        new Thread(new a7.a(this, 10)).start();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        e eVar = f2331i;
        if (eVar != null) {
            eVar.i();
        }
        f2331i = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i9, int i10) {
        a();
        return 1;
    }
}
