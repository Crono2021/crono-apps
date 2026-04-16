package p4;

import b4.i;
import d4.a0;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import o4.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements a {

    /* renamed from: j, reason: collision with root package name */
    public static final d f8252j = new d(0);

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8253i;

    public /* synthetic */ d(int i9) {
        this.f8253i = i9;
    }

    @Override // p4.a
    public final a0 k(a0 a0Var, i iVar) {
        b3.d dVar;
        byte[] bArr;
        switch (this.f8253i) {
            case 0:
                return a0Var;
            default:
                ByteBuffer asReadOnlyBuffer = ((h) ((o4.c) a0Var.get()).f7890i.f7889b).f7912a.f154d.asReadOnlyBuffer();
                AtomicReference atomicReference = w4.b.f9930a;
                if (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) {
                    dVar = null;
                } else {
                    dVar = new b3.d(asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit(), asReadOnlyBuffer.array());
                }
                if (dVar != null && dVar.f1286j == 0 && dVar.f1287k == ((byte[]) dVar.f1288l).length) {
                    bArr = asReadOnlyBuffer.array();
                } else {
                    ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
                    byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
                    asReadOnlyBuffer2.get(bArr2);
                    bArr = bArr2;
                }
                return new k4.a0(bArr);
        }
    }
}
