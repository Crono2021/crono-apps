.class public Lorg/drinkless/tdlib/TdApi$LoadChats;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoadChats"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x70648285


# instance fields
.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28105
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatList;I)V
    .locals 0
    .param p1, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;
    .param p2, "i9"    # I

    .line 28094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28095
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LoadChats;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 28096
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$LoadChats;->limit:I

    .line 28097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28101
    const v0, -0x70648285

    return v0
.end method
