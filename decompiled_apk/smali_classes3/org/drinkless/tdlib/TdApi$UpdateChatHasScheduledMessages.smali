.class public Lorg/drinkless/tdlib/TdApi$UpdateChatHasScheduledMessages;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatHasScheduledMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7b14c2d7


# instance fields
.field public chatId:J

.field public hasScheduledMessages:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34048
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34049
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 34038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34039
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatHasScheduledMessages;->chatId:J

    .line 34040
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatHasScheduledMessages;->hasScheduledMessages:Z

    .line 34041
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34045
    const v0, 0x7b14c2d7

    return v0
.end method
