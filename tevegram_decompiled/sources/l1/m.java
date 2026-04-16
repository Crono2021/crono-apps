package l1;

import com.network.tvgramplayer.player.PlayerManager$setupPlayer$renderersFactory$1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m implements a6.h {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5953i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5954j;

    public /* synthetic */ m(Object obj, int i9) {
        this.f5953i = i9;
        this.f5954j = obj;
    }

    @Override // a6.h
    public final Object get() {
        switch (this.f5953i) {
            case 0:
                return (i) this.f5954j;
            case 1:
                return (y1.o) this.f5954j;
            case 2:
                return (PlayerManager$setupPlayer$renderersFactory$1) this.f5954j;
            case 3:
                return Boolean.valueOf(((h0) this.f5954j).G);
            default:
                try {
                    return (v1.y) ((Class) this.f5954j).getConstructor(null).newInstance(null);
                } catch (Exception e9) {
                    throw new IllegalStateException(e9);
                }
        }
    }
}
