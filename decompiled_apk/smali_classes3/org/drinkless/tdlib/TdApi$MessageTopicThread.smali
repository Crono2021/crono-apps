.class public Lorg/drinkless/tdlib/TdApi$MessageTopicThread;
.super Lorg/drinkless/tdlib/TdApi$MessageTopic;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageTopicThread"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x511dfe07


# instance fields
.field public messageThreadId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16890
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageTopic;-><init>()V

    .line 16891
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16881
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageTopic;-><init>()V

    .line 16882
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageTopicThread;->messageThreadId:J

    .line 16883
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16887
    const v0, 0x511dfe07

    return v0
.end method
