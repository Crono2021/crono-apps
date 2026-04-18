.class public Lorg/drinkless/tdlib/TdApi$MessageEffectTypeEmojiReaction;
.super Lorg/drinkless/tdlib/TdApi$MessageEffectType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageEffectTypeEmojiReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x68aba63e


# instance fields
.field public effectAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public selectAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28424
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageEffectType;-><init>()V

    .line 28425
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p2, "sticker2"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 28414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageEffectType;-><init>()V

    .line 28415
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageEffectTypeEmojiReaction;->selectAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 28416
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageEffectTypeEmojiReaction;->effectAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 28417
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28421
    const v0, 0x68aba63e

    return v0
.end method
