package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import s.d;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;

    /* renamed from: i, reason: collision with root package name */
    public final Bundle f229i;

    static {
        d dVar = new d();
        dVar.put("android.media.metadata.TITLE", 1);
        dVar.put("android.media.metadata.ARTIST", 1);
        dVar.put("android.media.metadata.DURATION", 0);
        dVar.put("android.media.metadata.ALBUM", 1);
        dVar.put("android.media.metadata.AUTHOR", 1);
        dVar.put("android.media.metadata.WRITER", 1);
        dVar.put("android.media.metadata.COMPOSER", 1);
        dVar.put("android.media.metadata.COMPILATION", 1);
        dVar.put("android.media.metadata.DATE", 1);
        dVar.put("android.media.metadata.YEAR", 0);
        dVar.put("android.media.metadata.GENRE", 1);
        dVar.put("android.media.metadata.TRACK_NUMBER", 0);
        dVar.put("android.media.metadata.NUM_TRACKS", 0);
        dVar.put("android.media.metadata.DISC_NUMBER", 0);
        dVar.put("android.media.metadata.ALBUM_ARTIST", 1);
        dVar.put("android.media.metadata.ART", 2);
        dVar.put("android.media.metadata.ART_URI", 1);
        dVar.put("android.media.metadata.ALBUM_ART", 2);
        dVar.put("android.media.metadata.ALBUM_ART_URI", 1);
        dVar.put("android.media.metadata.USER_RATING", 3);
        dVar.put("android.media.metadata.RATING", 3);
        dVar.put("android.media.metadata.DISPLAY_TITLE", 1);
        dVar.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        dVar.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        dVar.put("android.media.metadata.DISPLAY_ICON", 2);
        dVar.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        dVar.put("android.media.metadata.MEDIA_ID", 1);
        dVar.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        dVar.put("android.media.metadata.MEDIA_URI", 1);
        dVar.put("android.media.metadata.ADVERTISEMENT", 0);
        dVar.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        CREATOR = new a(2);
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f229i = parcel.readBundle(android.support.v4.media.session.b.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeBundle(this.f229i);
    }
}
