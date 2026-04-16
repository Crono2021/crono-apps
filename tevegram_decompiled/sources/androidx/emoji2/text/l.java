package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f623i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static volatile l f624j;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f625a;

    /* renamed from: b, reason: collision with root package name */
    public final s.e f626b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f627c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f628d;

    /* renamed from: e, reason: collision with root package name */
    public final g f629e;

    /* renamed from: f, reason: collision with root package name */
    public final k f630f;

    /* renamed from: g, reason: collision with root package name */
    public final int f631g;
    public final e h;

    public l(t tVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f625a = reentrantReadWriteLock;
        this.f627c = 3;
        k kVar = (k) tVar.f618b;
        this.f630f = kVar;
        int i9 = tVar.f617a;
        this.f631g = i9;
        this.h = (e) tVar.f619c;
        this.f628d = new Handler(Looper.getMainLooper());
        this.f626b = new s.e(0);
        g gVar = new g(this);
        this.f629e = gVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i9 == 0) {
            try {
                this.f627c = 0;
            } catch (Throwable th) {
                this.f625a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                kVar.a(new f(gVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static l a() {
        l lVar;
        synchronized (f623i) {
            try {
                lVar = f624j;
                if (!(lVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return lVar;
    }

    public final int b() {
        this.f625a.readLock().lock();
        try {
            return this.f627c;
        } finally {
            this.f625a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f631g == 1)) {
            m7.c.p("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
            return;
        }
        if (b() == 1) {
            return;
        }
        this.f625a.writeLock().lock();
        try {
            if (this.f627c == 0) {
                return;
            }
            this.f627c = 0;
            this.f625a.writeLock().unlock();
            g gVar = this.f629e;
            l lVar = gVar.f614a;
            try {
                lVar.f630f.a(new f(gVar));
            } catch (Throwable th) {
                lVar.d(th);
            }
        } finally {
            this.f625a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f625a.writeLock().lock();
        try {
            this.f627c = 2;
            arrayList.addAll(this.f626b);
            this.f626b.clear();
            this.f625a.writeLock().unlock();
            this.f628d.post(new j(arrayList, this.f627c, th));
        } catch (Throwable th2) {
            this.f625a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x017a, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x015f A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:118:0x005a, B:121:0x005f, B:123:0x0063, B:125:0x0070, B:29:0x0083, B:31:0x008d, B:33:0x0090, B:35:0x0094, B:37:0x00a4, B:39:0x00a7, B:43:0x00b4, B:46:0x00bc, B:51:0x00db, B:75:0x00e7, B:79:0x00f3, B:80:0x00fd, B:63:0x010c, B:66:0x0113, B:54:0x0118, B:56:0x0123, B:85:0x012a, B:87:0x012e, B:89:0x0134, B:91:0x0138, B:94:0x0140, B:97:0x014c, B:98:0x0151, B:100:0x015f, B:27:0x0079), top: B:117:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:118:0x005a, B:121:0x005f, B:123:0x0063, B:125:0x0070, B:29:0x0083, B:31:0x008d, B:33:0x0090, B:35:0x0094, B:37:0x00a4, B:39:0x00a7, B:43:0x00b4, B:46:0x00bc, B:51:0x00db, B:75:0x00e7, B:79:0x00f3, B:80:0x00fd, B:63:0x010c, B:66:0x0113, B:54:0x0118, B:56:0x0123, B:85:0x012a, B:87:0x012e, B:89:0x0134, B:91:0x0138, B:94:0x0140, B:97:0x014c, B:98:0x0151, B:100:0x015f, B:27:0x0079), top: B:117:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014c A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:118:0x005a, B:121:0x005f, B:123:0x0063, B:125:0x0070, B:29:0x0083, B:31:0x008d, B:33:0x0090, B:35:0x0094, B:37:0x00a4, B:39:0x00a7, B:43:0x00b4, B:46:0x00bc, B:51:0x00db, B:75:0x00e7, B:79:0x00f3, B:80:0x00fd, B:63:0x010c, B:66:0x0113, B:54:0x0118, B:56:0x0123, B:85:0x012a, B:87:0x012e, B:89:0x0134, B:91:0x0138, B:94:0x0140, B:97:0x014c, B:98:0x0151, B:100:0x015f, B:27:0x0079), top: B:117:0x005a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.l.e(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void f(i iVar) {
        android.support.v4.media.session.b.r(iVar, "initCallback cannot be null");
        this.f625a.writeLock().lock();
        try {
            if (this.f627c != 1 && this.f627c != 2) {
                this.f626b.add(iVar);
                this.f625a.writeLock().unlock();
            }
            this.f628d.post(new j(Arrays.asList(iVar), this.f627c, (Throwable) null));
            this.f625a.writeLock().unlock();
        } catch (Throwable th) {
            this.f625a.writeLock().unlock();
            throw th;
        }
    }
}
