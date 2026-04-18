.class public Lorg/drinkless/tdlib/TdApi$SetCommands;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetCommands"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x36123fa6


# instance fields
.field public commands:[Lorg/drinkless/tdlib/TdApi$BotCommand;

.field public languageCode:Ljava/lang/String;

.field public scope:Lorg/drinkless/tdlib/TdApi$BotCommandScope;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40285
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BotCommandScope;Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$BotCommand;)V
    .locals 0
    .param p1, "botCommandScope"    # Lorg/drinkless/tdlib/TdApi$BotCommandScope;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "botCommandArr"    # [Lorg/drinkless/tdlib/TdApi$BotCommand;

    .line 40273
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40274
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetCommands;->scope:Lorg/drinkless/tdlib/TdApi$BotCommandScope;

    .line 40275
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetCommands;->languageCode:Ljava/lang/String;

    .line 40276
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetCommands;->commands:[Lorg/drinkless/tdlib/TdApi$BotCommand;

    .line 40277
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40281
    const v0, -0x36123fa6

    return v0
.end method
