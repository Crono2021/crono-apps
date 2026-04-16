package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new android.support.v4.media.a(5);

    /* renamed from: i, reason: collision with root package name */
    public final IntentSender f341i;

    /* renamed from: j, reason: collision with root package name */
    public final Intent f342j;

    /* renamed from: k, reason: collision with root package name */
    public final int f343k;

    /* renamed from: l, reason: collision with root package name */
    public final int f344l;

    public h(IntentSender intentSender, Intent intent, int i9, int i10) {
        this.f341i = intentSender;
        this.f342j = intent;
        this.f343k = i9;
        this.f344l = i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.getClass();
        parcel.writeParcelable(this.f341i, i9);
        parcel.writeParcelable(this.f342j, i9);
        parcel.writeInt(this.f343k);
        parcel.writeInt(this.f344l);
    }
}
