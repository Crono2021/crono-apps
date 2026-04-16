package b7;

import a0.k;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.network.tvgramplayer.data.HistoryItem;
import java.util.Comparator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements Comparator {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1489i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1490j;

    public /* synthetic */ d(Object obj, int i9) {
        this.f1489i = i9;
        this.f1490j = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1489i) {
            case 0:
                int compare = ((k) this.f1490j).compare(obj, obj2);
                return compare != 0 ? compare : com.bumptech.glide.c.j(Long.valueOf(((HistoryItem) obj2).getTimestamp()), Long.valueOf(((HistoryItem) obj).getTimestamp()));
            default:
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f1490j;
                int compareTo = Boolean.valueOf(materialButton.f1961w).compareTo(Boolean.valueOf(materialButton2.f1961w));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return compareTo2 != 0 ? compareTo2 : Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
        }
    }
}
