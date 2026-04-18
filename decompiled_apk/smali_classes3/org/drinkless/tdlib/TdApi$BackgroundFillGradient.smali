.class public Lorg/drinkless/tdlib/TdApi$BackgroundFillGradient;
.super Lorg/drinkless/tdlib/TdApi$BackgroundFill;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BackgroundFillGradient"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6da00e81


# instance fields
.field public bottomColor:I

.field public rotationAngle:I

.field public topColor:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundFill;-><init>()V

    .line 35795
    return-void
.end method

.method public constructor <init>(III)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I

    .line 35783
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundFill;-><init>()V

    .line 35784
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$BackgroundFillGradient;->topColor:I

    .line 35785
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$BackgroundFillGradient;->bottomColor:I

    .line 35786
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$BackgroundFillGradient;->rotationAngle:I

    .line 35787
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35791
    const v0, -0x6da00e81

    return v0
.end method
