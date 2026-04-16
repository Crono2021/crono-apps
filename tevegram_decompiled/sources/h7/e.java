package h7;

import d1.f1;
import d1.h1;
import d1.n0;
import d1.o0;
import d1.t0;
import i7.a2;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e implements Client.ResultHandler, g1.j, g1.k, y1.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4085i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4086j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4087k;

    public /* synthetic */ e(m1.a aVar, Object obj, long j5) {
        this.f4085i = 10;
        this.f4087k = aVar;
        this.f4086j = obj;
    }

    @Override // g1.j
    public void a(Object obj) {
        switch (this.f4085i) {
            case 3:
                ((m1.c) obj).D((m1.a) this.f4087k, (o0) this.f4086j);
                break;
            case 4:
            default:
                ((m1.c) obj).n((m1.a) this.f4087k, this.f4086j);
                break;
            case 5:
                ((m1.c) obj).B((m1.a) this.f4087k, (d1.j0) this.f4086j);
                break;
            case 6:
                ((m1.c) obj).i((m1.a) this.f4087k, (f1) this.f4086j);
                break;
            case 7:
                ((m1.c) obj).K((m1.a) this.f4087k, (n0) this.f4086j);
                break;
            case 8:
                ((m1.c) obj).J((m1.a) this.f4087k, (l1.f) this.f4086j);
                break;
            case 9:
                m1.a aVar = (m1.a) this.f4087k;
                h1 h1Var = (h1) this.f4086j;
                ((m1.c) obj).x(aVar, h1Var);
                int i9 = h1Var.f2474a;
                break;
        }
    }

    @Override // g1.k
    public void b(Object obj, d1.q qVar) {
        m1.c cVar = (m1.c) obj;
        cVar.E((t0) this.f4086j, new m1.b(qVar, ((m1.q) this.f4087k).f6555m));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
    @Override // y1.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b6.w0 d(int r17, d1.z0 r18, int[] r19) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h7.e.d(int, d1.z0, int[]):b6.w0");
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public void onResult(TdApi.Object object) {
        TdApi.File file;
        TdApi.LocalFile localFile;
        switch (this.f4085i) {
            case 0:
                i0 i0Var = (i0) this.f4087k;
                k0 k0Var = (k0) this.f4086j;
                if (object instanceof TdApi.Chat) {
                    TdApi.Chat chat = (TdApi.Chat) object;
                    TdApi.ChatPhotoInfo chatPhotoInfo = chat.photo;
                    String str = (chatPhotoInfo == null || (file = chatPhotoInfo.small) == null || (localFile = file.local) == null) ? null : localFile.path;
                    if (str != null && str.length() != 0 && !str.equals(i0Var.f4118f)) {
                        k0Var.B(i0Var.f4113a, i0Var.f4114b, true, i0Var.f4115c, i0Var.f4116d, chat);
                        break;
                    }
                }
                break;
            case 1:
                k0 k0Var2 = (k0) this.f4086j;
                TdApi.UpdateChatVideoChat updateChatVideoChat = (TdApi.UpdateChatVideoChat) this.f4087k;
                if (object instanceof TdApi.GroupCall) {
                    TdApi.GroupCall groupCall = (TdApi.GroupCall) object;
                    if (!groupCall.isActive) {
                        k0Var2.B(updateChatVideoChat.chatId, groupCall.id, false, "", 0, null);
                        break;
                    } else {
                        Client client = k0Var2.f4141l;
                        if (client != null) {
                            client.send(new TdApi.GetChat(updateChatVideoChat.chatId), new i(k0Var2, updateChatVideoChat, groupCall));
                            break;
                        }
                    }
                }
                break;
            default:
                a2 a2Var = (a2) this.f4087k;
                Long l4 = (Long) this.f4086j;
                if (!(object instanceof TdApi.Chat)) {
                    if (!(object instanceof TdApi.Error) || !b8.i.a(((TdApi.Error) object).message, "USER_ALREADY_PARTICIPANT")) {
                        a2Var.a(null);
                        break;
                    } else {
                        a2Var.a(l4);
                        break;
                    }
                } else {
                    a2Var.a(Long.valueOf(((TdApi.Chat) object).id));
                    break;
                }
        }
    }

    public /* synthetic */ e(Object obj, int i9, Object obj2) {
        this.f4085i = i9;
        this.f4087k = obj;
        this.f4086j = obj2;
    }

    public /* synthetic */ e(k0 k0Var, TdApi.UpdateChatVideoChat updateChatVideoChat) {
        this.f4085i = 1;
        this.f4086j = k0Var;
        this.f4087k = updateChatVideoChat;
    }
}
