package com.network.tvgramplayer.player;

import a5.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Surface;
import androidx.activity.g;
import androidx.media3.ui.PlayerView;
import b8.i;
import d1.c1;
import d1.e0;
import d1.e1;
import d1.f0;
import d1.f1;
import d1.t0;
import d1.y0;
import e7.a;
import f1.c;
import g1.s;
import g1.t;
import g1.w;
import h7.o;
import i1.m;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.a1;
import l1.b0;
import l1.d0;
import l1.h0;
import l1.k;
import l1.p;
import l1.w0;
import l7.b;
import m1.q;
import n1.p0;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import v1.n;
import y1.h;
import z1.f;
import z1.j;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class PlayerManager {
    private final Context context;
    private p exoPlayer;
    private b visualizerProcessor;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class AudioTrack {
        private final e1 group;
        private final String id;
        private final int index;
        private final boolean isSelected;
        private final String label;

        public AudioTrack(String str, String str2, e1 e1Var, int i9, boolean z8) {
            str.getClass();
            str2.getClass();
            e1Var.getClass();
            this.id = str;
            this.label = str2;
            this.group = e1Var;
            this.index = i9;
            this.isSelected = z8;
        }

        public static /* synthetic */ AudioTrack copy$default(AudioTrack audioTrack, String str, String str2, e1 e1Var, int i9, boolean z8, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = audioTrack.id;
            }
            if ((i10 & 2) != 0) {
                str2 = audioTrack.label;
            }
            if ((i10 & 4) != 0) {
                e1Var = audioTrack.group;
            }
            if ((i10 & 8) != 0) {
                i9 = audioTrack.index;
            }
            if ((i10 & 16) != 0) {
                z8 = audioTrack.isSelected;
            }
            boolean z9 = z8;
            e1 e1Var2 = e1Var;
            return audioTrack.copy(str, str2, e1Var2, i9, z9);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.label;
        }

        public final e1 component3() {
            return this.group;
        }

        public final int component4() {
            return this.index;
        }

        public final boolean component5() {
            return this.isSelected;
        }

        public final AudioTrack copy(String str, String str2, e1 e1Var, int i9, boolean z8) {
            str.getClass();
            str2.getClass();
            e1Var.getClass();
            return new AudioTrack(str, str2, e1Var, i9, z8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioTrack)) {
                return false;
            }
            AudioTrack audioTrack = (AudioTrack) obj;
            return i.a(this.id, audioTrack.id) && i.a(this.label, audioTrack.label) && i.a(this.group, audioTrack.group) && this.index == audioTrack.index && this.isSelected == audioTrack.isSelected;
        }

        public final e1 getGroup() {
            return this.group;
        }

        public final String getId() {
            return this.id;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getLabel() {
            return this.label;
        }

        public int hashCode() {
            return ((((this.group.hashCode() + g.k(this.id.hashCode() * 31, 31, this.label)) * 31) + this.index) * 31) + (this.isSelected ? 1231 : 1237);
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            return "AudioTrack(id=" + this.id + ", label=" + this.label + ", group=" + this.group + ", index=" + this.index + ", isSelected=" + this.isSelected + ")";
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class SubtitleTrack {
        private final e1 group;
        private final String id;
        private final int index;
        private final boolean isSelected;
        private final String label;

        public SubtitleTrack(String str, String str2, e1 e1Var, int i9, boolean z8) {
            str.getClass();
            str2.getClass();
            e1Var.getClass();
            this.id = str;
            this.label = str2;
            this.group = e1Var;
            this.index = i9;
            this.isSelected = z8;
        }

        public static /* synthetic */ SubtitleTrack copy$default(SubtitleTrack subtitleTrack, String str, String str2, e1 e1Var, int i9, boolean z8, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = subtitleTrack.id;
            }
            if ((i10 & 2) != 0) {
                str2 = subtitleTrack.label;
            }
            if ((i10 & 4) != 0) {
                e1Var = subtitleTrack.group;
            }
            if ((i10 & 8) != 0) {
                i9 = subtitleTrack.index;
            }
            if ((i10 & 16) != 0) {
                z8 = subtitleTrack.isSelected;
            }
            boolean z9 = z8;
            e1 e1Var2 = e1Var;
            return subtitleTrack.copy(str, str2, e1Var2, i9, z9);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.label;
        }

        public final e1 component3() {
            return this.group;
        }

        public final int component4() {
            return this.index;
        }

        public final boolean component5() {
            return this.isSelected;
        }

        public final SubtitleTrack copy(String str, String str2, e1 e1Var, int i9, boolean z8) {
            str.getClass();
            str2.getClass();
            e1Var.getClass();
            return new SubtitleTrack(str, str2, e1Var, i9, z8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleTrack)) {
                return false;
            }
            SubtitleTrack subtitleTrack = (SubtitleTrack) obj;
            return i.a(this.id, subtitleTrack.id) && i.a(this.label, subtitleTrack.label) && i.a(this.group, subtitleTrack.group) && this.index == subtitleTrack.index && this.isSelected == subtitleTrack.isSelected;
        }

        public final e1 getGroup() {
            return this.group;
        }

        public final String getId() {
            return this.id;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getLabel() {
            return this.label;
        }

        public int hashCode() {
            return ((((this.group.hashCode() + g.k(this.id.hashCode() * 31, 31, this.label)) * 31) + this.index) * 31) + (this.isSelected ? 1231 : 1237);
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            return "SubtitleTrack(id=" + this.id + ", label=" + this.label + ", group=" + this.group + ", index=" + this.index + ", isSelected=" + this.isSelected + ")";
        }
    }

    public PlayerManager(Context context) {
        context.getClass();
        this.context = context;
    }

    public final void addNextTrack(a aVar) {
        aVar.getClass();
        p pVar = this.exoPlayer;
        if ((pVar != null ? ((b0) pVar).U().o() : 0) > 1) {
            return;
        }
        m mVar = new m();
        mVar.f4343j = 60000;
        mVar.f4345l = true;
        d dVar = new d(this.context, mVar);
        z1.g gVar = new z1.g() { // from class: com.network.tvgramplayer.player.PlayerManager$addNextTrack$loadErrorHandlingPolicy$1
            @Override // z1.g
            public int getMinimumLoadableRetryCount(int i9) {
                return Integer.MAX_VALUE;
            }

            @Override // z1.g
            public long getRetryDelayMsFor(j jVar) {
                jVar.getClass();
                return jVar.f10572a != null ? k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS : super.getRetryDelayMsFor(jVar);
            }

            @Override // z1.g
            public /* bridge */ /* synthetic */ void onLoadTaskConcluded(long j5) {
            }
        };
        n nVar = new n(dVar);
        nVar.f(gVar);
        v1.a d9 = nVar.d(e0.a(aVar.f3151a));
        d9.getClass();
        p pVar2 = this.exoPlayer;
        if (pVar2 != null) {
            b0 b0Var = (b0) pVar2;
            ArrayList arrayList = b0Var.f5802w;
            b0Var.y0();
            List singletonList = Collections.singletonList(d9);
            b0Var.y0();
            int size = arrayList.size();
            b0Var.y0();
            g1.a.f(size >= 0);
            int min = Math.min(size, arrayList.size());
            if (arrayList.isEmpty()) {
                b0Var.p0(singletonList, b0Var.f5794p0 == -1);
            } else {
                w0 w0Var = b0Var.f5792o0;
                y0 y0Var = w0Var.f6047a;
                b0Var.N++;
                ArrayList a9 = b0Var.a(min, singletonList);
                a1 a1Var = new a1(arrayList, b0Var.S);
                w0 b02 = b0Var.b0(w0Var, a1Var, b0Var.y(y0Var, a1Var, b0Var.x(w0Var), b0Var.o(w0Var)));
                h0 h0Var = b0Var.f5798s;
                v1.y0 y0Var2 = b0Var.S;
                t tVar = h0Var.f5900p;
                d0 d0Var = new d0(a9, y0Var2, -1, -9223372036854775807L);
                tVar.getClass();
                s b9 = t.b();
                b9.f3706a = tVar.f3708a.obtainMessage(18, min, 0, d0Var);
                b9.b();
                b0Var.w0(b02, 0, 1, false, 5, -9223372036854775807L, -1, false);
            }
        }
        Log.i("PlayerManager", "➕ Siguiente canción añadida a la cola (Gapless)");
    }

    public final List<AudioTrack> getAudioTracks() {
        p pVar = this.exoPlayer;
        if (pVar == null) {
            return o7.p.f8013i;
        }
        ArrayList arrayList = new ArrayList();
        f1 v8 = ((b0) pVar).v();
        v8.getClass();
        b6.e0 listIterator = v8.f2422a.listIterator(0);
        listIterator.getClass();
        while (listIterator.hasNext()) {
            e1 e1Var = (e1) listIterator.next();
            if (e1Var.f2415b.f2618c == 1) {
                int i9 = e1Var.f2414a;
                for (int i10 = 0; i10 < i9; i10++) {
                    d1.s a9 = e1Var.a(i10);
                    a9.getClass();
                    String str = a9.f2543a;
                    if (str == null) {
                        str = e1Var.hashCode() + "_" + i10;
                    }
                    String str2 = a9.f2544b;
                    if (str2 == null && (str2 = a9.f2546d) == null) {
                        str2 = "Desconocido";
                    }
                    arrayList.add(new AudioTrack(str, str2, e1Var, i10, e1Var.f2418e[i10]));
                }
            }
        }
        return arrayList;
    }

    public final t0 getPlayer() {
        return this.exoPlayer;
    }

    public final List<SubtitleTrack> getSubtitleTracks() {
        p pVar = this.exoPlayer;
        if (pVar == null) {
            return o7.p.f8013i;
        }
        ArrayList arrayList = new ArrayList();
        f1 v8 = ((b0) pVar).v();
        v8.getClass();
        b6.e0 listIterator = v8.f2422a.listIterator(0);
        listIterator.getClass();
        while (listIterator.hasNext()) {
            e1 e1Var = (e1) listIterator.next();
            if (e1Var.f2415b.f2618c == 3) {
                int i9 = e1Var.f2414a;
                for (int i10 = 0; i10 < i9; i10++) {
                    d1.s a9 = e1Var.a(i10);
                    a9.getClass();
                    String str = a9.f2543a;
                    if (str == null) {
                        str = e1Var.hashCode() + "_" + i10;
                    }
                    String str2 = a9.f2544b;
                    if (str2 == null && (str2 = a9.f2546d) == null) {
                        str2 = "Desconocido";
                    }
                    arrayList.add(new SubtitleTrack(str, str2, e1Var, i10, e1Var.f2418e[i10]));
                }
            }
        }
        return arrayList;
    }

    public final b getVisualizerProcessor() {
        return this.visualizerProcessor;
    }

    public final void play(a aVar) {
        p pVar;
        aVar.getClass();
        m mVar = new m();
        mVar.f4343j = 60000;
        mVar.f4344k = 60000;
        mVar.f4345l = true;
        d dVar = new d(this.context, mVar);
        z1.g gVar = new z1.g() { // from class: com.network.tvgramplayer.player.PlayerManager$play$loadErrorHandlingPolicy$1
            @Override // z1.g
            public int getMinimumLoadableRetryCount(int i9) {
                return Integer.MAX_VALUE;
            }

            @Override // z1.g
            public long getRetryDelayMsFor(j jVar) {
                jVar.getClass();
                IOException iOException = jVar.f10572a;
                iOException.getClass();
                Log.i("PlayerManager", "⏳ Reintentando conexión de proxy en 5s debido a error de red: " + iOException.getMessage());
                return k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
            }

            @Override // z1.g
            public /* bridge */ /* synthetic */ void onLoadTaskConcluded(long j5) {
            }
        };
        n nVar = new n(dVar);
        nVar.f(gVar);
        v1.a d9 = nVar.d(e0.a(aVar.f3151a));
        d9.getClass();
        p pVar2 = this.exoPlayer;
        if (pVar2 != null) {
            ((b0) pVar2).stop();
        }
        p pVar3 = this.exoPlayer;
        if (pVar3 != null) {
            ((b0) pVar3).q();
        }
        p pVar4 = this.exoPlayer;
        if (pVar4 != null) {
            b0 b0Var = (b0) pVar4;
            b0Var.y0();
            List singletonList = Collections.singletonList(d9);
            b0Var.y0();
            b0Var.p0(singletonList, true);
        }
        int i9 = aVar.f3156f;
        if (i9 > 0 && (pVar = this.exoPlayer) != null) {
            b0 b0Var2 = (b0) pVar;
            b0Var2.n0(b0Var2.I(), i9 * IjkMediaCodecInfo.RANK_MAX, false);
        }
        p pVar5 = this.exoPlayer;
        if (pVar5 != null) {
            ((b0) pVar5).b();
        }
        p pVar6 = this.exoPlayer;
        if (pVar6 != null) {
            ((b0) pVar6).r0(true);
        }
    }

    public final void release() {
        String str;
        android.media.AudioTrack audioTrack;
        p pVar = this.exoPlayer;
        if (pVar != null) {
            b0 b0Var = (b0) pVar;
            StringBuilder sb = new StringBuilder("Release ");
            sb.append(Integer.toHexString(System.identityHashCode(b0Var)));
            sb.append(" [AndroidXMedia3/1.3.1] [");
            sb.append(w.f3717e);
            sb.append("] [");
            HashSet hashSet = f0.f2419a;
            synchronized (f0.class) {
                str = f0.f2420b;
            }
            sb.append(str);
            sb.append("]");
            g1.a.v("ExoPlayerImpl", sb.toString());
            b0Var.y0();
            if (w.f3713a < 21 && (audioTrack = b0Var.V) != null) {
                audioTrack.release();
                b0Var.V = null;
            }
            b0Var.G.g();
            b0Var.I.getClass();
            b0Var.J.getClass();
            l1.d dVar = b0Var.H;
            dVar.f5814c = null;
            dVar.a();
            if (!b0Var.f5798s.y()) {
                b0Var.f5799t.e(10, new o(6));
            }
            b0Var.f5799t.d();
            b0Var.f5795q.f3708a.removeCallbacksAndMessages(null);
            f fVar = b0Var.A;
            q qVar = b0Var.f5804y;
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) fVar.f10557b.f10541a;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                z1.b bVar = (z1.b) it.next();
                if (bVar.f10539b == qVar) {
                    bVar.f10540c = true;
                    copyOnWriteArrayList.remove(bVar);
                }
            }
            w0 w0Var = b0Var.f5792o0;
            if (w0Var.f6060o) {
                b0Var.f5792o0 = w0Var.a();
            }
            w0 g9 = b0Var.f5792o0.g(1);
            b0Var.f5792o0 = g9;
            w0 b9 = g9.b(g9.f6048b);
            b0Var.f5792o0 = b9;
            b9.f6061p = b9.f6063r;
            b0Var.f5792o0.f6062q = 0L;
            q qVar2 = b0Var.f5804y;
            t tVar = qVar2.f6558p;
            g1.a.l(tVar);
            tVar.c(new a7.a(qVar2, 16));
            b0Var.f5793p.h();
            b0Var.m0();
            Surface surface = b0Var.X;
            if (surface != null) {
                surface.release();
                b0Var.X = null;
            }
            b0Var.f5782j0 = c.f3259b;
        }
        this.exoPlayer = null;
    }

    public final void seekTo(long j5) {
        p pVar = this.exoPlayer;
        if (pVar != null) {
            b0 b0Var = (b0) pVar;
            b0Var.n0(b0Var.I(), j5, false);
        }
    }

    public final void selectAudioTrack(AudioTrack audioTrack) {
        audioTrack.getClass();
        p pVar = this.exoPlayer;
        if (pVar == null) {
            return;
        }
        b0 b0Var = (b0) pVar;
        y1.i iVar = (y1.i) b0Var.Y();
        iVar.getClass();
        h hVar = new h(iVar);
        hVar.f(new d1.a1(audioTrack.getGroup().f2415b, Collections.singletonList(Integer.valueOf(audioTrack.getIndex()))));
        b0Var.n(new y1.i(hVar));
    }

    public final void selectSubtitleTrack(SubtitleTrack subtitleTrack) {
        p pVar = this.exoPlayer;
        if (pVar == null) {
            return;
        }
        if (subtitleTrack == null) {
            b0 b0Var = (b0) pVar;
            y1.i iVar = (y1.i) b0Var.Y();
            iVar.getClass();
            h hVar = new h(iVar);
            hVar.j(Collections.singleton(3));
            b0Var.n(new y1.i(hVar));
            return;
        }
        b0 b0Var2 = (b0) pVar;
        y1.i iVar2 = (y1.i) b0Var2.Y();
        iVar2.getClass();
        h hVar2 = new h(iVar2);
        hVar2.j(Collections.EMPTY_SET);
        hVar2.f(new d1.a1(subtitleTrack.getGroup().f2415b, Collections.singletonList(Integer.valueOf(subtitleTrack.getIndex()))));
        b0Var2.n(new y1.i(hVar2));
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [com.network.tvgramplayer.player.PlayerManager$setupPlayer$renderersFactory$1, l1.k] */
    public final void setupPlayer(PlayerView playerView) {
        playerView.getClass();
        k7.a aVar = new k7.a(this.context);
        SharedPreferences sharedPreferences = aVar.f5628b;
        int i9 = sharedPreferences.getInt("min_buffer_ms", 15000);
        int i10 = i9 < 15000 ? 15000 : i9;
        int i11 = sharedPreferences.getInt("max_buffer_ms", 50000);
        int i12 = i11 < 50000 ? 50000 : i11;
        l1.i.a(5000, 0, "bufferForPlaybackMs", "0");
        l1.i.a(10000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        l1.i.a(i10, 5000, "minBufferMs", "bufferForPlaybackMs");
        l1.i.a(i10, 10000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        l1.i.a(i12, i10, "maxBufferMs", "minBufferMs");
        l1.i iVar = new l1.i(new z1.d(), i10, i12, 5000, 10000, true);
        d1.g gVar = new d1.g(3);
        b bVar = new b();
        e1.b bVar2 = e1.b.f3018e;
        bVar2.getClass();
        bVar.f6279c = bVar2;
        ByteBuffer byteBuffer = e1.d.f3023a;
        byteBuffer.getClass();
        bVar.f6280d = byteBuffer;
        bVar.f6281e = byteBuffer;
        this.visualizerProcessor = bVar;
        final Context context = this.context;
        ?? r8 = new k(context) { // from class: com.network.tvgramplayer.player.PlayerManager$setupPlayer$renderersFactory$1
            @Override // l1.k
            public n1.w buildAudioSink(Context context2, boolean z8, boolean z9) {
                context2.getClass();
                n1.h0 h0Var = new n1.h0(context2);
                b visualizerProcessor = PlayerManager.this.getVisualizerProcessor();
                visualizerProcessor.getClass();
                h0Var.f7254b = new androidx.fragment.app.g(new b[]{visualizerProcessor});
                g1.a.k(!h0Var.f7255c);
                h0Var.f7255c = true;
                if (h0Var.f7254b == null) {
                    h0Var.f7254b = new androidx.fragment.app.g(new e1.d[0]);
                }
                if (h0Var.f7257e == null) {
                    h0Var.f7257e = new m1.b(context2);
                }
                return new p0(h0Var);
            }
        };
        if (!aVar.c() || sharedPreferences.getBoolean("use_software_audio", false)) {
            r8.setExtensionRendererMode(2);
            Log.d("PlayerManager", "🛠️ Software decoding preferred (" + (sharedPreferences.getBoolean("use_software_audio", false) ? "Software Audio (Forced)" : "HW Accel Disabled") + ")");
        } else {
            r8.setExtensionRendererMode(1);
            Log.d("PlayerManager", "🚀 Hardware acceleration active (Force On/Amazon Default)");
        }
        boolean z8 = this.context.getSharedPreferences("tvgram_settings", 0).getBoolean("enable_subtitles", true);
        y1.o oVar = new y1.o(this.context);
        String string = sharedPreferences.getString("preferred_subtitle_lang", "spa");
        if (string == null) {
            string = "spa";
        }
        String string2 = sharedPreferences.getString("preferred_audio_lang", "spa");
        String str = string2 != null ? string2 : "spa";
        if (z8) {
            y1.i c9 = oVar.c();
            c9.getClass();
            h hVar = new h(c9);
            hVar.f2384n = c1.d(new String[]{string});
            hVar.f2379i = c1.d(new String[]{str});
            hVar.f2387q = true;
            oVar.j(new y1.i(hVar));
        } else {
            y1.i c10 = oVar.c();
            c10.getClass();
            h hVar2 = new h(c10);
            hVar2.f2379i = c1.d(new String[]{str});
            Set singleton = Collections.singleton(3);
            hVar2.f2389s.clear();
            hVar2.f2389s.addAll(singleton);
            oVar.j(new y1.i(hVar2));
        }
        l1.o oVar2 = new l1.o(this.context, r8);
        g1.a.k(!oVar2.f5997u);
        oVar2.f5982e = new l1.m(oVar, 1);
        g1.a.k(!oVar2.f5997u);
        oVar2.f5983f = new l1.m(iVar, 0);
        g1.a.k(!oVar2.f5997u);
        oVar2.f5985i = gVar;
        oVar2.f5986j = true;
        if (aVar.b()) {
            int i13 = aVar.a() == 1 ? 2 : 0;
            g1.a.k(!oVar2.f5997u);
            oVar2.f5988l = i13;
            Log.i("PlayerManager", "🎬 Auto Frame Rate (AFR) strategy: ".concat(aVar.a() == 1 ? "ALWAYS (Cine Mode)" : "ONLY_IF_SEAMLESS"));
        }
        g1.a.k(!oVar2.f5997u);
        oVar2.f5997u = true;
        b0 b0Var = new b0(oVar2);
        this.exoPlayer = b0Var;
        a2.a aVar2 = new a2.a();
        q qVar = b0Var.f5804y;
        qVar.getClass();
        qVar.f6556n.a(aVar2);
        playerView.setPlayer(b0Var);
        b0Var.M(0);
        b0Var.r0(true);
        b0Var.y0();
        final float g9 = w.g(1.0f, 0.0f, 1.0f);
        if (b0Var.f5779h0 != g9) {
            b0Var.f5779h0 = g9;
            b0Var.o0(1, 2, Float.valueOf(b0Var.H.f5818g * g9));
            b0Var.f5799t.e(22, new g1.j() { // from class: l1.q
                @Override // g1.j
                public final void a(Object obj) {
                    ((d1.r0) obj).q(g9);
                }
            });
        }
        Log.d("PlayerManager", "🔊 Volume forced to: 1.0f");
    }
}
