.class public Lorg/drinkless/tdlib/TdApi$MessageChatSetBackground;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatSetBackground"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3d5d7c40


# instance fields
.field public background:Lorg/drinkless/tdlib/TdApi$ChatBackground;

.field public oldBackgroundMessageId:J

.field public onlyForSelf:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38459
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatBackground;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatBackground"    # Lorg/drinkless/tdlib/TdApi$ChatBackground;
    .param p4, "z8"    # Z

    .line 38447
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38448
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatSetBackground;->oldBackgroundMessageId:J

    .line 38449
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageChatSetBackground;->background:Lorg/drinkless/tdlib/TdApi$ChatBackground;

    .line 38450
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessageChatSetBackground;->onlyForSelf:Z

    .line 38451
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38455
    const v0, 0x3d5d7c40

    return v0
.end method
