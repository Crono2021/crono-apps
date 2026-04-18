.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftSale;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeGiftSale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x64d61157


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$Gift;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32529
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$Gift;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "gift"    # Lorg/drinkless/tdlib/TdApi$Gift;

    .line 32518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32519
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftSale;->userId:J

    .line 32520
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeGiftSale;->gift:Lorg/drinkless/tdlib/TdApi$Gift;

    .line 32521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32525
    const v0, 0x64d61157

    return v0
.end method
