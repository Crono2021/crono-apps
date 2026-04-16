package h7;

import android.util.Log;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class t implements Client.ResultHandler {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4184i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a8.q f4185j;

    public /* synthetic */ t(a8.q qVar, k0 k0Var, int i9) {
        this.f4184i = i9;
        this.f4185j = qVar;
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public final void onResult(TdApi.Object object) {
        switch (this.f4184i) {
            case 0:
                int constructor = object.getConstructor();
                a8.q qVar = this.f4185j;
                if (constructor != -1145310535) {
                    Log.e("TdClient", "Error checking invite link: " + object);
                    qVar.c(null, null, null);
                    break;
                } else {
                    TdApi.ChatInviteLinkInfo chatInviteLinkInfo = (TdApi.ChatInviteLinkInfo) object;
                    String str = chatInviteLinkInfo.title;
                    Long valueOf = Long.valueOf(chatInviteLinkInfo.chatId);
                    TdApi.InviteLinkChatType inviteLinkChatType = chatInviteLinkInfo.type;
                    qVar.c(str, valueOf, inviteLinkChatType != null ? inviteLinkChatType instanceof TdApi.InviteLinkChatTypeChannel ? "Canal" : inviteLinkChatType instanceof TdApi.InviteLinkChatTypeSupergroup ? "Grupo (S)" : inviteLinkChatType instanceof TdApi.InviteLinkChatTypeBasicGroup ? "Grupo" : "Telegram" : null);
                    break;
                }
            default:
                boolean z8 = object instanceof TdApi.Chat;
                a8.q qVar2 = this.f4185j;
                if (!z8) {
                    qVar2.c(null, null, null);
                    break;
                } else {
                    TdApi.Chat chat = (TdApi.Chat) object;
                    qVar2.c(chat.title, Long.valueOf(chat.id), k0.i(chat.type));
                    break;
                }
        }
    }
}
