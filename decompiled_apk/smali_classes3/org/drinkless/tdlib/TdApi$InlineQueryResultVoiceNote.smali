.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultVoiceNote;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultVoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7117ebd1


# instance fields
.field public id:Ljava/lang/String;

.field public title:Ljava/lang/String;

.field public voiceNote:Lorg/drinkless/tdlib/TdApi$VoiceNote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37886
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 37887
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$VoiceNote;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "voiceNote"    # Lorg/drinkless/tdlib/TdApi$VoiceNote;
    .param p3, "str2"    # Ljava/lang/String;

    .line 37875
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 37876
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVoiceNote;->id:Ljava/lang/String;

    .line 37877
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVoiceNote;->voiceNote:Lorg/drinkless/tdlib/TdApi$VoiceNote;

    .line 37878
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVoiceNote;->title:Ljava/lang/String;

    .line 37879
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37883
    const v0, -0x7117ebd1

    return v0
.end method
