.class public Lorg/drinkless/tdlib/TdApi$UpdateChatVideoChat;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatVideoChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x25fb4ca6


# instance fields
.field public chatId:J

.field public videoChat:Lorg/drinkless/tdlib/TdApi$VideoChat;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34428
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34429
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$VideoChat;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "videoChat"    # Lorg/drinkless/tdlib/TdApi$VideoChat;

    .line 34418
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34419
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatVideoChat;->chatId:J

    .line 34420
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatVideoChat;->videoChat:Lorg/drinkless/tdlib/TdApi$VideoChat;

    .line 34421
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34425
    const v0, 0x25fb4ca6

    return v0
.end method
