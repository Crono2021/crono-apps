.class public Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitCode;
.super Lorg/drinkless/tdlib/TdApi$AuthorizationState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthorizationStateWaitCode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3234501


# instance fields
.field public codeInfo:Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 8935
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;)V
    .locals 0
    .param p1, "authenticationCodeInfo"    # Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;

    .line 8925
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 8926
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitCode;->codeInfo:Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;

    .line 8927
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8931
    const v0, 0x3234501

    return v0
.end method
