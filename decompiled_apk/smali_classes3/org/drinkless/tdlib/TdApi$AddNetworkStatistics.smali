.class public Lorg/drinkless/tdlib/TdApi$AddNetworkStatistics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddNetworkStatistics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b63b3d9


# instance fields
.field public entry:Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8646
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 8647
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;)V
    .locals 0
    .param p1, "networkStatisticsEntry"    # Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;

    .line 8637
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 8638
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AddNetworkStatistics;->entry:Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;

    .line 8639
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8643
    const v0, 0x4b63b3d9    # 1.4922713E7f

    return v0
.end method
