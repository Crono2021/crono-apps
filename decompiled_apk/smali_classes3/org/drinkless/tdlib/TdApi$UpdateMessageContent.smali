.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageContent;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageContent"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1e36bb24


# instance fields
.field public chatId:J

.field public messageId:J

.field public newContent:Lorg/drinkless/tdlib/TdApi$MessageContent;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41692
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41693
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$MessageContent;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "messageContent"    # Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 41681
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41682
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageContent;->chatId:J

    .line 41683
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageContent;->messageId:J

    .line 41684
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageContent;->newContent:Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 41685
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41689
    const v0, 0x1e36bb24

    return v0
.end method
