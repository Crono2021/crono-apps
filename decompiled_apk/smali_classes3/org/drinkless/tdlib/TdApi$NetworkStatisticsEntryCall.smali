.class public Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntryCall;
.super Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NetworkStatisticsEntryCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2bedbbad


# instance fields
.field public duration:D

.field public networkType:Lorg/drinkless/tdlib/TdApi$NetworkType;

.field public receivedBytes:J

.field public sentBytes:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44358
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;-><init>()V

    .line 44359
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$NetworkType;JJD)V
    .locals 0
    .param p1, "networkType"    # Lorg/drinkless/tdlib/TdApi$NetworkType;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "d9"    # D

    .line 44346
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntry;-><init>()V

    .line 44347
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntryCall;->networkType:Lorg/drinkless/tdlib/TdApi$NetworkType;

    .line 44348
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntryCall;->sentBytes:J

    .line 44349
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntryCall;->receivedBytes:J

    .line 44350
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$NetworkStatisticsEntryCall;->duration:D

    .line 44351
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44355
    const v0, 0x2bedbbad

    return v0
.end method
