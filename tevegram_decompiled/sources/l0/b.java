package l0;

import android.text.SpannableStringBuilder;
import d1.p;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String f5742b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f5743c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f5744d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f5745e;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5746a;

    static {
        p pVar = i.f5755c;
        f5742b = Character.toString((char) 8206);
        f5743c = Character.toString((char) 8207);
        f5744d = new b(false);
        f5745e = new b(true);
    }

    public b(boolean z8) {
        p pVar = i.f5753a;
        this.f5746a = z8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006d, code lost:
    
        if (r1 != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0070, code lost:
    
        if (r2 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0072, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0075, code lost:
    
        if (r0.f5740c <= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007b, code lost:
    
        switch(r0.a()) {
            case 14: goto L66;
            case 15: goto L66;
            case 16: goto L65;
            case 17: goto L65;
            case 18: goto L64;
            default: goto L70;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x007f, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0082, code lost:
    
        if (r1 != r3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0085, code lost:
    
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0088, code lost:
    
        if (r1 != r3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x008b, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.CharSequence r9) {
        /*
            l0.a r0 = new l0.a
            r0.<init>(r9)
            r9 = 0
            r0.f5740c = r9
            r1 = 0
            r2 = 0
            r3 = 0
        Lb:
            int r4 = r0.f5740c
            int r5 = r0.f5739b
            r6 = -1
            r7 = 1
            if (r4 >= r5) goto L6d
            if (r1 != 0) goto L6d
            java.lang.CharSequence r5 = r0.f5738a
            char r4 = r5.charAt(r4)
            r0.f5741d = r4
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            int r8 = r0.f5740c
            if (r4 == 0) goto L37
            int r4 = java.lang.Character.codePointAt(r5, r8)
            int r5 = r0.f5740c
            int r8 = java.lang.Character.charCount(r4)
            int r8 = r8 + r5
            r0.f5740c = r8
            byte r4 = java.lang.Character.getDirectionality(r4)
            goto L4a
        L37:
            int r8 = r8 + 1
            r0.f5740c = r8
            char r4 = r0.f5741d
            r5 = 1792(0x700, float:2.511E-42)
            if (r4 >= r5) goto L46
            byte[] r5 = l0.a.f5737e
            r4 = r5[r4]
            goto L4a
        L46:
            byte r4 = java.lang.Character.getDirectionality(r4)
        L4a:
            if (r4 == 0) goto L68
            if (r4 == r7) goto L65
            r5 = 2
            if (r4 == r5) goto L65
            r5 = 9
            if (r4 == r5) goto Lb
            switch(r4) {
                case 14: goto L61;
                case 15: goto L61;
                case 16: goto L5d;
                case 17: goto L5d;
                case 18: goto L59;
                default: goto L58;
            }
        L58:
            goto L6b
        L59:
            int r3 = r3 + (-1)
            r2 = 0
            goto Lb
        L5d:
            int r3 = r3 + 1
            r2 = 1
            goto Lb
        L61:
            int r3 = r3 + 1
            r2 = -1
            goto Lb
        L65:
            if (r3 != 0) goto L6b
            goto L84
        L68:
            if (r3 != 0) goto L6b
            goto L8a
        L6b:
            r1 = r3
            goto Lb
        L6d:
            if (r1 != 0) goto L70
            goto L8b
        L70:
            if (r2 == 0) goto L73
            return r2
        L73:
            int r2 = r0.f5740c
            if (r2 <= 0) goto L8b
            byte r2 = r0.a()
            switch(r2) {
                case 14: goto L88;
                case 15: goto L88;
                case 16: goto L82;
                case 17: goto L82;
                case 18: goto L7f;
                default: goto L7e;
            }
        L7e:
            goto L73
        L7f:
            int r3 = r3 + 1
            goto L73
        L82:
            if (r1 != r3) goto L85
        L84:
            return r7
        L85:
            int r3 = r3 + (-1)
            goto L73
        L88:
            if (r1 != r3) goto L85
        L8a:
            return r6
        L8b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.b.a(java.lang.CharSequence):int");
    }

    public static int b(CharSequence charSequence) {
        a aVar = new a(charSequence);
        aVar.f5740c = aVar.f5739b;
        int i9 = 0;
        int i10 = 0;
        while (aVar.f5740c > 0) {
            byte a9 = aVar.a();
            if (a9 != 0) {
                if (a9 == 1 || a9 == 2) {
                    if (i9 == 0) {
                        return 1;
                    }
                    if (i10 == 0) {
                        i10 = i9;
                    }
                } else if (a9 != 9) {
                    switch (a9) {
                        case 14:
                        case 15:
                            if (i10 == i9) {
                                return -1;
                            }
                            i9--;
                            break;
                        case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                        case 17:
                            if (i10 == i9) {
                                return 1;
                            }
                            i9--;
                            break;
                        case 18:
                            i9++;
                            break;
                        default:
                            if (i10 != 0) {
                                break;
                            } else {
                                i10 = i9;
                                break;
                            }
                    }
                } else {
                    continue;
                }
            } else {
                if (i9 == 0) {
                    return -1;
                }
                if (i10 == 0) {
                    i10 = i9;
                }
            }
        }
        return 0;
    }

    public final SpannableStringBuilder c(CharSequence charSequence) {
        p pVar = i.f5755c;
        if (charSequence == null) {
            return null;
        }
        boolean d9 = pVar.d(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean d10 = (d9 ? i.f5754b : i.f5753a).d(charSequence, charSequence.length());
        String str = "";
        String str2 = f5743c;
        String str3 = f5742b;
        boolean z8 = this.f5746a;
        spannableStringBuilder.append((CharSequence) ((z8 || !(d10 || a(charSequence) == 1)) ? (!z8 || (d10 && a(charSequence) != -1)) ? "" : str2 : str3));
        if (d9 != z8) {
            spannableStringBuilder.append(d9 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        boolean d11 = (d9 ? i.f5754b : i.f5753a).d(charSequence, charSequence.length());
        if (!z8 && (d11 || b(charSequence) == 1)) {
            str = str3;
        } else if (z8 && (!d11 || b(charSequence) == -1)) {
            str = str2;
        }
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }
}
