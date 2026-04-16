package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import d0.b;
import d0.g;
import d0.h;
import g.l;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import m7.c;
import org.xmlpull.v1.XmlPullParserException;
import t.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f573k = {"_display_name", "_size"};

    /* renamed from: l, reason: collision with root package name */
    public static final File f574l = new File("/");

    /* renamed from: m, reason: collision with root package name */
    public static final HashMap f575m = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public h f576i;

    /* renamed from: j, reason: collision with root package name */
    public String f577j;

    public static h b(Context context, String str) {
        h hVar;
        HashMap hashMap = f575m;
        synchronized (hashMap) {
            try {
                hVar = (h) hashMap.get(str);
                if (hVar == null) {
                    try {
                        try {
                            hVar = d(context, str);
                            hashMap.put(str, hVar);
                        } catch (IOException e9) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e9);
                        }
                    } catch (XmlPullParserException e10) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public static Uri c(l lVar, String str, File file) {
        h b9 = b(lVar, str);
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : b9.f2346b.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                c.n(a.b("Failed to find configured root that contains ", canonicalPath));
                return null;
            }
            String path2 = ((File) entry.getValue()).getPath();
            return new Uri.Builder().scheme("content").authority(b9.f2345a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
        } catch (IOException unused) {
            androidx.fragment.app.a.n(file, "Failed to resolve canonical path for ");
            return null;
        }
    }

    public static h d(Context context, String str) {
        h hVar = new h(str);
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (resolveContentProvider == null) {
            c.n(a.b("Couldn't find meta-data for provider with authority ", str));
            return null;
        }
        XmlResourceParser loadXmlMetaData = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            c.n("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            return null;
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                return hVar;
            }
            if (next == 2) {
                String name = loadXmlMetaData.getName();
                File file = null;
                String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    file = f574l;
                } else if ("files-path".equals(name)) {
                    file = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    file = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] b9 = b.b(context, null);
                    if (b9.length > 0) {
                        file = b9[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] a9 = b.a(context);
                    if (a9.length > 0) {
                        file = a9[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] a10 = g.a(context);
                    if (a10.length > 0) {
                        file = a10[0];
                    }
                }
                if (file == null) {
                    continue;
                } else {
                    String str2 = new String[]{attributeValue2}[0];
                    if (str2 != null) {
                        file = new File(file, str2);
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        c.n("Name must not be empty");
                        return null;
                    }
                    try {
                        hVar.f2346b.put(attributeValue, file.getCanonicalFile());
                    } catch (IOException e9) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e9);
                    }
                }
            }
        }
    }

    public final h a() {
        h hVar;
        synchronized (this) {
            try {
                if (this.f576i == null) {
                    this.f576i = b(getContext(), this.f577j);
                }
                hVar = this.f576i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.f577j = providerInfo.authority.split(";")[0];
        HashMap hashMap = f575m;
        synchronized (hashMap) {
            hashMap.remove(this.f577j);
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return a().a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        File a9 = a().a(uri);
        int lastIndexOf = a9.getName().lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a9.getName().substring(lastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        int i9;
        File a9 = a().a(uri);
        if ("r".equals(str)) {
            i9 = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i9 = 738197504;
        } else if ("wa".equals(str)) {
            i9 = 704643072;
        } else if ("rw".equals(str)) {
            i9 = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                c.n(a.b("Invalid mode: ", str));
                return null;
            }
            i9 = 1006632960;
        }
        return ParcelFileDescriptor.open(a9, i9);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i9;
        File a9 = a().a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f573k;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i10 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i10] = "_display_name";
                i9 = i10 + 1;
                objArr[i10] = queryParameter == null ? a9.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i10] = "_size";
                i9 = i10 + 1;
                objArr[i10] = Long.valueOf(a9.length());
            }
            i10 = i9;
        }
        String[] strArr4 = new String[i10];
        System.arraycopy(strArr3, 0, strArr4, 0, i10);
        Object[] objArr2 = new Object[i10];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
