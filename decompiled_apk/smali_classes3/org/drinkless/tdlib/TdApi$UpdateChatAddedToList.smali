.class public Lorg/drinkless/tdlib/TdApi$UpdateChatAddedToList;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatAddedToList"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x548ffb14


# instance fields
.field public chatId:J

.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33869
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatList;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 33858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33859
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAddedToList;->chatId:J

    .line 33860
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAddedToList;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 33861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33865
    const v0, -0x548ffb14

    return v0
.end method
