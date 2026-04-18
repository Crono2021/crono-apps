.class public Lorg/drinkless/tdlib/TdApi$UpdateAuthorizationState;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateAuthorizationState"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x60b30ee2


# instance fields
.field public authorizationState:Lorg/drinkless/tdlib/TdApi$AuthorizationState;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21549
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AuthorizationState;)V
    .locals 0
    .param p1, "authorizationState"    # Lorg/drinkless/tdlib/TdApi$AuthorizationState;

    .line 21539
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21540
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateAuthorizationState;->authorizationState:Lorg/drinkless/tdlib/TdApi$AuthorizationState;

    .line 21541
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21545
    const v0, 0x60b30ee2

    return v0
.end method
