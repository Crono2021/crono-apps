.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeVoiceNote;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeVoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2d2d30d5


# instance fields
.field public voiceNote:Lorg/drinkless/tdlib/TdApi$VoiceNote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16062
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16063
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$VoiceNote;)V
    .locals 0
    .param p1, "voiceNote"    # Lorg/drinkless/tdlib/TdApi$VoiceNote;

    .line 16053
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16054
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeVoiceNote;->voiceNote:Lorg/drinkless/tdlib/TdApi$VoiceNote;

    .line 16055
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16059
    const v0, -0x2d2d30d5

    return v0
.end method
