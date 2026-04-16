package g;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends ArrayAdapter {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AlertController$RecycleListView f3467i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f f3468j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, ContextThemeWrapper contextThemeWrapper, int i9, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(contextThemeWrapper, i9, R.id.text1, charSequenceArr);
        this.f3468j = fVar;
        this.f3467i = alertController$RecycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i9, view, viewGroup);
        boolean[] zArr = this.f3468j.f3524t;
        if (zArr != null && zArr[i9]) {
            this.f3467i.setItemChecked(i9, true);
        }
        return view2;
    }
}
