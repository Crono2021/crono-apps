.class public Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeSuggestedPostEarnings;
.super Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatRevenueTransactionTypeSuggestedPostEarnings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4aa0c0cf


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10356
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;-><init>()V

    .line 10357
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 10347
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;-><init>()V

    .line 10348
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeSuggestedPostEarnings;->userId:J

    .line 10349
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10353
    const v0, 0x4aa0c0cf    # 5267559.5f

    return v0
.end method
