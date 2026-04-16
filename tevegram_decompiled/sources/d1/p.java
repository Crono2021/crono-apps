package d1;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseBooleanArray;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2513a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2514b;

    public p(int i9) {
        switch (i9) {
            case 1:
                this.f2514b = new Handler(Looper.getMainLooper(), new d4.d0(0));
                break;
            default:
                this.f2514b = new SparseBooleanArray();
                break;
        }
    }

    public void a(int i9) {
        g1.a.k(!this.f2513a);
        ((SparseBooleanArray) this.f2514b).append(i9, true);
    }

    public q b() {
        g1.a.k(!this.f2513a);
        this.f2513a = true;
        return new q((SparseBooleanArray) this.f2514b);
    }

    public boolean c() {
        return this.f2513a;
    }

    public boolean d(CharSequence charSequence, int i9) {
        if (charSequence == null || i9 < 0 || charSequence.length() - i9 < 0) {
            m7.c.d();
            return false;
        }
        l0.h hVar = (l0.h) this.f2514b;
        if (hVar == null) {
            return c();
        }
        hVar.getClass();
        char c9 = 2;
        for (int i10 = 0; i10 < i9 && c9 == 2; i10++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i10));
            p pVar = l0.i.f5753a;
            if (directionality != 0) {
                if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                        case 17:
                            break;
                        default:
                            c9 = 2;
                            break;
                    }
                }
                c9 = 0;
            }
            c9 = 1;
        }
        if (c9 == 0) {
            return true;
        }
        if (c9 != 1) {
            return c();
        }
        return false;
    }

    public synchronized void e(d4.a0 a0Var, boolean z8) {
        try {
            if (!this.f2513a && !z8) {
                this.f2513a = true;
                a0Var.d();
                this.f2513a = false;
            }
            ((Handler) this.f2514b).obtainMessage(1, a0Var).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }

    public p(l0.h hVar, boolean z8) {
        this.f2514b = hVar;
        this.f2513a = z8;
    }

    public p(BottomSheetBehavior bottomSheetBehavior, boolean z8) {
        this.f2514b = bottomSheetBehavior;
        this.f2513a = z8;
    }
}
