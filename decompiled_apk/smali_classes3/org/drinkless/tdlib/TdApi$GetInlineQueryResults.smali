.class public Lorg/drinkless/tdlib/TdApi$GetInlineQueryResults;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetInlineQueryResults"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$InlineQueryResults;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x79dcf86c


# instance fields
.field public botUserId:J

.field public chatId:J

.field public offset:Ljava/lang/String;

.field public query:Ljava/lang/String;

.field public userLocation:Lorg/drinkless/tdlib/TdApi$Location;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47462
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47463
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$Location;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p6, "str"    # Ljava/lang/String;
    .param p7, "str2"    # Ljava/lang/String;

    .line 47449
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47450
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetInlineQueryResults;->botUserId:J

    .line 47451
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetInlineQueryResults;->chatId:J

    .line 47452
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GetInlineQueryResults;->userLocation:Lorg/drinkless/tdlib/TdApi$Location;

    .line 47453
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GetInlineQueryResults;->query:Ljava/lang/String;

    .line 47454
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$GetInlineQueryResults;->offset:Ljava/lang/String;

    .line 47455
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47459
    const v0, 0x79dcf86c

    return v0
.end method
