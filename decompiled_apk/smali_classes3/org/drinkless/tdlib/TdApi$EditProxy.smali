.class public Lorg/drinkless/tdlib/TdApi$EditProxy;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditProxy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Proxy;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5fb7d7ad


# instance fields
.field public enable:Z

.field public port:I

.field public proxyId:I

.field public server:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$ProxyType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47176
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47177
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;IZLorg/drinkless/tdlib/TdApi$ProxyType;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i10"    # I
    .param p4, "z8"    # Z
    .param p5, "proxyType"    # Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 47163
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47164
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$EditProxy;->proxyId:I

    .line 47165
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EditProxy;->server:Ljava/lang/String;

    .line 47166
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$EditProxy;->port:I

    .line 47167
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$EditProxy;->enable:Z

    .line 47168
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EditProxy;->type:Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 47169
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47173
    const v0, -0x5fb7d7ad

    return v0
.end method
