.class public Lorg/drinkless/tdlib/TdApi$GetChatAvailableMessageSenders;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatAvailableMessageSenders"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatMessageSenders;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x450fe92b


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12282
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12283
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12273
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12274
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatAvailableMessageSenders;->chatId:J

    .line 12275
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12279
    const v0, 0x450fe92b

    return v0
.end method
