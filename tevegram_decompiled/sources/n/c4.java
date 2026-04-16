package n;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c4 {

    /* renamed from: a, reason: collision with root package name */
    public Object f6834a = null;

    /* renamed from: b, reason: collision with root package name */
    public Object f6835b = null;

    /* renamed from: c, reason: collision with root package name */
    public Object f6836c = null;

    /* renamed from: d, reason: collision with root package name */
    public Object f6837d = null;

    /* renamed from: e, reason: collision with root package name */
    public Object f6838e = null;

    /* renamed from: f, reason: collision with root package name */
    public Object f6839f = null;

    /* renamed from: g, reason: collision with root package name */
    public Object f6840g;

    public static f6.f c(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            r6.f1 D = r6.f1.D(byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.q.a());
            byteArrayInputStream.close();
            return new f6.f((r6.c1) ((r6.f1) androidx.fragment.app.g.K(D).f728j).v(), 3);
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    public synchronized l6.a a() {
        byte[] bArr;
        l6.a aVar;
        try {
            if (((String) this.f6835b) == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            synchronized (l6.a.f6266b) {
                try {
                    Context context = (Context) this.f6834a;
                    String str = (String) this.f6835b;
                    String str2 = (String) this.f6836c;
                    if (str != null) {
                        Context applicationContext = context.getApplicationContext();
                        SharedPreferences defaultSharedPreferences = str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0);
                        bArr = null;
                        try {
                            String string = defaultSharedPreferences.getString(str, null);
                            if (string != null) {
                                bArr = android.support.v4.media.session.b.C(string);
                            }
                        } catch (ClassCastException | IllegalArgumentException unused) {
                            throw new CharConversionException(androidx.activity.g.n("can't read keyset; the pref value ", str, " is not a valid hex string"));
                        }
                    } else {
                        m7.c.n("keysetName cannot be null");
                        bArr = null;
                    }
                    String str3 = (String) this.f6837d;
                    if (bArr == null) {
                        if (str3 != null) {
                            this.f6838e = e();
                        }
                        this.f6840g = b();
                    } else {
                        if (str3 != null) {
                            if (Build.VERSION.SDK_INT >= 23) {
                                this.f6840g = d(bArr);
                            }
                        }
                        this.f6840g = c(bArr);
                    }
                    aVar = new l6.a(this);
                } finally {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    public f6.f b() {
        if (((f6.g) this.f6839f) == null) {
            androidx.fragment.app.a.o("cannot read or generate keyset");
            return null;
        }
        f6.f fVar = new f6.f(r6.f1.C(), 3);
        f6.g gVar = (f6.g) this.f6839f;
        synchronized (fVar) {
            fVar.a(gVar.f3424a);
        }
        fVar.h(f6.o.a((r6.f1) fVar.c().f728j).y().A());
        Context context = (Context) this.f6834a;
        String str = (String) this.f6835b;
        String str2 = (String) this.f6836c;
        if (str == null) {
            m7.c.n("keysetName cannot be null");
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        SharedPreferences.Editor edit = str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext).edit() : applicationContext.getSharedPreferences(str2, 0).edit();
        if (((l6.b) this.f6838e) != null) {
            androidx.fragment.app.g c9 = fVar.c();
            l6.b bVar = (l6.b) this.f6838e;
            byte[] bArr = new byte[0];
            r6.f1 f1Var = (r6.f1) c9.f728j;
            byte[] a9 = bVar.a(f1Var.e(), bArr);
            try {
                if (!r6.f1.E(bVar.b(a9, bArr), com.google.crypto.tink.shaded.protobuf.q.a()).equals(f1Var)) {
                    throw new GeneralSecurityException("cannot encrypt keyset");
                }
                r6.m0 z8 = r6.n0.z();
                com.google.crypto.tink.shaded.protobuf.i h = com.google.crypto.tink.shaded.protobuf.j.h(0, a9.length, a9);
                z8.e();
                r6.n0.w((r6.n0) z8.f2326j, h);
                r6.j1 a10 = f6.o.a(f1Var);
                z8.e();
                r6.n0.x((r6.n0) z8.f2326j, a10);
                if (!edit.putString(str, android.support.v4.media.session.b.F(((r6.n0) z8.b()).e())).commit()) {
                    throw new IOException("Failed to write to SharedPreferences");
                }
            } catch (com.google.crypto.tink.shaded.protobuf.e0 unused) {
                androidx.fragment.app.a.o("invalid keyset, corrupted key material");
                return null;
            }
        } else if (!edit.putString(str, android.support.v4.media.session.b.F(((r6.f1) fVar.c().f728j).e())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
        return fVar;
    }

    public f6.f d(byte[] bArr) {
        try {
            this.f6838e = new l6.c().c((String) this.f6837d);
            try {
                return new f6.f((r6.c1) ((r6.f1) androidx.fragment.app.g.h0(new f6.f(new ByteArrayInputStream(bArr), 1), (l6.b) this.f6838e).f728j).v(), 3);
            } catch (IOException | GeneralSecurityException e9) {
                try {
                    return c(bArr);
                } catch (IOException unused) {
                    throw e9;
                }
            }
        } catch (GeneralSecurityException | ProviderException e10) {
            try {
                f6.f c9 = c(bArr);
                Log.w("a", "cannot use Android Keystore, it'll be disabled", e10);
                return c9;
            } catch (IOException unused2) {
                throw e10;
            }
        }
    }

    public l6.b e() {
        if (Build.VERSION.SDK_INT < 23) {
            Log.w("a", "Android Keystore requires at least Android M");
            return null;
        }
        l6.c cVar = new l6.c();
        try {
            boolean a9 = l6.c.a((String) this.f6837d);
            try {
                return cVar.c((String) this.f6837d);
            } catch (GeneralSecurityException | ProviderException e9) {
                if (!a9) {
                    throw new KeyStoreException(androidx.activity.g.n("the master key ", (String) this.f6837d, " exists but is unusable"), e9);
                }
                Log.w("a", "cannot use Android Keystore, it'll be disabled", e9);
                return null;
            }
        } catch (GeneralSecurityException | ProviderException e10) {
            Log.w("a", "cannot use Android Keystore, it'll be disabled", e10);
            return null;
        }
    }
}
