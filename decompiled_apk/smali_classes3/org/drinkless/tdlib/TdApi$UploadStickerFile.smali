.class public Lorg/drinkless/tdlib/TdApi$UploadStickerFile;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UploadStickerFile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$File;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x269650c3


# instance fields
.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public stickerFormat:Lorg/drinkless/tdlib/TdApi$StickerFormat;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42000
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42001
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$StickerFormat;Lorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "stickerFormat"    # Lorg/drinkless/tdlib/TdApi$StickerFormat;
    .param p4, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 41989
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41990
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UploadStickerFile;->userId:J

    .line 41991
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UploadStickerFile;->stickerFormat:Lorg/drinkless/tdlib/TdApi$StickerFormat;

    .line 41992
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UploadStickerFile;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 41993
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41997
    const v0, 0x269650c3

    return v0
.end method
