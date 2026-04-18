.class public Lorg/drinkless/tdlib/TdApi$MessagePaidMessagePriceChanged;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePaidMessagePriceChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x148f72f5


# instance fields
.field public paidMessageStarCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16585
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16575
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16576
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePaidMessagePriceChanged;->paidMessageStarCount:J

    .line 16577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16581
    const v0, -0x148f72f5

    return v0
.end method
