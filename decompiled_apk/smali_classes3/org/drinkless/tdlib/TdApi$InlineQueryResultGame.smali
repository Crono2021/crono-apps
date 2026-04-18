.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultGame;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultGame"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x65bd7c7b


# instance fields
.field public game:Lorg/drinkless/tdlib/TdApi$Game;

.field public id:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27144
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 27145
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Game;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "game"    # Lorg/drinkless/tdlib/TdApi$Game;

    .line 27134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 27135
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultGame;->id:Ljava/lang/String;

    .line 27136
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultGame;->game:Lorg/drinkless/tdlib/TdApi$Game;

    .line 27137
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27141
    const v0, 0x65bd7c7b

    return v0
.end method
