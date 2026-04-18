.class public Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationAppleId;
.super Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmailAddressAuthenticationAppleId"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x25c94869


# instance fields
.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11616
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;-><init>()V

    .line 11617
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11607
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;-><init>()V

    .line 11608
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationAppleId;->token:Ljava/lang/String;

    .line 11609
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11613
    const v0, 0x25c94869

    return v0
.end method
