.class public Lorg/drinkless/tdlib/TdApi$UserStatusOffline;
.super Lorg/drinkless/tdlib/TdApi$UserStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserStatusOffline"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2d4c72fb


# instance fields
.field public wasOnline:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22520
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserStatus;-><init>()V

    .line 22521
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 22511
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserStatus;-><init>()V

    .line 22512
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UserStatusOffline;->wasOnline:I

    .line 22513
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22517
    const v0, -0x2d4c72fb

    return v0
.end method
