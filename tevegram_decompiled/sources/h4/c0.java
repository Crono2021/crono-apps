package h4;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f3970b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));

    /* renamed from: a, reason: collision with root package name */
    public final Object f3971a;

    public c0(b0 b0Var) {
        this.f3971a = b0Var;
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, b4.i iVar) {
        com.bumptech.glide.load.data.e aVar;
        Uri uri = (Uri) obj;
        v4.b bVar = new v4.b(uri);
        b0 b0Var = (b0) this.f3971a;
        switch (b0Var.f3966i) {
            case 0:
                aVar = new com.bumptech.glide.load.data.a(b0Var.f3967j, uri, 0);
                break;
            case 1:
                aVar = new com.bumptech.glide.load.data.a(b0Var.f3967j, uri, 1);
                break;
            default:
                aVar = new com.bumptech.glide.load.data.n(1, uri, b0Var.f3967j);
                break;
        }
        return new p(bVar, aVar);
    }

    @Override // h4.q
    public final boolean b(Object obj) {
        return f3970b.contains(((Uri) obj).getScheme());
    }
}
