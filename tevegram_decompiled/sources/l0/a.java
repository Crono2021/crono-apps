package l0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f5737e = new byte[1792];

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f5738a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5739b;

    /* renamed from: c, reason: collision with root package name */
    public int f5740c;

    /* renamed from: d, reason: collision with root package name */
    public char f5741d;

    static {
        for (int i9 = 0; i9 < 1792; i9++) {
            f5737e[i9] = Character.getDirectionality(i9);
        }
    }

    public a(CharSequence charSequence) {
        this.f5738a = charSequence;
        this.f5739b = charSequence.length();
    }

    public final byte a() {
        int i9 = this.f5740c - 1;
        CharSequence charSequence = this.f5738a;
        char charAt = charSequence.charAt(i9);
        this.f5741d = charAt;
        boolean isLowSurrogate = Character.isLowSurrogate(charAt);
        int i10 = this.f5740c;
        if (isLowSurrogate) {
            int codePointBefore = Character.codePointBefore(charSequence, i10);
            this.f5740c -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f5740c = i10 - 1;
        char c9 = this.f5741d;
        return c9 < 1792 ? f5737e[c9] : Character.getDirectionality(c9);
    }
}
