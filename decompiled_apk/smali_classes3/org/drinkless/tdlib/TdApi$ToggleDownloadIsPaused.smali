.class public Lorg/drinkless/tdlib/TdApi$ToggleDownloadIsPaused;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleDownloadIsPaused"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x387998eb


# instance fields
.field public fileId:I

.field public isPaused:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33188
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33189
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 33178
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33179
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleDownloadIsPaused;->fileId:I

    .line 33180
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleDownloadIsPaused;->isPaused:Z

    .line 33181
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33185
    const v0, -0x387998eb

    return v0
.end method
