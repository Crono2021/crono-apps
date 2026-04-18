.class public Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessOpeningHours"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x30ac6234


# instance fields
.field public openingHours:[Lorg/drinkless/tdlib/TdApi$BusinessOpeningHoursInterval;

.field public timeZoneId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23405
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$BusinessOpeningHoursInterval;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "businessOpeningHoursIntervalArr"    # [Lorg/drinkless/tdlib/TdApi$BusinessOpeningHoursInterval;

    .line 23394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23395
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;->timeZoneId:Ljava/lang/String;

    .line 23396
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessOpeningHours;->openingHours:[Lorg/drinkless/tdlib/TdApi$BusinessOpeningHoursInterval;

    .line 23397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23401
    const v0, 0x30ac6234

    return v0
.end method
