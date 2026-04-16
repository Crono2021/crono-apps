package f6;

import com.google.crypto.tink.shaded.protobuf.e0;
import d4.t;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import r6.a1;
import r6.q1;
import r6.x0;
import r6.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f3435a;

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f3436b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f3437c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f3438d;

    static {
        Logger.getLogger(n.class.getName());
        f3435a = new AtomicReference(new e());
        f3436b = new ConcurrentHashMap();
        f3437c = new ConcurrentHashMap();
        new ConcurrentHashMap();
        f3438d = new ConcurrentHashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0051, code lost:
    
        r6 = (java.util.Map.Entry) r5.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
    
        if (f6.n.f3438d.containsKey(r6.getKey()) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0088, code lost:
    
        throw new java.security.GeneralSecurityException("Attempted to register a new key template " + ((java.lang.String) r6.getKey()) + " from an existing key manager of type " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0089, code lost:
    
        r4 = r5.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0095, code lost:
    
        if (r4.hasNext() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
    
        r5 = (java.util.Map.Entry) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a7, code lost:
    
        if (f6.n.f3438d.containsKey(r5.getKey()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c6, code lost:
    
        throw new java.security.GeneralSecurityException("Attempted overwrite of a registered key template " + ((java.lang.String) r5.getKey()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0041, code lost:
    
        if (((f6.e) f6.n.f3435a.get()).f3418a.containsKey(r4) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0043, code lost:
    
        r5 = r5.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004f, code lost:
    
        if (r5.hasNext() == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void a(java.lang.String r4, java.util.Map r5, boolean r6) {
        /*
            java.lang.String r0 = "New keys are already disallowed for key type "
            java.lang.Class<f6.n> r1 = f6.n.class
            monitor-enter(r1)
            if (r6 == 0) goto L31
            java.util.concurrent.ConcurrentHashMap r2 = f6.n.f3437c     // Catch: java.lang.Throwable -> L2e
            boolean r3 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L31
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L2e
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L1c
            goto L31
        L1c:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L2e
            r6.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L2e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            throw r5     // Catch: java.lang.Throwable -> L2e
        L2e:
            r4 = move-exception
            goto Lc7
        L31:
            if (r6 == 0) goto Lc9
            java.util.concurrent.atomic.AtomicReference r6 = f6.n.f3435a     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L2e
            f6.e r6 = (f6.e) r6     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentHashMap r6 = r6.f3418a     // Catch: java.lang.Throwable -> L2e
            boolean r6 = r6.containsKey(r4)     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L89
            java.util.Set r5 = r5.entrySet()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L2e
        L4b:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto Lc9
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L2e
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentHashMap r0 = f6.n.f3438d     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r2 = r6.getKey()     // Catch: java.lang.Throwable -> L2e
            boolean r0 = r0.containsKey(r2)     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L64
            goto L4b
        L64:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r0.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "Attempted to register a new key template "
            r0.append(r2)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r6.getKey()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L2e
            r0.append(r6)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = " from an existing key manager of type "
            r0.append(r6)     // Catch: java.lang.Throwable -> L2e
            r0.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L2e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            throw r5     // Catch: java.lang.Throwable -> L2e
        L89:
            java.util.Set r4 = r5.entrySet()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L2e
        L91:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r5 == 0) goto Lc9
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L2e
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentHashMap r6 = f6.n.f3438d     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r0 = r5.getKey()     // Catch: java.lang.Throwable -> L2e
            boolean r6 = r6.containsKey(r0)     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto Laa
            goto L91
        Laa:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L2e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r6.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r0 = "Attempted overwrite of a registered key template "
            r6.append(r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r5 = r5.getKey()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L2e
            r6.append(r5)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L2e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2e
            throw r4     // Catch: java.lang.Throwable -> L2e
        Lc7:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            throw r4
        Lc9:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.n.a(java.lang.String, java.util.Map, boolean):void");
    }

    public static Object b(b bVar, Class cls) {
        m6.o oVar = (m6.o) m6.i.f6664b.f6665a.get();
        oVar.getClass();
        m6.n nVar = new m6.n(bVar.getClass(), cls);
        HashMap hashMap = oVar.f6674a;
        if (!hashMap.containsKey(nVar)) {
            androidx.fragment.app.a.q(nVar, " available", "No PrimitiveConstructor for ");
            return null;
        }
        switch (((m6.m) hashMap.get(nVar)).f6671b.f6694i) {
            case 2:
                o6.a aVar = new o6.a();
                if (!androidx.activity.g.d(1)) {
                    androidx.fragment.app.a.o("Can not use AES-CMAC in FIPS-mode.");
                    break;
                }
                break;
            default:
                o6.a aVar2 = new o6.a();
                if (!androidx.activity.g.e(2)) {
                    androidx.fragment.app.a.o("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
                    break;
                }
                break;
        }
        return null;
    }

    public static Object c(String str, com.google.crypto.tink.shaded.protobuf.j jVar, Class cls) {
        e eVar = (e) f3435a.get();
        eVar.getClass();
        d a9 = eVar.a(str);
        Set keySet = a9.f3416a.f6659b.keySet();
        m6.e eVar2 = a9.f3416a;
        if (!keySet.contains(cls)) {
            StringBuilder sb = new StringBuilder("Primitive type ");
            sb.append(cls.getName());
            sb.append(" not supported by key manager of type ");
            sb.append(eVar2.getClass());
            sb.append(", supported primitives: ");
            Set<Class> keySet2 = eVar2.f6659b.keySet();
            StringBuilder sb2 = new StringBuilder();
            boolean z8 = true;
            for (Class cls2 : keySet2) {
                if (!z8) {
                    sb2.append(", ");
                }
                sb2.append(cls2.getCanonicalName());
                z8 = false;
            }
            sb.append(sb2.toString());
            throw new GeneralSecurityException(sb.toString());
        }
        try {
            if (!eVar2.f6659b.keySet().contains(cls) && !Void.class.equals(cls)) {
                throw new IllegalArgumentException("Given internalKeyMananger " + eVar2.toString() + " does not support primitive class " + cls.getName());
            }
            try {
                com.google.crypto.tink.shaded.protobuf.a f9 = eVar2.f(jVar);
                if (Void.class.equals(cls)) {
                    throw new GeneralSecurityException("Cannot create a primitive for Void");
                }
                eVar2.g(f9);
                return eVar2.c(f9, cls);
            } catch (e0 e9) {
                throw new GeneralSecurityException("Failures parsing proto of type ".concat(eVar2.f6658a.getName()), e9);
            }
        } catch (IllegalArgumentException e10) {
            throw new GeneralSecurityException("Primitive type not supported", e10);
        }
    }

    public static synchronized x0 d(a1 a1Var) {
        x0 f9;
        synchronized (n.class) {
            m6.e eVar = ((e) f3435a.get()).a(a1Var.B()).f3416a;
            f fVar = new f(eVar, eVar.f6660c);
            if (!((Boolean) f3437c.get(a1Var.B())).booleanValue()) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + a1Var.B());
            }
            f9 = fVar.f(a1Var.C());
        }
        return f9;
    }

    public static synchronized void e(m6.e eVar, boolean z8) {
        synchronized (n.class) {
            try {
                AtomicReference atomicReference = f3435a;
                e eVar2 = new e((e) atomicReference.get());
                eVar2.b(eVar);
                String b9 = eVar.b();
                a(b9, z8 ? eVar.d().b() : Collections.EMPTY_MAP, z8);
                if (!((e) atomicReference.get()).f3418a.containsKey(b9)) {
                    f3436b.put(b9, new t(7));
                    if (z8) {
                        f(b9, eVar.d().b());
                    }
                }
                f3437c.put(b9, Boolean.valueOf(z8));
                atomicReference.set(eVar2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void f(String str, Map map) {
        q1 q1Var;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            byte[] e9 = ((com.google.crypto.tink.shaded.protobuf.a) ((m6.d) entry.getValue()).f6656a).e();
            int i9 = ((m6.d) entry.getValue()).f6657b;
            z0 D = a1.D();
            D.e();
            a1.w((a1) D.f2326j, str);
            com.google.crypto.tink.shaded.protobuf.i h = com.google.crypto.tink.shaded.protobuf.j.h(0, e9.length, e9);
            D.e();
            a1.x((a1) D.f2326j, h);
            int a9 = v.h.a(i9);
            if (a9 == 0) {
                q1Var = q1.TINK;
            } else if (a9 == 1) {
                q1Var = q1.LEGACY;
            } else if (a9 == 2) {
                q1Var = q1.RAW;
            } else {
                if (a9 != 3) {
                    m7.c.n("Unknown output prefix type");
                    return;
                }
                q1Var = q1.CRUNCHY;
            }
            D.e();
            a1.y((a1) D.f2326j, q1Var);
            f3438d.put(str2, new g((a1) D.b()));
        }
    }

    public static synchronized void g(m mVar) {
        synchronized (n.class) {
            m6.i.f6664b.b(mVar);
        }
    }
}
