package s1;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Message;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8667a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b2.m f8668b;

    public /* synthetic */ a(k kVar, b2.m mVar, int i9) {
        this.f8667a = i9;
        this.f8668b = mVar;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j5, long j9) {
        switch (this.f8667a) {
            case 0:
                b2.m mVar = this.f8668b;
                Handler handler = mVar.f1216i;
                if (g1.w.f3713a >= 30) {
                    mVar.a(j5);
                    break;
                } else {
                    handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 0, (int) (j5 >> 32), (int) j5));
                    break;
                }
            default:
                b2.m mVar2 = this.f8668b;
                Handler handler2 = mVar2.f1216i;
                if (g1.w.f3713a >= 30) {
                    mVar2.a(j5);
                    break;
                } else {
                    handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, 0, (int) (j5 >> 32), (int) j5));
                    break;
                }
        }
    }
}
