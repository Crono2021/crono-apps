package g5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o3.l0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends l0 {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f3743a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3744b;

    public a() {
        Paint paint = new Paint();
        this.f3743a = paint;
        this.f3744b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // o3.l0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Canvas canvas2;
        float dimension = recyclerView.getResources().getDimension(2131165456);
        Paint paint = this.f3743a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.f3744b.iterator();
        while (it.hasNext()) {
            ((d) it.next()).getClass();
            ThreadLocal threadLocal = f0.a.f3191a;
            float f9 = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f9)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f9)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f9)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f9))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).A0()) {
                canvas2 = canvas;
                canvas2.drawLine(0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f1983q.h(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f1983q.d(), paint);
            } else {
                canvas2 = canvas;
                canvas2.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).f1983q.e(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f1983q.f(), 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
