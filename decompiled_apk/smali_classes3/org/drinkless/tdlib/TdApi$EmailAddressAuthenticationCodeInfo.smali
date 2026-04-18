.class public Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmailAddressAuthenticationCodeInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x449be223


# instance fields
.field public emailAddressPattern:Ljava/lang/String;

.field public length:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25405
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 25394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25395
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;->emailAddressPattern:Ljava/lang/String;

    .line 25396
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;->length:I

    .line 25397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25401
    const v0, 0x449be223

    return v0
.end method
