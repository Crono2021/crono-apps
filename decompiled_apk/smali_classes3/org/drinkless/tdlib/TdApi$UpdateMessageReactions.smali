.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageReactions;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageReactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38efc345


# instance fields
.field public chatId:J

.field public date:I

.field public messageId:J

.field public reactions:[Lorg/drinkless/tdlib/TdApi$MessageReaction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46135
    return-void
.end method

.method public constructor <init>(JJI[Lorg/drinkless/tdlib/TdApi$MessageReaction;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "messageReactionArr"    # [Lorg/drinkless/tdlib/TdApi$MessageReaction;

    .line 46122
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46123
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReactions;->chatId:J

    .line 46124
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReactions;->messageId:J

    .line 46125
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReactions;->date:I

    .line 46126
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReactions;->reactions:[Lorg/drinkless/tdlib/TdApi$MessageReaction;

    .line 46127
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46131
    const v0, 0x38efc345

    return v0
.end method
