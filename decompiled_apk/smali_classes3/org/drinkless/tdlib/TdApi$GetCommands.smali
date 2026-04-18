.class public Lorg/drinkless/tdlib/TdApi$GetCommands;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetCommands"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BotCommands;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x58ba8ff7


# instance fields
.field public languageCode:Ljava/lang/String;

.field public scope:Lorg/drinkless/tdlib/TdApi$BotCommandScope;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25984
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25985
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BotCommandScope;Ljava/lang/String;)V
    .locals 0
    .param p1, "botCommandScope"    # Lorg/drinkless/tdlib/TdApi$BotCommandScope;
    .param p2, "str"    # Ljava/lang/String;

    .line 25974
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25975
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetCommands;->scope:Lorg/drinkless/tdlib/TdApi$BotCommandScope;

    .line 25976
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetCommands;->languageCode:Ljava/lang/String;

    .line 25977
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25981
    const v0, 0x58ba8ff7

    return v0
.end method
