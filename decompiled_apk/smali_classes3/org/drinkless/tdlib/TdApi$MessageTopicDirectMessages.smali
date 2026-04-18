.class public Lorg/drinkless/tdlib/TdApi$MessageTopicDirectMessages;
.super Lorg/drinkless/tdlib/TdApi$MessageTopic;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageTopicDirectMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4c9d5227


# instance fields
.field public directMessagesChatTopicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16836
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageTopic;-><init>()V

    .line 16837
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16827
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageTopic;-><init>()V

    .line 16828
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageTopicDirectMessages;->directMessagesChatTopicId:J

    .line 16829
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16833
    const v0, -0x4c9d5227

    return v0
.end method
