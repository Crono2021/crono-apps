.class public Lorg/drinkless/tdlib/TdApi$Proxy;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Proxy"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xbaf7b73


# instance fields
.field public id:I

.field public isEnabled:Z

.field public lastUsedDate:I

.field public port:I

.field public server:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$ProxyType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50542
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50543
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;IIZLorg/drinkless/tdlib/TdApi$ProxyType;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i10"    # I
    .param p4, "i11"    # I
    .param p5, "z8"    # Z
    .param p6, "proxyType"    # Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 50528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50529
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Proxy;->id:I

    .line 50530
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Proxy;->server:Ljava/lang/String;

    .line 50531
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$Proxy;->port:I

    .line 50532
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$Proxy;->lastUsedDate:I

    .line 50533
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$Proxy;->isEnabled:Z

    .line 50534
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$Proxy;->type:Lorg/drinkless/tdlib/TdApi$ProxyType;

    .line 50535
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50539
    const v0, 0xbaf7b73

    return v0
.end method
