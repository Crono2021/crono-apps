package d4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements Appendable {

    /* renamed from: i, reason: collision with root package name */
    public final Appendable f2931i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2932j = true;

    public v(Appendable appendable) {
        this.f2931i = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i9, int i10) {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z8 = this.f2932j;
        Appendable appendable = this.f2931i;
        boolean z9 = false;
        if (z8) {
            this.f2932j = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i10 - 1) == '\n') {
            z9 = true;
        }
        this.f2932j = z9;
        appendable.append(charSequence, i9, i10);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c9) {
        boolean z8 = this.f2932j;
        Appendable appendable = this.f2931i;
        if (z8) {
            this.f2932j = false;
            appendable.append("  ");
        }
        this.f2932j = c9 == '\n';
        appendable.append(c9);
        return this;
    }
}
