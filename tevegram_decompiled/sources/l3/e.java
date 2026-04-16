package l3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e implements View.OnLayoutChangeListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6123i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6124j;

    public /* synthetic */ e(Object obj, int i9) {
        this.f6123i = i9;
        this.f6124j = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int height;
        int height2;
        switch (this.f6123i) {
            case 0:
                q qVar = (q) this.f6124j;
                int i17 = qVar.f6213t;
                PopupWindow popupWindow = qVar.f6211s;
                int i18 = i12 - i10;
                int i19 = i16 - i14;
                if ((i11 - i9 != i15 - i13 || i18 != i19) && popupWindow.isShowing()) {
                    qVar.q();
                    popupWindow.update(view, (qVar.getWidth() - popupWindow.getWidth()) - i17, (-popupWindow.getHeight()) - i17, -1, -1);
                    break;
                }
                break;
            default:
                v vVar = (v) this.f6124j;
                q qVar2 = vVar.f6236a;
                int width = (qVar2.getWidth() - qVar2.getPaddingLeft()) - qVar2.getPaddingRight();
                int height3 = (qVar2.getHeight() - qVar2.getPaddingBottom()) - qVar2.getPaddingTop();
                ViewGroup viewGroup = vVar.f6238c;
                int c9 = v.c(viewGroup) - (viewGroup != null ? viewGroup.getPaddingRight() + viewGroup.getPaddingLeft() : 0);
                if (viewGroup == null) {
                    height = 0;
                } else {
                    height = viewGroup.getHeight();
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        height += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }
                }
                int paddingBottom = height - (viewGroup != null ? viewGroup.getPaddingBottom() + viewGroup.getPaddingTop() : 0);
                int max = Math.max(c9, v.c(vVar.f6245k) + v.c(vVar.f6243i));
                ViewGroup viewGroup2 = vVar.f6239d;
                if (viewGroup2 == null) {
                    height2 = 0;
                } else {
                    height2 = viewGroup2.getHeight();
                    ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        height2 += marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                    }
                }
                boolean z8 = width <= max || height3 <= (height2 * 2) + paddingBottom;
                if (vVar.A != z8) {
                    vVar.A = z8;
                    view.post(new r(vVar, 1));
                }
                boolean z9 = i11 - i9 != i15 - i13;
                if (!vVar.A && z9) {
                    view.post(new r(vVar, 2));
                    break;
                }
                break;
        }
    }
}
