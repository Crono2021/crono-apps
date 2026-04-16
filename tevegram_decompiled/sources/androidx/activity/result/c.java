package androidx.activity.result;

import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends a.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f325i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.d f326j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ g f327k;

    public c(g gVar, String str, com.bumptech.glide.d dVar) {
        this.f327k = gVar;
        this.f325i = str;
        this.f326j = dVar;
    }

    public final void Z(Object obj) {
        g gVar = this.f327k;
        HashMap hashMap = gVar.f335b;
        String str = this.f325i;
        Integer num = (Integer) hashMap.get(str);
        com.bumptech.glide.d dVar = this.f326j;
        if (num != null) {
            gVar.f337d.add(str);
            try {
                gVar.b(num.intValue(), dVar, obj);
                return;
            } catch (Exception e9) {
                gVar.f337d.remove(str);
                throw e9;
            }
        }
        throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + dVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
    }
}
