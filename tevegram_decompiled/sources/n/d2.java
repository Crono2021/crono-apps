package n;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d2 implements AdapterView.OnItemSelectedListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6846i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6847j;

    public /* synthetic */ d2(Object obj, int i9) {
        this.f6846i = i9;
        this.f6847j = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i9, long j5) {
        x1 x1Var;
        switch (this.f6846i) {
            case 0:
                if (i9 != -1 && (x1Var = ((k2) this.f6847j).f6926k) != null) {
                    x1Var.setListSelectionHidden(false);
                    break;
                }
                break;
            default:
                ((SearchView) this.f6847j).o(i9);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i9 = this.f6846i;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }
}
