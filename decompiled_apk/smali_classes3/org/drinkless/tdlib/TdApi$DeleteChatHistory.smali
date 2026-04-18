.class public Lorg/drinkless/tdlib/TdApi$DeleteChatHistory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteChatHistory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x57be2f61


# instance fields
.field public chatId:J

.field public removeFromChatList:Z

.field public revoke:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36586
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36587
    return-void
.end method

.method public constructor <init>(JZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 36575
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36576
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatHistory;->chatId:J

    .line 36577
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatHistory;->removeFromChatList:Z

    .line 36578
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$DeleteChatHistory;->revoke:Z

    .line 36579
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36583
    const v0, -0x57be2f61

    return v0
.end method
