.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentGift;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x66a17cdf


# instance fields
.field public isPrepaidUpgrade:Z

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29549
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 29538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29539
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGift;->starCount:J

    .line 29540
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGift;->isPrepaidUpgrade:Z

    .line 29541
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29545
    const v0, 0x66a17cdf

    return v0
.end method
