package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import f.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: i, reason: collision with root package name */
    public final int f361i;

    /* renamed from: j, reason: collision with root package name */
    public final int f362j;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f3184t);
        this.f362j = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f361i = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
