.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftTransfer;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeGiftTransfer"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x9614f7


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32549
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$UpgradedGift;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 32538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32539
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftTransfer;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 32540
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftTransfer;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 32541
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32545
    const v0, 0x9614f7

    return v0
.end method
