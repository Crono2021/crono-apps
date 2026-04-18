.class public Lorg/drinkless/tdlib/TdApi$StopBusinessPoll;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StopBusinessPoll"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4414dea0


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45534
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45535
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 45522
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45523
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StopBusinessPoll;->businessConnectionId:Ljava/lang/String;

    .line 45524
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$StopBusinessPoll;->chatId:J

    .line 45525
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$StopBusinessPoll;->messageId:J

    .line 45526
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$StopBusinessPoll;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 45527
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45531
    const v0, -0x4414dea0

    return v0
.end method
