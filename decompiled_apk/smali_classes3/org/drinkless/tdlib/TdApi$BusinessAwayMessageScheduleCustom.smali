.class public Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageScheduleCustom;
.super Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSchedule;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessAwayMessageScheduleCustom"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x753fb22e


# instance fields
.field public endDate:I

.field public startDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSchedule;-><init>()V

    .line 23305
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 23294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageSchedule;-><init>()V

    .line 23295
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageScheduleCustom;->startDate:I

    .line 23296
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessAwayMessageScheduleCustom;->endDate:I

    .line 23297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23301
    const v0, -0x753fb22e

    return v0
.end method
