package u7;

import java.io.Serializable;
import o7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends c implements a, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final Enum[] f9139i;

    public b(Enum[] enumArr) {
        enumArr.getClass();
        this.f9139i = enumArr;
    }

    @Override // o7.c, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r42 = (Enum) obj;
        int ordinal = r42.ordinal();
        Enum[] enumArr = this.f9139i;
        enumArr.getClass();
        return ((ordinal < 0 || ordinal >= enumArr.length) ? null : enumArr[ordinal]) == r42;
    }

    @Override // o7.c
    public final int f() {
        return this.f9139i.length;
    }

    @Override // java.util.List
    public final Object get(int i9) {
        Enum[] enumArr = this.f9139i;
        int length = enumArr.length;
        if (i9 >= 0 && i9 < length) {
            return enumArr[i9];
        }
        m7.c.h(", size: ", "index: ", i9, length);
        return null;
    }

    @Override // o7.c, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r52 = (Enum) obj;
        int ordinal = r52.ordinal();
        Enum[] enumArr = this.f9139i;
        enumArr.getClass();
        if (((ordinal < 0 || ordinal >= enumArr.length) ? null : enumArr[ordinal]) == r52) {
            return ordinal;
        }
        return -1;
    }

    @Override // o7.c, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r52 = (Enum) obj;
        int ordinal = r52.ordinal();
        Enum[] enumArr = this.f9139i;
        enumArr.getClass();
        if (((ordinal < 0 || ordinal >= enumArr.length) ? null : enumArr[ordinal]) == r52) {
            return ordinal;
        }
        return -1;
    }
}
