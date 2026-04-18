.class public Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SavedMessagesTopic"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2d571e5c


# instance fields
.field public draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

.field public id:J

.field public isPinned:Z

.field public lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

.field public order:J

.field public type:Lorg/drinkless/tdlib/TdApi$SavedMessagesTopicType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50599
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$SavedMessagesTopicType;ZJLorg/drinkless/tdlib/TdApi$Message;Lorg/drinkless/tdlib/TdApi$DraftMessage;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "savedMessagesTopicType"    # Lorg/drinkless/tdlib/TdApi$SavedMessagesTopicType;
    .param p4, "z8"    # Z
    .param p5, "j9"    # J
    .param p7, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p8, "draftMessage"    # Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 50584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50585
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;->id:J

    .line 50586
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;->type:Lorg/drinkless/tdlib/TdApi$SavedMessagesTopicType;

    .line 50587
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;->isPinned:Z

    .line 50588
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;->order:J

    .line 50589
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;->lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

    .line 50590
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$SavedMessagesTopic;->draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 50591
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50595
    const v0, -0x2d571e5c

    return v0
.end method
