package i8;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5282a;

    /* renamed from: b, reason: collision with root package name */
    public final e f5283b;

    /* renamed from: c, reason: collision with root package name */
    public final a8.l f5284c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5285d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f5286e;

    public /* synthetic */ l(Object obj, e eVar, a8.l lVar, CancellationException cancellationException, int i9) {
        this(obj, (i9 & 2) != 0 ? null : eVar, (i9 & 4) != 0 ? null : lVar, (Object) null, (i9 & 16) != 0 ? null : cancellationException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable] */
    public static l a(l lVar, e eVar, CancellationException cancellationException, int i9) {
        Object obj = lVar.f5282a;
        if ((i9 & 2) != 0) {
            eVar = lVar.f5283b;
        }
        e eVar2 = eVar;
        a8.l lVar2 = lVar.f5284c;
        Object obj2 = lVar.f5285d;
        CancellationException cancellationException2 = cancellationException;
        if ((i9 & 16) != 0) {
            cancellationException2 = lVar.f5286e;
        }
        return new l(obj, eVar2, lVar2, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return b8.i.a(this.f5282a, lVar.f5282a) && b8.i.a(this.f5283b, lVar.f5283b) && b8.i.a(this.f5284c, lVar.f5284c) && b8.i.a(this.f5285d, lVar.f5285d) && b8.i.a(this.f5286e, lVar.f5286e);
    }

    public final int hashCode() {
        Object obj = this.f5282a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        e eVar = this.f5283b;
        int hashCode2 = (hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        a8.l lVar = this.f5284c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f5285d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f5286e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f5282a + ", cancelHandler=" + this.f5283b + ", onCancellation=" + this.f5284c + ", idempotentResume=" + this.f5285d + ", cancelCause=" + this.f5286e + ')';
    }

    public l(Object obj, e eVar, a8.l lVar, Object obj2, Throwable th) {
        this.f5282a = obj;
        this.f5283b = eVar;
        this.f5284c = lVar;
        this.f5285d = obj2;
        this.f5286e = th;
    }
}
