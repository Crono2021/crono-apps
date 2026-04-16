package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends androidx.activity.result.g {
    public final /* synthetic */ g.l h;

    public i(g.l lVar) {
        this.h = lVar;
    }

    @Override // androidx.activity.result.g
    public final void b(int i9, com.bumptech.glide.d dVar, Object obj) {
        Bundle bundle;
        int i10;
        g.l lVar = this.h;
        d.a H = dVar.H(lVar, obj);
        if (H != null) {
            new Handler(Looper.getMainLooper()).post(new h(this, i9, H, 0));
            return;
        }
        Intent m9 = dVar.m(lVar, obj);
        if (m9.getExtras() != null && m9.getExtras().getClassLoader() == null) {
            m9.setExtrasClassLoader(lVar.getClassLoader());
        }
        if (m9.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundle = m9.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            m9.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(m9.getAction())) {
            String[] stringArrayExtra = m9.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < stringArrayExtra.length; i11++) {
                if (TextUtils.isEmpty(stringArrayExtra[i11])) {
                    m7.c.n(g.o(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                    return;
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[i11], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i11));
                }
            }
            int size = hashSet.size();
            String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i12 = 0;
                for (int i13 = 0; i13 < stringArrayExtra.length; i13++) {
                    if (!hashSet.contains(Integer.valueOf(i13))) {
                        strArr[i12] = stringArrayExtra[i13];
                        i12++;
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                c0.b.b(lVar, stringArrayExtra, i9);
                return;
            } else {
                new Handler(Looper.getMainLooper()).post(new h(i9, 2, strArr, lVar));
                return;
            }
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(m9.getAction())) {
            c0.a.b(lVar, m9, i9, bundle2);
            return;
        }
        androidx.activity.result.h hVar = (androidx.activity.result.h) m9.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            i10 = i9;
            try {
                c0.a.c(lVar, hVar.f341i, i10, hVar.f342j, hVar.f343k, hVar.f344l, 0, bundle2);
            } catch (IntentSender.SendIntentException e9) {
                e = e9;
                new Handler(Looper.getMainLooper()).post(new h(this, i10, e, 1));
            }
        } catch (IntentSender.SendIntentException e10) {
            e = e10;
            i10 = i9;
        }
    }
}
