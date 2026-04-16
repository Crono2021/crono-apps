package x;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class g implements e {

    /* renamed from: d, reason: collision with root package name */
    public final n f9998d;

    /* renamed from: f, reason: collision with root package name */
    public int f10000f;

    /* renamed from: g, reason: collision with root package name */
    public int f10001g;

    /* renamed from: a, reason: collision with root package name */
    public n f9995a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9996b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9997c = false;

    /* renamed from: e, reason: collision with root package name */
    public int f9999e = 1;
    public int h = 1;

    /* renamed from: i, reason: collision with root package name */
    public h f10002i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10003j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f10004k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f10005l = new ArrayList();

    public g(n nVar) {
        this.f9998d = nVar;
    }

    @Override // x.e
    public final void a(e eVar) {
        ArrayList arrayList = this.f10005l;
        int size = arrayList.size();
        int i9 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            if (!((g) obj).f10003j) {
                return;
            }
        }
        this.f9997c = true;
        n nVar = this.f9995a;
        if (nVar != null) {
            nVar.a(this);
        }
        if (this.f9996b) {
            this.f9998d.a(this);
            return;
        }
        int size2 = arrayList.size();
        g gVar = null;
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList.get(i11);
            i11++;
            g gVar2 = (g) obj2;
            if (!(gVar2 instanceof h)) {
                i9++;
                gVar = gVar2;
            }
        }
        if (gVar != null && i9 == 1 && gVar.f10003j) {
            h hVar = this.f10002i;
            if (hVar != null) {
                if (!hVar.f10003j) {
                    return;
                } else {
                    this.f10000f = this.h * hVar.f10001g;
                }
            }
            d(gVar.f10001g + this.f10000f);
        }
        n nVar2 = this.f9995a;
        if (nVar2 != null) {
            nVar2.a(this);
        }
    }

    public final void b(n nVar) {
        this.f10004k.add(nVar);
        if (this.f10003j) {
            nVar.a(nVar);
        }
    }

    public final void c() {
        this.f10005l.clear();
        this.f10004k.clear();
        this.f10003j = false;
        this.f10001g = 0;
        this.f9997c = false;
        this.f9996b = false;
    }

    public void d(int i9) {
        if (this.f10003j) {
            return;
        }
        this.f10003j = true;
        this.f10001g = i9;
        ArrayList arrayList = this.f10004k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            e eVar = (e) obj;
            eVar.a(eVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9998d.f10013b.W);
        sb.append(":");
        switch (this.f9999e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f10003j ? Integer.valueOf(this.f10001g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f10005l.size());
        sb.append(":d=");
        sb.append(this.f10004k.size());
        sb.append(">");
        return sb.toString();
    }
}
