.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultPhoto;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6e2b1dd0


# instance fields
.field public description:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43806
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 43807
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "str3"    # Ljava/lang/String;

    .line 43794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 43795
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultPhoto;->id:Ljava/lang/String;

    .line 43796
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultPhoto;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 43797
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultPhoto;->title:Ljava/lang/String;

    .line 43798
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultPhoto;->description:Ljava/lang/String;

    .line 43799
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43803
    const v0, 0x6e2b1dd0

    return v0
.end method
