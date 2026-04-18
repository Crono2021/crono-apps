.class public Lorg/drinkless/tdlib/TdApi$UpdateFileRemovedFromDownloads;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateFileRemovedFromDownloads"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6e7c14e8


# instance fields
.field public counts:Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34508
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34509
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$DownloadedFileCounts;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "downloadedFileCounts"    # Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

    .line 34498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34499
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileRemovedFromDownloads;->fileId:I

    .line 34500
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileRemovedFromDownloads;->counts:Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

    .line 34501
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34505
    const v0, 0x6e7c14e8

    return v0
.end method
