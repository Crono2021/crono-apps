package d2;

import d1.i0;
import d1.j0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f2730c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f2731a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f2732b = -1;

    public final boolean a(String str) {
        Matcher matcher = f2730c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i9 = g1.w.f3713a;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f2731a = parseInt;
            this.f2732b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final void b(j0 j0Var) {
        int i9 = 0;
        while (true) {
            i0[] i0VarArr = j0Var.f2490i;
            if (i9 >= i0VarArr.length) {
                return;
            }
            i0 i0Var = i0VarArr[i9];
            if (i0Var instanceof q2.e) {
                q2.e eVar = (q2.e) i0Var;
                if ("iTunSMPB".equals(eVar.f8439k) && a(eVar.f8440l)) {
                    return;
                }
            } else if (i0Var instanceof q2.j) {
                q2.j jVar = (q2.j) i0Var;
                if ("com.apple.iTunes".equals(jVar.f8451j) && "iTunSMPB".equals(jVar.f8452k) && a(jVar.f8453l)) {
                    return;
                }
            } else {
                continue;
            }
            i9++;
        }
    }
}
