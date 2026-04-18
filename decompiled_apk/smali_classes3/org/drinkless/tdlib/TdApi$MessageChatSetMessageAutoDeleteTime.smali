.class public Lorg/drinkless/tdlib/TdApi$MessageChatSetMessageAutoDeleteTime;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatSetMessageAutoDeleteTime"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x619e052e


# instance fields
.field public fromUserId:J

.field public messageAutoDeleteTime:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28305
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J

    .line 28294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28295
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatSetMessageAutoDeleteTime;->messageAutoDeleteTime:I

    .line 28296
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$MessageChatSetMessageAutoDeleteTime;->fromUserId:J

    .line 28297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28301
    const v0, 0x619e052e

    return v0
.end method
