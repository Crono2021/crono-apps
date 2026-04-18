.class public Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xc8a82db


# instance fields
.field public addedStickerFileIds:[I

.field public animation:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public duration:I

.field public hasSpoiler:Z

.field public height:I

.field public showCaptionAboveMedia:Z

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52766
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 52767
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputThumbnail;[IIIILorg/drinkless/tdlib/TdApi$FormattedText;ZZ)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "inputThumbnail"    # Lorg/drinkless/tdlib/TdApi$InputThumbnail;
    .param p3, "iArr"    # [I
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "i11"    # I
    .param p7, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p8, "z8"    # Z
    .param p9, "z9"    # Z

    .line 52749
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 52750
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->animation:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 52751
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

    .line 52752
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->addedStickerFileIds:[I

    .line 52753
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->duration:I

    .line 52754
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->width:I

    .line 52755
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->height:I

    .line 52756
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 52757
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->showCaptionAboveMedia:Z

    .line 52758
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAnimation;->hasSpoiler:Z

    .line 52759
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52763
    const v0, -0xc8a82db

    return v0
.end method
