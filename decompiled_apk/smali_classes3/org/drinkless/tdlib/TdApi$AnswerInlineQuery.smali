.class public Lorg/drinkless/tdlib/TdApi$AnswerInlineQuery;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnswerInlineQuery"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x50199514


# instance fields
.field public button:Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;

.field public cacheTime:I

.field public inlineQueryId:J

.field public isPersonal:Z

.field public nextOffset:Ljava/lang/String;

.field public results:[Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49366
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49367
    return-void
.end method

.method public constructor <init>(JZLorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;[Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;ILjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "inlineQueryResultsButton"    # Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;
    .param p5, "inputInlineQueryResultArr"    # [Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
    .param p6, "i9"    # I
    .param p7, "str"    # Ljava/lang/String;

    .line 49352
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49353
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AnswerInlineQuery;->inlineQueryId:J

    .line 49354
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$AnswerInlineQuery;->isPersonal:Z

    .line 49355
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AnswerInlineQuery;->button:Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;

    .line 49356
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$AnswerInlineQuery;->results:[Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;

    .line 49357
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$AnswerInlineQuery;->cacheTime:I

    .line 49358
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$AnswerInlineQuery;->nextOffset:Ljava/lang/String;

    .line 49359
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49363
    const v0, 0x50199514

    return v0
.end method
