.class public Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitEmailCode;
.super Lorg/drinkless/tdlib/TdApi$AuthorizationState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthorizationStateWaitEmailCode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6f60fda5


# instance fields
.field public allowAppleId:Z

.field public allowGoogleId:Z

.field public codeInfo:Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;

.field public emailAddressResetState:Lorg/drinkless/tdlib/TdApi$EmailAddressResetState;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42366
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 42367
    return-void
.end method

.method public constructor <init>(ZZLorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;Lorg/drinkless/tdlib/TdApi$EmailAddressResetState;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "emailAddressAuthenticationCodeInfo"    # Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;
    .param p4, "emailAddressResetState"    # Lorg/drinkless/tdlib/TdApi$EmailAddressResetState;

    .line 42354
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 42355
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitEmailCode;->allowAppleId:Z

    .line 42356
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitEmailCode;->allowGoogleId:Z

    .line 42357
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitEmailCode;->codeInfo:Lorg/drinkless/tdlib/TdApi$EmailAddressAuthenticationCodeInfo;

    .line 42358
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitEmailCode;->emailAddressResetState:Lorg/drinkless/tdlib/TdApi$EmailAddressResetState;

    .line 42359
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42363
    const v0, -0x6f60fda5

    return v0
.end method
