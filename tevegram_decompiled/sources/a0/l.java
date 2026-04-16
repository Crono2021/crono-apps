package a0;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.emoji2.text.u;
import androidx.lifecycle.n;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import g1.p;
import i8.c0;
import i8.w;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Inflater;
import m.t;
import m6.r;
import r6.e1;
import r6.q1;
import r6.y0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import v1.d0;
import v1.q;
import v1.v;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements z2.l, d0, o1.e {

    /* renamed from: i, reason: collision with root package name */
    public Object f30i;

    /* renamed from: j, reason: collision with root package name */
    public Object f31j;

    /* renamed from: k, reason: collision with root package name */
    public Object f32k;

    /* renamed from: l, reason: collision with root package name */
    public Object f33l;

    public l(int i9) {
        switch (i9) {
            case 4:
                this.f30i = new p();
                this.f31j = new p();
                this.f32k = new c3.a();
                break;
            case 8:
                l7.a aVar = new l7.a();
                this.f30i = aVar;
                this.f31j = new float[IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED];
                this.f32k = new float[256];
                aVar.f6272b = IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED;
                aVar.f6271a = IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED;
                int[] iArr = new int[IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED];
                for (int i10 = 0; i10 < 512; i10++) {
                    iArr[i10] = i10;
                }
                aVar.f6277g = iArr;
                int i11 = aVar.f6271a;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    if (i12 > i13) {
                        int[] iArr2 = (int[]) aVar.f6277g;
                        iArr2.getClass();
                        int i14 = iArr2[i13];
                        int[] iArr3 = (int[]) aVar.f6277g;
                        iArr3.getClass();
                        int[] iArr4 = (int[]) aVar.f6277g;
                        iArr4.getClass();
                        iArr3[i13] = iArr4[i12];
                        int[] iArr5 = (int[]) aVar.f6277g;
                        iArr5.getClass();
                        iArr5[i12] = i14;
                    }
                    int i15 = aVar.f6271a >> 1;
                    while (i15 >= 1 && i12 >= i15) {
                        i12 -= i15;
                        i15 >>= 1;
                    }
                    i12 += i15;
                }
                int i16 = 0;
                for (int i17 = 2; i17 <= aVar.f6271a; i17 <<= 1) {
                    i16++;
                }
                float[][] fArr = new float[i16][];
                for (int i18 = 0; i18 < i16; i18++) {
                    fArr[i18] = new float[2];
                }
                aVar.h = fArr;
                int i19 = 0;
                for (int i20 = 2; i20 <= aVar.f6271a; i20 <<= 1) {
                    float[][] fArr2 = (float[][]) aVar.h;
                    fArr2.getClass();
                    double d9 = (-6.2831855f) / i20;
                    fArr2[i19][0] = (float) Math.cos(d9);
                    float[][] fArr3 = (float[][]) aVar.h;
                    fArr3.getClass();
                    fArr3[i19][1] = (float) Math.sin(d9);
                    i19++;
                }
                int i21 = aVar.f6272b;
                float f9 = (1.0f / i21) * 6.2831855f;
                float[] fArr4 = new float[i21];
                for (int i22 = 0; i22 < i21; i22++) {
                    fArr4[i22] = (float) Math.pow((((float) Math.sin((i22 * f9) - 1.5707964f)) * 0.5f) + 0.5f, 1.0f);
                }
                aVar.f6273c = fArr4;
                int i23 = aVar.f6271a / 2;
                float f10 = 1.0f / i23;
                float[] fArr5 = new float[i23];
                for (int i24 = 0; i24 < i23; i24++) {
                    fArr5[i24] = (-0.02f) * ((float) Math.log10(((aVar.f6271a / 2) - i24) * f10));
                }
                aVar.f6274d = fArr5;
                int i25 = aVar.f6271a;
                aVar.f6275e = new float[i25];
                aVar.f6276f = new float[i25];
                break;
            case 9:
                this.f30i = new HashMap();
                this.f31j = new HashMap();
                this.f32k = new HashMap();
                this.f33l = new HashMap();
                break;
            case 14:
                this.f30i = new s.d();
                this.f31j = new SparseArray();
                this.f32k = new s.g();
                this.f33l = new s.d();
                break;
            default:
                this.f30i = new m0.d(10);
                this.f31j = new s.h();
                this.f32k = new ArrayList();
                this.f33l = new HashSet();
                break;
        }
    }

    public static final Object a(l lVar, ArrayList arrayList, t7.h hVar) {
        lVar.getClass();
        Object q4 = w.q(c0.f5251b, new n(lVar, arrayList, null, 1), hVar);
        return q4 == s7.a.f8891i ? q4 : n7.g.f7490c;
    }

    @Override // v1.d0
    public void Q(int i9, z zVar, q qVar, v vVar) {
        if (n(i9, zVar)) {
            ((o1.d) this.f31j).i(qVar, p(vVar, zVar));
        }
    }

    @Override // v1.d0
    public void T(int i9, z zVar, q qVar, v vVar, IOException iOException, boolean z8) {
        if (n(i9, zVar)) {
            ((o1.d) this.f31j).g(qVar, p(vVar, zVar), iOException, z8);
        }
    }

    @Override // v1.d0
    public void V(int i9, z zVar, q qVar, v vVar) {
        if (n(i9, zVar)) {
            ((o1.d) this.f31j).e(qVar, p(vVar, zVar));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // z2.l
    public void a0(byte[] bArr, int i9, int i10, z2.k kVar, g1.c cVar) {
        p pVar;
        f1.b bVar;
        int i11;
        p pVar2;
        int w8;
        c3.a aVar = (c3.a) this.f32k;
        p pVar3 = (p) this.f30i;
        pVar3.D(bArr, i9 + i10);
        pVar3.F(i9);
        p pVar4 = (p) this.f31j;
        if (pVar3.a() > 0 && (pVar3.f3699a[pVar3.f3700b] & 255) == 120) {
            if (((Inflater) this.f33l) == null) {
                this.f33l = new Inflater();
            }
            if (g1.w.G(pVar3, pVar4, (Inflater) this.f33l)) {
                pVar3.D(pVar4.f3699a, pVar4.f3701c);
            }
        }
        int i12 = 0;
        aVar.f1618d = 0;
        int[] iArr = aVar.f1616b;
        p pVar5 = aVar.f1615a;
        aVar.f1619e = 0;
        aVar.f1620f = 0;
        aVar.f1621g = 0;
        aVar.h = 0;
        aVar.f1622i = 0;
        pVar5.C(0);
        aVar.f1617c = false;
        ArrayList arrayList = new ArrayList();
        while (pVar3.a() >= 3) {
            int i13 = pVar3.f3701c;
            int t8 = pVar3.t();
            int z8 = pVar3.z();
            int i14 = pVar3.f3700b + z8;
            if (i14 > i13) {
                pVar3.F(i13);
                pVar = pVar5;
                bVar = null;
            } else {
                if (t8 != 128) {
                    switch (t8) {
                        case 20:
                            if (z8 % 5 == 2) {
                                pVar3.G(2);
                                Arrays.fill(iArr, i12);
                                int i15 = z8 / 5;
                                int i16 = 0;
                                while (i16 < i15) {
                                    int t9 = pVar3.t();
                                    double t10 = pVar3.t();
                                    double t11 = pVar3.t() - 128;
                                    double t12 = pVar3.t() - 128;
                                    iArr[t9] = (g1.w.h((int) ((1.402d * t11) + t10), 0, 255) << 16) | (pVar3.t() << 24) | (g1.w.h((int) ((t10 - (0.34414d * t12)) - (t11 * 0.71414d)), 0, 255) << 8) | g1.w.h((int) ((t12 * 1.772d) + t10), 0, 255);
                                    i16++;
                                    pVar5 = pVar5;
                                    aVar = aVar;
                                }
                                pVar2 = pVar5;
                                aVar.f1617c = true;
                                break;
                            }
                            pVar2 = pVar5;
                            break;
                        case 21:
                            if (z8 >= 4) {
                                pVar3.G(3);
                                int i17 = z8 - 4;
                                if ((128 & pVar3.t()) != 0) {
                                    if (i17 >= 7 && (w8 = pVar3.w()) >= 4) {
                                        aVar.h = pVar3.z();
                                        aVar.f1622i = pVar3.z();
                                        pVar5.C(w8 - 4);
                                        i17 = z8 - 11;
                                    }
                                }
                                int i18 = pVar5.f3700b;
                                int i19 = pVar5.f3701c;
                                if (i18 < i19 && i17 > 0) {
                                    int min = Math.min(i17, i19 - i18);
                                    pVar3.e(i18, min, pVar5.f3699a);
                                    pVar5.F(i18 + min);
                                }
                            }
                            pVar2 = pVar5;
                            break;
                        case 22:
                            if (z8 >= 19) {
                                aVar.f1618d = pVar3.z();
                                aVar.f1619e = pVar3.z();
                                pVar3.G(11);
                                aVar.f1620f = pVar3.z();
                                aVar.f1621g = pVar3.z();
                            }
                            pVar2 = pVar5;
                            break;
                        default:
                            pVar2 = pVar5;
                            break;
                    }
                    pVar = pVar2;
                    bVar = null;
                } else {
                    p pVar6 = pVar5;
                    if (aVar.f1618d == 0 || aVar.f1619e == 0 || aVar.h == 0 || aVar.f1622i == 0) {
                        pVar = pVar6;
                    } else {
                        pVar = pVar6;
                        int i20 = pVar.f3701c;
                        if (i20 != 0 && pVar.f3700b == i20 && aVar.f1617c) {
                            pVar.F(0);
                            int i21 = aVar.h * aVar.f1622i;
                            int[] iArr2 = new int[i21];
                            int i22 = 0;
                            while (i22 < i21) {
                                int t13 = pVar.t();
                                if (t13 != 0) {
                                    i11 = i22 + 1;
                                    iArr2[i22] = iArr[t13];
                                } else {
                                    int t14 = pVar.t();
                                    if (t14 != 0) {
                                        i11 = ((t14 & 64) == 0 ? t14 & 63 : ((t14 & 63) << 8) | pVar.t()) + i22;
                                        Arrays.fill(iArr2, i22, i11, (t14 & 128) == 0 ? 0 : iArr[pVar.t()]);
                                    }
                                }
                                i22 = i11;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(iArr2, aVar.h, aVar.f1622i, Bitmap.Config.ARGB_8888);
                            float f9 = aVar.f1620f;
                            float f10 = aVar.f1618d;
                            float f11 = f9 / f10;
                            float f12 = aVar.f1621g;
                            float f13 = aVar.f1619e;
                            bVar = new f1.b(null, null, null, createBitmap, f12 / f13, 0, 0, f11, 0, Integer.MIN_VALUE, -3.4028235E38f, aVar.h / f10, aVar.f1622i / f13, false, -16777216, Integer.MIN_VALUE, 0.0f);
                            aVar.f1618d = 0;
                            aVar.f1619e = 0;
                            aVar.f1620f = 0;
                            aVar.f1621g = 0;
                            aVar.h = 0;
                            aVar.f1622i = 0;
                            pVar.C(0);
                            aVar.f1617c = false;
                        }
                    }
                    bVar = null;
                    aVar.f1618d = 0;
                    aVar.f1619e = 0;
                    aVar.f1620f = 0;
                    aVar.f1621g = 0;
                    aVar.h = 0;
                    aVar.f1622i = 0;
                    pVar.C(0);
                    aVar.f1617c = false;
                }
                pVar3.F(i14);
            }
            if (bVar != null) {
                arrayList.add(bVar);
            }
            pVar5 = pVar;
            i12 = 0;
        }
        cVar.accept(new z2.a(-9223372036854775807L, -9223372036854775807L, arrayList));
    }

    public void b(HistoryItem historyItem) {
        k7.a aVar = new k7.a((g.l) this.f30i);
        if (aVar.f5628b.getBoolean("history_enabled", true)) {
            w.j((n8.e) this.f33l, null, new b7.c(this, historyItem, aVar, null, 0), 3);
        }
    }

    public synchronized boolean c(String str, PlaylistItem playlistItem) {
        Object obj;
        try {
            str.getClass();
            ArrayList arrayList = (ArrayList) this.f32k;
            int size = arrayList.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i9);
                i9++;
                if (b8.i.a(((Playlist) obj).getId(), str)) {
                    break;
                }
            }
            Playlist playlist = (Playlist) obj;
            if (playlist != null) {
                List<PlaylistItem> items = playlist.getItems();
                if (!(items != null) || !items.isEmpty()) {
                    for (PlaylistItem playlistItem2 : items) {
                        if (playlistItem2.getChatId() != playlistItem.getChatId() || playlistItem2.getMsgId() != playlistItem.getMsgId()) {
                        }
                    }
                }
                playlist.getItems().add(playlistItem);
                playlist.setLastModified(System.currentTimeMillis());
                w();
                return true;
            }
            return false;
        } finally {
        }
    }

    public void d(Object obj, Object obj2, e1 e1Var, boolean z8) {
        byte[] array;
        if (((ConcurrentHashMap) this.f31j) == null) {
            m7.c.p("addPrimitive cannot be called after build");
            return;
        }
        if (obj == null && obj2 == null) {
            androidx.fragment.app.a.o("at least one of the `fullPrimitive` or `primitive` must be set");
            return;
        }
        if (e1Var.D() != y0.ENABLED) {
            androidx.fragment.app.a.o("only ENABLED key is allowed");
            return;
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f31j;
        Integer valueOf = Integer.valueOf(e1Var.B());
        if (e1Var.C() == q1.RAW) {
            valueOf = null;
        }
        f6.b a9 = m6.j.f6666b.a(m6.p.c(e1Var.A().B(), e1Var.A().C(), e1Var.A().A(), e1Var.C(), valueOf));
        int ordinal = e1Var.C().ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    array = f6.b.f3415a;
                } else if (ordinal != 4) {
                    androidx.fragment.app.a.o("unknown output prefix type");
                    return;
                }
            }
            array = ByteBuffer.allocate(5).put((byte) 0).putInt(e1Var.B()).array();
        } else {
            array = ByteBuffer.allocate(5).put((byte) 1).putInt(e1Var.B()).array();
        }
        f6.k kVar = new f6.k(obj, obj2, array, e1Var.D(), e1Var.C(), e1Var.B(), e1Var.A().B(), a9);
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        byte[] bArr = kVar.f3429c;
        f6.l lVar = new f6.l(bArr != null ? Arrays.copyOf(bArr, bArr.length) : null);
        List list = (List) concurrentHashMap.put(lVar, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(kVar);
            concurrentHashMap.put(lVar, Collections.unmodifiableList(arrayList2));
        }
        if (z8) {
            if (((f6.k) this.f32k) == null) {
                this.f32k = kVar;
            } else {
                m7.c.p("you cannot set two primary primitives");
            }
        }
    }

    public n6.j e() {
        Integer num = (Integer) this.f30i;
        if (num == null) {
            androidx.fragment.app.a.o("key size is not set");
            return null;
        }
        if (((Integer) this.f31j) == null) {
            androidx.fragment.app.a.o("tag size is not set");
            return null;
        }
        if (((n6.c) this.f32k) == null) {
            androidx.fragment.app.a.o("hash type is not set");
            return null;
        }
        if (((n6.c) this.f33l) == null) {
            androidx.fragment.app.a.o("variant is not set");
            return null;
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", (Integer) this.f30i));
        }
        Integer num2 = (Integer) this.f31j;
        int intValue = num2.intValue();
        n6.c cVar = (n6.c) this.f32k;
        if (intValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (cVar == n6.c.f7446g) {
            if (intValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (cVar == n6.c.h) {
            if (intValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (cVar == n6.c.f7447i) {
            if (intValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (cVar == n6.c.f7448j) {
            if (intValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (cVar != n6.c.f7449k) {
                androidx.fragment.app.a.o("unknown hash type; must be SHA256, SHA384 or SHA512");
                return null;
            }
            if (intValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new n6.j(((Integer) this.f30i).intValue(), ((Integer) this.f31j).intValue(), (n6.c) this.f33l, (n6.c) this.f32k);
    }

    public synchronized Playlist f(String str) {
        Playlist playlist;
        str.getClass();
        playlist = new Playlist(null, str, 0L, null, false, false, false, false, 0L, 509, null);
        ((ArrayList) this.f32k).add(playlist);
        w();
        return playlist;
    }

    public void g(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            m7.c.i("This graph contains cyclic dependencies");
            return;
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((s.h) this.f31j).getOrDefault(obj, null);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i9 = 0; i9 < size; i9++) {
                g(arrayList2.get(i9), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public l.f h(l.a aVar) {
        ArrayList arrayList = (ArrayList) this.f32k;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            l.f fVar = (l.f) arrayList.get(i9);
            if (fVar != null && fVar.f5692b == aVar) {
                return fVar;
            }
        }
        l.f fVar2 = new l.f((Context) this.f33l, aVar);
        arrayList.add(fVar2);
        return fVar2;
    }

    @Override // z2.l
    public /* synthetic */ z2.f h0(int i9, int i10, byte[] bArr) {
        return t.a.a(this, bArr, i10);
    }

    public Object i(t7.c cVar) {
        return w.q(c0.f5251b, new b7.e(this, null, 0), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.String r6, t7.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof b7.f
            if (r0 == 0) goto L13
            r0 = r7
            b7.f r0 = (b7.f) r0
            int r1 = r0.f1496o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1496o = r1
            goto L18
        L13:
            b7.f r0 = new b7.f
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f1494m
            int r1 = r0.f1496o
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            java.lang.String r6 = r0.f1493l
            com.bumptech.glide.c.V(r7)
            goto L3e
        L27:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            m7.c.p(r6)
            r6 = 0
            return r6
        L2e:
            com.bumptech.glide.c.V(r7)
            r0.f1493l = r6
            r0.f1496o = r2
            java.lang.Object r7 = r5.i(r0)
            s7.a r0 = s7.a.f8891i
            if (r7 != r0) goto L3e
            return r0
        L3e:
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r0 = r7.iterator()
        L44:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L5d
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.network.tvgramplayer.data.HistoryItem r3 = (com.network.tvgramplayer.data.HistoryItem) r3
            java.lang.String r3 = r3.getUrl()
            boolean r3 = b8.i.a(r3, r6)
            if (r3 == 0) goto L44
            goto L5e
        L5d:
            r1 = r2
        L5e:
            com.network.tvgramplayer.data.HistoryItem r1 = (com.network.tvgramplayer.data.HistoryItem) r1
            if (r1 == 0) goto L63
            return r1
        L63:
            java.util.Iterator r7 = r7.iterator()
        L67:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L8a
            java.lang.Object r0 = r7.next()
            r1 = r0
            com.network.tvgramplayer.data.HistoryItem r1 = (com.network.tvgramplayer.data.HistoryItem) r1
            java.lang.String r3 = r1.getUrl()
            r4 = 0
            boolean r3 = h8.e.g0(r3, r6, r4)
            if (r3 != 0) goto L89
            java.lang.String r1 = r1.getUrl()
            boolean r1 = h8.e.g0(r6, r1, r4)
            if (r1 == 0) goto L67
        L89:
            return r0
        L8a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.l.j(java.lang.String, t7.c):java.lang.Object");
    }

    public Playlist k(String str) {
        Object obj;
        str.getClass();
        ArrayList arrayList = (ArrayList) this.f32k;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i9);
            i9++;
            if (b8.i.a(((Playlist) obj).getId(), str)) {
                break;
            }
        }
        return (Playlist) obj;
    }

    public boolean l(String str) {
        ArrayList arrayList = (ArrayList) this.f32k;
        try {
            Object fromJson = ((Gson) this.f31j).fromJson(str, new TypeToken<b7.a>() { // from class: com.network.tvgramplayer.data.PlaylistManager$importPlaylistFromJson$type$1
            }.getType());
            fromJson.getClass();
            Playlist playlist = ((b7.a) fromJson).f1481d;
            int size = arrayList.size();
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i9 = -1;
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                if (b8.i.a(((Playlist) obj).getId(), playlist.getId())) {
                    break;
                }
                i9++;
            }
            if (i9 != -1) {
                arrayList.set(i9, playlist);
            } else {
                arrayList.add(playlist);
            }
            w();
            Log.i("PlaylistManager", "📥 Sincronización exitosa: '" + playlist.getName() + "' ahora tiene " + playlist.getItems().size() + " elementos.");
            return true;
        } catch (Exception e9) {
            Log.e("PlaylistManager", "❌ Error al importar lista desde JSON", e9);
            return false;
        }
    }

    @Override // v1.d0
    public void m(int i9, z zVar, v vVar) {
        if (n(i9, zVar)) {
            ((o1.d) this.f31j).a(p(vVar, zVar));
        }
    }

    public boolean n(int i9, z zVar) {
        z zVar2;
        Object obj = this.f30i;
        v1.j jVar = (v1.j) this.f33l;
        if (zVar != null) {
            zVar2 = jVar.s(obj, zVar);
            if (zVar2 == null) {
                return false;
            }
        } else {
            zVar2 = null;
        }
        int u3 = jVar.u(i9, obj);
        o1.d dVar = (o1.d) this.f31j;
        if (dVar.f7569a != u3 || !g1.w.a(dVar.f7570b, zVar2)) {
            this.f31j = new o1.d(jVar.f9235c.f7571c, u3, zVar2);
        }
        o1.d dVar2 = (o1.d) this.f32k;
        if (dVar2.f7569a == u3 && g1.w.a(dVar2.f7570b, zVar2)) {
            return true;
        }
        this.f32k = new o1.d(jVar.f9236d.f7571c, u3, zVar2);
        return true;
    }

    @Override // v1.d0
    public void o(int i9, z zVar, v vVar) {
        if (n(i9, zVar)) {
            ((o1.d) this.f31j).j(p(vVar, zVar));
        }
    }

    public v p(v vVar, z zVar) {
        v1.j jVar = (v1.j) this.f33l;
        Object obj = this.f30i;
        long j5 = vVar.f9442f;
        long t8 = jVar.t(j5, obj);
        long j9 = vVar.f9443g;
        long t9 = jVar.t(j9, obj);
        return (t8 == j5 && t9 == j9) ? vVar : new v(vVar.f9437a, vVar.f9438b, vVar.f9439c, vVar.f9440d, vVar.f9441e, t8, t9);
    }

    public boolean q(l.a aVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f30i).onActionItemClicked(h(aVar), new t((Context) this.f33l, (h0.a) menuItem));
    }

    public boolean r(l.a aVar, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f30i;
        l.f h = h(aVar);
        s.h hVar = (s.h) this.f31j;
        Menu menu2 = (Menu) hVar.getOrDefault(menu, null);
        if (menu2 == null) {
            menu2 = new m.c0((Context) this.f33l, (m.m) menu);
            hVar.put(menu, menu2);
        }
        return callback.onCreateActionMode(h, menu2);
    }

    public void s(m6.a aVar) {
        aVar.getClass();
        r rVar = new r(m6.p.class, aVar.f6653a);
        HashMap hashMap = (HashMap) this.f31j;
        if (!hashMap.containsKey(rVar)) {
            hashMap.put(rVar, aVar);
            return;
        }
        m6.a aVar2 = (m6.a) hashMap.get(rVar);
        if (aVar2.equals(aVar) && aVar.equals(aVar2)) {
            return;
        }
        androidx.fragment.app.a.u(rVar, "Attempt to register non-equal parser for already existing object of type: ");
    }

    public void t(m6.k kVar) {
        kVar.getClass();
        r rVar = new r(m6.q.class, kVar.f6668a);
        HashMap hashMap = (HashMap) this.f33l;
        if (!hashMap.containsKey(rVar)) {
            hashMap.put(rVar, kVar);
            return;
        }
        m6.k kVar2 = (m6.k) hashMap.get(rVar);
        if (kVar2.equals(kVar) && kVar.equals(kVar2)) {
            return;
        }
        androidx.fragment.app.a.u(rVar, "Attempt to register non-equal parser for already existing object of type: ");
    }

    public synchronized boolean u(String str, String str2) {
        Object obj;
        boolean removeIf;
        try {
            str.getClass();
            str2.getClass();
            ArrayList arrayList = (ArrayList) this.f32k;
            int size = arrayList.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    obj = null;
                    break;
                }
                obj = arrayList.get(i9);
                i9++;
                if (b8.i.a(((Playlist) obj).getId(), str)) {
                    break;
                }
            }
            Playlist playlist = (Playlist) obj;
            if (playlist == null) {
                return false;
            }
            removeIf = playlist.getItems().removeIf(new b7.j(new b7.i(str2, 0), 0));
            if (removeIf) {
                w();
            }
            return removeIf;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void v(List list) {
        ((SharedPreferences) this.f30i).edit().putString("subscribed_channels", ((Gson) this.f31j).toJson(list)).apply();
        ((l8.d) this.f32k).e(o7.h.O0(list, new k(9)));
    }

    public synchronized void w() {
        try {
            String json = ((Gson) this.f31j).toJson((ArrayList) this.f32k);
            File file = new File(((Context) this.f30i).getFilesDir(), (String) this.f33l);
            json.getClass();
            com.bumptech.glide.c.Z(file, json);
        } catch (Exception e9) {
            Log.e("PlaylistManager", "❌ Error al guardar en " + ((String) this.f33l), e9);
        }
    }

    public synchronized boolean x(String str, boolean z8) {
        str.getClass();
        Playlist k3 = k(str);
        if (k3 == null) {
            return false;
        }
        k3.setLoopEnabled(z8);
        k3.setLastModified(System.currentTimeMillis());
        w();
        return true;
    }

    @Override // v1.d0
    public void y(int i9, z zVar, q qVar, v vVar) {
        if (n(i9, zVar)) {
            ((o1.d) this.f31j).c(qVar, p(vVar, zVar));
        }
    }

    public synchronized boolean z(String str, boolean z8) {
        str.getClass();
        Playlist k3 = k(str);
        if (k3 == null) {
            return false;
        }
        k3.setShuffleEnabled(z8);
        k3.setLastModified(System.currentTimeMillis());
        w();
        return true;
    }

    @Override // z2.l
    public /* synthetic */ void reset() {
    }

    public l(g.l lVar) {
        this.f30i = lVar;
        this.f31j = lVar.getSharedPreferences("stream_history", 0);
        this.f32k = new Gson();
        this.f33l = w.a(c0.f5251b);
    }

    public l(Context context) {
        this.f30i = context;
        Gson gson = new Gson();
        this.f31j = gson;
        this.f33l = "tvgram_playlists.json";
        ArrayList arrayList = new ArrayList();
        this.f32k = arrayList;
        synchronized (this) {
            try {
                File file = new File(context.getFilesDir(), "tvgram_playlists.json");
                if (file.exists()) {
                    try {
                        List<Playlist> list = (List) gson.fromJson(com.bumptech.glide.c.P(file), new TypeToken<List<? extends Playlist>>() { // from class: com.network.tvgramplayer.data.PlaylistManager$loadFromDisk$type$1
                        }.getType());
                        if (list != null) {
                            arrayList.clear();
                            ArrayList arrayList2 = new ArrayList(o7.j.E0(list));
                            for (Playlist playlist : list) {
                                String id = playlist.getId();
                                String name = playlist.getName();
                                name = name == null ? "Lista Recuperada" : name;
                                long dateCreated = playlist.getDateCreated();
                                List<PlaylistItem> items = playlist.getItems();
                                if (items == null) {
                                    items = new ArrayList<>();
                                }
                                arrayList2.add(new Playlist(id, name, dateCreated, items, playlist.isPinned(), playlist.isShuffleEnabled(), playlist.isLoopEnabled(), playlist.isAutoNextEnabled(), playlist.getLastModified()));
                            }
                            arrayList.addAll(arrayList2);
                            Log.i("PlaylistManager", "✅ Cargadas " + ((ArrayList) this.f32k).size() + " listas desde el disco");
                        }
                    } catch (Exception e9) {
                        Log.e("PlaylistManager", "❌ Error al leer o procesar " + ((String) this.f33l), e9);
                    }
                } else {
                    f("Favoritos");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public l(m6.t tVar) {
        this.f30i = new HashMap(tVar.f6687a);
        this.f31j = new HashMap(tVar.f6688b);
        this.f32k = new HashMap(tVar.f6689c);
        this.f33l = new HashMap(tVar.f6690d);
    }

    public l(Typeface typeface, w0.b bVar) {
        int i9;
        int i10;
        int i11;
        int i12;
        this.f33l = typeface;
        this.f30i = bVar;
        this.f32k = new u(1024);
        int a9 = bVar.a(6);
        if (a9 != 0) {
            int i13 = a9 + bVar.f7131a;
            i9 = ((ByteBuffer) bVar.f7134d).getInt(((ByteBuffer) bVar.f7134d).getInt(i13) + i13);
        } else {
            i9 = 0;
        }
        this.f31j = new char[i9 * 2];
        int a10 = bVar.a(6);
        if (a10 != 0) {
            int i14 = a10 + bVar.f7131a;
            i10 = ((ByteBuffer) bVar.f7134d).getInt(((ByteBuffer) bVar.f7134d).getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        for (int i15 = 0; i15 < i10; i15++) {
            androidx.emoji2.text.q qVar = new androidx.emoji2.text.q(this, i15);
            w0.a b9 = qVar.b();
            int a11 = b9.a(4);
            Character.toChars(a11 != 0 ? ((ByteBuffer) b9.f7134d).getInt(a11 + b9.f7131a) : 0, (char[]) this.f31j, i15 * 2);
            w0.a b10 = qVar.b();
            int a12 = b10.a(16);
            if (a12 != 0) {
                int i16 = a12 + b10.f7131a;
                i11 = ((ByteBuffer) b10.f7134d).getInt(((ByteBuffer) b10.f7134d).getInt(i16) + i16);
            } else {
                i11 = 0;
            }
            android.support.v4.media.session.b.o("invalid metadata codepoint length", i11 > 0);
            u uVar = (u) this.f32k;
            w0.a b11 = qVar.b();
            int a13 = b11.a(16);
            if (a13 != 0) {
                int i17 = a13 + b11.f7131a;
                i12 = ((ByteBuffer) b11.f7134d).getInt(((ByteBuffer) b11.f7134d).getInt(i17) + i17);
            } else {
                i12 = 0;
            }
            uVar.a(qVar, 0, i12 - 1);
        }
    }
}
