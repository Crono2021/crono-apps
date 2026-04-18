.class public Lorg/drinkless/tdlib/TdApi$BotCommandScopeChatMember;
.super Lorg/drinkless/tdlib/TdApi$BotCommandScope;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotCommandScopeChatMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xc99690e


# instance fields
.field public chatId:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotCommandScope;-><init>()V

    .line 23205
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 23194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotCommandScope;-><init>()V

    .line 23195
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BotCommandScopeChatMember;->chatId:J

    .line 23196
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$BotCommandScopeChatMember;->userId:J

    .line 23197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23201
    const v0, -0xc99690e

    return v0
.end method
