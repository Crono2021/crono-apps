.class public Lorg/drinkless/tdlib/TdApi$MessageVideo;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38c658a0


# instance fields
.field public alternativeVideos:[Lorg/drinkless/tdlib/TdApi$AlternativeVideo;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public cover:Lorg/drinkless/tdlib/TdApi$Photo;

.field public hasSpoiler:Z

.field public isSecret:Z

.field public showCaptionAboveMedia:Z

.field public startTimestamp:I

.field public storyboards:[Lorg/drinkless/tdlib/TdApi$VideoStoryboard;

.field public video:Lorg/drinkless/tdlib/TdApi$Video;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52970
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52971
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Video;[Lorg/drinkless/tdlib/TdApi$AlternativeVideo;[Lorg/drinkless/tdlib/TdApi$VideoStoryboard;Lorg/drinkless/tdlib/TdApi$Photo;ILorg/drinkless/tdlib/TdApi$FormattedText;ZZZ)V
    .locals 0
    .param p1, "video"    # Lorg/drinkless/tdlib/TdApi$Video;
    .param p2, "alternativeVideoArr"    # [Lorg/drinkless/tdlib/TdApi$AlternativeVideo;
    .param p3, "videoStoryboardArr"    # [Lorg/drinkless/tdlib/TdApi$VideoStoryboard;
    .param p4, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p5, "i9"    # I
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p7, "z8"    # Z
    .param p8, "z9"    # Z
    .param p9, "z10"    # Z

    .line 52953
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 52954
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->video:Lorg/drinkless/tdlib/TdApi$Video;

    .line 52955
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->alternativeVideos:[Lorg/drinkless/tdlib/TdApi$AlternativeVideo;

    .line 52956
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->storyboards:[Lorg/drinkless/tdlib/TdApi$VideoStoryboard;

    .line 52957
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->cover:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 52958
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->startTimestamp:I

    .line 52959
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 52960
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->showCaptionAboveMedia:Z

    .line 52961
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->hasSpoiler:Z

    .line 52962
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$MessageVideo;->isSecret:Z

    .line 52963
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52967
    const v0, 0x38c658a0

    return v0
.end method
