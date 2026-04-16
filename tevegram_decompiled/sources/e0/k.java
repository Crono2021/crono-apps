package e0;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f2993a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f2994b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2995c;

    public k(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f2993a = colorStateList;
        this.f2994b = configuration;
        this.f2995c = theme == null ? 0 : theme.hashCode();
    }
}
