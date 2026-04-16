package a3;

import b6.v0;
import b6.w;
import b6.y;
import d1.s;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import l3.c0;
import y1.n;
import y1.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f74i;

    public /* synthetic */ d(int i9) {
        this.f74i = i9;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f74i) {
            case 0:
                return Integer.compare(((e) obj2).f77b, ((e) obj).f77b);
            case 1:
                return Integer.compare(((h3.d) obj).f3936a.f3939b, ((h3.d) obj2).f3936a.f3939b);
            case 2:
                return Long.compare(((h3.c) obj).f3933b, ((h3.c) obj2).f3933b);
            case 3:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i9 = 0; i9 < bArr.length; i9++) {
                    byte b9 = bArr[i9];
                    byte b10 = bArr2[i9];
                    if (b9 != b10) {
                        return b9 - b10;
                    }
                }
                return 0;
            case 4:
                c0 c0Var = (c0) obj;
                c0 c0Var2 = (c0) obj2;
                int compare = Integer.compare(c0Var2.f6100b, c0Var.f6100b);
                if (compare != 0) {
                    return compare;
                }
                int compareTo = c0Var.f6101c.compareTo(c0Var2.f6101c);
                return compareTo != 0 ? compareTo : c0Var.f6102d.compareTo(c0Var2.f6102d);
            case 5:
                c0 c0Var3 = (c0) obj;
                c0 c0Var4 = (c0) obj2;
                int compare2 = Integer.compare(c0Var4.f6099a, c0Var3.f6099a);
                if (compare2 != 0) {
                    return compare2;
                }
                int compareTo2 = c0Var4.f6101c.compareTo(c0Var3.f6101c);
                return compareTo2 != 0 ? compareTo2 : c0Var4.f6102d.compareTo(c0Var3.f6102d);
            case 6:
                return ((s) obj2).f2550i - ((s) obj).f2550i;
            case 7:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                if (num.intValue() == -1) {
                    return num2.intValue() == -1 ? 0 : -1;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
            case 8:
                v0 v0Var = o.f10473j;
                return 0;
            case 9:
                return Integer.compare(((y1.f) ((List) obj).get(0)).f10428n, ((y1.f) ((List) obj2).get(0)).f10428n);
            case 10:
                return ((y1.e) Collections.max((List) obj)).compareTo((y1.e) Collections.max((List) obj2));
            case 11:
                List list = (List) obj;
                List list2 = (List) obj2;
                int i10 = 13;
                int i11 = 14;
                return w.f(n.c((n) Collections.max(list, new d(i10)), (n) Collections.max(list2, new d(i10)))).a(list.size(), list2.size()).b((n) Collections.max(list, new d(i11)), (n) Collections.max(list2, new d(i11)), new d(i11)).e();
            case 12:
                return ((y1.k) ((List) obj).get(0)).compareTo((y1.k) ((List) obj2).get(0));
            case 13:
                return n.c((n) obj, (n) obj2);
            case 14:
                n nVar = (n) obj;
                n nVar2 = (n) obj2;
                boolean z8 = nVar.f10459m;
                int i12 = nVar.f10464r;
                v0 a9 = (z8 && nVar.f10462p) ? o.f10473j : o.f10473j.a();
                Integer valueOf = Integer.valueOf(i12);
                Integer valueOf2 = Integer.valueOf(nVar2.f10464r);
                nVar.f10460n.getClass();
                return y.f1469a.b(valueOf, valueOf2, o.f10474k).b(Integer.valueOf(nVar.f10465s), Integer.valueOf(nVar2.f10465s), a9).b(Integer.valueOf(i12), Integer.valueOf(nVar2.f10464r), a9).e();
            case 15:
                return ((z1.s) obj).f10596a - ((z1.s) obj2).f10596a;
            default:
                return Float.compare(((z1.s) obj).f10598c, ((z1.s) obj2).f10598c);
        }
    }
}
