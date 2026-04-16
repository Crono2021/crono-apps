package j7;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.network.tvgramplayer.player.PlayerManager;
import i7.a3;
import java.util.Iterator;
import java.util.List;
import o3.d1;
import o3.g0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t extends g0 {

    /* renamed from: d, reason: collision with root package name */
    public final List f5497d;

    /* renamed from: e, reason: collision with root package name */
    public final a3 f5498e;

    public t(List list, a3 a3Var) {
        this.f5497d = list;
        this.f5498e = a3Var;
    }

    @Override // o3.g0
    public final int a() {
        return this.f5497d.size() + 1;
    }

    @Override // o3.g0
    public final void d(d1 d1Var, int i9) {
        s sVar = (s) d1Var;
        View view = sVar.f7618a;
        TextView textView = sVar.f5496u;
        List list = this.f5497d;
        if (i9 == 0) {
            textView.setText("Desactivar Subtítulos");
            if (list == null || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((PlayerManager.SubtitleTrack) it.next()).isSelected()) {
                        r2 = -1;
                        break;
                    }
                }
            }
            textView.setTextColor(r2);
            view.setOnClickListener(new com.google.android.material.datepicker.n(this, 3));
        } else {
            PlayerManager.SubtitleTrack subtitleTrack = (PlayerManager.SubtitleTrack) list.get(i9 - 1);
            textView.setText(subtitleTrack.getLabel());
            textView.setTextColor(subtitleTrack.isSelected() ? -14575885 : -1);
            view.setOnClickListener(new i7.b(this, 12, subtitleTrack));
        }
        view.setFocusable(true);
        view.setBackground(view.getContext().getDrawable(2131230845));
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_list_item_1, viewGroup, false);
        inflate.getClass();
        return new s(inflate);
    }
}
