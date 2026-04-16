package h7;

import i7.a2;
import java.io.IOException;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i implements Client.ResultHandler, g1.j {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4109i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4110j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4111k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4112l;

    public /* synthetic */ i(k0 k0Var, TdApi.UpdateChatVideoChat updateChatVideoChat, TdApi.GroupCall groupCall) {
        this.f4109i = 0;
        this.f4110j = k0Var;
        this.f4111k = updateChatVideoChat;
        this.f4112l = groupCall;
    }

    @Override // g1.j
    public void a(Object obj) {
        ((m1.c) obj).A((m1.a) this.f4110j, (v1.v) this.f4111k, (IOException) this.f4112l);
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public void onResult(TdApi.Object object) {
        switch (this.f4109i) {
            case 0:
                k0 k0Var = (k0) this.f4110j;
                TdApi.UpdateChatVideoChat updateChatVideoChat = (TdApi.UpdateChatVideoChat) this.f4111k;
                TdApi.GroupCall groupCall = (TdApi.GroupCall) this.f4112l;
                if (object instanceof TdApi.Chat) {
                    long j5 = updateChatVideoChat.chatId;
                    int i9 = groupCall.id;
                    boolean z8 = groupCall.isActive;
                    String str = groupCall.title;
                    str.getClass();
                    k0Var.B(j5, i9, z8, str, groupCall.participantCount, (TdApi.Chat) object);
                    break;
                }
                break;
            case 1:
                a8.q qVar = (a8.q) this.f4111k;
                k0 k0Var2 = (k0) this.f4110j;
                String str2 = (String) this.f4112l;
                if (!(object instanceof TdApi.Chat)) {
                    Long a02 = h8.l.a0(str2);
                    if (a02 == null) {
                        qVar.c(null, null, null);
                        break;
                    } else {
                        Client client = k0Var2.f4141l;
                        if (client != null) {
                            client.send(new TdApi.GetChat(a02.longValue()), new t(qVar, k0Var2, 1));
                            break;
                        }
                    }
                } else {
                    TdApi.Chat chat = (TdApi.Chat) object;
                    qVar.c(chat.title, Long.valueOf(chat.id), k0.i(chat.type));
                    break;
                }
                break;
            default:
                final a2 a2Var = (a2) this.f4111k;
                k0 k0Var3 = (k0) this.f4110j;
                String str3 = (String) this.f4112l;
                if (!(object instanceof TdApi.Chat)) {
                    if (!(object instanceof TdApi.Error) || !b8.i.a(((TdApi.Error) object).message, "USER_ALREADY_PARTICIPANT")) {
                        Client client2 = k0Var3.f4141l;
                        if (client2 != null) {
                            final int i10 = 1;
                            client2.send(new TdApi.CheckChatInviteLink(str3), new Client.ResultHandler() { // from class: h7.f0
                                @Override // org.drinkless.tdlib.Client.ResultHandler
                                public final void onResult(TdApi.Object object2) {
                                    switch (i10) {
                                        case 0:
                                            boolean z9 = object2 instanceof TdApi.ChatInviteLinkInfo;
                                            a2 a2Var2 = a2Var;
                                            if (z9) {
                                                long j9 = ((TdApi.ChatInviteLinkInfo) object2).chatId;
                                                if (j9 != 0) {
                                                    a2Var2.a(Long.valueOf(j9));
                                                    break;
                                                }
                                            }
                                            a2Var2.a(null);
                                            break;
                                        default:
                                            boolean z10 = object2 instanceof TdApi.ChatInviteLinkInfo;
                                            a2 a2Var3 = a2Var;
                                            if (z10) {
                                                long j10 = ((TdApi.ChatInviteLinkInfo) object2).chatId;
                                                if (j10 != 0) {
                                                    a2Var3.a(Long.valueOf(j10));
                                                    break;
                                                }
                                            }
                                            a2Var3.a(null);
                                            break;
                                    }
                                }
                            });
                            break;
                        }
                    } else {
                        Client client3 = k0Var3.f4141l;
                        if (client3 != null) {
                            final int i11 = 0;
                            client3.send(new TdApi.CheckChatInviteLink(str3), new Client.ResultHandler() { // from class: h7.f0
                                @Override // org.drinkless.tdlib.Client.ResultHandler
                                public final void onResult(TdApi.Object object2) {
                                    switch (i11) {
                                        case 0:
                                            boolean z9 = object2 instanceof TdApi.ChatInviteLinkInfo;
                                            a2 a2Var2 = a2Var;
                                            if (z9) {
                                                long j9 = ((TdApi.ChatInviteLinkInfo) object2).chatId;
                                                if (j9 != 0) {
                                                    a2Var2.a(Long.valueOf(j9));
                                                    break;
                                                }
                                            }
                                            a2Var2.a(null);
                                            break;
                                        default:
                                            boolean z10 = object2 instanceof TdApi.ChatInviteLinkInfo;
                                            a2 a2Var3 = a2Var;
                                            if (z10) {
                                                long j10 = ((TdApi.ChatInviteLinkInfo) object2).chatId;
                                                if (j10 != 0) {
                                                    a2Var3.a(Long.valueOf(j10));
                                                    break;
                                                }
                                            }
                                            a2Var3.a(null);
                                            break;
                                    }
                                }
                            });
                            break;
                        }
                    }
                } else {
                    a2Var.a(Long.valueOf(((TdApi.Chat) object).id));
                    break;
                }
                break;
        }
    }

    public /* synthetic */ i(m1.a aVar, v1.q qVar, v1.v vVar, IOException iOException, boolean z8) {
        this.f4109i = 3;
        this.f4110j = aVar;
        this.f4111k = vVar;
        this.f4112l = iOException;
    }

    public /* synthetic */ i(n7.a aVar, k0 k0Var, String str, int i9) {
        this.f4109i = i9;
        this.f4111k = aVar;
        this.f4110j = k0Var;
        this.f4112l = str;
    }
}
