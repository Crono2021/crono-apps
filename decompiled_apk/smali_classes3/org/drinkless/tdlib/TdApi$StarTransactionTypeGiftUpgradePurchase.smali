.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftUpgradePurchase;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeGiftUpgradePurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x33dab0fe


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$Gift;

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32588
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32589
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$Gift;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "gift"    # Lorg/drinkless/tdlib/TdApi$Gift;

    .line 32578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32579
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftUpgradePurchase;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 32580
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftUpgradePurchase;->gift:Lorg/drinkless/tdlib/TdApi$Gift;

    .line 32581
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32585
    const v0, -0x33dab0fe    # -4.3334664E7f

    return v0
.end method
