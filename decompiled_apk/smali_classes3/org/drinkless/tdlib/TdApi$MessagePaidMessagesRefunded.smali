.class public Lorg/drinkless/tdlib/TdApi$MessagePaidMessagesRefunded;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePaidMessagesRefunded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2298408f


# instance fields
.field public messageCount:I

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28525
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J

    .line 28514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28515
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePaidMessagesRefunded;->messageCount:I

    .line 28516
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$MessagePaidMessagesRefunded;->starCount:J

    .line 28517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28521
    const v0, 0x2298408f

    return v0
.end method
