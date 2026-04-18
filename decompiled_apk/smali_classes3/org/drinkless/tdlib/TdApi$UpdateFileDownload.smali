.class public Lorg/drinkless/tdlib/TdApi$UpdateFileDownload;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateFileDownload"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x342f83ca


# instance fields
.field public completeDate:I

.field public counts:Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

.field public fileId:I

.field public isPaused:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46039
    return-void
.end method

.method public constructor <init>(IIZLorg/drinkless/tdlib/TdApi$DownloadedFileCounts;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "z8"    # Z
    .param p4, "downloadedFileCounts"    # Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

    .line 46026
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46027
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileDownload;->fileId:I

    .line 46028
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileDownload;->completeDate:I

    .line 46029
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileDownload;->isPaused:Z

    .line 46030
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileDownload;->counts:Lorg/drinkless/tdlib/TdApi$DownloadedFileCounts;

    .line 46031
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46035
    const v0, 0x342f83ca

    return v0
.end method
