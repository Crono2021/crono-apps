.class public Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPassword;
.super Lorg/drinkless/tdlib/TdApi$AuthorizationState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthorizationStateWaitPassword"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6b09dce


# instance fields
.field public hasPassportData:Z

.field public hasRecoveryEmailAddress:Z

.field public passwordHint:Ljava/lang/String;

.field public recoveryEmailAddressPattern:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42390
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 42391
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZLjava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "str2"    # Ljava/lang/String;

    .line 42378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 42379
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPassword;->passwordHint:Ljava/lang/String;

    .line 42380
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPassword;->hasRecoveryEmailAddress:Z

    .line 42381
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPassword;->hasPassportData:Z

    .line 42382
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPassword;->recoveryEmailAddressPattern:Ljava/lang/String;

    .line 42383
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42387
    const v0, 0x6b09dce

    return v0
.end method
