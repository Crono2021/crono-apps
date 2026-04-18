.class public Lorg/drinkless/tdlib/TdApi$UpdateChatLastMessage;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatLastMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x370797f9


# instance fields
.field public chatId:J

.field public lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

.field public positions:[Lorg/drinkless/tdlib/TdApi$ChatPosition;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41560
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41561
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$Message;[Lorg/drinkless/tdlib/TdApi$ChatPosition;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p4, "chatPositionArr"    # [Lorg/drinkless/tdlib/TdApi$ChatPosition;

    .line 41549
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41550
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatLastMessage;->chatId:J

    .line 41551
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatLastMessage;->lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

    .line 41552
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatLastMessage;->positions:[Lorg/drinkless/tdlib/TdApi$ChatPosition;

    .line 41553
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41557
    const v0, -0x370797f9

    return v0
.end method
