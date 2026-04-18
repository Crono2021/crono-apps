.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftBackdrop"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x168c3c5a


# instance fields
.field public colors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;

.field public id:I

.field public name:Ljava/lang/String;

.field public rarityPerMille:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46302
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46303
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "upgradedGiftBackdropColors"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;
    .param p4, "i10"    # I

    .line 46290
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46291
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;->id:I

    .line 46292
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;->name:Ljava/lang/String;

    .line 46293
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;->colors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;

    .line 46294
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;->rarityPerMille:I

    .line 46295
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46299
    const v0, -0x168c3c5a

    return v0
.end method
