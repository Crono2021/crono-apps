package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(11);

    /* renamed from: i, reason: collision with root package name */
    public final q f2008i;

    /* renamed from: j, reason: collision with root package name */
    public final q f2009j;

    /* renamed from: k, reason: collision with root package name */
    public final d f2010k;

    /* renamed from: l, reason: collision with root package name */
    public final q f2011l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2012m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2013n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2014o;

    public b(q qVar, q qVar2, d dVar, q qVar3, int i9) {
        Objects.requireNonNull(qVar, "start cannot be null");
        Objects.requireNonNull(qVar2, "end cannot be null");
        Objects.requireNonNull(dVar, "validator cannot be null");
        this.f2008i = qVar;
        this.f2009j = qVar2;
        this.f2011l = qVar3;
        this.f2012m = i9;
        this.f2010k = dVar;
        if (qVar3 != null && qVar.f2061i.compareTo(qVar3.f2061i) > 0) {
            m7.c.n("start Month cannot be after current Month");
            throw null;
        }
        if (qVar3 != null && qVar3.f2061i.compareTo(qVar2.f2061i) > 0) {
            m7.c.n("current Month cannot be after end Month");
            throw null;
        }
        if (i9 < 0 || i9 > y.c(null).getMaximum(7)) {
            m7.c.n("firstDayOfWeek is not valid");
            throw null;
        }
        this.f2014o = qVar.g(qVar2) + 1;
        this.f2013n = (qVar2.f2063k - qVar.f2063k) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2008i.equals(bVar.f2008i) && this.f2009j.equals(bVar.f2009j) && m0.a.a(this.f2011l, bVar.f2011l) && this.f2012m == bVar.f2012m && this.f2010k.equals(bVar.f2010k);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2008i, this.f2009j, this.f2011l, Integer.valueOf(this.f2012m), this.f2010k});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeParcelable(this.f2008i, 0);
        parcel.writeParcelable(this.f2009j, 0);
        parcel.writeParcelable(this.f2011l, 0);
        parcel.writeParcelable(this.f2010k, 0);
        parcel.writeInt(this.f2012m);
    }
}
