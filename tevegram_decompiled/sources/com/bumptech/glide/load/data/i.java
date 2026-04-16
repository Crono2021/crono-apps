package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.HashMap;
import k4.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements g {

    /* renamed from: k, reason: collision with root package name */
    public static final h f1799k = new h(0);

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1800i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f1801j;

    public i(InputStream inputStream, e4.f fVar) {
        this.f1800i = 3;
        x xVar = new x(inputStream, fVar);
        this.f1801j = xVar;
        xVar.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.g
    public Object a() {
        switch (this.f1800i) {
            case 1:
                return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f1801j).rewind();
            case 2:
                return this.f1801j;
            default:
                x xVar = (x) this.f1801j;
                xVar.reset();
                return xVar;
        }
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
        switch (this.f1800i) {
            case 1:
            case 2:
                break;
            default:
                ((x) this.f1801j).b();
                break;
        }
    }

    public ParcelFileDescriptor e() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f1801j).rewind();
    }

    public i() {
        this.f1800i = 0;
        this.f1801j = new HashMap();
    }

    public i(ParcelFileDescriptor parcelFileDescriptor) {
        this.f1800i = 1;
        this.f1801j = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public i(Object obj) {
        this.f1800i = 2;
        this.f1801j = obj;
    }

    private final void c() {
    }

    private final void d() {
    }
}
