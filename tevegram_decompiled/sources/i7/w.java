package i7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.network.tvgramplayer.data.Playlist;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w extends o3.g0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5164d;

    /* renamed from: e, reason: collision with root package name */
    public List f5165e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f5166f;

    public w(List list, androidx.fragment.app.g gVar) {
        this.f5164d = 0;
        gVar.getClass();
        this.f5165e = list;
        this.f5166f = gVar;
    }

    @Override // o3.g0
    public final int a() {
        switch (this.f5164d) {
        }
        return this.f5165e.size();
    }

    @Override // o3.g0
    public final void d(o3.d1 d1Var, int i9) {
        switch (this.f5164d) {
            case 0:
                v vVar = (v) d1Var;
                h7.i0 i0Var = (h7.i0) this.f5165e.get(i9);
                vVar.f5152u.setText(i0Var.f4115c + " (" + i0Var.f4116d + ")");
                vVar.f5153v.setChecked(((LinkedHashSet) ((androidx.fragment.app.g) this.f5166f).f730l).contains(String.valueOf(i0Var.f4113a)) ^ true);
                View view = vVar.f7618a;
                view.setNextFocusRightId(2131361900);
                if (i9 == r0.size() - 1) {
                    view.setNextFocusDownId(2131361900);
                }
                view.setOnClickListener(new u(vVar, this, i0Var, 0));
                break;
            default:
                j7.m mVar = (j7.m) d1Var;
                Playlist playlist = (Playlist) this.f5165e.get(i9);
                mVar.f5475u.setText(playlist.getName());
                View view2 = mVar.f7618a;
                view2.setOnClickListener(new b(this, 10, playlist));
                view2.setOnFocusChangeListener(new f2(mVar, 1));
                break;
        }
    }

    @Override // o3.g0
    public final o3.d1 e(ViewGroup viewGroup) {
        switch (this.f5164d) {
            case 0:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558474, viewGroup, false);
                inflate.getClass();
                return new v(inflate);
            default:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(2131558477, viewGroup, false);
                inflate2.getClass();
                return new j7.m(inflate2);
        }
    }

    public w(m0 m0Var) {
        this.f5164d = 1;
        this.f5165e = o7.p.f8013i;
        this.f5166f = m0Var;
    }
}
