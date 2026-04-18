.class public Lorg/drinkless/tdlib/TdApi$UpdateUnreadChatCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateUnreadChatCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x76e19242


# instance fields
.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

.field public markedAsUnreadCount:I

.field public markedAsUnreadUnmutedCount:I

.field public totalCount:I

.field public unreadCount:I

.field public unreadUnmutedCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51018
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 51019
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatList;IIIII)V
    .locals 0
    .param p1, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "i11"    # I
    .param p5, "i12"    # I
    .param p6, "i13"    # I

    .line 51004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 51005
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadChatCount;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 51006
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadChatCount;->totalCount:I

    .line 51007
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadChatCount;->unreadCount:I

    .line 51008
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadChatCount;->unreadUnmutedCount:I

    .line 51009
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadChatCount;->markedAsUnreadCount:I

    .line 51010
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadChatCount;->markedAsUnreadUnmutedCount:I

    .line 51011
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51015
    const v0, 0x76e19242

    return v0
.end method
