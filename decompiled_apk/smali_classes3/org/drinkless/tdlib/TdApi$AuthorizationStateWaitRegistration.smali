.class public Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitRegistration;
.super Lorg/drinkless/tdlib/TdApi$AuthorizationState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthorizationStateWaitRegistration"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x20cdaeaf


# instance fields
.field public termsOfService:Lorg/drinkless/tdlib/TdApi$TermsOfService;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8970
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 8971
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$TermsOfService;)V
    .locals 0
    .param p1, "termsOfService"    # Lorg/drinkless/tdlib/TdApi$TermsOfService;

    .line 8961
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 8962
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitRegistration;->termsOfService:Lorg/drinkless/tdlib/TdApi$TermsOfService;

    .line 8963
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8967
    const v0, 0x20cdaeaf

    return v0
.end method
