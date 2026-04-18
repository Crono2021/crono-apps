.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeProxy;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeProxy"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e4ed316


# instance fields
.field public port:I

.field public server:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$ProxyType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38195
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ILorg/drinkless/tdlib/TdApi$ProxyType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I
    .param p3, "proxyType"    # Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 38183
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38184
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeProxy;->server:Ljava/lang/String;

    .line 38185
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeProxy;->port:I

    .line 38186
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeProxy;->type:Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 38187
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38191
    const v0, -0x4e4ed316

    return v0
.end method
