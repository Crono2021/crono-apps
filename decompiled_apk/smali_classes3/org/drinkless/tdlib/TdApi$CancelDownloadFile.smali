.class public Lorg/drinkless/tdlib/TdApi$CancelDownloadFile;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CancelDownloadFile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x747fad22


# instance fields
.field public fileId:I

.field public onlyIfPending:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 23525
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 23514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 23515
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CancelDownloadFile;->fileId:I

    .line 23516
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$CancelDownloadFile;->onlyIfPending:Z

    .line 23517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23521
    const v0, -0x747fad22

    return v0
.end method
