package c4;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f1623c = {"_data"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f1624d = {"_data"};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1625a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f1626b;

    public /* synthetic */ a(ContentResolver contentResolver, int i9) {
        this.f1625a = i9;
        this.f1626b = contentResolver;
    }

    public final Cursor a(Uri uri) {
        switch (this.f1625a) {
            case 0:
                String lastPathSegment = uri.getLastPathSegment();
                return this.f1626b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f1623c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.f1626b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f1624d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}
