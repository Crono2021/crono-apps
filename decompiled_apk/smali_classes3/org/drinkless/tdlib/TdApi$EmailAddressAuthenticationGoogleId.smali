.class public Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationGoogleId;
.super Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmailAddressAuthenticationGoogleId"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x12418be


# instance fields
.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11652
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;-><init>()V

    .line 11653
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11643
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;-><init>()V

    .line 11644
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationGoogleId;->token:Ljava/lang/String;

    .line 11645
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11649
    const v0, -0x12418be

    return v0
.end method
