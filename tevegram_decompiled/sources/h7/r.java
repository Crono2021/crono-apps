package h7;

import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class r implements a8.p {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4176i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f4177j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f4178k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ a8.r f4179l;

    public /* synthetic */ r(k0 k0Var, long j5, a8.r rVar, int i9) {
        this.f4176i = i9;
        this.f4177j = k0Var;
        this.f4178k = j5;
        this.f4179l = rVar;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        switch (this.f4176i) {
            case 0:
                final TdApi.File file = (TdApi.File) obj;
                final String str = (String) obj2;
                final int i9 = 0;
                final a8.r rVar = this.f4179l;
                final long j5 = this.f4178k;
                final k0 k0Var = this.f4177j;
                k0Var.h(j5, new a8.l() { // from class: h7.z
                    @Override // a8.l
                    public final Object a(Object obj3) {
                        TdApi.Chat chat = (TdApi.Chat) obj3;
                        switch (i9) {
                            case 0:
                                Long valueOf = Long.valueOf(j5);
                                TdApi.ChatType chatType = chat != null ? chat.type : null;
                                k0Var.getClass();
                                rVar.i(file, str, valueOf, k0.i(chatType));
                                break;
                            case 1:
                                Long valueOf2 = Long.valueOf(j5);
                                TdApi.ChatType chatType2 = chat != null ? chat.type : null;
                                k0Var.getClass();
                                rVar.i(file, str, valueOf2, k0.i(chatType2));
                                break;
                            case 2:
                                Long valueOf3 = Long.valueOf(j5);
                                TdApi.ChatType chatType3 = chat != null ? chat.type : null;
                                k0Var.getClass();
                                rVar.i(file, str, valueOf3, k0.i(chatType3));
                                break;
                            default:
                                Long valueOf4 = Long.valueOf(j5);
                                TdApi.ChatType chatType4 = chat != null ? chat.type : null;
                                k0Var.getClass();
                                rVar.i(file, str, valueOf4, k0.i(chatType4));
                                break;
                        }
                        return n7.g.f7490c;
                    }
                });
                break;
            case 1:
                final TdApi.File file2 = (TdApi.File) obj;
                final String str2 = (String) obj2;
                final int i10 = 1;
                final a8.r rVar2 = this.f4179l;
                final long j9 = this.f4178k;
                final k0 k0Var2 = this.f4177j;
                k0Var2.h(j9, new a8.l() { // from class: h7.z
                    @Override // a8.l
                    public final Object a(Object obj3) {
                        TdApi.Chat chat = (TdApi.Chat) obj3;
                        switch (i10) {
                            case 0:
                                Long valueOf = Long.valueOf(j9);
                                TdApi.ChatType chatType = chat != null ? chat.type : null;
                                k0Var2.getClass();
                                rVar2.i(file2, str2, valueOf, k0.i(chatType));
                                break;
                            case 1:
                                Long valueOf2 = Long.valueOf(j9);
                                TdApi.ChatType chatType2 = chat != null ? chat.type : null;
                                k0Var2.getClass();
                                rVar2.i(file2, str2, valueOf2, k0.i(chatType2));
                                break;
                            case 2:
                                Long valueOf3 = Long.valueOf(j9);
                                TdApi.ChatType chatType3 = chat != null ? chat.type : null;
                                k0Var2.getClass();
                                rVar2.i(file2, str2, valueOf3, k0.i(chatType3));
                                break;
                            default:
                                Long valueOf4 = Long.valueOf(j9);
                                TdApi.ChatType chatType4 = chat != null ? chat.type : null;
                                k0Var2.getClass();
                                rVar2.i(file2, str2, valueOf4, k0.i(chatType4));
                                break;
                        }
                        return n7.g.f7490c;
                    }
                });
                break;
            case 2:
                final TdApi.File file3 = (TdApi.File) obj;
                final String str3 = (String) obj2;
                final int i11 = 3;
                final a8.r rVar3 = this.f4179l;
                final long j10 = this.f4178k;
                final k0 k0Var3 = this.f4177j;
                k0Var3.h(j10, new a8.l() { // from class: h7.z
                    @Override // a8.l
                    public final Object a(Object obj3) {
                        TdApi.Chat chat = (TdApi.Chat) obj3;
                        switch (i11) {
                            case 0:
                                Long valueOf = Long.valueOf(j10);
                                TdApi.ChatType chatType = chat != null ? chat.type : null;
                                k0Var3.getClass();
                                rVar3.i(file3, str3, valueOf, k0.i(chatType));
                                break;
                            case 1:
                                Long valueOf2 = Long.valueOf(j10);
                                TdApi.ChatType chatType2 = chat != null ? chat.type : null;
                                k0Var3.getClass();
                                rVar3.i(file3, str3, valueOf2, k0.i(chatType2));
                                break;
                            case 2:
                                Long valueOf3 = Long.valueOf(j10);
                                TdApi.ChatType chatType3 = chat != null ? chat.type : null;
                                k0Var3.getClass();
                                rVar3.i(file3, str3, valueOf3, k0.i(chatType3));
                                break;
                            default:
                                Long valueOf4 = Long.valueOf(j10);
                                TdApi.ChatType chatType4 = chat != null ? chat.type : null;
                                k0Var3.getClass();
                                rVar3.i(file3, str3, valueOf4, k0.i(chatType4));
                                break;
                        }
                        return n7.g.f7490c;
                    }
                });
                break;
            default:
                final TdApi.File file4 = (TdApi.File) obj;
                final String str4 = (String) obj2;
                final int i12 = 2;
                final a8.r rVar4 = this.f4179l;
                final long j11 = this.f4178k;
                final k0 k0Var4 = this.f4177j;
                k0Var4.h(j11, new a8.l() { // from class: h7.z
                    @Override // a8.l
                    public final Object a(Object obj3) {
                        TdApi.Chat chat = (TdApi.Chat) obj3;
                        switch (i12) {
                            case 0:
                                Long valueOf = Long.valueOf(j11);
                                TdApi.ChatType chatType = chat != null ? chat.type : null;
                                k0Var4.getClass();
                                rVar4.i(file4, str4, valueOf, k0.i(chatType));
                                break;
                            case 1:
                                Long valueOf2 = Long.valueOf(j11);
                                TdApi.ChatType chatType2 = chat != null ? chat.type : null;
                                k0Var4.getClass();
                                rVar4.i(file4, str4, valueOf2, k0.i(chatType2));
                                break;
                            case 2:
                                Long valueOf3 = Long.valueOf(j11);
                                TdApi.ChatType chatType3 = chat != null ? chat.type : null;
                                k0Var4.getClass();
                                rVar4.i(file4, str4, valueOf3, k0.i(chatType3));
                                break;
                            default:
                                Long valueOf4 = Long.valueOf(j11);
                                TdApi.ChatType chatType4 = chat != null ? chat.type : null;
                                k0Var4.getClass();
                                rVar4.i(file4, str4, valueOf4, k0.i(chatType4));
                                break;
                        }
                        return n7.g.f7490c;
                    }
                });
                break;
        }
        return n7.g.f7490c;
    }
}
