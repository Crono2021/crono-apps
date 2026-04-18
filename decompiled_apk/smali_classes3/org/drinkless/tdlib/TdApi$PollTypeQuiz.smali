.class public Lorg/drinkless/tdlib/TdApi$PollTypeQuiz;
.super Lorg/drinkless/tdlib/TdApi$PollType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PollTypeQuiz"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x27293c99


# instance fields
.field public correctOptionId:I

.field public explanation:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29348
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PollType;-><init>()V

    .line 29349
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 29338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PollType;-><init>()V

    .line 29339
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PollTypeQuiz;->correctOptionId:I

    .line 29340
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PollTypeQuiz;->explanation:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 29341
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29345
    const v0, 0x27293c99

    return v0
.end method
