package c5;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import n.f4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements View.OnLayoutChangeListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1635i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1636j;

    public /* synthetic */ a(Object obj, int i9) {
        this.f1635i = i9;
        this.f1636j = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        switch (this.f1635i) {
            case 0:
                throw null;
            default:
                SearchView searchView = (SearchView) this.f1636j;
                SearchView.SearchAutoComplete searchAutoComplete = searchView.f467x;
                View view2 = searchView.F;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.f469z.getPaddingLeft();
                    Rect rect = new Rect();
                    boolean a9 = f4.a(searchView);
                    int dimensionPixelSize = searchView.U ? resources.getDimensionPixelSize(2131165226) + resources.getDimensionPixelSize(2131165225) : 0;
                    searchAutoComplete.getDropDownBackground().getPadding(rect);
                    int i17 = rect.left;
                    searchAutoComplete.setDropDownHorizontalOffset(a9 ? -i17 : paddingLeft - (i17 + dimensionPixelSize));
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
                    return;
                }
                return;
        }
    }
}
