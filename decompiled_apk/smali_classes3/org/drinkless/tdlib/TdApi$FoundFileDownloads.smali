.class public Lorg/drinkless/tdlib/TdApi$FoundFileDownloads;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundFileDownloads"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x533398d8


# instance fields
.field public files:[Lorg/drinkless/tdlib/TdApi$FileDownload;

.field public nextOffset:Ljava/lang/String;

.field public totalCounts:Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37026
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37027
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;[Lorg/drinkless/tdlib/TdApi$FileDownload;Ljava/lang/String;)V
    .locals 0
    .param p1, "downloadedFileCounts"    # Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;
    .param p2, "fileDownloadArr"    # [Lorg/drinkless/tdlib/TdApi$FileDownload;
    .param p3, "str"    # Ljava/lang/String;

    .line 37015
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37016
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FoundFileDownloads;->totalCounts:Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

    .line 37017
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundFileDownloads;->files:[Lorg/drinkless/tdlib/TdApi$FileDownload;

    .line 37018
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$FoundFileDownloads;->nextOffset:Ljava/lang/String;

    .line 37019
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37023
    const v0, 0x533398d8

    return v0
.end method
