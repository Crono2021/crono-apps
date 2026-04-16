package j7;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerType;
import h7.k0;
import i7.e2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o3.d1;
import o3.g0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends g0 {

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f5470d;

    /* renamed from: e, reason: collision with root package name */
    public final k0 f5471e;

    /* renamed from: f, reason: collision with root package name */
    public final e2 f5472f;

    /* renamed from: g, reason: collision with root package name */
    public final e2 f5473g;
    public final e2 h;

    /* renamed from: i, reason: collision with root package name */
    public final SimpleDateFormat f5474i;

    public l(ArrayList arrayList, k0 k0Var, e2 e2Var, e2 e2Var2, e2 e2Var3) {
        k0Var.getClass();
        this.f5470d = arrayList;
        this.f5471e = k0Var;
        this.f5472f = e2Var;
        this.f5473g = e2Var2;
        this.h = e2Var3;
        this.f5474i = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
    }

    @Override // o3.g0
    public final int a() {
        return this.f5470d.size();
    }

    @Override // o3.g0
    public final void d(d1 d1Var, int i9) {
        Object obj;
        boolean z8;
        boolean z9;
        int i10;
        List<PlaylistItem> items;
        List<PlaylistItem> items2;
        j jVar = (j) d1Var;
        FrameLayout frameLayout = jVar.f5463u;
        View view = jVar.B;
        ImageView imageView = jVar.f5464v;
        View view2 = jVar.f7618a;
        ImageView imageView2 = jVar.A;
        Chip chip = jVar.f5468z;
        final TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) this.f5470d.get(i9);
        jVar.f5465w.setText(tdClient$ExplorerItem.getTitle());
        TextView textView = jVar.f5466x;
        String description = tdClient$ExplorerItem.getDescription();
        if (description == null) {
            description = "Sin descripción";
        }
        textView.setText(description);
        jVar.f5467y.setText(this.f5474i.format(new Date(tdClient$ExplorerItem.getDate() * 1000)));
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        float f9 = view2.getContext().getResources().getDisplayMetrics().density;
        if (tdClient$ExplorerItem.getType() == TdClient$ExplorerType.VIDEO || tdClient$ExplorerItem.getType() == TdClient$ExplorerType.IMAGE) {
            layoutParams.height = (int) (130 * f9);
            layoutParams.width = (int) (220 * f9);
        } else {
            layoutParams.height = (int) (70 * f9);
            layoutParams.width = (int) (140 * f9);
        }
        frameLayout.setLayoutParams(layoutParams);
        long mediaGroupId = i9 > 0 ? ((TdClient$ExplorerItem) this.f5470d.get(i9 - 1)).getMediaGroupId() : 0L;
        long mediaGroupId2 = i9 < this.f5470d.size() - 1 ? ((TdClient$ExplorerItem) this.f5470d.get(i9 + 1)).getMediaGroupId() : 0L;
        boolean z10 = tdClient$ExplorerItem.getMediaGroupId() != 0 && mediaGroupId == tdClient$ExplorerItem.getMediaGroupId();
        boolean z11 = tdClient$ExplorerItem.getMediaGroupId() != 0 && mediaGroupId2 == tdClient$ExplorerItem.getMediaGroupId();
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        layoutParams2.getClass();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        MaterialCardView materialCardView = view2 instanceof MaterialCardView ? (MaterialCardView) view2 : null;
        if (materialCardView != null) {
            float f10 = 12 * f9;
            int i11 = (int) (8 * f9);
            if (z10 && z11) {
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.bottomMargin = 2;
                c7.b e9 = materialCardView.getShapeAppearanceModel().e();
                com.bumptech.glide.c l4 = com.bumptech.glide.d.l(0);
                e9.f1650d = l4;
                e9.f1651e = l4;
                e9.f1647a = l4;
                e9.f1648b = l4;
                e9.c(0.0f);
                materialCardView.setShapeAppearanceModel(e9.a());
            } else if (z10) {
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.bottomMargin = i11;
                c7.b e10 = materialCardView.getShapeAppearanceModel().e();
                e10.f1650d = com.bumptech.glide.d.l(0);
                e10.f1652f = new u5.a(0.0f);
                e10.f1651e = com.bumptech.glide.d.l(0);
                e10.f1653g = new u5.a(0.0f);
                e10.f1648b = com.bumptech.glide.d.l(0);
                e10.f1654i = new u5.a(f10);
                e10.f1647a = com.bumptech.glide.d.l(0);
                e10.h = new u5.a(f10);
                materialCardView.setShapeAppearanceModel(e10.a());
            } else if (z11) {
                marginLayoutParams.topMargin = i11;
                marginLayoutParams.bottomMargin = 2;
                c7.b e11 = materialCardView.getShapeAppearanceModel().e();
                e11.f1650d = com.bumptech.glide.d.l(0);
                e11.f1652f = new u5.a(f10);
                e11.f1651e = com.bumptech.glide.d.l(0);
                e11.f1653g = new u5.a(f10);
                e11.f1648b = com.bumptech.glide.d.l(0);
                e11.f1654i = new u5.a(0.0f);
                e11.f1647a = com.bumptech.glide.d.l(0);
                e11.h = new u5.a(0.0f);
                materialCardView.setShapeAppearanceModel(e11.a());
            } else {
                marginLayoutParams.topMargin = i11;
                marginLayoutParams.bottomMargin = i11;
                c7.b e12 = materialCardView.getShapeAppearanceModel().e();
                com.bumptech.glide.c l9 = com.bumptech.glide.d.l(0);
                e12.f1650d = l9;
                e12.f1651e = l9;
                e12.f1647a = l9;
                e12.f1648b = l9;
                e12.c(f10);
                materialCardView.setShapeAppearanceModel(e12.a());
            }
            view2.setLayoutParams(marginLayoutParams);
        }
        chip.setText(tdClient$ExplorerItem.getType().name());
        int i12 = k.f5469a[tdClient$ExplorerItem.getType().ordinal()];
        if (i12 == 1) {
            chip.setChipIconResource(R.drawable.ic_media_play);
            chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#FF1744")));
        } else if (i12 == 2) {
            chip.setChipIconResource(R.drawable.ic_menu_gallery);
            chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#76FF03")));
            chip.setTextColor(-16777216);
            chip.setChipIconTint(ColorStateList.valueOf(-16777216));
        } else if (i12 == 3) {
            chip.setChipIconResource(R.drawable.ic_menu_share);
            chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#2979FF")));
        } else if (i12 == 4) {
            chip.setText("TEMA");
            chip.setChipIconResource(R.drawable.ic_menu_send);
            chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#D500F9")));
            chip.setTextColor(-1);
        }
        int thumbnailFileId = tdClient$ExplorerItem.getThumbnailFileId();
        if (thumbnailFileId != 0) {
            this.f5471e.c(thumbnailFileId, new b7.b(jVar, 4));
        } else {
            imageView.setImageResource(R.color.black);
            if (tdClient$ExplorerItem.getType() == TdClient$ExplorerType.LINK) {
                imageView.setImageResource(R.drawable.ic_menu_send);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
            }
        }
        final int i13 = 0;
        view.setOnClickListener(new View.OnClickListener(this) { // from class: j7.h

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ l f5460j;

            {
                this.f5460j = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                switch (i13) {
                    case 0:
                        this.f5460j.f5472f.a(tdClient$ExplorerItem);
                        break;
                    default:
                        e2 e2Var = this.f5460j.f5473g;
                        if (e2Var != null) {
                            e2Var.a(tdClient$ExplorerItem);
                            break;
                        }
                        break;
                }
            }
        });
        view.setOnLongClickListener(new i7.o(this, tdClient$ExplorerItem, 2));
        final int i14 = 1;
        imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: j7.h

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ l f5460j;

            {
                this.f5460j = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                switch (i14) {
                    case 0:
                        this.f5460j.f5472f.a(tdClient$ExplorerItem);
                        break;
                    default:
                        e2 e2Var = this.f5460j.f5473g;
                        if (e2Var != null) {
                            e2Var.a(tdClient$ExplorerItem);
                            break;
                        }
                        break;
                }
            }
        });
        i iVar = new i(0);
        view.setOnFocusChangeListener(iVar);
        imageView2.setOnFocusChangeListener(iVar);
        Context context = view2.getContext();
        context.getClass();
        Iterator it = o7.h.Q0((ArrayList) new a0.l(context).f32k).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object next = it.next();
            String name = ((Playlist) next).getName();
            if (name == null ? false : name.equalsIgnoreCase("Favoritos")) {
                obj = next;
                break;
            }
        }
        Playlist playlist = (Playlist) obj;
        if (playlist != null && (items2 = playlist.getItems()) != null && !items2.isEmpty()) {
            for (PlaylistItem playlistItem : items2) {
                if (playlistItem.getChatId() == tdClient$ExplorerItem.getChatId() && playlistItem.getMsgId() == tdClient$ExplorerItem.getMessageId()) {
                    z8 = true;
                    break;
                }
            }
        }
        z8 = false;
        if (tdClient$ExplorerItem.getMediaGroupId() != 0 && !z8) {
            if (playlist == null || (items = playlist.getItems()) == null || items.isEmpty()) {
                i10 = 0;
            } else {
                Iterator<T> it2 = items.iterator();
                i10 = 0;
                while (it2.hasNext()) {
                    if (((PlaylistItem) it2.next()).getMediaGroupId() == tdClient$ExplorerItem.getMediaGroupId() && (i10 = i10 + 1) < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
            }
            if (i10 > 1) {
                z9 = true;
                if (z8 && !z9) {
                    imageView2.setImageResource(R.drawable.btn_star_big_off);
                    imageView2.setColorFilter(Color.parseColor("#888888"));
                    return;
                } else {
                    imageView2.setImageResource(R.drawable.btn_star_big_on);
                    imageView2.setColorFilter(Color.parseColor("#FFD700"));
                }
            }
        }
        z9 = false;
        if (z8) {
        }
        imageView2.setImageResource(R.drawable.btn_star_big_on);
        imageView2.setColorFilter(Color.parseColor("#FFD700"));
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558472, viewGroup, false);
        inflate.getClass();
        return new j(inflate);
    }

    public final void f(List list, boolean z8) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        long j5 = 0;
        while (it.hasNext()) {
            TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) it.next();
            if (tdClient$ExplorerItem.getMediaGroupId() == 0) {
                if (!arrayList2.isEmpty()) {
                    arrayList.addAll(o7.h.M0(arrayList2));
                    arrayList2.clear();
                    j5 = 0;
                }
                arrayList.add(tdClient$ExplorerItem);
            } else if (j5 == 0) {
                j5 = tdClient$ExplorerItem.getMediaGroupId();
                arrayList2.add(tdClient$ExplorerItem);
            } else if (j5 == tdClient$ExplorerItem.getMediaGroupId()) {
                arrayList2.add(tdClient$ExplorerItem);
            } else {
                arrayList.addAll(o7.h.M0(arrayList2));
                arrayList2.clear();
                j5 = tdClient$ExplorerItem.getMediaGroupId();
                arrayList2.add(tdClient$ExplorerItem);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.addAll(o7.h.M0(arrayList2));
        }
        if (!z8) {
            this.f5470d = new ArrayList(arrayList);
            c();
        } else {
            int size = this.f5470d.size();
            this.f5470d.addAll(arrayList);
            this.f7659a.e(size, arrayList.size());
        }
    }
}
