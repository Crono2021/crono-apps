package b6;

import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t extends m {

    /* renamed from: i, reason: collision with root package name */
    public final Object f1444i;

    /* renamed from: j, reason: collision with root package name */
    public int f1445j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ u f1446k;

    public t(u uVar, int i9) {
        this.f1446k = uVar;
        Object obj = u.f1450r;
        this.f1444i = uVar.i()[i9];
        this.f1445j = i9;
    }

    public final void a() {
        int i9 = this.f1445j;
        Object obj = this.f1444i;
        u uVar = this.f1446k;
        if (i9 != -1 && i9 < uVar.size()) {
            if (android.support.v4.media.session.b.G(obj, uVar.i()[this.f1445j])) {
                return;
            }
        }
        Object obj2 = u.f1450r;
        this.f1445j = uVar.d(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1444i;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        u uVar = this.f1446k;
        Map b9 = uVar.b();
        if (b9 != null) {
            return b9.get(this.f1444i);
        }
        a();
        int i9 = this.f1445j;
        if (i9 == -1) {
            return null;
        }
        return uVar.j()[i9];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        u uVar = this.f1446k;
        Map b9 = uVar.b();
        Object obj2 = this.f1444i;
        if (b9 != null) {
            return b9.put(obj2, obj);
        }
        a();
        int i9 = this.f1445j;
        if (i9 == -1) {
            uVar.put(obj2, obj);
            return null;
        }
        Object obj3 = uVar.j()[i9];
        uVar.j()[this.f1445j] = obj;
        return obj3;
    }
}
