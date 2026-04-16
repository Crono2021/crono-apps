package h3;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import g1.p;
import g1.w;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f3954a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f3955b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c, reason: collision with root package name */
    public static final Map f3956c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f3957d;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f3956c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f3957d = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(String str, e eVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        char c9;
        int i9;
        int i10;
        int i11;
        int i12 = eVar.f3939b;
        int length = spannableStringBuilder.length();
        String str2 = eVar.f3938a;
        str2.getClass();
        int i13 = -1;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case 98:
                if (str2.equals("b")) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case 99:
                if (str2.equals("c")) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case 105:
                if (str2.equals("i")) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case 117:
                if (str2.equals("u")) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            case 118:
                if (str2.equals("v")) {
                    c9 = 5;
                    break;
                }
                c9 = 65535;
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c9 = 6;
                    break;
                }
                c9 = 65535;
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c9 = 7;
                    break;
                }
                c9 = 65535;
                break;
            default:
                c9 = 65535;
                break;
        }
        switch (c9) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i12, length, 33);
                break;
            case 2:
                for (String str3 : eVar.f3941d) {
                    Map map = f3956c;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i12, length, 33);
                    } else {
                        Map map2 = f3957d;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i12, length, 33);
                        }
                    }
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i12, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i12, length, 33);
                break;
            case 7:
                int c10 = c(list2, str, eVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, d.f3935c);
                int i14 = eVar.f3939b;
                int i15 = 0;
                int i16 = 0;
                while (i15 < arrayList.size()) {
                    if ("rt".equals(((d) arrayList.get(i15)).f3936a.f3938a)) {
                        d dVar = (d) arrayList.get(i15);
                        int c11 = c(list2, str, dVar.f3936a);
                        if (c11 == i13) {
                            c11 = c10 != i13 ? c10 : 1;
                        }
                        int i17 = dVar.f3936a.f3939b - i16;
                        int i18 = dVar.f3937b - i16;
                        CharSequence subSequence = spannableStringBuilder.subSequence(i17, i18);
                        spannableStringBuilder.delete(i17, i18);
                        spannableStringBuilder.setSpan(new f1.g(subSequence.toString(), c11), i14, i17, 33);
                        i16 = subSequence.length() + i16;
                        i14 = i17;
                    }
                    i15++;
                    i13 = -1;
                }
                break;
            default:
                return;
        }
        ArrayList b9 = b(list2, str, eVar);
        for (int i19 = 0; i19 < b9.size(); i19++) {
            b bVar = ((f) b9.get(i19)).f3943j;
            int i20 = bVar.f3926l;
            if (i20 == -1 && bVar.f3927m == -1) {
                i9 = -1;
            } else {
                i9 = (bVar.f3927m == 1 ? (char) 2 : (char) 0) | (i20 == 1 ? (char) 1 : (char) 0);
            }
            if (i9 != -1) {
                int i21 = bVar.f3926l;
                if (i21 == -1 && bVar.f3927m == -1) {
                    i11 = -1;
                    i10 = 1;
                } else {
                    i10 = 1;
                    i11 = (i21 == 1 ? 1 : 0) | (bVar.f3927m == 1 ? 2 : 0);
                }
                com.bumptech.glide.d.b(spannableStringBuilder, new StyleSpan(i11), i12, length);
            } else {
                i10 = 1;
            }
            if (bVar.f3924j == i10) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i12, length, 33);
            }
            if (bVar.f3925k == i10) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i12, length, 33);
            }
            if (bVar.f3922g) {
                if (!bVar.f3922g) {
                    m7.c.p("Font color not defined");
                    return;
                }
                com.bumptech.glide.d.b(spannableStringBuilder, new ForegroundColorSpan(bVar.f3921f), i12, length);
            }
            if (bVar.f3923i) {
                if (!bVar.f3923i) {
                    m7.c.p("Background color not defined.");
                    return;
                }
                com.bumptech.glide.d.b(spannableStringBuilder, new BackgroundColorSpan(bVar.h), i12, length);
            }
            if (bVar.f3920e != null) {
                com.bumptech.glide.d.b(spannableStringBuilder, new TypefaceSpan(bVar.f3920e), i12, length);
            }
            int i22 = bVar.f3928n;
            if (i22 == 1) {
                com.bumptech.glide.d.b(spannableStringBuilder, new AbsoluteSizeSpan((int) bVar.f3929o, true), i12, length);
            } else if (i22 == 2) {
                com.bumptech.glide.d.b(spannableStringBuilder, new RelativeSizeSpan(bVar.f3929o), i12, length);
            } else if (i22 == 3) {
                com.bumptech.glide.d.b(spannableStringBuilder, new RelativeSizeSpan(bVar.f3929o / 100.0f), i12, length);
            }
            if (bVar.f3931q) {
                spannableStringBuilder.setSpan(new f1.e(), i12, length, 33);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList b(List list, String str, e eVar) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < list.size(); i9++) {
            b bVar = (b) list.get(i9);
            String str2 = eVar.f3938a;
            Set set = eVar.f3941d;
            String str3 = eVar.f3940c;
            if (bVar.f3916a.isEmpty() && bVar.f3917b.isEmpty() && bVar.f3918c.isEmpty() && bVar.f3919d.isEmpty()) {
                size = TextUtils.isEmpty(str2);
            } else {
                int a9 = b.a(b.a(b.a(0, 1073741824, bVar.f3916a, str), 2, bVar.f3917b, str2), 4, bVar.f3919d, str3);
                size = (a9 == -1 || !set.containsAll(bVar.f3918c)) ? 0 : a9 + (bVar.f3918c.size() * 4);
            }
            if (size > 0) {
                arrayList.add(new f(size, bVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int c(List list, String str, e eVar) {
        ArrayList b9 = b(list, str, eVar);
        for (int i9 = 0; i9 < b9.size(); i9++) {
            int i10 = ((f) b9.get(i9)).f3943j.f3930p;
            if (i10 != -1) {
                return i10;
            }
        }
        return -1;
    }

    public static c d(String str, Matcher matcher, p pVar, ArrayList arrayList) {
        g gVar = new g();
        try {
            String group = matcher.group(1);
            group.getClass();
            gVar.f3944a = i.c(group);
            String group2 = matcher.group(2);
            group2.getClass();
            gVar.f3945b = i.c(group2);
            String group3 = matcher.group(3);
            group3.getClass();
            e(group3, gVar);
            StringBuilder sb = new StringBuilder();
            pVar.getClass();
            String h = pVar.h(a6.b.f203c);
            while (!TextUtils.isEmpty(h)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(h.trim());
                h = pVar.h(a6.b.f203c);
            }
            gVar.f3946c = f(str, sb.toString(), arrayList);
            return new c(gVar.a().a(), gVar.f3944a, gVar.f3945b);
        } catch (NumberFormatException unused) {
            g1.a.D("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0081, code lost:
    
        if (r6.equals("center") == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c2, code lost:
    
        if (r7.equals("start") == false) goto L53;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.lang.String r18, h3.g r19) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.h.e(java.lang.String, h3.g):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SpannedString f(String str, String str2, List list) {
        char c9;
        char c10;
        String substring;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i9 = 0;
        while (true) {
            String str3 = "";
            if (i9 >= str2.length()) {
                while (!arrayDeque.isEmpty()) {
                    a(str, (e) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                a(str, new e("", 0, "", Collections.EMPTY_SET), Collections.EMPTY_LIST, spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
            char charAt = str2.charAt(i9);
            if (charAt == '&') {
                i9++;
                int indexOf = str2.indexOf(59, i9);
                int indexOf2 = str2.indexOf(32, i9);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    substring = str2.substring(i9, indexOf);
                    switch (substring) {
                        case "gt":
                            spannableStringBuilder.append('>');
                            break;
                        case "lt":
                            spannableStringBuilder.append('<');
                            break;
                        case "amp":
                            spannableStringBuilder.append('&');
                            break;
                        case "nbsp":
                            spannableStringBuilder.append(' ');
                            break;
                        default:
                            g1.a.D("WebvttCueParser", "ignoring unsupported entity: '&" + substring + ";'");
                            break;
                    }
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i9 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i9++;
            } else {
                int i10 = i9 + 1;
                if (i10 < str2.length()) {
                    boolean z8 = str2.charAt(i10) == '/';
                    int indexOf3 = str2.indexOf(62, i10);
                    i10 = indexOf3 == -1 ? str2.length() : indexOf3 + 1;
                    int i11 = i10 - 2;
                    boolean z9 = str2.charAt(i11) == '/';
                    int i12 = i9 + (z8 ? 2 : 1);
                    if (!z9) {
                        i11 = i10 - 1;
                    }
                    String substring2 = str2.substring(i12, i11);
                    if (!substring2.trim().isEmpty()) {
                        String trim = substring2.trim();
                        g1.a.f(!trim.isEmpty());
                        int i13 = w.f3713a;
                        String str4 = trim.split("[ \\.]", 2)[0];
                        str4.getClass();
                        switch (str4.hashCode()) {
                            case 98:
                                if (str4.equals("b")) {
                                    c9 = 0;
                                    break;
                                }
                                c9 = 65535;
                                break;
                            case 99:
                                if (str4.equals("c")) {
                                    c9 = 1;
                                    break;
                                }
                                c9 = 65535;
                                break;
                            case 105:
                                if (str4.equals("i")) {
                                    c9 = 2;
                                    break;
                                }
                                c9 = 65535;
                                break;
                            case 117:
                                if (str4.equals("u")) {
                                    c9 = 3;
                                    break;
                                }
                                c9 = 65535;
                                break;
                            case 118:
                                if (str4.equals("v")) {
                                    c9 = 4;
                                    break;
                                }
                                c9 = 65535;
                                break;
                            case 3650:
                                if (str4.equals("rt")) {
                                    c9 = 5;
                                    break;
                                }
                                c9 = 65535;
                                break;
                            case 3314158:
                                if (str4.equals("lang")) {
                                    c9 = 6;
                                    break;
                                }
                                c9 = 65535;
                                break;
                            case 3511770:
                                if (str4.equals("ruby")) {
                                    c9 = 7;
                                    break;
                                }
                                c9 = 65535;
                                break;
                            default:
                                c9 = 65535;
                                break;
                        }
                        switch (c9) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                if (z8) {
                                    while (!arrayDeque.isEmpty()) {
                                        e eVar = (e) arrayDeque.pop();
                                        a(str, eVar, arrayList, spannableStringBuilder, list);
                                        if (arrayDeque.isEmpty()) {
                                            arrayList.clear();
                                        } else {
                                            arrayList.add(new d(eVar, spannableStringBuilder.length()));
                                        }
                                        if (eVar.f3938a.equals(str4)) {
                                            break;
                                        }
                                    }
                                    break;
                                } else if (!z9) {
                                    int length = spannableStringBuilder.length();
                                    String trim2 = substring2.trim();
                                    g1.a.f(!trim2.isEmpty());
                                    int indexOf4 = trim2.indexOf(" ");
                                    if (indexOf4 == -1) {
                                        c10 = 0;
                                    } else {
                                        str3 = trim2.substring(indexOf4).trim();
                                        c10 = 0;
                                        trim2 = trim2.substring(0, indexOf4);
                                    }
                                    String[] split = trim2.split("\\.", -1);
                                    String str5 = split[c10];
                                    HashSet hashSet = new HashSet();
                                    for (int i14 = 1; i14 < split.length; i14++) {
                                        hashSet.add(split[i14]);
                                    }
                                    arrayDeque.push(new e(str5, length, str3, hashSet));
                                    break;
                                }
                                break;
                        }
                    }
                }
                i9 = i10;
            }
        }
    }

    public static void g(String str, g gVar) {
        String substring;
        int i9;
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            substring = str.substring(indexOf + 1);
            i9 = 2;
            switch (substring) {
                case "center":
                case "middle":
                    i9 = 1;
                    break;
                case "end":
                    break;
                case "start":
                    i9 = 0;
                    break;
                default:
                    g1.a.D("WebvttCueParser", "Invalid anchor value: ".concat(substring));
                    i9 = Integer.MIN_VALUE;
                    break;
            }
            gVar.f3950g = i9;
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            gVar.f3948e = i.b(str);
            gVar.f3949f = 0;
        } else {
            gVar.f3948e = Integer.parseInt(str);
            gVar.f3949f = 1;
        }
    }
}
