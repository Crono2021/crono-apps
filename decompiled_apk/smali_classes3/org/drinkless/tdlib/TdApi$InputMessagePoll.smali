.class public Lorg/drinkless/tdlib/TdApi$InputMessagePoll;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessagePoll"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xfb234cc


# instance fields
.field public closeDate:I

.field public isAnonymous:Z

.field public isClosed:Z

.field public openPeriod:I

.field public options:[Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public question:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public type:Lorg/drinkless/tdlib/TdApi$PollType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 51525
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;[Lorg/drinkless/tdlib/TdApi$FormattedText;ZLorg/drinkless/tdlib/TdApi$PollType;IIZ)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "formattedTextArr"    # [Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p3, "z8"    # Z
    .param p4, "pollType"    # Lorg/drinkless/tdlib/TdApi$PollType;
    .param p5, "i9"    # I
    .param p6, "i10"    # I
    .param p7, "z9"    # Z

    .line 51509
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 51510
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePoll;->question:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 51511
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePoll;->options:[Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 51512
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePoll;->isAnonymous:Z

    .line 51513
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePoll;->type:Lorg/drinkless/tdlib/TdApi$PollType;

    .line 51514
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePoll;->openPeriod:I

    .line 51515
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePoll;->closeDate:I

    .line 51516
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$InputMessagePoll;->isClosed:Z

    .line 51517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51521
    const v0, -0xfb234cc

    return v0
.end method
