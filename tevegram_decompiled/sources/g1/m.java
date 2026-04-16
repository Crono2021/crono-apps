package g1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final r f3682a;

    /* renamed from: b, reason: collision with root package name */
    public final t f3683b;

    /* renamed from: c, reason: collision with root package name */
    public final k f3684c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f3685d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque f3686e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f3687f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3688g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3689i;

    public m(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, r rVar, k kVar, boolean z8) {
        this.f3682a = rVar;
        this.f3685d = copyOnWriteArraySet;
        this.f3684c = kVar;
        this.f3688g = new Object();
        this.f3686e = new ArrayDeque();
        this.f3687f = new ArrayDeque();
        this.f3683b = rVar.a(looper, new Handler.Callback() { // from class: g1.h
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                m mVar = m.this;
                Iterator it = mVar.f3685d.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    k kVar2 = mVar.f3684c;
                    if (!lVar.f3681d && lVar.f3680c) {
                        d1.q b9 = lVar.f3679b.b();
                        lVar.f3679b = new d1.p(0);
                        lVar.f3680c = false;
                        kVar2.b(lVar.f3678a, b9);
                    }
                    if (mVar.f3683b.f3708a.hasMessages(0)) {
                        return true;
                    }
                }
                return true;
            }
        });
        this.f3689i = z8;
    }

    public final void a(Object obj) {
        obj.getClass();
        synchronized (this.f3688g) {
            try {
                if (this.h) {
                    return;
                }
                this.f3685d.add(new l(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        f();
        ArrayDeque arrayDeque = this.f3687f;
        if (arrayDeque.isEmpty()) {
            return;
        }
        t tVar = this.f3683b;
        Handler handler = tVar.f3708a;
        Handler handler2 = tVar.f3708a;
        if (!handler.hasMessages(0)) {
            s b9 = t.b();
            Message obtainMessage = handler2.obtainMessage(0);
            b9.f3706a = obtainMessage;
            obtainMessage.getClass();
            handler2.sendMessageAtFrontOfQueue(obtainMessage);
            b9.a();
        }
        ArrayDeque arrayDeque2 = this.f3686e;
        boolean isEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (isEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void c(int i9, j jVar) {
        f();
        this.f3687f.add(new i(i9, 0, new CopyOnWriteArraySet(this.f3685d), jVar));
    }

    public final void d() {
        f();
        synchronized (this.f3688g) {
            this.h = true;
        }
        Iterator it = this.f3685d.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            k kVar = this.f3684c;
            lVar.f3681d = true;
            if (lVar.f3680c) {
                lVar.f3680c = false;
                kVar.b(lVar.f3678a, lVar.f3679b.b());
            }
        }
        this.f3685d.clear();
    }

    public final void e(int i9, j jVar) {
        c(i9, jVar);
        b();
    }

    public final void f() {
        if (this.f3689i) {
            a.k(Thread.currentThread() == this.f3683b.f3708a.getLooper().getThread());
        }
    }

    public m(Looper looper, r rVar, k kVar) {
        this(new CopyOnWriteArraySet(), looper, rVar, kVar, true);
    }
}
