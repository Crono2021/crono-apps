package j0;

import android.os.LocaleList;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k implements i {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f5346a;

    public k(Object obj) {
        this.f5346a = j.m(obj);
    }

    @Override // j0.i
    public final String a() {
        String languageTags;
        languageTags = this.f5346a.toLanguageTags();
        return languageTags;
    }

    @Override // j0.i
    public final Object b() {
        return this.f5346a;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        equals = this.f5346a.equals(((i) obj).b());
        return equals;
    }

    @Override // j0.i
    public final Locale get(int i9) {
        Locale locale;
        locale = this.f5346a.get(i9);
        return locale;
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f5346a.hashCode();
        return hashCode;
    }

    @Override // j0.i
    public final boolean isEmpty() {
        boolean isEmpty;
        isEmpty = this.f5346a.isEmpty();
        return isEmpty;
    }

    @Override // j0.i
    public final int size() {
        int size;
        size = this.f5346a.size();
        return size;
    }

    public final String toString() {
        String localeList;
        localeList = this.f5346a.toString();
        return localeList;
    }
}
