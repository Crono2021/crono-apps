.class public Lorg/drinkless/tdlib/TdApi$PaymentProviderSmartGlocal;
.super Lorg/drinkless/tdlib/TdApi$PaymentProvider;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentProviderSmartGlocal"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x45fb888c


# instance fields
.field public publicToken:Ljava/lang/String;

.field public tokenizeUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29244
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentProvider;-><init>()V

    .line 29245
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 29234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentProvider;-><init>()V

    .line 29235
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentProviderSmartGlocal;->publicToken:Ljava/lang/String;

    .line 29236
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PaymentProviderSmartGlocal;->tokenizeUrl:Ljava/lang/String;

    .line 29237
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29241
    const v0, -0x45fb888c

    return v0
.end method
