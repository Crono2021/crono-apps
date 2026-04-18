.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftUpgrade;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeGiftUpgrade"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x25b17ce7


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32568
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32569
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$UpgradedGift;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 32558
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32559
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftUpgrade;->userId:J

    .line 32560
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftUpgrade;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 32561
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32565
    const v0, -0x25b17ce7

    return v0
.end method
