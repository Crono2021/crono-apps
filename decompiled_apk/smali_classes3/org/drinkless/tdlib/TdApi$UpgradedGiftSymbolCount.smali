.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbolCount;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftSymbolCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2e1be462


# instance fields
.field public symbol:Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35208
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35209
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;I)V
    .locals 0
    .param p1, "upgradedGiftSymbol"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;
    .param p2, "i9"    # I

    .line 35198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35199
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbolCount;->symbol:Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;

    .line 35200
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbolCount;->totalCount:I

    .line 35201
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35205
    const v0, -0x2e1be462

    return v0
.end method
