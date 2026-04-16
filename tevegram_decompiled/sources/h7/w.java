package h7;

import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class w implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4196i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a8.r f4197j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4198k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f4199l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k0 f4200m;

    public /* synthetic */ w(a8.r rVar, Object obj, long j5, k0 k0Var, int i9) {
        this.f4196i = i9;
        this.f4197j = rVar;
        this.f4198k = obj;
        this.f4199l = j5;
        this.f4200m = k0Var;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        switch (this.f4196i) {
            case 0:
                TdApi.File file = (TdApi.File) this.f4198k;
                TdApi.Chat chat = (TdApi.Chat) obj;
                Long valueOf = Long.valueOf(this.f4199l);
                TdApi.ChatType chatType = chat != null ? chat.type : null;
                this.f4200m.getClass();
                this.f4197j.i(file, null, valueOf, k0.i(chatType));
                break;
            case 1:
                TdApi.File file2 = (TdApi.File) this.f4198k;
                TdApi.Chat chat2 = (TdApi.Chat) obj;
                Long valueOf2 = Long.valueOf(this.f4199l);
                TdApi.ChatType chatType2 = chat2 != null ? chat2.type : null;
                this.f4200m.getClass();
                this.f4197j.i(file2, null, valueOf2, k0.i(chatType2));
                break;
            case 2:
                TdApi.File file3 = (TdApi.File) this.f4198k;
                TdApi.Chat chat3 = (TdApi.Chat) obj;
                Long valueOf3 = Long.valueOf(this.f4199l);
                TdApi.ChatType chatType3 = chat3 != null ? chat3.type : null;
                this.f4200m.getClass();
                this.f4197j.i(file3, null, valueOf3, k0.i(chatType3));
                break;
            default:
                TdApi.Chat chat4 = (TdApi.Chat) obj;
                String concat = "EXTRACTED_LINK:::".concat((String) this.f4198k);
                Long valueOf4 = Long.valueOf(this.f4199l);
                TdApi.ChatType chatType4 = chat4 != null ? chat4.type : null;
                this.f4200m.getClass();
                this.f4197j.i(null, concat, valueOf4, k0.i(chatType4));
                break;
        }
        return n7.g.f7490c;
    }
}
