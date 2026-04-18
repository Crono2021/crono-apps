.class public Lorg/drinkless/tdlib/TdApi$UpdateChatMessageSender;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatMessageSender"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x77705241


# instance fields
.field public chatId:J

.field public messageSenderId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34128
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34129
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 34118
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34119
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMessageSender;->chatId:J

    .line 34120
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMessageSender;->messageSenderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 34121
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34125
    const v0, 0x77705241

    return v0
.end method
