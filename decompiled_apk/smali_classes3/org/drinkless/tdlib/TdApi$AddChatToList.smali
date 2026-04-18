.class public Lorg/drinkless/tdlib/TdApi$AddChatToList;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddChatToList"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4ccb14b


# instance fields
.field public chatId:J

.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22745
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatList;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 22734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22735
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddChatToList;->chatId:J

    .line 22736
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AddChatToList;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 22737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22741
    const v0, -0x4ccb14b

    return v0
.end method
