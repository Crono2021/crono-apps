.class public Lorg/drinkless/tdlib/TdApi$BotCommands;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotCommands"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x67cb1cf4


# instance fields
.field public botUserId:J

.field public commands:[Lorg/drinkless/tdlib/TdApi$BotCommand;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23225
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$BotCommand;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "botCommandArr"    # [Lorg/drinkless/tdlib/TdApi$BotCommand;

    .line 23214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23215
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BotCommands;->botUserId:J

    .line 23216
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$BotCommands;->commands:[Lorg/drinkless/tdlib/TdApi$BotCommand;

    .line 23217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23221
    const v0, 0x67cb1cf4

    return v0
.end method
