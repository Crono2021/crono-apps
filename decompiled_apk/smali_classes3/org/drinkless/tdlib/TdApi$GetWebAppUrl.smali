.class public Lorg/drinkless/tdlib/TdApi$GetWebAppUrl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetWebAppUrl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5b00e0bc


# instance fields
.field public botUserId:J

.field public parameters:Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37666
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37667
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "webAppOpenParameters"    # Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

    .line 37655
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37656
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppUrl;->botUserId:J

    .line 37657
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppUrl;->url:Ljava/lang/String;

    .line 37658
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppUrl;->parameters:Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

    .line 37659
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37663
    const v0, -0x5b00e0bc

    return v0
.end method
