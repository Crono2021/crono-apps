.class public Lorg/drinkless/tdlib/TdApi$ChatStatisticsInviterInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatStatisticsInviterInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2583d48b


# instance fields
.field public addedMemberCount:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24444
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24445
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 24434
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24435
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsInviterInfo;->userId:J

    .line 24436
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsInviterInfo;->addedMemberCount:I

    .line 24437
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24441
    const v0, 0x2583d48b

    return v0
.end method
