package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new android.support.v4.media.a(6);

    /* renamed from: i, reason: collision with root package name */
    public final int[] f697i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f698j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f699k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f700l;

    /* renamed from: m, reason: collision with root package name */
    public final int f701m;

    /* renamed from: n, reason: collision with root package name */
    public final String f702n;

    /* renamed from: o, reason: collision with root package name */
    public final int f703o;

    /* renamed from: p, reason: collision with root package name */
    public final int f704p;

    /* renamed from: q, reason: collision with root package name */
    public final CharSequence f705q;

    /* renamed from: r, reason: collision with root package name */
    public final int f706r;

    /* renamed from: s, reason: collision with root package name */
    public final CharSequence f707s;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f708t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f709u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f710v;

    public c(b bVar) {
        int size = bVar.f678a.size();
        this.f697i = new int[size * 5];
        if (!bVar.f684g) {
            m7.c.p("Not on back stack");
            throw null;
        }
        this.f698j = new ArrayList(size);
        this.f699k = new int[size];
        this.f700l = new int[size];
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            o0 o0Var = (o0) bVar.f678a.get(i10);
            int i11 = i9 + 1;
            this.f697i[i9] = o0Var.f816a;
            ArrayList arrayList = this.f698j;
            s sVar = o0Var.f817b;
            arrayList.add(sVar != null ? sVar.f846m : null);
            int[] iArr = this.f697i;
            iArr[i11] = o0Var.f818c;
            iArr[i9 + 2] = o0Var.f819d;
            int i12 = i9 + 4;
            iArr[i9 + 3] = o0Var.f820e;
            i9 += 5;
            iArr[i12] = o0Var.f821f;
            this.f699k[i10] = o0Var.f822g.ordinal();
            this.f700l[i10] = o0Var.h.ordinal();
        }
        this.f701m = bVar.f683f;
        this.f702n = bVar.h;
        this.f703o = bVar.f694r;
        this.f704p = bVar.f685i;
        this.f705q = bVar.f686j;
        this.f706r = bVar.f687k;
        this.f707s = bVar.f688l;
        this.f708t = bVar.f689m;
        this.f709u = bVar.f690n;
        this.f710v = bVar.f691o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeIntArray(this.f697i);
        parcel.writeStringList(this.f698j);
        parcel.writeIntArray(this.f699k);
        parcel.writeIntArray(this.f700l);
        parcel.writeInt(this.f701m);
        parcel.writeString(this.f702n);
        parcel.writeInt(this.f703o);
        parcel.writeInt(this.f704p);
        TextUtils.writeToParcel(this.f705q, parcel, 0);
        parcel.writeInt(this.f706r);
        TextUtils.writeToParcel(this.f707s, parcel, 0);
        parcel.writeStringList(this.f708t);
        parcel.writeStringList(this.f709u);
        parcel.writeInt(this.f710v ? 1 : 0);
    }

    public c(Parcel parcel) {
        this.f697i = parcel.createIntArray();
        this.f698j = parcel.createStringArrayList();
        this.f699k = parcel.createIntArray();
        this.f700l = parcel.createIntArray();
        this.f701m = parcel.readInt();
        this.f702n = parcel.readString();
        this.f703o = parcel.readInt();
        this.f704p = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f705q = (CharSequence) creator.createFromParcel(parcel);
        this.f706r = parcel.readInt();
        this.f707s = (CharSequence) creator.createFromParcel(parcel);
        this.f708t = parcel.createStringArrayList();
        this.f709u = parcel.createStringArrayList();
        this.f710v = parcel.readInt() != 0;
    }
}
