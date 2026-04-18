.class public Lorg/drinkless/tdlib/TdApi$MessageAnimation;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7134eed8


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public hasSpoiler:Z

.field public isSecret:Z

.field public showCaptionAboveMedia:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48008
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48009
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Animation;Lorg/drinkless/tdlib/TdApi$FormattedText;ZZZ)V
    .locals 0
    .param p1, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "z10"    # Z

    .line 47995
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 47996
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageAnimation;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 47997
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageAnimation;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 47998
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessageAnimation;->showCaptionAboveMedia:Z

    .line 47999
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessageAnimation;->hasSpoiler:Z

    .line 48000
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$MessageAnimation;->isSecret:Z

    .line 48001
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48005
    const v0, -0x7134eed8

    return v0
.end method
