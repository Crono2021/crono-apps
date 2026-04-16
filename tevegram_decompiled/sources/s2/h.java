package s2;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final long f8788a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8789b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8790c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8791d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8792e;

    /* renamed from: f, reason: collision with root package name */
    public final List f8793f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f8794g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8795i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8796j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8797k;

    public h(Parcel parcel) {
        this.f8788a = parcel.readLong();
        this.f8789b = parcel.readByte() == 1;
        this.f8790c = parcel.readByte() == 1;
        this.f8791d = parcel.readByte() == 1;
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i9 = 0; i9 < readInt; i9++) {
            arrayList.add(new g(parcel.readInt(), parcel.readLong()));
        }
        this.f8793f = Collections.unmodifiableList(arrayList);
        this.f8792e = parcel.readLong();
        this.f8794g = parcel.readByte() == 1;
        this.h = parcel.readLong();
        this.f8795i = parcel.readInt();
        this.f8796j = parcel.readInt();
        this.f8797k = parcel.readInt();
    }

    public h(long j5, boolean z8, boolean z9, boolean z10, ArrayList arrayList, long j9, boolean z11, long j10, int i9, int i10, int i11) {
        this.f8788a = j5;
        this.f8789b = z8;
        this.f8790c = z9;
        this.f8791d = z10;
        this.f8793f = Collections.unmodifiableList(arrayList);
        this.f8792e = j9;
        this.f8794g = z11;
        this.h = j10;
        this.f8795i = i9;
        this.f8796j = i10;
        this.f8797k = i11;
    }
}
