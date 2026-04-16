package i7;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.util.SubscriptionItem;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b4 extends o3.g0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4793d = 0;

    /* renamed from: e, reason: collision with root package name */
    public List f4794e = o7.p.f8013i;

    /* renamed from: f, reason: collision with root package name */
    public final a8.l f4795f;

    /* renamed from: g, reason: collision with root package name */
    public final a8.l f4796g;

    public b4(m0 m0Var, m0 m0Var2) {
        this.f4795f = m0Var;
        this.f4796g = m0Var2;
    }

    @Override // o3.g0
    public final int a() {
        switch (this.f4793d) {
        }
        return this.f4794e.size();
    }

    @Override // o3.g0
    public final void d(o3.d1 d1Var, int i9) {
        String title;
        switch (this.f4793d) {
            case 0:
                a4 a4Var = (a4) d1Var;
                View view = a4Var.f7618a;
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem = (SearchHistoryManager$QuickSearchItem) this.f4794e.get(i9);
                a4Var.f4769v.setText(searchHistoryManager$QuickSearchItem.getQuery());
                a4Var.f4770w.setText(searchHistoryManager$QuickSearchItem.getChatTitle());
                String filterType = searchHistoryManager$QuickSearchItem.getFilterType();
                a4Var.f4768u.setImageResource(b8.i.a(filterType, "video") ? 2131230975 : b8.i.a(filterType, "document") ? 2131230960 : 2131230973);
                View findViewById = view.findViewById(2131361975);
                findViewById.setOnClickListener(new b(this, 8, searchHistoryManager$QuickSearchItem));
                findViewById.setNextFocusRightId(2131361906);
                findViewById.setNextFocusDownId(2131362315);
                view.setOnLongClickListener(new o(this, searchHistoryManager$QuickSearchItem, 1));
                break;
            default:
                j7.r rVar = (j7.r) d1Var;
                ImageView imageView = rVar.f5494v;
                View view2 = rVar.f7618a;
                SubscriptionItem subscriptionItem = (SubscriptionItem) this.f4794e.get(i9);
                if (subscriptionItem.isForum()) {
                    title = subscriptionItem.getTitle() + " 💬";
                } else {
                    title = subscriptionItem.getTitle();
                }
                rVar.f5493u.setText(title);
                String photoPath = subscriptionItem.getPhotoPath();
                if (photoPath == null || photoPath.length() == 0) {
                    imageView.setImageResource(R.drawable.ic_menu_gallery);
                } else {
                    com.bumptech.glide.k n4 = com.bumptech.glide.b.d(view2.getContext()).n(subscriptionItem.getPhotoPath());
                    n4.getClass();
                    ((com.bumptech.glide.k) ((com.bumptech.glide.k) n4.r(k4.o.f5576c, new k4.j())).j(R.drawable.ic_menu_gallery)).x(imageView);
                }
                view2.setOnClickListener(new b(this, 11, subscriptionItem));
                view2.setOnFocusChangeListener(new f2(rVar, 2));
                view2.setNextFocusDownId(2131362320);
                view2.setNextFocusRightId(2131361907);
                view2.setOnLongClickListener(new o(this, subscriptionItem, 3));
                break;
        }
    }

    @Override // o3.g0
    public final o3.d1 e(ViewGroup viewGroup) {
        switch (this.f4793d) {
            case 0:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558480, viewGroup, false);
                inflate.getClass();
                return new a4(inflate);
            default:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(2131558482, viewGroup, false);
                inflate2.getClass();
                return new j7.r(inflate2);
        }
    }

    public b4(m0 m0Var, m0 m0Var2, byte b9) {
        this.f4795f = m0Var;
        this.f4796g = m0Var2;
    }
}
