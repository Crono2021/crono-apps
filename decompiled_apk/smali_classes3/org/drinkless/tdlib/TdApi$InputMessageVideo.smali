.class public Lorg/drinkless/tdlib/TdApi$InputMessageVideo;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x241e307f


# instance fields
.field public addedStickerFileIds:[I

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public cover:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public duration:I

.field public hasSpoiler:Z

.field public height:I

.field public selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

.field public showCaptionAboveMedia:Z

.field public startTimestamp:I

.field public supportsStreaming:Z

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

.field public video:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 53995
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputThumbnail;Lorg/drinkless/tdlib/TdApi$InputFile;I[IIIIZLorg/drinkless/tdlib/TdApi$FormattedText;ZLorg/drinkless/tdlib/TdApi$MessageSelfDestructType;Z)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "inputThumbnail"    # Lorg/drinkless/tdlib/TdApi$InputThumbnail;
    .param p3, "inputFile2"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p4, "i9"    # I
    .param p5, "iArr"    # [I
    .param p6, "i10"    # I
    .param p7, "i11"    # I
    .param p8, "i12"    # I
    .param p9, "z8"    # Z
    .param p10, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p11, "z9"    # Z
    .param p12, "messageSelfDestructType"    # Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;
    .param p13, "z10"    # Z

    .line 53973
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 53974
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->video:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 53975
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

    .line 53976
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->cover:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 53977
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->startTimestamp:I

    .line 53978
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->addedStickerFileIds:[I

    .line 53979
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->duration:I

    .line 53980
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->width:I

    .line 53981
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->height:I

    .line 53982
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->supportsStreaming:Z

    .line 53983
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 53984
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->showCaptionAboveMedia:Z

    .line 53985
    iput-object p12, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

    .line 53986
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideo;->hasSpoiler:Z

    .line 53987
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53991
    const v0, -0x241e307f

    return v0
.end method
