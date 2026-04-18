.class public Lorg/drinkless/tdlib/TdApi$UpdatePendingTextMessage;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdatePendingTextMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x402701ab


# instance fields
.field public chatId:J

.field public draftId:J

.field public forumTopicId:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46230
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46231
    return-void
.end method

.method public constructor <init>(JIJLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "j9"    # J
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 46218
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46219
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdatePendingTextMessage;->chatId:J

    .line 46220
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdatePendingTextMessage;->forumTopicId:I

    .line 46221
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$UpdatePendingTextMessage;->draftId:J

    .line 46222
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdatePendingTextMessage;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 46223
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46227
    const v0, 0x402701ab

    return v0
.end method
