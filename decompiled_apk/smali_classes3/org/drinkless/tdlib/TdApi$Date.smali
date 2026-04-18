.class public Lorg/drinkless/tdlib/TdApi$Date;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Date"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x10914960


# instance fields
.field public day:I

.field public month:I

.field public year:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36520
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36521
    return-void
.end method

.method public constructor <init>(III)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I

    .line 36509
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36510
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Date;->day:I

    .line 36511
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$Date;->month:I

    .line 36512
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$Date;->year:I

    .line 36513
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36517
    const v0, -0x10914960

    return v0
.end method
