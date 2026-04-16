package x0;

import android.text.Editable;
import androidx.emoji2.text.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f10021a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f10022b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f10023c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f10023c;
        return cls != null ? new w(cls, charSequence) : super.newEditable(charSequence);
    }
}
