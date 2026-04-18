.class public Lorg/drinkless/tdlib/TdApi$GetChatStoryInteractions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatStoryInteractions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StoryInteractions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1521ee74


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public preferForwards:Z

.field public reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49842
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49843
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$ReactionType;ZLjava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p5, "z8"    # Z
    .param p6, "str"    # Ljava/lang/String;
    .param p7, "i10"    # I

    .line 49828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49829
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatStoryInteractions;->storyPosterChatId:J

    .line 49830
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatStoryInteractions;->storyId:I

    .line 49831
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetChatStoryInteractions;->reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 49832
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$GetChatStoryInteractions;->preferForwards:Z

    .line 49833
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GetChatStoryInteractions;->offset:Ljava/lang/String;

    .line 49834
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$GetChatStoryInteractions;->limit:I

    .line 49835
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49839
    const v0, 0x1521ee74

    return v0
.end method
