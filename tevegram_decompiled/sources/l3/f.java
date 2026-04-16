package l3;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import b6.w0;
import java.util.ArrayList;
import java.util.List;
import o3.d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends o3.g0 {

    /* renamed from: d, reason: collision with root package name */
    public List f6126d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f6127e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6128f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f6129g;

    public f(q qVar, int i9) {
        this.f6128f = i9;
        this.f6129g = qVar;
        this.f6127e = qVar;
    }

    @Override // o3.g0
    public final int a() {
        if (this.f6126d.isEmpty()) {
            return 0;
        }
        return this.f6126d.size() + 1;
    }

    @Override // o3.g0
    public /* bridge */ /* synthetic */ void d(d1 d1Var, int i9) {
        switch (this.f6128f) {
            case 1:
                h((m) d1Var, i9);
                break;
            default:
                h((m) d1Var, i9);
                break;
        }
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        return new m(LayoutInflater.from(this.f6127e.getContext()).inflate(2131558466, viewGroup, false));
    }

    public boolean f(d1.d1 d1Var) {
        for (int i9 = 0; i9 < this.f6126d.size(); i9++) {
            if (d1Var.f2406r.containsKey(((n) this.f6126d.get(i9)).f6177a.f2415b)) {
                return true;
            }
        }
        return false;
    }

    public void g(List list) {
        q qVar = this.f6129g;
        ImageView imageView = qVar.E;
        boolean z8 = false;
        int i9 = 0;
        while (true) {
            if (i9 >= ((w0) list).f1466l) {
                break;
            }
            n nVar = (n) ((w0) list).get(i9);
            if (nVar.f6177a.f2418e[nVar.f6178b]) {
                z8 = true;
                break;
            }
            i9++;
        }
        if (imageView != null) {
            imageView.setImageDrawable(z8 ? qVar.f6191h0 : qVar.i0);
            imageView.setContentDescription(z8 ? qVar.f6194j0 : qVar.f6196k0);
        }
        this.f6126d = list;
    }

    public void h(m mVar, int i9) {
        switch (this.f6128f) {
            case 1:
                i(mVar, i9);
                if (i9 > 0) {
                    n nVar = (n) this.f6126d.get(i9 - 1);
                    mVar.f6176v.setVisibility(nVar.f6177a.f2418e[nVar.f6178b] ? 0 : 4);
                    break;
                }
                break;
            default:
                i(mVar, i9);
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009d, code lost:
    
        if (r8.f6177a.f2418e[r8.f6178b] != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(l3.m r7, int r8) {
        /*
            r6 = this;
            l3.q r0 = r6.f6127e
            d1.t0 r0 = r0.f6206p0
            if (r0 != 0) goto L7
            return
        L7:
            if (r8 != 0) goto L7a
            int r8 = r6.f6128f
            switch(r8) {
                case 0: goto L4d;
                default: goto Le;
            }
        Le:
            android.widget.TextView r8 = r7.f6175u
            r0 = 2131951711(0x7f13005f, float:1.9539844E38)
            r8.setText(r0)
            r8 = 0
            r0 = 0
        L18:
            java.util.List r1 = r6.f6126d
            int r1 = r1.size()
            if (r0 >= r1) goto L37
            java.util.List r1 = r6.f6126d
            java.lang.Object r1 = r1.get(r0)
            l3.n r1 = (l3.n) r1
            d1.e1 r2 = r1.f6177a
            int r1 = r1.f6178b
            boolean[] r2 = r2.f2418e
            boolean r1 = r2[r1]
            if (r1 == 0) goto L34
            r0 = 0
            goto L38
        L34:
            int r0 = r0 + 1
            goto L18
        L37:
            r0 = 1
        L38:
            android.view.View r1 = r7.f6176v
            if (r0 == 0) goto L3d
            goto L3e
        L3d:
            r8 = 4
        L3e:
            r1.setVisibility(r8)
            android.view.View r7 = r7.f7618a
            com.google.android.material.datepicker.n r8 = new com.google.android.material.datepicker.n
            r0 = 7
            r8.<init>(r6, r0)
            r7.setOnClickListener(r8)
            goto L79
        L4d:
            android.widget.TextView r8 = r7.f6175u
            r0 = 2131951710(0x7f13005e, float:1.9539842E38)
            r8.setText(r0)
            l3.q r8 = r6.f6129g
            d1.t0 r8 = r8.f6206p0
            r8.getClass()
            d1.d1 r8 = r8.Y()
            boolean r8 = r6.f(r8)
            android.view.View r0 = r7.f6176v
            if (r8 == 0) goto L6a
            r8 = 4
            goto L6b
        L6a:
            r8 = 0
        L6b:
            r0.setVisibility(r8)
            android.view.View r7 = r7.f7618a
            com.google.android.material.datepicker.n r8 = new com.google.android.material.datepicker.n
            r0 = 5
            r8.<init>(r6, r0)
            r7.setOnClickListener(r8)
        L79:
            return
        L7a:
            java.util.List r1 = r6.f6126d
            r2 = 1
            int r8 = r8 - r2
            java.lang.Object r8 = r1.get(r8)
            l3.n r8 = (l3.n) r8
            d1.e1 r1 = r8.f6177a
            d1.z0 r1 = r1.f2415b
            d1.d1 r3 = r0.Y()
            b6.b1 r3 = r3.f2406r
            java.lang.Object r3 = r3.get(r1)
            r4 = 0
            if (r3 == 0) goto La0
            d1.e1 r3 = r8.f6177a
            int r5 = r8.f6178b
            boolean[] r3 = r3.f2418e
            boolean r3 = r3[r5]
            if (r3 == 0) goto La0
            goto La1
        La0:
            r2 = 0
        La1:
            android.widget.TextView r3 = r7.f6175u
            java.lang.String r5 = r8.f6179c
            r3.setText(r5)
            android.view.View r3 = r7.f6176v
            if (r2 == 0) goto Lad
            goto Lae
        Lad:
            r4 = 4
        Lae:
            r3.setVisibility(r4)
            android.view.View r7 = r7.f7618a
            l3.o r2 = new l3.o
            r2.<init>()
            r7.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.f.i(l3.m, int):void");
    }

    private final void j(String str) {
    }
}
