package h4;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d0 implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f3974b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    public final q f3975a;

    public d0(q qVar) {
        this.f3975a = qVar;
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, b4.i iVar) {
        return this.f3975a.a(new g(((Uri) obj).toString()), i9, i10, iVar);
    }

    @Override // h4.q
    public final boolean b(Object obj) {
        return f3974b.contains(((Uri) obj).getScheme());
    }
}
