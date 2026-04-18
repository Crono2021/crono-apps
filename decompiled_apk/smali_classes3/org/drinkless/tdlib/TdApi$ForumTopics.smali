.class public Lorg/drinkless/tdlib/TdApi$ForumTopics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ForumTopics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6fee453b


# instance fields
.field public nextOffsetDate:I

.field public nextOffsetForumTopicId:I

.field public nextOffsetMessageId:J

.field public topics:[Lorg/drinkless/tdlib/TdApi$ForumTopic;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47280
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47281
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ForumTopic;IJI)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "forumTopicArr"    # [Lorg/drinkless/tdlib/TdApi$ForumTopic;
    .param p3, "i10"    # I
    .param p4, "j5"    # J
    .param p6, "i11"    # I

    .line 47267
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47268
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ForumTopics;->totalCount:I

    .line 47269
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ForumTopics;->topics:[Lorg/drinkless/tdlib/TdApi$ForumTopic;

    .line 47270
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ForumTopics;->nextOffsetDate:I

    .line 47271
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$ForumTopics;->nextOffsetMessageId:J

    .line 47272
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ForumTopics;->nextOffsetForumTopicId:I

    .line 47273
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47277
    const v0, 0x6fee453b

    return v0
.end method
