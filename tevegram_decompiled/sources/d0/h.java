package d0;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f2345a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2346b = new HashMap();

    public h(String str) {
        this.f2345a = str;
    }

    public final File a(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int indexOf = encodedPath.indexOf(47, 1);
        String decode = Uri.decode(encodedPath.substring(1, indexOf));
        String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
        File file = (File) this.f2346b.get(decode);
        if (file == null) {
            androidx.fragment.app.a.n(uri, "Unable to find configured root for ");
            return null;
        }
        File file2 = new File(file, decode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (canonicalFile.getPath().startsWith(file.getPath())) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException unused) {
            androidx.fragment.app.a.n(file2, "Failed to resolve canonical path for ");
            return null;
        }
    }
}
