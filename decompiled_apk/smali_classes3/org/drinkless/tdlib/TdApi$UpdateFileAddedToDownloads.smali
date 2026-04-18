.class public Lorg/drinkless/tdlib/TdApi$UpdateFileAddedToDownloads;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateFileAddedToDownloads"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5ff5921a


# instance fields
.field public counts:Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

.field public fileDownload:Lorg/drinkless/tdlib/TdApi$FileDownload;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34488
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34489
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FileDownload;Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;)V
    .locals 0
    .param p1, "fileDownload"    # Lorg/drinkless/tdlib/TdApi$FileDownload;
    .param p2, "downloadedFileCounts"    # Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

    .line 34478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34479
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileAddedToDownloads;->fileDownload:Lorg/drinkless/tdlib/TdApi$FileDownload;

    .line 34480
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileAddedToDownloads;->counts:Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

    .line 34481
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34485
    const v0, 0x5ff5921a

    return v0
.end method
