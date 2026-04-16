package h7;

import android.util.Log;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 implements Client.ResultHandler {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ r7.i f4125i;

    public j0(r7.i iVar) {
        this.f4125i = iVar;
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public final void onResult(TdApi.Object object) {
        r7.i iVar = this.f4125i;
        try {
            int constructor = object.getConstructor();
            if (constructor == -1679978726) {
                iVar.g(null);
                return;
            }
            if (constructor == 221197337 || constructor == 399564614) {
                Object obj = object.getClass().getField("data").get(object);
                iVar.g(obj instanceof byte[] ? (byte[]) obj : null);
                return;
            }
            if (h8.e.g0(object.getClass().getSimpleName(), "FilePart", false)) {
                Object obj2 = object.getClass().getField("data").get(object);
                iVar.g(obj2 instanceof byte[] ? (byte[]) obj2 : null);
                return;
            }
            Log.e("TdClient", "ReadFilePart devolvió tipo no manejado: " + object.getConstructor() + " (" + object.getClass().getSimpleName() + ")");
            iVar.g(null);
        } catch (Exception e9) {
            Log.e("TdClient", "Error procesando ReadFilePart: " + e9.getMessage());
            iVar.g(null);
        }
    }
}
