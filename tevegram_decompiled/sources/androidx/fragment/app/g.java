package androidx.fragment.app;

import android.content.ClipDescription;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.network.tvgramplayer.ui.MainActivity;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import n.v0;
import n1.u0;
import o3.d1;
import org.webrtc.PeerConnectionFactory;
import r6.e1;
import r6.f1;
import r6.q1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements j0.c, z2.f, i3.z, p4.a, q0.g, s1.k, q6.a {

    /* renamed from: m, reason: collision with root package name */
    public static g f726m;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f727i;

    /* renamed from: j, reason: collision with root package name */
    public Object f728j;

    /* renamed from: k, reason: collision with root package name */
    public Object f729k;

    /* renamed from: l, reason: collision with root package name */
    public Object f730l;

    public g(ArrayList arrayList) {
        this.f727i = 13;
        this.f728j = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f729k = new long[arrayList.size() * 2];
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            h3.c cVar = (h3.c) arrayList.get(i9);
            int i10 = i9 * 2;
            long[] jArr = (long[]) this.f729k;
            jArr[i10] = cVar.f3933b;
            jArr[i10 + 1] = cVar.f3934c;
        }
        long[] jArr2 = (long[]) this.f729k;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f730l = copyOf;
        Arrays.sort(copyOf);
    }

    public static final g K(f1 f1Var) {
        if (f1Var.z() <= 0) {
            a.o("empty keyset");
            return null;
        }
        ArrayList arrayList = new ArrayList(f1Var.z());
        for (e1 e1Var : f1Var.A()) {
            e1Var.getClass();
            try {
                try {
                    f6.b a9 = m6.j.f6666b.a(m6.p.c(e1Var.A().B(), e1Var.A().C(), e1Var.A().A(), e1Var.C(), e1Var.C() == q1.RAW ? null : Integer.valueOf(e1Var.B())));
                    int ordinal = e1Var.D().ordinal();
                    if (ordinal != 1 && ordinal != 2 && ordinal != 3) {
                        throw new GeneralSecurityException("Unknown key status");
                    }
                    arrayList.add(new f6.h(a9));
                } catch (GeneralSecurityException unused) {
                    arrayList.add(null);
                }
            } catch (GeneralSecurityException e9) {
                throw new r("Creating a protokey serialization failed", e9);
            }
        }
        return new g(f1Var, Collections.unmodifiableList(arrayList));
    }

    public static g g0(Context context, AttributeSet attributeSet, int[] iArr, int i9) {
        return new g(context, context.obtainStyledAttributes(attributeSet, iArr, i9, 0));
    }

    public static final g h0(f6.f fVar, l6.b bVar) {
        byte[] bArr = new byte[0];
        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) fVar.f3423b;
        try {
            r6.n0 A = r6.n0.A(byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.q.a());
            byteArrayInputStream.close();
            if (A.y().size() == 0) {
                a.o("empty keyset");
                return null;
            }
            try {
                f1 E = f1.E(bVar.b(A.y().j(), bArr), com.google.crypto.tink.shaded.protobuf.q.a());
                if (E.z() > 0) {
                    return K(E);
                }
                throw new GeneralSecurityException("empty keyset");
            } catch (com.google.crypto.tink.shaded.protobuf.e0 unused) {
                a.o("invalid keyset, corrupted key material");
                return null;
            }
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    public g6.m A() {
        i7.x xVar;
        g6.n nVar = (g6.n) this.f728j;
        if (nVar == null || (xVar = (i7.x) this.f729k) == null) {
            a.o("Cannot build without parameters and/or key material");
            return null;
        }
        if (nVar.f3782b != ((t6.a) xVar.f5179j).f8980a.length) {
            a.o("Key size mismatch");
            return null;
        }
        g6.j jVar = nVar.f3785e;
        g6.j jVar2 = g6.j.h;
        if (jVar != jVar2 && ((Integer) this.f730l) == null) {
            a.o("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (jVar == jVar2 && ((Integer) this.f730l) != null) {
            a.o("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (jVar == jVar2) {
            t6.a.a(new byte[0]);
        } else if (jVar == g6.j.f3762g) {
            t6.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f730l).intValue()).array());
        } else {
            if (jVar != g6.j.f3761f) {
                a.t(((g6.n) this.f728j).f3785e, "Unknown AesGcmParameters.Variant: ");
                return null;
            }
            t6.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f730l).intValue()).array());
        }
        return new g6.m();
    }

    public g6.p B() {
        i7.x xVar;
        g6.q qVar = (g6.q) this.f728j;
        if (qVar == null || (xVar = (i7.x) this.f729k) == null) {
            a.o("Cannot build without parameters and/or key material");
            return null;
        }
        if (qVar.f3790b != ((t6.a) xVar.f5179j).f8980a.length) {
            a.o("Key size mismatch");
            return null;
        }
        g6.j jVar = qVar.f3791c;
        g6.j jVar2 = g6.j.f3765k;
        if (jVar != jVar2 && ((Integer) this.f730l) == null) {
            a.o("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (jVar == jVar2 && ((Integer) this.f730l) != null) {
            a.o("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (jVar == jVar2) {
            t6.a.a(new byte[0]);
        } else if (jVar == g6.j.f3764j) {
            t6.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f730l).intValue()).array());
        } else {
            if (jVar != g6.j.f3763i) {
                a.t(((g6.q) this.f728j).f3791c, "Unknown AesGcmSivParameters.Variant: ");
                return null;
            }
            t6.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f730l).intValue()).array());
        }
        return new g6.p();
    }

    public n6.a C() {
        i7.x xVar;
        t6.a a9;
        n6.d dVar = (n6.d) this.f728j;
        if (dVar == null || (xVar = (i7.x) this.f729k) == null) {
            a.o("Cannot build without parameters and/or key material");
            return null;
        }
        if (dVar.f7456b != ((t6.a) xVar.f5179j).f8980a.length) {
            a.o("Key size mismatch");
            return null;
        }
        n6.c cVar = dVar.f7458d;
        n6.c cVar2 = n6.c.f7445f;
        if (cVar != cVar2 && ((Integer) this.f730l) == null) {
            a.o("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (cVar == cVar2 && ((Integer) this.f730l) != null) {
            a.o("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (cVar == cVar2) {
            a9 = t6.a.a(new byte[0]);
        } else if (cVar == n6.c.f7444e || cVar == n6.c.f7443d) {
            a9 = t6.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f730l).intValue()).array());
        } else {
            if (cVar != n6.c.f7442c) {
                a.t(((n6.d) this.f728j).f7458d, "Unknown AesCmacParametersParameters.Variant: ");
                return null;
            }
            a9 = t6.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f730l).intValue()).array());
        }
        return new n6.a((n6.d) this.f728j, a9);
    }

    public n6.d D() {
        Integer num = (Integer) this.f728j;
        if (num == null) {
            a.o("key size not set");
            return null;
        }
        if (((Integer) this.f729k) == null) {
            a.o("tag size not set");
            return null;
        }
        if (((n6.c) this.f730l) != null) {
            return new n6.d(num.intValue(), ((Integer) this.f729k).intValue(), (n6.c) this.f730l);
        }
        a.o("variant not set");
        return null;
    }

    public n6.i E() {
        i7.x xVar;
        t6.a a9;
        n6.j jVar = (n6.j) this.f728j;
        if (jVar == null || (xVar = (i7.x) this.f729k) == null) {
            a.o("Cannot build without parameters and/or key material");
            return null;
        }
        if (jVar.f7466b != ((t6.a) xVar.f5179j).f8980a.length) {
            a.o("Key size mismatch");
            return null;
        }
        n6.c cVar = jVar.f7468d;
        n6.c cVar2 = n6.c.f7453o;
        if (cVar != cVar2 && ((Integer) this.f730l) == null) {
            a.o("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (cVar == cVar2 && ((Integer) this.f730l) != null) {
            a.o("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (cVar == cVar2) {
            a9 = t6.a.a(new byte[0]);
        } else if (cVar == n6.c.f7452n || cVar == n6.c.f7451m) {
            a9 = t6.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f730l).intValue()).array());
        } else {
            if (cVar != n6.c.f7450l) {
                a.t(((n6.j) this.f728j).f7468d, "Unknown HmacParameters.Variant: ");
                return null;
            }
            a9 = t6.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f730l).intValue()).array());
        }
        return new n6.i((n6.j) this.f728j, a9);
    }

    public void F(d4.b bVar) {
        d4.a0 a0Var;
        synchronized (this) {
            ((HashMap) this.f728j).remove(bVar.f2794a);
            if (bVar.f2795b && (a0Var = bVar.f2796c) != null) {
                ((d4.n) this.f730l).f(bVar.f2794a, new d4.u(a0Var, true, false, bVar.f2794a, (d4.n) this.f730l));
            }
        }
    }

    public Bitmap G(BitmapFactory.Options options) {
        switch (this.f727i) {
            case 15:
                return BitmapFactory.decodeStream(new w4.a(w4.b.c((ByteBuffer) this.f728j)), null, options);
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                k4.x xVar = (k4.x) ((com.bumptech.glide.load.data.i) this.f728j).f1801j;
                xVar.reset();
                return BitmapFactory.decodeStream(xVar, null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((com.bumptech.glide.load.data.i) this.f730l).e().getFileDescriptor(), null, options);
        }
    }

    public void H(int i9) {
        d1 J;
        int V = V(i9);
        ((b2.d0) this.f729k).w(V);
        RecyclerView recyclerView = ((o3.f0) this.f728j).f7650a;
        View childAt = recyclerView.getChildAt(V);
        if (childAt != null && (J = RecyclerView.J(childAt)) != null) {
            if (J.j() && !J.o()) {
                throw new IllegalArgumentException("called detach on an already detached child " + J + recyclerView.z());
            }
            J.a(256);
        }
        recyclerView.detachViewFromParent(V);
    }

    public s I(String str) {
        n0 n0Var = (n0) ((HashMap) this.f729k).get(str);
        if (n0Var != null) {
            return n0Var.f802c;
        }
        return null;
    }

    public s J(String str) {
        for (n0 n0Var : ((HashMap) this.f729k).values()) {
            if (n0Var != null) {
                s sVar = n0Var.f802c;
                if (!str.equals(sVar.f846m)) {
                    sVar = sVar.B.f738c.J(str);
                }
                if (sVar != null) {
                    return sVar;
                }
            }
        }
        return null;
    }

    public ArrayList L() {
        ArrayList arrayList = new ArrayList();
        for (n0 n0Var : ((HashMap) this.f729k).values()) {
            if (n0Var != null) {
                arrayList.add(n0Var);
            }
        }
        return arrayList;
    }

    public View M(int i9) {
        return ((o3.f0) this.f728j).f7650a.getChildAt(V(i9));
    }

    public int N() {
        return ((o3.f0) this.f728j).f7650a.getChildCount() - ((ArrayList) this.f730l).size();
    }

    public ColorStateList O(int i9) {
        int resourceId;
        ColorStateList u3;
        TypedArray typedArray = (TypedArray) this.f729k;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0 || (u3 = a.a.u((Context) this.f728j, resourceId)) == null) ? typedArray.getColorStateList(i9) : u3;
    }

    public long P() {
        d2.j jVar = (d2.j) this.f730l;
        if (jVar != null) {
            return jVar.f2703l;
        }
        return -1L;
    }

    public Drawable Q(int i9) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f729k;
        return (!typedArray.hasValue(i9) || (resourceId = typedArray.getResourceId(i9, 0)) == 0) ? typedArray.getDrawable(i9) : android.support.v4.media.session.b.I((Context) this.f728j, resourceId);
    }

    public Drawable R(int i9) {
        int resourceId;
        Drawable g9;
        if (!((TypedArray) this.f729k).hasValue(i9) || (resourceId = ((TypedArray) this.f729k).getResourceId(i9, 0)) == 0) {
            return null;
        }
        n.t a9 = n.t.a();
        Context context = (Context) this.f728j;
        synchronized (a9) {
            g9 = a9.f7034a.g(context, resourceId, true);
        }
        return g9;
    }

    public Typeface S(int i9, int i10, v0 v0Var) {
        int resourceId = ((TypedArray) this.f729k).getResourceId(i9, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f730l) == null) {
            this.f730l = new TypedValue();
        }
        Context context = (Context) this.f728j;
        TypedValue typedValue = (TypedValue) this.f730l;
        ThreadLocal threadLocal = e0.o.f3001a;
        if (context.isRestricted()) {
            return null;
        }
        return e0.o.b(context, resourceId, typedValue, i10, v0Var, true, false);
    }

    public List T() {
        ArrayList arrayList;
        if (((ArrayList) this.f728j).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.f728j)) {
            arrayList = new ArrayList((ArrayList) this.f728j);
        }
        return arrayList;
    }

    public ImageHeaderParser$ImageType U() {
        switch (this.f727i) {
            case 15:
                return com.bumptech.glide.d.J((List) this.f729k, w4.b.c((ByteBuffer) this.f728j));
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                List list = (List) this.f730l;
                k4.x xVar = (k4.x) ((com.bumptech.glide.load.data.i) this.f728j).f1801j;
                xVar.reset();
                return com.bumptech.glide.d.I(list, xVar, (e4.f) this.f729k);
            default:
                List list2 = (List) this.f729k;
                com.bumptech.glide.load.data.i iVar = (com.bumptech.glide.load.data.i) this.f730l;
                e4.f fVar = (e4.f) this.f728j;
                int size = list2.size();
                for (int i9 = 0; i9 < size; i9++) {
                    b4.e eVar = (b4.e) list2.get(i9);
                    k4.x xVar2 = null;
                    try {
                        k4.x xVar3 = new k4.x(new FileInputStream(iVar.e().getFileDescriptor()), fVar);
                        try {
                            ImageHeaderParser$ImageType d9 = eVar.d(xVar3);
                            xVar3.b();
                            iVar.e();
                            if (d9 != ImageHeaderParser$ImageType.UNKNOWN) {
                                return d9;
                            }
                        } catch (Throwable th) {
                            th = th;
                            xVar2 = xVar3;
                            if (xVar2 != null) {
                                xVar2.b();
                            }
                            iVar.e();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public int V(int i9) {
        b2.d0 d0Var = (b2.d0) this.f729k;
        if (i9 < 0) {
            return -1;
        }
        int childCount = ((o3.f0) this.f728j).f7650a.getChildCount();
        int i10 = i9;
        while (i10 < childCount) {
            int r8 = i9 - (i10 - d0Var.r(i10));
            if (r8 == 0) {
                while (d0Var.u(i10)) {
                    i10++;
                }
                return i10;
            }
            i10 += r8;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object W(java.lang.Class r18) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.g.W(java.lang.Class):java.lang.Object");
    }

    public List X(byte[] bArr) {
        List list = (List) ((ConcurrentMap) this.f728j).get(new f6.l(bArr));
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public View Y(int i9) {
        return ((o3.f0) this.f728j).f7650a.getChildAt(i9);
    }

    public int Z() {
        return ((o3.f0) this.f728j).f7650a.getChildCount();
    }

    @Override // q0.g
    public ClipDescription a() {
        return (ClipDescription) this.f729k;
    }

    public boolean a0() {
        String trim;
        ArrayDeque arrayDeque = (ArrayDeque) this.f729k;
        if (((String) this.f730l) == null) {
            if (!arrayDeque.isEmpty()) {
                String str = (String) arrayDeque.poll();
                str.getClass();
                this.f730l = str;
                return true;
            }
            do {
                String readLine = ((BufferedReader) this.f728j).readLine();
                this.f730l = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f730l = trim;
            } while (trim.isEmpty());
        }
        return true;
    }

    @Override // s1.k
    public void b(int i9, j1.a aVar, long j5, int i10) {
        ((MediaCodec) this.f728j).queueSecureInputBuffer(i9, 0, aVar.f5355i, j5, i10);
    }

    public void b0(View view) {
        ((ArrayList) this.f730l).add(view);
        o3.f0 f0Var = (o3.f0) this.f728j;
        d1 J = RecyclerView.J(view);
        if (J != null) {
            View view2 = J.f7618a;
            RecyclerView recyclerView = f0Var.f7650a;
            int i9 = J.f7633q;
            if (i9 != -1) {
                J.f7632p = i9;
            } else {
                WeakHashMap weakHashMap = n0.t0.f7209a;
                J.f7632p = n0.c0.c(view2);
            }
            if (recyclerView.M()) {
                J.f7633q = 4;
                recyclerView.B0.add(J);
            } else {
                WeakHashMap weakHashMap2 = n0.t0.f7209a;
                n0.c0.s(view2, 4);
            }
        }
    }

    @Override // i3.z
    public void c(g1.p pVar) {
        long d9;
        g1.a.l((g1.u) this.f729k);
        int i9 = g1.w.f3713a;
        g1.u uVar = (g1.u) this.f729k;
        synchronized (uVar) {
            try {
                long j5 = uVar.f3711c;
                d9 = j5 != -9223372036854775807L ? j5 + uVar.f3710b : uVar.d();
            } finally {
            }
        }
        long e9 = ((g1.u) this.f729k).e();
        if (d9 == -9223372036854775807L || e9 == -9223372036854775807L) {
            return;
        }
        d1.s sVar = (d1.s) this.f728j;
        if (e9 != sVar.f2558q) {
            d1.r a9 = sVar.a();
            a9.f2532p = e9;
            d1.s sVar2 = new d1.s(a9);
            this.f728j = sVar2;
            ((d2.d0) this.f730l).e(sVar2);
        }
        int a10 = pVar.a();
        ((d2.d0) this.f730l).c(a10, pVar);
        ((d2.d0) this.f730l).d(d9, 1, a10, 0, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a6, code lost:
    
        if (r1.f2703l != r11) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00a9, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00d0, code lost:
    
        if (r1.f2703l != r11) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:8:0x0016, B:10:0x002b, B:13:0x0032, B:14:0x003a, B:16:0x0041, B:17:0x0049, B:20:0x0051, B:23:0x0057, B:26:0x005d, B:28:0x0060, B:32:0x0063, B:33:0x006a, B:35:0x0070), top: B:7:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:8:0x0016, B:10:0x002b, B:13:0x0032, B:14:0x003a, B:16:0x0041, B:17:0x0049, B:20:0x0051, B:23:0x0057, B:26:0x005d, B:28:0x0060, B:32:0x0063, B:33:0x006a, B:35:0x0070), top: B:7:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070 A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #0 {all -> 0x0045, blocks: (B:8:0x0016, B:10:0x002b, B:13:0x0032, B:14:0x003a, B:16:0x0041, B:17:0x0049, B:20:0x0051, B:23:0x0057, B:26:0x005d, B:28:0x0060, B:32:0x0063, B:33:0x006a, B:35:0x0070), top: B:7:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c0(i1.h r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, v1.m0 r15) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.g.c0(i1.h, android.net.Uri, java.util.Map, long, long, v1.m0):void");
    }

    @Override // s1.k
    public void d(long j5, int i9, int i10, int i11) {
        ((MediaCodec) this.f728j).queueInputBuffer(i9, 0, i10, j5, i11);
    }

    public void d0(n0 n0Var) {
        s sVar = n0Var.f802c;
        String str = sVar.f846m;
        HashMap hashMap = (HashMap) this.f729k;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(sVar.f846m, n0Var);
        if (h0.D(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + sVar);
        }
    }

    @Override // s1.k
    public int e(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        MediaCodec mediaCodec = (MediaCodec) this.f728j;
        do {
            dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3 && g1.w.f3713a < 21) {
                this.f730l = mediaCodec.getOutputBuffers();
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public void e0(n0 n0Var) {
        s sVar = n0Var.f802c;
        if (sVar.I) {
            ((j0) this.f730l).b(sVar);
        }
        if (((n0) ((HashMap) this.f729k).put(sVar.f846m, null)) != null && h0.D(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + sVar);
        }
    }

    @Override // i3.z
    public void f(g1.u uVar, d2.o oVar, i3.e0 e0Var) {
        this.f729k = uVar;
        e0Var.a();
        e0Var.b();
        d2.d0 l4 = oVar.l(e0Var.f4483d, 5);
        this.f730l = l4;
        l4.e((d1.s) this.f728j);
    }

    public String f0() {
        if (!a0()) {
            throw new NoSuchElementException();
        }
        String str = (String) this.f730l;
        this.f730l = null;
        return str;
    }

    @Override // s1.k
    public void flush() {
        ((MediaCodec) this.f728j).flush();
    }

    @Override // z2.f
    public int g(long j5) {
        long[] jArr = (long[]) this.f730l;
        int b9 = g1.w.b(j5, jArr, false);
        if (b9 < jArr.length) {
            return b9;
        }
        return -1;
    }

    @Override // s1.k
    public ByteBuffer getInputBuffer(int i9) {
        return g1.w.f3713a >= 21 ? ((MediaCodec) this.f728j).getInputBuffer(i9) : ((ByteBuffer[]) this.f729k)[i9];
    }

    @Override // s1.k
    public ByteBuffer getOutputBuffer(int i9) {
        return g1.w.f3713a >= 21 ? ((MediaCodec) this.f728j).getOutputBuffer(i9) : ((ByteBuffer[]) this.f730l)[i9];
    }

    @Override // s1.k
    public MediaFormat getOutputFormat() {
        return ((MediaCodec) this.f728j).getOutputFormat();
    }

    @Override // s1.k
    public void h(b2.m mVar, Handler handler) {
        ((MediaCodec) this.f728j).setOnFrameRenderedListener(new s1.a(this, mVar, 1), handler);
    }

    @Override // s1.k
    public void i(int i9) {
        ((MediaCodec) this.f728j).setVideoScalingMode(i9);
    }

    public void i0() {
        ((TypedArray) this.f729k).recycle();
    }

    @Override // z2.f
    public long j(int i9) {
        long[] jArr = (long[]) this.f730l;
        g1.a.f(i9 >= 0);
        g1.a.f(i9 < jArr.length);
        return jArr[i9];
    }

    public void j0(int i9) {
        if (i9 != 16 && i9 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i9 * 8)));
        }
        this.f728j = Integer.valueOf(i9);
    }

    @Override // p4.a
    public d4.a0 k(d4.a0 a0Var, b4.i iVar) {
        Drawable drawable = (Drawable) a0Var.get();
        if (drawable instanceof BitmapDrawable) {
            return ((d4.i) this.f729k).k(k4.d.b(((BitmapDrawable) drawable).getBitmap(), (e4.a) this.f728j), iVar);
        }
        if (drawable instanceof o4.c) {
            return ((p4.d) this.f730l).k(a0Var, iVar);
        }
        return null;
    }

    @Override // q0.g
    public Object l() {
        return null;
    }

    @Override // q0.g
    public Uri m() {
        return (Uri) this.f728j;
    }

    public void m0(View view) {
        if (((ArrayList) this.f730l).remove(view)) {
            o3.f0 f0Var = (o3.f0) this.f728j;
            d1 J = RecyclerView.J(view);
            if (J != null) {
                RecyclerView recyclerView = f0Var.f7650a;
                int i9 = J.f7632p;
                if (recyclerView.M()) {
                    J.f7633q = i9;
                    recyclerView.B0.add(J);
                } else {
                    View view2 = J.f7618a;
                    WeakHashMap weakHashMap = n0.t0.f7209a;
                    n0.c0.s(view2, i9);
                }
                J.f7632p = 0;
            }
        }
    }

    @Override // s1.k
    public void o(Surface surface) {
        ((MediaCodec) this.f728j).setOutputSurface(surface);
    }

    @Override // j0.c
    public void onCancel() {
        View view = (View) this.f728j;
        view.clearAnimation();
        ((ViewGroup) this.f729k).endViewTransition(view);
        ((h) this.f730l).d();
    }

    @Override // q0.g
    public Uri p() {
        return (Uri) this.f730l;
    }

    @Override // z2.f
    public List q(long j5) {
        List list = (List) this.f728j;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i9 = 0; i9 < list.size(); i9++) {
            long[] jArr = (long[]) this.f729k;
            int i10 = i9 * 2;
            if (jArr[i10] <= j5 && j5 < jArr[i10 + 1]) {
                h3.c cVar = (h3.c) list.get(i9);
                f1.b bVar = cVar.f3932a;
                if (bVar.f3247e == -3.4028235E38f) {
                    arrayList2.add(cVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new a3.d(2));
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            f1.a a9 = ((h3.c) arrayList2.get(i11)).f3932a.a();
            a9.f3222e = (-1) - i11;
            a9.f3223f = 1;
            arrayList.add(a9.a());
        }
        return arrayList;
    }

    @Override // s1.k
    public void r(int i9, long j5) {
        ((MediaCodec) this.f728j).releaseOutputBuffer(i9, j5);
    }

    @Override // s1.k
    public void release() {
        this.f729k = null;
        this.f730l = null;
        ((MediaCodec) this.f728j).release();
    }

    @Override // s1.k
    public void releaseOutputBuffer(int i9, boolean z8) {
        ((MediaCodec) this.f728j).releaseOutputBuffer(i9, z8);
    }

    @Override // s1.k
    public int s() {
        return ((MediaCodec) this.f728j).dequeueInputBuffer(0L);
    }

    @Override // s1.k
    public void setParameters(Bundle bundle) {
        ((MediaCodec) this.f728j).setParameters(bundle);
    }

    @Override // q6.a
    public byte[] t(byte[] bArr, int i9) {
        byte[] Y;
        if (i9 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        if (!androidx.activity.g.d(1)) {
            a.o("Can not use AES-CMAC in FIPS-mode.");
            return null;
        }
        Cipher cipher = (Cipher) s6.i.f8884b.f8886a.a("AES/ECB/NoPadding");
        cipher.init(1, (SecretKeySpec) this.f728j);
        int max = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
        if (max * 16 == bArr.length) {
            Y = a.a.X(bArr, (max - 1) * 16, (byte[]) this.f729k, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) * 16, bArr.length);
            if (copyOfRange.length >= 16) {
                m7.c.n("x must be smaller than a block.");
                return null;
            }
            byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
            copyOf[copyOfRange.length] = Byte.MIN_VALUE;
            Y = a.a.Y(copyOf, (byte[]) this.f730l);
        }
        byte[] bArr2 = new byte[16];
        for (int i10 = 0; i10 < max - 1; i10++) {
            bArr2 = cipher.doFinal(a.a.X(bArr2, 0, bArr, i10 * 16, 16));
        }
        return Arrays.copyOf(cipher.doFinal(a.a.Y(Y, bArr2)), i9);
    }

    public String toString() {
        switch (this.f727i) {
            case 7:
                return f6.o.a((f1) this.f728j).toString();
            case 23:
                return ((b2.d0) this.f729k).toString() + ", hidden list:" + ((ArrayList) this.f730l).size();
            default:
                return super.toString();
        }
    }

    @Override // z2.f
    public int u() {
        return ((long[]) this.f730l).length;
    }

    public synchronized void v(b4.f fVar, d4.u uVar) {
        d4.b bVar = (d4.b) ((HashMap) this.f728j).put(fVar, new d4.b(fVar, uVar, (ReferenceQueue) this.f729k));
        if (bVar != null) {
            bVar.f2796c = null;
            bVar.clear();
        }
    }

    public void w(s sVar) {
        if (((ArrayList) this.f728j).contains(sVar)) {
            a.r(sVar, "Fragment already added: ");
            return;
        }
        synchronized (((ArrayList) this.f728j)) {
            ((ArrayList) this.f728j).add(sVar);
        }
        sVar.f852s = true;
    }

    public void x(View view, int i9, boolean z8) {
        RecyclerView recyclerView = ((o3.f0) this.f728j).f7650a;
        int childCount = i9 < 0 ? recyclerView.getChildCount() : V(i9);
        ((b2.d0) this.f729k).v(childCount, z8);
        if (z8) {
            b0(view);
        }
        recyclerView.addView(view, childCount);
        RecyclerView.J(view);
    }

    public void y(View view, int i9, ViewGroup.LayoutParams layoutParams, boolean z8) {
        RecyclerView recyclerView = ((o3.f0) this.f728j).f7650a;
        int childCount = i9 < 0 ? recyclerView.getChildCount() : V(i9);
        ((b2.d0) this.f729k).v(childCount, z8);
        if (z8) {
            b0(view);
        }
        d1 J = RecyclerView.J(view);
        if (J != null) {
            if (!J.j() && !J.o()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + J + recyclerView.z());
            }
            J.f7626j &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public g6.i z() {
        i7.x xVar;
        g6.k kVar = (g6.k) this.f728j;
        if (kVar == null || (xVar = (i7.x) this.f729k) == null) {
            a.o("Cannot build without parameters and/or key material");
            return null;
        }
        if (kVar.f3774b != ((t6.a) xVar.f5179j).f8980a.length) {
            a.o("Key size mismatch");
            return null;
        }
        g6.j jVar = kVar.f3777e;
        g6.j jVar2 = g6.j.f3760e;
        if (jVar != jVar2 && ((Integer) this.f730l) == null) {
            a.o("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (jVar == jVar2 && ((Integer) this.f730l) != null) {
            a.o("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (jVar == jVar2) {
            t6.a.a(new byte[0]);
        } else if (jVar == g6.j.f3759d) {
            t6.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f730l).intValue()).array());
        } else {
            if (jVar != g6.j.f3758c) {
                a.t(((g6.k) this.f728j).f3777e, "Unknown AesEaxParameters.Variant: ");
                return null;
            }
            t6.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f730l).intValue()).array());
        }
        return new g6.i();
    }

    private final void k0() {
    }

    private final void l0() {
    }

    @Override // q0.g
    public void n() {
    }

    public /* synthetic */ g(Object obj, Object obj2, Object obj3, int i9) {
        this.f727i = i9;
        this.f728j = obj;
        this.f729k = obj2;
        this.f730l = obj3;
    }

    public g(MainActivity mainActivity) {
        this.f727i = 2;
        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("live_filter_prefs", 0);
        sharedPreferences.getClass();
        this.f728j = sharedPreferences;
        this.f729k = "hidden_chats";
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f730l = linkedHashSet;
        Set<String> stringSet = sharedPreferences.getStringSet("hidden_chats", o7.r.f8015i);
        if (stringSet != null) {
            linkedHashSet.addAll(stringSet);
        }
    }

    public g(int i9) {
        this.f727i = i9;
        switch (i9) {
            case 3:
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new d4.a(0));
                this.f728j = new HashMap();
                this.f729k = new ReferenceQueue();
                newSingleThreadExecutor.execute(new androidx.activity.j(this, 6));
                break;
            default:
                this.f728j = new ArrayList();
                this.f729k = new HashMap();
                break;
        }
    }

    public /* synthetic */ g(int i9, boolean z8) {
        this.f727i = i9;
    }

    public g(String str) {
        this.f727i = 14;
        d1.r rVar = new d1.r();
        rVar.f2528l = d1.l0.k(str);
        this.f728j = new d1.s(rVar);
    }

    public g(o3.f0 f0Var) {
        this.f727i = 23;
        this.f728j = f0Var;
        this.f729k = new b2.d0(5);
        this.f730l = new ArrayList();
    }

    public g(d2.k kVar) {
        this.f727i = 29;
        this.f728j = kVar;
    }

    public g(byte[] bArr) {
        this.f727i = 28;
        s6.m.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f728j = secretKeySpec;
        if (androidx.activity.g.d(1)) {
            Cipher cipher = (Cipher) s6.i.f8884b.f8886a.a("AES/ECB/NoPadding");
            cipher.init(1, secretKeySpec);
            byte[] p5 = com.bumptech.glide.c.p(cipher.doFinal(new byte[16]));
            this.f729k = p5;
            this.f730l = com.bumptech.glide.c.p(p5);
            return;
        }
        a.o("Can not use AES-CMAC in FIPS-mode.");
        throw null;
    }

    public g(Context context, TypedArray typedArray) {
        this.f727i = 18;
        this.f728j = context;
        this.f729k = typedArray;
    }

    public g(Context context, LocationManager locationManager) {
        this.f727i = 9;
        this.f730l = new g.m0();
        this.f728j = context;
        this.f729k = locationManager;
    }

    public g(MediaCodec mediaCodec) {
        this.f727i = 27;
        this.f728j = mediaCodec;
        if (g1.w.f3713a < 21) {
            this.f729k = mediaCodec.getInputBuffers();
            this.f730l = mediaCodec.getOutputBuffers();
        }
    }

    public g(e1.d[] dVarArr) {
        this.f727i = 19;
        u0 u0Var = new u0();
        e1.g gVar = new e1.g();
        gVar.f3052c = 1.0f;
        gVar.f3053d = 1.0f;
        e1.b bVar = e1.b.f3018e;
        gVar.f3054e = bVar;
        gVar.f3055f = bVar;
        gVar.f3056g = bVar;
        gVar.h = bVar;
        ByteBuffer byteBuffer = e1.d.f3023a;
        gVar.f3059k = byteBuffer;
        gVar.f3060l = byteBuffer.asShortBuffer();
        gVar.f3061m = byteBuffer;
        gVar.f3051b = -1;
        e1.d[] dVarArr2 = new e1.d[dVarArr.length + 2];
        this.f728j = dVarArr2;
        System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
        this.f729k = u0Var;
        this.f730l = gVar;
        dVarArr2[dVarArr.length] = u0Var;
        dVarArr2[dVarArr.length + 1] = gVar;
    }

    public g(w4.k kVar, ArrayList arrayList, e4.f fVar) {
        this.f727i = 16;
        w4.f.c(fVar, "Argument must not be null");
        this.f729k = fVar;
        w4.f.c(arrayList, "Argument must not be null");
        this.f730l = arrayList;
        this.f728j = new com.bumptech.glide.load.data.i(kVar, fVar);
    }

    public g(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, e4.f fVar) {
        this.f727i = 17;
        w4.f.c(fVar, "Argument must not be null");
        this.f728j = fVar;
        w4.f.c(arrayList, "Argument must not be null");
        this.f729k = arrayList;
        this.f730l = new com.bumptech.glide.load.data.i(parcelFileDescriptor);
    }

    public g(ConcurrentMap concurrentMap, f6.k kVar, p6.a aVar, Class cls) {
        this.f727i = 8;
        this.f728j = concurrentMap;
        this.f729k = kVar;
        this.f730l = aVar;
    }

    public g(d4.n nVar, s4.f fVar, d4.r rVar) {
        this.f727i = 6;
        this.f730l = nVar;
        this.f729k = fVar;
        this.f728j = rVar;
    }

    public g(f1 f1Var, List list) {
        this.f727i = 7;
        this.f728j = f1Var;
        this.f729k = list;
        this.f730l = p6.a.f8254b;
    }

    public g(ArrayDeque arrayDeque, BufferedReader bufferedReader) {
        this.f727i = 26;
        this.f729k = arrayDeque;
        this.f728j = bufferedReader;
    }
}
