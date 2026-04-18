.class public Lorg/drinkless/tdlib/TdApi$DateRange;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DateRange"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x51150c66


# instance fields
.field public endDate:I

.field public startDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24804
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24805
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 24794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24795
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DateRange;->startDate:I

    .line 24796
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$DateRange;->endDate:I

    .line 24797
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24801
    const v0, 0x51150c66    # 4.0009884E10f

    return v0
.end method
