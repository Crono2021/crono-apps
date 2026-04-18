.class public Lorg/drinkless/tdlib/TdApi$ToggleDirectMessagesChatTopicCanSendUnpaidMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleDirectMessagesChatTopicCanSendUnpaidMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1405684f


# instance fields
.field public canSendUnpaidMessages:Z

.field public chatId:J

.field public refundPayments:Z

.field public topicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45870
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45871
    return-void
.end method

.method public constructor <init>(JJZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z

    .line 45858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45859
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleDirectMessagesChatTopicCanSendUnpaidMessages;->chatId:J

    .line 45860
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleDirectMessagesChatTopicCanSendUnpaidMessages;->topicId:J

    .line 45861
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ToggleDirectMessagesChatTopicCanSendUnpaidMessages;->canSendUnpaidMessages:Z

    .line 45862
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ToggleDirectMessagesChatTopicCanSendUnpaidMessages;->refundPayments:Z

    .line 45863
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45867
    const v0, -0x1405684f

    return v0
.end method
