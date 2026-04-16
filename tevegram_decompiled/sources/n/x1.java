package n;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class x1 extends ListView {

    /* renamed from: i, reason: collision with root package name */
    public final Rect f7088i;

    /* renamed from: j, reason: collision with root package name */
    public int f7089j;

    /* renamed from: k, reason: collision with root package name */
    public int f7090k;

    /* renamed from: l, reason: collision with root package name */
    public int f7091l;

    /* renamed from: m, reason: collision with root package name */
    public int f7092m;

    /* renamed from: n, reason: collision with root package name */
    public int f7093n;

    /* renamed from: o, reason: collision with root package name */
    public v1 f7094o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7095p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f7096q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7097r;

    /* renamed from: s, reason: collision with root package name */
    public r0.g f7098s;

    /* renamed from: t, reason: collision with root package name */
    public androidx.activity.j f7099t;

    public x1(Context context, boolean z8) {
        super(context, null, 2130968964);
        this.f7088i = new Rect();
        this.f7089j = 0;
        this.f7090k = 0;
        this.f7091l = 0;
        this.f7092m = 0;
        this.f7096q = z8;
        setCacheColorHint(0);
    }

    public final int a(int i9, int i10) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i11 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i12 = 0;
        for (int i13 = 0; i13 < count; i13++) {
            int itemViewType = adapter.getItemViewType(i13);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            view = adapter.getView(i13, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i14 = layoutParams.height;
            view.measure(i9, i14 > 0 ? View.MeasureSpec.makeMeasureSpec(i14, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i13 > 0) {
                i11 += dividerHeight;
            }
            i11 += view.getMeasuredHeight();
            if (i11 >= i10) {
                return i10;
            }
        }
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r3 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r18, int r19) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.x1.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f7088i;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f7099t != null) {
            return;
        }
        super.drawableStateChanged();
        v1 v1Var = this.f7094o;
        if (v1Var != null) {
            v1Var.f7072j = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f7097r && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f7096q || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f7096q || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f7096q || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f7096q && this.f7095p) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f7099t = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        int i10 = 10;
        if (actionMasked == 10 && this.f7099t == null) {
            androidx.activity.j jVar = new androidx.activity.j(this, i10);
            this.f7099t = jVar;
            post(jVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return onHoverEvent;
        }
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i9 < 30 || !t1.f7047d) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                } else {
                    try {
                        t1.f7044a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                        t1.f7045b.invoke(this, Integer.valueOf(pointToPosition));
                        t1.f7046c.invoke(this, Integer.valueOf(pointToPosition));
                    } catch (IllegalAccessException e9) {
                        e9.printStackTrace();
                    } catch (InvocationTargetException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f7097r && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f7093n = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        androidx.activity.j jVar = this.f7099t;
        if (jVar != null) {
            x1 x1Var = (x1) jVar.f292j;
            x1Var.f7099t = null;
            x1Var.removeCallbacks(jVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z8) {
        this.f7095p = z8;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        v1 v1Var;
        if (drawable != null) {
            v1Var = new v1(drawable);
            v1Var.f7072j = true;
        } else {
            v1Var = null;
        }
        this.f7094o = v1Var;
        super.setSelector(v1Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f7089j = rect.left;
        this.f7090k = rect.top;
        this.f7091l = rect.right;
        this.f7092m = rect.bottom;
    }
}
