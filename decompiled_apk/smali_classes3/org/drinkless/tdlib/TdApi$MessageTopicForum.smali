.class public Lorg/drinkless/tdlib/TdApi$MessageTopicForum;
.super Lorg/drinkless/tdlib/TdApi$MessageTopic;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageTopicForum"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7e5416f0


# instance fields
.field public forumTopicId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageTopic;-><init>()V

    .line 16855
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16845
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageTopic;-><init>()V

    .line 16846
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageTopicForum;->forumTopicId:I

    .line 16847
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16851
    const v0, 0x7e5416f0

    return v0
.end method
