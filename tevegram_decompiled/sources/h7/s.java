package h7;

import android.util.Log;
import b6.w0;
import com.network.tvgramplayer.telegram.TdClient$ExplorerAction;
import d1.z0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class s implements Client.ResultHandler, y1.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f4180i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4181j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4182k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Serializable f4183l;

    public /* synthetic */ s(Object obj, Object obj2, boolean z8, Serializable serializable) {
        this.f4181j = obj;
        this.f4182k = obj2;
        this.f4180i = z8;
        this.f4183l = serializable;
    }

    @Override // y1.l
    public w0 d(int i9, z0 z0Var, int[] iArr) {
        y1.o oVar = (y1.o) this.f4181j;
        y1.i iVar = (y1.i) this.f4182k;
        int[] iArr2 = (int[]) this.f4183l;
        oVar.getClass();
        y1.d dVar = new y1.d(oVar);
        int i10 = iArr2[i9];
        b6.e0 e0Var = b6.g0.f1391j;
        b6.q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i11 = 0;
        int i12 = 0;
        boolean z8 = false;
        while (i11 < z0Var.f2616a) {
            y1.e eVar = new y1.e(i9, z0Var, i11, iVar, iArr[i11], this.f4180i, dVar, i10);
            int i13 = i12 + 1;
            if (objArr.length < i13) {
                objArr = Arrays.copyOf(objArr, b6.a0.d(objArr.length, i13));
            } else if (z8) {
                objArr = (Object[]) objArr.clone();
            } else {
                objArr[i12] = eVar;
                i11++;
                i12++;
            }
            z8 = false;
            objArr[i12] = eVar;
            i11++;
            i12++;
        }
        return b6.g0.l(i12, objArr);
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public void onResult(TdApi.Object object) {
        String str;
        int i9;
        TdApi.MessageContent messageContent;
        TdClient$ExplorerAction tdClient$ExplorerAction;
        k0 k0Var = (k0) this.f4181j;
        a8.r rVar = (a8.r) this.f4182k;
        String str2 = (String) this.f4183l;
        if (object.getConstructor() == 361619055) {
            TdApi.MessageLinkInfo messageLinkInfo = (TdApi.MessageLinkInfo) object;
            TdApi.Message message = messageLinkInfo.message;
            TdApi.MessageContent messageContent2 = message != null ? message.content : null;
            k0Var.getClass();
            TdApi.File f9 = k0.f(messageContent2);
            TdApi.Message message2 = messageLinkInfo.message;
            long j5 = message2 != null ? message2.chatId : messageLinkInfo.chatId;
            if (f9 != null) {
                long j9 = j5;
                k0Var.h(j9, new w(rVar, f9, j9, k0Var, 0));
                return;
            }
            long j10 = j5;
            String url = (message2 == null || (messageContent = message2.content) == null || (tdClient$ExplorerAction = (TdClient$ExplorerAction) o7.h.I0(k0.e(messageContent))) == null) ? null : tdClient$ExplorerAction.getUrl();
            if (url != null) {
                Log.i("TdClient", "🔗 Link detectado en texto: ".concat(url));
                rVar.i(null, "EXTRACTED_LINK:::".concat(url), Long.valueOf(j10), null);
                return;
            } else {
                if (j10 == 0) {
                    rVar.i(null, "NO_VIDEO_IN_MESSAGE", null, null);
                    return;
                }
                Log.d("TdClient", "Mensaje no tiene video. Buscando el más reciente en el chat " + j10 + "...");
                k0Var.y(j10, this.f4180i, new r(k0Var, j10, rVar, 1));
                return;
            }
        }
        if (!h8.e.g0(str2, "/c/", false)) {
            TdApi.Error error = object instanceof TdApi.Error ? (TdApi.Error) object : null;
            if (error == null || (str = error.message) == null) {
                str = "RESOLVE_FAILED";
            }
            rVar.i(null, str, null, null);
            return;
        }
        k0Var.getClass();
        try {
            List p02 = h8.e.p0(str2, new String[]{"/"}, 6);
            int indexOf = p02.indexOf("c");
            if (indexOf == -1 || (i9 = indexOf + 2) >= p02.size()) {
                rVar.i(null, "INVALID_PRIVATE_URL_FORMAT", null, null);
                return;
            }
            String str3 = (String) p02.get(indexOf + 1);
            String str4 = (String) h8.e.p0((CharSequence) p02.get(i9), new String[]{"?"}, 6).get(0);
            long parseLong = h8.m.f0(str3, "-100", false) ? Long.parseLong(str3) : Long.parseLong("-100".concat(str3));
            long parseLong2 = Long.parseLong(str4) << 20;
            Client client = k0Var.f4141l;
            if (client != null) {
                client.send(new TdApi.GetMessage(parseLong, parseLong2), new l(k0Var, parseLong, rVar, 1));
            }
        } catch (Exception e9) {
            rVar.i(null, t.a.b("MANUAL_PARSE_ERROR: ", e9.getMessage()), null, null);
        }
    }
}
