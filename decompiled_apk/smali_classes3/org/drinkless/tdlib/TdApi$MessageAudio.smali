.class public Lorg/drinkless/tdlib/TdApi$MessageAudio;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageAudio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x107e741c


# instance fields
.field public audio:Lorg/drinkless/tdlib/TdApi$Audio;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28225
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Audio;Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "audio"    # Lorg/drinkless/tdlib/TdApi$Audio;
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 28214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28215
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageAudio;->audio:Lorg/drinkless/tdlib/TdApi$Audio;

    .line 28216
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageAudio;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 28217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28221
    const v0, 0x107e741c

    return v0
.end method
