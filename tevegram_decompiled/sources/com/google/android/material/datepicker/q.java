package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q implements Comparable, Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new android.support.v4.media.a(13);

    /* renamed from: i, reason: collision with root package name */
    public final Calendar f2061i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2062j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2063k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2064l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2065m;

    /* renamed from: n, reason: collision with root package name */
    public final long f2066n;

    /* renamed from: o, reason: collision with root package name */
    public String f2067o;

    public q(Calendar calendar) {
        calendar.set(5, 1);
        Calendar a9 = y.a(calendar);
        this.f2061i = a9;
        this.f2062j = a9.get(2);
        this.f2063k = a9.get(1);
        this.f2064l = a9.getMaximum(7);
        this.f2065m = a9.getActualMaximum(5);
        this.f2066n = a9.getTimeInMillis();
    }

    public static q d(int i9, int i10) {
        Calendar c9 = y.c(null);
        c9.set(1, i9);
        c9.set(2, i10);
        return new q(c9);
    }

    public static q e(long j5) {
        Calendar c9 = y.c(null);
        c9.setTimeInMillis(j5);
        return new q(c9);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f2061i.compareTo(((q) obj).f2061i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f2062j == qVar.f2062j && this.f2063k == qVar.f2063k;
    }

    public final String f() {
        String formatDateTime;
        DateFormat instanceForSkeleton;
        TimeZone timeZone;
        DisplayContext unused;
        if (this.f2067o == null) {
            long timeInMillis = this.f2061i.getTimeInMillis();
            if (Build.VERSION.SDK_INT >= 24) {
                Locale locale = Locale.getDefault();
                AtomicReference atomicReference = y.f2081a;
                instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
                timeZone = TimeZone.getTimeZone("UTC");
                instanceForSkeleton.setTimeZone(timeZone);
                unused = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
                instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
                formatDateTime = instanceForSkeleton.format(new Date(timeInMillis));
            } else {
                formatDateTime = DateUtils.formatDateTime(null, timeInMillis, 8228);
            }
            this.f2067o = formatDateTime;
        }
        return this.f2067o;
    }

    public final int g(q qVar) {
        if (this.f2061i instanceof GregorianCalendar) {
            return (qVar.f2062j - this.f2062j) + ((qVar.f2063k - this.f2063k) * 12);
        }
        m7.c.n("Only Gregorian calendars are supported.");
        return 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2062j), Integer.valueOf(this.f2063k)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f2063k);
        parcel.writeInt(this.f2062j);
    }
}
