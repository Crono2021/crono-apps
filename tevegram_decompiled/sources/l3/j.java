package l3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import o3.d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends o3.g0 {

    /* renamed from: d, reason: collision with root package name */
    public final String[] f6160d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f6161e;

    /* renamed from: f, reason: collision with root package name */
    public int f6162f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f6163g;

    public j(q qVar, String[] strArr, float[] fArr) {
        this.f6163g = qVar;
        this.f6160d = strArr;
        this.f6161e = fArr;
    }

    @Override // o3.g0
    public final int a() {
        return this.f6160d.length;
    }

    @Override // o3.g0
    public final void d(d1 d1Var, final int i9) {
        m mVar = (m) d1Var;
        View view = mVar.f6176v;
        View view2 = mVar.f7618a;
        String[] strArr = this.f6160d;
        if (i9 < strArr.length) {
            mVar.f6175u.setText(strArr[i9]);
        }
        if (i9 == this.f6162f) {
            view2.setSelected(true);
            view.setVisibility(0);
        } else {
            view2.setSelected(false);
            view.setVisibility(4);
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: l3.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                j jVar = j.this;
                q qVar = jVar.f6163g;
                int i10 = jVar.f6162f;
                int i11 = i9;
                if (i11 != i10) {
                    qVar.setPlaybackSpeed(jVar.f6161e[i11]);
                }
                qVar.f6211s.dismiss();
            }
        });
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        return new m(LayoutInflater.from(this.f6163g.getContext()).inflate(2131558466, viewGroup, false));
    }
}
