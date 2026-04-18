.class public Lorg/drinkless/tdlib/TdApi$ChatMembersFilterMention;
.super Lorg/drinkless/tdlib/TdApi$ChatMembersFilter;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMembersFilterMention"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x732c8244


# instance fields
.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMembersFilter;-><init>()V

    .line 10285
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageTopic;)V
    .locals 0
    .param p1, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 10275
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMembersFilter;-><init>()V

    .line 10276
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMembersFilterMention;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 10277
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10281
    const v0, 0x732c8244

    return v0
.end method
