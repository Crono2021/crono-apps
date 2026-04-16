package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a(4);

    /* renamed from: i, reason: collision with root package name */
    public final int f243i;

    /* renamed from: j, reason: collision with root package name */
    public final long f244j;

    /* renamed from: k, reason: collision with root package name */
    public final long f245k;

    /* renamed from: l, reason: collision with root package name */
    public final float f246l;

    /* renamed from: m, reason: collision with root package name */
    public final long f247m;

    /* renamed from: n, reason: collision with root package name */
    public final int f248n;

    /* renamed from: o, reason: collision with root package name */
    public final CharSequence f249o;

    /* renamed from: p, reason: collision with root package name */
    public final long f250p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f251q;

    /* renamed from: r, reason: collision with root package name */
    public final long f252r;

    /* renamed from: s, reason: collision with root package name */
    public final Bundle f253s;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new c();

        /* renamed from: i, reason: collision with root package name */
        public final String f254i;

        /* renamed from: j, reason: collision with root package name */
        public final CharSequence f255j;

        /* renamed from: k, reason: collision with root package name */
        public final int f256k;

        /* renamed from: l, reason: collision with root package name */
        public final Bundle f257l;

        public CustomAction(Parcel parcel) {
            this.f254i = parcel.readString();
            this.f255j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f256k = parcel.readInt();
            this.f257l = parcel.readBundle(b.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f255j) + ", mIcon=" + this.f256k + ", mExtras=" + this.f257l;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            parcel.writeString(this.f254i);
            TextUtils.writeToParcel(this.f255j, parcel, i9);
            parcel.writeInt(this.f256k);
            parcel.writeBundle(this.f257l);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f243i = parcel.readInt();
        this.f244j = parcel.readLong();
        this.f246l = parcel.readFloat();
        this.f250p = parcel.readLong();
        this.f245k = parcel.readLong();
        this.f247m = parcel.readLong();
        this.f249o = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f251q = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f252r = parcel.readLong();
        this.f253s = parcel.readBundle(b.class.getClassLoader());
        this.f248n = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f243i + ", position=" + this.f244j + ", buffered position=" + this.f245k + ", speed=" + this.f246l + ", updated=" + this.f250p + ", actions=" + this.f247m + ", error code=" + this.f248n + ", error message=" + this.f249o + ", custom actions=" + this.f251q + ", active item id=" + this.f252r + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f243i);
        parcel.writeLong(this.f244j);
        parcel.writeFloat(this.f246l);
        parcel.writeLong(this.f250p);
        parcel.writeLong(this.f245k);
        parcel.writeLong(this.f247m);
        TextUtils.writeToParcel(this.f249o, parcel, i9);
        parcel.writeTypedList(this.f251q);
        parcel.writeLong(this.f252r);
        parcel.writeBundle(this.f253s);
        parcel.writeInt(this.f248n);
    }
}
