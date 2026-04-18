.class public Lorg/drinkless/tdlib/TdApi$ChatLists;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatLists"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xf653c23


# instance fields
.field public chatLists:[Lorg/drinkless/tdlib/TdApi$ChatList;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10230
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10231
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatList;)V
    .locals 0
    .param p1, "chatListArr"    # [Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 10221
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10222
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatLists;->chatLists:[Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 10223
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10227
    const v0, -0xf653c23

    return v0
.end method
