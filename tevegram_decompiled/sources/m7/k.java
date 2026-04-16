package m7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.voip.NativeInstance;
import h7.k0;
import h7.o;
import i7.b0;
import i7.c0;
import i8.d1;
import i8.e1;
import i8.l0;
import i8.q0;
import i8.s;
import i8.t;
import i8.w;
import i8.y0;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.webrtc.EglBase;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {
    public static boolean N;
    public final String A;
    public final AtomicInteger B;
    public final AtomicInteger C;
    public final AtomicInteger D;
    public final AtomicInteger E;
    public long F;
    public final AtomicInteger G;
    public final ConcurrentHashMap H;
    public final ConcurrentHashMap I;
    public final ConcurrentHashMap J;
    public final ConcurrentLinkedQueue K;
    public final ConcurrentHashMap L;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6727a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6728b;

    /* renamed from: c, reason: collision with root package name */
    public final n7.e f6729c;

    /* renamed from: d, reason: collision with root package name */
    public NativeInstance f6730d;

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentLinkedQueue f6731e;

    /* renamed from: f, reason: collision with root package name */
    public CountDownLatch f6732f;

    /* renamed from: g, reason: collision with root package name */
    public String f6733g;
    public Long h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicLong f6734i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicLong f6735j;

    /* renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap f6736k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicLong f6737l;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicLong f6738m;

    /* renamed from: n, reason: collision with root package name */
    public final AtomicLong f6739n;

    /* renamed from: o, reason: collision with root package name */
    public final k8.d f6740o;

    /* renamed from: p, reason: collision with root package name */
    public final d1 f6741p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicLong f6742q;

    /* renamed from: r, reason: collision with root package name */
    public final AtomicLong f6743r;

    /* renamed from: s, reason: collision with root package name */
    public final AtomicInteger f6744s;

    /* renamed from: t, reason: collision with root package name */
    public final Semaphore f6745t;

    /* renamed from: u, reason: collision with root package name */
    public final l0 f6746u;

    /* renamed from: v, reason: collision with root package name */
    public b0 f6747v;

    /* renamed from: w, reason: collision with root package name */
    public androidx.activity.d f6748w;

    /* renamed from: x, reason: collision with root package name */
    public c0 f6749x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f6750y;

    /* renamed from: z, reason: collision with root package name */
    public final n8.e f6751z;
    public static final CopyOnWriteArrayList M = new CopyOnWriteArrayList();
    public static final StringBuilder O = new StringBuilder();
    public static final Handler P = new Handler(Looper.getMainLooper());

    public k(LiveStreamActivity liveStreamActivity) {
        r7.b bVar;
        liveStreamActivity.getClass();
        this.f6727a = liveStreamActivity;
        this.f6729c = new n7.e(new a());
        this.f6731e = new ConcurrentLinkedQueue();
        this.f6734i = new AtomicLong(0L);
        this.f6735j = new AtomicLong(0L);
        this.f6736k = new ConcurrentHashMap();
        this.f6737l = new AtomicLong(0L);
        this.f6738m = new AtomicLong(0L);
        this.f6739n = new AtomicLong(0L);
        this.f6740o = com.bumptech.glide.d.a(Integer.MAX_VALUE);
        this.f6742q = new AtomicLong(0L);
        this.f6743r = new AtomicLong(0L);
        this.f6744s = new AtomicInteger(0);
        this.f6745t = new Semaphore(10);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.getClass();
        this.f6746u = new l0(newSingleThreadExecutor);
        r7.g gVar = i8.c0.f5251b;
        e1 e1Var = new e1();
        gVar.getClass();
        r7.h hVar = r7.h.f8615i;
        if (e1Var != hVar) {
            r7.g e9 = gVar.e(e1Var.getKey());
            if (e9 == hVar) {
                gVar = e1Var;
            } else {
                r7.d dVar = r7.d.f8614i;
                s sVar = (s) e9.h(dVar);
                if (sVar == null) {
                    bVar = new r7.b(e9, e1Var);
                } else {
                    r7.g e10 = e9.e(dVar);
                    if (e10 == hVar) {
                        gVar = new r7.b(e1Var, sVar);
                    } else {
                        bVar = new r7.b(new r7.b(e10, e1Var), sVar);
                    }
                }
                gVar = bVar;
            }
        }
        this.f6751z = w.a(gVar);
        String hexString = Integer.toHexString(System.identityHashCode(this));
        this.A = hexString;
        Log.i("TelegramNTgCallsManager", "🏗️ TelegramNTgCallsManager INSTANTIATED [ID: " + hexString + "]");
        this.B = new AtomicInteger(0);
        this.C = new AtomicInteger(0);
        this.D = new AtomicInteger(0);
        this.E = new AtomicInteger(0);
        this.G = new AtomicInteger(0);
        this.H = new ConcurrentHashMap();
        this.I = new ConcurrentHashMap();
        this.J = new ConcurrentHashMap();
        this.K = new ConcurrentLinkedQueue();
        this.L = new ConcurrentHashMap();
        Log.i("TelegramNTgCallsManager", "> Preparando componentes nativos...");
        try {
            NativeInstance.setContext(liveStreamActivity.getApplicationContext());
            Log.i("TelegramNTgCallsManager", "> Motor nativo LISTO (Contexto configurado).");
        } catch (Exception e11) {
            Log.e("TelegramNTgCallsManager", "Init Error: " + e11.getMessage());
        }
        for (int i9 = 0; i9 < 50; i9++) {
            this.f6731e.add(ByteBuffer.allocateDirect(131072));
        }
        d1 d1Var = this.f6741p;
        if (d1Var != null) {
            w.c(d1Var);
        }
        this.f6741p = w.j(this.f6751z, this.f6746u, new i7.f(this, null), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #0 {Exception -> 0x0062, blocks: (B:6:0x000c, B:8:0x0016, B:12:0x0022, B:14:0x0026, B:18:0x0035, B:19:0x0038, B:21:0x003c, B:22:0x003f, B:24:0x0045, B:25:0x0048, B:27:0x004c, B:28:0x004f, B:30:0x0053, B:31:0x005c, B:36:0x0059), top: B:5:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r7, h7.c r8) {
        /*
            r6 = this;
            r7.getClass()
            boolean r0 = r6.f6728b
            if (r0 != 0) goto L68
            com.network.tvgramplayer.voip.NativeInstance r0 = r6.f6730d
            if (r0 != 0) goto Lc
            goto L68
        Lc:
            java.lang.String r0 = "\"rtmp\":true"
            r1 = 0
            boolean r0 = h8.e.g0(r7, r0, r1)     // Catch: java.lang.Exception -> L62
            r2 = 1
            if (r0 != 0) goto L21
            java.lang.String r0 = "\"stream\":true"
            boolean r0 = h8.e.g0(r7, r0, r1)     // Catch: java.lang.Exception -> L62
            if (r0 == 0) goto L1f
            goto L21
        L1f:
            r0 = 0
            goto L22
        L21:
            r0 = 1
        L22:
            com.network.tvgramplayer.voip.NativeInstance r3 = r6.f6730d     // Catch: java.lang.Exception -> L62
            if (r3 == 0) goto L2f
            m7.c r4 = new m7.c     // Catch: java.lang.Exception -> L62
            r5 = 0
            r4.<init>(r5)     // Catch: java.lang.Exception -> L62
            r3.setOnStateUpdatedListener(r4)     // Catch: java.lang.Exception -> L62
        L2f:
            com.network.tvgramplayer.voip.NativeInstance r3 = r6.f6730d
            if (r0 == 0) goto L57
            if (r3 == 0) goto L38
            r3.prepareForStream(r2)     // Catch: java.lang.Exception -> L62
        L38:
            com.network.tvgramplayer.voip.NativeInstance r0 = r6.f6730d     // Catch: java.lang.Exception -> L62
            if (r0 == 0) goto L3f
            r0.setMuteMicrophone(r2)     // Catch: java.lang.Exception -> L62
        L3f:
            com.network.tvgramplayer.voip.NativeInstance r0 = r6.f6730d     // Catch: java.lang.Exception -> L62
            r3 = 0
            if (r0 == 0) goto L48
            r0.setVolume(r1, r3)     // Catch: java.lang.Exception -> L62
        L48:
            com.network.tvgramplayer.voip.NativeInstance r0 = r6.f6730d     // Catch: java.lang.Exception -> L62
            if (r0 == 0) goto L4f
            r0.setVolume(r2, r3)     // Catch: java.lang.Exception -> L62
        L4f:
            com.network.tvgramplayer.voip.NativeInstance r0 = r6.f6730d     // Catch: java.lang.Exception -> L62
            if (r0 == 0) goto L5c
            r0.setJoinResponsePayload(r7, r2)     // Catch: java.lang.Exception -> L62
            goto L5c
        L57:
            if (r3 == 0) goto L5c
            r3.setJoinResponsePayload(r7, r1)     // Catch: java.lang.Exception -> L62
        L5c:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L62
            r8.a(r7)     // Catch: java.lang.Exception -> L62
            return
        L62:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r8.a(r7)
            return
        L68:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r8.a(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.k.a(java.lang.String, h7.c):void");
    }

    public final String b(int i9) {
        if (this.f6728b) {
            return null;
        }
        NativeInstance nativeInstance = this.f6730d;
        if (nativeInstance != null) {
            nativeInstance.stopGroup();
        }
        this.f6733g = null;
        this.f6732f = new CountDownLatch(1);
        File file = new File(this.f6727a.getCacheDir(), "voip_logs");
        if (!file.exists()) {
            file.mkdirs();
        }
        NativeInstance makeGroup = NativeInstance.makeGroup(file.getAbsolutePath(), true, 0L, false, true, new a3.i(this, 19), new o(27), new o(28), new b(this, i9), new o(29), new b(this, i9), false, true);
        this.f6730d = makeGroup;
        if (makeGroup != null) {
            makeGroup.setBufferSize(3145728);
        }
        NativeInstance nativeInstance2 = this.f6730d;
        if (nativeInstance2 != null) {
            nativeInstance2.resetGroupInstance(true, false);
        }
        CountDownLatch countDownLatch = this.f6732f;
        if (countDownLatch != null) {
            countDownLatch.await(30L, TimeUnit.SECONDS);
        }
        return this.f6733g;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d A[Catch: Exception -> 0x004e, TryCatch #0 {Exception -> 0x004e, blocks: (B:3:0x0010, B:5:0x001c, B:8:0x0023, B:10:0x0033, B:12:0x003d, B:13:0x0050, B:15:0x0079, B:16:0x0081, B:23:0x002e), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0079 A[Catch: Exception -> 0x004e, TryCatch #0 {Exception -> 0x004e, blocks: (B:3:0x0010, B:5:0x001c, B:8:0x0023, B:10:0x0033, B:12:0x003d, B:13:0x0050, B:15:0x0079, B:16:0x0081, B:23:0x002e), top: B:2:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(m7.f r21, byte[] r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            int r3 = r0.f6700k
            long r4 = r0.f6698i
            java.util.concurrent.ConcurrentHashMap r6 = r1.I
            java.lang.String r7 = "_"
            java.util.concurrent.ConcurrentLinkedQueue r8 = r1.f6731e
            r1.f(r3, r4, r2)     // Catch: java.lang.Exception -> L4e
            int r9 = r2.length     // Catch: java.lang.Exception -> L4e
            java.lang.Object r10 = r8.poll()     // Catch: java.lang.Exception -> L4e
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10     // Catch: java.lang.Exception -> L4e
            if (r10 == 0) goto L28
            int r11 = r10.capacity()     // Catch: java.lang.Exception -> L4e
            if (r11 >= r9) goto L23
            goto L28
        L23:
            r10.clear()     // Catch: java.lang.Exception -> L4e
        L26:
            r14 = r10
            goto L33
        L28:
            r10 = 131072(0x20000, float:1.83671E-40)
            if (r9 >= r10) goto L2e
            r9 = 131072(0x20000, float:1.83671E-40)
        L2e:
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.allocateDirect(r9)     // Catch: java.lang.Exception -> L4e
            goto L26
        L33:
            r14.getClass()     // Catch: java.lang.Exception -> L4e
            r14.put(r2)     // Catch: java.lang.Exception -> L4e
            com.network.tvgramplayer.voip.NativeInstance r11 = r1.f6730d     // Catch: java.lang.Exception -> L4e
            if (r11 == 0) goto L50
            long r12 = r0.f6698i     // Catch: java.lang.Exception -> L4e
            int r15 = r2.length     // Catch: java.lang.Exception -> L4e
            int r2 = r0.f6700k     // Catch: java.lang.Exception -> L4e
            int r9 = r0.f6701l     // Catch: java.lang.Exception -> L4e
            r16 = 0
            r18 = r2
            r19 = r9
            r11.onStreamPartAvailable(r12, r14, r15, r16, r18, r19)     // Catch: java.lang.Exception -> L4e
            goto L50
        L4e:
            r0 = move-exception
            goto L87
        L50:
            r8.offer(r14)     // Catch: java.lang.Exception -> L4e
            int r0 = r0.f6701l     // Catch: java.lang.Exception -> L4e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4e
            r2.<init>()     // Catch: java.lang.Exception -> L4e
            r2.append(r3)     // Catch: java.lang.Exception -> L4e
            r2.append(r7)     // Catch: java.lang.Exception -> L4e
            r2.append(r0)     // Catch: java.lang.Exception -> L4e
            r2.append(r7)     // Catch: java.lang.Exception -> L4e
            r2.append(r4)     // Catch: java.lang.Exception -> L4e
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Exception -> L4e
            java.lang.Object r2 = r6.get(r0)     // Catch: java.lang.Exception -> L4e
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L4e
            boolean r2 = b8.i.a(r2, r3)     // Catch: java.lang.Exception -> L4e
            if (r2 != 0) goto L81
            r6.put(r0, r3)     // Catch: java.lang.Exception -> L4e
            java.util.concurrent.ConcurrentLinkedQueue r2 = r1.K     // Catch: java.lang.Exception -> L4e
            r2.offer(r0)     // Catch: java.lang.Exception -> L4e
        L81:
            java.util.concurrent.ConcurrentHashMap r2 = r1.J     // Catch: java.lang.Exception -> L4e
            r2.remove(r0)     // Catch: java.lang.Exception -> L4e
            return
        L87:
            java.lang.String r2 = "TelegramNTgCallsManager"
            java.lang.String r3 = "❌ Error in dispatchSegment"
            android.util.Log.e(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.k.c(m7.f, byte[]):void");
    }

    public final void d(f fVar, k0 k0Var, ConcurrentHashMap concurrentHashMap, int i9) {
        String str = fVar.f6700k + "_" + fVar.f6701l + "_" + fVar.f6698i;
        AtomicInteger atomicInteger = this.C;
        if (i9 == 0) {
            atomicInteger.incrementAndGet();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.F > l1.k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            this.F = currentTimeMillis;
            int i10 = atomicInteger.get();
            int i11 = this.D.get();
            int i12 = this.E.get();
            int i13 = i10 > 0 ? (i11 * 100) / i10 : 100;
            int i14 = this.B.get();
            StringBuilder q4 = androidx.activity.g.q("📊 STREAM HEALTH: ", i13, "% | Success: ", i11, " | Failed: ");
            q4.append(i12);
            q4.append(" | Total: ");
            q4.append(i10);
            q4.append(" | Active: ");
            q4.append(i14);
            Log.e("TelegramNTgCallsManager", q4.toString());
        }
        w.j(this.f6751z, null, new j(this, fVar, k0Var, str, concurrentHashMap, i9, null), 3);
    }

    public final void e(f fVar, k0 k0Var) {
        int i9;
        int i10;
        int i11 = fVar.f6700k;
        int i12 = fVar.f6701l;
        long j5 = fVar.f6698i;
        String str = i11 + "_" + i12 + "_" + j5;
        ConcurrentHashMap concurrentHashMap = this.I;
        Object obj = concurrentHashMap.get(str);
        Boolean bool = Boolean.TRUE;
        if (b8.i.a(obj, bool)) {
            return;
        }
        ConcurrentHashMap concurrentHashMap2 = this.J;
        if (b8.i.a(concurrentHashMap2.get(str), bool)) {
            return;
        }
        if (b8.i.a(this.L.get(Long.valueOf(j5)), bool)) {
            Log.v("TelegramNTgCallsManager", "⏭️ SKIP FAILED ts=" + j5 + " — already dropped");
            NativeInstance nativeInstance = this.f6730d;
            if (nativeInstance != null) {
                nativeInstance.onStreamPartAvailable(fVar.f6698i, null, 0, 0L, fVar.f6700k, fVar.f6701l);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        AtomicLong atomicLong = this.f6739n;
        if (currentTimeMillis < atomicLong.get()) {
            StringBuilder c9 = t.a.c("🚦 Rate-limit COOLDOWN ACTIVE (", (atomicLong.get() - currentTimeMillis) / IjkMediaCodecInfo.RANK_MAX, "s). Deferring ts=");
            c9.append(j5);
            Log.w("TelegramNTgCallsManager", c9.toString());
            w.j(this.f6751z, null, new b7.c(this, fVar, k0Var, null, 5), 3);
            return;
        }
        if (i11 != 1 || currentTimeMillis <= atomicLong.get()) {
            i9 = i11;
            i10 = i12;
        } else {
            long j9 = fVar.f6698i;
            long j10 = fVar.f6699j;
            int i13 = fVar.f6701l;
            f fVar2 = new f(j9, j10, 0, i13, fVar.f6702m, fVar.f6703n, fVar.f6704o);
            i10 = i12;
            i9 = i11;
            String str2 = "0_" + i13 + "_" + j9;
            if (!b8.i.a(concurrentHashMap.get(str2), bool) && !b8.i.a(concurrentHashMap2.get(str2), bool)) {
                e(fVar2, k0Var);
            }
        }
        concurrentHashMap2.put(str, bool);
        this.f6738m.set(j5);
        long j11 = this.f6737l.get();
        if (j11 > 0 && j5 < j11 - 60000) {
            StringBuilder c10 = t.a.c("🚫 DROPPING ANCIENT REQUEST: ts=", j5, " (LiveHead=");
            c10.append(j11);
            c10.append("). Triggering JUMP TO LIVE.");
            Log.w("TelegramNTgCallsManager", c10.toString());
            concurrentHashMap2.remove(str);
            b0 b0Var = this.f6747v;
            if (b0Var != null) {
                StringBuilder c11 = t.a.c("ANCIENT_REQUEST (ts=", j5, ", live=");
                c11.append(j11);
                c11.append(")");
                b0Var.a(c11.toString());
                return;
            }
            return;
        }
        ConcurrentHashMap concurrentHashMap3 = this.H;
        if (concurrentHashMap3.containsKey(str)) {
            Object remove = concurrentHashMap3.remove(str);
            remove.getClass();
            concurrentHashMap2.remove(str);
            c(fVar, (byte[]) remove);
            return;
        }
        Log.v("TelegramNTgCallsManager", "🔍 Requesting segment: ts=" + j5 + ", ch=" + i9 + ", scale=" + fVar.f6703n + ", qual=" + i10);
        d(fVar, k0Var, new ConcurrentHashMap(), 0);
    }

    public final void f(int i9, long j5, byte[] bArr) {
        if (this.f6728b) {
            return;
        }
        long andSet = this.f6737l.getAndSet(j5);
        long j9 = andSet > 0 ? j5 - andSet : 0L;
        Log.i("TelegramNTgCallsManager", "📦 Segment Received [ch=" + i9 + "]: ts=" + j5 + ", Bytes=" + bArr.length + " (LiveDelta=" + j9 + ")");
        AtomicLong atomicLong = this.f6743r;
        AtomicLong atomicLong2 = this.f6742q;
        if (i9 == 0) {
            atomicLong2.set(j5);
        } else {
            atomicLong.set(j5);
        }
        long j10 = atomicLong2.get() - atomicLong.get();
        if (Math.abs(j10) > 1000) {
            long j11 = atomicLong2.get();
            long j12 = atomicLong.get();
            StringBuilder c9 = t.a.c("🚨 CRITICAL A/V RECEIVE MISALIGNMENT: Diff=", j10, "ms (A=");
            c9.append(j11);
            c9.append(", V=");
            c9.append(j12);
            c9.append(")");
            Log.e("TelegramNTgCallsManager", c9.toString());
        }
        this.f6740o.a(new n7.f(Boolean.valueOf(i9 == 1), bArr, Long.valueOf(j5)));
        this.f6744s.incrementAndGet();
        AtomicInteger atomicInteger = this.G;
        atomicInteger.incrementAndGet();
        if (this.f6750y || atomicInteger.get() < 20) {
            return;
        }
        this.f6750y = true;
        p8.d dVar = i8.c0.f5250a;
        w.j(this.f6751z, n8.o.f7529a, new b7.e(this, null, 2), 2);
    }

    public final void g() {
        Log.i("TelegramNTgCallsManager", "🛑 Releasing TelegramNTgCallsManager [ID: " + this.A + "]");
        this.f6728b = true;
        n8.e eVar = this.f6751z;
        y0 y0Var = (y0) eVar.f7502i.h(t.f5304j);
        if (y0Var == null) {
            o.c(eVar, "Scope cannot be cancelled because it does not have a job: ");
            return;
        }
        y0Var.l(new q0(y0Var.n(), null, y0Var));
        new Thread(new a7.a(this.f6730d, 17)).start();
        Object a9 = this.f6729c.a();
        a9.getClass();
        ((EglBase) a9).release();
        this.f6730d = null;
    }

    public final void h(long j5) {
        this.h = Long.valueOf(j5);
        this.f6734i.set(System.currentTimeMillis());
        this.I.clear();
        this.H.clear();
        this.f6750y = false;
        this.G.set(0);
    }
}
