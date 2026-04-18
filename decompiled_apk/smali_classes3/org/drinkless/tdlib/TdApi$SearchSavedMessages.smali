.class public Lorg/drinkless/tdlib/TdApi$SearchSavedMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchSavedMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundChatMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7564606a


# instance fields
.field public fromMessageId:J

.field public limit:I

.field public offset:I

.field public query:Ljava/lang/String;

.field public savedMessagesTopicId:J

.field public tag:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50626
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50627
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ReactionType;Ljava/lang/String;JII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "j9"    # J
    .param p7, "i9"    # I
    .param p8, "i10"    # I

    .line 50612
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50613
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SearchSavedMessages;->savedMessagesTopicId:J

    .line 50614
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchSavedMessages;->tag:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 50615
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SearchSavedMessages;->query:Ljava/lang/String;

    .line 50616
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$SearchSavedMessages;->fromMessageId:J

    .line 50617
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$SearchSavedMessages;->offset:I

    .line 50618
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$SearchSavedMessages;->limit:I

    .line 50619
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50623
    const v0, -0x7564606a

    return v0
.end method
