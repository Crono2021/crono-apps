.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftPurchase;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeGiftPurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6c6c6f20


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$Gift;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32508
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32509
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$Gift;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "gift"    # Lorg/drinkless/tdlib/TdApi$Gift;

    .line 32498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32499
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftPurchase;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 32500
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftPurchase;->gift:Lorg/drinkless/tdlib/TdApi$Gift;

    .line 32501
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32505
    const v0, -0x6c6c6f20

    return v0
.end method
