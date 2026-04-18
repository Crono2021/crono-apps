.class public Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitEmailAddress;
.super Lorg/drinkless/tdlib/TdApi$AuthorizationState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthorizationStateWaitEmailAddress"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3e0471c7


# instance fields
.field public allowAppleId:Z

.field public allowGoogleId:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23024
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 23025
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 23014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 23015
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitEmailAddress;->allowAppleId:Z

    .line 23016
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitEmailAddress;->allowGoogleId:Z

    .line 23017
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23021
    const v0, 0x3e0471c7

    return v0
.end method
