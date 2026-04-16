package androidx.fragment.app;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.view.MenuItem;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashSet;
import javax.crypto.AEADBadTagException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class i implements h4.r {

    /* renamed from: i, reason: collision with root package name */
    public Object f761i;

    /* renamed from: j, reason: collision with root package name */
    public Object f762j;

    public /* synthetic */ i(Object obj, Object obj2) {
        this.f761i = obj;
        this.f762j = obj2;
    }

    public static byte[] k(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int remaining = byteBuffer.remaining();
        int i9 = remaining % 16;
        int i10 = (i9 == 0 ? remaining : (remaining + 16) - i9) + length;
        ByteBuffer order = ByteBuffer.allocate(i10 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(length);
        order.put(byteBuffer);
        order.position(i10);
        order.putLong(bArr.length);
        order.putLong(remaining);
        return order.array();
    }

    public void c() {
        com.bumptech.glide.manager.p pVar = (com.bumptech.glide.manager.p) this.f761i;
        if (pVar != null) {
            try {
                ((g.c0) this.f762j).f3488s.unregisterReceiver(pVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f761i = null;
        }
    }

    public void d() {
        s0 s0Var = (s0) this.f761i;
        j0.d dVar = (j0.d) this.f762j;
        HashSet hashSet = s0Var.f864e;
        if (hashSet.remove(dVar) && hashSet.isEmpty()) {
            s0Var.b();
        }
    }

    public abstract IntentFilter e();

    public byte[] f(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() < 16) {
            a.o("ciphertext too short");
            return null;
        }
        int position = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(position);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            ((com.google.crypto.tink.shaded.protobuf.m) this.f762j).a(bArr, 0).get(bArr4);
            if (!MessageDigest.isEqual(com.bumptech.glide.c.k(bArr4, k(bArr2, byteBuffer)), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(position);
            com.google.crypto.tink.shaded.protobuf.m mVar = (com.google.crypto.tink.shaded.protobuf.m) this.f761i;
            mVar.getClass();
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            mVar.k(bArr, allocate, byteBuffer);
            return allocate.array();
        } catch (GeneralSecurityException e9) {
            throw new AEADBadTagException(e9.toString());
        }
    }

    public void g(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (byteBuffer.remaining() < bArr2.length + 16) {
            m7.c.n("Given ByteBuffer output is too small");
            return;
        }
        int position = byteBuffer.position();
        com.google.crypto.tink.shaded.protobuf.m mVar = (com.google.crypto.tink.shaded.protobuf.m) this.f761i;
        mVar.getClass();
        if (byteBuffer.remaining() < bArr2.length) {
            m7.c.n("Given ByteBuffer output is too small");
            return;
        }
        mVar.k(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
        byteBuffer.position(position);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        byte[] bArr4 = new byte[32];
        ((com.google.crypto.tink.shaded.protobuf.m) this.f762j).a(bArr, 0).get(bArr4);
        byte[] k3 = com.bumptech.glide.c.k(bArr4, k(bArr3, byteBuffer));
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(k3);
    }

    public abstract int h();

    @Override // h4.r
    public h4.q i(h4.w wVar) {
        Context context = (Context) this.f761i;
        Class cls = (Class) this.f762j;
        return new i4.d(context, wVar.b(File.class, cls), wVar.b(Uri.class, cls), cls);
    }

    public MenuItem j(MenuItem menuItem) {
        if (!(menuItem instanceof h0.a)) {
            return menuItem;
        }
        h0.a aVar = (h0.a) menuItem;
        if (((s.h) this.f762j) == null) {
            this.f762j = new s.h();
        }
        MenuItem menuItem2 = (MenuItem) ((s.h) this.f762j).getOrDefault(aVar, null);
        if (menuItem2 != null) {
            return menuItem2;
        }
        m.t tVar = new m.t((Context) this.f761i, aVar);
        ((s.h) this.f762j).put(aVar, tVar);
        return tVar;
    }

    public abstract com.google.crypto.tink.shaded.protobuf.m l(byte[] bArr, int i9);

    public abstract void m();

    public void n() {
        c();
        IntentFilter e9 = e();
        if (e9.countActions() == 0) {
            return;
        }
        if (((com.bumptech.glide.manager.p) this.f761i) == null) {
            this.f761i = new com.bumptech.glide.manager.p(this, 1);
        }
        ((g.c0) this.f762j).f3488s.registerReceiver((com.bumptech.glide.manager.p) this.f761i, e9);
    }

    public i(Context context) {
        this.f761i = context;
    }

    public i(g.c0 c0Var) {
        this.f762j = c0Var;
    }
}
