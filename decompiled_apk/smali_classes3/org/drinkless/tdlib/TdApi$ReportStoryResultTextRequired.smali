.class public Lorg/drinkless/tdlib/TdApi$ReportStoryResultTextRequired;
.super Lorg/drinkless/tdlib/TdApi$ReportStoryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportStoryResultTextRequired"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x13ed9d91


# instance fields
.field public isOptional:Z

.field public optionId:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30288
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportStoryResult;-><init>()V

    .line 30289
    return-void
.end method

.method public constructor <init>([BZ)V
    .locals 0
    .param p1, "bArr"    # [B
    .param p2, "z8"    # Z

    .line 30278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportStoryResult;-><init>()V

    .line 30279
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReportStoryResultTextRequired;->optionId:[B

    .line 30280
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ReportStoryResultTextRequired;->isOptional:Z

    .line 30281
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30285
    const v0, 0x13ed9d91

    return v0
.end method
