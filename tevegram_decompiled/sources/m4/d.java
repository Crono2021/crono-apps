package m4;

import android.content.Context;
import android.net.Uri;
import b4.h;
import b4.i;
import b4.k;
import d4.a0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements k {

    /* renamed from: b, reason: collision with root package name */
    public static final h f6645b = new h("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme", null, h.f1326e);

    /* renamed from: a, reason: collision with root package name */
    public final Context f6646a;

    public d(Context context) {
        this.f6646a = context.getApplicationContext();
    }

    @Override // b4.k
    public final /* bridge */ /* synthetic */ a0 a(Object obj, int i9, int i10, i iVar) {
        return c((Uri) obj, iVar);
    }

    @Override // b4.k
    public final boolean b(Object obj, i iVar) {
        String scheme = ((Uri) obj).getScheme();
        return scheme != null && scheme.equals("android.resource");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d4.a0 c(android.net.Uri r9, b4.i r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getAuthority()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto Ld2
            android.content.Context r1 = r8.f6646a
            java.lang.String r2 = r1.getPackageName()
            boolean r2 = r0.equals(r2)
            r3 = 0
            if (r2 == 0) goto L19
        L17:
            r2 = r1
            goto L2a
        L19:
            android.content.Context r2 = r1.createPackageContext(r0, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1e
            goto L2a
        L1e:
            r2 = move-exception
            java.lang.String r4 = r1.getPackageName()
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto Lbe
            goto L17
        L2a:
            java.util.List r4 = r9.getPathSegments()
            int r5 = r4.size()
            r6 = 2
            r7 = 1
            if (r5 != r6) goto L68
            java.util.List r4 = r9.getPathSegments()
            java.lang.String r5 = r9.getAuthority()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r4.get(r7)
            java.lang.String r4 = (java.lang.String) r4
            android.content.res.Resources r6 = r2.getResources()
            int r5 = r6.getIdentifier(r4, r3, r5)
            if (r5 != 0) goto L5e
            android.content.res.Resources r5 = android.content.res.Resources.getSystem()
            java.lang.String r6 = "android"
            int r5 = r5.getIdentifier(r4, r3, r6)
        L5e:
            if (r5 == 0) goto L61
            goto L7e
        L61:
            java.lang.String r10 = "Failed to find resource id for: "
            androidx.fragment.app.a.n(r9, r10)
        L66:
            r9 = 0
            return r9
        L68:
            int r4 = r4.size()
            java.lang.String r5 = "Unrecognized Uri format: "
            if (r4 != r7) goto Lba
            java.util.List r4 = r9.getPathSegments()
            java.lang.Object r3 = r4.get(r3)     // Catch: java.lang.NumberFormatException -> La7
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.NumberFormatException -> La7
            int r5 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> La7
        L7e:
            java.lang.String r9 = r1.getPackageName()
            boolean r9 = r0.equals(r9)
            r0 = 0
            if (r9 == 0) goto L92
            b4.h r9 = m4.d.f6645b
            java.lang.Object r9 = r10.c(r9)
            android.content.res.Resources$Theme r9 = (android.content.res.Resources.Theme) r9
            goto L93
        L92:
            r9 = r0
        L93:
            if (r9 != 0) goto L9a
            android.graphics.drawable.Drawable r9 = com.bumptech.glide.c.x(r1, r2, r5, r0)
            goto L9e
        L9a:
            android.graphics.drawable.Drawable r9 = com.bumptech.glide.c.x(r1, r1, r5, r9)
        L9e:
            if (r9 == 0) goto La6
            m4.c r0 = new m4.c
            r10 = 0
            r0.<init>(r9, r10)
        La6:
            return r0
        La7:
            r10 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9, r10)
            throw r0
        Lba:
            androidx.fragment.app.a.n(r9, r5)
            goto L66
        Lbe:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to obtain context or unrecognized Uri format for: "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9, r2)
            throw r10
        Ld2:
            java.lang.String r10 = "Package name for "
            java.lang.String r0 = " is null or empty"
            androidx.fragment.app.a.f(r9, r0, r10)
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.d.c(android.net.Uri, b4.i):d4.a0");
    }
}
