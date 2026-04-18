.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftSymbol"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4340c5af


# instance fields
.field public name:Ljava/lang/String;

.field public rarityPerMille:I

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41979
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Sticker;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p3, "i9"    # I

    .line 41967
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41968
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;->name:Ljava/lang/String;

    .line 41969
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 41970
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;->rarityPerMille:I

    .line 41971
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41975
    const v0, 0x4340c5af

    return v0
.end method
