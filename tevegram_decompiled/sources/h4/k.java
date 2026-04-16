package h4;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k implements h {

    /* renamed from: b, reason: collision with root package name */
    public final Map f3990b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Map f3991c;

    public k(Map map) {
        this.f3990b = Collections.unmodifiableMap(map);
    }

    @Override // h4.h
    public final Map a() {
        if (this.f3991c == null) {
            synchronized (this) {
                try {
                    if (this.f3991c == null) {
                        this.f3991c = Collections.unmodifiableMap(b());
                    }
                } finally {
                }
            }
        }
        return this.f3991c;
    }

    public final HashMap b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f3990b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                String str = ((j) list.get(i9)).f3989a;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    if (i9 != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f3990b.equals(((k) obj).f3990b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3990b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f3990b + '}';
    }
}
