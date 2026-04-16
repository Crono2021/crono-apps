package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.bumptech.glide.manager.s;
import d4.n;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements ComponentCallbacks2 {

    /* renamed from: p, reason: collision with root package name */
    public static volatile b f1729p;

    /* renamed from: q, reason: collision with root package name */
    public static volatile boolean f1730q;

    /* renamed from: i, reason: collision with root package name */
    public final e4.a f1731i;

    /* renamed from: j, reason: collision with root package name */
    public final f4.e f1732j;

    /* renamed from: k, reason: collision with root package name */
    public final e f1733k;

    /* renamed from: l, reason: collision with root package name */
    public final e4.f f1734l;

    /* renamed from: m, reason: collision with root package name */
    public final com.bumptech.glide.manager.k f1735m;

    /* renamed from: n, reason: collision with root package name */
    public final u5.e f1736n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f1737o = new ArrayList();

    public b(Context context, n nVar, f4.e eVar, e4.a aVar, e4.f fVar, com.bumptech.glide.manager.k kVar, u5.e eVar2, u5.e eVar3, s.d dVar, List list, ArrayList arrayList, d dVar2, a0.b bVar) {
        this.f1731i = aVar;
        this.f1734l = fVar;
        this.f1732j = eVar;
        this.f1735m = kVar;
        this.f1736n = eVar2;
        this.f1733k = new e(context, fVar, new s(this, arrayList, dVar2), new o4.d(12), eVar3, dVar, list, nVar, bVar);
    }

    public static b a(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (f1729p == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e9) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e9);
            } catch (InstantiationException e10) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e10);
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e12);
            }
            synchronized (b.class) {
                if (f1729p == null) {
                    if (f1730q) {
                        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
                    }
                    f1730q = true;
                    try {
                        b(context, generatedAppGlideModule);
                        f1730q = false;
                    } catch (Throwable th) {
                        f1730q = false;
                        throw th;
                    }
                }
            }
        }
        return f1729p;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x031b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r27, com.bumptech.glide.GeneratedAppGlideModule r28) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.b(android.content.Context, com.bumptech.glide.GeneratedAppGlideModule):void");
    }

    public static m d(Context context) {
        w4.f.c(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).f1735m.b(context);
    }

    public final void c(m mVar) {
        synchronized (this.f1737o) {
            try {
                if (!this.f1737o.contains(mVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f1737o.remove(mVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        w4.n.a();
        this.f1732j.e(0L);
        this.f1731i.q();
        this.f1734l.a();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i9) {
        w4.n.a();
        synchronized (this.f1737o) {
            try {
                ArrayList arrayList = this.f1737o;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((m) obj).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f1732j.f(i9);
        this.f1731i.m(i9);
        this.f1734l.i(i9);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
