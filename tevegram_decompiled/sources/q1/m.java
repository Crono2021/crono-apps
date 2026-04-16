package q1;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f8392a;

    /* renamed from: b, reason: collision with root package name */
    public final List f8393b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8394c;

    public m(String str, List list, boolean z8) {
        this.f8392a = str;
        this.f8393b = Collections.unmodifiableList(list);
        this.f8394c = z8;
    }

    public abstract Object a(List list);
}
