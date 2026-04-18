.class public Lorg/drinkless/tdlib/TdApi$GetGiftUpgradePreview;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetGiftUpgradePreview"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GiftUpgradePreview;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42343da3


# instance fields
.field public giftId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12895
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12885
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12886
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetGiftUpgradePreview;->giftId:J

    .line 12887
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12891
    const v0, -0x42343da3

    return v0
.end method
