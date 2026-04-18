.class public Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicCreated;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventForumTopicCreated"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7785fb42


# instance fields
.field public topicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9799
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;)V
    .locals 0
    .param p1, "forumTopicInfo"    # Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 9789
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9790
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicCreated;->topicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 9791
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9795
    const v0, 0x7785fb42

    return v0
.end method
