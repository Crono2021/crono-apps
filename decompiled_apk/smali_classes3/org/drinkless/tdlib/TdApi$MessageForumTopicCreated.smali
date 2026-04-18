.class public Lorg/drinkless/tdlib/TdApi$MessageForumTopicCreated;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageForumTopicCreated"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2a95d6a6


# instance fields
.field public icon:Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;

.field public isNameImplicit:Z

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38502
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38503
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZLorg/drinkless/tdlib/TdApi$ForumTopicIcon;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "forumTopicIcon"    # Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;

    .line 38491
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38492
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageForumTopicCreated;->name:Ljava/lang/String;

    .line 38493
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageForumTopicCreated;->isNameImplicit:Z

    .line 38494
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageForumTopicCreated;->icon:Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;

    .line 38495
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38499
    const v0, -0x2a95d6a6

    return v0
.end method
