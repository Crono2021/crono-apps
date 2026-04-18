.class public Lorg/drinkless/tdlib/TdApi$MessageSendingStateFailed;
.super Lorg/drinkless/tdlib/TdApi$MessageSendingState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSendingStateFailed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2e59b33a


# instance fields
.field public canRetry:Z

.field public error:Lorg/drinkless/tdlib/TdApi$Error;

.field public needAnotherReplyQuote:Z

.field public needAnotherSender:Z

.field public needDropReply:Z

.field public requiredPaidMessageStarCount:J

.field public retryAfter:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSendingState;-><init>()V

    .line 51585
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Error;ZZZZJD)V
    .locals 0
    .param p1, "error"    # Lorg/drinkless/tdlib/TdApi$Error;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "z11"    # Z
    .param p6, "j5"    # J
    .param p8, "d9"    # D

    .line 51569
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSendingState;-><init>()V

    .line 51570
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSendingStateFailed;->error:Lorg/drinkless/tdlib/TdApi$Error;

    .line 51571
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageSendingStateFailed;->canRetry:Z

    .line 51572
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessageSendingStateFailed;->needAnotherSender:Z

    .line 51573
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessageSendingStateFailed;->needAnotherReplyQuote:Z

    .line 51574
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$MessageSendingStateFailed;->needDropReply:Z

    .line 51575
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$MessageSendingStateFailed;->requiredPaidMessageStarCount:J

    .line 51576
    iput-wide p8, p0, Lorg/drinkless/tdlib/TdApi$MessageSendingStateFailed;->retryAfter:D

    .line 51577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51581
    const v0, -0x2e59b33a

    return v0
.end method
