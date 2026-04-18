.class public Lorg/drinkless/tdlib/TdApi$AddFileToDownloads;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddFileToDownloads"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$File;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x33b583b7


# instance fields
.field public chatId:J

.field public fileId:I

.field public messageId:J

.field public priority:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42246
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42247
    return-void
.end method

.method public constructor <init>(IJJI)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "i10"    # I

    .line 42234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42235
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AddFileToDownloads;->fileId:I

    .line 42236
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$AddFileToDownloads;->chatId:J

    .line 42237
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$AddFileToDownloads;->messageId:J

    .line 42238
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$AddFileToDownloads;->priority:I

    .line 42239
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42243
    const v0, 0x33b583b7

    return v0
.end method
