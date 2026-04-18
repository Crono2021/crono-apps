.class public Lorg/drinkless/tdlib/TdApi$InputMessageSticker;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3ff1b6f9


# instance fields
.field public emoji:Ljava/lang/String;

.field public height:I

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47722
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 47723
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputThumbnail;IILjava/lang/String;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "inputThumbnail"    # Lorg/drinkless/tdlib/TdApi$InputThumbnail;
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "str"    # Ljava/lang/String;

    .line 47709
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 47710
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageSticker;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 47711
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageSticker;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

    .line 47712
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageSticker;->width:I

    .line 47713
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageSticker;->height:I

    .line 47714
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessageSticker;->emoji:Ljava/lang/String;

    .line 47715
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47719
    const v0, 0x3ff1b6f9

    return v0
.end method
