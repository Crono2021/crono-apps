.class public Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResultPasswordTooFresh;
.super Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanTransferOwnershipResultPasswordTooFresh"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x305d9b11


# instance fields
.field public retryAfter:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9510
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResult;-><init>()V

    .line 9511
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9501
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResult;-><init>()V

    .line 9502
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CanTransferOwnershipResultPasswordTooFresh;->retryAfter:I

    .line 9503
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9507
    const v0, 0x305d9b11

    return v0
.end method
