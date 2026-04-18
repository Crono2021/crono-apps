.class public Lorg/drinkless/tdlib/TdApi$InputBackgroundRemote;
.super Lorg/drinkless/tdlib/TdApi$InputBackground;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputBackgroundRemote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1063cde7


# instance fields
.field public backgroundId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14460
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputBackground;-><init>()V

    .line 14461
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14451
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputBackground;-><init>()V

    .line 14452
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputBackgroundRemote;->backgroundId:J

    .line 14453
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14457
    const v0, -0x1063cde7

    return v0
.end method
