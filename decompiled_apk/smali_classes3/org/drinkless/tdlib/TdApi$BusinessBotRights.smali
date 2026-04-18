.class public Lorg/drinkless/tdlib/TdApi$BusinessBotRights;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessBotRights"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x49018f7e


# instance fields
.field public canChangeGiftSettings:Z

.field public canDeleteAllMessages:Z

.field public canDeleteSentMessages:Z

.field public canEditBio:Z

.field public canEditName:Z

.field public canEditProfilePhoto:Z

.field public canEditUsername:Z

.field public canManageStories:Z

.field public canReadMessages:Z

.field public canReply:Z

.field public canSellGifts:Z

.field public canTransferAndUpgradeGifts:Z

.field public canTransferStars:Z

.field public canViewGiftsAndStars:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54206
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54207
    return-void
.end method

.method public constructor <init>(ZZZZZZZZZZZZZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z
    .param p4, "z11"    # Z
    .param p5, "z12"    # Z
    .param p6, "z13"    # Z
    .param p7, "z14"    # Z
    .param p8, "z15"    # Z
    .param p9, "z16"    # Z
    .param p10, "z17"    # Z
    .param p11, "z18"    # Z
    .param p12, "z19"    # Z
    .param p13, "z20"    # Z
    .param p14, "z21"    # Z

    .line 54184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54185
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canReply:Z

    .line 54186
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canReadMessages:Z

    .line 54187
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canDeleteSentMessages:Z

    .line 54188
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canDeleteAllMessages:Z

    .line 54189
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canEditName:Z

    .line 54190
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canEditBio:Z

    .line 54191
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canEditProfilePhoto:Z

    .line 54192
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canEditUsername:Z

    .line 54193
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canViewGiftsAndStars:Z

    .line 54194
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canSellGifts:Z

    .line 54195
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canChangeGiftSettings:Z

    .line 54196
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canTransferAndUpgradeGifts:Z

    .line 54197
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canTransferStars:Z

    .line 54198
    iput-boolean p14, p0, Lorg/drinkless/tdlib/TdApi$BusinessBotRights;->canManageStories:Z

    .line 54199
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54203
    const v0, 0x49018f7e    # 530679.9f

    return v0
.end method
