.class public Lorg/drinkless/tdlib/TdApi$MessageBotWriteAccessAllowed;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageBotWriteAccessAllowed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6575484c


# instance fields
.field public reason:Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16225
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;)V
    .locals 0
    .param p1, "botWriteAccessAllowReason"    # Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;

    .line 16215
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16216
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageBotWriteAccessAllowed;->reason:Lorg/drinkless/tdlib/TdApi$BotWriteAccessAllowReason;

    .line 16217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16221
    const v0, -0x6575484c

    return v0
.end method
