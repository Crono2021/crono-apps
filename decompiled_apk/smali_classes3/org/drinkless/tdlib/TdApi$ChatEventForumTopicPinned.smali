.class public Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicPinned;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventForumTopicPinned"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7fc523ee


# instance fields
.field public newTopicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

.field public oldTopicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23804
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23805
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;)V
    .locals 0
    .param p1, "forumTopicInfo"    # Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;
    .param p2, "forumTopicInfo2"    # Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 23794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23795
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicPinned;->oldTopicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 23796
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventForumTopicPinned;->newTopicInfo:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 23797
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23801
    const v0, 0x7fc523ee

    return v0
.end method
