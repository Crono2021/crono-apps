.class public Lorg/drinkless/tdlib/TdApi$GiftsForResale;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftsForResale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x21750b9


# instance fields
.field public backdrops:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropCount;

.field public gifts:[Lorg/drinkless/tdlib/TdApi$GiftForResale;

.field public models:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftModelCount;

.field public nextOffset:Ljava/lang/String;

.field public symbols:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbolCount;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49955
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$GiftForResale;[Lorg/drinkless/tdlib/TdApi$UpgradedGiftModelCount;[Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbolCount;[Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropCount;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "giftForResaleArr"    # [Lorg/drinkless/tdlib/TdApi$GiftForResale;
    .param p3, "upgradedGiftModelCountArr"    # [Lorg/drinkless/tdlib/TdApi$UpgradedGiftModelCount;
    .param p4, "upgradedGiftSymbolCountArr"    # [Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbolCount;
    .param p5, "upgradedGiftBackdropCountArr"    # [Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropCount;
    .param p6, "str"    # Ljava/lang/String;

    .line 49940
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49941
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GiftsForResale;->totalCount:I

    .line 49942
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GiftsForResale;->gifts:[Lorg/drinkless/tdlib/TdApi$GiftForResale;

    .line 49943
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GiftsForResale;->models:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftModelCount;

    .line 49944
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GiftsForResale;->symbols:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbolCount;

    .line 49945
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GiftsForResale;->backdrops:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropCount;

    .line 49946
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GiftsForResale;->nextOffset:Ljava/lang/String;

    .line 49947
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49951
    const v0, 0x21750b9

    return v0
.end method
