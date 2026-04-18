.class public Lorg/drinkless/tdlib/TdApi$VideoChatStream;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VideoChatStream"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x44a5a824


# instance fields
.field public channelId:I

.field public scale:I

.field public timeOffset:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42132
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42133
    return-void
.end method

.method public constructor <init>(IIJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "j5"    # J

    .line 42121
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42122
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$VideoChatStream;->channelId:I

    .line 42123
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$VideoChatStream;->scale:I

    .line 42124
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$VideoChatStream;->timeOffset:J

    .line 42125
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42129
    const v0, -0x44a5a824

    return v0
.end method
