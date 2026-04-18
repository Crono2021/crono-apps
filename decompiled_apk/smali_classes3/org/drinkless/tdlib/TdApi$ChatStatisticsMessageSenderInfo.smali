.class public Lorg/drinkless/tdlib/TdApi$ChatStatisticsMessageSenderInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatStatisticsMessageSenderInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x690a7e4b


# instance fields
.field public averageCharacterCount:I

.field public sentMessageCount:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36322
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36323
    return-void
.end method

.method public constructor <init>(JII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I

    .line 36311
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36312
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsMessageSenderInfo;->userId:J

    .line 36313
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsMessageSenderInfo;->sentMessageCount:I

    .line 36314
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsMessageSenderInfo;->averageCharacterCount:I

    .line 36315
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36319
    const v0, 0x690a7e4b

    return v0
.end method
