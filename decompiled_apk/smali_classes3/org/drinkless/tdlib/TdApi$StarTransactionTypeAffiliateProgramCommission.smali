.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeAffiliateProgramCommission;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeAffiliateProgramCommission"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x659c8a8d


# instance fields
.field public chatId:J

.field public commissionPerMille:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32348
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32349
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 32338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32339
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeAffiliateProgramCommission;->chatId:J

    .line 32340
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeAffiliateProgramCommission;->commissionPerMille:I

    .line 32341
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32345
    const v0, -0x659c8a8d

    return v0
.end method
