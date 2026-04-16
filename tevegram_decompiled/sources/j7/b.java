package j7;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.network.tvgramplayer.player.PlayerManager;
import i7.a3;
import java.util.List;
import o3.d1;
import o3.g0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends g0 {

    /* renamed from: d, reason: collision with root package name */
    public final List f5438d;

    /* renamed from: e, reason: collision with root package name */
    public final a3 f5439e;

    public b(List list, a3 a3Var) {
        this.f5438d = list;
        this.f5439e = a3Var;
    }

    @Override // o3.g0
    public final int a() {
        return this.f5438d.size();
    }

    @Override // o3.g0
    public final void d(d1 d1Var, int i9) {
        a aVar = (a) d1Var;
        View view = aVar.f7618a;
        PlayerManager.AudioTrack audioTrack = (PlayerManager.AudioTrack) this.f5438d.get(i9);
        TextView textView = aVar.f5437u;
        textView.setText(audioTrack.getLabel());
        textView.setTextColor(audioTrack.isSelected() ? -14575885 : -1);
        view.setOnClickListener(new i7.b(this, 9, audioTrack));
        view.setFocusable(true);
        view.setBackground(view.getContext().getDrawable(2131230845));
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_list_item_1, viewGroup, false);
        inflate.getClass();
        return new a(inflate);
    }
}
