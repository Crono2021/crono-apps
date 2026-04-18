.class public Lorg/drinkless/tdlib/TdApi$CanPostStoryResultWeeklyLimitExceeded;
.super Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CanPostStoryResultWeeklyLimitExceeded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x20f3f3ed


# instance fields
.field public retryAfter:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9420
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;-><init>()V

    .line 9421
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9411
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;-><init>()V

    .line 9412
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CanPostStoryResultWeeklyLimitExceeded;->retryAfter:I

    .line 9413
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9417
    const v0, 0x20f3f3ed

    return v0
.end method
