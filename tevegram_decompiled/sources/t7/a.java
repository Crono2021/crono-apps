package t7;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import n.e3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a implements r7.c, d, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final r7.c f8981i;

    public a(r7.c cVar) {
        this.f8981i = cVar;
    }

    @Override // t7.d
    public final d b() {
        r7.c cVar = this.f8981i;
        if (cVar instanceof d) {
            return (d) cVar;
        }
        return null;
    }

    @Override // r7.c
    public final void g(Object obj) {
        r7.c cVar = this;
        while (true) {
            a aVar = (a) cVar;
            r7.c cVar2 = aVar.f8981i;
            cVar2.getClass();
            try {
                obj = aVar.k(obj);
                if (obj == s7.a.f8891i) {
                    return;
                }
            } catch (Throwable th) {
                obj = new n7.c(th);
            }
            aVar.l();
            if (!(cVar2 instanceof a)) {
                cVar2.g(obj);
                return;
            }
            cVar = cVar2;
        }
    }

    public r7.c j(Object obj, r7.c cVar) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public abstract Object k(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.StackTraceElement] */
    public String toString() {
        int i9;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        StringBuilder sb = new StringBuilder("Continuation at ");
        e eVar = (e) getClass().getAnnotation(e.class);
        String str2 = null;
        if (eVar != null) {
            int v8 = eVar.v();
            if (v8 > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v8 + ". Please update the Kotlin standard library.").toString());
            }
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                i9 = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                i9 = -1;
            }
            int i10 = i9 >= 0 ? eVar.l()[i9] : -1;
            e3 e3Var = f.f8986b;
            e3 e3Var2 = f.f8985a;
            if (e3Var == null) {
                try {
                    e3 e3Var3 = new e3(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                    f.f8986b = e3Var3;
                    e3Var = e3Var3;
                } catch (Exception unused2) {
                    f.f8986b = e3Var2;
                    e3Var = e3Var2;
                }
            }
            if (e3Var != e3Var2 && (method = e3Var.f6857a) != null && (invoke = method.invoke(getClass(), null)) != null && (method2 = e3Var.f6858b) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
                Method method3 = e3Var.f6859c;
                String invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
                if (invoke3 instanceof String) {
                    str2 = invoke3;
                }
            }
            if (str2 == null) {
                str = eVar.c();
            } else {
                str = str2 + '/' + eVar.c();
            }
            str2 = new StackTraceElement(str, eVar.m(), eVar.f(), i10);
        }
        if (str2 == null) {
            str2 = getClass().getName();
        }
        sb.append((Object) str2);
        return sb.toString();
    }

    public void l() {
    }
}
