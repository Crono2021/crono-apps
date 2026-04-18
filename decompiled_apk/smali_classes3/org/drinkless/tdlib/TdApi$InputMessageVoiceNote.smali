.class public Lorg/drinkless/tdlib/TdApi$InputMessageVoiceNote;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageVoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5723ffac


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public duration:I

.field public selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

.field public voiceNote:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public waveform:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 47775
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;I[BLorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "i9"    # I
    .param p3, "bArr"    # [B
    .param p4, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p5, "messageSelfDestructType"    # Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

    .line 47761
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 47762
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVoiceNote;->voiceNote:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 47763
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVoiceNote;->duration:I

    .line 47764
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVoiceNote;->waveform:[B

    .line 47765
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVoiceNote;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 47766
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVoiceNote;->selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

    .line 47767
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47771
    const v0, 0x5723ffac

    return v0
.end method
