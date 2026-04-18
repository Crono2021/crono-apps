.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginUpgrade;
.super Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftOriginUpgrade"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1f9735a3


# instance fields
.field public giftMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22376
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;-><init>()V

    .line 22377
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 22367
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOrigin;-><init>()V

    .line 22368
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginUpgrade;->giftMessageId:J

    .line 22369
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22373
    const v0, 0x1f9735a3

    return v0
.end method
