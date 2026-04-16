package org.webrtc;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class RefCountDelegate implements RefCounted {
    private final AtomicInteger refCount = new AtomicInteger(1);
    private final Runnable releaseCallback;

    public RefCountDelegate(Runnable runnable) {
        this.releaseCallback = runnable;
    }

    @Override // org.webrtc.RefCounted
    public void release() {
        Runnable runnable;
        int decrementAndGet = this.refCount.decrementAndGet();
        if (decrementAndGet < 0) {
            m7.c.p("release() called on an object with refcount < 1");
        } else {
            if (decrementAndGet != 0 || (runnable = this.releaseCallback) == null) {
                return;
            }
            runnable.run();
        }
    }

    @Override // org.webrtc.RefCounted
    public void retain() {
        if (this.refCount.incrementAndGet() >= 2) {
            return;
        }
        m7.c.p("retain() called on an object with refcount < 1");
    }

    public boolean safeRetain() {
        int i9 = this.refCount.get();
        while (i9 != 0) {
            if (this.refCount.weakCompareAndSet(i9, i9 + 1)) {
                return true;
            }
            i9 = this.refCount.get();
        }
        return false;
    }
}
