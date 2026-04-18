.class public Lorg/drinkless/tdlib/TdApi$UpdateChatReplyMarkup;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatReplyMarkup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e0ba5a0


# instance fields
.field public chatId:J

.field public replyMarkupMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34308
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34309
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 34298
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34299
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatReplyMarkup;->chatId:J

    .line 34300
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatReplyMarkup;->replyMarkupMessageId:J

    .line 34301
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34305
    const v0, 0x4e0ba5a0    # 5.8572186E8f

    return v0
.end method
