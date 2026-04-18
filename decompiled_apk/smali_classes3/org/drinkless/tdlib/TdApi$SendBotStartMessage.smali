.class public Lorg/drinkless/tdlib/TdApi$SendBotStartMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendBotStartMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5595c112


# instance fields
.field public botUserId:J

.field public chatId:J

.field public parameter:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39932
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39933
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;

    .line 39921
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39922
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SendBotStartMessage;->botUserId:J

    .line 39923
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SendBotStartMessage;->chatId:J

    .line 39924
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SendBotStartMessage;->parameter:Ljava/lang/String;

    .line 39925
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39929
    const v0, -0x5595c112

    return v0
.end method
