package androidx.emoji2.text;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import o3.o0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f620i;

    /* renamed from: j, reason: collision with root package name */
    public final int f621j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f622k;

    public j(List list, int i9, Throwable th) {
        this.f620i = 0;
        android.support.v4.media.session.b.r(list, "initCallbacks cannot be null");
        this.f622k = new ArrayList(list);
        this.f621j = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f620i) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f622k;
                int size = arrayList.size();
                int i9 = 0;
                if (this.f621j == 1) {
                    while (i9 < size) {
                        ((i) arrayList.get(i9)).b();
                        i9++;
                    }
                    break;
                } else {
                    while (i9 < size) {
                        ((i) arrayList.get(i9)).a();
                        i9++;
                    }
                    break;
                }
            case 1:
                RecyclerView recyclerView = ((com.google.android.material.datepicker.m) this.f622k).f2039g0;
                if (!recyclerView.F) {
                    o0 o0Var = recyclerView.f1080v;
                    if (o0Var != null) {
                        o0Var.w0(recyclerView, this.f621j);
                        break;
                    } else {
                        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                        break;
                    }
                }
                break;
            default:
                e0.b bVar = (e0.b) ((a0.b) this.f622k).f8j;
                if (bVar != null) {
                    bVar.h(this.f621j);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ j(int i9, int i10, Object obj) {
        this.f620i = i10;
        this.f622k = obj;
        this.f621j = i9;
    }
}
