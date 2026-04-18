.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultVenue;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultVenue"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4c5b105e


# instance fields
.field public id:Ljava/lang/String;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public venue:Lorg/drinkless/tdlib/TdApi$Venue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 37865
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Venue;Lorg/drinkless/tdlib/TdApi$Thumbnail;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "venue"    # Lorg/drinkless/tdlib/TdApi$Venue;
    .param p3, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 37853
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 37854
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVenue;->id:Ljava/lang/String;

    .line 37855
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVenue;->venue:Lorg/drinkless/tdlib/TdApi$Venue;

    .line 37856
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultVenue;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 37857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37861
    const v0, 0x4c5b105e    # 5.7426296E7f

    return v0
.end method
