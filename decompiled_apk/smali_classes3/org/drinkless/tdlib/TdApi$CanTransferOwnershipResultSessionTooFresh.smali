.class public Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResultSessionTooFresh;
.super Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanTransferOwnershipResultSessionTooFresh"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3ab0c8e1


# instance fields
.field public retryAfter:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResult;-><init>()V

    .line 9529
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9519
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResult;-><init>()V

    .line 9520
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResultSessionTooFresh;->retryAfter:I

    .line 9521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9525
    const v0, 0x3ab0c8e1

    return v0
.end method
