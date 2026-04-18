.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultVideo;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x51d8bd1b


# instance fields
.field public description:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public title:Ljava/lang/String;

.field public video:Lorg/drinkless/tdlib/TdApi$Video;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43830
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 43831
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Video;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "video"    # Lorg/drinkless/tdlib/TdApi$Video;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "str3"    # Ljava/lang/String;

    .line 43818
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 43819
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVideo;->id:Ljava/lang/String;

    .line 43820
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVideo;->video:Lorg/drinkless/tdlib/TdApi$Video;

    .line 43821
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVideo;->title:Ljava/lang/String;

    .line 43822
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVideo;->description:Ljava/lang/String;

    .line 43823
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43827
    const v0, -0x51d8bd1b

    return v0
.end method
