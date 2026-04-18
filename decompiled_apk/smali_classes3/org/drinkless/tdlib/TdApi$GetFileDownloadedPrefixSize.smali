.class public Lorg/drinkless/tdlib/TdApi$GetFileDownloadedPrefixSize;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetFileDownloadedPrefixSize"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FileDownloadedPrefixSize;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3304bd2d


# instance fields
.field public fileId:I

.field public offset:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26085
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J

    .line 26074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26075
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetFileDownloadedPrefixSize;->fileId:I

    .line 26076
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$GetFileDownloadedPrefixSize;->offset:J

    .line 26077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26081
    const v0, 0x3304bd2d

    return v0
.end method
