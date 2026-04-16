package e3;

import a6.b;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import b6.g0;
import g1.c;
import g1.p;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z2.f;
import z2.k;
import z2.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements l {

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f3082l = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f3083m = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: i, reason: collision with root package name */
    public final StringBuilder f3084i = new StringBuilder();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f3085j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final p f3086k = new p();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x006f, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008b, code lost:
    
        if (r21.equals("{\\an9}") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009b, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
    
        if (r21.equals("{\\an8}") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0099, code lost:
    
        if (r21.equals("{\\an7}") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b0, code lost:
    
        if (r21.equals("{\\an3}") != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c0, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b7, code lost:
    
        if (r21.equals("{\\an2}") != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00be, code lost:
    
        if (r21.equals("{\\an1}") != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0053, code lost:
    
        if (r21.equals("{\\an7}") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007c, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x005a, code lost:
    
        if (r21.equals("{\\an6}") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0066, code lost:
    
        if (r21.equals("{\\an4}") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x006d, code lost:
    
        if (r21.equals("{\\an3}") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x007a, code lost:
    
        if (r21.equals("{\\an1}") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0047, code lost:
    
        if (r21.equals("{\\an9}") != false) goto L25;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f1.b a(android.text.Spanned r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.a.a(android.text.Spanned, java.lang.String):f1.b");
    }

    public static long b(Matcher matcher, int i9) {
        String group = matcher.group(i9 + 1);
        long parseLong = group != null ? Long.parseLong(group) * 3600000 : 0L;
        String group2 = matcher.group(i9 + 2);
        group2.getClass();
        long parseLong2 = (Long.parseLong(group2) * 60000) + parseLong;
        String group3 = matcher.group(i9 + 3);
        group3.getClass();
        long parseLong3 = (Long.parseLong(group3) * 1000) + parseLong2;
        String group4 = matcher.group(i9 + 4);
        if (group4 != null) {
            parseLong3 += Long.parseLong(group4);
        }
        return parseLong3 * 1000;
    }

    @Override // z2.l
    public final void a0(byte[] bArr, int i9, int i10, k kVar, c cVar) {
        String h;
        String str;
        a aVar = this;
        long j5 = kVar.f10621a;
        p pVar = aVar.f3086k;
        pVar.D(bArr, i9 + i10);
        pVar.F(i9);
        Charset B = pVar.B();
        if (B == null) {
            B = b.f203c;
        }
        long j9 = -9223372036854775807L;
        ArrayList arrayList = (j5 == -9223372036854775807L || !kVar.f10622b) ? null : new ArrayList();
        while (true) {
            String h9 = pVar.h(B);
            if (h9 == null) {
                break;
            }
            if (h9.length() != 0) {
                try {
                    Integer.parseInt(h9);
                    h = pVar.h(B);
                } catch (NumberFormatException unused) {
                    g1.a.D("SubripParser", "Skipping invalid index: ".concat(h9));
                }
                if (h == null) {
                    g1.a.D("SubripParser", "Unexpected end");
                    break;
                }
                Matcher matcher = f3082l.matcher(h);
                if (matcher.matches()) {
                    long b9 = b(matcher, 1);
                    long b10 = b(matcher, 6);
                    StringBuilder sb = aVar.f3084i;
                    sb.setLength(0);
                    ArrayList arrayList2 = aVar.f3085j;
                    arrayList2.clear();
                    String h10 = pVar.h(B);
                    while (!TextUtils.isEmpty(h10)) {
                        long j10 = j9;
                        if (sb.length() > 0) {
                            sb.append("<br>");
                        }
                        String trim = h10.trim();
                        StringBuilder sb2 = new StringBuilder(trim);
                        Matcher matcher2 = f3083m.matcher(trim);
                        int i11 = 0;
                        while (matcher2.find()) {
                            String group = matcher2.group();
                            arrayList2.add(group);
                            int start = matcher2.start() - i11;
                            int length = group.length();
                            sb2.replace(start, start + length, "");
                            i11 += length;
                            j5 = j5;
                        }
                        sb.append(sb2.toString());
                        h10 = pVar.h(B);
                        j9 = j10;
                    }
                    long j11 = j5;
                    long j12 = j9;
                    Spanned fromHtml = Html.fromHtml(sb.toString());
                    int i12 = 0;
                    while (true) {
                        if (i12 >= arrayList2.size()) {
                            str = null;
                            break;
                        }
                        str = (String) arrayList2.get(i12);
                        if (str.matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                    if (j11 == j12 || b9 >= j11) {
                        cVar.accept(new z2.a(b9, b10 - b9, g0.q(a(fromHtml, str))));
                    } else if (arrayList != null) {
                        arrayList.add(new z2.a(b9, b10 - b9, g0.q(a(fromHtml, str))));
                    }
                    aVar = this;
                    j9 = j12;
                    j5 = j11;
                } else {
                    g1.a.D("SubripParser", "Skipping invalid timing: ".concat(h));
                    aVar = this;
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayList.get(i13);
                i13++;
                cVar.accept((z2.a) obj);
            }
        }
    }

    @Override // z2.l
    public final /* synthetic */ f h0(int i9, int i10, byte[] bArr) {
        return t.a.a(this, bArr, i10);
    }

    @Override // z2.l
    public final /* synthetic */ void reset() {
    }
}
