.class public Lorg/drinkless/tdlib/TdApi$CanPostStoryResultMonthlyLimitExceeded;
.super Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanPostStoryResultMonthlyLimitExceeded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2ebe12b2


# instance fields
.field public retryAfter:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9384
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;-><init>()V

    .line 9385
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9375
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;-><init>()V

    .line 9376
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CanPostStoryResultMonthlyLimitExceeded;->retryAfter:I

    .line 9377
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9381
    const v0, -0x2ebe12b2

    return v0
.end method
