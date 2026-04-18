.class public Lorg/drinkless/tdlib/TdApi$UpdateChatAccentColors;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatAccentColors"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x34183ee6


# instance fields
.field public accentColorId:I

.field public backgroundCustomEmojiId:J

.field public chatId:J

.field public profileAccentColorId:I

.field public profileBackgroundCustomEmojiId:J

.field public upgradedGiftColors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50879
    return-void
.end method

.method public constructor <init>(JIJLorg/drinkless/tdlib/TdApi$UpgradedGiftColors;IJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "j9"    # J
    .param p6, "upgradedGiftColors"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;
    .param p7, "i10"    # I
    .param p8, "j10"    # J

    .line 50864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50865
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAccentColors;->chatId:J

    .line 50866
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAccentColors;->accentColorId:I

    .line 50867
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAccentColors;->backgroundCustomEmojiId:J

    .line 50868
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAccentColors;->upgradedGiftColors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;

    .line 50869
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAccentColors;->profileAccentColorId:I

    .line 50870
    iput-wide p8, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAccentColors;->profileBackgroundCustomEmojiId:J

    .line 50871
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50875
    const v0, 0x34183ee6

    return v0
.end method
