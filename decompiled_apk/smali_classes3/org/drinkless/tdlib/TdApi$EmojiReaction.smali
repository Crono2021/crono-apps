.class public Lorg/drinkless/tdlib/TdApi$EmojiReaction;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x60532c5f


# instance fields
.field public activateAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public appearAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public aroundAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public centerAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public effectAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public emoji:Ljava/lang/String;

.field public isActive:Z

.field public selectAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public staticIcon:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53276
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53277
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p5, "sticker2"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p6, "sticker3"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p7, "sticker4"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p8, "sticker5"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p9, "sticker6"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p10, "sticker7"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53259
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->emoji:Ljava/lang/String;

    .line 53260
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->title:Ljava/lang/String;

    .line 53261
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->isActive:Z

    .line 53262
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->staticIcon:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53263
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->appearAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53264
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->selectAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53265
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->activateAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53266
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->effectAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53267
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->aroundAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53268
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$EmojiReaction;->centerAnimation:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 53269
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53273
    const v0, 0x60532c5f

    return v0
.end method
