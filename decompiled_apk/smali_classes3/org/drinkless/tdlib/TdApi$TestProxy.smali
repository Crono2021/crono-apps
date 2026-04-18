.class public Lorg/drinkless/tdlib/TdApi$TestProxy;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestProxy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x475e5d62


# instance fields
.field public dcId:I

.field public port:I

.field public server:Ljava/lang/String;

.field public timeout:D

.field public type:Lorg/drinkless/tdlib/TdApi$ProxyType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49126
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49127
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ILorg/drinkless/tdlib/TdApi$ProxyType;ID)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I
    .param p3, "proxyType"    # Lorg/drinkless/tdlib/TdApi$ProxyType;
    .param p4, "i10"    # I
    .param p5, "d9"    # D

    .line 49113
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49114
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestProxy;->server:Ljava/lang/String;

    .line 49115
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$TestProxy;->port:I

    .line 49116
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$TestProxy;->type:Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 49117
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$TestProxy;->dcId:I

    .line 49118
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$TestProxy;->timeout:D

    .line 49119
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49123
    const v0, -0x475e5d62

    return v0
.end method
