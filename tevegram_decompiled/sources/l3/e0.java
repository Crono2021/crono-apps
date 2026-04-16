package l3;

import android.text.Html;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f6125a = Pattern.compile("(&#13;)?&#10;");

    public static String a(CharSequence charSequence) {
        return f6125a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
