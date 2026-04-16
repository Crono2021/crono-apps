package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends u0.b {
    public static final Parcelable.Creator<f> CREATOR = new e();

    /* renamed from: k, reason: collision with root package name */
    public boolean f1901k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1902l;

    /* renamed from: m, reason: collision with root package name */
    public int f1903m;

    /* renamed from: n, reason: collision with root package name */
    public float f1904n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1905o;

    public f(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f1901k = parcel.readByte() != 0;
        this.f1902l = parcel.readByte() != 0;
        this.f1903m = parcel.readInt();
        this.f1904n = parcel.readFloat();
        this.f1905o = parcel.readByte() != 0;
    }

    @Override // u0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeByte(this.f1901k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1902l ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f1903m);
        parcel.writeFloat(this.f1904n);
        parcel.writeByte(this.f1905o ? (byte) 1 : (byte) 0);
    }
}
