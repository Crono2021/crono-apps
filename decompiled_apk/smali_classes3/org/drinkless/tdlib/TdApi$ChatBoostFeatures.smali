.class public Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostFeatures"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x380f5ea7


# instance fields
.field public features:[Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;

.field public minAutomaticTranslationBoostLevel:I

.field public minBackgroundCustomEmojiBoostLevel:I

.field public minChatThemeBackgroundBoostLevel:I

.field public minCustomBackgroundBoostLevel:I

.field public minCustomEmojiStickerSetBoostLevel:I

.field public minEmojiStatusBoostLevel:I

.field public minProfileBackgroundCustomEmojiBoostLevel:I

.field public minSpeechRecognitionBoostLevel:I

.field public minSponsoredMessageDisableBoostLevel:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53205
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;IIIIIIIII)V
    .locals 0
    .param p1, "chatBoostLevelFeaturesArr"    # [Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "i11"    # I
    .param p5, "i12"    # I
    .param p6, "i13"    # I
    .param p7, "i14"    # I
    .param p8, "i15"    # I
    .param p9, "i16"    # I
    .param p10, "i17"    # I

    .line 53186
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53187
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->features:[Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;

    .line 53188
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minProfileBackgroundCustomEmojiBoostLevel:I

    .line 53189
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minBackgroundCustomEmojiBoostLevel:I

    .line 53190
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minEmojiStatusBoostLevel:I

    .line 53191
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minChatThemeBackgroundBoostLevel:I

    .line 53192
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minCustomBackgroundBoostLevel:I

    .line 53193
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minCustomEmojiStickerSetBoostLevel:I

    .line 53194
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minAutomaticTranslationBoostLevel:I

    .line 53195
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minSpeechRecognitionBoostLevel:I

    .line 53196
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;->minSponsoredMessageDisableBoostLevel:I

    .line 53197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53201
    const v0, -0x380f5ea7

    return v0
.end method
