.class public Lorg/drinkless/tdlib/TdApi$GetChats;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChats"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chats;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x39fb453e


# instance fields
.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25965
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatList;I)V
    .locals 0
    .param p1, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;
    .param p2, "i9"    # I

    .line 25954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25955
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetChats;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 25956
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetChats;->limit:I

    .line 25957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25961
    const v0, -0x39fb453e

    return v0
.end method
