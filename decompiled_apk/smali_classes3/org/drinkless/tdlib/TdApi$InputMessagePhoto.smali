.class public Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessagePhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x30499822


# instance fields
.field public addedStickerFileIds:[I

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public hasSpoiler:Z

.field public height:I

.field public photo:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

.field public showCaptionAboveMedia:Z

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52800
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 52801
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputThumbnail;[IIILorg/drinkless/tdlib/TdApi$FormattedText;ZLorg/drinkless/tdlib/TdApi$MessageSelfDestructType;Z)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "inputThumbnail"    # Lorg/drinkless/tdlib/TdApi$InputThumbnail;
    .param p3, "iArr"    # [I
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p7, "z8"    # Z
    .param p8, "messageSelfDestructType"    # Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;
    .param p9, "z9"    # Z

    .line 52783
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 52784
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->photo:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 52785
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

    .line 52786
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->addedStickerFileIds:[I

    .line 52787
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->width:I

    .line 52788
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->height:I

    .line 52789
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 52790
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->showCaptionAboveMedia:Z

    .line 52791
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

    .line 52792
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePhoto;->hasSpoiler:Z

    .line 52793
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52797
    const v0, -0x30499822

    return v0
.end method
