.class public Lorg/drinkless/tdlib/TdApi$GetCallbackQueryAnswer;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetCallbackQueryAnswer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CallbackQueryAnswer;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6ef7a5f


# instance fields
.field public chatId:J

.field public messageId:J

.field public payload:Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37180
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37181
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$CallbackQueryPayload;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "callbackQueryPayload"    # Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 37169
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37170
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetCallbackQueryAnswer;->chatId:J

    .line 37171
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetCallbackQueryAnswer;->messageId:J

    .line 37172
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GetCallbackQueryAnswer;->payload:Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 37173
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37177
    const v0, 0x6ef7a5f

    return v0
.end method
