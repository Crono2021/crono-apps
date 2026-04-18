.class public Lorg/drinkless/tdlib/TdApi$DeleteChatMessagesBySender;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteChatMessagesBySender"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4564d199


# instance fields
.field public chatId:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25024
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25025
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 25014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25015
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatMessagesBySender;->chatId:J

    .line 25016
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatMessagesBySender;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 25017
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25021
    const v0, -0x4564d199

    return v0
.end method
