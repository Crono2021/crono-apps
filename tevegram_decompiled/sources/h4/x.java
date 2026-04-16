package h4;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import d1.l0;
import java.io.InputStream;
import l3.h0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x implements r, h0, p4.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4022i;

    /* renamed from: j, reason: collision with root package name */
    public final Resources f4023j;

    public x(Resources resources) {
        this.f4022i = 3;
        resources.getClass();
        this.f4023j = resources;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(d1.s r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.f2546d
            java.lang.String r1 = r8.f2544b
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = ""
            if (r2 != 0) goto L40
            java.lang.String r2 = "und"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L15
            goto L40
        L15:
            int r2 = g1.w.f3713a
            r4 = 21
            if (r2 < r4) goto L20
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            goto L26
        L20:
            java.util.Locale r4 = new java.util.Locale
            r4.<init>(r0)
            r0 = r4
        L26:
            r4 = 24
            if (r2 < r4) goto L32
            androidx.emoji2.text.y.l()
            java.util.Locale r2 = androidx.emoji2.text.y.m()
            goto L36
        L32:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L36:
            java.lang.String r0 = r0.getDisplayName(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L42
        L40:
            r0 = r3
            goto L65
        L42:
            r4 = 1
            r5 = 0
            int r4 = r0.offsetByCodePoints(r5, r4)     // Catch: java.lang.IndexOutOfBoundsException -> L64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> L64
            r6.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> L64
            java.lang.String r5 = r0.substring(r5, r4)     // Catch: java.lang.IndexOutOfBoundsException -> L64
            java.lang.String r2 = r5.toUpperCase(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L64
            r6.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L64
            java.lang.String r2 = r0.substring(r4)     // Catch: java.lang.IndexOutOfBoundsException -> L64
            r6.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L64
            java.lang.String r0 = r6.toString()     // Catch: java.lang.IndexOutOfBoundsException -> L64
            goto L65
        L64:
        L65:
            java.lang.String r8 = r7.b(r8)
            java.lang.String[] r8 = new java.lang.String[]{r0, r8}
            java.lang.String r8 = r7.d(r8)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L7f
            boolean r8 = android.text.TextUtils.isEmpty(r1)
            if (r8 == 0) goto L7e
            r1 = r3
        L7e:
            r8 = r1
        L7f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.x.a(d1.s):java.lang.String");
    }

    public String b(d1.s sVar) {
        int i9 = sVar.f2548f;
        int i10 = sVar.f2548f;
        int i11 = i9 & 2;
        Resources resources = this.f4023j;
        String string = i11 != 0 ? resources.getString(2131951706) : "";
        if ((i10 & 4) != 0) {
            string = d(string, resources.getString(2131951709));
        }
        if ((i10 & 8) != 0) {
            string = d(string, resources.getString(2131951708));
        }
        return (i10 & 1088) != 0 ? d(string, resources.getString(2131951707)) : string;
    }

    public String c(d1.s sVar) {
        String a9;
        String c9;
        String str = sVar.f2554m;
        int i9 = sVar.f2550i;
        int i10 = sVar.f2567z;
        int i11 = sVar.f2560s;
        int i12 = sVar.f2559r;
        String str2 = sVar.f2551j;
        int g9 = l0.g(str);
        if (g9 == -1) {
            String str3 = null;
            if (str2 != null) {
                for (String str4 : g1.w.V(str2)) {
                    c9 = l0.c(str4);
                    if (c9 != null && l0.j(c9)) {
                        break;
                    }
                }
            }
            c9 = null;
            if (c9 == null) {
                if (str2 != null) {
                    String[] V = g1.w.V(str2);
                    int length = V.length;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= length) {
                            break;
                        }
                        String c10 = l0.c(V[i13]);
                        if (c10 != null && l0.h(c10)) {
                            str3 = c10;
                            break;
                        }
                        i13++;
                    }
                }
                if (str3 == null) {
                    if (i12 == -1 && i11 == -1) {
                        if (i10 == -1 && sVar.A == -1) {
                            g9 = -1;
                        }
                    }
                }
                g9 = 1;
            }
            g9 = 2;
        }
        Resources resources = this.f4023j;
        if (g9 == 2) {
            a9 = d(b(sVar), (i12 == -1 || i11 == -1) ? "" : resources.getString(2131951705, Integer.valueOf(i12), Integer.valueOf(i11)), i9 != -1 ? resources.getString(2131951703, Float.valueOf(i9 / 1000000.0f)) : "");
        } else if (g9 == 1) {
            a9 = d(a(sVar), (i10 == -1 || i10 < 1) ? "" : i10 != 1 ? i10 != 2 ? (i10 == 6 || i10 == 7) ? resources.getString(2131951717) : i10 != 8 ? resources.getString(2131951716) : resources.getString(2131951718) : resources.getString(2131951715) : resources.getString(2131951704), i9 != -1 ? resources.getString(2131951703, Float.valueOf(i9 / 1000000.0f)) : "");
        } else {
            a9 = a(sVar);
        }
        if (a9.length() != 0) {
            return a9;
        }
        String str5 = sVar.f2546d;
        return (str5 == null || str5.trim().isEmpty()) ? resources.getString(2131951719) : resources.getString(2131951720, str5);
    }

    public String d(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.f4023j.getString(2131951702, str, str2);
            }
        }
        return str;
    }

    @Override // h4.r
    public q i(w wVar) {
        switch (this.f4022i) {
            case 0:
                return new b(this.f4023j, wVar.b(Uri.class, AssetFileDescriptor.class));
            case 1:
                return new b(this.f4023j, wVar.b(Uri.class, InputStream.class));
            default:
                return new b(this.f4023j, a0.f3961b);
        }
    }

    @Override // p4.a
    public d4.a0 k(d4.a0 a0Var, b4.i iVar) {
        if (a0Var == null) {
            return null;
        }
        return new k4.d(this.f4023j, a0Var);
    }

    public /* synthetic */ x(Resources resources, int i9) {
        this.f4022i = i9;
        this.f4023j = resources;
    }
}
