package d4;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 implements b4.f {

    /* renamed from: j, reason: collision with root package name */
    public static final w4.j f2807j = new w4.j(50);

    /* renamed from: b, reason: collision with root package name */
    public final e4.f f2808b;

    /* renamed from: c, reason: collision with root package name */
    public final b4.f f2809c;

    /* renamed from: d, reason: collision with root package name */
    public final b4.f f2810d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2811e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2812f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f2813g;
    public final b4.i h;

    /* renamed from: i, reason: collision with root package name */
    public final b4.m f2814i;

    public c0(e4.f fVar, b4.f fVar2, b4.f fVar3, int i9, int i10, b4.m mVar, Class cls, b4.i iVar) {
        this.f2808b = fVar;
        this.f2809c = fVar2;
        this.f2810d = fVar3;
        this.f2811e = i9;
        this.f2812f = i10;
        this.f2814i = mVar;
        this.f2813g = cls;
        this.h = iVar;
    }

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        Object f9;
        e4.f fVar = this.f2808b;
        synchronized (fVar) {
            e4.e eVar = fVar.f3097b;
            e4.h hVar = (e4.h) ((ArrayDeque) eVar.f1132i).poll();
            if (hVar == null) {
                hVar = eVar.f();
            }
            e4.d dVar = (e4.d) hVar;
            dVar.f3093b = 8;
            dVar.f3094c = byte[].class;
            f9 = fVar.f(dVar, byte[].class);
        }
        byte[] bArr = (byte[]) f9;
        ByteBuffer.wrap(bArr).putInt(this.f2811e).putInt(this.f2812f).array();
        this.f2810d.b(messageDigest);
        this.f2809c.b(messageDigest);
        messageDigest.update(bArr);
        b4.m mVar = this.f2814i;
        if (mVar != null) {
            mVar.b(messageDigest);
        }
        this.h.b(messageDigest);
        w4.j jVar = f2807j;
        Class cls = this.f2813g;
        byte[] bArr2 = (byte[]) jVar.a(cls);
        if (bArr2 == null) {
            bArr2 = cls.getName().getBytes(b4.f.f1325a);
            jVar.d(cls, bArr2);
        }
        messageDigest.update(bArr2);
        this.f2808b.h(bArr);
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (this.f2812f == c0Var.f2812f && this.f2811e == c0Var.f2811e && w4.n.b(this.f2814i, c0Var.f2814i) && this.f2813g.equals(c0Var.f2813g) && this.f2809c.equals(c0Var.f2809c) && this.f2810d.equals(c0Var.f2810d) && this.h.equals(c0Var.h)) {
                return true;
            }
        }
        return false;
    }

    @Override // b4.f
    public final int hashCode() {
        int hashCode = ((((this.f2810d.hashCode() + (this.f2809c.hashCode() * 31)) * 31) + this.f2811e) * 31) + this.f2812f;
        b4.m mVar = this.f2814i;
        if (mVar != null) {
            hashCode = (hashCode * 31) + mVar.hashCode();
        }
        return this.h.f1331b.hashCode() + ((this.f2813g.hashCode() + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f2809c + ", signature=" + this.f2810d + ", width=" + this.f2811e + ", height=" + this.f2812f + ", decodedResourceClass=" + this.f2813g + ", transformation='" + this.f2814i + "', options=" + this.h + '}';
    }
}
