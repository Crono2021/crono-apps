.class public Lorg/drinkless/tdlib/TdApi$InputMessageAudio;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageAudio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x255bff4e


# instance fields
.field public albumCoverThumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

.field public audio:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public duration:I

.field public performer:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50066
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 50067
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputThumbnail;ILjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "inputThumbnail"    # Lorg/drinkless/tdlib/TdApi$InputThumbnail;
    .param p3, "i9"    # I
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "str2"    # Ljava/lang/String;
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 50052
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 50053
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAudio;->audio:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 50054
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAudio;->albumCoverThumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

    .line 50055
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAudio;->duration:I

    .line 50056
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAudio;->title:Ljava/lang/String;

    .line 50057
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAudio;->performer:Ljava/lang/String;

    .line 50058
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputMessageAudio;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 50059
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50063
    const v0, -0x255bff4e

    return v0
.end method
