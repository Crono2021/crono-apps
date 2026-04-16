package m7;

import a8.p;
import android.util.Log;
import com.network.tvgramplayer.voip.NativeInstance;
import h7.k0;
import i7.b0;
import i8.c0;
import i8.w;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import n8.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class g implements p {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k f6705i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMap f6706j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f f6707k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6708l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f6709m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ k0 f6710n;

    public /* synthetic */ g(k kVar, ConcurrentHashMap concurrentHashMap, f fVar, int i9, String str, k0 k0Var) {
        this.f6705i = kVar;
        this.f6706j = concurrentHashMap;
        this.f6707k = fVar;
        this.f6708l = i9;
        this.f6709m = str;
        this.f6710n = k0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        int i9;
        k kVar = this.f6705i;
        ConcurrentHashMap concurrentHashMap4 = kVar.I;
        ConcurrentLinkedQueue concurrentLinkedQueue = kVar.K;
        f fVar = this.f6707k;
        long j5 = fVar.f6698i;
        String str = this.f6709m;
        byte[] bArr = (byte[]) obj;
        int intValue = ((Integer) obj2).intValue();
        ?? r11 = "REPEATED_429 (ts=";
        try {
            AtomicInteger atomicInteger = kVar.B;
            AtomicLong atomicLong = kVar.f6737l;
            ConcurrentHashMap concurrentHashMap5 = kVar.J;
            ConcurrentHashMap concurrentHashMap6 = kVar.L;
            n8.e eVar = kVar.f6751z;
            atomicInteger.decrementAndGet();
            kVar.f6745t.release();
            if (kVar.f6728b) {
                while (concurrentLinkedQueue.size() > 1500) {
                    String str2 = (String) concurrentLinkedQueue.poll();
                    if (str2 != null) {
                        concurrentHashMap4.remove(str2);
                    }
                }
            } else {
                ConcurrentHashMap concurrentHashMap7 = this.f6706j;
                int i10 = this.f6708l;
                try {
                    if (bArr != null) {
                        concurrentHashMap7.remove(Long.valueOf(j5));
                        kVar.D.incrementAndGet();
                        if (i10 > 0) {
                            Log.i("TelegramNTgCallsManager", "✅ Segment ts=" + j5 + " recovered after " + i10 + " retries");
                        }
                        kVar.c(fVar, bArr);
                        concurrentHashMap2 = concurrentHashMap4;
                    } else {
                        concurrentHashMap5.remove(str);
                        k0 k0Var = this.f6710n;
                        try {
                            if (intValue == 429) {
                                Log.w("TelegramNTgCallsManager", "🚦 429 Detected for ts=" + j5 + " (InFlight=" + concurrentHashMap5.size() + "). Backing off 10s...");
                                kVar.f6739n.set(System.currentTimeMillis() + ((long) 10000));
                                if (i10 > 6) {
                                    Log.w("TelegramNTgCallsManager", "🚦 Repeated 429s for ts=" + j5 + ". Triggering resync.");
                                    b0 b0Var = kVar.f6747v;
                                    if (b0Var != null) {
                                        b0Var.a("REPEATED_429 (ts=" + j5 + ")");
                                    }
                                    while (concurrentLinkedQueue.size() > 1500) {
                                        String str3 = (String) concurrentLinkedQueue.poll();
                                        if (str3 != null) {
                                            concurrentHashMap4.remove(str3);
                                        }
                                    }
                                } else {
                                    w.j(eVar, null, new h(i10, kVar, fVar, k0Var, concurrentHashMap7, (r7.c) null, 0), 3);
                                    while (concurrentLinkedQueue.size() > 1500) {
                                        String str4 = (String) concurrentLinkedQueue.poll();
                                        if (str4 != null) {
                                            concurrentHashMap4.remove(str4);
                                        }
                                    }
                                }
                            } else {
                                concurrentHashMap2 = concurrentHashMap4;
                                if (intValue == 400) {
                                    long j9 = atomicLong.get();
                                    if (j9 > 0) {
                                        concurrentHashMap3 = concurrentHashMap7;
                                        if (j5 > 30000 + j9) {
                                            Log.w("TelegramNTgCallsManager", "🏁 FUTURE SEGMENT for ts=" + j5 + " (live=" + j9 + "). Waiting 2s...");
                                            w.j(eVar, null, new h(kVar, fVar, k0Var, concurrentHashMap3, i10, (r7.c) null, 1), 3);
                                            while (concurrentLinkedQueue.size() > 1500) {
                                                String str5 = (String) concurrentLinkedQueue.poll();
                                                if (str5 != null) {
                                                    concurrentHashMap2.remove(str5);
                                                }
                                            }
                                        } else {
                                            kVar = kVar;
                                        }
                                    } else {
                                        concurrentHashMap3 = concurrentHashMap7;
                                    }
                                    if (j9 > 0) {
                                        i9 = i10;
                                        if (j5 < j9 - 60000) {
                                            Log.w("TelegramNTgCallsManager", "🚩 EXPIRED for ts=" + j5 + " (live=" + j9 + "). Jumping.");
                                            b0 b0Var2 = kVar.f6747v;
                                            if (b0Var2 != null) {
                                                b0Var2.a("EXPIRED_400 (ts=" + j5 + ", live=" + j9 + ")");
                                            }
                                            while (concurrentLinkedQueue.size() > 1500) {
                                                String str6 = (String) concurrentLinkedQueue.poll();
                                                if (str6 != null) {
                                                    concurrentHashMap2.remove(str6);
                                                }
                                            }
                                        }
                                    } else {
                                        i9 = i10;
                                    }
                                    StringBuilder sb = new StringBuilder("🚩 400 ERROR for ts=");
                                    sb.append(j5);
                                    sb.append(" (live=");
                                    sb.append(j9);
                                    sb.append("). Retry ");
                                    int i11 = i9;
                                    sb.append(i11);
                                    Log.w("TelegramNTgCallsManager", sb.toString());
                                    if (i11 < 10) {
                                        w.j(eVar, null, new h(kVar, fVar, k0Var, concurrentHashMap3, i11, (r7.c) null, 2), 3);
                                    }
                                    while (concurrentLinkedQueue.size() > 1500) {
                                        String str7 = (String) concurrentLinkedQueue.poll();
                                        if (str7 != null) {
                                            concurrentHashMap2.remove(str7);
                                        }
                                    }
                                } else if ((intValue == 0 || intValue == 404) && i10 < 4) {
                                    Log.v("TelegramNTgCallsManager", "⏳ Retry " + i10 + " segment ts=" + j5 + " (status=" + intValue + ")");
                                    w.j(eVar, null, new h(i10, kVar, fVar, k0Var, concurrentHashMap7, (r7.c) null, 3), 3);
                                } else {
                                    Comparable comparable = null;
                                    concurrentHashMap5.remove(str);
                                    kVar.E.incrementAndGet();
                                    Log.e("TelegramNTgCallsManager", "❌ Dropping segment ts=" + j5 + " (attempts EXHAUSTED) — marking as FAILED");
                                    concurrentHashMap6.put(Long.valueOf(j5), Boolean.TRUE);
                                    if (concurrentHashMap6.size() > 200) {
                                        Set keySet = concurrentHashMap6.keySet();
                                        keySet.getClass();
                                        Iterator it = keySet.iterator();
                                        if (it.hasNext()) {
                                            comparable = (Comparable) it.next();
                                            while (it.hasNext()) {
                                                Comparable comparable2 = (Comparable) it.next();
                                                if (comparable.compareTo(comparable2) > 0) {
                                                    comparable = comparable2;
                                                }
                                            }
                                        }
                                        Long l4 = (Long) comparable;
                                        if (l4 != null) {
                                            concurrentHashMap6.remove(l4);
                                        }
                                    }
                                    NativeInstance nativeInstance = kVar.f6730d;
                                    if (nativeInstance != null) {
                                        nativeInstance.onStreamPartAvailable(fVar.f6698i, null, intValue < 0 ? 0 : intValue, 0L, fVar.f6700k, fVar.f6701l);
                                    }
                                    long j10 = atomicLong.get();
                                    if (j10 > 0) {
                                        long j11 = j10 - j5;
                                        if (j11 > l1.k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
                                            Log.w("TelegramNTgCallsManager", "⚡ LIVE LAG DETECTED: ts=" + j5 + " is " + j11 + "ms behind live. Triggering resync.");
                                            p8.d dVar = c0.f5250a;
                                            w.j(eVar, o.f7529a, new i(kVar, fVar, j10, null), 2);
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            concurrentHashMap = r11;
                            while (concurrentLinkedQueue.size() > 1500) {
                                String str8 = (String) concurrentLinkedQueue.poll();
                                if (str8 != null) {
                                    concurrentHashMap.remove(str8);
                                }
                            }
                            throw th;
                        }
                    }
                    while (concurrentLinkedQueue.size() > 1500) {
                        String str9 = (String) concurrentLinkedQueue.poll();
                        if (str9 != null) {
                            concurrentHashMap2.remove(str9);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    concurrentHashMap = concurrentHashMap4;
                }
            }
            return n7.g.f7490c;
        } catch (Throwable th3) {
            th = th3;
            concurrentHashMap = concurrentHashMap4;
        }
    }
}
