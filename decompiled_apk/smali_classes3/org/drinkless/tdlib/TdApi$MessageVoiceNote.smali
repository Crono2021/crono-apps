.class public Lorg/drinkless/tdlib/TdApi$MessageVoiceNote;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageVoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1f753ff5


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public isListened:Z

.field public voiceNote:Lorg/drinkless/tdlib/TdApi$VoiceNote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38745
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$VoiceNote;Lorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "voiceNote"    # Lorg/drinkless/tdlib/TdApi$VoiceNote;
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p3, "z8"    # Z

    .line 38733
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38734
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageVoiceNote;->voiceNote:Lorg/drinkless/tdlib/TdApi$VoiceNote;

    .line 38735
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageVoiceNote;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 38736
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessageVoiceNote;->isListened:Z

    .line 38737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38741
    const v0, 0x1f753ff5

    return v0
.end method
