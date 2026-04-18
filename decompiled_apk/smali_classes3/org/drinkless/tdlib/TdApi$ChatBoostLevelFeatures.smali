.class public Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostLevelFeatures"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a24066e


# instance fields
.field public accentColorCount:I

.field public canDisableSponsoredMessages:Z

.field public canEnableAutomaticTranslation:Z

.field public canRecognizeSpeech:Z

.field public canSetBackgroundCustomEmoji:Z

.field public canSetCustomBackground:Z

.field public canSetCustomEmojiStickerSet:Z

.field public canSetEmojiStatus:Z

.field public canSetProfileBackgroundCustomEmoji:Z

.field public chatThemeBackgroundCount:I

.field public customEmojiReactionCount:I

.field public level:I

.field public profileAccentColorCount:I

.field public storyPerDayCount:I

.field public titleColorCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54472
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54473
    return-void
.end method

.method public constructor <init>(IIIIIZIZZIZZZZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "i12"    # I
    .param p5, "i13"    # I
    .param p6, "z8"    # Z
    .param p7, "i14"    # I
    .param p8, "z9"    # Z
    .param p9, "z10"    # Z
    .param p10, "i15"    # I
    .param p11, "z11"    # Z
    .param p12, "z12"    # Z
    .param p13, "z13"    # Z
    .param p14, "z14"    # Z
    .param p15, "z15"    # Z

    .line 54449
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54450
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->level:I

    .line 54451
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->storyPerDayCount:I

    .line 54452
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->customEmojiReactionCount:I

    .line 54453
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->titleColorCount:I

    .line 54454
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->profileAccentColorCount:I

    .line 54455
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->canSetProfileBackgroundCustomEmoji:Z

    .line 54456
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->accentColorCount:I

    .line 54457
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->canSetBackgroundCustomEmoji:Z

    .line 54458
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->canSetEmojiStatus:Z

    .line 54459
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->chatThemeBackgroundCount:I

    .line 54460
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->canSetCustomBackground:Z

    .line 54461
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->canSetCustomEmojiStickerSet:Z

    .line 54462
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->canEnableAutomaticTranslation:Z

    .line 54463
    iput-boolean p14, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->canRecognizeSpeech:Z

    .line 54464
    iput-boolean p15, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;->canDisableSponsoredMessages:Z

    .line 54465
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54469
    const v0, 0x3a24066e

    return v0
.end method
