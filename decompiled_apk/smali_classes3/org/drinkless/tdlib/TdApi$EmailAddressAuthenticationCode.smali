.class public Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCode;
.super Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmailAddressAuthenticationCode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3b33e63e


# instance fields
.field public code:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;-><init>()V

    .line 11635
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11625
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthentication;-><init>()V

    .line 11626
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCode;->code:Ljava/lang/String;

    .line 11627
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11631
    const v0, -0x3b33e63e

    return v0
.end method
