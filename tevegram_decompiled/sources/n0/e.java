package n0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements d, f {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7147i;

    /* renamed from: j, reason: collision with root package name */
    public Object f7148j;

    /* renamed from: k, reason: collision with root package name */
    public int f7149k;

    /* renamed from: l, reason: collision with root package name */
    public int f7150l;

    /* renamed from: m, reason: collision with root package name */
    public Object f7151m;

    /* renamed from: n, reason: collision with root package name */
    public Cloneable f7152n;

    public e(e eVar) {
        this.f7147i = 1;
        ClipData clipData = (ClipData) eVar.f7148j;
        clipData.getClass();
        this.f7148j = clipData;
        int i9 = eVar.f7149k;
        if (i9 < 0) {
            Locale locale = Locale.US;
            m7.c.n("source is out of range of [0, 5] (too low)");
            throw null;
        }
        if (i9 > 5) {
            Locale locale2 = Locale.US;
            m7.c.n("source is out of range of [0, 5] (too high)");
            throw null;
        }
        this.f7149k = i9;
        int i10 = eVar.f7150l;
        if ((i10 & 1) == i10) {
            this.f7150l = i10;
            this.f7151m = (Uri) eVar.f7151m;
            this.f7152n = (Bundle) eVar.f7152n;
            return;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
    }

    public void a(a2 a2Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((((m1) it.next()).f7177a.c() & 8) != 0) {
                ((View) this.f7151m).setTranslationY(z4.a.c(r3.f7177a.b(), this.f7150l, 0));
                return;
            }
        }
    }

    @Override // n0.d
    public g build() {
        return new g(new e(this));
    }

    @Override // n0.f
    public ClipData c() {
        return (ClipData) this.f7148j;
    }

    @Override // n0.f
    public int m() {
        return this.f7150l;
    }

    @Override // n0.f
    public ContentInfo o() {
        return null;
    }

    @Override // n0.d
    public void s(Uri uri) {
        this.f7151m = uri;
    }

    @Override // n0.d
    public void setExtras(Bundle bundle) {
        this.f7152n = bundle;
    }

    @Override // n0.f
    public int t() {
        return this.f7149k;
    }

    public String toString() {
        String str;
        switch (this.f7147i) {
            case 1:
                Uri uri = (Uri) this.f7151m;
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(((ClipData) this.f7148j).getDescription());
                sb.append(", source=");
                int i9 = this.f7149k;
                sb.append(i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? i9 != 5 ? String.valueOf(i9) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i10 = this.f7150l;
                sb.append((i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10));
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return androidx.activity.g.o(sb, ((Bundle) this.f7152n) != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    @Override // n0.d
    public void u(int i9) {
        this.f7150l = i9;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [int[], java.lang.Cloneable] */
    public e(View view) {
        this.f7147i = 2;
        this.f7152n = new int[2];
        this.f7151m = view;
    }

    public /* synthetic */ e() {
        this.f7147i = 0;
    }
}
