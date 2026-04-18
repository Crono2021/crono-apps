.class public Lorg/drinkless/tdlib/TdApi$ProxyTypeHttp;
.super Lorg/drinkless/tdlib/TdApi$ProxyType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProxyTypeHttp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5c383889


# instance fields
.field public httpOnly:Z

.field public password:Ljava/lang/String;

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39118
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ProxyType;-><init>()V

    .line 39119
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 39107
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ProxyType;-><init>()V

    .line 39108
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ProxyTypeHttp;->username:Ljava/lang/String;

    .line 39109
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ProxyTypeHttp;->password:Ljava/lang/String;

    .line 39110
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ProxyTypeHttp;->httpOnly:Z

    .line 39111
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39115
    const v0, -0x5c383889

    return v0
.end method
