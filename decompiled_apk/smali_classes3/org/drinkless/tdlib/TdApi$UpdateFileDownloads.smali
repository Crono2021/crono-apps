.class public Lorg/drinkless/tdlib/TdApi$UpdateFileDownloads;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateFileDownloads"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1732ed39


# instance fields
.field public downloadedSize:J

.field public totalCount:I

.field public totalSize:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41605
    return-void
.end method

.method public constructor <init>(JIJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "j9"    # J

    .line 41593
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41594
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileDownloads;->totalSize:J

    .line 41595
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileDownloads;->totalCount:I

    .line 41596
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileDownloads;->downloadedSize:J

    .line 41597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41601
    const v0, -0x1732ed39

    return v0
.end method
