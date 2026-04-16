package z1;

import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t {
    public static final a3.d h = new a3.d(15);

    /* renamed from: i, reason: collision with root package name */
    public static final a3.d f10599i = new a3.d(16);

    /* renamed from: a, reason: collision with root package name */
    public final int f10600a;

    /* renamed from: e, reason: collision with root package name */
    public int f10604e;

    /* renamed from: f, reason: collision with root package name */
    public int f10605f;

    /* renamed from: g, reason: collision with root package name */
    public int f10606g;

    /* renamed from: c, reason: collision with root package name */
    public final s[] f10602c = new s[5];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10601b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public int f10603d = -1;

    public t(int i9) {
        this.f10600a = i9;
    }

    public final void a(int i9, float f9) {
        s sVar;
        int i10 = this.f10603d;
        ArrayList arrayList = this.f10601b;
        if (i10 != 1) {
            Collections.sort(arrayList, h);
            this.f10603d = 1;
        }
        int i11 = this.f10606g;
        s[] sVarArr = this.f10602c;
        if (i11 > 0) {
            int i12 = i11 - 1;
            this.f10606g = i12;
            sVar = sVarArr[i12];
        } else {
            sVar = new s();
        }
        int i13 = this.f10604e;
        this.f10604e = i13 + 1;
        sVar.f10596a = i13;
        sVar.f10597b = i9;
        sVar.f10598c = f9;
        arrayList.add(sVar);
        this.f10605f += i9;
        while (true) {
            int i14 = this.f10605f;
            int i15 = this.f10600a;
            if (i14 <= i15) {
                return;
            }
            int i16 = i14 - i15;
            s sVar2 = (s) arrayList.get(0);
            int i17 = sVar2.f10597b;
            if (i17 <= i16) {
                this.f10605f -= i17;
                arrayList.remove(0);
                int i18 = this.f10606g;
                if (i18 < 5) {
                    this.f10606g = i18 + 1;
                    sVarArr[i18] = sVar2;
                }
            } else {
                sVar2.f10597b = i17 - i16;
                this.f10605f -= i16;
            }
        }
    }

    public final float b() {
        int i9 = this.f10603d;
        ArrayList arrayList = this.f10601b;
        if (i9 != 0) {
            Collections.sort(arrayList, f10599i);
            this.f10603d = 0;
        }
        float f9 = 0.5f * this.f10605f;
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            s sVar = (s) arrayList.get(i11);
            i10 += sVar.f10597b;
            if (i10 >= f9) {
                return sVar.f10598c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((s) arrayList.get(arrayList.size() - 1)).f10598c;
    }
}
