.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentVoiceNote;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentVoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x54cac8b


# instance fields
.field public isPinned:Z

.field public voiceNote:Lorg/drinkless/tdlib/TdApi$VoiceNote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29708
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29709
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$VoiceNote;Z)V
    .locals 0
    .param p1, "voiceNote"    # Lorg/drinkless/tdlib/TdApi$VoiceNote;
    .param p2, "z8"    # Z

    .line 29698
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29699
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentVoiceNote;->voiceNote:Lorg/drinkless/tdlib/TdApi$VoiceNote;

    .line 29700
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentVoiceNote;->isPinned:Z

    .line 29701
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29705
    const v0, 0x54cac8b

    return v0
.end method
