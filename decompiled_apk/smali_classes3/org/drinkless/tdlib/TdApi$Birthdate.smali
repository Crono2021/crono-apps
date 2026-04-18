.class public Lorg/drinkless/tdlib/TdApi$Birthdate;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Birthdate"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x61fe6d1e


# instance fields
.field public day:I

.field public month:I

.field public year:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35816
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35817
    return-void
.end method

.method public constructor <init>(III)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I

    .line 35805
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35806
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Birthdate;->day:I

    .line 35807
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$Birthdate;->month:I

    .line 35808
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$Birthdate;->year:I

    .line 35809
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35813
    const v0, 0x61fe6d1e

    return v0
.end method
