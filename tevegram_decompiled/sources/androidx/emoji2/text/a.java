package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f607a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f608b;

    public /* synthetic */ a(String str, int i9) {
        this.f607a = i9;
        this.f608b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f607a) {
            case 0:
                Thread thread = new Thread(runnable, this.f608b);
                thread.setPriority(10);
                return thread;
            default:
                return new Thread(runnable, this.f608b);
        }
    }
}
