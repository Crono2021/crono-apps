package g1;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.crypto.Mac;
import n.o3;
import n.r1;
import n0.t0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o implements q6.a {

    /* renamed from: m, reason: collision with root package name */
    public static o f3691m;

    /* renamed from: i, reason: collision with root package name */
    public int f3692i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f3693j;

    /* renamed from: k, reason: collision with root package name */
    public Object f3694k;

    /* renamed from: l, reason: collision with root package name */
    public Object f3695l;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        if (r4.equals("HMACSHA256") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o(java.lang.String r4, javax.crypto.spec.SecretKeySpec r5) {
        /*
            r3 = this;
            r3.<init>()
            s6.j r0 = new s6.j
            r0.<init>(r3)
            r3.f3693j = r0
            r1 = 2
            boolean r2 = androidx.activity.g.e(r1)
            if (r2 == 0) goto L8f
            r3.f3694k = r4
            r3.f3695l = r5
            byte[] r5 = r5.getEncoded()
            int r5 = r5.length
            r2 = 16
            if (r5 < r2) goto L87
            int r5 = r4.hashCode()
            r2 = -1
            switch(r5) {
                case -1823053428: goto L52;
                case 392315023: goto L47;
                case 392315118: goto L3e;
                case 392316170: goto L33;
                case 392317873: goto L28;
                default: goto L26;
            }
        L26:
            r1 = -1
            goto L5c
        L28:
            java.lang.String r5 = "HMACSHA512"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L31
            goto L26
        L31:
            r1 = 4
            goto L5c
        L33:
            java.lang.String r5 = "HMACSHA384"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L3c
            goto L26
        L3c:
            r1 = 3
            goto L5c
        L3e:
            java.lang.String r5 = "HMACSHA256"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L5c
            goto L26
        L47:
            java.lang.String r5 = "HMACSHA224"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L50
            goto L26
        L50:
            r1 = 1
            goto L5c
        L52:
            java.lang.String r5 = "HMACSHA1"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L5b
            goto L26
        L5b:
            r1 = 0
        L5c:
            switch(r1) {
                case 0: goto L7f;
                case 1: goto L7a;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L6b;
                default: goto L5f;
            }
        L5f:
            java.security.NoSuchAlgorithmException r5 = new java.security.NoSuchAlgorithmException
            java.lang.String r0 = "unknown Hmac algorithm: "
            java.lang.String r4 = r0.concat(r4)
            r5.<init>(r4)
            throw r5
        L6b:
            r4 = 64
            r3.f3692i = r4
            goto L83
        L70:
            r4 = 48
            r3.f3692i = r4
            goto L83
        L75:
            r4 = 32
            r3.f3692i = r4
            goto L83
        L7a:
            r4 = 28
            r3.f3692i = r4
            goto L83
        L7f:
            r4 = 20
            r3.f3692i = r4
        L83:
            r0.get()
            return
        L87:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r5 = "key size too small, need at least 16 bytes"
            r4.<init>(r5)
            throw r4
        L8f:
            java.lang.String r4 = "Can not use HMAC in FIPS-mode, as BoringCrypto module is not available."
            androidx.fragment.app.a.o(r4)
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.o.<init>(java.lang.String, javax.crypto.spec.SecretKeySpec):void");
    }

    public static void a(int i9, o oVar) {
        synchronized (oVar.f3695l) {
            try {
                if (oVar.f3692i == i9) {
                    return;
                }
                oVar.f3692i = i9;
                Iterator it = ((CopyOnWriteArrayList) oVar.f3694k).iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    z1.e eVar = (z1.e) weakReference.get();
                    if (eVar != null) {
                        eVar.a(i9);
                    } else {
                        ((CopyOnWriteArrayList) oVar.f3694k).remove(weakReference);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized o c(Context context) {
        o oVar;
        synchronized (o.class) {
            try {
                if (f3691m == null) {
                    f3691m = new o(context);
                }
                oVar = f3691m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    public void b() {
        ImageView imageView = (ImageView) this.f3693j;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            r1.a(drawable);
        }
        if (drawable != null) {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 <= 21 && i9 == 21) {
                if (((o3) this.f3695l) == null) {
                    this.f3695l = new o3();
                }
                o3 o3Var = (o3) this.f3695l;
                o3Var.f6991a = null;
                o3Var.f6994d = false;
                o3Var.f6992b = null;
                o3Var.f6993c = false;
                ColorStateList a9 = r0.f.a(imageView);
                if (a9 != null) {
                    o3Var.f6994d = true;
                    o3Var.f6991a = a9;
                }
                PorterDuff.Mode b9 = r0.f.b(imageView);
                if (b9 != null) {
                    o3Var.f6993c = true;
                    o3Var.f6992b = b9;
                }
                if (o3Var.f6994d || o3Var.f6993c) {
                    n.t.e(drawable, o3Var, imageView.getDrawableState());
                    return;
                }
            }
            o3 o3Var2 = (o3) this.f3694k;
            if (o3Var2 != null) {
                n.t.e(drawable, o3Var2, imageView.getDrawableState());
            }
        }
    }

    public int d() {
        int i9;
        synchronized (this.f3695l) {
            i9 = this.f3692i;
        }
        return i9;
    }

    public int e() {
        int i9 = this.f3692i;
        if (i9 == 2) {
            return IjkMediaMeta.FF_PROFILE_H264_INTRA;
        }
        if (i9 != 3) {
            return 0;
        }
        return IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED;
    }

    public void f(AttributeSet attributeSet, int i9) {
        Drawable drawable;
        Drawable drawable2;
        int resourceId;
        ImageView imageView = (ImageView) this.f3693j;
        Context context = imageView.getContext();
        int[] iArr = f.a.f3171f;
        androidx.fragment.app.g g02 = androidx.fragment.app.g.g0(context, attributeSet, iArr, i9);
        TypedArray typedArray = (TypedArray) g02.f729k;
        t0.o(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) g02.f729k, i9);
        try {
            Drawable drawable3 = imageView.getDrawable();
            if (drawable3 == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable3 = android.support.v4.media.session.b.I(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                r1.a(drawable3);
            }
            if (typedArray.hasValue(2)) {
                r0.f.c(imageView, g02.O(2));
                if (Build.VERSION.SDK_INT == 21 && (drawable2 = imageView.getDrawable()) != null && r0.f.a(imageView) != null) {
                    if (drawable2.isStateful()) {
                        drawable2.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable2);
                }
            }
            if (typedArray.hasValue(3)) {
                r0.f.d(imageView, r1.c(typedArray.getInt(3, -1), null));
                if (Build.VERSION.SDK_INT == 21 && (drawable = imageView.getDrawable()) != null && r0.f.a(imageView) != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
            g02.i0();
        } catch (Throwable th) {
            g02.i0();
            throw th;
        }
    }

    @Override // q6.a
    public byte[] t(byte[] bArr, int i9) {
        s6.j jVar = (s6.j) this.f3693j;
        if (i9 > this.f3692i) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) jVar.get()).update(bArr);
        return Arrays.copyOf(((Mac) jVar.get()).doFinal(), i9);
    }

    public o(ImageView imageView) {
        this.f3692i = 0;
        this.f3693j = imageView;
    }

    public o(Context context) {
        this.f3693j = new Handler(Looper.getMainLooper());
        this.f3694k = new CopyOnWriteArrayList();
        this.f3695l = new Object();
        this.f3692i = 0;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new com.bumptech.glide.manager.p(this, 2), intentFilter);
    }

    public o(int i9, String str, int i10, ArrayList arrayList, byte[] bArr) {
        List unmodifiableList;
        this.f3693j = str;
        this.f3692i = i10;
        if (arrayList == null) {
            unmodifiableList = Collections.EMPTY_LIST;
        } else {
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        this.f3694k = unmodifiableList;
        this.f3695l = bArr;
    }
}
