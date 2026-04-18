.class public Lorg/drinkless/tdlib/TdApi$ChatMessageSenders;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMessageSenders"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6f3c6cba


# instance fields
.field public senders:[Lorg/drinkless/tdlib/TdApi$ChatMessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10302
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10303
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatMessageSender;)V
    .locals 0
    .param p1, "chatMessageSenderArr"    # [Lorg/drinkless/tdlib/TdApi$ChatMessageSender;

    .line 10293
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10294
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMessageSenders;->senders:[Lorg/drinkless/tdlib/TdApi$ChatMessageSender;

    .line 10295
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10299
    const v0, -0x6f3c6cba

    return v0
.end method
