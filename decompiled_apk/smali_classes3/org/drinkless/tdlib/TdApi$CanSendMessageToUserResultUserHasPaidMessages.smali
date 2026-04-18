.class public Lorg/drinkless/tdlib/TdApi$CanSendMessageToUserResultUserHasPaidMessages;
.super Lorg/drinkless/tdlib/TdApi$CanSendMessageToUserResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanSendMessageToUserResultUserHasPaidMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5041c532


# instance fields
.field public outgoingPaidMessageStarCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9492
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanSendMessageToUserResult;-><init>()V

    .line 9493
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 9483
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanSendMessageToUserResult;-><init>()V

    .line 9484
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CanSendMessageToUserResultUserHasPaidMessages;->outgoingPaidMessageStarCount:J

    .line 9485
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9489
    const v0, -0x5041c532

    return v0
.end method
