.class public Lorg/drinkless/tdlib/TdApi$VideoNote;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VideoNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7ae918c5


# instance fields
.field public duration:I

.field public length:I

.field public minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public speechRecognitionResult:Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public video:Lorg/drinkless/tdlib/TdApi$File;

.field public waveform:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51885
    return-void
.end method

.method public constructor <init>(I[BILorg/drinkless/tdlib/TdApi$Minithumbnail;Lorg/drinkless/tdlib/TdApi$Thumbnail;Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "bArr"    # [B
    .param p3, "i10"    # I
    .param p4, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;
    .param p5, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;
    .param p6, "speechRecognitionResult"    # Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;
    .param p7, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 51869
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51870
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$VideoNote;->duration:I

    .line 51871
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$VideoNote;->waveform:[B

    .line 51872
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$VideoNote;->length:I

    .line 51873
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$VideoNote;->minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 51874
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$VideoNote;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 51875
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$VideoNote;->speechRecognitionResult:Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;

    .line 51876
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$VideoNote;->video:Lorg/drinkless/tdlib/TdApi$File;

    .line 51877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51881
    const v0, 0x7ae918c5

    return v0
.end method
