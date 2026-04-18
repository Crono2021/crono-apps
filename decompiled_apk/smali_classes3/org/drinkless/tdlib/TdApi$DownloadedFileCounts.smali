.class public Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DownloadedFileCounts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x75a8d7be


# instance fields
.field public activeCount:I

.field public completedCount:I

.field public pausedCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36696
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36697
    return-void
.end method

.method public constructor <init>(III)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I

    .line 36685
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36686
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;->activeCount:I

    .line 36687
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;->pausedCount:I

    .line 36688
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;->completedCount:I

    .line 36689
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36693
    const v0, -0x75a8d7be

    return v0
.end method
