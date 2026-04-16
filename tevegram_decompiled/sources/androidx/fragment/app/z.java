package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z implements androidx.activity.result.b {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f884i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ h0 f885j;

    public /* synthetic */ z(h0 h0Var, int i9) {
        this.f884i = i9;
        this.f885j = h0Var;
    }

    @Override // androidx.activity.result.b
    public final void b(Object obj) {
        switch (this.f884i) {
            case 0:
                androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
                h0 h0Var = this.f885j;
                e0 e0Var = (e0) h0Var.f757w.pollFirst();
                if (e0Var == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    break;
                } else {
                    String str = e0Var.f721i;
                    int i9 = e0Var.f722j;
                    s J = h0Var.f738c.J(str);
                    if (J == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                        break;
                    } else {
                        J.k(i9, aVar.f323i, aVar.f324j);
                        break;
                    }
                }
            case 1:
                Map map = (Map) obj;
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
                }
                h0 h0Var2 = this.f885j;
                e0 e0Var2 = (e0) h0Var2.f757w.pollFirst();
                if (e0Var2 == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    break;
                } else {
                    String str2 = e0Var2.f721i;
                    if (h0Var2.f738c.J(str2) == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                        break;
                    }
                }
                break;
            default:
                androidx.activity.result.a aVar2 = (androidx.activity.result.a) obj;
                h0 h0Var3 = this.f885j;
                e0 e0Var3 = (e0) h0Var3.f757w.pollFirst();
                if (e0Var3 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    break;
                } else {
                    String str3 = e0Var3.f721i;
                    int i11 = e0Var3.f722j;
                    s J2 = h0Var3.f738c.J(str3);
                    if (J2 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                        break;
                    } else {
                        J2.k(i11, aVar2.f323i, aVar2.f324j);
                        break;
                    }
                }
        }
    }
}
