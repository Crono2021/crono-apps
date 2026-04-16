package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y implements LayoutInflater.Factory2 {

    /* renamed from: i, reason: collision with root package name */
    public final h0 f883i;

    public y(h0 h0Var) {
        this.f883i = h0Var;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z8;
        s sVar;
        int i9;
        n0 f9;
        View view2;
        h0 h0Var = this.f883i;
        g gVar = h0Var.f738c;
        s sVar2 = null;
        if (FragmentContainerView.class.getName().equals(str)) {
            FragmentContainerView fragmentContainerView = new FragmentContainerView(context, attributeSet);
            fragmentContainerView.f672l = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z0.a.f10535b);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
            }
            String string = obtainStyledAttributes.getString(1);
            obtainStyledAttributes.recycle();
            int id = fragmentContainerView.getId();
            s y2 = h0Var.y(id);
            if (classAttribute != null && y2 == null) {
                if (id <= 0) {
                    m7.c.p(androidx.activity.g.n("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                    return null;
                }
                b0 A = h0Var.A();
                context.getClassLoader();
                s a9 = A.a(classAttribute);
                a9.K = true;
                v vVar = a9.A;
                if ((vVar == null ? null : vVar.f871o) != null) {
                    a9.K = true;
                }
                b bVar = new b(h0Var);
                bVar.f691o = true;
                a9.L = fragmentContainerView;
                int id2 = fragmentContainerView.getId();
                Class<?> cls = a9.getClass();
                int modifiers = cls.getModifiers();
                if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
                    throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
                }
                if (string != null) {
                    String str2 = a9.F;
                    if (str2 != null && !string.equals(str2)) {
                        StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                        sb.append(a9);
                        String str3 = a9.F;
                        sb.append(": was ");
                        sb.append(str3);
                        sb.append(" now ");
                        sb.append(string);
                        throw new IllegalStateException(sb.toString());
                    }
                    a9.F = string;
                }
                if (id2 != 0) {
                    if (id2 == -1) {
                        throw new IllegalArgumentException("Can't add fragment " + a9 + " with tag " + string + " to container view with no id");
                    }
                    int i10 = a9.D;
                    if (i10 != 0 && i10 != id2) {
                        StringBuilder sb2 = new StringBuilder("Can't change container ID of fragment ");
                        sb2.append(a9);
                        int i11 = a9.D;
                        sb2.append(": was ");
                        sb2.append(i11);
                        sb2.append(" now ");
                        sb2.append(id2);
                        throw new IllegalStateException(sb2.toString());
                    }
                    a9.D = id2;
                    a9.E = id2;
                }
                bVar.b(new o0(1, a9));
                h0 h0Var2 = bVar.f692p;
                a9.f859z = h0Var2;
                if (bVar.f684g) {
                    m7.c.p("This transaction is already being added to the back stack");
                    return null;
                }
                if (h0Var2.f748n != null && !h0Var2.A) {
                    h0Var2.v(true);
                    bVar.a(h0Var2.C, h0Var2.D);
                    h0Var2.f737b = true;
                    try {
                        h0Var2.M(h0Var2.C, h0Var2.D);
                        h0Var2.d();
                        h0Var2.W();
                        if (h0Var2.B) {
                            h0Var2.B = false;
                            h0Var2.V();
                        }
                        ((HashMap) h0Var2.f738c.f729k).values().removeAll(Collections.singleton(null));
                    } catch (Throwable th) {
                        h0Var2.d();
                        throw th;
                    }
                }
            }
            ArrayList L = gVar.L();
            int size = L.size();
            while (r8 < size) {
                Object obj = L.get(r8);
                r8++;
                n0 n0Var = (n0) obj;
                s sVar3 = n0Var.f802c;
                if (sVar3.E == fragmentContainerView.getId() && (view2 = sVar3.M) != null && view2.getParent() == null) {
                    sVar3.L = fragmentContainerView;
                    n0Var.b();
                }
            }
            return fragmentContainerView;
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, z0.a.f10534a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes2.getString(0);
            }
            int resourceId = obtainStyledAttributes2.getResourceId(1, -1);
            String string2 = obtainStyledAttributes2.getString(2);
            obtainStyledAttributes2.recycle();
            if (attributeValue != null) {
                try {
                    z8 = s.class.isAssignableFrom(b0.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    z8 = false;
                }
                if (z8) {
                    r8 = view != null ? view.getId() : 0;
                    if (r8 == -1 && resourceId == -1 && string2 == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    s y3 = resourceId != -1 ? h0Var.y(resourceId) : null;
                    if (y3 == null && string2 != null) {
                        ArrayList arrayList = (ArrayList) gVar.f728j;
                        int size2 = arrayList.size() - 1;
                        while (true) {
                            if (size2 < 0) {
                                sVar = sVar2;
                                i9 = 2;
                                Iterator it = ((HashMap) gVar.f729k).values().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        y3 = sVar;
                                        break;
                                    }
                                    n0 n0Var2 = (n0) it.next();
                                    if (n0Var2 != null) {
                                        y3 = n0Var2.f802c;
                                        if (string2.equals(y3.F)) {
                                            break;
                                        }
                                    }
                                }
                            } else {
                                sVar = sVar2;
                                s sVar4 = (s) arrayList.get(size2);
                                i9 = 2;
                                if (sVar4 != null && string2.equals(sVar4.F)) {
                                    y3 = sVar4;
                                    break;
                                }
                                size2--;
                                sVar2 = sVar;
                            }
                        }
                    } else {
                        sVar = null;
                        i9 = 2;
                    }
                    if (y3 == null && r8 != -1) {
                        y3 = h0Var.y(r8);
                    }
                    if (y3 == null) {
                        b0 A2 = h0Var.A();
                        context.getClassLoader();
                        y3 = A2.a(attributeValue);
                        y3.f854u = true;
                        y3.D = resourceId != 0 ? resourceId : r8;
                        y3.E = r8;
                        y3.F = string2;
                        y3.f855v = true;
                        y3.f859z = h0Var;
                        v vVar2 = h0Var.f748n;
                        y3.A = vVar2;
                        g.l lVar = vVar2.f872p;
                        y3.K = true;
                        if ((vVar2 == null ? sVar : vVar2.f871o) != null) {
                            y3.K = true;
                        }
                        f9 = h0Var.a(y3);
                        if (h0.D(i9)) {
                            Log.v("FragmentManager", "Fragment " + y3 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (y3.f855v) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(r8) + " with another fragment for " + attributeValue);
                        }
                        y3.f855v = true;
                        y3.f859z = h0Var;
                        v vVar3 = h0Var.f748n;
                        y3.A = vVar3;
                        g.l lVar2 = vVar3.f872p;
                        y3.K = true;
                        if ((vVar3 == null ? sVar : vVar3.f871o) != null) {
                            y3.K = true;
                        }
                        f9 = h0Var.f(y3);
                        if (h0.D(i9)) {
                            Log.v("FragmentManager", "Retained Fragment " + y3 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    y3.L = (ViewGroup) view;
                    f9.k();
                    f9.j();
                    View view3 = y3.M;
                    if (view3 == null) {
                        m7.c.p(androidx.activity.g.n("Fragment ", attributeValue, " did not create a view."));
                        return null;
                    }
                    if (resourceId != 0) {
                        view3.setId(resourceId);
                    }
                    if (y3.M.getTag() == null) {
                        y3.M.setTag(string2);
                    }
                    y3.M.addOnAttachStateChangeListener(new x(this, f9));
                    return y3.M;
                }
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
