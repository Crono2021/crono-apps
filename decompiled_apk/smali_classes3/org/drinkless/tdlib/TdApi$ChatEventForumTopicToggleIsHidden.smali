.class public Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicToggleIsHidden;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventForumTopicToggleIsHidden"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5fea10d2


# instance fields
.field public topicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9852
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9853
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;)V
    .locals 0
    .param p1, "forumTopicInfo"    # Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 9843
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9844
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicToggleIsHidden;->topicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 9845
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9849
    const v0, -0x5fea10d2    # -1.2699929E-19f

    return v0
.end method
