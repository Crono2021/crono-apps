package r3;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import androidx.fragment.app.r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f8542d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f8543e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f8546c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f8545b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8544a = new HashMap();

    public a(Context context) {
        this.f8546c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f8542d == null) {
            synchronized (f8543e) {
                try {
                    if (f8542d == null) {
                        f8542d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f8542d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f8546c.getString(2131951643);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f8545b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e9) {
                throw new r(e9);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        HashMap hashMap = this.f8544a;
        if (android.support.v4.media.session.b.V()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (hashMap.containsKey(cls)) {
            obj = hashMap.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> a9 = bVar.a();
                if (!a9.isEmpty()) {
                    for (Class cls2 : a9) {
                        if (!hashMap.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                obj = bVar.b(this.f8546c);
                hashSet.remove(cls);
                hashMap.put(cls, obj);
            } catch (Throwable th2) {
                throw new r(th2);
            }
        }
        Trace.endSection();
        return obj;
    }
}
