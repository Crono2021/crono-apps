.class public Lorg/drinkless/tdlib/TdApi$BusinessOpeningHoursInterval;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessOpeningHoursInterval"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x420fa9ac


# instance fields
.field public endMinute:I

.field public startMinute:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23424
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23425
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 23414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23415
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessOpeningHoursInterval;->startMinute:I

    .line 23416
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessOpeningHoursInterval;->endMinute:I

    .line 23417
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23421
    const v0, -0x420fa9ac

    return v0
.end method
