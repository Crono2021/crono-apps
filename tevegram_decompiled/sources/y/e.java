package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final float f10266a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10267b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10268c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10269d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10270e;

    public e(Context context, XmlResourceParser xmlResourceParser) {
        this.f10266a = Float.NaN;
        this.f10267b = Float.NaN;
        this.f10268c = Float.NaN;
        this.f10269d = Float.NaN;
        this.f10270e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), o.f10344i);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = obtainStyledAttributes.getIndex(i9);
            if (index == 0) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f10270e);
                this.f10270e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new k().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f10269d = obtainStyledAttributes.getDimension(index, this.f10269d);
            } else if (index == 2) {
                this.f10267b = obtainStyledAttributes.getDimension(index, this.f10267b);
            } else if (index == 3) {
                this.f10268c = obtainStyledAttributes.getDimension(index, this.f10268c);
            } else if (index == 4) {
                this.f10266a = obtainStyledAttributes.getDimension(index, this.f10266a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }
}
