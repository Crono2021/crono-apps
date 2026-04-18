.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeTelegramApiUsage;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeTelegramApiUsage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x27a82afe


# instance fields
.field public requestCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20202
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20203
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 20193
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20194
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeTelegramApiUsage;->requestCount:I

    .line 20195
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20199
    const v0, 0x27a82afe

    return v0
.end method
