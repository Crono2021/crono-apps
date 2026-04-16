package o7;

import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends c implements RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ float[] f8011i;

    public g(float[] fArr) {
        this.f8011i = fArr;
    }

    @Override // o7.c, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Number) obj).floatValue();
            for (float f9 : this.f8011i) {
                if (Float.floatToIntBits(f9) == Float.floatToIntBits(floatValue)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // o7.c
    public final int f() {
        return this.f8011i.length;
    }

    @Override // java.util.List
    public final Object get(int i9) {
        return Float.valueOf(this.f8011i[i9]);
    }

    @Override // o7.c, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Number) obj).floatValue();
        float[] fArr = this.f8011i;
        int length = fArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (Float.floatToIntBits(fArr[i9]) == Float.floatToIntBits(floatValue)) {
                return i9;
            }
        }
        return -1;
    }

    @Override // o7.c, java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f8011i.length == 0;
    }

    @Override // o7.c, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Number) obj).floatValue();
            float[] fArr = this.f8011i;
            int length = fArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i9 = length - 1;
                    if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(floatValue)) {
                        return length;
                    }
                    if (i9 < 0) {
                        break;
                    }
                    length = i9;
                }
            }
        }
        return -1;
    }
}
