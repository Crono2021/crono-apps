package y1;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import d1.c1;
import d1.d1;
import g1.w;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends d1 {
    public static final /* synthetic */ int C = 0;
    public final SparseArray A;
    public final SparseBooleanArray B;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f10438t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f10439u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f10440v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f10441w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f10442x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f10443y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f10444z;

    static {
        new i(new h());
        w.H(IjkMediaCodecInfo.RANK_MAX);
        w.H(1001);
        w.H(1002);
        w.H(1003);
        w.H(1004);
        androidx.activity.g.s(1005, 1006, 1007, 1008, 1009);
        androidx.activity.g.s(1010, 1011, 1012, 1013, 1014);
        w.H(1015);
        w.H(1016);
        w.H(1017);
        w.H(1018);
    }

    public i(h hVar) {
        super(hVar);
        this.f10438t = hVar.f10431t;
        this.f10439u = hVar.f10432u;
        this.f10440v = hVar.f10433v;
        this.f10441w = hVar.f10434w;
        this.f10442x = hVar.f10435x;
        this.f10443y = hVar.f10436y;
        this.f10444z = hVar.f10437z;
        this.A = hVar.A;
        this.B = hVar.B;
    }

    @Override // d1.d1
    public final c1 a() {
        return new h(this);
    }

    @Override // d1.d1
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (super.equals(iVar) && this.f10438t == iVar.f10438t && this.f10439u == iVar.f10439u && this.f10440v == iVar.f10440v && this.f10441w == iVar.f10441w && this.f10442x == iVar.f10442x && this.f10443y == iVar.f10443y && this.f10444z == iVar.f10444z) {
                SparseBooleanArray sparseBooleanArray = iVar.B;
                SparseBooleanArray sparseBooleanArray2 = this.B;
                int size = sparseBooleanArray2.size();
                if (sparseBooleanArray.size() == size) {
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size) {
                            SparseArray sparseArray = iVar.A;
                            SparseArray sparseArray2 = this.A;
                            int size2 = sparseArray2.size();
                            if (sparseArray.size() == size2) {
                                for (int i10 = 0; i10 < size2; i10++) {
                                    int indexOfKey = sparseArray.indexOfKey(sparseArray2.keyAt(i10));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray2.valueAt(i10);
                                        Map map2 = (Map) sparseArray.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                v1.c1 c1Var = (v1.c1) entry.getKey();
                                                if (map2.containsKey(c1Var) && w.a(entry.getValue(), map2.get(c1Var))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            if (sparseBooleanArray.indexOfKey(sparseBooleanArray2.keyAt(i9)) < 0) {
                                break;
                            }
                            i9++;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // d1.d1
    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.f10438t ? 1 : 0)) * 961) + (this.f10439u ? 1 : 0)) * 961) + (this.f10440v ? 1 : 0)) * 28629151) + (this.f10441w ? 1 : 0)) * 31) + (this.f10442x ? 1 : 0)) * 31) + (this.f10443y ? 1 : 0)) * 961) + (this.f10444z ? 1 : 0)) * 31;
    }
}
