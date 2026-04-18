.class public Lorg/drinkless/tdlib/TdApi$BackgroundFillFreeformGradient;
.super Lorg/drinkless/tdlib/TdApi$BackgroundFill;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BackgroundFillFreeformGradient"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x44467947


# instance fields
.field public colors:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9024
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundFill;-><init>()V

    .line 9025
    return-void
.end method

.method public constructor <init>([I)V
    .locals 0
    .param p1, "iArr"    # [I

    .line 9015
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundFill;-><init>()V

    .line 9016
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BackgroundFillFreeformGradient;->colors:[I

    .line 9017
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9021
    const v0, -0x44467947

    return v0
.end method
