package l3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import o3.d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends d1 {

    /* renamed from: u, reason: collision with root package name */
    public final TextView f6165u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f6166v;

    /* renamed from: w, reason: collision with root package name */
    public final ImageView f6167w;

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ q f6168x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(q qVar, View view) {
        super(view);
        this.f6168x = qVar;
        if (g1.w.f3713a < 26) {
            view.setFocusable(true);
        }
        this.f6165u = (TextView) view.findViewById(2131362059);
        this.f6166v = (TextView) view.findViewById(2131362081);
        this.f6167w = (ImageView) view.findViewById(2131362058);
        view.setOnClickListener(new com.google.android.material.datepicker.n(this, 6));
    }
}
