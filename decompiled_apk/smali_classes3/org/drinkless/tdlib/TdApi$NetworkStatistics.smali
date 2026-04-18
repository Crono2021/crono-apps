.class public Lorg/drinkless/tdlib/TdApi$NetworkStatistics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NetworkStatistics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x604b66a4


# instance fields
.field public entries:[Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;

.field public sinceDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28825
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "networkStatisticsEntryArr"    # [Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;

    .line 28814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28815
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$NetworkStatistics;->sinceDate:I

    .line 28816
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$NetworkStatistics;->entries:[Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;

    .line 28817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28821
    const v0, 0x604b66a4

    return v0
.end method
