package g;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AlertController$RecycleListView f3499i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i f3500j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f f3501k;

    public e(f fVar, AlertController$RecycleListView alertController$RecycleListView, i iVar) {
        this.f3501k = fVar;
        this.f3499i = alertController$RecycleListView;
        this.f3500j = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
        f fVar = this.f3501k;
        boolean[] zArr = fVar.f3524t;
        AlertController$RecycleListView alertController$RecycleListView = this.f3499i;
        if (zArr != null) {
            zArr[i9] = alertController$RecycleListView.isItemChecked(i9);
        }
        fVar.f3528x.onClick(this.f3500j.f3540b, i9, alertController$RecycleListView.isItemChecked(i9));
    }
}
