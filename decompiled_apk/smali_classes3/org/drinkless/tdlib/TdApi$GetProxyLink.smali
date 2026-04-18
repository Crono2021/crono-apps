.class public Lorg/drinkless/tdlib/TdApi$GetProxyLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetProxyLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3eda5188


# instance fields
.field public proxyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13362
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13363
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 13353
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13354
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetProxyLink;->proxyId:I

    .line 13355
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13359
    const v0, -0x3eda5188

    return v0
.end method
