package l3;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends View implements g0 {

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f6081i;

    /* renamed from: j, reason: collision with root package name */
    public List f6082j;

    /* renamed from: k, reason: collision with root package name */
    public float f6083k;

    /* renamed from: l, reason: collision with root package name */
    public c f6084l;

    /* renamed from: m, reason: collision with root package name */
    public float f6085m;

    public b(Context context, int i9) {
        super(context, null);
        this.f6081i = new ArrayList();
        this.f6082j = Collections.EMPTY_LIST;
        this.f6083k = 0.0533f;
        this.f6084l = c.f6090g;
        this.f6085m = 0.08f;
    }

    @Override // l3.g0
    public final void a(List list, c cVar, float f9, float f10) {
        this.f6082j = list;
        this.f6084l = cVar;
        this.f6083k = f9;
        this.f6085m = f10;
        while (true) {
            ArrayList arrayList = this.f6081i;
            if (arrayList.size() >= list.size()) {
                invalidate();
                return;
            }
            arrayList.add(new f0(getContext()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0470  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchDraw(android.graphics.Canvas r37) {
        /*
            Method dump skipped, instructions count: 1182
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.b.dispatchDraw(android.graphics.Canvas):void");
    }
}
