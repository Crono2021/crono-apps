package p1;

import android.text.TextUtils;
import d1.l0;
import d1.m0;
import d1.w;
import d2.d0;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements d2.m {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f8228g = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final String f8229a;

    /* renamed from: b, reason: collision with root package name */
    public final g1.u f8230b;

    /* renamed from: d, reason: collision with root package name */
    public d2.o f8232d;

    /* renamed from: f, reason: collision with root package name */
    public int f8234f;

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f8231c = new g1.p();

    /* renamed from: e, reason: collision with root package name */
    public byte[] f8233e = new byte[1024];

    public v(String str, g1.u uVar, z2.c cVar) {
        this.f8229a = str;
        this.f8230b = uVar;
    }

    public final d0 b(long j5) {
        d0 l4 = this.f8232d.l(0, 3);
        d1.r rVar = new d1.r();
        rVar.f2528l = l0.k("text/vtt");
        rVar.f2521d = this.f8229a;
        rVar.f2532p = j5;
        androidx.activity.g.v(rVar, l4);
        this.f8232d.c();
        return l4;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        throw new IllegalStateException();
    }

    @Override // d2.m
    public final void d(d2.o oVar) {
        this.f8232d = oVar;
        oVar.t(new d2.p(-9223372036854775807L));
    }

    @Override // d2.m
    public final boolean g(d2.n nVar) {
        d2.j jVar = (d2.j) nVar;
        jVar.n(this.f8233e, 0, 6, false);
        byte[] bArr = this.f8233e;
        g1.p pVar = this.f8231c;
        pVar.D(bArr, 6);
        if (h3.i.a(pVar)) {
            return true;
        }
        jVar.n(this.f8233e, 6, 3, false);
        pVar.D(this.f8233e, 9);
        return h3.i.a(pVar);
    }

    @Override // d2.m
    public final int h(d2.n nVar, w wVar) {
        String h9;
        this.f8232d.getClass();
        int e9 = (int) nVar.e();
        int i9 = this.f8234f;
        byte[] bArr = this.f8233e;
        if (i9 == bArr.length) {
            this.f8233e = Arrays.copyOf(bArr, ((e9 != -1 ? e9 : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f8233e;
        int i10 = this.f8234f;
        int read = nVar.read(bArr2, i10, bArr2.length - i10);
        if (read != -1) {
            int i11 = this.f8234f + read;
            this.f8234f = i11;
            if (e9 == -1 || i11 != e9) {
                return 0;
            }
        }
        g1.p pVar = new g1.p(this.f8233e);
        h3.i.d(pVar);
        String h10 = pVar.h(a6.b.f203c);
        long j5 = 0;
        long j9 = 0;
        while (true) {
            Matcher matcher = null;
            if (TextUtils.isEmpty(h10)) {
                while (true) {
                    String h11 = pVar.h(a6.b.f203c);
                    if (h11 == null) {
                        break;
                    }
                    if (h3.i.f3958a.matcher(h11).matches()) {
                        do {
                            h9 = pVar.h(a6.b.f203c);
                            if (h9 != null) {
                            }
                        } while (!h9.isEmpty());
                    } else {
                        Matcher matcher2 = h3.h.f3954a.matcher(h11);
                        if (matcher2.matches()) {
                            matcher = matcher2;
                            break;
                        }
                    }
                }
                if (matcher == null) {
                    b(0L);
                    return -1;
                }
                String group = matcher.group(1);
                group.getClass();
                long c9 = h3.i.c(group);
                long b9 = this.f8230b.b(((((j5 + c9) - j9) * 90000) / 1000000) % IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT);
                d0 b10 = b(b9 - c9);
                byte[] bArr3 = this.f8233e;
                int i12 = this.f8234f;
                g1.p pVar2 = this.f8231c;
                pVar2.D(bArr3, i12);
                b10.c(this.f8234f, pVar2);
                b10.d(b9, 1, this.f8234f, 0, null);
                return -1;
            }
            if (h10.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher3 = f8228g.matcher(h10);
                if (!matcher3.find()) {
                    throw m0.a(null, "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(h10));
                }
                Matcher matcher4 = h.matcher(h10);
                if (!matcher4.find()) {
                    throw m0.a(null, "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(h10));
                }
                String group2 = matcher3.group(1);
                group2.getClass();
                j9 = h3.i.c(group2);
                String group3 = matcher4.group(1);
                group3.getClass();
                j5 = (Long.parseLong(group3) * 1000000) / 90000;
            }
            h10 = pVar.h(a6.b.f203c);
        }
    }

    @Override // d2.m
    public final d2.m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
