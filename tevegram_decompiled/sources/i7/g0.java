package i7;

import android.R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g0 extends o3.g0 {

    /* renamed from: d, reason: collision with root package name */
    public Object f4865d;

    /* renamed from: e, reason: collision with root package name */
    public final m0 f4866e;

    public g0(ArrayList arrayList, m0 m0Var) {
        this.f4865d = arrayList;
        this.f4866e = m0Var;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.List] */
    @Override // o3.g0
    public final int a() {
        return this.f4865d.size();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    @Override // o3.g0
    public final void d(o3.d1 d1Var, int i9) {
        f0 f0Var = (f0) d1Var;
        ImageView imageView = f0Var.f4844x;
        View view = f0Var.f7618a;
        h7.i0 i0Var = (h7.i0) this.f4865d.get(i9);
        f0Var.f4841u.setText(i0Var.f4115c);
        TextView textView = f0Var.f4843w;
        String str = i0Var.f4117e;
        textView.setText(str);
        f0Var.f4842v.setText(String.valueOf(i0Var.f4116d));
        String str2 = i0Var.f4118f;
        Log.d("LiveStreamAdapter", "Bind Chat: " + str + ", Avatar Path: '" + str2 + "'");
        if (str2 == null || str2.length() == 0) {
            imageView.setImageResource(R.drawable.sym_def_app_icon);
        } else {
            com.bumptech.glide.k n4 = com.bumptech.glide.b.d(view.getContext()).n(str2);
            n4.getClass();
            ((com.bumptech.glide.k) n4.r(k4.o.f5576c, new k4.j())).x(imageView);
        }
        View findViewById = view.findViewById(2131361974);
        findViewById.setOnClickListener(new b(this, 3, i0Var));
        findViewById.setNextFocusRightId(2131361904);
    }

    @Override // o3.g0
    public final o3.d1 e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558475, viewGroup, false);
        inflate.getClass();
        return new f0(inflate);
    }
}
