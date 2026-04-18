.class public Lorg/drinkless/tdlib/TdApi$EditForumTopic;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditForumTopic"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x424db7ab


# instance fields
.field public chatId:J

.field public editIconCustomEmoji:Z

.field public forumTopicId:I

.field public iconCustomEmojiId:J

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47125
    return-void
.end method

.method public constructor <init>(JILjava/lang/String;ZJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "z8"    # Z
    .param p6, "j9"    # J

    .line 47111
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47112
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditForumTopic;->chatId:J

    .line 47113
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$EditForumTopic;->forumTopicId:I

    .line 47114
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EditForumTopic;->name:Ljava/lang/String;

    .line 47115
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$EditForumTopic;->editIconCustomEmoji:Z

    .line 47116
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$EditForumTopic;->iconCustomEmojiId:J

    .line 47117
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47121
    const v0, 0x424db7ab

    return v0
.end method
