.class public Lorg/drinkless/tdlib/TdApi$Seconds;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Seconds"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3936e58e


# instance fields
.field public seconds:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19248
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 19249
    return-void
.end method

.method public constructor <init>(D)V
    .locals 0
    .param p1, "d9"    # D

    .line 19239
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 19240
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$Seconds;->seconds:D

    .line 19241
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19245
    const v0, 0x3936e58e

    return v0
.end method
