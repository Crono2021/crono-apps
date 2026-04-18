.class public Lorg/drinkless/tdlib/TdApi$AddProxy;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddProxy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Proxy;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x13c2bcd8


# instance fields
.field public enable:Z

.field public port:I

.field public server:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$ProxyType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42295
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;IZLorg/drinkless/tdlib/TdApi$ProxyType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z
    .param p4, "proxyType"    # Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 42282
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42283
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AddProxy;->server:Ljava/lang/String;

    .line 42284
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AddProxy;->port:I

    .line 42285
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$AddProxy;->enable:Z

    .line 42286
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AddProxy;->type:Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 42287
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42291
    const v0, 0x13c2bcd8

    return v0
.end method
