.class public Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TrendingStickerSets"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2720d4c


# instance fields
.field public isPremium:Z

.field public sets:[Lorg/drinkless/tdlib/TdApi$StickerSetInfo;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41384
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41385
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$StickerSetInfo;Z)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "stickerSetInfoArr"    # [Lorg/drinkless/tdlib/TdApi$StickerSetInfo;
    .param p3, "z8"    # Z

    .line 41373
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41374
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;->totalCount:I

    .line 41375
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;->sets:[Lorg/drinkless/tdlib/TdApi$StickerSetInfo;

    .line 41376
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$TrendingStickerSets;->isPremium:Z

    .line 41377
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41381
    const v0, 0x2720d4c

    return v0
.end method
