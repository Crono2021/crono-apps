package b7;

import com.network.tvgramplayer.data.Playlist;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f1478a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final long f1479b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1480c;

    /* renamed from: d, reason: collision with root package name */
    public final Playlist f1481d;

    public a(long j5, String str, Playlist playlist) {
        this.f1479b = j5;
        this.f1480c = str;
        this.f1481d = playlist;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1478a == aVar.f1478a && this.f1479b == aVar.f1479b && b8.i.a(this.f1480c, aVar.f1480c) && b8.i.a(this.f1481d, aVar.f1481d);
    }

    public final int hashCode() {
        int i9 = this.f1478a * 31;
        long j5 = this.f1479b;
        return this.f1481d.hashCode() + androidx.activity.g.k((i9 + ((int) (j5 ^ (j5 >>> 32)))) * 31, 31, this.f1480c);
    }

    public final String toString() {
        return "CloudSyncInfo(sync_version=" + this.f1478a + ", timestamp=" + this.f1479b + ", device_id=" + this.f1480c + ", playlist_data=" + this.f1481d + ")";
    }
}
