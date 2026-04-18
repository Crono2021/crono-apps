.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftOriginalDetailsDrop;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeGiftOriginalDetailsDrop"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x63f3a37d


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32488
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32489
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$UpgradedGift;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 32478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32479
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftOriginalDetailsDrop;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 32480
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftOriginalDetailsDrop;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 32481
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32485
    const v0, 0x63f3a37d

    return v0
.end method
