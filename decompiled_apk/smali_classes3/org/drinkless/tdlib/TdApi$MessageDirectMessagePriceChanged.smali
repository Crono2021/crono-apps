.class public Lorg/drinkless/tdlib/TdApi$MessageDirectMessagePriceChanged;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageDirectMessagePriceChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4eba4db7


# instance fields
.field public isEnabled:Z

.field public paidMessageStarCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28384
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28385
    return-void
.end method

.method public constructor <init>(ZJ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "j5"    # J

    .line 28374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28375
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$MessageDirectMessagePriceChanged;->isEnabled:Z

    .line 28376
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$MessageDirectMessagePriceChanged;->paidMessageStarCount:J

    .line 28377
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28381
    const v0, 0x4eba4db7

    return v0
.end method
