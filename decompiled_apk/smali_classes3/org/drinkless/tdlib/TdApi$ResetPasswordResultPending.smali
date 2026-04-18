.class public Lorg/drinkless/tdlib/TdApi$ResetPasswordResultPending;
.super Lorg/drinkless/tdlib/TdApi$ResetPasswordResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ResetPasswordResultPending"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4729dc59


# instance fields
.field public pendingResetDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18888
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ResetPasswordResult;-><init>()V

    .line 18889
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 18879
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ResetPasswordResult;-><init>()V

    .line 18880
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ResetPasswordResultPending;->pendingResetDate:I

    .line 18881
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18885
    const v0, 0x4729dc59

    return v0
.end method
