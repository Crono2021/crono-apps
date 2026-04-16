package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f10316a;

    /* renamed from: b, reason: collision with root package name */
    public int f10317b;

    /* renamed from: c, reason: collision with root package name */
    public float f10318c;

    /* renamed from: d, reason: collision with root package name */
    public float f10319d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f10342f);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = obtainStyledAttributes.getIndex(i9);
            if (index == 1) {
                this.f10318c = obtainStyledAttributes.getFloat(index, this.f10318c);
            } else if (index == 0) {
                int i10 = obtainStyledAttributes.getInt(index, this.f10316a);
                this.f10316a = i10;
                this.f10316a = k.f10332d[i10];
            } else if (index == 4) {
                this.f10317b = obtainStyledAttributes.getInt(index, this.f10317b);
            } else if (index == 3) {
                this.f10319d = obtainStyledAttributes.getFloat(index, this.f10319d);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
