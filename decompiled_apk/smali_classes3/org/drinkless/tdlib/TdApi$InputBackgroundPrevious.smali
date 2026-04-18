.class public Lorg/drinkless/tdlib/TdApi$InputBackgroundPrevious;
.super Lorg/drinkless/tdlib/TdApi$InputBackground;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputBackgroundPrevious"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x14f9a8a2


# instance fields
.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14442
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputBackground;-><init>()V

    .line 14443
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14433
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputBackground;-><init>()V

    .line 14434
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputBackgroundPrevious;->messageId:J

    .line 14435
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14439
    const v0, -0x14f9a8a2

    return v0
.end method
