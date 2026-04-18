.class public Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectTypeMessage;
.super Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatStatisticsObjectTypeMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6f9f24f6


# instance fields
.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;-><init>()V

    .line 10375
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 10365
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectType;-><init>()V

    .line 10366
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsObjectTypeMessage;->messageId:J

    .line 10367
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10371
    const v0, 0x6f9f24f6

    return v0
.end method
