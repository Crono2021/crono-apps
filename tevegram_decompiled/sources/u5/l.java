package u5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f9115c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f9116d;

    public l(ArrayList arrayList, Matrix matrix) {
        this.f9115c = arrayList;
        this.f9116d = matrix;
    }

    @Override // u5.r
    public final void a(Matrix matrix, t5.a aVar, int i9, Canvas canvas) {
        ArrayList arrayList = this.f9115c;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((r) obj).a(this.f9116d, aVar, i9, canvas);
        }
    }
}
