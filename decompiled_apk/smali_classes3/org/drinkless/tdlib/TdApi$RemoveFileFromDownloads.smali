.class public Lorg/drinkless/tdlib/TdApi$RemoveFileFromDownloads;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveFileFromDownloads"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5706bfee


# instance fields
.field public deleteFromCache:Z

.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29888
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29889
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 29878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29879
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveFileFromDownloads;->fileId:I

    .line 29880
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$RemoveFileFromDownloads;->deleteFromCache:Z

    .line 29881
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29885
    const v0, 0x5706bfee

    return v0
.end method
