package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
@Deprecated
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class ReflectiveGenericLifecycleObserver implements q {

    /* renamed from: i, reason: collision with root package name */
    public final r f891i;

    /* renamed from: j, reason: collision with root package name */
    public final a f892j;

    public ReflectiveGenericLifecycleObserver(r rVar) {
        this.f891i = rVar;
        c cVar = c.f899c;
        Class<?> cls = rVar.getClass();
        a aVar = (a) cVar.f900a.get(cls);
        this.f892j = aVar == null ? cVar.a(cls, null) : aVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, l lVar) {
        HashMap hashMap = this.f892j.f895a;
        List list = (List) hashMap.get(lVar);
        r rVar = this.f891i;
        a.a(list, sVar, lVar, rVar);
        a.a((List) hashMap.get(l.ON_ANY), sVar, lVar, rVar);
    }
}
