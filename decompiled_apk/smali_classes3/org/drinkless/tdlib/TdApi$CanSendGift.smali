.class public Lorg/drinkless/tdlib/TdApi$CanSendGift;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanSendGift"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CanSendGiftResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4de82676


# instance fields
.field public giftId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9456
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 9457
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 9447
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 9448
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CanSendGift;->giftId:J

    .line 9449
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9453
    const v0, 0x4de82676

    return v0
.end method
