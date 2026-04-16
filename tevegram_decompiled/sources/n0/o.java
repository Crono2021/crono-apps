package n0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f7182a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f7183b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f7184c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7185d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f7186e;

    public o(ViewGroup viewGroup) {
        this.f7184c = viewGroup;
    }

    public final boolean a(float f9, float f10, boolean z8) {
        ViewParent e9;
        if (this.f7185d && (e9 = e(0)) != null) {
            try {
                return z0.a(e9, this.f7184c, f9, f10, z8);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + e9 + " does not implement interface method onNestedFling", e10);
            }
        }
        return false;
    }

    public final boolean b(float f9, float f10) {
        ViewParent e9;
        if (this.f7185d && (e9 = e(0)) != null) {
            try {
                return z0.b(e9, this.f7184c, f9, f10);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + e9 + " does not implement interface method onNestedPreFling", e10);
            }
        }
        return false;
    }

    public final boolean c(int i9, int i10, int[] iArr, int[] iArr2, int i11) {
        ViewParent e9;
        int i12;
        int i13;
        if (!this.f7185d || (e9 = e(i11)) == null) {
            return false;
        }
        if (i9 == 0 && i10 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f7184c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i12 = iArr2[0];
            i13 = iArr2[1];
        } else {
            i12 = 0;
            i13 = 0;
        }
        if (iArr == null) {
            if (this.f7186e == null) {
                this.f7186e = new int[2];
            }
            iArr = this.f7186e;
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (e9 instanceof p) {
            ((p) e9).c(viewGroup, i9, i10, iArr3, i11);
        } else if (i11 == 0) {
            try {
                z0.c(e9, viewGroup, i9, i10, iArr3);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + e9 + " does not implement interface method onNestedPreScroll", e10);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i12;
            iArr2[1] = iArr2[1] - i13;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i9, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        ViewParent e9;
        int i14;
        int i15;
        int[] iArr3;
        if (this.f7185d && (e9 = e(i13)) != null) {
            if (i9 != 0 || i10 != 0 || i11 != 0 || i12 != 0) {
                ViewGroup viewGroup = this.f7184c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i14 = iArr[0];
                    i15 = iArr[1];
                } else {
                    i14 = 0;
                    i15 = 0;
                }
                if (iArr2 == null) {
                    if (this.f7186e == null) {
                        this.f7186e = new int[2];
                    }
                    int[] iArr4 = this.f7186e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (e9 instanceof q) {
                    ((q) e9).d(viewGroup, i9, i10, i11, i12, i13, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i11;
                    iArr3[1] = iArr3[1] + i12;
                    if (e9 instanceof p) {
                        ((p) e9).e(viewGroup, i9, i10, i11, i12, i13);
                    } else if (i13 == 0) {
                        try {
                            z0.d(e9, viewGroup, i9, i10, i11, i12);
                        } catch (AbstractMethodError e10) {
                            Log.e("ViewParentCompat", "ViewParent " + e9 + " does not implement interface method onNestedScroll", e10);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i14;
                    iArr[1] = iArr[1] - i15;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent e(int i9) {
        if (i9 == 0) {
            return this.f7182a;
        }
        if (i9 != 1) {
            return null;
        }
        return this.f7183b;
    }

    public final boolean f(int i9) {
        return e(i9) != null;
    }

    public final boolean g(int i9, int i10) {
        boolean f9;
        if (!f(i10)) {
            if (this.f7185d) {
                ViewGroup viewGroup = this.f7184c;
                View view = viewGroup;
                for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z8 = parent instanceof p;
                    if (z8) {
                        f9 = ((p) parent).f(view, viewGroup, i9, i10);
                    } else {
                        if (i10 == 0) {
                            try {
                                f9 = z0.f(parent, view, viewGroup, i9);
                            } catch (AbstractMethodError e9) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e9);
                            }
                        }
                        f9 = false;
                    }
                    if (f9) {
                        if (i10 == 0) {
                            this.f7182a = parent;
                        } else if (i10 == 1) {
                            this.f7183b = parent;
                        }
                        if (z8) {
                            ((p) parent).a(view, viewGroup, i9, i10);
                        } else if (i10 == 0) {
                            try {
                                z0.e(parent, view, viewGroup, i9);
                            } catch (AbstractMethodError e10) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e10);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i9) {
        ViewParent e9 = e(i9);
        if (e9 != null) {
            boolean z8 = e9 instanceof p;
            ViewGroup viewGroup = this.f7184c;
            if (z8) {
                ((p) e9).b(viewGroup, i9);
            } else if (i9 == 0) {
                try {
                    z0.g(e9, viewGroup);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewParentCompat", "ViewParent " + e9 + " does not implement interface method onStopNestedScroll", e10);
                }
            }
            if (i9 == 0) {
                this.f7182a = null;
            } else {
                if (i9 != 1) {
                    return;
                }
                this.f7183b = null;
            }
        }
    }
}
