package s2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p1.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends b {
    public static final Parcelable.Creator<e> CREATOR = new s(21);

    /* renamed from: i, reason: collision with root package name */
    public final long f8773i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f8774j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f8775k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f8776l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f8777m;

    /* renamed from: n, reason: collision with root package name */
    public final long f8778n;

    /* renamed from: o, reason: collision with root package name */
    public final long f8779o;

    /* renamed from: p, reason: collision with root package name */
    public final List f8780p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f8781q;

    /* renamed from: r, reason: collision with root package name */
    public final long f8782r;

    /* renamed from: s, reason: collision with root package name */
    public final int f8783s;

    /* renamed from: t, reason: collision with root package name */
    public final int f8784t;

    /* renamed from: u, reason: collision with root package name */
    public final int f8785u;

    public e(Parcel parcel) {
        this.f8773i = parcel.readLong();
        this.f8774j = parcel.readByte() == 1;
        this.f8775k = parcel.readByte() == 1;
        this.f8776l = parcel.readByte() == 1;
        this.f8777m = parcel.readByte() == 1;
        this.f8778n = parcel.readLong();
        this.f8779o = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i9 = 0; i9 < readInt; i9++) {
            arrayList.add(new d(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.f8780p = Collections.unmodifiableList(arrayList);
        this.f8781q = parcel.readByte() == 1;
        this.f8782r = parcel.readLong();
        this.f8783s = parcel.readInt();
        this.f8784t = parcel.readInt();
        this.f8785u = parcel.readInt();
    }

    @Override // s2.b
    public final String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.f8778n + ", programSplicePlaybackPositionUs= " + this.f8779o + " }";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeLong(this.f8773i);
        parcel.writeByte(this.f8774j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8775k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8776l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8777m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8778n);
        parcel.writeLong(this.f8779o);
        List list = this.f8780p;
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) list.get(i10);
            parcel.writeInt(dVar.f8770a);
            parcel.writeLong(dVar.f8771b);
            parcel.writeLong(dVar.f8772c);
        }
        parcel.writeByte(this.f8781q ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8782r);
        parcel.writeInt(this.f8783s);
        parcel.writeInt(this.f8784t);
        parcel.writeInt(this.f8785u);
    }

    public e(long j5, boolean z8, boolean z9, boolean z10, boolean z11, long j9, long j10, List list, boolean z12, long j11, int i9, int i10, int i11) {
        this.f8773i = j5;
        this.f8774j = z8;
        this.f8775k = z9;
        this.f8776l = z10;
        this.f8777m = z11;
        this.f8778n = j9;
        this.f8779o = j10;
        this.f8780p = Collections.unmodifiableList(list);
        this.f8781q = z12;
        this.f8782r = j11;
        this.f8783s = i9;
        this.f8784t = i10;
        this.f8785u = i11;
    }
}
