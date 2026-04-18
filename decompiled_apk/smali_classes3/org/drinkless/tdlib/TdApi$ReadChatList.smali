.class public Lorg/drinkless/tdlib/TdApi$ReadChatList;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReadChatList"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x429b6756


# instance fields
.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18348
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18349
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatList;)V
    .locals 0
    .param p1, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 18339
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18340
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReadChatList;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 18341
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18345
    const v0, -0x429b6756

    return v0
.end method
