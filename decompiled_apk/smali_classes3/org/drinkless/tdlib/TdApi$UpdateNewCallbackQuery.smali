.class public Lorg/drinkless/tdlib/TdApi$UpdateNewCallbackQuery;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewCallbackQuery"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x769b2fa2


# instance fields
.field public chatId:J

.field public chatInstance:J

.field public id:J

.field public messageId:J

.field public payload:Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

.field public senderUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50962
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50963
    return-void
.end method

.method public constructor <init>(JJJJJLorg/drinkless/tdlib/TdApi$CallbackQueryPayload;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "j11"    # J
    .param p9, "j12"    # J
    .param p11, "callbackQueryPayload"    # Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 50948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50949
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCallbackQuery;->id:J

    .line 50950
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCallbackQuery;->senderUserId:J

    .line 50951
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCallbackQuery;->chatId:J

    .line 50952
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCallbackQuery;->messageId:J

    .line 50953
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCallbackQuery;->chatInstance:J

    .line 50954
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCallbackQuery;->payload:Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 50955
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50959
    const v0, -0x769b2fa2

    return v0
.end method
