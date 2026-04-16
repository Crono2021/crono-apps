package androidx.fragment.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d0 extends com.bumptech.glide.d {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f715f;

    public /* synthetic */ d0(int i9) {
        this.f715f = i9;
    }

    @Override // com.bumptech.glide.d
    public d.a H(g.l lVar, Object obj) {
        switch (this.f715f) {
            case 1:
                String[] strArr = (String[]) obj;
                strArr.getClass();
                if (strArr.length == 0) {
                    return new d.a(o7.q.f8014i);
                }
                for (String str : strArr) {
                    if (a.a.g(lVar, str) != 0) {
                        return null;
                    }
                }
                int b02 = o7.t.b0(strArr.length);
                if (b02 < 16) {
                    b02 = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(b02);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new d.a(linkedHashMap);
            default:
                return super.H(lVar, obj);
        }
    }

    @Override // com.bumptech.glide.d
    public final Object Q(int i9, Intent intent) {
        switch (this.f715f) {
            case 0:
                return new androidx.activity.result.a(i9, intent);
            case 1:
                if (i9 == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i10 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i10 == 0));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArrayExtra) {
                            if (str != null) {
                                arrayList2.add(str);
                            }
                        }
                        Iterator it = arrayList2.iterator();
                        Iterator it2 = arrayList.iterator();
                        ArrayList arrayList3 = new ArrayList(Math.min(o7.j.E0(arrayList2), o7.j.E0(arrayList)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList3.add(new n7.b(it.next(), it2.next()));
                        }
                        return o7.t.c0(arrayList3);
                    }
                }
                return o7.q.f8014i;
            default:
                return new androidx.activity.result.a(i9, intent);
        }
    }

    @Override // com.bumptech.glide.d
    public final Intent m(g.l lVar, Object obj) {
        Bundle bundleExtra;
        switch (this.f715f) {
            case 0:
                androidx.activity.result.h hVar = (androidx.activity.result.h) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = hVar.f342j;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        hVar = new androidx.activity.result.h(hVar.f341i, null, hVar.f343k, hVar.f344l);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", hVar);
                if (h0.D(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                String[] strArr = (String[]) obj;
                strArr.getClass();
                Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                putExtra.getClass();
                return putExtra;
            default:
                Intent intent3 = (Intent) obj;
                intent3.getClass();
                return intent3;
        }
    }
}
