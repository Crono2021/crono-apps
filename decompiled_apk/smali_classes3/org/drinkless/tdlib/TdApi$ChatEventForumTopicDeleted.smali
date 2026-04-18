.class public Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicDeleted;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventForumTopicDeleted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4f70d6f3


# instance fields
.field public topicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9816
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9817
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;)V
    .locals 0
    .param p1, "forumTopicInfo"    # Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 9807
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9808
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicDeleted;->topicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 9809
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9813
    const v0, -0x4f70d6f3

    return v0
.end method
