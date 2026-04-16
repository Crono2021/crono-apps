package com.network.tvgramplayer.voip;

import android.widget.Toast;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.ui.PlaylistsActivity;
import g.j;
import i7.b1;
import i7.q2;
import i7.s3;
import o1.d;
import v1.v;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2334i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f2335j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f2336k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f2337l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2338m;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, Object obj4, int i9) {
        this.f2334i = i9;
        this.f2335j = obj;
        this.f2336k = obj2;
        this.f2337l = obj3;
        this.f2338m = obj4;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, v1.d0] */
    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f2334i;
        Object obj = this.f2338m;
        Object obj2 = this.f2337l;
        ?? r32 = this.f2336k;
        Object obj3 = this.f2335j;
        switch (i9) {
            case 0:
                ((NativeInstance) obj3).lambda$onAudioLevelsUpdated$1((int[]) r32, (float[]) obj2, (boolean[]) obj);
                break;
            case 1:
                Playlist playlist = (Playlist) obj3;
                Playlist playlist2 = (Playlist) r32;
                PlaylistsActivity playlistsActivity = (PlaylistsActivity) obj2;
                b7.a aVar = (b7.a) obj;
                int i10 = PlaylistsActivity.K;
                if (playlist != null && playlist2.getLastModified() <= playlist.getLastModified()) {
                    Toast.makeText(playlistsActivity, "Ya tienes la versión más reciente (o superior) ✅", 0).show();
                    break;
                } else {
                    playlistsActivity.y(aVar);
                    break;
                }
            case 2:
                PlaylistsActivity playlistsActivity2 = (PlaylistsActivity) obj3;
                s3 s3Var = (s3) obj;
                int i11 = PlaylistsActivity.K;
                new j(playlistsActivity2).setTitle("Actualización de Nube").c("Hay una versión más reciente de '" + ((Playlist) r32).getName() + "' en la nube. ¿Actualizar antes de reproducir?").g("Actualizar y Play", new b1(playlistsActivity2, (b7.a) obj2, s3Var, 6)).d("Play sin actualizar", new q2(s3Var, 3)).e("Cancelar", null).h();
                break;
            default:
                r32.o(((d) obj3).f7569a, (z) obj2, (v) obj);
                break;
        }
    }
}
