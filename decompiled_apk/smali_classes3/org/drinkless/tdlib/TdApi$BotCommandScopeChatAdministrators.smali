.class public Lorg/drinkless/tdlib/TdApi$BotCommandScopeChatAdministrators;
.super Lorg/drinkless/tdlib/TdApi$BotCommandScope;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotCommandScopeChatAdministrators"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x42bcfe4e


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9132
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotCommandScope;-><init>()V

    .line 9133
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 9123
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotCommandScope;-><init>()V

    .line 9124
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BotCommandScopeChatAdministrators;->chatId:J

    .line 9125
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9129
    const v0, 0x42bcfe4e

    return v0
.end method
