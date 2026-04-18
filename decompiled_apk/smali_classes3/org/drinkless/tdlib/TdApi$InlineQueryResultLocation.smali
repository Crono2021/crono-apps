.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultLocation;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultLocation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1bc6ab10


# instance fields
.field public id:Ljava/lang/String;

.field public location:Lorg/drinkless/tdlib/TdApi$Location;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43782
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 43783
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Location;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Thumbnail;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 43770
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 43771
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultLocation;->id:Ljava/lang/String;

    .line 43772
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 43773
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultLocation;->title:Ljava/lang/String;

    .line 43774
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultLocation;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 43775
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43779
    const v0, 0x1bc6ab10

    return v0
.end method
