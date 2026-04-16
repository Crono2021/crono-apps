package g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final boolean E;
    public final g F;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3539a;

    /* renamed from: b, reason: collision with root package name */
    public final k f3540b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f3541c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f3542d;

    /* renamed from: e, reason: collision with root package name */
    public String f3543e;

    /* renamed from: f, reason: collision with root package name */
    public AlertController$RecycleListView f3544f;

    /* renamed from: g, reason: collision with root package name */
    public View f3545g;

    /* renamed from: i, reason: collision with root package name */
    public Button f3546i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f3547j;

    /* renamed from: k, reason: collision with root package name */
    public Message f3548k;

    /* renamed from: l, reason: collision with root package name */
    public Button f3549l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f3550m;

    /* renamed from: n, reason: collision with root package name */
    public Message f3551n;

    /* renamed from: o, reason: collision with root package name */
    public Button f3552o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f3553p;

    /* renamed from: q, reason: collision with root package name */
    public Message f3554q;

    /* renamed from: r, reason: collision with root package name */
    public NestedScrollView f3555r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f3556s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f3557t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f3558u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f3559v;

    /* renamed from: w, reason: collision with root package name */
    public View f3560w;

    /* renamed from: x, reason: collision with root package name */
    public ListAdapter f3561x;

    /* renamed from: z, reason: collision with root package name */
    public final int f3563z;
    public boolean h = false;

    /* renamed from: y, reason: collision with root package name */
    public int f3562y = -1;
    public final com.google.android.material.datepicker.l G = new com.google.android.material.datepicker.l(this, 1);

    public i(Context context, k kVar, Window window) {
        this.f3539a = context;
        this.f3540b = kVar;
        this.f3541c = window;
        g gVar = new g();
        gVar.f3537b = new WeakReference(kVar);
        this.F = gVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f.a.f3170e, 2130968619, 0);
        this.f3563z = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.A = obtainStyledAttributes.getResourceId(4, 0);
        this.B = obtainStyledAttributes.getResourceId(5, 0);
        this.C = obtainStyledAttributes.getResourceId(7, 0);
        this.D = obtainStyledAttributes.getResourceId(3, 0);
        this.E = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        kVar.c().h(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void b(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup c(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void d(int i9, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message obtainMessage = onClickListener != null ? this.F.obtainMessage(i9, onClickListener) : null;
        if (i9 == -3) {
            this.f3553p = charSequence;
            this.f3554q = obtainMessage;
        } else if (i9 == -2) {
            this.f3550m = charSequence;
            this.f3551n = obtainMessage;
        } else if (i9 != -1) {
            m7.c.n("Button does not exist");
        } else {
            this.f3547j = charSequence;
            this.f3548k = obtainMessage;
        }
    }
}
