.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftModelCount;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftModelCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x43304987


# instance fields
.field public model:Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35188
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35189
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;I)V
    .locals 0
    .param p1, "upgradedGiftModel"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;
    .param p2, "i9"    # I

    .line 35178
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35179
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftModelCount;->model:Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;

    .line 35180
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftModelCount;->totalCount:I

    .line 35181
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35185
    const v0, -0x43304987

    return v0
.end method
