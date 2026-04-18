.class public Lorg/drinkless/tdlib/TdApi$GetPassportAuthorizationForm;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPassportAuthorizationForm"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PassportAuthorizationForm;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x61850486


# instance fields
.field public botUserId:J

.field public nonce:Ljava/lang/String;

.field public publicKey:Ljava/lang/String;

.field public scope:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43519
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "str3"    # Ljava/lang/String;

    .line 43506
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43507
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetPassportAuthorizationForm;->botUserId:J

    .line 43508
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetPassportAuthorizationForm;->scope:Ljava/lang/String;

    .line 43509
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetPassportAuthorizationForm;->publicKey:Ljava/lang/String;

    .line 43510
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GetPassportAuthorizationForm;->nonce:Ljava/lang/String;

    .line 43511
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43515
    const v0, 0x61850486

    return v0
.end method
