package h4;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3963a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3964b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3965c;

    public b(Context context, androidx.emoji2.text.o oVar) {
        this.f3963a = 1;
        this.f3965c = context.getApplicationContext();
        this.f3964b = oVar;
    }

    @Override // h4.q
    public final p a(Object obj, int i9, int i10, b4.i iVar) {
        com.bumptech.glide.load.data.k kVar;
        p a9;
        Uri uri;
        switch (this.f3963a) {
            case 0:
                Uri uri2 = (Uri) obj;
                String substring = uri2.toString().substring(22);
                v4.b bVar = new v4.b(uri2);
                AssetManager assetManager = (AssetManager) this.f3965c;
                switch (((a) this.f3964b).f3959i) {
                    case 0:
                        kVar = new com.bumptech.glide.load.data.k(assetManager, substring, 0);
                        break;
                    default:
                        kVar = new com.bumptech.glide.load.data.k(assetManager, substring, 1);
                        break;
                }
                return new p(bVar, kVar);
            case 1:
                Integer num = (Integer) obj;
                Resources.Theme theme = (Resources.Theme) iVar.c(m4.d.f6645b);
                return new p(new v4.b(num), new e(theme, theme != null ? theme.getResources() : ((Context) this.f3965c).getResources(), (androidx.emoji2.text.o) this.f3964b, num.intValue()));
            case 2:
                ArrayList arrayList = (ArrayList) this.f3965c;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                b4.f fVar = null;
                for (int i11 = 0; i11 < size; i11++) {
                    q qVar = (q) arrayList.get(i11);
                    if (qVar.b(obj) && (a9 = qVar.a(obj, i9, i10, iVar)) != null) {
                        fVar = a9.f4000a;
                        arrayList2.add(a9.f4002c);
                    }
                }
                if (arrayList2.isEmpty() || fVar == null) {
                    return null;
                }
                return new p(fVar, new u(arrayList2, (m0.c) this.f3964b));
            case 3:
                Integer num2 = (Integer) obj;
                Resources resources = (Resources) this.f3964b;
                try {
                    uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num2.intValue()) + '/' + resources.getResourceTypeName(num2.intValue()) + '/' + resources.getResourceEntryName(num2.intValue()));
                } catch (Resources.NotFoundException e9) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num2, e9);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((q) this.f3965c).a(uri, i9, i10, iVar);
            default:
                Uri uri3 = (Uri) obj;
                q qVar2 = (q) this.f3964b;
                List<String> pathSegments = uri3.getPathSegments();
                p pVar = null;
                if (pathSegments.size() == 1) {
                    try {
                        int parseInt = Integer.parseInt(uri3.getPathSegments().get(0));
                        if (parseInt != 0) {
                            pVar = qVar2.a(Integer.valueOf(parseInt), i9, i10, iVar);
                        } else if (Log.isLoggable("ResourceUriLoader", 5)) {
                            Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri3);
                        }
                        return pVar;
                    } catch (NumberFormatException e10) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return pVar;
                        }
                        Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri3, e10);
                        return pVar;
                    }
                }
                if (pathSegments.size() != 2) {
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri3);
                    return null;
                }
                List<String> pathSegments2 = uri3.getPathSegments();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                Context context = (Context) this.f3965c;
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier != 0) {
                    return qVar2.a(Integer.valueOf(identifier), i9, i10, iVar);
                }
                if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                }
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri3);
                return null;
        }
    }

    @Override // h4.q
    public final boolean b(Object obj) {
        switch (this.f3963a) {
            case 0:
                Uri uri = (Uri) obj;
                return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                return true;
            case 2:
                ArrayList arrayList = (ArrayList) this.f3965c;
                int size = arrayList.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj2 = arrayList.get(i9);
                    i9++;
                    if (((q) obj2).b(obj)) {
                        return true;
                    }
                }
                return false;
            case 3:
                return true;
            default:
                Uri uri2 = (Uri) obj;
                return "android.resource".equals(uri2.getScheme()) && ((Context) this.f3965c).getPackageName().equals(uri2.getAuthority());
        }
    }

    public String toString() {
        switch (this.f3963a) {
            case 2:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.f3965c).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public b(Resources resources, q qVar) {
        this.f3963a = 3;
        this.f3964b = resources;
        this.f3965c = qVar;
    }

    public /* synthetic */ b(Object obj, int i9, Object obj2) {
        this.f3963a = i9;
        this.f3965c = obj;
        this.f3964b = obj2;
    }

    public b(Context context, q qVar) {
        this.f3963a = 4;
        this.f3965c = context.getApplicationContext();
        this.f3964b = qVar;
    }
}
