.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypePassportDataRequest;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypePassportDataRequest"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3af0317f


# instance fields
.field public botUserId:J

.field public callbackUrl:Ljava/lang/String;

.field public nonce:Ljava/lang/String;

.field public publicKey:Ljava/lang/String;

.field public scope:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47852
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 47853
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "str3"    # Ljava/lang/String;
    .param p6, "str4"    # Ljava/lang/String;

    .line 47839
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 47840
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePassportDataRequest;->botUserId:J

    .line 47841
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePassportDataRequest;->scope:Ljava/lang/String;

    .line 47842
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePassportDataRequest;->publicKey:Ljava/lang/String;

    .line 47843
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePassportDataRequest;->nonce:Ljava/lang/String;

    .line 47844
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePassportDataRequest;->callbackUrl:Ljava/lang/String;

    .line 47845
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47849
    const v0, -0x3af0317f

    return v0
.end method
