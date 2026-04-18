.class public Lorg/drinkless/tdlib/TdApi$LocalFile;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LocalFile"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5d256679


# instance fields
.field public canBeDeleted:Z

.field public canBeDownloaded:Z

.field public downloadOffset:J

.field public downloadedPrefixSize:J

.field public downloadedSize:J

.field public isDownloadingActive:Z

.field public isDownloadingCompleted:Z

.field public path:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52076
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52077
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZZZJJJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "z11"    # Z
    .param p6, "j5"    # J
    .param p8, "j9"    # J
    .param p10, "j10"    # J

    .line 52060
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52061
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LocalFile;->path:Ljava/lang/String;

    .line 52062
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$LocalFile;->canBeDownloaded:Z

    .line 52063
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$LocalFile;->canBeDeleted:Z

    .line 52064
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$LocalFile;->isDownloadingActive:Z

    .line 52065
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$LocalFile;->isDownloadingCompleted:Z

    .line 52066
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$LocalFile;->downloadOffset:J

    .line 52067
    iput-wide p8, p0, Lorg/drinkless/tdlib/TdApi$LocalFile;->downloadedPrefixSize:J

    .line 52068
    iput-wide p10, p0, Lorg/drinkless/tdlib/TdApi$LocalFile;->downloadedSize:J

    .line 52069
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52073
    const v0, -0x5d256679

    return v0
.end method
