package j7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import i7.u0;
import java.util.List;
import o3.d1;
import o3.g0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends g0 {

    /* renamed from: d, reason: collision with root package name */
    public List f5455d;

    /* renamed from: e, reason: collision with root package name */
    public final u0 f5456e;

    /* renamed from: f, reason: collision with root package name */
    public final u0 f5457f;

    /* renamed from: g, reason: collision with root package name */
    public final u0 f5458g;

    public g(List list, u0 u0Var, u0 u0Var2, u0 u0Var3) {
        this.f5455d = list;
        this.f5456e = u0Var;
        this.f5457f = u0Var2;
        this.f5458g = u0Var3;
    }

    @Override // o3.g0
    public final int a() {
        return this.f5455d.size();
    }

    @Override // o3.g0
    public final void d(d1 d1Var, int i9) {
        f fVar = (f) d1Var;
        ImageButton imageButton = fVar.f5453y;
        ImageButton imageButton2 = fVar.f5452x;
        ImageButton imageButton3 = fVar.f5454z;
        final SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem = (SearchHistoryManager$QuickSearchItem) this.f5455d.get(i9);
        fVar.f5449u.setText(searchHistoryManager$QuickSearchItem.getQuery());
        fVar.f5450v.setText(searchHistoryManager$QuickSearchItem.getChatTitle());
        fVar.f5451w.setImageResource(b8.i.a(searchHistoryManager$QuickSearchItem.getFilterType(), "video") ? 2131230975 : b8.i.a(searchHistoryManager$QuickSearchItem.getFilterType(), "document") ? 2131230960 : 2131230973);
        final int i10 = 0;
        imageButton2.setOnClickListener(new View.OnClickListener(this) { // from class: j7.e

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ g f5447j;

            {
                this.f5447j = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case 0:
                        this.f5447j.f5456e.a(searchHistoryManager$QuickSearchItem);
                        break;
                    case 1:
                        this.f5447j.f5457f.a(searchHistoryManager$QuickSearchItem);
                        break;
                    default:
                        this.f5447j.f5458g.a(searchHistoryManager$QuickSearchItem);
                        break;
                }
            }
        });
        final int i11 = 1;
        imageButton.setOnClickListener(new View.OnClickListener(this) { // from class: j7.e

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ g f5447j;

            {
                this.f5447j = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i11) {
                    case 0:
                        this.f5447j.f5456e.a(searchHistoryManager$QuickSearchItem);
                        break;
                    case 1:
                        this.f5447j.f5457f.a(searchHistoryManager$QuickSearchItem);
                        break;
                    default:
                        this.f5447j.f5458g.a(searchHistoryManager$QuickSearchItem);
                        break;
                }
            }
        });
        final int i12 = 2;
        imageButton3.setOnClickListener(new View.OnClickListener(this) { // from class: j7.e

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ g f5447j;

            {
                this.f5447j = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i12) {
                    case 0:
                        this.f5447j.f5456e.a(searchHistoryManager$QuickSearchItem);
                        break;
                    case 1:
                        this.f5447j.f5457f.a(searchHistoryManager$QuickSearchItem);
                        break;
                    default:
                        this.f5447j.f5458g.a(searchHistoryManager$QuickSearchItem);
                        break;
                }
            }
        });
        fVar.f7618a.setNextFocusRightId(2131361902);
        imageButton3.setNextFocusLeftId(-1);
        imageButton3.setNextFocusRightId(2131361903);
        imageButton2.setNextFocusRightId(2131361896);
        imageButton.setNextFocusRightId(-1);
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558476, viewGroup, false);
        inflate.getClass();
        return new f(inflate);
    }
}
