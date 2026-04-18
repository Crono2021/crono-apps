.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageUnreadReactions;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageUnreadReactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x383298c8


# instance fields
.field public chatId:J

.field public messageId:J

.field public unreadReactionCount:I

.field public unreadReactions:[Lorg/drinkless/tdlib/TdApi$UnreadReaction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46159
    return-void
.end method

.method public constructor <init>(JJ[Lorg/drinkless/tdlib/TdApi$UnreadReaction;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "unreadReactionArr"    # [Lorg/drinkless/tdlib/TdApi$UnreadReaction;
    .param p6, "i9"    # I

    .line 46146
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46147
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageUnreadReactions;->chatId:J

    .line 46148
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageUnreadReactions;->messageId:J

    .line 46149
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageUnreadReactions;->unreadReactions:[Lorg/drinkless/tdlib/TdApi$UnreadReaction;

    .line 46150
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageUnreadReactions;->unreadReactionCount:I

    .line 46151
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46155
    const v0, 0x383298c8

    return v0
.end method
