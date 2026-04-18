.class public Lorg/drinkless/tdlib/TdApi$DownloadFile;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DownloadFile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$File;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3f253234


# instance fields
.field public fileId:I

.field public limit:J

.field public offset:J

.field public priority:I

.field public synchronous:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46995
    return-void
.end method

.method public constructor <init>(IIJJZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "j5"    # J
    .param p5, "j9"    # J
    .param p7, "z8"    # Z

    .line 46981
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46982
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DownloadFile;->fileId:I

    .line 46983
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$DownloadFile;->priority:I

    .line 46984
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$DownloadFile;->offset:J

    .line 46985
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$DownloadFile;->limit:J

    .line 46986
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$DownloadFile;->synchronous:Z

    .line 46987
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46991
    const v0, 0x3f253234

    return v0
.end method
