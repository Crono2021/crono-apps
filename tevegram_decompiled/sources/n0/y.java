package n0;

import android.text.TextUtils;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y extends a0 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7236e;

    public y(int i9, Class cls, int i10, int i11, int i12) {
        this.f7236e = i12;
        this.f7131a = i9;
        this.f7134d = cls;
        this.f7133c = i10;
        this.f7132b = i11;
    }

    @Override // n0.a0
    public final Object b(View view) {
        switch (this.f7236e) {
            case 0:
                return Boolean.valueOf(m0.d(view));
            case 1:
                return m0.b(view);
            case 2:
                return o0.b(view);
            default:
                return Boolean.valueOf(m0.c(view));
        }
    }

    @Override // n0.a0
    public final void c(View view, Object obj) {
        switch (this.f7236e) {
            case 0:
                m0.j(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                m0.h(view, (CharSequence) obj);
                break;
            case 2:
                o0.e(view, (CharSequence) obj);
                break;
            default:
                m0.g(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // n0.a0
    public final boolean e(Object obj, Object obj2) {
        boolean equals;
        switch (this.f7236e) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                equals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            case 2:
                equals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
        return !equals;
    }
}
