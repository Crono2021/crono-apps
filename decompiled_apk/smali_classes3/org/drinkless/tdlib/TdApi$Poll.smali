.class public Lorg/drinkless/tdlib/TdApi$Poll;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Poll"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x720650b6


# instance fields
.field public closeDate:I

.field public id:J

.field public isAnonymous:Z

.field public isClosed:Z

.field public openPeriod:I

.field public options:[Lorg/drinkless/tdlib/TdApi$PollOption;

.field public question:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public recentVoterIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public totalVoterCount:I

.field public type:Lorg/drinkless/tdlib/TdApi$PollType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53420
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53421
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$FormattedText;[Lorg/drinkless/tdlib/TdApi$PollOption;I[Lorg/drinkless/tdlib/TdApi$MessageSender;ZLorg/drinkless/tdlib/TdApi$PollType;IIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p4, "pollOptionArr"    # [Lorg/drinkless/tdlib/TdApi$PollOption;
    .param p5, "i9"    # I
    .param p6, "messageSenderArr"    # [Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p7, "z8"    # Z
    .param p8, "pollType"    # Lorg/drinkless/tdlib/TdApi$PollType;
    .param p9, "i10"    # I
    .param p10, "i11"    # I
    .param p11, "z9"    # Z

    .line 53402
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53403
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$Poll;->id:J

    .line 53404
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Poll;->question:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 53405
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$Poll;->options:[Lorg/drinkless/tdlib/TdApi$PollOption;

    .line 53406
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$Poll;->totalVoterCount:I

    .line 53407
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$Poll;->recentVoterIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 53408
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$Poll;->isAnonymous:Z

    .line 53409
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$Poll;->type:Lorg/drinkless/tdlib/TdApi$PollType;

    .line 53410
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$Poll;->openPeriod:I

    .line 53411
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$Poll;->closeDate:I

    .line 53412
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$Poll;->isClosed:Z

    .line 53413
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53417
    const v0, 0x720650b6

    return v0
.end method
