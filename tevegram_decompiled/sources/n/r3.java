package n;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r3 implements m, m.k {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Toolbar f7024i;

    public /* synthetic */ r3(Toolbar toolbar) {
        this.f7024i = toolbar;
    }

    @Override // m.k
    public boolean e(m.m mVar, MenuItem menuItem) {
        return false;
    }

    @Override // m.k
    public void j(m.m mVar) {
        Toolbar toolbar = this.f7024i;
        j jVar = toolbar.f499i.B;
        if (jVar == null || !jVar.e()) {
            Iterator it = ((CopyOnWriteArrayList) toolbar.O.f6511k).iterator();
            if (it.hasNext()) {
                throw androidx.activity.g.l(it);
            }
        }
    }
}
