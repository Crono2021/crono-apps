.class public Lorg/drinkless/tdlib/TdApi$GetMainWebApp;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMainWebApp"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MainWebApp;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x23687ca6


# instance fields
.field public botUserId:J

.field public chatId:J

.field public parameters:Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

.field public startParameter:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43470
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43471
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "webAppOpenParameters"    # Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

    .line 43458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43459
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMainWebApp;->chatId:J

    .line 43460
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMainWebApp;->botUserId:J

    .line 43461
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GetMainWebApp;->startParameter:Ljava/lang/String;

    .line 43462
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GetMainWebApp;->parameters:Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

    .line 43463
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43467
    const v0, 0x23687ca6

    return v0
.end method
