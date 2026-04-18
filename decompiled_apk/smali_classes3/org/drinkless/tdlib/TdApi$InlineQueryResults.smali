.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResults;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResults"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6d1e0baf


# instance fields
.field public button:Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;

.field public inlineQueryId:J

.field public nextOffset:Ljava/lang/String;

.field public results:[Lorg/drinkless/tdlib/TdApi$InlineQueryResult;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43855
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;[Lorg/drinkless/tdlib/TdApi$InlineQueryResult;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inlineQueryResultsButton"    # Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;
    .param p4, "inlineQueryResultArr"    # [Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
    .param p5, "str"    # Ljava/lang/String;

    .line 43842
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43843
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResults;->inlineQueryId:J

    .line 43844
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResults;->button:Lorg/drinkless/tdlib/TdApi$InlineQueryResultsButton;

    .line 43845
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResults;->results:[Lorg/drinkless/tdlib/TdApi$InlineQueryResult;

    .line 43846
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResults;->nextOffset:Ljava/lang/String;

    .line 43847
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43851
    const v0, 0x6d1e0baf

    return v0
.end method
