package i3;

import android.view.View;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4657a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f4658b;

    /* renamed from: c, reason: collision with root package name */
    public int f4659c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4660d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4661e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4662f;

    public u(int i9) {
        this.f4658b = i9;
        byte[] bArr = new byte[131];
        this.f4662f = bArr;
        bArr[2] = 1;
    }

    public void a(int i9, int i10, byte[] bArr) {
        if (this.f4660d) {
            int i11 = i10 - i9;
            byte[] bArr2 = (byte[]) this.f4662f;
            int length = bArr2.length;
            int i12 = this.f4659c + i11;
            if (length < i12) {
                this.f4662f = Arrays.copyOf(bArr2, i12 * 2);
            }
            System.arraycopy(bArr, i9, (byte[]) this.f4662f, this.f4659c, i11);
            this.f4659c += i11;
        }
    }

    public void b() {
        boolean z8 = this.f4660d;
        androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f4662f;
        this.f4659c = z8 ? hVar.g() : hVar.k();
    }

    public void c(View view, int i9) {
        androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f4662f;
        int l4 = Integer.MIN_VALUE == hVar.f617a ? 0 : hVar.l() - hVar.f617a;
        if (l4 >= 0) {
            boolean z8 = this.f4660d;
            androidx.emoji2.text.h hVar2 = (androidx.emoji2.text.h) this.f4662f;
            if (z8) {
                int b9 = hVar2.b(view);
                androidx.emoji2.text.h hVar3 = (androidx.emoji2.text.h) this.f4662f;
                this.f4659c = (Integer.MIN_VALUE != hVar3.f617a ? hVar3.l() - hVar3.f617a : 0) + b9;
            } else {
                this.f4659c = hVar2.e(view);
            }
            this.f4658b = i9;
            return;
        }
        this.f4658b = i9;
        boolean z9 = this.f4660d;
        androidx.emoji2.text.h hVar4 = (androidx.emoji2.text.h) this.f4662f;
        if (!z9) {
            int e9 = hVar4.e(view);
            int k3 = e9 - ((androidx.emoji2.text.h) this.f4662f).k();
            this.f4659c = e9;
            if (k3 > 0) {
                int g9 = (((androidx.emoji2.text.h) this.f4662f).g() - Math.min(0, (((androidx.emoji2.text.h) this.f4662f).g() - l4) - ((androidx.emoji2.text.h) this.f4662f).b(view))) - (((androidx.emoji2.text.h) this.f4662f).c(view) + e9);
                if (g9 < 0) {
                    this.f4659c -= Math.min(k3, -g9);
                    return;
                }
                return;
            }
            return;
        }
        int g10 = (hVar4.g() - l4) - ((androidx.emoji2.text.h) this.f4662f).b(view);
        this.f4659c = ((androidx.emoji2.text.h) this.f4662f).g() - g10;
        if (g10 > 0) {
            int c9 = this.f4659c - ((androidx.emoji2.text.h) this.f4662f).c(view);
            int k9 = ((androidx.emoji2.text.h) this.f4662f).k();
            int min = c9 - (Math.min(((androidx.emoji2.text.h) this.f4662f).e(view) - k9, 0) + k9);
            if (min < 0) {
                this.f4659c = Math.min(g10, -min) + this.f4659c;
            }
        }
    }

    public boolean d(int i9) {
        if (!this.f4660d) {
            return false;
        }
        this.f4659c -= i9;
        this.f4660d = false;
        this.f4661e = true;
        return true;
    }

    public final void e() {
        switch (this.f4657a) {
            case 0:
                this.f4660d = false;
                this.f4661e = false;
                break;
            default:
                this.f4658b = -1;
                this.f4659c = Integer.MIN_VALUE;
                this.f4660d = false;
                this.f4661e = false;
                break;
        }
    }

    public void f(int i9) {
        g1.a.k(!this.f4660d);
        boolean z8 = i9 == this.f4658b;
        this.f4660d = z8;
        if (z8) {
            this.f4659c = 3;
            this.f4661e = false;
        }
    }

    public String toString() {
        switch (this.f4657a) {
            case 1:
                return "AnchorInfo{mPosition=" + this.f4658b + ", mCoordinate=" + this.f4659c + ", mLayoutFromEnd=" + this.f4660d + ", mValid=" + this.f4661e + '}';
            default:
                return super.toString();
        }
    }

    public u() {
        e();
    }
}
