.class public Lorg/drinkless/tdlib/TdApi$PollOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PollOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x63e97090


# instance fields
.field public isBeingChosen:Z

.field public isChosen:Z

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public votePercentage:I

.field public voterCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48372
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48373
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;IIZZ)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z

    .line 48359
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48360
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PollOption;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 48361
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PollOption;->voterCount:I

    .line 48362
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PollOption;->votePercentage:I

    .line 48363
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PollOption;->isChosen:Z

    .line 48364
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$PollOption;->isBeingChosen:Z

    .line 48365
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48369
    const v0, 0x63e97090

    return v0
.end method
