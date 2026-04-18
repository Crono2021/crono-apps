.class public Lorg/drinkless/tdlib/TdApi$TestSquareInt;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestSquareInt"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TestInt;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3959670


# instance fields
.field public f8027x:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21080
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21081
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 21071
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21072
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$TestSquareInt;->f8027x:I

    .line 21073
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21077
    const v0, -0x3959670

    return v0
.end method
