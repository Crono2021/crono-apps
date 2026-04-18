.class public Lorg/drinkless/tdlib/TdApi$UpdateUnreadMessageCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateUnreadMessageCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b541c9


# instance fields
.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

.field public unreadCount:I

.field public unreadUnmutedCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41935
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatList;II)V
    .locals 0
    .param p1, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;
    .param p2, "i9"    # I
    .param p3, "i10"    # I

    .line 41923
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41924
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadMessageCount;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 41925
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadMessageCount;->unreadCount:I

    .line 41926
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateUnreadMessageCount;->unreadUnmutedCount:I

    .line 41927
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41931
    const v0, 0x4b541c9

    return v0
.end method
