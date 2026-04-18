.class public Lorg/drinkless/tdlib/TdApi$GetWebAppLinkUrl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetWebAppLinkUrl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x60fe62c1


# instance fields
.field public allowWriteAccess:Z

.field public botUserId:J

.field public chatId:J

.field public parameters:Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

.field public startParameter:Ljava/lang/String;

.field public webAppShortName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49926
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49927
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;Ljava/lang/String;ZLorg/drinkless/tdlib/TdApi$WebAppOpenParameters;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "z8"    # Z
    .param p8, "webAppOpenParameters"    # Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

    .line 49912
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49913
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppLinkUrl;->chatId:J

    .line 49914
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppLinkUrl;->botUserId:J

    .line 49915
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppLinkUrl;->webAppShortName:Ljava/lang/String;

    .line 49916
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppLinkUrl;->startParameter:Ljava/lang/String;

    .line 49917
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppLinkUrl;->allowWriteAccess:Z

    .line 49918
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppLinkUrl;->parameters:Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

    .line 49919
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49923
    const v0, 0x60fe62c1

    return v0
.end method
