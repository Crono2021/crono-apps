package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f678a;

    /* renamed from: b, reason: collision with root package name */
    public int f679b;

    /* renamed from: c, reason: collision with root package name */
    public int f680c;

    /* renamed from: d, reason: collision with root package name */
    public int f681d;

    /* renamed from: e, reason: collision with root package name */
    public int f682e;

    /* renamed from: f, reason: collision with root package name */
    public int f683f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f684g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public int f685i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f686j;

    /* renamed from: k, reason: collision with root package name */
    public int f687k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f688l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f689m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f690n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f691o;

    /* renamed from: p, reason: collision with root package name */
    public final h0 f692p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f693q;

    /* renamed from: r, reason: collision with root package name */
    public int f694r;

    public b(h0 h0Var) {
        h0Var.A();
        v vVar = h0Var.f748n;
        if (vVar != null) {
            vVar.f872p.getClassLoader();
        }
        this.f678a = new ArrayList();
        this.f691o = false;
        this.f694r = -1;
        this.f692p = h0Var;
    }

    @Override // androidx.fragment.app.f0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (h0.D(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f684g) {
            return true;
        }
        h0 h0Var = this.f692p;
        if (h0Var.f739d == null) {
            h0Var.f739d = new ArrayList();
        }
        h0Var.f739d.add(this);
        return true;
    }

    public final void b(o0 o0Var) {
        this.f678a.add(o0Var);
        o0Var.f818c = this.f679b;
        o0Var.f819d = this.f680c;
        o0Var.f820e = this.f681d;
        o0Var.f821f = this.f682e;
    }

    public final void c(int i9) {
        if (this.f684g) {
            if (h0.D(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i9);
            }
            ArrayList arrayList = this.f678a;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                o0 o0Var = (o0) arrayList.get(i10);
                s sVar = o0Var.f817b;
                if (sVar != null) {
                    sVar.f858y += i9;
                    if (h0.D(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + o0Var.f817b + " to " + o0Var.f817b.f858y);
                    }
                }
            }
        }
    }

    public final void d(String str, PrintWriter printWriter, boolean z8) {
        String str2;
        if (z8) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f694r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f693q);
            if (this.f683f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f683f));
            }
            if (this.f679b != 0 || this.f680c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f679b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f680c));
            }
            if (this.f681d != 0 || this.f682e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f681d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f682e));
            }
            if (this.f685i != 0 || this.f686j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f685i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f686j);
            }
            if (this.f687k != 0 || this.f688l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f687k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f688l);
            }
        }
        ArrayList arrayList = this.f678a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            o0 o0Var = (o0) arrayList.get(i9);
            switch (o0Var.f816a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + o0Var.f816a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i9);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(o0Var.f817b);
            if (z8) {
                if (o0Var.f818c != 0 || o0Var.f819d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(o0Var.f818c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(o0Var.f819d));
                }
                if (o0Var.f820e != 0 || o0Var.f821f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(o0Var.f820e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(o0Var.f821f));
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f694r >= 0) {
            sb.append(" #");
            sb.append(this.f694r);
        }
        if (this.h != null) {
            sb.append(" ");
            sb.append(this.h);
        }
        sb.append("}");
        return sb.toString();
    }
}
