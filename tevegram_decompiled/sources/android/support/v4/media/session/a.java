package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f258a;

    public /* synthetic */ a(int i9) {
        this.f258a = i9;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        switch (this.f258a) {
            case 0:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f235i = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 1:
                return new Parcelable(parcel) { // from class: android.support.v4.media.session.MediaSessionCompat$QueueItem
                    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new a(1);

                    /* renamed from: i, reason: collision with root package name */
                    public final MediaDescriptionCompat f233i;

                    /* renamed from: j, reason: collision with root package name */
                    public final long f234j;

                    {
                        this.f233i = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        this.f234j = parcel.readLong();
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaSession.QueueItem {Description=" + this.f233i + ", Id=" + this.f234j + " }";
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i9) {
                        this.f233i.writeToParcel(parcel2, i9);
                        parcel2.writeLong(this.f234j);
                    }
                };
            case 2:
                final Parcelable readParcelable = parcel.readParcelable(null);
                return new Parcelable(readParcelable) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new a(2);

                    /* renamed from: i, reason: collision with root package name */
                    public final Object f236i = new Object();

                    /* renamed from: j, reason: collision with root package name */
                    public final Object f237j;

                    {
                        this.f237j = readParcelable;
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof MediaSessionCompat$Token)) {
                            return false;
                        }
                        Object obj2 = ((MediaSessionCompat$Token) obj).f237j;
                        Object obj3 = this.f237j;
                        if (obj3 == null) {
                            return obj2 == null;
                        }
                        if (obj2 == null) {
                            return false;
                        }
                        return obj3.equals(obj2);
                    }

                    public final int hashCode() {
                        Object obj = this.f237j;
                        if (obj == null) {
                            return 0;
                        }
                        return obj.hashCode();
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i9) {
                        parcel2.writeParcelable((Parcelable) this.f237j, i9);
                    }
                };
            case 3:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.f238i = parcel.readInt();
                parcelableVolumeInfo.f240k = parcel.readInt();
                parcelableVolumeInfo.f241l = parcel.readInt();
                parcelableVolumeInfo.f242m = parcel.readInt();
                parcelableVolumeInfo.f239j = parcel.readInt();
                return parcelableVolumeInfo;
            default:
                return new PlaybackStateCompat(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i9) {
        switch (this.f258a) {
            case 0:
                return new MediaSessionCompat$ResultReceiverWrapper[i9];
            case 1:
                return new MediaSessionCompat$QueueItem[i9];
            case 2:
                return new MediaSessionCompat$Token[i9];
            case 3:
                return new ParcelableVolumeInfo[i9];
            default:
                return new PlaybackStateCompat[i9];
        }
    }
}
