.class public Lorg/drinkless/tdlib/TdApi$RemoveAllFilesFromDownloads;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveAllFilesFromDownloads"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x46b7897a


# instance fields
.field public deleteFromCache:Z

.field public onlyActive:Z

.field public onlyCompleted:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39449
    return-void
.end method

.method public constructor <init>(ZZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z

    .line 39437
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39438
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveAllFilesFromDownloads;->onlyActive:Z

    .line 39439
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$RemoveAllFilesFromDownloads;->onlyCompleted:Z

    .line 39440
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$RemoveAllFilesFromDownloads;->deleteFromCache:Z

    .line 39441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39445
    const v0, -0x46b7897a

    return v0
.end method
