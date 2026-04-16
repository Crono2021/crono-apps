package g;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i f3496i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f f3497j;

    public d(f fVar, i iVar) {
        this.f3497j = fVar;
        this.f3496i = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
        f fVar = this.f3497j;
        DialogInterface.OnClickListener onClickListener = fVar.f3522r;
        i iVar = this.f3496i;
        onClickListener.onClick(iVar.f3540b, i9);
        if (fVar.f3526v) {
            return;
        }
        iVar.f3540b.dismiss();
    }
}
