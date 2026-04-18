.class public Lorg/drinkless/tdlib/TdApi$OpenWebApp;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OpenWebApp"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$WebAppInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x38aa4dc2


# instance fields
.field public botUserId:J

.field public chatId:J

.field public parameters:Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

.field public replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50319
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;Lorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p7, "inputMessageReplyTo"    # Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
    .param p8, "webAppOpenParameters"    # Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

    .line 50304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50305
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$OpenWebApp;->chatId:J

    .line 50306
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$OpenWebApp;->botUserId:J

    .line 50307
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$OpenWebApp;->url:Ljava/lang/String;

    .line 50308
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$OpenWebApp;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 50309
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$OpenWebApp;->replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

    .line 50310
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$OpenWebApp;->parameters:Lorg/drinkless/tdlib/TdApi$WebAppOpenParameters;

    .line 50311
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50315
    const v0, -0x38aa4dc2

    return v0
.end method
