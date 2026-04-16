package h4;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4024a;

    /* renamed from: b, reason: collision with root package name */
    public final q f4025b;

    public /* synthetic */ y(q qVar, int i9) {
        this.f4024a = i9;
        this.f4025b = qVar;
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, b4.i iVar) {
        Uri fromFile;
        switch (this.f4024a) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    fromFile = null;
                } else if (str.charAt(0) == '/') {
                    fromFile = Uri.fromFile(new File(str));
                } else {
                    Uri parse = Uri.parse(str);
                    fromFile = parse.getScheme() == null ? Uri.fromFile(new File(str)) : parse;
                }
                if (fromFile == null) {
                    return null;
                }
                q qVar = this.f4025b;
                if (qVar.b(fromFile)) {
                    return qVar.a(fromFile, i9, i10, iVar);
                }
                return null;
            default:
                return this.f4025b.a(new g((URL) obj), i9, i10, iVar);
        }
    }

    @Override // h4.q
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        switch (this.f4024a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}
