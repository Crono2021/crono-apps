.class public Lorg/drinkless/tdlib/TdApi$VoiceNote;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x460db30b


# instance fields
.field public duration:I

.field public mimeType:Ljava/lang/String;

.field public speechRecognitionResult:Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;

.field public voice:Lorg/drinkless/tdlib/TdApi$File;

.field public waveform:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49256
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49257
    return-void
.end method

.method public constructor <init>(I[BLjava/lang/String;Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "bArr"    # [B
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "speechRecognitionResult"    # Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;
    .param p5, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 49243
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49244
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$VoiceNote;->duration:I

    .line 49245
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$VoiceNote;->waveform:[B

    .line 49246
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$VoiceNote;->mimeType:Ljava/lang/String;

    .line 49247
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$VoiceNote;->speechRecognitionResult:Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;

    .line 49248
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$VoiceNote;->voice:Lorg/drinkless/tdlib/TdApi$File;

    .line 49249
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49253
    const v0, -0x460db30b

    return v0
.end method
