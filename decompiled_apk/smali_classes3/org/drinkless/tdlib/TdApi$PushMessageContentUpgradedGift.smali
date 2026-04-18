.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentUpgradedGift;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentUpgradedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4cb77802


# instance fields
.field public isPrepaidUpgrade:Z

.field public isUpgrade:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29668
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29669
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 29658
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29659
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentUpgradedGift;->isUpgrade:Z

    .line 29660
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentUpgradedGift;->isPrepaidUpgrade:Z

    .line 29661
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29665
    const v0, 0x4cb77802    # 9.619048E7f

    return v0
.end method
