.class public Lorg/drinkless/tdlib/TdApi$BackgroundFillSolid;
.super Lorg/drinkless/tdlib/TdApi$BackgroundFill;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BackgroundFillSolid"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3c3dbc1d


# instance fields
.field public color:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9042
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundFill;-><init>()V

    .line 9043
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9033
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundFill;-><init>()V

    .line 9034
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$BackgroundFillSolid;->color:I

    .line 9035
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9039
    const v0, 0x3c3dbc1d

    return v0
.end method
