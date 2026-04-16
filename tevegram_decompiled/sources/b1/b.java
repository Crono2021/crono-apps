package b1;

import com.google.crypto.tink.shaded.protobuf.j;
import e4.h;
import h4.q;
import h4.r;
import h4.w;
import h4.z;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b implements r {

    /* renamed from: i, reason: collision with root package name */
    public final Object f1132i;

    public b(int i9) {
        switch (i9) {
            case 1:
                char[] cArr = n.f9951a;
                this.f1132i = new ArrayDeque(20);
                break;
            default:
                this.f1132i = new LinkedHashMap();
                break;
        }
    }

    public abstract com.google.crypto.tink.shaded.protobuf.a a(com.google.crypto.tink.shaded.protobuf.a aVar);

    public Map b() {
        return Collections.EMPTY_MAP;
    }

    public void c(h hVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f1132i;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(hVar);
        }
    }

    public abstract com.google.crypto.tink.shaded.protobuf.a d(j jVar);

    public abstract void e(com.google.crypto.tink.shaded.protobuf.a aVar);

    @Override // h4.r
    public q i(w wVar) {
        return new h4.c((z) this.f1132i, 2);
    }

    public /* synthetic */ b(Object obj) {
        this.f1132i = obj;
    }
}
