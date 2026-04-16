package c;

import androidx.emoji2.text.o;
import d4.t;
import f4.d;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;
import w4.f;
import w4.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements g {

    /* renamed from: i, reason: collision with root package name */
    public final Object f1527i;

    /* renamed from: j, reason: collision with root package name */
    public volatile Object f1528j;

    public a() {
        this.f1527i = new CopyOnWriteArraySet();
    }

    public f4.a a() {
        if (((f4.a) this.f1528j) == null) {
            synchronized (this) {
                try {
                    if (((f4.a) this.f1528j) == null) {
                        File cacheDir = ((o) ((a0.b) this.f1527i).f8j).f639j.getCacheDir();
                        d dVar = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            dVar = new d(file);
                        }
                        this.f1528j = dVar;
                    }
                    if (((f4.a) this.f1528j) == null) {
                        this.f1528j = new t(5);
                    }
                } finally {
                }
            }
        }
        return (f4.a) this.f1528j;
    }

    @Override // w4.g
    public Object get() {
        if (this.f1528j == null) {
            synchronized (this) {
                try {
                    if (this.f1528j == null) {
                        Object obj = ((g) this.f1527i).get();
                        f.c(obj, "Argument must not be null");
                        this.f1528j = obj;
                    }
                } finally {
                }
            }
        }
        return this.f1528j;
    }

    public /* synthetic */ a(Object obj) {
        this.f1527i = obj;
    }
}
