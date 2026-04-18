.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultArticle;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultArticle"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1016d01a


# instance fields
.field public description:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public title:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47670
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 47671
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Thumbnail;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 47657
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 47658
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultArticle;->id:Ljava/lang/String;

    .line 47659
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultArticle;->url:Ljava/lang/String;

    .line 47660
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultArticle;->title:Ljava/lang/String;

    .line 47661
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultArticle;->description:Ljava/lang/String;

    .line 47662
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultArticle;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 47663
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47667
    const v0, 0x1016d01a

    return v0
.end method
