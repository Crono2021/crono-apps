.class public Lorg/drinkless/tdlib/TdApi$Point;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Point"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1a13f5b9


# instance fields
.field public f8019x:D

.field public f8020y:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29329
    return-void
.end method

.method public constructor <init>(DD)V
    .locals 0
    .param p1, "d9"    # D
    .param p3, "d10"    # D

    .line 29318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29319
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$Point;->f8019x:D

    .line 29320
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$Point;->f8020y:D

    .line 29321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29325
    const v0, 0x1a13f5b9

    return v0
.end method
