.class public Lorg/drinkless/tdlib/TdApi$BotCommandScopeChat;
.super Lorg/drinkless/tdlib/TdApi$BotCommandScope;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotCommandScopeChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x19a4dd5b


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotCommandScope;-><init>()V

    .line 9115
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 9105
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotCommandScope;-><init>()V

    .line 9106
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BotCommandScopeChat;->chatId:J

    .line 9107
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9111
    const v0, -0x19a4dd5b

    return v0
.end method
