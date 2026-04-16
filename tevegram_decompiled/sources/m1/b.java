package m1;

import android.content.Context;
import android.graphics.ImageDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import d1.k0;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import k4.a0;
import o3.d1;
import o3.j1;
import o3.m0;
import o3.m1;
import org.webrtc.PeerConnectionFactory;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements n0.r, q1.p, z1.q {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6509i;

    /* renamed from: j, reason: collision with root package name */
    public Object f6510j;

    /* renamed from: k, reason: collision with root package name */
    public Object f6511k;

    public b(int i9) {
        this.f6509i = i9;
        switch (i9) {
            case 7:
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED);
                this.f6510j = byteArrayOutputStream;
                this.f6511k = new DataOutputStream(byteArrayOutputStream);
                break;
            case 8:
                this.f6510j = new SparseIntArray();
                this.f6511k = new SparseIntArray();
                break;
            case 11:
                this.f6510j = new s.h();
                this.f6511k = new s.g();
                break;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                this.f6510j = new AtomicReference();
                this.f6511k = new s.d();
                break;
            case 17:
                this.f6510j = new ArrayList();
                this.f6511k = new HashMap();
                break;
            default:
                this.f6510j = new HashMap();
                this.f6511k = new HashMap();
                break;
        }
    }

    public static a0 g(ImageDecoder.Source source, int i9, int i10, b4.i iVar) {
        Drawable decodeDrawable;
        decodeDrawable = ImageDecoder.decodeDrawable(source, new j4.b(i9, i10, iVar));
        if (androidx.emoji2.text.b.x(decodeDrawable)) {
            return new a0(androidx.emoji2.text.b.h(decodeDrawable), 2);
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + decodeDrawable);
    }

    public static int n(int i9, int i10) {
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i9; i13++) {
            i11++;
            if (i11 == i10) {
                i12++;
                i11 = 0;
            } else if (i11 > i10) {
                i12++;
                i11 = 1;
            }
        }
        return i11 + 1 > i10 ? i12 + 1 : i12;
    }

    @Override // z1.q
    public q1.m a(Uri uri, i1.j jVar) {
        q1.m a9 = ((z1.q) this.f6510j).a(uri, jVar);
        List list = (List) this.f6511k;
        return (list == null || list.isEmpty()) ? a9 : (q1.m) a9.a(list);
    }

    public void b(d1 d1Var, k0 k0Var) {
        s.h hVar = (s.h) this.f6510j;
        m1 m1Var = (m1) hVar.getOrDefault(d1Var, null);
        if (m1Var == null) {
            m1Var = m1.a();
            hVar.put(d1Var, m1Var);
        }
        m1Var.f7737c = k0Var;
        m1Var.f7735a |= 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    @Override // n0.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n0.a2 c(android.view.View r17, n0.a2 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.Object r3 = r0.f6510j
            d1.p r3 = (d1.p) r3
            java.lang.Object r4 = r0.f6511k
            b2.l r4 = (b2.l) r4
            int r5 = r4.f1212a
            int r6 = r4.f1213b
            int r4 = r4.f1214c
            n0.x1 r7 = r2.f7139a
            r8 = 7
            f0.c r8 = r7.f(r8)
            r9 = 32
            f0.c r7 = r7.f(r9)
            java.lang.Object r9 = r3.f2514b
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r9
            int r10 = r8.f3194b
            int r11 = r8.f3195c
            int r12 = r8.f3193a
            r9.f1945w = r10
            boolean r10 = o5.o.e(r1)
            int r13 = r1.getPaddingBottom()
            int r14 = r1.getPaddingLeft()
            int r15 = r1.getPaddingRight()
            boolean r0 = r9.f1937o
            if (r0 == 0) goto L48
            int r13 = r2.a()
            r9.f1944v = r13
            int r13 = r13 + r4
        L48:
            boolean r4 = r9.f1938p
            if (r4 == 0) goto L53
            if (r10 == 0) goto L50
            r4 = r6
            goto L51
        L50:
            r4 = r5
        L51:
            int r14 = r4 + r12
        L53:
            boolean r4 = r9.f1939q
            if (r4 == 0) goto L5d
            if (r10 == 0) goto L5a
            goto L5b
        L5a:
            r5 = r6
        L5b:
            int r15 = r5 + r11
        L5d:
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            boolean r5 = r9.f1941s
            r6 = 1
            if (r5 == 0) goto L70
            int r5 = r4.leftMargin
            if (r5 == r12) goto L70
            r4.leftMargin = r12
            r5 = 1
            goto L71
        L70:
            r5 = 0
        L71:
            boolean r10 = r9.f1942t
            if (r10 == 0) goto L7c
            int r10 = r4.rightMargin
            if (r10 == r11) goto L7c
            r4.rightMargin = r11
            r5 = 1
        L7c:
            boolean r10 = r9.f1943u
            if (r10 == 0) goto L89
            int r10 = r4.topMargin
            int r8 = r8.f3194b
            if (r10 == r8) goto L89
            r4.topMargin = r8
            goto L8a
        L89:
            r6 = r5
        L8a:
            if (r6 == 0) goto L8f
            r1.setLayoutParams(r4)
        L8f:
            int r4 = r1.getPaddingTop()
            r1.setPadding(r14, r4, r15, r13)
            boolean r1 = r3.f2513a
            if (r1 == 0) goto L9e
            int r3 = r7.f3196d
            r9.f1935m = r3
        L9e:
            if (r0 != 0) goto La4
            if (r1 == 0) goto La3
            goto La4
        La3:
            return r2
        La4:
            r9.J()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.b.c(android.view.View, n0.a2):n0.a2");
    }

    @Override // q1.p
    public z1.q d(q1.l lVar, q1.i iVar) {
        return new b(((q1.p) this.f6510j).d(lVar, iVar), 18, (List) this.f6511k);
    }

    public void e() {
        int[] iArr = (int[]) this.f6510j;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f6511k = null;
    }

    public boolean f(int i9) {
        return ((d1.q) this.f6510j).f2516a.get(i9);
    }

    public void h(l1.f fVar) {
        synchronized (fVar) {
        }
        Handler handler = (Handler) this.f6510j;
        if (handler != null) {
            handler.post(new n1.m(this, fVar, 1));
        }
    }

    public void i(int i9) {
        int[] iArr = (int[]) this.f6510j;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i9, 10) + 1];
            this.f6510j = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i9 >= iArr.length) {
            int length = iArr.length;
            while (length <= i9) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f6510j = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f6510j;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public View j(int i9, int i10, int i11, int i12) {
        View u3;
        d3.a aVar = (d3.a) this.f6511k;
        m0 m0Var = (m0) this.f6510j;
        int d9 = m0Var.d();
        int c9 = m0Var.c();
        int i13 = i10 > i9 ? 1 : -1;
        View view = null;
        while (i9 != i10) {
            switch (m0Var.f7732a) {
                case 0:
                    u3 = m0Var.f7733b.u(i9);
                    break;
                default:
                    u3 = m0Var.f7733b.u(i9);
                    break;
            }
            int b9 = m0Var.b(u3);
            int a9 = m0Var.a(u3);
            aVar.f2759b = d9;
            aVar.f2760c = c9;
            aVar.f2761d = b9;
            aVar.f2762e = a9;
            if (i11 != 0) {
                aVar.f2758a = i11;
                if (aVar.a()) {
                    return u3;
                }
            }
            if (i12 != 0) {
                aVar.f2758a = i12;
                if (aVar.a()) {
                    view = u3;
                }
            }
            i9 += i13;
        }
        return view;
    }

    public synchronized List k(String str) {
        List list;
        try {
            if (!((ArrayList) this.f6510j).contains(str)) {
                ((ArrayList) this.f6510j).add(str);
            }
            list = (List) ((HashMap) this.f6511k).get(str);
            if (list == null) {
                list = new ArrayList();
                ((HashMap) this.f6511k).put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    @Override // q1.p
    public z1.q l() {
        return new b(((q1.p) this.f6510j).l(), 18, (List) this.f6511k);
    }

    public synchronized ArrayList m(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.f6510j;
        int size = arrayList2.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList2.get(i9);
            i9++;
            List<r4.c> list = (List) ((HashMap) this.f6511k).get((String) obj);
            if (list != null) {
                for (r4.c cVar : list) {
                    if ((cVar.f8552a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.f8553b)) && !arrayList.contains(cVar.f8553b)) {
                        arrayList.add(cVar.f8553b);
                    }
                }
            }
        }
        return arrayList;
    }

    public void o() {
        ((SparseIntArray) this.f6510j).clear();
    }

    public boolean p(View view) {
        d3.a aVar = (d3.a) this.f6511k;
        m0 m0Var = (m0) this.f6510j;
        int d9 = m0Var.d();
        int c9 = m0Var.c();
        int b9 = m0Var.b(view);
        int a9 = m0Var.a(view);
        aVar.f2759b = d9;
        aVar.f2760c = c9;
        aVar.f2761d = b9;
        aVar.f2762e = a9;
        aVar.f2758a = 24579;
        return aVar.a();
    }

    public void q(int i9, int i10) {
        int[] iArr = (int[]) this.f6510j;
        if (iArr == null || i9 >= iArr.length) {
            return;
        }
        int i11 = i9 + i10;
        i(i11);
        int[] iArr2 = (int[]) this.f6510j;
        System.arraycopy(iArr2, i9, iArr2, i11, (iArr2.length - i9) - i10);
        Arrays.fill((int[]) this.f6510j, i9, i11, -1);
        ArrayList arrayList = (ArrayList) this.f6511k;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            j1 j1Var = (j1) ((ArrayList) this.f6511k).get(size);
            int i12 = j1Var.f7692i;
            if (i12 >= i9) {
                j1Var.f7692i = i12 + i10;
            }
        }
    }

    public void r(int i9, int i10) {
        int[] iArr = (int[]) this.f6510j;
        if (iArr == null || i9 >= iArr.length) {
            return;
        }
        int i11 = i9 + i10;
        i(i11);
        int[] iArr2 = (int[]) this.f6510j;
        System.arraycopy(iArr2, i11, iArr2, i9, (iArr2.length - i9) - i10);
        int[] iArr3 = (int[]) this.f6510j;
        Arrays.fill(iArr3, iArr3.length - i10, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.f6511k;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            j1 j1Var = (j1) ((ArrayList) this.f6511k).get(size);
            int i12 = j1Var.f7692i;
            if (i12 >= i9) {
                if (i12 < i11) {
                    ((ArrayList) this.f6511k).remove(size);
                } else {
                    j1Var.f7692i = i12 - i10;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01c1, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.b.s(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public k0 t(d1 d1Var, int i9) {
        m1 m1Var;
        k0 k0Var;
        s.h hVar = (s.h) this.f6510j;
        int e9 = hVar.e(d1Var);
        if (e9 >= 0 && (m1Var = (m1) hVar.l(e9)) != null) {
            int i10 = m1Var.f7735a;
            if ((i10 & i9) != 0) {
                int i11 = i10 & (~i9);
                m1Var.f7735a = i11;
                if (i9 == 4) {
                    k0Var = m1Var.f7736b;
                } else {
                    if (i9 != 8) {
                        m7.c.n("Must provide flag PRE or POST");
                        return null;
                    }
                    k0Var = m1Var.f7737c;
                }
                if ((i11 & 12) == 0) {
                    hVar.j(e9);
                    m1Var.f7735a = 0;
                    m1Var.f7736b = null;
                    m1Var.f7737c = null;
                    m1.f7734d.a(m1Var);
                }
                return k0Var;
            }
        }
        return null;
    }

    public String toString() {
        switch (this.f6509i) {
            case 4:
                return "Bounds{lower=" + ((f0.c) this.f6510j) + " upper=" + ((f0.c) this.f6511k) + "}";
            default:
                return super.toString();
        }
    }

    public void u(Class cls, Class cls2, Class cls3, List list) {
        synchronized (((s.d) this.f6511k)) {
            ((s.d) this.f6511k).put(new w4.l(cls, cls2, cls3), list);
        }
    }

    public void v(d1 d1Var) {
        m1 m1Var = (m1) ((s.h) this.f6510j).getOrDefault(d1Var, null);
        if (m1Var == null) {
            return;
        }
        m1Var.f7735a &= -2;
    }

    public void w(d1 d1Var) {
        s.g gVar = (s.g) this.f6511k;
        int g9 = gVar.g() - 1;
        while (true) {
            if (g9 < 0) {
                break;
            }
            if (d1Var == gVar.h(g9)) {
                Object[] objArr = gVar.f8645k;
                Object obj = objArr[g9];
                Object obj2 = s.g.f8642m;
                if (obj != obj2) {
                    objArr[g9] = obj2;
                    gVar.f8643i = true;
                }
            } else {
                g9--;
            }
        }
        m1 m1Var = (m1) ((s.h) this.f6510j).remove(d1Var);
        if (m1Var != null) {
            m1Var.f7735a = 0;
            m1Var.f7736b = null;
            m1Var.f7737c = null;
            m1.f7734d.a(m1Var);
        }
    }

    public void x(int i9, int i10, int i11, int i12) {
        CardView cardView = (CardView) this.f6511k;
        cardView.f528l.set(i9, i10, i11, i12);
        Rect rect = cardView.f527k;
        super/*android.widget.FrameLayout*/.setPadding(i9 + rect.left, i10 + rect.top, i11 + rect.right, i12 + rect.bottom);
    }

    public /* synthetic */ b(Object obj, int i9, Object obj2) {
        this.f6509i = i9;
        this.f6510j = obj;
        this.f6511k = obj2;
    }

    public /* synthetic */ b(int i9, boolean z8) {
        this.f6509i = i9;
    }

    public b(m6.o oVar) {
        this.f6509i = 2;
        this.f6510j = new HashMap(oVar.f6674a);
        this.f6511k = new HashMap(oVar.f6675b);
    }

    public b(Context context) {
        this.f6509i = 6;
        this.f6510j = context;
    }

    public b(Runnable runnable) {
        this.f6509i = 3;
        this.f6511k = new CopyOnWriteArrayList();
        new HashMap();
        this.f6510j = runnable;
    }

    public b(d1.q qVar, SparseArray sparseArray) {
        this.f6509i = 0;
        this.f6510j = qVar;
        SparseBooleanArray sparseBooleanArray = qVar.f2516a;
        SparseArray sparseArray2 = new SparseArray(sparseBooleanArray.size());
        for (int i9 = 0; i9 < sparseBooleanArray.size(); i9++) {
            int a9 = qVar.a(i9);
            a aVar = (a) sparseArray.get(a9);
            aVar.getClass();
            sparseArray2.append(a9, aVar);
        }
        this.f6511k = sparseArray2;
    }

    public b(m0 m0Var) {
        this.f6509i = 10;
        this.f6510j = m0Var;
        d3.a aVar = new d3.a();
        aVar.f2758a = 0;
        this.f6511k = aVar;
    }

    public b(Handler handler, n1.q qVar) {
        this.f6509i = 5;
        if (qVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.f6510j = handler;
        this.f6511k = qVar;
    }

    public b(EditText editText) {
        this.f6509i = 19;
        this.f6510j = editText;
        x0.h hVar = new x0.h(editText);
        this.f6511k = hVar;
        editText.addTextChangedListener(hVar);
        if (x0.a.f10022b == null) {
            synchronized (x0.a.f10021a) {
                try {
                    if (x0.a.f10022b == null) {
                        x0.a aVar = new x0.a();
                        try {
                            x0.a.f10023c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, x0.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        x0.a.f10022b = aVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(x0.a.f10022b);
    }

    public b(CardView cardView) {
        this.f6509i = 15;
        this.f6511k = cardView;
    }
}
