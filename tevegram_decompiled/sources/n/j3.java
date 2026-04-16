package n;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j3 extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6923a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j3(Class cls, String str, int i9) {
        super(cls, str);
        this.f6923a = i9;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f6923a) {
            case 0:
                return Float.valueOf(((SwitchCompat) obj).H);
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return null;
            case 6:
                return Float.valueOf(v3.r.f9551a.Z((View) obj));
            default:
                WeakHashMap weakHashMap = n0.t0.f7209a;
                return n0.e0.a((View) obj);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f6923a) {
            case 0:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 1:
                v3.e eVar = (v3.e) obj;
                PointF pointF = (PointF) obj2;
                eVar.getClass();
                eVar.f9508a = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                eVar.f9509b = round;
                int i9 = eVar.f9513f + 1;
                eVar.f9513f = i9;
                if (i9 == eVar.f9514g) {
                    v3.r.a(eVar.f9512e, eVar.f9508a, round, eVar.f9510c, eVar.f9511d);
                    eVar.f9513f = 0;
                    eVar.f9514g = 0;
                    break;
                }
                break;
            case 2:
                v3.e eVar2 = (v3.e) obj;
                PointF pointF2 = (PointF) obj2;
                eVar2.getClass();
                eVar2.f9510c = Math.round(pointF2.x);
                int round2 = Math.round(pointF2.y);
                eVar2.f9511d = round2;
                int i10 = eVar2.f9514g + 1;
                eVar2.f9514g = i10;
                if (eVar2.f9513f == i10) {
                    v3.r.a(eVar2.f9512e, eVar2.f9508a, eVar2.f9509b, eVar2.f9510c, round2);
                    eVar2.f9513f = 0;
                    eVar2.f9514g = 0;
                    break;
                }
                break;
            case 3:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                v3.r.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 4:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                v3.r.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 5:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int round3 = Math.round(pointF5.x);
                int round4 = Math.round(pointF5.y);
                v3.r.a(view3, round3, round4, view3.getWidth() + round3, view3.getHeight() + round4);
                break;
            case 6:
                float floatValue = ((Float) obj2).floatValue();
                v3.r.f9551a.a0((View) obj, floatValue);
                break;
            default:
                WeakHashMap weakHashMap = n0.t0.f7209a;
                n0.e0.c((View) obj, (Rect) obj2);
                break;
        }
    }
}
