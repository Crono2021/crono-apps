package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c {
    public static Uri a(MediaDescription mediaDescription) {
        Uri mediaUri;
        mediaUri = mediaDescription.getMediaUri();
        return mediaUri;
    }

    public static void b(MediaDescription.Builder builder, Uri uri) {
        builder.setMediaUri(uri);
    }
}
