.class public Lorg/drinkless/tdlib/TdApi$TimeZones;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TimeZones"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x13f27052


# instance fields
.field public timeZones:[Lorg/drinkless/tdlib/TdApi$TimeZone;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21332
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21333
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$TimeZone;)V
    .locals 0
    .param p1, "timeZoneArr"    # [Lorg/drinkless/tdlib/TdApi$TimeZone;

    .line 21323
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21324
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TimeZones;->timeZones:[Lorg/drinkless/tdlib/TdApi$TimeZone;

    .line 21325
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21329
    const v0, -0x13f27052

    return v0
.end method
