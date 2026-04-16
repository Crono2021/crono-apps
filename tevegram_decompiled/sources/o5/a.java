package o5;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import com.network.tvgramplayer.ui.DiscoveryActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f7932a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f7933b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public a0.b f7934c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7935d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7936e;

    public final boolean a(h hVar) {
        int id = hVar.getId();
        Integer valueOf = Integer.valueOf(id);
        HashSet hashSet = this.f7933b;
        if (hashSet.contains(valueOf)) {
            return false;
        }
        h hVar2 = (h) this.f7932a.get(Integer.valueOf(c()));
        if (hVar2 != null) {
            e(hVar2, false);
        }
        boolean add = hashSet.add(Integer.valueOf(id));
        if (!hVar.isChecked()) {
            hVar.setChecked(true);
        }
        return add;
    }

    public final ArrayList b(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet(this.f7933b);
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
            View childAt = viewGroup.getChildAt(i9);
            if ((childAt instanceof h) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public final int c() {
        if (!this.f7935d) {
            return -1;
        }
        HashSet hashSet = this.f7933b;
        if (hashSet.isEmpty()) {
            return -1;
        }
        return ((Integer) hashSet.iterator().next()).intValue();
    }

    public final void d() {
        int i9;
        a0.b bVar = this.f7934c;
        if (bVar != null) {
            new HashSet(this.f7933b);
            ChipGroup chipGroup = (ChipGroup) bVar.f8j;
            i5.h hVar = chipGroup.f2000o;
            if (hVar != null) {
                chipGroup.f2001p.b(chipGroup);
                a5.d dVar = (a5.d) hVar;
                ChipGroup chipGroup2 = (ChipGroup) dVar.f175k;
                if (chipGroup2.f2001p.f7935d) {
                    i5.g gVar = (i5.g) dVar.f174j;
                    int checkedChipId = chipGroup2.getCheckedChipId();
                    DiscoveryActivity discoveryActivity = (DiscoveryActivity) ((a3.i) gVar).f118j;
                    int i10 = DiscoveryActivity.J;
                    if (checkedChipId == 2131361952) {
                        i9 = 6;
                    } else {
                        if (checkedChipId != 2131361950) {
                            if (checkedChipId == 2131361951) {
                                i9 = 48;
                            } else if (checkedChipId == 2131361949) {
                                i9 = 168;
                            }
                        }
                        i9 = 24;
                    }
                    if (i9 != discoveryActivity.I) {
                        discoveryActivity.I = i9;
                        discoveryActivity.s();
                    }
                }
            }
        }
    }

    public final boolean e(h hVar, boolean z8) {
        int id = hVar.getId();
        Integer valueOf = Integer.valueOf(id);
        HashSet hashSet = this.f7933b;
        if (!hashSet.contains(valueOf)) {
            return false;
        }
        if (z8 && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
            hVar.setChecked(true);
            return false;
        }
        boolean remove = hashSet.remove(Integer.valueOf(id));
        if (hVar.isChecked()) {
            hVar.setChecked(false);
        }
        return remove;
    }
}
