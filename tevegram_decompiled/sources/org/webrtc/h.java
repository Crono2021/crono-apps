package org.webrtc;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8052i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f8053j;

    public /* synthetic */ h(int i9, ByteBuffer byteBuffer) {
        this.f8052i = i9;
        this.f8053j = byteBuffer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8052i) {
            case 0:
                JniCommon.nativeFreeByteBuffer(this.f8053j);
                break;
            default:
                JniCommon.nativeFreeByteBuffer(this.f8053j);
                break;
        }
    }
}
