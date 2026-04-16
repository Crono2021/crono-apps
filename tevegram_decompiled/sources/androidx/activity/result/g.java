package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.n;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f334a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f335b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f336c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f337d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient HashMap f338e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f339f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f340g = new Bundle();

    public final boolean a(int i9, int i10, Intent intent) {
        String str = (String) this.f334a.get(Integer.valueOf(i9));
        if (str == null) {
            return false;
        }
        e eVar = (e) this.f338e.get(str);
        if (eVar != null) {
            b bVar = eVar.f330a;
            if (this.f337d.contains(str)) {
                bVar.b(eVar.f331b.Q(i10, intent));
                this.f337d.remove(str);
                return true;
            }
        }
        this.f339f.remove(str);
        this.f340g.putParcelable(str, new a(i10, intent));
        return true;
    }

    public abstract void b(int i9, com.bumptech.glide.d dVar, Object obj);

    public final c c(final String str, n nVar, final com.bumptech.glide.d dVar, final b bVar) {
        u uVar = nVar.f300l;
        if (uVar.f943d.compareTo(m.f931l) >= 0) {
            StringBuilder sb = new StringBuilder("LifecycleOwner ");
            sb.append(nVar);
            m mVar = uVar.f943d;
            sb.append(" is attempting to register while current state is ");
            sb.append(mVar);
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString());
        }
        e(str);
        HashMap hashMap = this.f336c;
        f fVar = (f) hashMap.get(str);
        if (fVar == null) {
            fVar = new f(uVar);
        }
        q qVar = new q() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.q
            public final void a(s sVar, l lVar) {
                boolean equals = l.ON_START.equals(lVar);
                String str2 = str;
                g gVar = g.this;
                if (!equals) {
                    if (l.ON_STOP.equals(lVar)) {
                        gVar.f338e.remove(str2);
                        return;
                    } else {
                        if (l.ON_DESTROY.equals(lVar)) {
                            gVar.f(str2);
                            return;
                        }
                        return;
                    }
                }
                HashMap hashMap2 = gVar.f338e;
                Bundle bundle = gVar.f340g;
                HashMap hashMap3 = gVar.f339f;
                b bVar2 = bVar;
                com.bumptech.glide.d dVar2 = dVar;
                hashMap2.put(str2, new e(bVar2, dVar2));
                if (hashMap3.containsKey(str2)) {
                    Object obj = hashMap3.get(str2);
                    hashMap3.remove(str2);
                    bVar2.b(obj);
                }
                a aVar = (a) bundle.getParcelable(str2);
                if (aVar != null) {
                    bundle.remove(str2);
                    bVar2.b(dVar2.Q(aVar.f323i, aVar.f324j));
                }
            }
        };
        fVar.f332a.a(qVar);
        fVar.f333b.add(qVar);
        hashMap.put(str, fVar);
        return new c(this, str, dVar);
    }

    public final d d(String str, com.bumptech.glide.d dVar, b bVar) {
        e(str);
        this.f338e.put(str, new e(bVar, dVar));
        HashMap hashMap = this.f339f;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            bVar.b(obj);
        }
        Bundle bundle = this.f340g;
        a aVar = (a) bundle.getParcelable(str);
        if (aVar != null) {
            bundle.remove(str);
            bVar.b(dVar.Q(aVar.f323i, aVar.f324j));
        }
        return new d(this, str, dVar);
    }

    public final void e(String str) {
        HashMap hashMap = this.f335b;
        if (((Integer) hashMap.get(str)) != null) {
            return;
        }
        int e9 = c8.e.f1727i.e(2147418112);
        while (true) {
            int i9 = e9 + 65536;
            Integer valueOf = Integer.valueOf(i9);
            HashMap hashMap2 = this.f334a;
            if (!hashMap2.containsKey(valueOf)) {
                hashMap2.put(Integer.valueOf(i9), str);
                hashMap.put(str, Integer.valueOf(i9));
                return;
            }
            e9 = c8.e.f1727i.e(2147418112);
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f337d.contains(str) && (num = (Integer) this.f335b.remove(str)) != null) {
            this.f334a.remove(num);
        }
        this.f338e.remove(str);
        HashMap hashMap = this.f339f;
        if (hashMap.containsKey(str)) {
            StringBuilder r8 = androidx.activity.g.r("Dropping pending result for request ", str, ": ");
            r8.append(hashMap.get(str));
            Log.w("ActivityResultRegistry", r8.toString());
            hashMap.remove(str);
        }
        Bundle bundle = this.f340g;
        if (bundle.containsKey(str)) {
            StringBuilder r9 = androidx.activity.g.r("Dropping pending result for request ", str, ": ");
            r9.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", r9.toString());
            bundle.remove(str);
        }
        HashMap hashMap2 = this.f336c;
        f fVar = (f) hashMap2.get(str);
        if (fVar != null) {
            ArrayList arrayList = fVar.f333b;
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                fVar.f332a.f((q) obj);
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }
}
