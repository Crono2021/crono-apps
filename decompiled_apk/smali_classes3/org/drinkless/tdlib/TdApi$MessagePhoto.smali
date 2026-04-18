.class public Lorg/drinkless/tdlib/TdApi$MessagePhoto;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x754c7e1f


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public hasSpoiler:Z

.field public isSecret:Z

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public showCaptionAboveMedia:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48165
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;Lorg/drinkless/tdlib/TdApi$FormattedText;ZZZ)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "z10"    # Z

    .line 48151
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48152
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePhoto;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 48153
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessagePhoto;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 48154
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessagePhoto;->showCaptionAboveMedia:Z

    .line 48155
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessagePhoto;->hasSpoiler:Z

    .line 48156
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$MessagePhoto;->isSecret:Z

    .line 48157
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48161
    const v0, 0x754c7e1f

    return v0
.end method
