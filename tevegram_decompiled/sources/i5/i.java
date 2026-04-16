package i5;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import i7.x;
import java.util.WeakHashMap;
import n0.d0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements ViewGroup.OnHierarchyChangeListener {

    /* renamed from: i, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f4745i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ChipGroup f4746j;

    public i(ChipGroup chipGroup) {
        this.f4746j = chipGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.f4746j;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                WeakHashMap weakHashMap = t0.f7209a;
                view2.setId(d0.a());
            }
            o5.a aVar = chipGroup.f2001p;
            Chip chip = (Chip) view2;
            aVar.f7932a.put(Integer.valueOf(chip.getId()), chip);
            if (chip.isChecked()) {
                aVar.a(chip);
            }
            chip.setInternalOnCheckedChangeListener(new x(aVar, 18));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f4745i;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        ChipGroup chipGroup = this.f4746j;
        if (view == chipGroup && (view2 instanceof Chip)) {
            o5.a aVar = chipGroup.f2001p;
            Chip chip = (Chip) view2;
            aVar.getClass();
            chip.setInternalOnCheckedChangeListener(null);
            aVar.f7932a.remove(Integer.valueOf(chip.getId()));
            aVar.f7933b.remove(Integer.valueOf(chip.getId()));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f4745i;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
